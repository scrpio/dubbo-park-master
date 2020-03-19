package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.dao.GarageCarMapper;
import com.park.model.GarageCar;
import com.park.service.GarageCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class GarageCarServiceImpl extends ServiceImpl<GarageCarMapper, GarageCar> implements GarageCarService {
    @Autowired
    private GarageCarMapper garageCarMapper;

    @Override
    public int addGarageCar(GarageCar garageCar) {
        int result = garageCarMapper.insert(garageCar);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        return result;
    }

    @Override
    public int editGarageCar(GarageCar garageCar) {
        int result = garageCarMapper.updateById(garageCar);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public int editGarageCarStatus(Long id, Boolean status) {
        GarageCar garageCar = garageCarMapper.selectById(id);
        garageCar.setStatus(status);
        int result = garageCarMapper.updateById(garageCar);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public int removeGarageCar(Long id) {
        int result = garageCarMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }
}
