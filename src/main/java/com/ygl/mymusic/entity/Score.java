package com.ygl.mymusic.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户对歌曲的评分
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Score implements Serializable {

    private int id;
    int score;
    /**
     * 歌曲Id
     */
    private int songid;

    /**
     * 评论用户Id
     */
    private int userid;



    private String mark1;

    private String mark2;


}
