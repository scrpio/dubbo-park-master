package com.park.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.park.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    Set<String> getRolesByUsername(@Param("username") String username);

    Set<String> getMenusByUsername(@Param("username") String username);
}
