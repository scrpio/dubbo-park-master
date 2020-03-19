package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.dao.DeptMapper;
import com.park.model.Dept;
import com.park.service.DeptService;
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
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int addDept(Dept dept) {
        int result = deptMapper.insert(dept);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        return result;
    }

    @Override
    public int editDept(Dept dept) {
        int result = deptMapper.updateById(dept);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public int removeDept(int id) {
        int result = deptMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }
}
