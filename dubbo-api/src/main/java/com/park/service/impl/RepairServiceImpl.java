package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.dao.GarageMapper;
import com.park.dao.OrderMapper;
import com.park.dao.RepairMapper;
import com.park.model.Garage;
import com.park.model.Order;
import com.park.model.Repair;
import com.park.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {
    @Autowired
    private RepairMapper repairMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GarageMapper garageMapper;

    @Override
    public int addRepair(Repair repair) {
        repair.setCreateTime(new Date());
        Garage garage = garageMapper.selectById(repair.getGarageId());
        repair.setGarageName(garage.getName());
        int result = repairMapper.insert(repair);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        return result;
    }

    @Override
    public int editRepair(Repair repair) {
        int result = repairMapper.updateById(repair);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public int editStatus(Long id, Integer status) {
        Repair repair = repairMapper.selectById(id);
        repair.setStatus(status);
        int result = repairMapper.updateById(repair);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public int removerRepair(Long id) {
        int result = repairMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }

    @Override
    public Map<String, Object> repairPieData() {
        Map<String, Object> result = new HashMap<>();
        EntityWrapper<Order> entityWrapper = new EntityWrapper<>();
        Wrapper<Order> wrapper = entityWrapper.setSqlSelect("garage_name");
        List<Object> legend = orderMapper.selectObjs(wrapper);
        result.put("seriesData", repairMapper.selectRatePie());
        result.put("legendData", legend);
        return result;
    }
}
