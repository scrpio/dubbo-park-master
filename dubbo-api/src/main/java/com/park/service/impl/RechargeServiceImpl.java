package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.common.util.ToolUtil;
import com.park.dao.MemberMapper;
import com.park.dao.RechargeMapper;
import com.park.model.Member;
import com.park.model.Recharge;
import com.park.pojo.BillVo;
import com.park.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

//import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@Component
@Service
public class RechargeServiceImpl extends ServiceImpl<RechargeMapper, Recharge> implements RechargeService {
    @Autowired
    private RechargeMapper rechargeMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Recharge addRecharge(Recharge recharge) {
        recharge.setOrderId(ToolUtil.getRandomId());
        recharge.setStatus(1);
        recharge.setCreateTime(new Date());
        int result = rechargeMapper.insert(recharge);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        EntityWrapper<Member> entity = new EntityWrapper<>();
        Wrapper<Member> wrapper = entity.eq("id", recharge.getMemberId());
        List<Member> list = memberMapper.selectList(wrapper);
        if (list.size() > 0) {
            Member member = list.get(0);
            member.setBalance(member.getBalance().add(recharge.getMoney()));
            memberMapper.updateById(member);
        }
        return getApiRecharge(recharge.getOrderId());
    }

    @Override
    public int removeRecharge(Long id) {
        int result = rechargeMapper.deleteById(id);
        if (result != 1) {
            throw new TransException(TransCode.DELETE_FAIL);
        }
        return result;
    }

    @Override
    public int editRechargeStatus(Long id, Integer status) {
        Recharge recharge = rechargeMapper.selectById(id);
        recharge.setStatus(status);
        int result = rechargeMapper.updateById(recharge);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public Recharge getApiRecharge(String orderId) {
        EntityWrapper<Recharge> rechargeEntity = new EntityWrapper<>();
        Wrapper<Recharge> rechargeWrapper = rechargeEntity.eq("order_id", orderId);
        List<Recharge> rechargeList = rechargeMapper.selectList(rechargeWrapper);
        if (rechargeList.size() > 0) {
            return rechargeList.get(0);
        }
        return null;
    }

    @Override
    public List<BillVo> getBillList(Long memberId) {
        return rechargeMapper.getBillList(memberId);
    }
}
