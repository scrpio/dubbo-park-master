package com.park.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Order;
import com.park.common.pojo.Result;
import com.park.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/list")
    public Result<Map<String, Object>> getOrderList(@RequestParam int page, @RequestParam int limit, @RequestParam String condition) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(page, limit);
        EntityWrapper<Order> entity = new EntityWrapper<>();
        Wrapper<Order> wrapper = entity.like("nickname", condition).or().like("garage_name", condition);
        List<Order> list = orderService.selectList(wrapper);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        result.put("list", list);
        result.put("total", pageInfo.getTotal());
        return new ResultUtil<Map<String, Object>>().setData(result);
    }

    @SystemLog(value = "修改订单状态")
    @PostMapping("/order/status")
    public Result<Order> editOrderStatus(@RequestParam Long id, @RequestParam Integer status) {
        if (orderService.editOrderStatus(id, status) != 1) {
            return new ResultUtil<Order>().setErrorMsg("修改失败");
        }
        return new ResultUtil<Order>().setSuccessMsg("修改成功");
    }

}

