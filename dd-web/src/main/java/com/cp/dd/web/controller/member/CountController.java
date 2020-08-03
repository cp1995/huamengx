package com.cp.dd.web.controller.member;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.entity.sport.BaskItem;
import com.cp.dd.common.entity.sport.Item;
import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.entity.sport.XxItem;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.util.SignUtil;
import com.cp.dd.common.vo.sport.*;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.sport.ItemForm;
import com.cp.dd.web.form.sport.ItemUpdateForm;
import com.cp.dd.web.service.sport.IBaskItemService;
import com.cp.dd.web.service.sport.IItemService;
import com.cp.dd.web.service.sport.ISportService;
import com.cp.dd.web.service.sport.IXxItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    private IBaskItemService baskItemService;
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
        Integer countNan3= baskItemService.count(Wrappers.<BaskItem>lambdaQuery()
                .eq(BaskItem::getSex,1)
                .eq(BaskItem::getState,1));
        Integer countNv3= baskItemService.count(Wrappers.<BaskItem>lambdaQuery()
                .eq(BaskItem::getSex,2)
                .eq(BaskItem::getState,1));
        Map<String,Integer> map = new HashMap<>();
        map.put("男",countNan+countNan2+countNan3);
        map.put("女",countNv+countNv2+countNv3);
        return Result.success(map);
    }


    @GetMapping("/yxz")
    @ApiOperation(value = "月新增学员与非学员统计", notes = "月新增学员与非学员统计")
    public Result<MonthVO> yxz(@ApiParam("年份") @RequestParam(required = false) String year) {

        return Result.success(itemService.countMonth(year));
    }
    @GetMapping("/countTotal")
    @ApiOperation(value = "男女合格比例统计", notes = "男女合格比例统计")
    public Result<CountVO> countTotal(@ApiParam("年龄段开始最小是  3") @RequestParam(required = false) String start,
                                      @ApiParam("年龄段结束 最大为 10") @RequestParam(required = false) String end
                                      ) {
        return Result.success(itemService.countTotal(start,end));
    }

    @GetMapping("/getItemCount")
    @ApiOperation(value = "幼儿园各项目统计", notes = "幼儿园各项目统计")
    public Result<ItemCountVO> getItemCount(@ApiParam("年龄段开始最小是  3") @RequestParam(required = false) String start,
                                            @ApiParam("年龄段结束 最大为 6") @RequestParam(required = false) String end
    ) {
        if(StringUtils.isNotBlank(start)){
            if(Integer.valueOf(start) < 3){
                throw new ApiException("开始年龄有误");
            }
        }
        if(StringUtils.isNotBlank(end)){
            if(Integer.valueOf(end) >  7  ){
                throw new ApiException("结束年龄段有误");
            }
        }
        return Result.success(itemService.getItemCount(start,end));
    }

    @GetMapping("/getXxItemCount")
    @ApiOperation(value = "小学各项目统计", notes = "小学各项目统计")
    public Result<XxItemCountVO> getXxItemCount(@ApiParam("年龄段开始最小是  7") @RequestParam(required = false) String start,
                                              @ApiParam("年龄段结束 最大为 10") @RequestParam(required = false) String end
    ) {
        if(StringUtils.isNotBlank(start)){
            if(Integer.valueOf(start) < 7){
                throw new ApiException("开始年龄有误");
            }
        }
        if(StringUtils.isNotBlank(end)){
            if(Integer.valueOf(end) >10   ){
                throw new ApiException("结束年龄段有误");
            }
        }
        return Result.success(xxItemService.getItemCount(start,end));
    }


}
