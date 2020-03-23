package com.park.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.park.model.Recharge;
import com.park.pojo.BillVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Mapper
public interface RechargeMapper extends BaseMapper<Recharge> {
    List<BillVo> getBillList(Long memberId);
}
