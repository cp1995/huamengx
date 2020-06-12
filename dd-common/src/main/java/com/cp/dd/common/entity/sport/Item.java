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
@ApiModel(value = "sport对象", description = "会员信息")
public class Item implements Serializable {

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

    @ApiModelProperty(value = "家长姓名")
    private String parentName;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "学校")
    private String school;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "身高")
    private double height;

    @ApiModelProperty(value = "身高得分")
    private Integer heightScore;

    @ApiModelProperty(value = "体重")
    private double weight;

    @ApiModelProperty(value = "ibm")
    private double ibm;

    @ApiModelProperty(value = "ibm得分")
    private Integer ibmScore;

    @ApiModelProperty(value = "父亲身高")
    private double fHeight;

    @ApiModelProperty(value = "母亲身高")
    private double mHeight;

    @ApiModelProperty(value = "预测身高")
    private double resultHeight;

    @ApiModelProperty(value = "下肢")
    private Integer legs;

    @ApiModelProperty(value = "下肢成绩")
    private Integer legsScore;

    @ApiModelProperty(value = "上肢")
    private double szLimb;

    @ApiModelProperty(value = "上肢成绩")
    private Integer limbScore;

    @ApiModelProperty(value = "协调性")
    private double coordinate;

    @ApiModelProperty(value = "协调性成绩")
    private Integer coordinateScore;

    @ApiModelProperty(value = "平衡性")
    private double balance;

    @ApiModelProperty(value = "平衡性成绩")
    private Integer balanceScore;

    @ApiModelProperty(value = "柔韧性")
    private double flexibility;

    @ApiModelProperty(value = "柔韧性成绩")
    private Integer flexibilityScore;

    @ApiModelProperty(value = "灵敏性")
    private double sensitives;

    @ApiModelProperty(value = "灵敏性成绩")
    private Integer sensitiveScore;

    @ApiModelProperty(value = "拍球")
    private Integer racket;

    @ApiModelProperty(value = "拍球成绩")
    private Integer racketScore;

    @ApiModelProperty(value = "传球")
    private Integer pass;

    @ApiModelProperty(value = "传球成绩")
    private Integer passScore;

    @ApiModelProperty(value = "投篮")
    private Integer shoot;

    @ApiModelProperty(value = "投篮成绩")
    private Integer shootScore;

    @ApiModelProperty(value = "创建人")
    private String createBy;



}
