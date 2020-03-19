package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Log;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface LogService extends IService<Log> {
    @Transactional
    int removeLog(long id);
}
