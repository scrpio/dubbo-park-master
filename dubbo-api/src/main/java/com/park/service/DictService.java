package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Dict;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface DictService extends IService<Dict> {
    /**
     * 获取扩展词库列表
     *
     * @return
     */
    List<Dict> getDictList();

    /**
     * 获取停用词库列表
     *
     * @return
     */
    List<Dict> getStopList();

    /**
     * 添加
     *
     * @param dict
     * @return
     */
    @Transactional
    int addDict(Dict dict);

    /**
     * 更新
     *
     * @param dict
     * @return
     */
    @Transactional
    int editDict(Dict dict);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Transactional
    int removeDict(int id);
}
