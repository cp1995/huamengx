package com.cp.dd.common.entity.sport;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 场次信息
 * </p>
 *
 * @author CodeGenerator
 * @date 2019-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "篮球项目", description = "篮球项目")
public class BaskItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "场次id")
    private Long sportId;

    @ApiModelProperty(value = "小孩姓名")
    private String name;

    @ApiModelProperty(value = "小孩性别  1男 2女")
    private Integer sex;

    @ApiModelProperty(value = "出生年月")
    private LocalDate birthday;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "身高")
    private double height;

    @ApiModelProperty(value = "身高得分")
    private Integer heightScore;

    @ApiModelProperty(value = "体重")
    private double weight;

    @ApiModelProperty(value = "ibm")
    private double ibm;


    @ApiModelProperty(value = "班级  1小班 2中班 3大班")
    private Integer type;

    @ApiModelProperty(value = "家长姓名")
    private String parentName;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "学校")
    private String school;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "滚球")
    private Integer rall;

    @ApiModelProperty(value = "滚球成绩")
    private Integer rallScore;

    @ApiModelProperty(value = "运球")
    private Integer dsDribble;

    @ApiModelProperty(value = "运球成绩")
    private Integer dsDribbleScore;

    @ApiModelProperty(value = "拍球")
    private Double bat;

    @ApiModelProperty(value = "拍球成绩")
    private Integer batScore;

    @ApiModelProperty(value = "传球进圈")
    private Integer pass;

    @ApiModelProperty(value = "传球进圈成绩")
    private Integer passScore;

    @ApiModelProperty(value = "投篮")
    private Integer shoot;

    @ApiModelProperty(value = "投篮成绩")
    private Integer shootScore;

    @ApiModelProperty(value = "总分")
    private Integer total;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "状态")
    private Integer state;

    @ApiModelProperty(value = "华蒙星学员/非学员")
    private String xyType;

}
