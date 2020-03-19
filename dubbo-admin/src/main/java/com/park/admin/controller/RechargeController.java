package com.park.admin.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Recharge;
import com.park.common.pojo.Result;
import com.park.service.RechargeService;
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
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @GetMapping("/recharge/list")
    public Result<Map<String, Object>> getRechargeList(@RequestParam int page, @RequestParam int limit, @RequestParam String condition) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(page, limit);
        EntityWrapper<Recharge> entity = new EntityWrapper<>();
        Wrapper<Recharge> wrapper = entity.like("nickname", condition);
        List<Recharge> list = rechargeService.selectList(wrapper);
        PageInfo<Recharge> pageInfo = new PageInfo<>(list);
        result.put("list", list);
        result.put("total", pageInfo.getTotal());
        return new ResultUtil<Map<String, Object>>().setData(result);
    }

    @SystemLog(value = "修改充值状态")
    @PostMapping("/recharge/status")
    public Result<Recharge> editRechargeStatus(@RequestParam Long id, @RequestParam Integer status) {
        if (rechargeService.editRechargeStatus(id, status) != 1) {
            return new ResultUtil<Recharge>().setErrorMsg("修改失败");
        }
        return new ResultUtil<Recharge>().setSuccessMsg("修改成功");
    }

}

