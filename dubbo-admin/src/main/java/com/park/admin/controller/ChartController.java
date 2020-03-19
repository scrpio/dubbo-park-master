package com.park.admin.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.park.common.util.ResultUtil;
import com.park.model.Member;
import com.park.model.Order;
import com.park.model.Repair;
import com.park.common.pojo.Result;
import com.park.service.MemberService;
import com.park.service.OrderService;
import com.park.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RepairService repairService;

    @GetMapping("/countMember")
    public Result<Object> countMember() {
        EntityWrapper<Member> entity = new EntityWrapper<>();
        return new ResultUtil<Object>().setData(memberService.selectCount(entity));
    }

    @GetMapping("/countOrder")
    public Result<Object> countOrder() {
        EntityWrapper<Order> entity = new EntityWrapper<>();
        Wrapper<Order> wrapper = entity.eq("status", 1);
        return new ResultUtil<Object>().setData(orderService.selectCount(wrapper));
    }


    @GetMapping("/countMoney")
    public Result<Object> countMoney() {
        EntityWrapper<Order> entity = new EntityWrapper<>();
        Wrapper<Order> wrapper = entity.eq("status", 1);
        BigDecimal sum = new BigDecimal(0);
        List<Order> list = orderService.selectList(wrapper);
        for (Order order : list) {
            sum = order.getAmount().add(sum);
        }
        return new ResultUtil<Object>().setData(sum);
    }

    @GetMapping("/countRepair")
    public Result<Object> countRepair() {
        EntityWrapper<Repair> entity = new EntityWrapper<>();
        return new ResultUtil<Object>().setData(repairService.selectCount(entity));
    }

    @GetMapping("/order")
    public Result<Object> getOrderChart(@RequestParam int type,
                                        @RequestParam(required = false) int year,
                                        @RequestParam(required = false) String startTime,
                                        @RequestParam(required = false) String endTime) {
        Date startDate = DateUtil.parse(startTime);
        Date endDate = DateUtil.parse(endTime);
        if (type == -1) {
            long betweenDay = DateUtil.between(DateUtil.beginOfDay(startDate), DateUtil.endOfDay(endDate), DateUnit.DAY);
            if (betweenDay > 30) {
                return new ResultUtil<Object>().setErrorMsg("所选日期范围过长，最多不能超过31天");
            }
        }
        Map<String, Object> result = orderService.orderChartData(type, year, startDate, endDate);
        return new ResultUtil<Object>().setData(result);
    }

    @GetMapping("/carBar")
    public Result<Object> getCarPie() {
        return new ResultUtil<Object>().setData(orderService.carBarData());
    }

    @GetMapping("/repairPie")
    public Result<Object> getRepairBar() {
        return new ResultUtil<Object>().setData(repairService.repairPieData());
    }
}
