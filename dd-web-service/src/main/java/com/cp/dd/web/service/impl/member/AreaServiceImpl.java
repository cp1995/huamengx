package com.cp.dd.web.service.impl.member;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.constant.CommonConstant;
import com.cp.dd.common.entity.member.Area;
import com.cp.dd.common.entity.member.Member;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.member.AreaMapper;
import com.cp.dd.common.mapper.member.MemberMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.web.service.member.IAreaService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
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
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService {

    private  MemberMapper memberMapper;

    @Override
    public List<Area> findList() {
        List<Area> list= null;
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role == CommonConstant.Role.SUPER){
            list = baseMapper.selectList(Wrappers.<Area>lambdaQuery()
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .orderByDesc(Area::getCreateTime));
        }else{
            list = baseMapper.selectList(Wrappers.<Area>lambdaQuery()
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .eq(Area::getId,session.getAreaId())
                    .orderByDesc(Area::getCreateTime));
        }
        return list;
    }

    @Override
    public void  delete(Long id) {
        Area area = baseMapper.selectById(id);
        List<Member> list = memberMapper.selectList(Wrappers.<Member>lambdaQuery().eq(Member::getAreaId,area.getId())
                                                                            .eq(Member::getState,CommonConstant.State.ENABLE));
        if(list.size()>0){
            throw new ApiException("该园区下有数据,不能删除");
        }
        area.setState(CommonConstant.State.DELETE);
        baseMapper.updateById(area);
    }

    @Override
    public void save(String name) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role != CommonConstant.Role.SUPER){
            throw new ApiException("暂无权限");
        }
        Area area = new Area();
        area.setName(name);
        area.setState(CommonConstant.State.ENABLE);
        this.baseMapper.insert(area);
    }

    @Override
    public IPage getPage(PageQuery pageQuery, String name) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        LambdaQueryWrapper<Area> wrapper;
        if(role == CommonConstant.Role.SUPER){
            wrapper = Wrappers.<Area>lambdaQuery().like(StringUtils.isNotBlank(name), Area::getName, name)
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .orderByAsc(Area::getCreateTime);
        }else{
            wrapper = Wrappers.<Area>lambdaQuery().like(StringUtils.isNotBlank(name), Area::getName, name)
                    .eq(Area::getState,CommonConstant.State.ENABLE)
                    .eq(Area::getId,session.getAreaId())
                    .orderByAsc(Area::getCreateTime);
        }

        IPage<Area> page = baseMapper.selectPage(pageQuery.loadPage(), wrapper);
        return page;
    }
}
