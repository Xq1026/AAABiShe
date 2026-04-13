package com.entity.view;

import com.entity.YajintuihaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 押金退还
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
@TableName("yajintuihai")
public class YajintuihaiView  extends YajintuihaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YajintuihaiView(){
	}
 
 	public YajintuihaiView(YajintuihaiEntity yajintuihaiEntity){
 	try {
			BeanUtils.copyProperties(this, yajintuihaiEntity);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
