package com.ygl.mymusic.entity;

import java.time.LocalDate;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    private int id;

    /**
     * 来自谁id的信息
     */
    private int fromid;

    /**
     * 给谁的id
     */
    private int toid;

    /**
     * 留言内容
     */
    private String content;



    /**
     * 评论时间
     */
    private String time;

    private String mark1;

    private String mark2;
    public Message(int fromid, int to, String content, String time) {
        this.fromid = fromid;
        this.toid = to;
        this.content = content;
        this.time = time;
    }

}
