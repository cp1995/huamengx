package com.cp.dd.web.form.sport;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * jwt登录参数
 *
 * @author chengp
 * @date 2019/9/20
 */
@Data
public class SportForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改时使用")
    private Long id;

    @ApiModelProperty(value = "场次名", required = true)
    @NotNull(message = "场次名不能为空")
    private String name;

   /* @ApiModelProperty(value = "园区id")
    @NotNull(message = "园区id不能为空")
    private Long areaId;*/

    @ApiModelProperty(value = "开始时间yyyy-MM-dd ", required = true)
 //   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "开始时间不能为空")
    private String startTimes;

    @ApiModelProperty(value = "结束时间yyyy-MM-dd ", required = true)
   // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "结束时间不能为空")
    private String endTimes;

}
