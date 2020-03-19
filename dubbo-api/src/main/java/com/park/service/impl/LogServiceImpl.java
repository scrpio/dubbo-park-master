package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.dao.LogMapper;
import com.park.model.Log;
import com.park.service.LogService;
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
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int removeLog(long id) {
        int result = logMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }
}
