package com.entity.model;

import com.entity.TushuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 图书信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2026-02-20 17:41:34
 */
public class TushuxinxiModel  implements Serializable {
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
	 * 出版公司
	 */
	
	private String chubangongsi;
		
	/**
	 * 图书标签
	 */
	
	private String tushubiaoqian;
		
	/**
	 * 受众群体
	 */
	
	private String shouzhongqunti;
		
	/**
	 * 图书状态
	 */
	
	private String tushuzhuangtai;
		
	/**
	 * 可借天数
	 */
	
	private String kejietianshu;
		
	/**
	 * 借书地点
	 */
	
	private String jieshudidian;
		
	/**
	 * 图书押金
	 */
	
	private Double tushuyajin;
		
	/**
	 * 图书简介
	 */
	
	private String tushujianjie;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 评分
	 */
	
	private Double totalscore;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：出版公司
	 */
	 
	public void setChubangongsi(String chubangongsi) {
		this.chubangongsi = chubangongsi;
	}
	
	/**
	 * 获取：出版公司
	 */
	public String getChubangongsi() {
		return chubangongsi;
	}
				
	
	/**
	 * 设置：图书标签
	 */
	 
	public void setTushubiaoqian(String tushubiaoqian) {
		this.tushubiaoqian = tushubiaoqian;
	}
	
	/**
	 * 获取：图书标签
	 */
	public String getTushubiaoqian() {
		return tushubiaoqian;
	}
				
	
	/**
	 * 设置：受众群体
	 */
	 
	public void setShouzhongqunti(String shouzhongqunti) {
		this.shouzhongqunti = shouzhongqunti;
	}
	
	/**
	 * 获取：受众群体
	 */
	public String getShouzhongqunti() {
		return shouzhongqunti;
	}
				
	
	/**
	 * 设置：图书状态
	 */
	 
	public void setTushuzhuangtai(String tushuzhuangtai) {
		this.tushuzhuangtai = tushuzhuangtai;
	}
	
	/**
	 * 获取：图书状态
	 */
	public String getTushuzhuangtai() {
		return tushuzhuangtai;
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
	 * 设置：借书地点
	 */
	 
	public void setJieshudidian(String jieshudidian) {
		this.jieshudidian = jieshudidian;
	}
	
	/**
	 * 获取：借书地点
	 */
	public String getJieshudidian() {
		return jieshudidian;
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
	 * 设置：图书简介
	 */
	 
	public void setTushujianjie(String tushujianjie) {
		this.tushujianjie = tushujianjie;
	}
	
	/**
	 * 获取：图书简介
	 */
	public String getTushujianjie() {
		return tushujianjie;
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
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：评分
	 */
	 
	public void setTotalscore(Double totalscore) {
		this.totalscore = totalscore;
	}
	
	/**
	 * 获取：评分
	 */
	public Double getTotalscore() {
		return totalscore;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
