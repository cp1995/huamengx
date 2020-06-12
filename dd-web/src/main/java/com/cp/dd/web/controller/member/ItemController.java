package com.cp.dd.web.controller.member;

import com.cp.dd.common.constant.sys.OperTypeEnum;
import com.cp.dd.common.entity.sport.Sport;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.vo.sport.ItemVO;
import com.cp.dd.web.aop.AddOperLog;
import com.cp.dd.web.form.member.sport.ItemForm;
import com.cp.dd.web.service.sport.IItemService;
import com.cp.dd.web.service.sport.ISportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * 登录接口
 *
 * @author chengp
 * @date 2020-06-01
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/item")
@Api(value = "/item", tags = "信息录入接口")
public class ItemController {

    private IItemService  itemService;

    private ISportService sportService;

    @AddOperLog(name = "新增报告信息")
    @PostMapping("/save")
    @ApiOperation(value = "保存", notes = "保存")
    public Result save(@Valid ItemForm itemForm) {
        itemService.save(itemForm);
        return Result.success();
    }



    @GetMapping("/getPage")
    @ApiOperation(value = "报告分页列表", notes = "用户分页列表")
    public Result<PageModel<ItemVO>> getPage(@Valid PageQuery pageQuery,
                                             @ApiParam("小朋友姓名") @RequestParam(required = false) String childName,
                                             @ApiParam("家长手机号") @RequestParam(required = false) String phone,
                                             @ApiParam("场次名称") @RequestParam(required = false) String name,
                                             @ApiParam("创建人") @RequestParam(required = false) String createBy,
                                             @ApiParam("家长姓名") @RequestParam(required = false) String parentName,
                                             @ApiParam("所属区域") @RequestParam(required = false) Long areaId
    ) {


        return Result.success(itemService.getPage(pageQuery,childName,phone,name,createBy,parentName,areaId));
    }

    @GetMapping("/getDataPage")
    @ApiOperation(value = "数据报告分页列表", notes = "数据报告分页列表")
    public Result<PageModel<ItemVO>> getDataPage(@Valid PageQuery pageQuery,
                                             @ApiParam("小朋友姓名") @RequestParam(required = false) String childName,
                                             @ApiParam("家长手机号") @RequestParam(required = false) String phone,
                                             @ApiParam("场次名称") @RequestParam(required = false) String name,
                                             @ApiParam("创建人") @RequestParam(required = false) String createBy,
                                             @ApiParam("所属区域") @RequestParam(required = false) Long areaId,
                                             @ApiParam("排序(1、身高得分 2、bmi 3、下肢 4、上肢 5、协调性 6、平衡性 7、柔韧性 8、灵敏性 9、拍球 10 、传球 11、上篮)  ") @RequestParam(required = false) Integer sort,
                                             @ApiParam("asc 或者 desc") @RequestParam(required = false) String ascOrDesc
    ) {
        return Result.success(itemService.getDataPage(pageQuery,childName,phone,name,createBy,areaId,sort,ascOrDesc));
    }
    @AddOperLog(name = "数据报告导出")
    @GetMapping("/export")
    @ApiOperation(value = "数据报告列表导出", notes = "数据报告列表导出")
    public void export(HttpServletResponse response, HttpServletRequest request,
                       @ApiParam("小朋友姓名") @RequestParam(required = false) String childName,
                       @ApiParam("家长手机号") @RequestParam(required = false) String phone,
                       @ApiParam("场次名称") @RequestParam(required = false) String name,
                       @ApiParam("创建人") @RequestParam(required = false) String createBy,
                       @ApiParam("所属区域") @RequestParam(required = false) Long areaId,
                       @ApiParam("排序(1、身高得分 2、bmi 3、下肢 4、上肢 5、协调性 6、平衡性 7、柔韧性 8、灵敏性 9、拍球 10 、传球 11、上篮) ") @RequestParam(required = false) Integer sort,
                       @ApiParam("asc 或者 desc") @RequestParam(required = false) String ascOrDesc
                                                                                            ) {
        itemService.export(response,request,childName,phone,name,createBy,areaId,sort,ascOrDesc);
    }

    @PostMapping("/import")
    @AddOperLog(name = "数据报告导入")
    @ApiOperation(value = "导入", notes = "数据报告导入")
    public Result<?> importWord(@RequestParam("file") MultipartFile file) {
        itemService.importItem(file);
        return Result.success();
    }
    @AddOperLog(name = "公众号获取报告")
    @GetMapping("/getData")
    @ApiOperation(value = "公众号获取报告", notes = "公众号获取报告")
    public Result<List<ItemVO> > getData(
                                                 @ApiParam("小朋友姓名") @RequestParam(required = false) String childName,
                                                 @ApiParam("家长手机号") @RequestParam(required = false) String phone,
                                                 @ApiParam("场次名称") @RequestParam(required = true) Long sportId

    ) {
        return Result.success(itemService.getData(childName,phone,sportId));
    }

    @GetMapping("/getList")
    @ApiOperation(value = "公众号场次选择下拉列表", notes = "公众号场次选择下拉列表")
    public Result<List<Sport>> getList() {
        return Result.success(sportService.getWechatList());
    }

    @GetMapping("/detail")
    @ApiOperation(value = "详情", notes = "详情")
    public Result<ItemVO> detail(
            @ApiParam("id") @RequestParam(required = true) Long id

    ) {
        return Result.success(itemService.detail(id));
    }

}
