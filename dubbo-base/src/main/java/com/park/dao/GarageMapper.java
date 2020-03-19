package com.park.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.park.model.Garage;
import com.park.pojo.Marker;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Mapper
public interface GarageMapper extends BaseMapper<Garage> {
    List<Marker> selectGarageList();
}
