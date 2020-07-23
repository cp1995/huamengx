package com.cp.dd.common.vo.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 全国行政区划-省市县乡村五级(2018最新版)
 * </p>
 *
 * @author chengp
 * @date 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysArea对象", description = "全国行政区划-省市县乡村3级(2018最新版)")
public class SysAreaVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id主键")
    private Long id;

    @ApiModelProperty(value = "行政区划编码")
    private String code;

    @ApiModelProperty(value = "父级行政区划编码")
    private String parentCode;

    private String shortCode;

    private String shortParentCode;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "行政级别 省1 市2 区3 ")
    private String grade;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "县/区")
    private String district;

    @ApiModelProperty(value = "乡/镇/街道")
    private String town;

    @ApiModelProperty(value = "村/社区居委会")
    private String village;

    @ApiModelProperty(value = "称行政区划全")
    private String fullName;

    @ApiModelProperty(value = "城乡分类")
    private String category;

    private List<SysAreaVo> childArea;




}
