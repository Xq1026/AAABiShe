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


import com.dao.TushuyueduDao;
import com.entity.TushuyueduEntity;
import com.service.TushuyueduService;
import com.entity.vo.TushuyueduVO;
import com.entity.view.TushuyueduView;

@Service("tushuyueduService")
public class TushuyueduServiceImpl extends ServiceImpl<TushuyueduDao, TushuyueduEntity> implements TushuyueduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TushuyueduEntity> page = this.selectPage(
                new Query<TushuyueduEntity>(params).getPage(),
                new EntityWrapper<TushuyueduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TushuyueduEntity> wrapper) {
		  Page<TushuyueduView> page =new Query<TushuyueduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TushuyueduVO> selectListVO(Wrapper<TushuyueduEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TushuyueduVO selectVO(Wrapper<TushuyueduEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TushuyueduView> selectListView(Wrapper<TushuyueduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TushuyueduView selectView(Wrapper<TushuyueduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
