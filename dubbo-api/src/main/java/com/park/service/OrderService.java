package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface OrderService extends IService<Order> {
    @Transactional
    Order addOrder(Order order);

    @Transactional
    Order editOrder(Order order);

    @Transactional
    int editOrderStatus(Long id, Integer status);

    Map<String, Object> orderChartData(int type, int year, Date startTime, Date endTime);

    Map<String, Object> carBarData();

    Order getOrderByStatus(Long memberId);
}
