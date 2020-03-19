package com.park.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.park.common.enums.TransCode;
import com.park.common.exception.TransException;
import com.park.common.util.SecretUtil;
import com.park.dao.MemberMapper;
import com.park.model.Member;
import com.park.pojo.WxPhoneVo;
import com.park.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member addMember(Member member) {
        member.setStatus(1);
        member.setCreateTime(new Date());
        member.setLastLoginTime(new Date());
        int result = memberMapper.insert(member);
        if (result != 1) {
            throw new TransException(TransCode.INSERT_FAIL);
        }
        return login(member.getOpenId());
    }

    @Override
    public Member editMember(Member member) {
        EntityWrapper<Member> entity = new EntityWrapper<>();
        Wrapper<Member> wrapper = entity.eq("open_id", member.getOpenId());
        int result = memberMapper.update(member, wrapper);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return login(member.getOpenId());
    }

    @Override
    public int editMemberStatus(Long id, Integer status) {
        Member member = memberMapper.selectById(id);
        member.setStatus(status);
        int result = memberMapper.updateById(member);
        if (result != 1) {
            throw new TransException(TransCode.UPDATE_FAIL);
        }
        return result;
    }

    @Override
    public String getMemberOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx9409ae705604a646&secret=071df0fd8602397a62f0b5c74729959e&js_code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public Member login(String openId) {
        EntityWrapper<Member> entity = new EntityWrapper<>();
        Wrapper<Member> wrapper = entity.eq("open_id", openId);
        List<Member> list = memberMapper.selectList(wrapper);
        if (list.size() > 0) {
            Member member = list.get(0);
            member.setLastLoginTime(new Date());
            memberMapper.updateById(member);
            return member;
        } else {
            return null;
        }
    }

    @Override
    public String getPhoneNumber(WxPhoneVo wxPhoneVo) {
        String encryptedDataStr = wxPhoneVo.getEncryptedData();
        String keyBytesStr = wxPhoneVo.getSession();
        String ivStr = wxPhoneVo.getIv();
        String phoneStr = SecretUtil.decrypt(encryptedDataStr, keyBytesStr, ivStr);
        JSONObject jsonObject = JSONObject.parseObject(phoneStr);
        String phone = jsonObject.getString("phoneNumber");
        return phone;
    }
}
