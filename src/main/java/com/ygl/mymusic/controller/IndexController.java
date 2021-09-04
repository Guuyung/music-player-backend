package com.ygl.mymusic.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ygl.mymusic.common.Result;
import com.ygl.mymusic.common.dto.registerdto;
import com.ygl.mymusic.entity.Banner;
import com.ygl.mymusic.entity.Songs;
import com.ygl.mymusic.entity.Type;
import com.ygl.mymusic.service.BannerService;
import com.ygl.mymusic.service.ISongsService;
import com.ygl.mymusic.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    ITypeService iTypeService;
    @Autowired
    ISongsService iSongsService;
    @Autowired
    BannerService bannerService;

    /**
     *主页，返回banner图和歌曲分类
     * @author ygl
     * @date
     * @param
     * @return
     */
    @RequestMapping("/index")
    public Result index(@RequestBody registerdto r, HttpServletResponse response)
    {
        List<Banner> list= bannerService.list();
        list.forEach((e)->{
            e.setUrl("localhost:8080/banner/"+e.getUrl()+".jpg");
        });

        Map res=new HashMap<>();
        res.put("banner",list);

        Map m=new HashMap();
        List<Type> types= iTypeService.list();
        for (Type t : types) {
            m.put(t.getTypename(),iSongsService.list(new QueryWrapper<Songs>().eq("type",t.getId())));
        }

        res.put("types",m);

        return Result.succ(res);
    }


}