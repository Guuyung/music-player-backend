package com.ygl.mymusic.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ygl.mymusic.common.Mypage;
import com.ygl.mymusic.common.Result;
import com.ygl.mymusic.common.dto.CommentDto;
import com.ygl.mymusic.entity.Comment;
import com.ygl.mymusic.entity.Score;
import com.ygl.mymusic.entity.Songs;
import com.ygl.mymusic.entity.Users;
import com.ygl.mymusic.service.ICommentService;
import com.ygl.mymusic.service.IScoreService;
import com.ygl.mymusic.service.ISongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@RestController
public class SongsController {
    @Autowired
    ISongsService iSongsService;
    @Autowired
    ICommentService iCommentService;
    @Autowired
    IScoreService iScoreService;

    /**
     *查询某首歌曲及评论,评论有多个分页
     * @author ygl
     * @date
     * @param
     * @return
     */
    @RequestMapping("/song/{id}")
    public Result getSongAndComment(@PathVariable(name = "id")int id,
                                    @RequestParam(defaultValue = "1",name = "current") Integer currentPage)
    {



        Songs song=iSongsService.getById(id);
        if(song==null)
            return Result.fail("查询不到该歌曲");

        Map res=new HashMap<>();
        res.put("song",song);


        Page page = new Page(currentPage, 5);
        IPage<Users> usersIPage=
                iCommentService.page(page,new QueryWrapper<Comment>().eq("songid",id));


        res.put("comments",usersIPage);

       return Result.succ(res);
    }

    /**
     *对歌曲评论
     * @author ygl
     * @date
     * @param
     * @return
     */
    @RequestMapping("/comment")
    public Result doComment(@RequestBody CommentDto commentDto) throws ParseException {
        java.util.Date date = new java.util.Date();
        java.text.DateFormat myformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowdate = myformat.format(date);

        iCommentService.save
                (new Comment(commentDto.getSongid(),commentDto.getUserid(),commentDto.getContent(),nowdate));
        return Result.succ();
    }

    /**
     *对歌曲打分
     * @author ygl
     * @date
     * @param
     * @return
     */
    @RequestMapping("/point")
    public Result doPoint(@RequestBody Score score)
    {
        //每个人对每首歌只能评论一次
        if(iScoreService.getOne(new QueryWrapper<Score>().
                eq("songid",score.getSongid()).
                eq("userid",score.getUserid()))!=null)
        {
            return Result.fail("您已经评价过了哦");
        }
        iScoreService.save(score);
        return Result.succ("评论成功");
    }

    /**
     *歌曲搜索
     * @author ygl
     * @date
     * @param
     * @return
     */

    @RequestMapping("/search")
    public Result search(@RequestParam(name = "songname")String songname
               ,@RequestParam(defaultValue = "1",name = "current")
                                     Integer currentPage        )
    {

        List<Songs> res=new LinkedList<>();
        List<Songs> correct=
                iSongsService.list(new QueryWrapper<Songs>().eq("songname",songname));
        for (Songs songs:correct)
        {
            res.add(songs);
        }
        List<Songs> likeright=
                iSongsService.list(new QueryWrapper<Songs>().likeRight("songname",songname));
        for (Songs songs:likeright)
        {
            res.add(songs);
        }
        List<Songs> likeleft=
                iSongsService.list(new QueryWrapper<Songs>().likeLeft("songname",songname));
        for (Songs songs:likeleft)
        {
            res.add(songs);
        }

        LinkedHashSet<Songs> hashSet = new LinkedHashSet<>(res);
        ArrayList<Songs> listWithoutDuplicates = new ArrayList<>(hashSet);



        return Result.succ(Mypage.getPage(currentPage,5,listWithoutDuplicates));
    }

    /**
     *删除歌曲
     * @author ygl
     * @date
     * @param
     * @return
     */

    @RequestMapping("/delsong/{id}")
    public Result delsong(@PathVariable int id)
    {
        if(iSongsService.getById(id)==null)
            return Result.fail("找不到该歌曲");

        iSongsService.removeById(id);
        return Result.succ();
    }

    /**
     *修改歌曲,直接返回歌的json对象，在json上修改并返回
     * @author ygl
     * @date
     * @param
     * @return
     */
    @RequestMapping("/modifysong")
    private Result modify(@RequestBody Songs r)
    {
        if(iSongsService.getById(r.getId())==null)
        {
            return Result.fail("找不到该歌曲");
        }
        iSongsService.update(r,new QueryWrapper<Songs>().eq("id",r.getId()));
        return Result.succ("修改成功");
    }

    /**
     *新增歌曲
     * @author ygl
     * @date
     * @param
     * @return
     */

    @RequestMapping("/addsong")
    private Result add(@RequestBody Songs r)
    {
      if(r.getUrl()==null||r.getType()<1||r.getType()>8||r.getCover()==null||r.getLength()==null||r.getSinger()==null||r.getSongname()==null)
          return Result.fail("歌曲信息有误,请填写正确歌曲信息");
        iSongsService.save(r);
        return Result.succ("添加歌曲成功");

    }

    /**
     *  获取歌曲评分,总共有5分，返回每一分的人数及统计结果
     * @author ygl
     * @date
     * @param
     * @return
     */

    @RequestMapping("/getscorelist/{id}")
    public Result getscorelist(@PathVariable int id)
    {
        List<Score> scores=iScoreService.list(new QueryWrapper<Score>().eq("songid",id));
        int []s=new int[6];
        int sum=0;
        for(Score score:scores)
        {
            sum+=score.getScore();
//            每个数组的位置对于的分数数量
            s[score.getScore()]++;
        }
        sum/=scores.size();
        Map<String,Object>res=new HashMap<>();
        res.put("ave",sum);
        res.put("scores",s);
        return Result.succ(res);
    }

}
