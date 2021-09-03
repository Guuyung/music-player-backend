package com.ygl.mymusic.mapper;

import com.ygl.mymusic.entity.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户对歌曲的评分 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Component
public interface ScoreMapper extends BaseMapper<Score> {

}
