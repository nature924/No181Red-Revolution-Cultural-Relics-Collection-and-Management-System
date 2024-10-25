package com.dao;

import com.entity.WenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WenwuView;

/**
 * 文物 Dao 接口
 *
 * @author 
 */
public interface WenwuDao extends BaseMapper<WenwuEntity> {

   List<WenwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
