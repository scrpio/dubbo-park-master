package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.dao.DictMapper;
import com.park.model.Dict;
import com.park.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<Dict> getDictList() {
        EntityWrapper<Dict> entityWrapper = new EntityWrapper<>();
        Wrapper<Dict> wrapper = entityWrapper.eq("type", 1);
        List<Dict> list = dictMapper.selectList(wrapper);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Dict> getStopList() {
        EntityWrapper<Dict> entityWrapper = new EntityWrapper<>();
        Wrapper<Dict> wrapper = entityWrapper.eq("type", 0);
        List<Dict> list = dictMapper.selectList(wrapper);
        return list;
    }

    @Override
    public int addDict(Dict dict) {
        int result = dictMapper.insert(dict);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        return result;
    }

    @Override
    public int editDict(Dict dict) {
        int result = dictMapper.updateById(dict);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public int removeDict(int id) {
        int result = dictMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }
}
