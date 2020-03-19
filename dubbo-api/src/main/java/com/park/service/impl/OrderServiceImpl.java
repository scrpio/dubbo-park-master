package com.park.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.common.util.TimeUtil;
import com.park.common.util.ToolUtil;
import com.park.dao.GarageCarMapper;
import com.park.dao.MemberMapper;
import com.park.dao.OrderMapper;
import com.park.model.GarageCar;
import com.park.model.Member;
import com.park.model.Order;
import com.park.pojo.ChartData;
import com.park.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

//import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Component
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GarageCarMapper garageCarMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Order addOrder(Order order) {
        order.setStatus(0);
        order.setStartTime(new Date());
        EntityWrapper<GarageCar> entity = new EntityWrapper<>();
        Wrapper<GarageCar> wrapper = entity.eq("garage_id", order.getGarageId()).and().eq("status", 0);
        List<GarageCar> list = garageCarMapper.selectList(wrapper);
        if (list.size() > 0) {
            GarageCar garageCar = list.get(0);
            order.setCarId(garageCar.getCarId());
            garageCar.setStatus(true);
            garageCarMapper.updateById(garageCar);
        }
        order.setOrderId(ToolUtil.getRandomId());
        int result = orderMapper.insert(order);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        return order;
    }

    @Override
    public Order editOrder(Order order) {
        order.setStatus(1);
        order.setEndTime(new Date());
        EntityWrapper<GarageCar> entity = new EntityWrapper<>();
        Wrapper<GarageCar> wrapper = entity.eq("garage_id", order.getGarageId()).and().eq("car_id", order.getCarId());
        List<GarageCar> list = garageCarMapper.selectList(wrapper);
        if (list.size() > 0) {
            GarageCar garageCar = list.get(0);
            garageCar.setStatus(false);
            garageCarMapper.updateById(garageCar);
        }
        EntityWrapper<Member> memberEntity = new EntityWrapper<>();
        Wrapper<Member> memberWrapper = memberEntity.eq("id", order.getMemberId());
        List<Member> memberList = memberMapper.selectList(memberWrapper);
        if (memberList.size() > 0) {
            Member member = memberList.get(0);
            int points = order.getAmount().divide(BigDecimal.valueOf(10)).intValue();
            member.setPoints(member.getPoints() + points);
            if (order.getPayType() == 1) {
                BigDecimal balance = member.getBalance().subtract(order.getAmount());
                member.setBalance(balance);
            }
            memberMapper.updateById(member);
        }
        int result = orderMapper.updateById(order);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        return order;
    }

    @Override
    public int editOrderStatus(Long id, Integer status) {
        Order order = orderMapper.selectById(id);
        order.setStatus(status);
        int result = orderMapper.updateById(order);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public Map<String, Object> orderChartData(int type, int year, Date startTime, Date endTime) {
        Map<String, Object> fullData = new HashMap<>();
        if (type == 0) {
            List<ChartData> data = orderMapper.selectOrderChart(startTime, endTime);
            List<Object> xData = xDataFull(startTime, endTime);
            List<Object> yData = yDataFull(data, xData).get("yData");
            fullData.put("xData", xData);
            fullData.put("yData", yData);
        } else if (type == 1) {
            List<ChartData> data = orderMapper.selectOrderChartByYear(year);
            List<Object> xData = xDataFullYear(year);
            List<Object> yData = yDataFull(data, xData).get("yData");
            fullData.put("xData", xData);
            fullData.put("yData", yData);
        }
        return fullData;
    }

    /**
     * x轴无数据补0
     *
     * @param startTime
     * @param endTime
     * @return
     */
    private List<Object> xDataFull(Date startTime, Date endTime) {
        List<Object> xData = new ArrayList<>();
        //相差
        long betweenDay = DateUtil.between(startTime, endTime, DateUnit.DAY);
        //起始时间
        Date everyday = startTime;
        for (int i = 0; i <= betweenDay; i++) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(everyday);
            xData.add(dateString);
            //时间+1天
            Calendar cal = Calendar.getInstance();
            cal.setTime(everyday);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            everyday = cal.getTime();
        }
        return xData;
    }

    /**
     * x轴无数据补0
     *
     * @param year
     * @return
     */
    private List<Object> xDataFullYear(int year) {
        List<Object> xData = new ArrayList<>();
        //起始月份
        Date everyMonth = TimeUtil.getBeginDayOfYear(year);
        for (int i = 0; i < 12; i++) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            String dateString = formatter.format(everyMonth);
            xData.add(dateString);
            //时间+1月
            Calendar cal = Calendar.getInstance();
            cal.setTime(everyMonth);
            cal.add(Calendar.MONTH, 1);
            everyMonth = cal.getTime();
        }
        return xData;
    }

    /**
     * y轴无数据补0
     *
     * @param data
     * @param xData
     * @return
     */
    private Map<String, List<Object>> yDataFull(List<ChartData> data, List<Object> xData) {
        Map<String, List<Object>> map = new HashMap<>();
        List<Object> yData = new ArrayList<>();
        int count = -1;
        for (int i = 0; i < xData.size(); i++) {
            boolean flag = true;
            for (ChartData chartData : data) {
                if (chartData.getDate().equals(xData.get(i))) {
                    //有数据
                    flag = false;
                    count++;
                    break;
                }
            }
            if (!flag) {
                yData.add(data.get(count).getTotal());
            } else {
                yData.add(0);
            }
        }
        map.put("yData", yData);
        return map;
    }

    @Override
    public Map<String, Object> carBarData() {
        Map<String, Object> result = new HashMap<>();
        EntityWrapper<Order> entity = new EntityWrapper<>();
        Wrapper<Order> wrapper = entity.setSqlSelect("garage_name").groupBy("garage_name");
        List<Object> xData = orderMapper.selectObjs(wrapper);
        EntityWrapper<Order> entityWrapper = new EntityWrapper<>();
        Wrapper<Order> repairWrapper = entityWrapper.setSqlSelect("count(*)").groupBy("garage_name");
        List<Object> yData = orderMapper.selectObjs(repairWrapper);
        result.put("xData", xData);
        result.put("yData", yData);
        return result;
    }

    @Override
    public Order getOrderByStatus(Long memberId) {
        return orderMapper.getOrderByStatus(memberId);
    }
}
