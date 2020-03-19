package com.park.admin.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.common.annotation.SystemLog;
import com.park.common.util.ResultUtil;
import com.park.model.Member;
import com.park.common.pojo.Result;
import com.park.service.MemberService;
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
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/member/list")
    public Result<Map<String, Object>> getMemberList(@RequestParam int page, @RequestParam int limit, @RequestParam String condition) {
        Map<String, Object> result = new HashMap<>();
        PageHelper.startPage(page, limit);
        EntityWrapper<Member> entity = new EntityWrapper<>();
        Wrapper<Member> wrapper = entity.like("nickname", condition);
        List<Member> list = memberService.selectList(wrapper);
        PageInfo<Member> pageInfo = new PageInfo<>(list);
        result.put("list", list);
        result.put("total", pageInfo.getTotal());
        return new ResultUtil<Map<String, Object>>().setData(result);
    }

    @SystemLog(value = "修改会员状态")
    @PostMapping("/member/status")
    public Result<Member> editMemberStatus(@RequestBody Member member) {
        if (memberService.editMemberStatus(member.getId(), member.getStatus()) != 1) {
            return new ResultUtil<Member>().setErrorMsg("修改状态失败");
        }
        return new ResultUtil<Member>().setSuccessMsg("修改状态成功");
    }

}

