package com.dao;

import com.entity.WenwuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WenwuCollectionView;

/**
 * 文物收藏 Dao 接口
 *
 * @author 
 */
public interface WenwuCollectionDao extends BaseMapper<WenwuCollectionEntity> {

   List<WenwuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
