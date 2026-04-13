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

import com.entity.TushuyueduEntity;
import com.entity.view.TushuyueduView;

import com.service.TushuyueduService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书阅读
 * 后端接口
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
@RestController
@RequestMapping("/tushuyuedu")
public class TushuyueduController {
    @Autowired
    private TushuyueduService tushuyueduService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushuyueduEntity tushuyuedu,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TushuyueduEntity> ew = new EntityWrapper<TushuyueduEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("shenqingrenzhanghao", (String)request.getSession().getAttribute("username"));
        }
        ew.andNew("1=1");

        //查询结果
		PageUtils page = tushuyueduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuyuedu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,TushuyueduEntity tushuyuedu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date kaishishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date kaishishijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TushuyueduEntity> ew = new EntityWrapper<TushuyueduEntity>();
        if(kaishishijianstart!=null) ew.ge("kaishishijian", kaishishijianstart);
        if(kaishishijianend!=null) ew.le("kaishishijian", kaishishijianend);

        //查询结果
		PageUtils page = tushuyueduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuyuedu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushuyueduEntity tushuyuedu){
       	EntityWrapper<TushuyueduEntity> ew = new EntityWrapper<TushuyueduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushuyuedu, "tushuyuedu"));
        return R.ok().put("data", tushuyueduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushuyueduEntity tushuyuedu){
        EntityWrapper< TushuyueduEntity> ew = new EntityWrapper< TushuyueduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushuyuedu, "tushuyuedu"));
		TushuyueduView tushuyueduView =  tushuyueduService.selectView(ew);
		return R.ok("查询图书阅读成功").put("data", tushuyueduView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushuyueduEntity tushuyuedu = tushuyueduService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tushuyuedu,deSens);
        return R.ok().put("data", tushuyuedu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushuyueduEntity tushuyuedu = tushuyueduService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tushuyuedu,deSens);
        return R.ok().put("data", tushuyuedu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushuyueduEntity tushuyuedu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuyuedu);
        tushuyueduService.insert(tushuyuedu);
        return R.ok().put("data",tushuyuedu.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushuyueduEntity tushuyuedu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuyuedu);
        tushuyueduService.insert(tushuyuedu);
        return R.ok().put("data",tushuyuedu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushuyueduEntity tushuyuedu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuyuedu);
        //全部更新
        tushuyueduService.updateById(tushuyuedu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushuyueduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
