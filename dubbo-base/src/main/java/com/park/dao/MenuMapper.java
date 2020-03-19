package com.park.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.park.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> listMenuByUserId(Long userId);
}
