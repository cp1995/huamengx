package com.cp.dd.web.controller.member;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.entity.sport.Item;
import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.entity.sport.XxItem;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.util.SignUtil;
import com.cp.dd.common.vo.sport.AccessTokenFactory;
import com.cp.dd.common.vo.sport.CountVO;
import com.cp.dd.common.vo.sport.ItemVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.sport.ItemForm;
import com.cp.dd.web.form.sport.ItemUpdateForm;
import com.cp.dd.web.service.sport.IItemService;
import com.cp.dd.web.service.sport.ISportService;
import com.cp.dd.web.service.sport.IXxItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 登录接口
 *
 * @author chengp
 * @date 2020-06-01
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/count")
@Api(value = "/item", tags = "统计")
@Slf4j
@IgnoreLogin
public class CountController {

    private IItemService  itemService;

    private IXxItemService xxItemService;
    private static LocalDate date = LocalDate.now();
    private static LocalDateTime localDateTime = LocalDateTime.now();
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static String dateStr = date.format(fmt);


    @GetMapping("/countSex")
    @ApiOperation(value = "统计男女比例", notes = "统计男女比例")
    public Result countSex() {
        Integer countNan= itemService.count(Wrappers.<Item>lambdaQuery()
                .eq(Item::getSex,1)
                .eq(Item::getState,1));
        Integer countNv= itemService.count(Wrappers.<Item>lambdaQuery()
                .eq(Item::getSex,2)
                .eq(Item::getState,1));
        Integer countNan2= xxItemService.count(Wrappers.<XxItem>lambdaQuery()
                .eq(XxItem::getSex,1)
                .eq(XxItem::getState,1));
        Integer countNv2= xxItemService.count(Wrappers.<XxItem>lambdaQuery()
                .eq(XxItem::getSex,2)
                .eq(XxItem::getState,1));
        Map<String,Integer> map = new HashMap<>();
        map.put("男",countNan+countNan2);
        map.put("女",countNv+countNv2);
        return Result.success(map);
    }

    @GetMapping("/countType")
    @ApiOperation(value = "学员与非学员统计", notes = "学员与非学员统计")
    public Result countType() {
        Integer countNan= itemService.count(Wrappers.<Item>lambdaQuery()
                .eq(Item::getXyType,"华蒙星学员")
                .eq(Item::getState,1));
        Integer countNv= itemService.count(Wrappers.<Item>lambdaQuery()
                .eq(Item::getXyType,"非学员")
                .eq(Item::getState,1));
        Integer countNan2= xxItemService.count(Wrappers.<XxItem>lambdaQuery()
                .eq(XxItem::getXyType,"华蒙星学员")
                .eq(XxItem::getState,1));
        Integer countNv2= xxItemService.count(Wrappers.<XxItem>lambdaQuery()
                .eq(XxItem::getXyType,"非学员")
                .eq(XxItem::getState,1));
        Map<String,Integer> map = new HashMap<>();
        map.put("学员",countNan+countNan2);
        map.put("非学员",countNv+countNv2);
        return Result.success(map);
    }
    @GetMapping("/yxz")
    @ApiOperation(value = "月新增学员与非学员统计", notes = "月新增学员与非学员统计")
    public Result yxz() {
        String year =(localDateTime.getMonthValue() < 10) ? "0"+localDateTime.getMonthValue() : localDateTime.getMonthValue()+"";
        year = localDateTime.getYear() + "-" + year;
        LocalDateTime startTime = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(year+"-01"+" "+"00:00:00"));
        LocalDateTime endTime = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse(year+"-30"+" "+"23:59:59"));
        Integer countNan= itemService.count(Wrappers.<Item>lambdaQuery()
                .eq(Item::getXyType,"华蒙星学员")
                .between(Item::getCreateTime, startTime,endTime)
                .eq(Item::getState,1));
        Integer countNv= itemService.count(Wrappers.<Item>lambdaQuery()
                .eq(Item::getXyType,"非学员")
                .between(Item::getCreateTime, startTime,endTime)
                .eq(Item::getState,1));
        Integer countNan2= xxItemService.count(Wrappers.<XxItem>lambdaQuery()
                .eq(XxItem::getXyType,"华蒙星学员")
                .between(XxItem::getCreateTime, startTime,endTime)
                .eq(XxItem::getState,1));
        Integer countNv2= xxItemService.count(Wrappers.<XxItem>lambdaQuery()
                .eq(XxItem::getXyType,"非学员")
                .between(XxItem::getCreateTime, startTime,endTime)
                .eq(XxItem::getState,1));
        Map<String,Integer> map = new HashMap<>();
        map.put("月新增学员",countNan+countNan2);
        map.put("月新增非学员",countNv+countNv2);
        return Result.success(map);
    }
    @GetMapping("/countTotal")
    @ApiOperation(value = "男女合格比例统计", notes = "男女合格比例统计")
    public Result<CountVO> countTotal(@ApiParam("年龄段开始最小是  3") @RequestParam(required = false) String start,
                                      @ApiParam("年龄段结束 最大为 10") @RequestParam(required = false) String end
                                      ) {
        return Result.success(itemService.countTotal(start,end));
    }


}
