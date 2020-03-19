package com.park.service;

import com.baomidou.mybatisplus.service.IService;
import com.park.model.Member;
import com.park.pojo.WxPhoneVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
public interface MemberService extends IService<Member> {
    /**
     * 添加
     *
     * @param member
     * @return
     */
    @Transactional
    Member addMember(Member member);

    /**
     * 更新
     *
     * @param member
     * @return
     */
    @Transactional
    Member editMember(Member member);

    /**
     * 修改会员状态
     *
     * @param id
     * @param status
     * @return
     */
    @Transactional
    int editMemberStatus(Long id, Integer status);

    String getMemberOpenId(String code);

    Member login(String openId);

    String getPhoneNumber(WxPhoneVo wxPhoneVo);
}
