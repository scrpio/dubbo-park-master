package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Role;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface RoleService extends IService<Role> {
    @Transactional
    int addRole(Role role);

    @Transactional
    int editRole(Role role);

    @Transactional
    int removeRole(int id);
}
