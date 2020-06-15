package com.cp.dd.web.service.impl.sport;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.constant.CommonConstant;
import com.cp.dd.common.entity.sport.Avg;
import com.cp.dd.common.entity.sport.Item;
import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sport.AvgMapper;
import com.cp.dd.common.mapper.sport.ItemMapper;
import com.cp.dd.common.mapper.sport.SportMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.ExcelUtil;
import com.cp.dd.common.util.calculation;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.common.vo.sport.ItemVO;
import com.cp.dd.web.form.member.sport.ItemForm;
import com.cp.dd.web.service.sport.IItemService;
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
import java.time.temporal.ChronoUnit;
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
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    private SportMapper sportMapper;

    private AvgMapper avgMapper;

    @Override
    public Item save(ItemForm itemForm) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role == CommonConstant.Role.SUPER){
            throw new ApiException("超级管理员不能录入");
        }
        Item item = new Item();
        BeanUtils.copyProperties(itemForm,item);
        LocalDate today = LocalDate.now();
        LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(itemForm.getBirth()));
       // long years = ChronoUnit.YEARS.between(playerDate, today);
        item.setBirthday(playerDate);
        item.setAge(geAge(itemForm.getBirth()));
        if(Double.valueOf(item.getAge()) <3 || Double.valueOf(item.getAge()) >6){
            throw new ApiException("测试年龄不符合");
        }
        //身高预测
        item.setResultHeight(calculation.calResultHeight(itemForm.getFHeight(),itemForm.getMHeight(),itemForm.getSex()));
        //身高得分
        item.setHeightScore(calculation.calHeight(item.getAge(),itemForm.getHeight(),itemForm.getSex()));
        item.setIbm(calculation.getBMI(itemForm.getHeight(),itemForm.getWeight()));
        //BMI得分
        item.setIbmScore(calculation.calBmi(item.getAge(),itemForm.getHeight(),itemForm.getWeight(),itemForm.getSex()));
        //下肢得分
        item.setLegsScore(calculation.calLeg(item.getAge(),itemForm.getLegs(),itemForm.getSex()));
        //上肢得分
        item.setLimbScore(calculation.calLimb(item.getAge(),itemForm.getSzLimb(),itemForm.getSex()));
        //协调性成绩
        item.setCoordinateScore(calculation.calCoordinate(item.getAge(),itemForm.getCoordinate(),itemForm.getSex()));
        //平衡性成绩
        item.setBalanceScore(calculation.calBalance(item.getAge(),itemForm.getBalance(),itemForm.getSex()));
        //柔韧性成绩
        item.setFlexibilityScore(calculation.calFlexibility(item.getAge(),itemForm.getFlexibility(),itemForm.getSex()));
        //灵敏性成绩
        item.setSensitiveScore(calculation.calSensitives(item.getAge(),itemForm.getSensitives(),itemForm.getSex()));
        //拍球
        item.setRacketScore(calculation.calRacket(item.getAge(),itemForm.getRacket()));
        //传球
        item.setPassScore(calculation.calPass(item.getAge(),itemForm.getPass()));
        //投篮成绩
        item.setShootScore(calculation.calShoot(item.getAge(),itemForm.getShoot()));
        item.setCreateBy(session.getUsername());
        baseMapper.insert(item);
        return item;
    }

    public static String geAge(String birth){
        LocalDate today = LocalDate.now();
        LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(birth));
        long years = ChronoUnit.YEARS.between(playerDate, today);
        long month = ChronoUnit.MONTHS.between(playerDate, today);
        String age = String.valueOf(years);
        if(month - years*12 >= 6 ){
            if(years <= 1){
                age = "0.5";
            }else{
                age = age + ".5";
            }
        }
        return  age;
    }

    @Override
    public IPage getPage(PageQuery pageQuery, String childName, String phone, String name,String createBy,String parentName, Long areaId) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role != CommonConstant.Role.SUPER){
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
       List<ItemVO> list = baseMapper.getDataList(childName,phone,name,createBy,areaId,orderBy);
        String[] titles = new String[]{"姓名", "BMI", "下肢力量", "上肢力量","协调性","平衡性","柔韧性","灵敏性","拍球","传球","投篮"};
        String[] fields = {"name", "ibm", "legs", "szLimb","coordinate","balance","flexibility","sensitives","racket","pass","shoot"};
        // 转化器
        Map<String, ExcelUtil.Converter> converters = new HashMap<>(16);
     //   converters.put("createTime", (ExcelUtil.Converter<LocalDateTime>) createTime -> createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
      //  converters.put("resultCode", (ExcelUtil.Converter<Integer>) signStatus -> signStatus == 0 ? "成功" : "失败");
       // converters.put("times", (ExcelUtil.Converter<Long>) times -> times /1000 +"秒");
        ExcelUtil.exportExcel( "数据报表内容.xlsx", titles, fields, list, response, converters);
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
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            int index =0;
            Item item = new Item();
            item.setSportId(sport.getId());
            item.setName(row.getCell(1).getStringCellValue());
            Cell cell2 =row.getCell(2);
            cell2.setCellType(CellType.STRING);
            item.setSex(Integer.valueOf(cell2.getStringCellValue()));
            LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(row.getCell(3).getStringCellValue()));
            // long years = ChronoUnit.YEARS.between(playerDate, today);
            item.setBirthday(playerDate);
            item.setAge(geAge(row.getCell(3).getStringCellValue()));
            if(Double.valueOf(item.getAge()) <3 || Double.valueOf(item.getAge()) >6){
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
            item.setResultHeight(calculation.calResultHeight(item.getFHeight(),item.getMHeight(),item.getSex()));
            //身高得分
            item.setHeightScore(calculation.calHeight(item.getAge(),item.getHeight(),item.getSex()));
            item.setIbm(calculation.getBMI(item.getHeight(),item.getWeight()));
            //BMI得分
            item.setIbmScore(calculation.calBmi(item.getAge(),item.getHeight(),item.getWeight(),item.getSex()));
            //下肢得分
            Cell cell11 =row.getCell(11);
            cell11.setCellType(CellType.STRING);
            item.setLegs(Integer.valueOf(row.getCell(11).getStringCellValue()));
            item.setLegsScore(calculation.calLeg(item.getAge(),item.getLegs(),item.getSex()));
            //上肢得分
            Cell cell12 =row.getCell(12);
            cell12.setCellType(CellType.STRING);
            item.setSzLimb(Double.valueOf(row.getCell(12).getStringCellValue()));
            item.setLimbScore(calculation.calLimb(item.getAge(),item.getSzLimb(),item.getSex()));
            //协调性成绩
            Cell cell13 =row.getCell(13);
            cell13.setCellType(CellType.STRING);
            item.setCoordinate(Double.valueOf(row.getCell(13).getStringCellValue()));
            item.setCoordinateScore(calculation.calCoordinate(item.getAge(),item.getCoordinate(),item.getSex()));
            //平衡性成绩
            Cell cell14 =row.getCell(14);
            cell14.setCellType(CellType.STRING);
            item.setBalance(Double.valueOf(row.getCell(14).getStringCellValue()));
            item.setBalanceScore(calculation.calBalance(item.getAge(),item.getBalance(),item.getSex()));
            //柔韧性成绩
            Cell cell15 =row.getCell(15);
            cell15.setCellType(CellType.STRING);
            item.setFlexibility(Double.valueOf(row.getCell(15).getStringCellValue()));
            item.setFlexibilityScore(calculation.calFlexibility(item.getAge(),item.getFlexibility(),item.getSex()));
            //灵敏性成绩
            Cell cell16 =row.getCell(16);
            cell16.setCellType(CellType.STRING);
            item.setSensitives(Double.valueOf(row.getCell(16).getStringCellValue()));
            item.setSensitiveScore(calculation.calSensitives(item.getAge(),item.getSensitives(),item.getSex()));
            //拍球
            Cell cell17 =row.getCell(17);
            cell17.setCellType(CellType.STRING);
            item.setRacket(Integer.valueOf(row.getCell(17).getStringCellValue()));
            item.setRacketScore(calculation.calRacket(item.getAge(),item.getRacket()));
            //传球
            Cell cell18 =row.getCell(18);
            cell18.setCellType(CellType.STRING);
            item.setPass(Integer.valueOf(row.getCell(18).getStringCellValue()));
            item.setPassScore(calculation.calPass(item.getAge(),item.getPass()));
            //投篮成绩
            Cell cell19 =row.getCell(19);
            cell19.setCellType(CellType.STRING);
            item.setShoot(Integer.valueOf(row.getCell(19).getStringCellValue()));
            item.setShootScore(calculation.calShoot(item.getAge(),item.getShoot()));
            item.setCreateBy(session.getUsername());
            baseMapper.insert(item);
      /*      act.setName(row.getCell(0).getStringCellValue());
            act.setCategory(getCategoryId(row.getCell(1).getStringCellValue(),categoryMap));
            act.setBeginTime(row.getCell(2).getLocalDateTimeCellValue());
            act.setEndTime(row.getCell(3).getLocalDateTimeCellValue());
            act.setPeopleNum((long) row.getCell(4).getNumericCellValue());
            act.setAddress(row.getCell(5).getStringCellValue());
            act.setCreateDeptId(sysUserVO.getDeptId());
            save(act);*/
        }
    }

    @Override
    public List<ItemVO> getData(String childName, String phone, Long sportId) {
    /*    List<ItemVO> list = baseMapper.getData(childName,phone,sportId);
        ItemVO vo =new ItemVO();
        if(list.size()>0){
            vo  = list.get(0);
            Avg avg =avgMapper.selectOne(Wrappers.<Avg>lambdaQuery().eq(Avg::getSex,vo.getSex())
                                                           .eq(Avg::getAge,vo.getAge()));
            if(avg != null){
               vo.setHightAvg(avg.getHightAvg());
               vo.setLegsAvg(avg.getLegsAvg());
               vo.setCoordinateAvg(avg.getCoordinateAvg());
               vo.setBalanceAvg(avg.getBalanceAvg());
               vo.setFlexibilityAvg(avg.getFlexibilityAvg());
               vo.setSensitiveAvg(avg.getSensitiveAvg());
               vo.setLimbAvg(avg.getLimbAvg());
               vo.setRacketAvg(avg.getRacketAvg());
               vo.setPassAvg(avg.getPassAvg());
               vo.setShootAvg(avg.getShootAvg());
            }
        }*/
        return baseMapper.getData(childName,phone,sportId);
    }

    @Override
    public ItemVO detail(Long id) {
        ItemVO vo =baseMapper.detail(id);
        Avg avg =avgMapper.selectOne(Wrappers.<Avg>lambdaQuery().eq(Avg::getSex,vo.getSex())
                .eq(Avg::getAge,vo.getAge()));
        if(avg != null){
            vo.setHightAvg(avg.getHightAvg());
            vo.setLegsAvg(avg.getLegsAvg());
            vo.setCoordinateAvg(avg.getCoordinateAvg());
            vo.setBalanceAvg(avg.getBalanceAvg());
            vo.setFlexibilityAvg(avg.getFlexibilityAvg());
            vo.setSensitiveAvg(avg.getSensitiveAvg());
            vo.setLimbAvg(avg.getLimbAvg());
            vo.setRacketAvg(avg.getRacketAvg());
            vo.setPassAvg(avg.getPassAvg());
            vo.setShootAvg(avg.getShootAvg());
            vo.setBmiAvg(avg.getBmiAvg());
        }
        return vo;
    }

}
