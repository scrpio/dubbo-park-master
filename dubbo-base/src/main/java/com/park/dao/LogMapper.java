package com.park.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.park.model.Log;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {

}
