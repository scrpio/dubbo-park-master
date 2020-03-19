package com.park.weixin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.Gson;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Member;
import com.park.common.pojo.Result;
import com.park.pojo.WxPhoneVo;
import com.park.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @SystemLog(value = "会员注册")
    @PostMapping("/api/member/add")
    public Result<Member> addMember(@RequestBody Member member) {
        if (memberService.login(member.getOpenId()) != null) {
            return new ResultUtil<Member>().setSuccessMsg("该用户已注册会员");
        }
        return new ResultUtil<Member>().setData(memberService.addMember(member));
    }

    @SystemLog(value = "修改会员信息")
    @PostMapping("/api/member/edit")
    public Result<Member> editMember(@RequestBody Member member) {
        return new ResultUtil<Member>().setData(memberService.editMember(member));
    }

    @GetMapping("/api/getMemberOpenId")
    public Result<Object> getUserOpenId(@RequestParam String code) {
        String result = memberService.getMemberOpenId(code);
        Object data = new Gson().fromJson(result, Object.class);
        return new ResultUtil<Object>().setData(data);
    }

    @PostMapping("/api/getPhoneNumber")
    public Result<Object> getPhoneNumber(@RequestBody WxPhoneVo wxPhoneVo) {
        return new ResultUtil<Object>().setData(memberService.getPhoneNumber(wxPhoneVo));
    }

    @GetMapping("/api/login")
    public Result<Object> login(@RequestParam String openId) {
        return new ResultUtil<Object>().setData(memberService.login(openId));
    }
}
