package com.dao;

import com.entity.ZhifuyajinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhifuyajinVO;
import com.entity.view.ZhifuyajinView;


/**
 * 支付押金
 * 
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface ZhifuyajinDao extends BaseMapper<ZhifuyajinEntity> {
	
	List<ZhifuyajinVO> selectListVO(@Param("ew") Wrapper<ZhifuyajinEntity> wrapper);
	
	ZhifuyajinVO selectVO(@Param("ew") Wrapper<ZhifuyajinEntity> wrapper);
	
	List<ZhifuyajinView> selectListView(@Param("ew") Wrapper<ZhifuyajinEntity> wrapper);

	List<ZhifuyajinView> selectListView(Pagination page,@Param("ew") Wrapper<ZhifuyajinEntity> wrapper);

	
	ZhifuyajinView selectView(@Param("ew") Wrapper<ZhifuyajinEntity> wrapper);
	

}
