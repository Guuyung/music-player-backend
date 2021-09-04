package com.ygl.mymusic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ygl.mymusic.unionResult.Likesongs;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LikesongsMapper extends BaseMapper<Likesongs> {
    @Select("select  s.songname ,s.id , s.singer,s.url,s.cover from songs s ,\n" +
            " (select songid from collection c where userid =#{id}) t where t.songid=s.id;")
    public List<Likesongs> getSongs(int id);

}