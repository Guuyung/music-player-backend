package com.ygl.mymusic.service.impl;

import com.ygl.mymusic.entity.Score;
import com.ygl.mymusic.mapper.ScoreMapper;
import com.ygl.mymusic.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户对歌曲的评分 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

}
