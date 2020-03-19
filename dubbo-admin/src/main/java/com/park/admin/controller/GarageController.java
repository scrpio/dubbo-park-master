package com.park.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Garage;
import com.park.pojo.GarageVo;
import com.park.common.pojo.Result;
import com.park.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@RestController
public class GarageController {
    @Autowired
    private GarageService garageService;

    @GetMapping("/garage/list")
    public Result<Map<String, Object>> getGarageList(@RequestParam int page, @RequestParam int limit, @RequestParam String condition) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(page, limit);
        EntityWrapper<Garage> entity = new EntityWrapper<>();
        Wrapper<Garage> wrapper = entity.like("name", condition);
        List<Garage> list = garageService.selectList(wrapper);
        PageInfo<Garage> pageInfo = new PageInfo<>(list);
        result.put("list", list);
        result.put("total", pageInfo.getTotal());
        return new ResultUtil<Map<String, Object>>().setData(result);
    }

    @GetMapping("/garage/allList")
    public Result<List<GarageVo>> getList() {
        return new ResultUtil<List<GarageVo>>().setData(garageService.getGarageList());
    }

    @SystemLog(value = "添加车库信息")
    @PostMapping("/garage/add")
    public Result<Garage> addGarage(@RequestBody Garage garage) {
        if (garageService.addGarage(garage) != 1) {
            return new ResultUtil<Garage>().setErrorMsg("添加失败");
        }
        return new ResultUtil<Garage>().setSuccessMsg("添加成功");
    }

    @SystemLog(value = "修改车库信息")
    @PostMapping("/garage/edit")
    public Result<Garage> editGarage(@RequestBody Garage garage) {
        if (garageService.editGarage(garage) != 1) {
            return new ResultUtil<Garage>().setErrorMsg("修改失败");
        }
        return new ResultUtil<Garage>().setSuccessMsg("修改成功");
    }

    @SystemLog(value = "删除车库")
    @DeleteMapping("/garage/remove")
    public Result<Garage> removeGarage(@RequestParam Long[] ids) {
        for (Long id : ids) {
            if (garageService.removeGarage(id) != 1) {
                return new ResultUtil<Garage>().setErrorMsg("删除失败");
            }
        }
        return new ResultUtil<Garage>().setSuccessMsg("删除成功");
    }
}

