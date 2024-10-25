package com.dao;

import com.entity.GongzuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzuoView;

/**
 * 工作人员 Dao 接口
 *
 * @author 
 */
public interface GongzuoDao extends BaseMapper<GongzuoEntity> {

   List<GongzuoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
