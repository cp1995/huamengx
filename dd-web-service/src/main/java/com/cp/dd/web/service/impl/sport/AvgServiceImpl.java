package com.cp.dd.web.service.impl.sport;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cp.dd.common.entity.sport.Avg;

import com.cp.dd.common.mapper.sport.AvgMapper;

import com.cp.dd.web.service.sport.IAvgService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;


/**
 * <p>
 * 会员信息 服务实现类
 * </p>
 *
 * @author chengp
 * @date 2019-09-30
 */
@AllArgsConstructor
@Service
public class AvgServiceImpl extends ServiceImpl<AvgMapper, Avg> implements IAvgService {

}
