package com.ygl.mymusic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ygl.mymusic.common.Mypage;
import com.ygl.mymusic.common.Result;
import com.ygl.mymusic.entity.*;
import com.ygl.mymusic.mapper.LikesongsMapper;
import com.ygl.mymusic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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

    @Autowired
    IMessageService iMessageService;

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
    public Result likelist(@PathVariable(name = "id")int id,
                           @RequestParam(defaultValue = "1",name = "current")Integer currentPage)
    {

        return Result.succ(Mypage.getPage(currentPage,5,likesongsMapper.getSongs(id)));
    }



    /**
     *  获取留言列表,传入用户id
     * @author ygl
     * @date
     * @param
     * @return
     */
    @RequestMapping("/getmessages/{id}")
    public Result getmessages(@PathVariable(name = "id")int id,@RequestParam(defaultValue = "1",name = "current")Integer currentPage)
    {

        List<Message>list=iMessageService.list(new QueryWrapper<Message>().eq("toid",id));

          return Result.succ(Mypage.getPage(currentPage,5,list));
    }

    /**
     *给某人留言
     * @author ygl
     * @date
     * @param
     * @return
     */
    @RequestMapping("/message")
    public Result domessage(@RequestBody Map<String,Object> r)
    {
        java.util.Date date = new java.util.Date();
        java.text.DateFormat myformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowdate = myformat.format(date);

        int from =(int)r.get("fromid");
        int to=(int)r.get("toid");
        iMessageService.save(new Message(from,to,(String) r.get("content"),nowdate));
        return Result.succ("留言成功");
    }

}