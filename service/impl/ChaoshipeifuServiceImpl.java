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


import com.dao.ChaoshipeifuDao;
import com.entity.ChaoshipeifuEntity;
import com.service.ChaoshipeifuService;
import com.entity.vo.ChaoshipeifuVO;
import com.entity.view.ChaoshipeifuView;

@Service("chaoshipeifuService")
public class ChaoshipeifuServiceImpl extends ServiceImpl<ChaoshipeifuDao, ChaoshipeifuEntity> implements ChaoshipeifuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChaoshipeifuEntity> page = this.selectPage(
                new Query<ChaoshipeifuEntity>(params).getPage(),
                new EntityWrapper<ChaoshipeifuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChaoshipeifuEntity> wrapper) {
		  Page<ChaoshipeifuView> page =new Query<ChaoshipeifuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChaoshipeifuVO> selectListVO(Wrapper<ChaoshipeifuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChaoshipeifuVO selectVO(Wrapper<ChaoshipeifuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChaoshipeifuView> selectListView(Wrapper<ChaoshipeifuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChaoshipeifuView selectView(Wrapper<ChaoshipeifuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
