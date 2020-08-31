package com.cp.dd.common.vo.member;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * <p>
 * 会员信息VO
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
@Data
@ApiModel(value = "MemberVO对象", description = "会员信息")
public class MemberVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("token-header")
    private String Authorization;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名/账号")
    private String username;


    @ApiModelProperty(value = "1管理员2录入员3园区管理员4 师资部 5总部管理员 6体测主管")
    private Integer  role;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "园区")
    private String areaName;

    @ApiModelProperty(value = "园区id")
    private Long areaId;

    @ApiModelProperty(value = "注册时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;




}
