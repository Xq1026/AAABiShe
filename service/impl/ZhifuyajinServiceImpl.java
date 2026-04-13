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


import com.dao.ZhifuyajinDao;
import com.entity.ZhifuyajinEntity;
import com.service.ZhifuyajinService;
import com.entity.vo.ZhifuyajinVO;
import com.entity.view.ZhifuyajinView;

@Service("zhifuyajinService")
public class ZhifuyajinServiceImpl extends ServiceImpl<ZhifuyajinDao, ZhifuyajinEntity> implements ZhifuyajinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhifuyajinEntity> page = this.selectPage(
                new Query<ZhifuyajinEntity>(params).getPage(),
                new EntityWrapper<ZhifuyajinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhifuyajinEntity> wrapper) {
		  Page<ZhifuyajinView> page =new Query<ZhifuyajinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhifuyajinVO> selectListVO(Wrapper<ZhifuyajinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhifuyajinVO selectVO(Wrapper<ZhifuyajinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhifuyajinView> selectListView(Wrapper<ZhifuyajinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhifuyajinView selectView(Wrapper<ZhifuyajinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
