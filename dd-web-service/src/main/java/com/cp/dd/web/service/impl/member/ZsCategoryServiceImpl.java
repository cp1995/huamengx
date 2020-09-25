package com.cp.dd.web.service.impl.member;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.constant.Constants;
import com.cp.dd.common.entity.member.ZsCategory;
import com.cp.dd.common.entity.zs.ZsPersonal;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.member.ZsCategoryMapper;
import com.cp.dd.common.mapper.zs.ZsPersonalMapper;
import com.cp.dd.common.vo.zs.ZsCategoryVO;
import com.cp.dd.web.form.member.ZsCategoryForm;
import com.cp.dd.web.service.member.IZsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-07-23
 */
@AllArgsConstructor
@Service
public class ZsCategoryServiceImpl extends ServiceImpl<ZsCategoryMapper, ZsCategory> implements IZsCategoryService {

    private ZsPersonalMapper zsPersonalMapper;

    @Override
    public void save(ZsCategoryForm zsCategoryForm) {
        ZsCategory zsCategory = new ZsCategory();
        checkName(zsCategoryForm.getName());
        BeanUtils.copyProperties(zsCategoryForm, zsCategory);
        this.baseMapper.insert(zsCategory);

    }

    @Override
    public void update(ZsCategoryForm zsCategoryForm) {
        ZsCategory zsCategory = this.baseMapper.selectById(zsCategoryForm.getId());
        if(zsCategory == null){
            throw new ApiException("该分类不存在");
        }
        if(!zsCategory.getName().equals(zsCategoryForm.getName())){
            this.checkName(zsCategoryForm.getName());
        }
        BeanUtils.copyProperties(zsCategoryForm, zsCategory);
        this.baseMapper.updateById(zsCategory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void del(List<Long> ids) {
        ids.forEach(this::delete);
    }

    @Override
    public ZsCategoryVO getId(Long id) {
        Integer ids = Integer.valueOf(String.valueOf(id));
        ZsCategoryVO vo = new ZsCategoryVO();
        String code =code() + "000";
        List<ZsPersonal> list = zsPersonalMapper.selectList(Wrappers.<ZsPersonal>lambdaQuery()
                .eq(ZsPersonal::getCategoryId,id)
                .orderByDesc(ZsPersonal::getId)
        );
        String listCode;
        if(list.size()>0){
            code = code + String.valueOf(list.get(0).getId());
            listCode = String.valueOf(list.get(0).getId());
        }else {
            code = code + "1";
            listCode = "1";
        }
        switch(ids){
            case 5 :
                vo.setName("俱乐部星教练（WEAC-A）");
                vo.setCode("WA"+code);
                break;
            case 6 :
                vo.setName("星伙伴教练员（WEAC-B）");
                vo.setCode("WB"+code);
                break;
            case 7 :
                vo.setName("星宝贝督导师（WEAC-S）");
                vo.setCode("WS"+code);
                break;
            case 8 :
                vo.setName("星宝贝教师证（WEAC-T）");
                vo.setCode("WT"+code);
                break;
            case 9 :
                vo.setName("幼儿篮球裁判员");
                vo.setCode("WR"+code);
                break;
            case 14 :
                vo.setName("幼儿篮球教师资格证书");
                vo.setCode("WT"+code);
                break;
            case 15 :
                vo.setName("俱乐部初级校长");
                vo.setCode("WCP"+code);
                break;
            case 17 :
                vo.setName("俱俱乐部初级课程顾问");
                vo.setCode("WCC"+code);
                break;
            case 18 :
                vo.setName("俱乐部初级教练员");
                vo.setCode("WCT"+code);
                break;
            case 19 :
                vo.setName("俱乐部教练AC认证培训");
                vo.setCode("WAC"+code);
                break;
            case 20 :
                vo.setName("华蒙星幼儿篮球公益培训");
                vo.setCode("WPG"+code);
                break;
            case 21 :
                vo.setName("星伙伴合作基地");
                vo.setCode("WX"+listCode);
                break;
            case 22 :
                vo.setName("小小CBA少儿篮球示范基地");
                vo.setCode("C810X"+code);
                break;
            case 23 :
                vo.setName("小小CBA少儿篮球示范园");
                vo.setCode("K600X"+code);
                break;
            case 24 :
                vo.setName("俱乐部教练BC认证培训");
                vo.setCode("WBC"+code);
                break;


        }

        return vo;
    }


    public void checkName(String name){
        ZsCategory entity = this.baseMapper.selectOne(Wrappers.<ZsCategory>lambdaQuery()
                .eq(ZsCategory::getName,name)
                .ne(ZsCategory::getStatus, Constants.Status.delete));
        if(entity != null){
            throw new ApiException("该分类名称已存在");
        }
    }

    public void delete(Long actId) {
        ZsCategory entity = baseMapper.selectById(actId);
        if (Objects.isNull(entity)) {
            throw new ApiException(-1, "该分类不存在");
        }
        // 修改状态，逻辑删除
        entity.setStatus(Constants.Status.delete);
        this.updateById(entity);
    }

    public static  String  code(){
        String code;
        //获取当前时间
        LocalDateTime currentDate = LocalDateTime.now();
        //获取年份
        int year = currentDate.getYear();
        code = year+"";
        //获取月份
        int month = currentDate.getMonthValue();
        if(month < 10){
            code = code + "0" + month+"";
        }else {
            code = code + month+"";
        }
        return  code;
    }



}
