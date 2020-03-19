package com.park.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.park.model.Order;
import com.park.pojo.ChartData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
public interface OrderMapper extends BaseMapper<Order> {
    List<ChartData> selectOrderChart(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<ChartData> selectOrderChartByYear(@Param("year") int year);

    Order getOrderByStatus(Long memberId);
}
