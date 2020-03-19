package com.park.admin.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Menu;
import com.park.common.pojo.Result;
import com.park.common.pojo.Tree;
import com.park.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public Result<List<Tree<Menu>>> getMenuList() {
        List<Tree<Menu>> list = menuService.getTree().getChildren();
        return new ResultUtil<List<Tree<Menu>>>().setData(list);
    }

    @SystemLog(value = "添加菜单")
    @PostMapping("/add")
    public Result<Menu> addMenu(@RequestBody Menu menu) {
        if (menuService.addMenu(menu) != 1) {
            return new ResultUtil<Menu>().setErrorMsg("添加菜单失败");
        }
        return new ResultUtil<Menu>().setSuccessMsg("添加菜单成功");
    }

    @SystemLog(value = "修改菜单信息")
    @PutMapping("/edit")
    public Result<Menu> editMenu(@RequestBody Menu menu) {
        if (menuService.editMenu(menu) != 1) {
            return new ResultUtil<Menu>().setErrorMsg("修改菜单失败");
        }
        return new ResultUtil<Menu>().setSuccessMsg("修改菜单成功");
    }

    @SystemLog(value = "删除菜单")
    @DeleteMapping("/remove")
    public Result<Menu> removeMenu(@RequestParam Integer id) {
        if (menuService.removeMenu(id) != 1) {
            return new ResultUtil<Menu>().setErrorMsg("删除菜单失败");
        }
        return new ResultUtil<Menu>().setSuccessMsg("删除菜单成功");
    }
}

