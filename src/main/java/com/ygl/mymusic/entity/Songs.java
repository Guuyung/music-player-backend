package com.ygl.mymusic.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Songs implements Serializable {

    private int id;

    private String songname;

    private String singer;

    /**
     * 歌曲存放地址
     */
    private String url;

    /**
     * 歌曲封面地址
     */
    private String cover;

    /**
     * 歌曲分类
     */
    private int type;

    /**
     * 歌曲长度，单位为秒
     */
    private Integer length;

    private String mark1;

    private String mark2;

    public Songs(String songname, String singer) {
        this.songname = songname;
        this.singer = singer;
    }
}
