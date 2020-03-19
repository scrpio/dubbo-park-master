package com.park.admin.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Garage;
import com.park.model.GarageCar;
import com.park.common.pojo.Result;
import com.park.service.GarageCarService;
import com.park.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
public class GarageCarController {
    @Autowired
    private GarageCarService garageCarService;
    @Autowired
    private GarageService garageService;

    @GetMapping("/garage/car/list")
    public Result<Map<String, Object>> getGarageCarList(@RequestParam int page, @RequestParam int limit, @RequestParam String condition) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(page, limit);

        EntityWrapper<GarageCar> entity = new EntityWrapper<>();
        Wrapper<GarageCar> wrapper = entity.eq("garage_name", condition);
        List<GarageCar> list = garageCarService.selectList(wrapper);

        EntityWrapper<GarageCar> carEntity = new EntityWrapper<>();
        Wrapper<GarageCar> carWrapper = carEntity.eq("garage_name", condition).and("status = 0");
        int leisure = garageCarService.selectCount(carWrapper);

        PageInfo<GarageCar> pageInfo = new PageInfo<>(list);
        result.put("list", list);
        result.put("leisure", leisure);
        result.put("total", pageInfo.getTotal());
        return new ResultUtil<Map<String, Object>>().setData(result);
    }

    @GetMapping("/garage/car/view")
    public Result<Map<String, Object>> getGarageCarList2(@RequestParam String condition) {
        Map<String, Object> result = new HashMap<>();
        EntityWrapper<Garage> entity = new EntityWrapper<>();
        Wrapper<Garage> wrapper = entity.eq("name", condition);
        Garage garage = garageService.selectList(wrapper).get(0);
        List<List<GarageCar>> list = new ArrayList<>();
        for (int i = 1; i <= garage.getRows(); i++) {
            EntityWrapper<GarageCar> entityWrapper = new EntityWrapper<>();
            Wrapper<GarageCar> carWrapper = entityWrapper.eq("garage_name", condition).and().eq("rows", i);
            list.add(garageCarService.selectList(carWrapper));
        }
        result.put("sum", garage.getSum());
        result.put("cols", garage.getCols());
        result.put("list", list);
        return new ResultUtil<Map<String, Object>>().setData(result);
    }

    @SystemLog(value = "添加车位信息")
    @PostMapping("/garage/car/add")
    public Result<GarageCar> addGarageCar(@RequestBody GarageCar garageCar) {
        if (garageCarService.addGarageCar(garageCar) != 1) {
            return new ResultUtil<GarageCar>().setErrorMsg("添加失败");
        }
        return new ResultUtil<GarageCar>().setSuccessMsg("添加成功");
    }

    @SystemLog(value = "修改车位信息")
    @PostMapping("/garage/car/edit")
    public Result<GarageCar> editGarageCar(@RequestBody GarageCar garageCar) {
        if (garageCarService.editGarageCar(garageCar) != 1) {
            return new ResultUtil<GarageCar>().setErrorMsg("修改失败");
        }
        return new ResultUtil<GarageCar>().setSuccessMsg("修改成功");
    }

    @SystemLog(value = "修改车位状态")
    @PostMapping("/garage/car/status")
    public Result<GarageCar> editGarageCarStatus(@RequestParam Long id, @RequestParam Boolean status) {
        if (garageCarService.editGarageCarStatus(id, status) != 1) {
            return new ResultUtil<GarageCar>().setErrorMsg("修改失败");
        }
        return new ResultUtil<GarageCar>().setSuccessMsg("修改成功");
    }

    @SystemLog(value = "删除车位")
    @DeleteMapping("/garage/car/remove")
    public Result<GarageCar> removeGarageCar(@RequestParam Long[] ids) {
        for (Long id : ids) {
            if (garageCarService.removeGarageCar(id) != 1) {
                return new ResultUtil<GarageCar>().setErrorMsg("删除失败");
            }
        }
        return new ResultUtil<GarageCar>().setSuccessMsg("删除成功");
    }
}

