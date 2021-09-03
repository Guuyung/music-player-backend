package com.ygl.mymusic.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户留言
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Message implements Serializable {

    private int id;

    /**
     * 来自谁id的信息
     */
    private Integer from;

    /**
     * 给谁的id
     */
    private Integer to;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 评论时间
     */
    private LocalDate time;

    private String mark1;

    private String mark2;


}
