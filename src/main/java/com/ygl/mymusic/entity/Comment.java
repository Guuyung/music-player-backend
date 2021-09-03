package com.ygl.mymusic.entity;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class Comment implements Serializable {

    private int id;

    private Integer songid;

    /**
     * 评论这首歌的用户的id
     */
    private Integer userid;

    /**
     * 评论内容
     */
    private String content;

    private String time;

    private String mark1;

    private String mark2;

    public Comment(Integer songid, Integer userid, String content, String time) {
        this.songid = songid;
        this.userid = userid;
        this.content = content;
        this.time = time;
    }
}
