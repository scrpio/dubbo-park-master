package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.dao.RoleMapper;
import com.park.dao.RoleMenuMapper;
import com.park.dao.UserRoleMapper;
import com.park.model.Role;
import com.park.model.RoleMenu;
import com.park.model.UserRole;
import com.park.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int addRole(Role role) {
        int result = roleMapper.insert(role);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        addRoleMenu(role.getId(), role.getMenuIds());
        return result;
    }

    @Override
    public int editRole(Role role) {
        int result = roleMapper.updateById(role);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        updateRoleMenu(role.getId(), role.getMenuIds());
        return result;
    }

    @Override
    public int removeRole(int id) {
        EntityWrapper<UserRole> entity = new EntityWrapper<>();
        EntityWrapper<RoleMenu> roleMenuEntity = new EntityWrapper<>();
        Wrapper<UserRole> wrapper = entity.eq("role_id", id);
        Wrapper<RoleMenu> roleMenuWrapper = roleMenuEntity.eq("role_id", id);
        if (userRoleMapper.selectCount(wrapper) > 0 && userRoleMapper.delete(wrapper) <= 0) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        if (roleMenuMapper.selectCount(roleMenuWrapper) > 0 && roleMenuMapper.delete(roleMenuWrapper) <= 0) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        int result = roleMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }

    private void addRoleMenu(int roleId, Integer[] menuIds) {
        for (int id : menuIds) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(id);
            roleMenu.setRoleId(roleId);
            if (roleMenuMapper.insert(roleMenu) != 1) {
                throw new TransException(TransCode.INSERT_FAIL);
            }
        }
    }

    private void updateRoleMenu(int roleId, Integer[] menuIds) {
        EntityWrapper<RoleMenu> entity = new EntityWrapper<>();
        Wrapper<RoleMenu> wrapper = entity.eq("role_id", roleId);
        if (roleMenuMapper.selectCount(wrapper) > 0 && roleMenuMapper.delete(wrapper) <= 0) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        addRoleMenu(roleId, menuIds);
    }
}
