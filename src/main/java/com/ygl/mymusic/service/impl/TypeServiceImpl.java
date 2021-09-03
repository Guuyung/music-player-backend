package com.ygl.mymusic.service.impl;

import com.ygl.mymusic.entity.Type;
import com.ygl.mymusic.mapper.TypeMapper;
import com.ygl.mymusic.service.ITypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 歌曲分类表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

}
