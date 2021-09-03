package com.ygl.mymusic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ygl.mymusic.common.Result;
import com.ygl.mymusic.entity.Collection;
import com.ygl.mymusic.entity.Songs;
import com.ygl.mymusic.entity.Users;
import com.ygl.mymusic.mapper.LikesongsMapper;
import com.ygl.mymusic.service.ICollectionService;
import com.ygl.mymusic.service.ISongsService;
import com.ygl.mymusic.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    ICollectionService collectionService;

    @Autowired
    ISongsService songsService;

    @Autowired
    IUsersService usersService;

    @Autowired
    LikesongsMapper likesongsMapper;



    /**
     *发送一次请求收藏歌曲，第二次取消收藏
     * @author ygl
     * @date
     * @param
     * @return
     */
    @RequestMapping("/like/{songid}/{userid}")
    public Result like(@PathVariable(name = "songid")int songid,@PathVariable(name = "userid")int userid)
    {
        Songs s=songsService.getById(songid);
        Users u=usersService.getById(userid);
        if(u==null||s==null)
        {
            return Result.fail("操作失败,该用户或歌曲不存在");
        }
        if(collectionService.
                getOne(new QueryWrapper<Collection>().eq("userid",userid).eq("songid",songid))==null)
        {
            collectionService.save(new Collection(userid,songid));
        }
        else
        {
            collectionService.remove(new QueryWrapper<Collection>().eq("userid",userid).eq("songid",songid));
        }
        return Result.succ();
    }

/**
 *  收藏列表
 * @author ygl
 * @date
 * @param
 * @return
 */
    @RequestMapping("/likelist/{id}")
    public Result likelist(@PathVariable(name = "id")int id)
    {

        return Result.succ(likesongsMapper.getSongs(id));
    }

    /**
     *修改个人信息
     * @author ygl
     * @date
     * @param
     * @return
     */




}