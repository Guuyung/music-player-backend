package com.ygl.mymusic.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ygl.mymusic.common.Result;
import com.ygl.mymusic.common.dto.registerdto;
import com.ygl.mymusic.common.token.TokenUtil;
import com.ygl.mymusic.entity.Users;
import com.ygl.mymusic.service.IUsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    IUsersService iUsersService;

    //注册
    @RequestMapping("/register")
    public Result register( @RequestBody registerdto r, HttpServletResponse response)
    {

      if(iUsersService.getOne(new QueryWrapper<Users>().eq("email",r.getEmail()))==null)
      {

          if(r.getEmail()==null)
              return Result.fail("邮箱不能为空");
          if(r.getPassword()==null)
              return Result.fail("密码不能为空");
          if(r.getUsername()==null)
              return Result.fail("用户名不能为空");

          iUsersService.save(new Users(r.getUsername(),r.getPassword(),0,r.getEmail()));
          return Result.succ("创建成功");
      }
      else
      {
          return Result.fail("注册失败，该邮箱已存在，请更换邮箱");
      }
    }

    //登录
    @RequestMapping("/login")
    public Result login( @RequestBody registerdto r, HttpServletResponse response)
    {

        if(r.getEmail()==null)
            return Result.fail("邮箱不能为空");
        if(r.getPassword()==null)
            return Result.fail("密码不能为空");


        Users users=iUsersService.
                getOne(new QueryWrapper<Users>().eq("email",r.getEmail()).eq("password",r.getPassword()));

        if(users==null)
            return Result.fail("邮箱或密码错误");

        String token= TokenUtil.sign(r.getUsername());

        response.setHeader("token",token);

        return Result.succ(users,"登录成功");
    }





}