package com.ygl.mymusic.unionResult;

import com.ygl.mymusic.entity.Songs;
import lombok.Data;

@Data
public class Likesongs extends Songs {
    /**
     * 收藏人的id
     */
    private int userid;

    /**
     * 收藏歌曲的id
     */
    private int songid;
}