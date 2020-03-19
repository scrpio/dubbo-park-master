package com.park.weixin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Order;
import com.park.common.pojo.Result;
import com.park.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @SystemLog(value = "添加订单")
    @PostMapping("/api/orderAdd")
    public Result<Order> addOrder(@RequestBody Order order) {
        return new ResultUtil<Order>().setData(orderService.addOrder(order));
    }

    @SystemLog(value = "订单结算")
    @PostMapping("/api/orderEdit")
    public Result<Order> editOrder(@RequestBody Order order) {
        return new ResultUtil<Order>().setData(orderService.editOrder(order));
    }

    @GetMapping("/api/orderList")
    public Result<List<Order>> getApiOrderList(@RequestParam Long memberId, @RequestParam Integer type) {
        if (type != 2) {
            EntityWrapper<Order> entity = new EntityWrapper<>();
            Wrapper<Order> wrapper = entity.eq("member_id", memberId).and().eq("status", type).orderBy("id",false);
            return new ResultUtil<List<Order>>().setData(orderService.selectList(wrapper));
        } else {
            EntityWrapper<Order> orderEntity = new EntityWrapper<>();
            Wrapper<Order> orderWrapper = orderEntity.eq("member_id", memberId).orderBy("id",false);
            return new ResultUtil<List<Order>>().setData(orderService.selectList(orderWrapper));
        }
    }

    @GetMapping("/api/order")
    public Result<Order> getApiOrder(@RequestParam String orderId) {
        EntityWrapper<Order> entity = new EntityWrapper<>();
        Wrapper<Order> wrapper = entity.eq("order_id", orderId);
        List<Order> orderList = orderService.selectList(wrapper);
        if (orderList.size() > 0) {
            return new ResultUtil<Order>().setData(orderList.get(0));
        } else {
            return new ResultUtil<Order>().setData(null);
        }
    }

    @GetMapping("/api/getOrderByStatus")
    public Result<Order> getApiOrderByStatus(@RequestParam Long memberId) {
        return new ResultUtil<Order>().setData(orderService.getOrderByStatus(memberId));
    }
}
