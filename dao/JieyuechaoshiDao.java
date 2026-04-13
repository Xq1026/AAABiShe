package com.dao;

import com.entity.JieyuechaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JieyuechaoshiVO;
import com.entity.view.JieyuechaoshiView;


/**
 * 借阅超时
 * 
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface JieyuechaoshiDao extends BaseMapper<JieyuechaoshiEntity> {
	
	List<JieyuechaoshiVO> selectListVO(@Param("ew") Wrapper<JieyuechaoshiEntity> wrapper);
	
	JieyuechaoshiVO selectVO(@Param("ew") Wrapper<JieyuechaoshiEntity> wrapper);
	
	List<JieyuechaoshiView> selectListView(@Param("ew") Wrapper<JieyuechaoshiEntity> wrapper);

	List<JieyuechaoshiView> selectListView(Pagination page,@Param("ew") Wrapper<JieyuechaoshiEntity> wrapper);

	
	JieyuechaoshiView selectView(@Param("ew") Wrapper<JieyuechaoshiEntity> wrapper);
	

}
