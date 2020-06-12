package com.cp.dd.web.service.member;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cp.dd.common.entity.sys.SysLog;
import com.cp.dd.common.support.PageQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;


/**
 * <p>
 * 会员信息 服务类
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
public interface ISysLogService extends IService<SysLog> {

    IPage getPage(PageQuery pageQuery, String createBy, Long memberId, Integer resultCode, LocalDate startTime, LocalDate endTime);

    void export(HttpServletResponse response, HttpServletRequest request, String createBy, Long memberId, Integer resultCode, LocalDate startTime, LocalDate endTime);

}


