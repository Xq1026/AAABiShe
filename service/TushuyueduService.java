package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TushuyueduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TushuyueduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TushuyueduView;


/**
 * 图书阅读
 *
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface TushuyueduService extends IService<TushuyueduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushuyueduVO> selectListVO(Wrapper<TushuyueduEntity> wrapper);
   	
   	TushuyueduVO selectVO(@Param("ew") Wrapper<TushuyueduEntity> wrapper);
   	
   	List<TushuyueduView> selectListView(Wrapper<TushuyueduEntity> wrapper);
   	
   	TushuyueduView selectView(@Param("ew") Wrapper<TushuyueduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushuyueduEntity> wrapper);

   	

}

