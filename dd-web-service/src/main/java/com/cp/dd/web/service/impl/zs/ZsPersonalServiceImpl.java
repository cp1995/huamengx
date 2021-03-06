package com.cp.dd.web.service.impl.zs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.sys.SysArea;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sys.SysAreaMapper;
import com.cp.dd.common.mapper.zs.ZsPersonalMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.IdCardUtil;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.common.vo.zs.ZsPersonalVO;
import com.cp.dd.web.form.zs.ZsPersonalForm;
import com.cp.dd.web.service.zs.IZsPersonalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
@AllArgsConstructor
@Service
public class ZsPersonalServiceImpl extends ServiceImpl<ZsPersonalMapper, ZsPersonal> implements IZsPersonalService {

    private SysAreaMapper sysAreaMapper;

    @Override
    public void save(ZsPersonalForm zsPersonalForm) {
        if(StringUtils.isBlank(zsPersonalForm.getIdCard())){
            throw new ApiException("请输入身份证号码");
        }
        if(!IdCardUtil.validateCard(zsPersonalForm.getIdCard())){
            throw new ApiException("请输入正确身份证号码");
        }
        ZsPersonal zsTeachers = new ZsPersonal();
        ZsPersonal zsTeachers1 = this.baseMapper.selectOne(Wrappers.<ZsPersonal>lambdaQuery()
                .eq(ZsPersonal::getIdCard,zsPersonalForm.getIdCard())
                .eq(ZsPersonal::getCategoryId,zsPersonalForm.getCategoryId())
        );
        if(zsTeachers1 != null){
            throw new ApiException("已申请此分类证书");
        }
        if(StringUtils.isNoneBlank(zsPersonalForm.getAreaCode())){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,zsPersonalForm.getAreaCode()));
            zsTeachers.setShortCode(sysArea.getShortCode());
        }
        zsTeachers.setStatus(1);
        BeanUtils.copyProperties(zsPersonalForm,zsTeachers);
        this.baseMapper.insert(zsTeachers);
    }

    @Override
    public void wechatSave(ZsPersonalForm zsPersonalForm) {
        if(StringUtils.isBlank(zsPersonalForm.getIdCard())){
            throw new ApiException("请输入身份证号码");
        }
        if(!IdCardUtil.validateCard(zsPersonalForm.getIdCard())){
            throw new ApiException("请输入正确身份证号码");
        }
        ZsPersonal zsTeachers = new ZsPersonal();
        ZsPersonal zsTeachers1 = this.baseMapper.selectOne(Wrappers.<ZsPersonal>lambdaQuery()
                .eq(ZsPersonal::getIdCard,zsPersonalForm.getIdCard())
                .eq(ZsPersonal::getCategoryId,zsPersonalForm.getCategoryId())
        );
        if(zsTeachers1 != null){
            throw new ApiException("已申请此分类证书");
        }
        if(StringUtils.isNoneBlank(zsPersonalForm.getAreaCode())){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,zsPersonalForm.getAreaCode()));
            zsTeachers.setShortCode(sysArea.getShortCode());
        }
        zsTeachers.setStatus(0);
        BeanUtils.copyProperties(zsPersonalForm,zsTeachers);
        this.baseMapper.insert(zsTeachers);
    }

    @Override
    public void wechatUpdate(ZsPersonalForm zsPersonalForm) {
        ZsPersonal zsTeachers = this.baseMapper.selectById(zsPersonalForm.getId());
        BeanUtils.copyProperties(zsPersonalForm,zsTeachers);
        if(StringUtils.isNoneBlank(zsPersonalForm.getAreaCode())){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,zsPersonalForm.getAreaCode()));
            zsTeachers.setShortCode(sysArea.getShortCode());
        }
        this.baseMapper.updateById(zsTeachers);
    }

    @Override
    public IPage<ZsPersonalVO> getPage(PageQuery query, String name, Integer status,Long categoryId,String areaCode) {
        String shortCode = null;
        if(StringUtils.isNotBlank(areaCode)){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,areaCode));
            shortCode = sysArea.getShortCode();
        }
        return this.baseMapper.getPage(query.loadPage(),name,status,categoryId,shortCode);
    }

    @Override
    public void update(ZsPersonalForm zsPersonalForm) {
        ZsPersonal zsTeachers = this.baseMapper.selectById(zsPersonalForm.getId());
        BeanUtils.copyProperties(zsPersonalForm,zsTeachers);
        if(StringUtils.isNoneBlank(zsPersonalForm.getAreaCode())){
            SysArea sysArea = sysAreaMapper.selectOne(Wrappers.<SysArea>lambdaQuery()
                    .eq(SysArea::getCode,zsPersonalForm.getAreaCode()));
            zsTeachers.setShortCode(sysArea.getShortCode());
        }
        this.baseMapper.updateById(zsTeachers);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void del(List<Long> ids) {
        MemberVO memberVO  = SessionCache.get();
        if(memberVO.getRole() != 1){
            throw new ApiException("暂无权限删除");
        }
        ids.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void audit(List<Long> ids, Integer auditStatus) {
        ids.forEach(id->{
            this.audit(id,auditStatus);
        });
    }

    @Override
    public ZsPersonalVO detail(Long id) {
        return this.baseMapper.detail(id);
    }

    @Override
    public List<ZsPersonalVO> getName(String name) {
        return this.baseMapper.getName(name);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        ZsPersonal entity = baseMapper.selectById(id);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该证书不存在");
        }
        // 修改状态，逻辑删除
       /* entity.setStatus(Constants.Status.delete);
        this.updateById(entity);*/
        this.baseMapper.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void audit(Long id,Integer auditStatus) {
        ZsPersonal entity = baseMapper.selectById(id);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该证书不存在");
        }
        // 修改状态，逻辑删除
        entity.setStatus(auditStatus);
        entity.setStartTime(LocalDate.now());
        entity.setEndTime(LocalDate.now().plus(2, ChronoUnit.YEARS));
        baseMapper.updateById(entity);
        this.updateById(entity);
    }


}
