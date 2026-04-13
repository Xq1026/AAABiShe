package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChaoshipeifuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChaoshipeifuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChaoshipeifuView;


/**
 * 超时赔付
 *
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface ChaoshipeifuService extends IService<ChaoshipeifuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChaoshipeifuVO> selectListVO(Wrapper<ChaoshipeifuEntity> wrapper);
   	
   	ChaoshipeifuVO selectVO(@Param("ew") Wrapper<ChaoshipeifuEntity> wrapper);
   	
   	List<ChaoshipeifuView> selectListView(Wrapper<ChaoshipeifuEntity> wrapper);
   	
   	ChaoshipeifuView selectView(@Param("ew") Wrapper<ChaoshipeifuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChaoshipeifuEntity> wrapper);

   	

}

