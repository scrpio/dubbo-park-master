package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Recharge;
import com.park.pojo.BillVo;
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
public interface RechargeService extends IService<Recharge> {
    @Transactional
    Recharge addRecharge(Recharge recharge);

    @Transactional
    int removeRecharge(Long id);

    @Transactional
    int editRechargeStatus(Long id, Integer status);

    Recharge getApiRecharge(String orderId);

    List<BillVo> getBillList(Long memberId);
}
