package com.dao;

import com.entity.TushuyueduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TushuyueduVO;
import com.entity.view.TushuyueduView;


/**
 * 图书阅读
 * 
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface TushuyueduDao extends BaseMapper<TushuyueduEntity> {
	
	List<TushuyueduVO> selectListVO(@Param("ew") Wrapper<TushuyueduEntity> wrapper);
	
	TushuyueduVO selectVO(@Param("ew") Wrapper<TushuyueduEntity> wrapper);
	
	List<TushuyueduView> selectListView(@Param("ew") Wrapper<TushuyueduEntity> wrapper);

	List<TushuyueduView> selectListView(Pagination page,@Param("ew") Wrapper<TushuyueduEntity> wrapper);

	
	TushuyueduView selectView(@Param("ew") Wrapper<TushuyueduEntity> wrapper);
	

}
