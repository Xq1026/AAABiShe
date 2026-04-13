package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import com.utils.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TushuleixingEntity;
import com.entity.view.TushuleixingView;

import com.service.TushuleixingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书类型
 * 后端接口
 * @author 
 * @email 
 * @date 2026-02-20 17:41:34
 */
@RestController
@RequestMapping("/tushuleixing")
public class TushuleixingController {
    @Autowired
    private TushuleixingService tushuleixingService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushuleixingEntity tushuleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TushuleixingEntity> ew = new EntityWrapper<TushuleixingEntity>();


        //查询结果
		PageUtils page = tushuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TushuleixingEntity tushuleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TushuleixingEntity> ew = new EntityWrapper<TushuleixingEntity>();

        //查询结果
		PageUtils page = tushuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushuleixingEntity tushuleixing){
       	EntityWrapper<TushuleixingEntity> ew = new EntityWrapper<TushuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushuleixing, "tushuleixing"));
        return R.ok().put("data", tushuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushuleixingEntity tushuleixing){
        EntityWrapper< TushuleixingEntity> ew = new EntityWrapper< TushuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushuleixing, "tushuleixing"));
		TushuleixingView tushuleixingView =  tushuleixingService.selectView(ew);
		return R.ok("查询图书类型成功").put("data", tushuleixingView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushuleixingEntity tushuleixing = tushuleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tushuleixing,deSens);
        return R.ok().put("data", tushuleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushuleixingEntity tushuleixing = tushuleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tushuleixing,deSens);
        return R.ok().put("data", tushuleixing);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushuleixingEntity tushuleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(tushuleixingService.selectCount(new EntityWrapper<TushuleixingEntity>().eq("tushuleixing", tushuleixing.getTushuleixing()))>0) {
            return R.error("图书类型已存在");
        }
        //ValidatorUtils.validateEntity(tushuleixing);
        tushuleixingService.insert(tushuleixing);
        return R.ok().put("data",tushuleixing.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushuleixingEntity tushuleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(tushuleixingService.selectCount(new EntityWrapper<TushuleixingEntity>().eq("tushuleixing", tushuleixing.getTushuleixing()))>0) {
            return R.error("图书类型已存在");
        }
        //ValidatorUtils.validateEntity(tushuleixing);
        tushuleixingService.insert(tushuleixing);
        return R.ok().put("data",tushuleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushuleixingEntity tushuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuleixing);
        //验证字段唯一性，否则返回错误信息
        if(tushuleixingService.selectCount(new EntityWrapper<TushuleixingEntity>().ne("id", tushuleixing.getId()).eq("tushuleixing", tushuleixing.getTushuleixing()))>0) {
            return R.error("图书类型已存在");
        }
        //全部更新
        tushuleixingService.updateById(tushuleixing);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
