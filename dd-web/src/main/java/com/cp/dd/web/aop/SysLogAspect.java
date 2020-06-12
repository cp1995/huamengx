package com.cp.dd.web.aop;



import com.alibaba.fastjson.JSONObject;
import com.cp.dd.common.entity.sys.SysLog;
import com.cp.dd.common.exception.ApiException;
import com.cp.dd.common.support.Result;
import com.cp.dd.common.support.ResultCode;
import com.cp.dd.common.util.ip.IpUtils;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import com.cp.dd.web.service.member.ISysLogService;
import lombok.extern.slf4j.Slf4j;
import com.cp.dd.common.util.json.FastJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.aspectj.lang.reflect.MethodSignature;
import com.alibaba.fastjson.serializer.PropertyFilter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 系统日志切面
 *
 * @author chengp
 */


@Slf4j
@Aspect
@Component
public class SysLogAspect {
    @Resource
    private ISysLogService sysLogService;

    @Around("@annotation(com.cp.dd.web.aop.AddOperLog)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取注解信息
        MethodSignature sign = (MethodSignature) pjp.getSignature();
        AddOperLog operLog = sign.getMethod().getAnnotation(AddOperLog.class);

        SysLog sysLog = new SysLog();
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            final Map parameterMap = request.getParameterMap();

            long startTimeMillis = System.currentTimeMillis();
            // 请求参数
            // 请求参数
            sysLog.setOperParam(FastJsonUtil.toJSON(parameterMap,
                    (PropertyFilter) (object, name, value) -> !(value instanceof String[] && ((String[]) value)[0].length() > 100)));
            // ip
            sysLog.setIp(IpUtils.getIpAddr(request));
            String url = request.getRequestURL().toString();
            sysLog.setUrl(url);
            // 开始执行
            sysLog.setName(operLog.name());
            if("登录".equals(operLog.name())){
                JSONObject jsonObject = JSONObject.parseObject(sysLog.getOperParam());
                String username = jsonObject.getString("username");
                username = StringUtils.strip(username,"[]");
                username = username.replace("\"", "");
                sysLog.setCreateBy(username);
            }
            // 执行目标方法
            Object result = pjp.proceed();
            long execTimeMillis = System.currentTimeMillis() - startTimeMillis;
            sysLog.setTimes(execTimeMillis);
            // 执行成功
            sysLog.setDescs(ResultCode.SUCCESS.getMsg());
            sysLog.setResultCode(0);
            if (result instanceof Result) {
                // 返回结果

            }
            return result;
        } catch (Throwable e) {
            // 执行异常
           if (e instanceof ApiException) {
               sysLog.setResultCode(((ApiException) e).getCode());
               sysLog.setDescs(e.getMessage());
            } else {
               sysLog.setResultCode(ResultCode.FAILURE.getCode());
               sysLog.setDescs("系统错误");
            }
            // 这里的异常需要抛出，交给全局异常处理
            throw e;
        } finally {
            MemberVO member =  SessionCache.get();
            if(member != null){
                sysLog.setMemberId(member.getId());
                sysLog.setCreateBy(member.getUsername());
            }
            // 异步保存操作日志
            sysLogService.saveOrUpdate(sysLog);
        }
    }

/*    public static void main(String[] args) {
        String aa = "{\"username\":[\"测试园区园长\"],\"password\":[\"123456\"]}";
        JSONObject jsonObject = JSONObject.parseObject(aa);
        String username = jsonObject.getString("username");
        username = StringUtils.strip(username,"[]");
    }*/

}