package com.park.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.park.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
    Integer[] getRoleIdsByUserId(@Param("userId") long userId);
}
