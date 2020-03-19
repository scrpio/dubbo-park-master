package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.common.pojo.ShiroKit;
import com.park.common.util.BuildTree;
import com.park.dao.MenuMapper;
import com.park.dao.RoleMenuMapper;
import com.park.model.Menu;
import com.park.model.RoleMenu;
import com.park.pojo.Router;
import com.park.common.pojo.Tree;
import com.park.service.MenuService;
import com.park.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Component
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public List<Menu> userMenus(Long userId) {
        return menuMapper.listMenuByUserId(userId);
    }

    @Override
    public Tree<Menu> getTree() {
        List<Tree<Menu>> trees = new ArrayList<Tree<Menu>>();
        EntityWrapper<Menu> entity = new EntityWrapper<>();
        List<Menu> menus = menuMapper.selectList(entity);
        for (Menu menu : menus) {
            Tree<Menu> tree = new Tree<Menu>();
            tree.setId(menu.getId().toString());
            tree.setParentId(menu.getParentId().toString());
            tree.setText(menu.getName());
            tree.setObject(menu);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        return BuildTree.build(trees);
    }

    @Override
    public List<Router> RoutersByUserId(Long userId) {
        List<Menu> menus = userMenus(userId);
        List<Router> routers = new ArrayList<>();
        for (Menu menu : menus) {
            Router router = new Router();
            router.setId(menu.getId());
            router.setName(menu.getName());
            router.setPath(menu.getUrl());
            router.setIconCls(menu.getIcon());
            router.setParentId(menu.getParentId());
            router.setMenuShow(menu.getMenuShow());
            router.setChildren(new ArrayList<>());
            router.setLeaf(menu.getLeaf());
            routers.add(router);
        }
        return Router.buildList(routers, 0);
    }

    @Override
    public List<String> PermsByUserId(Long userId) {
        List<String> permsList = new ArrayList<>();
        List<Menu> menus = userMenus(userId);
        for (Menu menu : menus) {
            if (menu.getPerms() != null && "" != menu.getPerms()) {
                permsList.add(menu.getPerms());
            }
        }
        return permsList;
    }

    @Override
    public int addMenu(Menu menu) {
        menu.setCreateTime(new Date());
        int result = menuMapper.insert(menu);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        updateRouters();
        updatePerms();
        return result;
    }

    @Override
    public int editMenu(Menu menu) {
        menu.setModifiedTime(new Date());
        int result = menuMapper.updateById(menu);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        updateRouters();
        updatePerms();
        return result;
    }

    @Override
    public int removeMenu(int id) {
        EntityWrapper<RoleMenu> entity = new EntityWrapper<>();
        Wrapper<RoleMenu> wrapper = entity.eq("menu_id", id);
        if (roleMenuMapper.selectCount(wrapper) > 0 && roleMenuMapper.delete(wrapper) <= 0) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        if (menuMapper.deleteById(id) != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        updateRouters();
        updatePerms();
        return 1;
    }

    private void updateRouters() {
        if (ShiroKit.getUser() != null) {
            Long userId = ShiroKit.getUser().getId();
            List<Router> routers = RoutersByUserId(userId);
            redisService.set("user:router:", new Gson().toJson(routers));
        }
    }

    private void updatePerms() {
        if (ShiroKit.getUser() != null) {
            Long userId = ShiroKit.getUser().getId();
            List<String> perms = PermsByUserId(userId);
            redisService.set("user:perms:", new Gson().toJson(perms));
        }
    }
}
