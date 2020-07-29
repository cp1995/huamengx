package com.cp.dd.common.vo.sport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "月新增学员非学员统计")
public class MonthVO  implements Serializable {



    @ApiModelProperty(value = "华蒙星学员1月")
    private Integer xyJan;
    @ApiModelProperty(value = "华蒙星学员2月")
    private Integer xyFeb;
    @ApiModelProperty(value = "华蒙星学员3月")
    private Integer xyMar;
    @ApiModelProperty(value = "华蒙星学员4月")
    private Integer xyApr;
    @ApiModelProperty(value = "华蒙星学员5月")
    private Integer xyMay;
    @ApiModelProperty(value = "华蒙星学员6月")
    private Integer xyJune;
    @ApiModelProperty(value = "华蒙星学员7月")
    private Integer xyJuly;
    @ApiModelProperty(value = "华蒙星学员8月")
    private Integer xyAug;
    @ApiModelProperty(value = "华蒙星学员9月")
    private Integer xySept;
    @ApiModelProperty(value = "华蒙星学员10月")
    private Integer xyOct;
    @ApiModelProperty(value = "华蒙星学员11月")
    private Integer xyNov;
    @ApiModelProperty(value = "华蒙星学员12月")
    private Integer xyDece;

    @ApiModelProperty(value = "非学员1月")
    private Integer fJan;
    @ApiModelProperty(value = "非学员2月")
    private Integer fFeb;
    @ApiModelProperty(value = "非学员3月")
    private Integer fMar;
    @ApiModelProperty(value = "非学员4月")
    private Integer fApr;
    @ApiModelProperty(value = "非学员5月")
    private Integer fMay;
    @ApiModelProperty(value = "非学员6月")
    private Integer fJune;
    @ApiModelProperty(value = "非学员7月")
    private Integer fJuly;
    @ApiModelProperty(value = "非学员8月")
    private Integer fAug;
    @ApiModelProperty(value = "非学员9月")
    private Integer fSept;
    @ApiModelProperty(value = "非学员10月")
    private Integer fOct;
    @ApiModelProperty(value = "非学员11月")
    private Integer fNov;
    @ApiModelProperty(value = "非学员12月")
    private Integer fDece;


}
