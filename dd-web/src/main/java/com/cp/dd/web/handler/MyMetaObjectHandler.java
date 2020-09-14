package com.cp.dd.web.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.cp.dd.common.util.sys.SessionCache;
import com.cp.dd.common.vo.member.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 自动填充器
 *
 * @author chengp
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("start insert fill create_time、modified_time");
        MemberVO sysUserVO = SessionCache.get();
        if (sysUserVO != null) {
            this.setFieldValByName("createBy", sysUserVO.getUsername(), metaObject);
            this.setFieldValByName("createId", sysUserVO.getId(), metaObject);
        }
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("start update fill update_time");
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
