package com.entity.view;

import com.entity.TushuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 图书类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-02-20 17:41:34
 */
@TableName("tushuleixing")
public class TushuleixingView  extends TushuleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushuleixingView(){
	}
 
 	public TushuleixingView(TushuleixingEntity tushuleixingEntity){
 	try {
			BeanUtils.copyProperties(this, tushuleixingEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
