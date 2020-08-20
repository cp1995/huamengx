package com.cp.dd.common.vo.sport;

import com.cp.dd.common.entity.sport.ZsInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chengp
 */
@Data
@ApiModel(description = "系统用户信息")
public class ZsInfoVO extends ZsInfo implements Serializable {


    @ApiModelProperty(value = "分类名称")
    private String categoryName;



}
