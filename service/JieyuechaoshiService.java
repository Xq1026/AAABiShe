package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieyuechaoshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JieyuechaoshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JieyuechaoshiView;


/**
 * 借阅超时
 *
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface JieyuechaoshiService extends IService<JieyuechaoshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JieyuechaoshiVO> selectListVO(Wrapper<JieyuechaoshiEntity> wrapper);
   	
   	JieyuechaoshiVO selectVO(@Param("ew") Wrapper<JieyuechaoshiEntity> wrapper);
   	
   	List<JieyuechaoshiView> selectListView(Wrapper<JieyuechaoshiEntity> wrapper);
   	
   	JieyuechaoshiView selectView(@Param("ew") Wrapper<JieyuechaoshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JieyuechaoshiEntity> wrapper);

   	

}

