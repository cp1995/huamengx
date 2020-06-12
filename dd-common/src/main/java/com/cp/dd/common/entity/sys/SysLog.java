package com.cp.dd.common.entity.sys;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by chengp on 2020/2/11.
 */
@SuppressWarnings("serial")
@Data
@TableName(value = "sys_log")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysLog implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "操作结果 0 成功  -1失败")
    private Integer resultCode;

    @ApiModelProperty(value = "用户id")
    private Long MemberId;

    @ApiModelProperty(value = "操作名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String descs;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "请求url")
    private String url;

    @ApiModelProperty(value = "请求参数")
    private String operParam;

    @ApiModelProperty(value = "操作人")
    private String createBy;

    @ApiModelProperty(value = "创建时间/提交时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "时长")
    private Long times;

}
