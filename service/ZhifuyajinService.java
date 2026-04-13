package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhifuyajinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhifuyajinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhifuyajinView;


/**
 * 支付押金
 *
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface ZhifuyajinService extends IService<ZhifuyajinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhifuyajinVO> selectListVO(Wrapper<ZhifuyajinEntity> wrapper);
   	
   	ZhifuyajinVO selectVO(@Param("ew") Wrapper<ZhifuyajinEntity> wrapper);
   	
   	List<ZhifuyajinView> selectListView(Wrapper<ZhifuyajinEntity> wrapper);
   	
   	ZhifuyajinView selectView(@Param("ew") Wrapper<ZhifuyajinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhifuyajinEntity> wrapper);

   	

}

