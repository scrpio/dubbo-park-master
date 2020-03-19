package com.park.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.park.model.RoleMenu;
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
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    Integer[] getMenuIdsByRoleId(@Param("roleId") int roleId);
}
