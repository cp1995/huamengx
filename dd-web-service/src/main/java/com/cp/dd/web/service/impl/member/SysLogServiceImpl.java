package com.cp.dd.web.service.impl.member;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.entity.sys.SysLog;
import com.cp.dd.common.mapper.member.SysLogMapper;
import com.cp.dd.common.support.PageQuery;
import com.cp.dd.common.util.ExcelUtil;
import com.cp.dd.web.service.member.ISysLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {


    @Override
    public IPage getPage(PageQuery pageQuery, String createBy, Long memberId, Integer resultCode,LocalDate startTime, LocalDate endTime) {

        return  baseMapper.getPage(pageQuery.loadPage(),createBy,memberId,resultCode,startTime,endTime);
    }

    @Override
    public void export(HttpServletResponse response, HttpServletRequest request, String createBy, Long memberId, Integer resultCode, LocalDate startTime, LocalDate endTime) {
        List<SysLog> list = baseMapper.getList(createBy,memberId,resultCode,startTime,endTime);
        String[] titles = new String[]{"日志名称", "操作ip", "操作时间", "请求参数","操作结果","操作结果描述","操作人","请求耗时","请求url"};
        String[] fields = {"name", "ip", "createTime", "operParam","resultCode","descs","createBy","times","url"};
        // 转化器
        Map<String, ExcelUtil.Converter> converters = new HashMap<>(16);
        converters.put("createTime", (ExcelUtil.Converter<LocalDateTime>) createTime -> createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        converters.put("resultCode", (ExcelUtil.Converter<Integer>) signStatus -> signStatus == 0 ? "成功" : "失败");
        converters.put("times", (ExcelUtil.Converter<Long>) times -> times /1000 +"秒");
        ExcelUtil.exportExcel( "系统日志.xlsx", titles, fields, list, response, converters);
    }
}
