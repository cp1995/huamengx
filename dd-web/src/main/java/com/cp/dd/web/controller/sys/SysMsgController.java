package com.cp.dd.web.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cp.dd.common.entity.sys.SysDict;
import com.cp.dd.common.entity.sys.SysMsg;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.support.PageModel;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.common.vo.sys.SysUserVO;
import com.cp.dd.web.service.sys.ISysMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 消息 前端控制器
 * </p>
 *
 * @author CodeGenerator
 * @date 2020-09-15
 */
@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/sysMsg")
@Api(value = "/sysMsg", tags = "消息")
public class SysMsgController {

    private ISysMsgService sysMsgService;

    @GetMapping("/page")
    @ApiOperation(value = "分页列表", notes = "字典树状列表")
    public Result<PageModel<SysMsg>> page(@Valid PageQuery pageQuery,
                                          @RequestParam(required = false) @ApiParam("状态（1-未读，2-已读）") Integer status) {
        MemberVO memberVO = SessionCache.get();
        IPage<SysMsg> page = sysMsgService.page(pageQuery.loadPage(), Wrappers. <SysMsg>lambdaQuery()
                .eq(SysMsg::getUserId, memberVO.getId())
                .eq(Objects.nonNull(status), SysMsg::getStatus, status)
                // 默认按sort排序
                .orderByAsc(SysMsg::getCreateTime));
        return Result.success(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping(value = "/audit")
    @ApiOperation(value = "消息已读", notes = "消息已读")
    public Result audit(@RequestParam @ApiParam(value = "Id", required = true)
                                List<Long> ids
    ) {
        ids.forEach(id->{
            SysMsg sysMsg = sysMsgService.getById(id);
            if(sysMsg == null){
                throw new ApiException("该消息不存在");
            }
            sysMsg.setStatus(2);
            sysMsgService.save(sysMsg);
        });
        return Result.success();
    }

}
