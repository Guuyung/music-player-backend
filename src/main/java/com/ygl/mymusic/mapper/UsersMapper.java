package com.ygl.mymusic.mapper;

import com.ygl.mymusic.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Component(value = "UsersMapper")
public interface UsersMapper extends BaseMapper<Users> {

}
