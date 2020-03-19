package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.dao.GarageCarMapper;
import com.park.dao.GarageMapper;
import com.park.model.Garage;
import com.park.model.GarageCar;
import com.park.pojo.GarageVo;
import com.park.pojo.Marker;
import com.park.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class GarageServiceImpl extends ServiceImpl<GarageMapper, Garage> implements GarageService {
    @Autowired
    private GarageMapper garageMapper;
    @Autowired
    private GarageCarMapper garageCarMapper;

    @Override
    public List<GarageVo> getGarageList() {
        EntityWrapper<Garage> entity = new EntityWrapper<>();
        List<Garage> list = garageMapper.selectList(entity);
        List<GarageVo> garageList = new ArrayList<>();
        for (Garage garage : list) {
            GarageVo garageVo = new GarageVo();
            garageVo.setId(garage.getId());
            garageVo.setValue(garage.getName());
            garageVo.setSum(garage.getSum());
            garageVo.setRows(garage.getRows());
            garageVo.setCols(garage.getCols());
            garageList.add(garageVo);
        }
        return garageList;
    }

    @Override
    public List<Marker> getApiGarageList(Double lat, Double lng) {
        List<Marker> list = garageMapper.selectGarageList();
        List<Marker> res = new ArrayList<>();
        for (Marker marker : list) {
            marker.setIconPath("../../../image/mark.png");
            marker.setHeight(25);
            int d = (int) getDistance(lat, lng, marker.getLatitude(), marker.getLongitude());
            if (d < 100000) {
                marker.setDistance(d);
                res.add(marker);
            }
        }
        res.sort(Comparator.comparingInt(Marker::getDistance));
        return res;
    }

    private double getDistance(Double lat1, Double lng1, Double lat2, Double lng2) {
        double rad1 = lat1 * Math.PI / 180.0;
        double rad2 = lat2 * Math.PI / 180.0;
        double a = rad1 - rad2;
        double b = lng1 * Math.PI / 180.0 - lng2 * Math.PI / 180.0;
        double r = 6378137;
        return r * 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(rad1) * Math.cos(rad2) * Math.pow(Math.sin(b / 2), 2)));
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageMapper.selectById(id);
    }

    @Override
    public int addGarage(Garage garage) {
        garage.setCreateTime(new Date());
        int result = garageMapper.insert(garage);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        insertGarageCar(garage);
        return result;
    }

    private void insertGarageCar(Garage garage) {
        for (int i = 0; i < garage.getRows(); i++) {
            GarageCar garageCar = new GarageCar();
            garageCar.setRows(i + 1);
            char c = (char) ('A' + i);
            for (int j = 1; j <= garage.getCols(); j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                sb.append(j);
                garageCar.setGarageId(garage.getId());
                garageCar.setGarageName(garage.getName());
                garageCar.setCols(j);
                garageCar.setCarId(sb.toString());
                garageCar.setStatus(false);
                garageCarMapper.insert(garageCar);
            }
        }
    }

    @Override
    public int editGarage(Garage garage) {
        Garage old = garageMapper.selectById(garage.getId());
        if (old.getRows() != garage.getRows() || old.getCols() != garage.getCols()) {
            EntityWrapper<GarageCar> entity = new EntityWrapper<>();
            Wrapper<GarageCar> wrapper = entity.eq("garage_id", garage.getId());
            garageCarMapper.delete(wrapper);
            insertGarageCar(garage);
        }
        int result = garageMapper.updateById(garage);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public int removeGarage(Long id) {
        int result = garageMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }
}
