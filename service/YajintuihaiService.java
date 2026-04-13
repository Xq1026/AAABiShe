package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YajintuihaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YajintuihaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YajintuihaiView;


/**
 * 押金退还
 *
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public interface YajintuihaiService extends IService<YajintuihaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YajintuihaiVO> selectListVO(Wrapper<YajintuihaiEntity> wrapper);
   	
   	YajintuihaiVO selectVO(@Param("ew") Wrapper<YajintuihaiEntity> wrapper);
   	
   	List<YajintuihaiView> selectListView(Wrapper<YajintuihaiEntity> wrapper);
   	
   	YajintuihaiView selectView(@Param("ew") Wrapper<YajintuihaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YajintuihaiEntity> wrapper);

   	

}

