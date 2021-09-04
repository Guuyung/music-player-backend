package com.ygl.mymusic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ygl.mymusic.entity.Songs;
import com.ygl.mymusic.entity.Type;
import com.ygl.mymusic.mapper.LikesongsMapper;
import com.ygl.mymusic.service.ISongsService;
import com.ygl.mymusic.service.ITypeService;
import com.ygl.mymusic.service.IUsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class test {
    @Autowired
    IUsersService iUsersService;
    @Autowired
    ISongsService iSongsService;
    @Autowired
    ITypeService iTypeService;

    @Autowired
    LikesongsMapper likesongsMapper;
    @Test
    public void f()
    {
    List<Integer>a=new ArrayList<>();
    a.add(2);
    a.add(3);
    a.add(4);
    a.add(7);
    a.add(6);
    a.add(5);
        int cur=2,size=5;
        a.subList((cur-1)*size,cur*size);


    }



}