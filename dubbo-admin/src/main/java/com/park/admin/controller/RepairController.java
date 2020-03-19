package com.park.admin.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Repair;
import com.park.common.pojo.Result;
import com.park.service.RepairService;
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
@RequestMapping("/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;

    @GetMapping("/list")
    public Result<Map<String, Object>> getRepairList(@RequestParam int page, @RequestParam int limit, @RequestParam String condition) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(page, limit);
        EntityWrapper<Repair> entity = new EntityWrapper<>();
        Wrapper<Repair> wrapper = entity.like("name", condition).or().like("garageName", condition);
        List<Repair> list = repairService.selectList(wrapper);
        PageInfo<Repair> pageInfo = new PageInfo<>(list);
        result.put("list", list);
        result.put("total", pageInfo.getTotal());
        return new ResultUtil<Map<String, Object>>().setData(result);
    }

    @SystemLog("添加维修记录")
    @PostMapping("/add")
    public Result<Repair> addRepair(@RequestBody Repair repair) {
        if (repairService.addRepair(repair) != 1) {
            return new ResultUtil<Repair>().setErrorMsg("添加失败");
        }
        return new ResultUtil<Repair>().setSuccessMsg("添加成功");
    }

    @SystemLog("添加维修记录")
    @PostMapping("/edit")
    public Result<Repair> editRepair(@RequestBody Repair repair) {
        if (repairService.editRepair(repair) != 1) {
            return new ResultUtil<Repair>().setErrorMsg("修改失败");
        }
        return new ResultUtil<Repair>().setSuccessMsg("修改成功");
    }

    @SystemLog(value = "修改故障状态")
    @PostMapping("/errorStatus")
    public Result<Repair> editStatus(@RequestParam Long id, @RequestParam Integer status) {
        if (repairService.editStatus(id, status) != 1) {
            return new ResultUtil<Repair>().setErrorMsg("修改失败");
        }
        return new ResultUtil<Repair>().setSuccessMsg("修改成功");
    }

    @SystemLog("删除维修记录")
    @PostMapping("/remover")
    public Result<Repair> removerRepair(Long[] ids) {
        for (Long id : ids) {
            if (repairService.removerRepair(id) != 1) {
                return new ResultUtil<Repair>().setErrorMsg("删除失败");
            }
        }
        return new ResultUtil<Repair>().setSuccessMsg("删除成功");
    }
}

