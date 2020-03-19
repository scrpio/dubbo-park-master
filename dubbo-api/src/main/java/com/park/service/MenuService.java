package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.common.pojo.Tree;
import com.park.model.Menu;
import com.park.pojo.Router;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface MenuService extends IService<Menu> {
    List<Menu> userMenus(Long userId);

    Tree<Menu> getTree();

    List<Router> RoutersByUserId(Long userId);

    List<String> PermsByUserId(Long userId);

    @Transactional
    int addMenu(Menu menu);

    @Transactional
    int editMenu(Menu menu);

    @Transactional
    int removeMenu(int id);
}
