package com.ygl.mymusic.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Collection implements Serializable {
    private int id;

    /**
     * 收藏人的id
     */
    private int userid;

    /**
     * 收藏歌曲的id
     */
    private int songid;

    private String mark1;

    private String mark2;

    public Collection(Integer userid, Integer songid) {
        this.userid = userid;
        this.songid = songid;
    }
}
