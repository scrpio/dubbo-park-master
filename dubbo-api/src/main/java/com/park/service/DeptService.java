package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Dept;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface DeptService extends IService<Dept> {
    @Transactional
    int addDept(Dept dept);

    @Transactional
    int editDept(Dept dept);

    @Transactional
    int removeDept(int id);
}
