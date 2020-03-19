package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Repair;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface RepairService extends IService<Repair> {
    @Transactional
    int addRepair(Repair repair);

    @Transactional
    int editRepair(Repair repair);

    @Transactional
    int editStatus(Long id, Integer status);

    @Transactional
    int removerRepair(Long id);

    Map<String, Object> repairPieData();
}
