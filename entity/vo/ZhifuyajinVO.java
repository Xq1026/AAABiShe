package com.entity.vo;

import com.entity.ZhifuyajinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 支付押金
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
public class ZhifuyajinVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图书名称
	 */
	
	private String tushumingcheng;
		
	/**
	 * 图书类型
	 */
	
	private String tushuleixing;
		
	/**
	 * 图书封面
	 */
	
	private String tushufengmian;
		
	/**
	 * 图书作者
	 */
	
	private String tushuzuozhe;
		
	/**
	 * 作者国籍
	 */
	
	private String zuozheguoji;
		
	/**
	 * 图书语言
	 */
	
	private String tushuyuyan;
		
	/**
	 * 可借天数
	 */
	
	private String kejietianshu;
		
	/**
	 * 图书押金
	 */
	
	private Double tushuyajin;
		
	/**
	 * 支付时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date zhifushijian;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 申请人账号
	 */
	
	private String shenqingrenzhanghao;
		
	/**
	 * 申请人姓名
	 */
	
	private String shenqingrenxingming;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：图书名称
	 */
	 
	public void setTushumingcheng(String tushumingcheng) {
		this.tushumingcheng = tushumingcheng;
	}
	
	/**
	 * 获取：图书名称
	 */
	public String getTushumingcheng() {
		return tushumingcheng;
	}
				
	
	/**
	 * 设置：图书类型
	 */
	 
	public void setTushuleixing(String tushuleixing) {
		this.tushuleixing = tushuleixing;
	}
	
	/**
	 * 获取：图书类型
	 */
	public String getTushuleixing() {
		return tushuleixing;
	}
				
	
	/**
	 * 设置：图书封面
	 */
	 
	public void setTushufengmian(String tushufengmian) {
		this.tushufengmian = tushufengmian;
	}
	
	/**
	 * 获取：图书封面
	 */
	public String getTushufengmian() {
		return tushufengmian;
	}
				
	
	/**
	 * 设置：图书作者
	 */
	 
	public void setTushuzuozhe(String tushuzuozhe) {
		this.tushuzuozhe = tushuzuozhe;
	}
	
	/**
	 * 获取：图书作者
	 */
	public String getTushuzuozhe() {
		return tushuzuozhe;
	}
				
	
	/**
	 * 设置：作者国籍
	 */
	 
	public void setZuozheguoji(String zuozheguoji) {
		this.zuozheguoji = zuozheguoji;
	}
	
	/**
	 * 获取：作者国籍
	 */
	public String getZuozheguoji() {
		return zuozheguoji;
	}
				
	
	/**
	 * 设置：图书语言
	 */
	 
	public void setTushuyuyan(String tushuyuyan) {
		this.tushuyuyan = tushuyuyan;
	}
	
	/**
	 * 获取：图书语言
	 */
	public String getTushuyuyan() {
		return tushuyuyan;
	}
				
	
	/**
	 * 设置：可借天数
	 */
	 
	public void setKejietianshu(String kejietianshu) {
		this.kejietianshu = kejietianshu;
	}
	
	/**
	 * 获取：可借天数
	 */
	public String getKejietianshu() {
		return kejietianshu;
	}
				
	
	/**
	 * 设置：图书押金
	 */
	 
	public void setTushuyajin(Double tushuyajin) {
		this.tushuyajin = tushuyajin;
	}
	
	/**
	 * 获取：图书押金
	 */
	public Double getTushuyajin() {
		return tushuyajin;
	}
				
	
	/**
	 * 设置：支付时间
	 */
	 
	public void setZhifushijian(Date zhifushijian) {
		this.zhifushijian = zhifushijian;
	}
	
	/**
	 * 获取：支付时间
	 */
	public Date getZhifushijian() {
		return zhifushijian;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：申请人账号
	 */
	 
	public void setShenqingrenzhanghao(String shenqingrenzhanghao) {
		this.shenqingrenzhanghao = shenqingrenzhanghao;
	}
	
	/**
	 * 获取：申请人账号
	 */
	public String getShenqingrenzhanghao() {
		return shenqingrenzhanghao;
	}
				
	
	/**
	 * 设置：申请人姓名
	 */
	 
	public void setShenqingrenxingming(String shenqingrenxingming) {
		this.shenqingrenxingming = shenqingrenxingming;
	}
	
	/**
	 * 获取：申请人姓名
	 */
	public String getShenqingrenxingming() {
		return shenqingrenxingming;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
