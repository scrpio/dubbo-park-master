package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.UserRole;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface UserRoleService extends IService<UserRole> {
    Integer[] getRoleIdsByUserId(long userId);
}
