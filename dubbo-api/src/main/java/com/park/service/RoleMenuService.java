package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.RoleMenu;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface RoleMenuService extends IService<RoleMenu> {
    Integer[] getMenuIdsByRoleId(int roleId);
}
