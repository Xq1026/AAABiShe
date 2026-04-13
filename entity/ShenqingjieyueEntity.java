package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 申请借阅
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-02-20 17:41:34
 */
@TableName("shenqingjieyue")
public class ShenqingjieyueEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShenqingjieyueEntity() {
		
	}
	
	public ShenqingjieyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 图书编号
	 */
					
	private String tushubianhao;
	
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
	 * 可借天数
	 */
					
	private String kejietianshu;
	
	/**
	 * 受众群体
	 */
					
	private String shouzhongqunti;
	
	/**
	 * 图书押金
	 */
					
	private Double tushuyajin;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
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
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：图书编号
	 */
	public void setTushubianhao(String tushubianhao) {
		this.tushubianhao = tushubianhao;
	}
	/**
	 * 获取：图书编号
	 */
	public String getTushubianhao() {
		return tushubianhao;
	}
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
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
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
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
}
