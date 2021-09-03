package com.ygl.mymusic.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygl.mymusic.entity.Banner;
import com.ygl.mymusic.mapper.BannerMapper;
import com.ygl.mymusic.service.BannerService;
import org.springframework.stereotype.Service;




import com.ygl.mymusic.entity.Collection;
import com.ygl.mymusic.mapper.CollectionMapper;
import com.ygl.mymusic.service.ICollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {
}