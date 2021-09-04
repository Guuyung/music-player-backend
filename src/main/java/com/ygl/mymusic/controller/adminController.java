package com.ygl.mymusic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ygl.mymusic.common.Result;
import com.ygl.mymusic.entity.Users;
import com.ygl.mymusic.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class adminController {

    @Autowired
    IUsersService userservice;

    @RequestMapping("/getusers")
    public Result getUsers(@RequestParam(defaultValue = "1",name = "current") Integer currentPage)
    {
        Page page = new Page(currentPage, 5);
        IPage<Users> usersIPage=userservice.page(page);

        return Result.succ(usersIPage);
    }


    @RequestMapping("/adduser")
    public Result addUser(@RequestBody Users user)
    {
       if(user.getEmail()==null||user.getPassword()==null||user.getUsername()==null)
       {
           return Result.fail("参数不能为空");
       }
       if(userservice.getOne(new QueryWrapper<Users>().eq("email",user.getEmail()))!=null)
        {
            return Result.fail("已存在该邮箱,换个试试");
        }
       userservice.save(user);
       return Result.succ("新增成功");
    }

    @RequestMapping("/deluser/{id}")
    public Result deluser(@PathVariable(name = "id")int id)
    {
       Users u= userservice.getOne(new QueryWrapper<Users>().eq("id",id));
        if(u==null)
            return Result.fail("找不到用户信息，删除失败");
        userservice.remove(new QueryWrapper<Users>().eq("id",id));
        return Result.succ("删除用户成功");
    }

    /**
     *修改用户信息，修改个人信息
     * @author ygl
     * @date
     * @param
     * @return
     */

    @RequestMapping("/updateuser/{id}")
    public Result updateuser(@PathVariable(name = "id")int id,@RequestBody Users users)
    {
        Users u= userservice.getOne(new QueryWrapper<Users>().eq("id",id));
        if(u==null)
            return Result.fail("更新失败");
        userservice.update(users,new QueryWrapper<Users>().eq("id",id));
        return Result.succ("更新成功");
    }



}