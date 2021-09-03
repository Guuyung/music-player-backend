package com.ygl.mymusic.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    private int songid;

    /**
     * 评论这首歌的用户的id
     */
    private int userid;

    /**
     * 评论内容
     */
    private String content;

    public CommentDto(int songid, int userid, String content) {
        this.songid = songid;
        this.userid = userid;
        this.content = content;
    }
}