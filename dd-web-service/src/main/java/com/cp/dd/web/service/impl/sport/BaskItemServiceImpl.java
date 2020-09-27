package com.cp.dd.web.service.impl.sport;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.constant.CommonConstant;
import com.cp.dd.common.entity.sport.Avg;
import com.cp.dd.common.entity.sport.BaskItem;
import com.cp.dd.common.entity.sport.Item;
import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.mapper.sport.AvgMapper;
import com.cp.dd.common.mapper.sport.BaskItemMapper;
import com.cp.dd.common.mapper.sport.SportMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.ExcelUtil;
import com.cp.dd.common.util.calculation;
import com.cp.dd.common.util.sys.Baskculation;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.common.vo.sport.*;
import com.cp.dd.web.form.sport.BaskItemForm;
import com.cp.dd.web.service.sport.IBaskItemService;
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
public class BaskItemServiceImpl extends ServiceImpl<BaskItemMapper, BaskItem> implements IBaskItemService {

    private SportMapper sportMapper;
    private AvgMapper avgMapper;


    @Override
    public BaskItem save(BaskItemForm baskItemForm) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role == CommonConstant.Role.SUPER){
            throw new ApiException("超级管理员不能录入");
        }
        BaskItem item1 = baseMapper.selectOne(Wrappers.<BaskItem>lambdaQuery().eq(BaskItem::getSportId,baskItemForm.getSportId())
                .eq(BaskItem::getState,CommonConstant.State.ENABLE)
                .eq(BaskItem::getName,baskItemForm.getName()));
        if(item1 != null){
            throw new ApiException("已存在该小孩信息,不能进行重复录入!");
        }
        BaskItem item = new BaskItem();
        BeanUtils.copyProperties(baskItemForm,item);
        LocalDate today = LocalDate.now();
        LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(baskItemForm.getBirth()));
        item.setBirthday(playerDate);
        item.setAge(geAge(baskItemForm.getBirth()));
        if(Double.valueOf(item.getAge()) <3 || Double.valueOf(item.getAge()) >6){
            throw new ApiException("测试年龄不符合");
        }
        //身高得分
        item.setHeightScore(calculation.calHeight(item.getAge(),baskItemForm.getHeight(),baskItemForm.getSex()));
        item.setIbm(calculation.getBMI(baskItemForm.getHeight(),baskItemForm.getWeight()));
        //滚球
        item.setRallScore(Baskculation.calRall(item.getType(),baskItemForm.getRall()));
        //运球
        item.setDsDribbleScore(Baskculation.calShDribble(item.getType(),baskItemForm.getDsDribble()));
        //拍球
        item.setBatScore(Baskculation.calBat(item.getType(),baskItemForm.getBat()));
        //传球
        item.setPassScore(Baskculation.calPass(item.getType(),baskItemForm.getPass()));
        //投篮成绩
        item.setShootScore(Baskculation.calShoot(item.getType(),baskItemForm.getShoot()));
        item.setTotal(item.getBatScore()+item.getDsDribbleScore()+item.getRallScore()+item.getPassScore()+item.getShootScore());
        item.setCreateBy(session.getUsername());
        baseMapper.insert(item);
        return item;
    }

    @Override
    public BaskItem update(BaskItemForm baskItemForm) {
        MemberVO session = SessionCache.get();
        Integer role = session.getRole();
        if(role == CommonConstant.Role.SUPER){
            throw new ApiException("超级管理员不能修改数据");
        }
        BaskItem item = baseMapper.selectById(baskItemForm.getId());
        if(item == null){
            throw new ApiException("该数据不存在!");
        }
        item.setCreateTime(LocalDateTime.now());
        item.setName(baskItemForm.getName());
        LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(baskItemForm.getBirth()));
        item.setBirthday(playerDate);
        item.setAge(geAge(baskItemForm.getBirth()));
        if(Double.valueOf(item.getAge()) <3 || Double.valueOf(item.getAge()) >6){
            throw new ApiException("测试年龄不符合");
        }
        item.setType(baskItemForm.getType());
        //身高得分
        item.setHeightScore(calculation.calHeight(item.getAge(),baskItemForm.getHeight(),baskItemForm.getSex()));
        item.setIbm(calculation.getBMI(baskItemForm.getHeight(),baskItemForm.getWeight()));
        //滚球
        item.setRall(baskItemForm.getRall());
        item.setRallScore(Baskculation.calRall(item.getType(),baskItemForm.getRall()));

        //运球
        item.setDsDribble(baskItemForm.getDsDribble());
        item.setDsDribbleScore(Baskculation.calShDribble(item.getType(),baskItemForm.getDsDribble()));
        //拍球
        item.setBat(baskItemForm.getBat());
        item.setBatScore(Baskculation.calBat(item.getType(),baskItemForm.getBat()));
        //传球
        item.setPass(baskItemForm.getPass());
        item.setPassScore(Baskculation.calPass(item.getType(),baskItemForm.getPass()));
        //投篮成绩
        item.setShoot(baskItemForm.getShoot());
        item.setShootScore(Baskculation.calShoot(item.getType(),baskItemForm.getShoot()));
        item.setTotal(item.getBatScore()+item.getDsDribbleScore()+item.getRallScore()+item.getPassScore()+item.getShootScore());
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
            if(StringUtils.isBlank(ascOrDesc)){
                ascOrDesc = " desc ";
            }
            orderBy = orderBy + "  "+ascOrDesc;
        }
        if(role != CommonConstant.Role.SUPER){
            areaId = session.getAreaId();
        }
       List<BaskItemVO> list = baseMapper.getDataList(childName,phone,name,createBy,areaId,orderBy);
        String[] titles = new String[]{"姓名","场次名","班级","总分","学员类型","滚球","运球","拍球","传球","投篮"};
        String[] fields = {"name","sportName","type","total","xyType","rall","dsDribble","bat","pass","shoot"};
        // 转化器
        Map<String, ExcelUtil.Converter> converters = new HashMap<>(16);
     //   converters.put("createTime", (ExcelUtil.Converter<LocalDateTime>) createTime -> createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        converters.put("type", (ExcelUtil.Converter<Integer>) type -> type == 1 ? "小班" :type == 2 ? "中班" : "大班");
       // converters.put("times", (ExcelUtil.Converter<Long>) times -> times /1000 +"秒");
        ExcelUtil.exportExcel( "篮球数据报表内容.xlsx", titles, fields, list, response, converters);
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
            BaskItem item = new BaskItem();
            item.setSportId(sport.getId());
            item.setName(row.getCell(1).getStringCellValue());
            Cell cell2 =row.getCell(2);
            cell2.setCellType(CellType.STRING);
            item.setSex(Integer.valueOf(cell2.getStringCellValue()));
         //   LocalDate playerDate = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(row.getCell(3).getStringCellValue()));
            // long years = ChronoUnit.YEARS.between(playerDate, today);
            Cell cell3 =row.getCell(3);
            cell3.setCellType(CellType.STRING);
            item.setType(Integer.valueOf(cell3.getStringCellValue()));
