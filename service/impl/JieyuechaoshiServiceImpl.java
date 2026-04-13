package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JieyuechaoshiDao;
import com.entity.JieyuechaoshiEntity;
import com.service.JieyuechaoshiService;
import com.entity.vo.JieyuechaoshiVO;
import com.entity.view.JieyuechaoshiView;

@Service("jieyuechaoshiService")
public class JieyuechaoshiServiceImpl extends ServiceImpl<JieyuechaoshiDao, JieyuechaoshiEntity> implements JieyuechaoshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JieyuechaoshiEntity> page = this.selectPage(
                new Query<JieyuechaoshiEntity>(params).getPage(),
                new EntityWrapper<JieyuechaoshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JieyuechaoshiEntity> wrapper) {
		  Page<JieyuechaoshiView> page =new Query<JieyuechaoshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JieyuechaoshiVO> selectListVO(Wrapper<JieyuechaoshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JieyuechaoshiVO selectVO(Wrapper<JieyuechaoshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JieyuechaoshiView> selectListView(Wrapper<JieyuechaoshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JieyuechaoshiView selectView(Wrapper<JieyuechaoshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
