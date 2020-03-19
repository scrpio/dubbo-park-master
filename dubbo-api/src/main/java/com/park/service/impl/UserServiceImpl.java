package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.common.pojo.ShiroKit;
import com.park.dao.UserMapper;
import com.park.dao.UserRoleMapper;
import com.park.model.User;
import com.park.model.UserRole;
import com.park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Set<String> getRolesByUsername(String username) {
        return userMapper.getRolesByUsername(username);
    }

    @Override
    public Set<String> getMenusByUsername(String username) {
        return userMapper.getMenusByUsername(username);
    }

    @Override
    public User getUserByUsername(String username) {
        EntityWrapper<User> entity = new EntityWrapper<>();
        Wrapper<User> wrapper = entity.eq("username", username).and().ne("status", 3);
        List<User> list = userMapper.selectList(wrapper);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User getUserByPhone(String phone) {
        EntityWrapper<User> entity = new EntityWrapper<>();
        Wrapper<User> wrapper = entity.eq("phone", phone).and().ne("status", 3);
        List<User> list = userMapper.selectList(wrapper);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        user.setPassword(ShiroKit.encrypt(user.getUsername(), user.getPassword()));
        user.setCreateTime(new Date());
        int result = userMapper.insert(user);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        addUserRole(user.getId(), user.getRoleIds());
        return result;
    }

    @Override
    public int editUser(User user) {
        if (!user.getPassword().isEmpty()) {
            user.setPassword(ShiroKit.encrypt(user.getUsername(), user.getPassword()));
        }
        int result = userMapper.updateById(user);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        delUserRole(user.getId());
        addUserRole(user.getId(), user.getRoleIds());
        return result;
    }

    @Override
    public int removeUser(long id) {
        delUserRole(id);
        int result = userMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }

    private void addUserRole(long userId, Integer[] roleIds) {
        UserRole userRole = new UserRole();
        for (int id : roleIds) {
            userRole.setUserId(userId);
            userRole.setRoleId(id);
            if (userRoleMapper.insert(userRole) != 1) {
                throw new TransException(TransCode.INSERT_FAIL);
            }
        }
    }

    private void delUserRole(long userId) {
        EntityWrapper<UserRole> entity = new EntityWrapper<>();
        Wrapper<UserRole> wrapper = entity.eq("user_id", userId);
        if (userRoleMapper.selectCount(wrapper) > 0 && userRoleMapper.delete(wrapper) <= 0) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
    }
}
