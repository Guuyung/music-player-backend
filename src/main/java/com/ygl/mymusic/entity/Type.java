package com.ygl.mymusic.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 歌曲分类表
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Type implements Serializable {

    private int id;


    /**
     * 歌曲类别名
     */
    private String typename;

    private String mark1;

    private String mark2;


}
