package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Garage;
import com.park.pojo.GarageVo;
import com.park.pojo.Marker;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface GarageService extends IService<Garage> {
    List<GarageVo> getGarageList();

    List<Marker> getApiGarageList(Double lat, Double lng);

    Garage getGarageById(Long id);

    @Transactional
    int addGarage(Garage garage);

    @Transactional
    int editGarage(Garage garage);

    @Transactional
    int removeGarage(Long id);
}
