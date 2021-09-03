package com.ygl.mymusic.service.impl;

import com.ygl.mymusic.entity.Message;
import com.ygl.mymusic.mapper.MessageMapper;
import com.ygl.mymusic.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户留言 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
