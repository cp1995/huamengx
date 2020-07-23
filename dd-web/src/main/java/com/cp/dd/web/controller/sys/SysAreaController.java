package com.cp.dd.web.controller.sys;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.annotation.IgnoreLogin;
import com.cp.dd.common.entity.sys.SysArea;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.vo.sys.SysAreaVo;
import com.cp.dd.web.service.sys.ISysAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 全国行政区划-省市县乡村五级(2018最新版) 前端控制器
 * </p>
 *
 * @author chengp
 * @date 2020-07-05
 */
@IgnoreLogin
@Validated
@RestController
@RequestMapping("/api/sys/sysArea")
@Api(value = "/sysArea", tags = "全国行政区划-省市县乡村五级")
public class SysAreaController {
    @Resource
    private ISysAreaService sysAreaService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    private static final String AREA_CODE_MAP = "AREA_CODE_MAP";


    @GetMapping(value = "/list")
    @ApiOperation(value = "获取所有的省", notes = "获取所有的省")
    public Result list() {
        List<SysAreaVo> menuList = null;
        if (Objects.nonNull(redisTemplate)) {
            menuList = (List<SysAreaVo>) redisTemplate.opsForHash().get(AREA_CODE_MAP, "hmx");
        }
        if(Objects.isNull(menuList) || menuList.isEmpty()){
            menuList = new ArrayList<>();
            List<SysArea>list =sysAreaService.list(Wrappers.<SysArea>lambdaQuery().eq(SysArea::getGrade, 1));
            for (SysArea sysArea : list) {
                SysAreaVo sysAreaVo = new SysAreaVo();
                BeanUtils.copyProperties(sysArea, sysAreaVo);
                sysAreaVo.setChildArea(getChildMenu(sysArea));
                menuList.add(sysAreaVo);
            }
            if (Objects.nonNull(redisTemplate) && Objects.nonNull(menuList) && !menuList.isEmpty()) {
                redisTemplate.opsForHash().put(AREA_CODE_MAP, "hmx", menuList);
            }
        }
        return Result.success(menuList);
    }

    @GetMapping(value = "/getNestList")
    @ApiOperation(value = "获取下一级级别数据", notes = "获取下一级级别数据")
    public Result getLevelType(@RequestParam @ApiParam(value = "code", required = true)String code,
                               @RequestParam @ApiParam(value = "grade", required = true)Integer grade) {
        List<SysArea> list = null;
        if (Objects.nonNull(redisTemplate)) {
            list = (List<SysArea>) redisTemplate.opsForHash().get(AREA_CODE_MAP, code);
        }
        if(Objects.isNull(list) || list.isEmpty()){
            list = sysAreaService.list(Wrappers.<SysArea>lambdaQuery().eq(SysArea::getGrade, grade+1)
                    .eq(SysArea::getParentCode,code));
            if (Objects.nonNull(redisTemplate) && Objects.nonNull(list) && !list.isEmpty()) {
                redisTemplate.opsForHash().put(AREA_CODE_MAP, code, list);
            }
        }
        return Result.success(list);
    }
    public  List<SysAreaVo> getChildMenu( SysArea sysArea1) {
        List<SysAreaVo> childMenuList = new ArrayList<>();
        List<SysArea> list = sysAreaService.list(Wrappers.<SysArea>lambdaQuery()
                   .eq(SysArea::getParentCode,sysArea1.getCode()));
        for (SysArea sysArea : list) {
            SysAreaVo sysAreaVo = new SysAreaVo();
            BeanUtils.copyProperties(sysArea, sysAreaVo);
            sysAreaVo.setChildArea(getThreeChildMenu(sysArea));
            childMenuList.add(sysAreaVo);
        }
        return childMenuList;
    }

    public  List<SysAreaVo> getThreeChildMenu( SysArea sysArea1) {
        List<SysAreaVo> childMenuList = new ArrayList<>();
        List<SysArea> list = sysAreaService.list(Wrappers.<SysArea>lambdaQuery()
                .eq(SysArea::getParentCode,sysArea1.getCode()));
        for (SysArea sysArea : list) {
            SysAreaVo sysAreaVo = new SysAreaVo();
            BeanUtils.copyProperties(sysArea, sysAreaVo);
            childMenuList.add(sysAreaVo);
        }
        return childMenuList;
    }
}
