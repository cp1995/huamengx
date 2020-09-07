package com.cp.dd.web.service.impl.sport;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.constant.CommonConstant;
import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.entity.sport.XxAvg;
import com.cp.dd.common.entity.sport.XxItem;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sport.SportMapper;
import com.cp.dd.common.mapper.sport.XxAvgMapper;
import com.cp.dd.common.mapper.sport.XxItemMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.ExcelUtil;
import com.cp.dd.common.util.XxCalculation;
import com.cp.dd.common.util.calculation;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.common.vo.sport.XxItemCountVO;
import com.cp.dd.common.vo.sport.XxItemVO;
import com.cp.dd.web.form.sport.XxItemForm;
import com.cp.dd.web.form.sport.XxItemUpdateForm;
import com.cp.dd.web.service.sport.IXxItemService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
public class XxItemServiceImpl extends ServiceImpl<XxItemMapper, XxItem> implements IXxItemService {

    private SportMapper sportMapper;

    private XxAvgMapper xxAvgMapper;

    @Override
    public XxItem save(XxItemForm itemForm) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role == CommonConstant.Role.SUPER){
            throw new ApiException("超级管理员不能录入");
        }
        XxItem item1 = baseMapper.selectOne(Wrappers.<XxItem>lambdaQuery().eq(XxItem::getSportId,itemForm.getSportId())
                .eq(XxItem::getState,CommonConstant.State.ENABLE)
                .eq(XxItem::getName,itemForm.getName()));
        if(item1 != null){
            throw new ApiException("已存在该小孩信息,不能进行重复录入!");
        }
        XxItem item = new XxItem();
        BeanUtils.copyProperties(itemForm,item);
        LocalDate today = LocalDate.now();
        LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(itemForm.getBirth()));
       // long years = ChronoUnit.YEARS.between(playerDate, today);
        item.setBirthday(playerDate);
        item.setAge(XxCalculation.getXxAge(itemForm.getBirth()));
        if(Double.valueOf(item.getAge()) <7 || Double.valueOf(item.getAge()) >10){
            throw new ApiException("测试年龄不符合");
        }
        //身高预测
        item.setResultHeight(XxCalculation.calResultHeight(itemForm.getFHeight(),itemForm.getMHeight(),itemForm.getSex()));
        //身高得分
        item.setHeightScore(XxCalculation.calHeight(item.getAge(),itemForm.getHeight(),itemForm.getSex()));
        item.setIbm(XxCalculation.getBMI(itemForm.getHeight(),itemForm.getWeight()));
        //BMI得分
        item.setIbmScore(XxCalculation.calBmi(item.getAge(),itemForm.getHeight(),itemForm.getWeight(),itemForm.getSex()));
        //肺活量得分
        item.setFeiHlScore(XxCalculation.calFhl(item.getAge(),itemForm.getFeiHl(),itemForm.getSex()));
        //跳绳得分
        item.setTiaosScore(XxCalculation.calTs(item.getAge(),itemForm.getTiaos(),itemForm.getSex()));
        //柔韧性成绩
        item.setFlexibilityScore(XxCalculation.calFlexibility(item.getAge(),itemForm.getFlexibility(),itemForm.getSex()));
        //灵敏性成绩
        item.setSensitiveScore(XxCalculation.calSensitives(item.getAge(),itemForm.getSensitives(),itemForm.getSex()));
        //移动得分
        item.setRemoveScore(XxCalculation.calYd(item.getAge(),itemForm.getRemove(),itemForm.getSex()));
        //传球
        item.setPassScore(XxCalculation.calPass(item.getAge(),itemForm.getPass(),itemForm.getSex()));
        //投篮成绩
        item.setShootScore(XxCalculation.calShoot(item.getAge(),itemForm.getShoot(),itemForm.getSex()));
        item.setCreateBy(session.getUsername());
        baseMapper.insert(item);
        return item;
    }

    @Override
    public XxItem update(XxItemUpdateForm itemForm) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role == CommonConstant.Role.SUPER){
            throw new ApiException("超级管理员不能修改数据");
        }
        XxItem item = baseMapper.selectById(itemForm.getId());
        if(item == null){
            throw new ApiException("该数据不存在!");
        }
        item.setName(itemForm.getName());
        LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(itemForm.getBirth()));
        item.setBirthday(playerDate);
        item.setAge(XxCalculation.getXxAge(itemForm.getBirth()));
        if(Double.valueOf(item.getAge()) <7 || Double.valueOf(item.getAge()) >10){
            throw new ApiException("测试年龄不符合");
        }
        item.setCreateTime(LocalDateTime.now());
        item.setFHeight(itemForm.getFHeight());
        item.setMHeight(itemForm.getMHeight());
        //身高预测
        item.setResultHeight(XxCalculation.calResultHeight(itemForm.getFHeight(),itemForm.getMHeight(),item.getSex()));
        //身高得分
        item.setHeight(itemForm.getHeight());
        item.setHeightScore(XxCalculation.calHeight(item.getAge(),itemForm.getHeight(),item.getSex()));
        item.setIbm(XxCalculation.getBMI(itemForm.getHeight(),itemForm.getWeight()));
        //BMI得分
        item.setIbmScore(XxCalculation.calBmi(item.getAge(),itemForm.getHeight(),itemForm.getWeight(),item.getSex()));
        //肺活量得分
        item.setFeiHl(itemForm.getFeiHl());
        item.setFeiHlScore(XxCalculation.calFhl(item.getAge(),itemForm.getFeiHl(),item.getSex()));
        //跳绳得分
        item.setTiaos(itemForm.getTiaos());
        item.setTiaosScore(XxCalculation.calTs(item.getAge(),itemForm.getTiaos(),item.getSex()));
        //柔韧性成绩
        item.setFlexibility(itemForm.getFlexibility());
        item.setFlexibilityScore(XxCalculation.calFlexibility(item.getAge(),itemForm.getFlexibility(),item.getSex()));
        //灵敏性成绩
        item.setSensitives(itemForm.getSensitives());
        item.setSensitiveScore(XxCalculation.calSensitives(item.getAge(),itemForm.getSensitives(),item.getSex()));
        //移动
        item.setRemove(itemForm.getRemove());
        item.setRemoveScore(XxCalculation.calYd(item.getAge(),itemForm.getRemove(),item.getSex()));
        //接球
        item.setPass(itemForm.getPass());
        item.setPassScore(XxCalculation.calPass(item.getAge(),itemForm.getPass(),item.getSex()));
        //投篮成绩
        item.setShoot(itemForm.getShoot());
        item.setShootScore(XxCalculation.calShoot(item.getAge(),itemForm.getShoot(),item.getSex()));
        item.setCreateBy(session.getUsername());
        baseMapper.updateById(item);
        return item;
    }




    @Override
    public IPage getPage(PageQuery pageQuery, String childName, String phone, String name,String createBy,String parentName, Long areaId) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role != CommonConstant.Role.SUPER || role != 6){
            areaId = session.getAreaId();
        }
        return baseMapper.getPage(pageQuery.loadPage(),childName,phone,name,createBy,parentName,areaId);
    }

    @Override
    public IPage getDataPage(PageQuery pageQuery, String childName, String phone, String name, String createBy, Long areaId,Integer sort,String ascOrDesc) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        String orderBy = null;
        if(sort == null){
            orderBy = " i.create_time DESC ";
        }else{
            switch (sort){
                case 1:
                    orderBy = " i.height_score " ; //身高得分
                    break;
                case 2:
                    orderBy = " i.ibm_score "; //ibm
                    break;
                case 3:
                    orderBy = " i.legs_score "; //下肢
                    break;
                case 4:
                    orderBy = " i.limb_score " ; //上肢
                    break;
                case 5:
                    orderBy = " i.coordinate_score "; //协调性
                    break;
                case 6:
                    orderBy = " i.balance_score "; //平衡性
                    break;
                case 7:
                    orderBy = " i.flexibility_score "; //柔韧性
                    break;
                case 8:
                    orderBy = " i.sensitive_score "; //灵敏性
                    break;
                case 9:
                    orderBy = " i.racket_score " ; //拍球
                    break;
                case 10:
                    orderBy = " i.pass_score "; //传球
                    break;
                case 11:
                    orderBy = " i.shoot_score "; //上篮
                    break;
            }
            if(StringUtils.isBlank(ascOrDesc)){
                ascOrDesc = " desc ";
            }
            orderBy = orderBy + "  "+ascOrDesc;
        }
        if(role != CommonConstant.Role.SUPER){
            areaId = session.getAreaId();
        }
        return baseMapper.getDataPage(pageQuery.loadPage(),childName,phone,name,createBy,areaId,orderBy);
    }

    @Override
    public void export(HttpServletResponse response, HttpServletRequest request, String childName, String phone, String name, String createBy, Long areaId, Integer sort, String ascOrDesc) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        String orderBy = null;
        if(sort == null){
            orderBy = " i.create_time DESC ";
        }else{
            switch (sort){
                case 1:
                    orderBy = " i.height_score " ; //身高得分
                    break;
                case 2:
                    orderBy = " i.ibm_score "; //bmi
                    break;
                case 3:
                    orderBy = " i.legs_score "; //下肢
                    break;
                case 4:
                    orderBy = " i.limb_score " ; //上肢
                    break;
                case 5:
                    orderBy = " i.coordinate_score "; //协调性
                    break;
                case 6:
                    orderBy = " i.balance_score "; //平衡性
                    break;
                case 7:
                    orderBy = " i.flexibility_score "; //柔韧性
                    break;
                case 8:
                    orderBy = " i.sensitive_score "; //灵敏性
                    break;
                case 9:
                    orderBy = " i.racket_score " ; //拍球
                    break;
                case 10:
                    orderBy = " i.pass_score "; //传球
                    break;
                case 11:
                    orderBy = " i.shoot_score "; //上篮
                    break;
            }
            if(StringUtils.isBlank(ascOrDesc)){
                ascOrDesc = " desc ";
            }
            orderBy = orderBy + "  "+ascOrDesc;
        }
        if(role != CommonConstant.Role.SUPER){
            areaId = session.getAreaId();
        }
       List<XxItemVO> list = baseMapper.getDataList(childName,phone,name,createBy,areaId,orderBy);
        String[] titles = new String[]{"姓名","场次名","年龄","总分","学员类型","身高","预测身高", "BMI", "肺活量", "10×4折返跑","柔韧性","一分钟跳绳","移动技术","接球","投篮"};
        String[] fields = {"name","sportName","age","total","xyType","height","resultHeight","ibm", "feiHl", "sensitives","flexibility","tiaos","remove","pass","shoot"};
        // 转化器
        Map<String, ExcelUtil.Converter> converters = new HashMap<>(16);
     //   converters.put("createTime", (ExcelUtil.Converter<LocalDateTime>) createTime -> createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      //  converters.put("resultCode", (ExcelUtil.Converter<Integer>) signStatus -> signStatus == 0 ? "成功" : "失败");
       // converters.put("times", (ExcelUtil.Converter<Long>) times -> times /1000 +"秒");
        ExcelUtil.exportExcel( "小学数据报表内容.xlsx", titles, fields, list, response, converters);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importItem(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ApiException("文件上传失败");
        }
        // 获取 Excel 工作簿
        Workbook workbook = ExcelUtil.getWorkbookFromFile(file);
        Sheet sheet = workbook.getSheetAt(0);
        MemberVO session = SessionCache.get();
        if(session.getRole() == CommonConstant.Role.SUPER){
            throw new ApiException("超级管理员不能导入");
        }
        Sport sport = new Sport();
        if(sheet.getRow(1).getCell(0).getStringCellValue()!=null){
            sport.setName(sheet.getRow(1).getCell(0).getStringCellValue());
            sport.setAreaId(session.getAreaId());
            Sport vo = sportMapper.selectOne(Wrappers.<Sport>lambdaQuery().eq(Sport::getAreaId,sport.getAreaId()).
                                                                eq(Sport::getName,sport.getName()).
                                                                eq(Sport::getState,CommonConstant.State.ENABLE));
            if(vo !=null){
                BeanUtils.copyProperties(vo,sport);
            }else{
                LocalDate date = LocalDate.now();
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateStr = date.format(fmt);
                LocalDateTime startTime = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(dateStr+" "+"00:00:00"));
                LocalDateTime endTime = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(dateStr+" "+"23:59:59"));
                sport.setStartTime(startTime);
                sport.setEndTime(endTime);
                sport.setState(CommonConstant.State.ENABLE);
                sportMapper.insert(sport);
            }
        }
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            int index =0;
            XxItem item = new XxItem();
            item.setSportId(sport.getId());
            item.setName(row.getCell(1).getStringCellValue());
            Cell cell2 =row.getCell(2);
            cell2.setCellType(CellType.STRING);
            item.setSex(Integer.valueOf(cell2.getStringCellValue()));
            LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(row.getCell(3).getStringCellValue()));
            // long years = ChronoUnit.YEARS.between(playerDate, today);
            item.setBirthday(playerDate);
            item.setAge(XxCalculation.getXxAge(row.getCell(3).getStringCellValue()));
            if(Double.valueOf(item.getAge()) <7 || Double.valueOf(item.getAge()) >10){
                throw new ApiException("测试年龄不符合");
            }
            item.setParentName(row.getCell(4).getStringCellValue());
            Cell cell5 =row.getCell(5);
            cell5.setCellType(CellType.STRING);
            item.setPhone(row.getCell(5).getStringCellValue());
            item.setSchool(row.getCell(6).getStringCellValue());
            Cell cell7 =row.getCell(7);
            cell7.setCellType(CellType.STRING);
            item.setHeight(Double.valueOf(row.getCell(7).getStringCellValue()));
            Cell cell8 =row.getCell(8);
            cell8.setCellType(CellType.STRING);
            item.setWeight(Double.valueOf(row.getCell(8).getStringCellValue()));
            Cell cell9 =row.getCell(9);
            cell9.setCellType(CellType.STRING);
            item.setFHeight(Double.valueOf(row.getCell(9).getStringCellValue()));
            Cell cell10 =row.getCell(10);
            cell10.setCellType(CellType.STRING);
            item.setMHeight(Double.valueOf(row.getCell(10).getStringCellValue()));
            //身高预测
            item.setResultHeight(XxCalculation.calResultHeight(item.getFHeight(),item.getMHeight(),item.getSex()));
            //身高得分
            item.setHeightScore(XxCalculation.calHeight(item.getAge(),item.getHeight(),item.getSex()));
            item.setIbm(XxCalculation.getBMI(item.getHeight(),item.getWeight()));
            //BMI得分
            item.setIbmScore(XxCalculation.calBmi(item.getAge(),item.getHeight(),item.getWeight(),item.getSex()));
            //肺活量
            Cell cell11 =row.getCell(11);
            cell11.setCellType(CellType.STRING);
            item.setFeiHl(Integer.valueOf(row.getCell(11).getStringCellValue()));
            item.setFeiHlScore(XxCalculation.calFhl(item.getAge(),item.getFeiHl(),item.getSex()));
            //10×4折返跑 灵敏性成绩
            Cell cell16 =row.getCell(12);
            cell16.setCellType(CellType.STRING);
            item.setSensitives(Double.valueOf(row.getCell(12).getStringCellValue()));
            item.setSensitiveScore(XxCalculation.calSensitives(item.getAge(),item.getSensitives(),item.getSex()));
            //柔韧性成绩
            Cell cell15 =row.getCell(13);
            cell15.setCellType(CellType.STRING);
            item.setFlexibility(Double.valueOf(row.getCell(13).getStringCellValue()));
            item.setFlexibilityScore(XxCalculation.calFlexibility(item.getAge(),item.getFlexibility(),item.getSex()));
            //跳绳成绩
            Cell cell14 =row.getCell(14);
            cell14.setCellType(CellType.STRING);
            item.setTiaos(Integer.valueOf(row.getCell(14).getStringCellValue()));
            item.setTiaosScore(XxCalculation.calTs(item.getAge(),item.getTiaos(),item.getSex()));

            //拍球
            Cell cell17 =row.getCell(15);
            if (cell17 != null) {
                cell17.setCellType(CellType.STRING);
                item.setRemove(Integer.valueOf(row.getCell(15).getStringCellValue()));
                item.setRemoveScore(XxCalculation.calYd(item.getAge(),item.getRemove(),item.getSex()));
            }else{
                item.setRemove(0);
                item.setRemoveScore(0);
            }

            //接球
            Cell cell18 =row.getCell(16);
            if (cell18 != null) {
                cell18.setCellType(CellType.STRING);
                item.setPass(Integer.valueOf(row.getCell(16).getStringCellValue()));
                item.setPassScore(XxCalculation.calPass(item.getAge(),item.getPass(),item.getSex()));
            }else{
                item.setPass(0);
                item.setPassScore(0);
            }

            //投篮成绩
            Cell cell19 =row.getCell(17);
            if (cell19 != null) {
                cell19.setCellType(CellType.STRING);
                item.setShoot(Integer.valueOf(row.getCell(17).getStringCellValue()));
                item.setShootScore(XxCalculation.calShoot(item.getAge(),item.getShoot(),item.getSex()));
            }else{
                item.setShoot(0);
                item.setShootScore(0);
            }
            Cell cell20 =row.getCell(18);
            cell20.setCellType(CellType.STRING);
            item.setXyType((row.getCell(18).getStringCellValue()));
            item.setCreateBy(session.getUsername());
            XxItem item1 = baseMapper.selectOne(Wrappers.<XxItem>lambdaQuery().eq(XxItem::getSportId,sport.getId())
                                                             .eq(XxItem::getState,CommonConstant.State.ENABLE)
                                                             .eq(XxItem::getName,item.getName()));
            if(item1 != null){
                item.setId(item1.getId());
                baseMapper.updateById(item);
            }else{
                baseMapper.insert(item);
            }
        }
    }

    @Override
    public List<XxItemVO> getData(String childName, String phone, Long sportId) {

        return baseMapper.getData(childName,phone,sportId);
    }

    @Override
    public XxItemVO detail(Long id) {
        XxItemVO vo =baseMapper.detail(id);
        XxAvg xxAvg =xxAvgMapper.selectOne(Wrappers.<XxAvg>lambdaQuery().eq(XxAvg::getSex,vo.getSex())
                .eq(XxAvg::getAge,vo.getAge()));
        if(xxAvg != null){
            vo.setHightAvg(xxAvg.getHeightAvg());
            vo.setBmiAvg(xxAvg.getIbmAvg());
            vo.setFeiHlAvg(xxAvg.getFeiHlAvg());
            vo.setSensitiveAvg(xxAvg.getSensitiveAvg());
            vo.setFlexibilityAvg(xxAvg.getFlexibilityAvg());
            vo.setTiaosAvg(xxAvg.getTiaosAvg());
            vo.setRemoveAvg(xxAvg.getRemoveAvg());
            vo.setPassAvg(xxAvg.getPassAvg());
            vo.setShootAvg(xxAvg.getShootAvg());

        }
        return vo;
    }

    @Override
    public void del(Long id) {
        XxItem item = baseMapper.selectById(id);
        if(item == null){
            throw new ApiException("该报告不存在");
        }
        item.setState(CommonConstant.State.DELETE);
        baseMapper.updateById(item);
    }

    @Override
    public XxItemCountVO getItemCount(String start, String end) {
        return this.baseMapper.getItemCount(Integer.valueOf(start),Integer.valueOf(end));
    }


}
