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
 * 超时赔付
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
@TableName("chaoshipeifu")
public class ChaoshipeifuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChaoshipeifuEntity() {
		
	}
	
	public ChaoshipeifuEntity(T t) {
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
	 * 可借天数
	 */
					
	private Integer kejietianshu;
	
	/**
	 * 图书押金
	 */
					
	private Double tushuyajin;
	
	/**
	 * 赔付时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date peifushijian;
	
	/**
	 * 借阅时长
	 */
					
	private Double jieyueshizhang;
	
	/**
	 * 超出时长
	 */
					
	private Integer chaochushizhang;
	
	/**
	 * 超时金额
	 */
					
	private Double chaoshijine;
	
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
	 * 设置：可借天数
	 */
	public void setKejietianshu(Integer kejietianshu) {
		this.kejietianshu = kejietianshu;
	}
	/**
	 * 获取：可借天数
	 */
	public Integer getKejietianshu() {
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
	 * 设置：赔付时间
	 */
	public void setPeifushijian(Date peifushijian) {
		this.peifushijian = peifushijian;
	}
	/**
	 * 获取：赔付时间
	 */
	public Date getPeifushijian() {
		return peifushijian;
	}
	/**
	 * 设置：借阅时长
	 */
	public void setJieyueshizhang(Double jieyueshizhang) {
		this.jieyueshizhang = jieyueshizhang;
	}
	/**
	 * 获取：借阅时长
	 */
	public Double getJieyueshizhang() {
		return jieyueshizhang;
	}
	/**
	 * 设置：超出时长
	 */
	public void setChaochushizhang(Integer chaochushizhang) {
		this.chaochushizhang = chaochushizhang;
	}
	/**
	 * 获取：超出时长
	 */
	public Integer getChaochushizhang() {
		return chaochushizhang;
	}
	/**
	 * 设置：超时金额
	 */
	public void setChaoshijine(Double chaoshijine) {
		this.chaoshijine = chaoshijine;
	}
	/**
	 * 获取：超时金额
	 */
	public Double getChaoshijine() {
		return chaoshijine;
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
