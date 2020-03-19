package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.GarageCar;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface GarageCarService extends IService<GarageCar> {
    @Transactional
    int addGarageCar(GarageCar garageCar);

    @Transactional
    int editGarageCar(GarageCar garageCar);

    @Transactional
    int editGarageCarStatus(Long id, Boolean status);

    @Transactional
    int removeGarageCar(Long id);
}
