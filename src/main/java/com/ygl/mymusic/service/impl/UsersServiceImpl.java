package com.ygl.mymusic.service.impl;

import com.ygl.mymusic.entity.Users;
import com.ygl.mymusic.mapper.UsersMapper;
import com.ygl.mymusic.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