//            item.setAge(Baskculation.getBaskAge(row.getCell(3).getStringCellValue()));
//            if(Double.valueOf(item.getAge()) <4 || Double.valueOf(item.getAge()) >6){
//                throw new ApiException("测试年龄不符合");
//            }
            item.setParentName(row.getCell(4).getStringCellValue());
            Cell cell5 =row.getCell(5);
            cell5.setCellType(CellType.STRING);
            item.setPhone(row.getCell(5).getStringCellValue());
            item.setSchool(row.getCell(6).getStringCellValue());

            //滚球
            Cell cell7 =row.getCell(7);
            cell7.setCellType(CellType.STRING);
            item.setRall(Integer.valueOf(row.getCell(7).getStringCellValue()));
            item.setRallScore(Baskculation.calRall(item.getType(),item.getRall()));

            // 运球
            Cell cell8 =row.getCell(8);
            cell8.setCellType(CellType.STRING);
            item.setDsDribble(Integer.valueOf(row.getCell(8).getStringCellValue()));
            item.setDsDribbleScore(Baskculation.calShDribble(item.getType(),item.getDsDribble()));

            //拍球
            Cell cell9 =row.getCell(9);
            cell9.setCellType(CellType.STRING);
            item.setBat(Double.valueOf(row.getCell(9).getStringCellValue()));
            item.setBatScore(Baskculation.calBat(item.getType(),item.getBat()));
            //传球
            Cell cell10 =row.getCell(10);
            cell10.setCellType(CellType.STRING);
            item.setPass(Integer.valueOf(row.getCell(10).getStringCellValue()));
            item.setPassScore(Baskculation.calPass(item.getType(),item.getPass()));

            //投篮
            Cell cell11 =row.getCell(11);
            cell11.setCellType(CellType.STRING);
            item.setShoot(Integer.valueOf(row.getCell(11).getStringCellValue()));
            item.setShootScore(Baskculation.calShoot(item.getType(),item.getShoot()));
            item.setTotal(item.getBatScore()+item.getDsDribbleScore()+item.getRallScore()+item.getPassScore()+item.getShootScore());

            Cell cell12 =row.getCell(12);
            cell12.setCellType(CellType.STRING);
            item.setXyType((row.getCell(12).getStringCellValue()));
            item.setCreateBy(session.getUsername());
            BaskItem item1 = baseMapper.selectOne(Wrappers.<BaskItem>lambdaQuery().eq(BaskItem::getSportId,sport.getId())
                                                             .eq(BaskItem::getState,CommonConstant.State.ENABLE)
                                                             .eq(BaskItem::getName,item.getName()));
            if(item1 != null){
                item.setId(item1.getId());
                baseMapper.updateById(item);
            }else{
                baseMapper.insert(item);
            }

        }
    }

    @Override
    public List<BaskItemVO> getData(String childName, String phone, Long sportId) {
        return baseMapper.getData(childName,phone,sportId);
    }

    @Override
    public BaskItemVO detail(Long id) {
        BaskItemVO vo =baseMapper.detail(id);
        Avg avg =avgMapper.selectOne(Wrappers.<Avg>lambdaQuery().eq(Avg::getSex,vo.getSex())
                .eq(Avg::getAge,vo.getAge()));
        if(avg != null){
            vo.setHightAvg(avg.getHightAvg());
            vo.setBmiAvg(avg.getBmiAvg());
        }
        return vo;
    }

    @Override
    public void del(Long id) {
        BaskItem item = baseMapper.selectById(id);
        if(item == null){
            throw new ApiException("该报告不存在");
        }
        item.setState(CommonConstant.State.DELETE);
        baseMapper.updateById(item);
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

}
