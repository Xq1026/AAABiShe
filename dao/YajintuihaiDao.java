package com.dao;

import com.entity.YajintuihaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YajintuihaiVO;
import com.entity.view.YajintuihaiView;


/**
 * 押金退还
 * 
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface YajintuihaiDao extends BaseMapper<YajintuihaiEntity> {
	
	List<YajintuihaiVO> selectListVO(@Param("ew") Wrapper<YajintuihaiEntity> wrapper);
	
	YajintuihaiVO selectVO(@Param("ew") Wrapper<YajintuihaiEntity> wrapper);
	
	List<YajintuihaiView> selectListView(@Param("ew") Wrapper<YajintuihaiEntity> wrapper);

	List<YajintuihaiView> selectListView(Pagination page,@Param("ew") Wrapper<YajintuihaiEntity> wrapper);

	
	YajintuihaiView selectView(@Param("ew") Wrapper<YajintuihaiEntity> wrapper);
	

}
