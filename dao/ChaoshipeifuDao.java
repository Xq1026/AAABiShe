package com.dao;

import com.entity.ChaoshipeifuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChaoshipeifuVO;
import com.entity.view.ChaoshipeifuView;


/**
 * 超时赔付
 * 
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface ChaoshipeifuDao extends BaseMapper<ChaoshipeifuEntity> {
	
	List<ChaoshipeifuVO> selectListVO(@Param("ew") Wrapper<ChaoshipeifuEntity> wrapper);
	
	ChaoshipeifuVO selectVO(@Param("ew") Wrapper<ChaoshipeifuEntity> wrapper);
	
	List<ChaoshipeifuView> selectListView(@Param("ew") Wrapper<ChaoshipeifuEntity> wrapper);

	List<ChaoshipeifuView> selectListView(Pagination page,@Param("ew") Wrapper<ChaoshipeifuEntity> wrapper);

	
	ChaoshipeifuView selectView(@Param("ew") Wrapper<ChaoshipeifuEntity> wrapper);
	

}
