package com.ygl.mymusic.service.impl;

import com.ygl.mymusic.entity.Comment;
import com.ygl.mymusic.mapper.CommentMapper;
import com.ygl.mymusic.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
