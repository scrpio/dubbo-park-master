package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface UserService extends IService<User> {
    Set<String> getRolesByUsername(String username);

    Set<String> getMenusByUsername(String username);

    User getUserByUsername(String username);

    User getUserByPhone(String phone);

    @Transactional
    int addUser(User user);

    @Transactional
    int editUser(User user);

    @Transactional
    int removeUser(long id);
}
