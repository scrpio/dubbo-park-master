package com.park.weixin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Recharge;
import com.park.common.pojo.Result;
import com.park.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @SystemLog("添加充值记录")
    @PostMapping("/api/addRecharge")
    public Result<Recharge> addRecharge(@RequestBody Recharge recharge) {
        return new ResultUtil<Recharge>().setData(rechargeService.addRecharge(recharge));
    }

    @GetMapping("/api/getApiRecharge")
    public Result<Recharge> getApiRecharge(@RequestParam String orderId) {
        return new ResultUtil<Recharge>().setData(rechargeService.getApiRecharge(orderId));
    }

    @SystemLog("删除充值记录")
    @PostMapping("/api/removerRecharge")
    public Result<Recharge> removerRecharge(Long[] ids) {
        for (Long id : ids) {
            if (rechargeService.removeRecharge(id) != 1) {
                return new ResultUtil<Recharge>().setErrorMsg("删除失败");
            }
        }
        return new ResultUtil<Recharge>().setSuccessMsg("删除成功");
    }

    @GetMapping("/api/getBillList")
    public Result<Object> getBillList(@RequestParam Long memberId){
        return new ResultUtil<Object>().setData(rechargeService.getBillList(memberId));
    }
}
