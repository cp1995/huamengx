package com.cp.dd.web.service.impl.sport;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.constant.CommonConstant;
import com.cp.dd.common.entity.member.Area;
import com.cp.dd.common.entity.sport.Item;
import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sport.ItemMapper;
import com.cp.dd.common.mapper.sport.SportMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.web.form.member.sport.SportForm;
import com.cp.dd.web.service.sport.ISportService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * <p>
 * 会员信息 服务实现类
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
@AllArgsConstructor
@Service
public class SportServiceImpl extends ServiceImpl<SportMapper, Sport> implements ISportService {

    private ItemMapper itemMapper;

    @Override
    public void save(SportForm sportForm) {
        MemberVO session = SessionCache.get();
        if(session.getRole() != CommonConstant.Role.AREA){
            throw new ApiException("只有园长才能新建场次");
        }
        List<Sport> list =baseMapper.selectList(Wrappers.<Sport>lambdaQuery().eq(Sport::getState,CommonConstant.State.ENABLE)
                .eq(Sport::getName,sportForm.getName())
               );
        if(list.size()>0){
            throw new ApiException("该场次名称已存在");
        }
        Sport sport = new Sport();
        BeanUtils.copyProperties(sportForm,sport);
        MemberVO memberVO = SessionCache.get();
        LocalDateTime startDate = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(sportForm.getStartTimes()+" "+"00:00:00"));
        LocalDateTime endDate = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(sportForm.getEndTimes()+" "+"23:59:59"));
        sport.setStartTime(startDate);
        sport.setEndTime(endDate);
        sport.setAreaId(memberVO.getAreaId());
        sport.setState(CommonConstant.State.ENABLE);
        baseMapper.insert(sport);
    }

    @Override
    public void delete(Long id) {
        Sport sport = baseMapper.selectById(id);
        if(sport == null){
            throw new ApiException("该场次不存在");
        }
        List<Item> list = itemMapper.selectList(Wrappers.<Item>lambdaQuery().eq(Item::getSportId,id));
        if(list.size()>0){
            throw new ApiException("该场次下有数据,不能删除");
        }
        sport.setState(CommonConstant.State.DELETE);
        baseMapper.updateById(sport);
    }

    @Override
    public void saveIds(Long id,String ids) {
        Sport sport = baseMapper.selectById(id);
        if(sport == null){
            throw new ApiException("该场次不存在");
        }
        //sport.set
    }

    @Override
    public List<Sport> getList() {
        MemberVO memberVO = SessionCache.get();
      /*  if(memberVO.getRole()==CommonConstant.Role.SUPER){
            throw new ApiException("管理员不能录入数据");
        }*/
        LocalDateTime date = LocalDateTime.now();
        return baseMapper.selectList(Wrappers.<Sport>lambdaQuery().eq(Sport::getState,CommonConstant.State.ENABLE)
                                                                  .eq(Sport::getAreaId,memberVO.getAreaId())
                                                                  .le(Sport::getStartTime,date)
                                                                  .ge(Sport::getEndTime,date)
                                                                  .orderByDesc(Sport::getCreateTime));
    }

    @Override
    public List<Sport> getWechatList() {
        MemberVO memberVO = SessionCache.get();
      /*  if(memberVO.getRole()==CommonConstant.Role.SUPER){
            throw new ApiException("管理员不能录入数据");
        }*/
        return baseMapper.selectList(Wrappers.<Sport>lambdaQuery().eq(Sport::getState,CommonConstant.State.ENABLE)
                .eq(Sport::getAreaId,memberVO.getAreaId())
                .orderByDesc(Sport::getCreateTime));
    }

    @Override
    public IPage getPage(PageQuery pageQuery, String name) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        LambdaQueryWrapper<Sport> wrapper;
        if(role == CommonConstant.Role.SUPER){
            wrapper = Wrappers.<Sport>lambdaQuery().like(StringUtils.isNotBlank(name), Sport::getName, name)
                    .eq(Sport::getState,CommonConstant.State.ENABLE)
                    .orderByAsc(Sport::getCreateTime);
        }else{
            wrapper = Wrappers.<Sport>lambdaQuery().like(StringUtils.isNotBlank(name), Sport::getName, name)
                    .eq(Sport::getState,CommonConstant.State.ENABLE)
                    .eq(Sport::getAreaId,session.getAreaId())
                    .orderByAsc(Sport::getCreateTime);
        }

        IPage<Sport> page = baseMapper.selectPage(pageQuery.loadPage(), wrapper);
        return page;
    }


}
