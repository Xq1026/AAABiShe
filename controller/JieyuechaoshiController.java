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

import com.entity.JieyuechaoshiEntity;
import com.entity.view.JieyuechaoshiView;

import com.service.JieyuechaoshiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 借阅超时
 * 后端接口
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
@RestController
@RequestMapping("/jieyuechaoshi")
public class JieyuechaoshiController {
    @Autowired
    private JieyuechaoshiService jieyuechaoshiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JieyuechaoshiEntity jieyuechaoshi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JieyuechaoshiEntity> ew = new EntityWrapper<JieyuechaoshiEntity>();

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
		PageUtils page = jieyuechaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieyuechaoshi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JieyuechaoshiEntity jieyuechaoshi,
                @RequestParam(required = false) Double tushuyajinstart,
                @RequestParam(required = false) Double tushuyajinend,
                @RequestParam(required = false) Double jieyueshizhangstart,
                @RequestParam(required = false) Double jieyueshizhangend,
                @RequestParam(required = false) Double chaochushizhangstart,
                @RequestParam(required = false) Double chaochushizhangend,
                @RequestParam(required = false) Double fajinbilistart,
                @RequestParam(required = false) Double fajinbiliend,
                @RequestParam(required = false) Double chaoshijinestart,
                @RequestParam(required = false) Double chaoshijineend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JieyuechaoshiEntity> ew = new EntityWrapper<JieyuechaoshiEntity>();
        if(tushuyajinstart!=null) ew.ge("tushuyajin", tushuyajinstart);
        if(tushuyajinend!=null) ew.le("tushuyajin", tushuyajinend);
        if(jieyueshizhangstart!=null) ew.ge("jieyueshizhang", jieyueshizhangstart);
        if(jieyueshizhangend!=null) ew.le("jieyueshizhang", jieyueshizhangend);
        if(chaochushizhangstart!=null) ew.ge("chaochushizhang", chaochushizhangstart);
        if(chaochushizhangend!=null) ew.le("chaochushizhang", chaochushizhangend);
        if(fajinbilistart!=null) ew.ge("fajinbili", fajinbilistart);
        if(fajinbiliend!=null) ew.le("fajinbili", fajinbiliend);
        if(chaoshijinestart!=null) ew.ge("chaoshijine", chaoshijinestart);
        if(chaoshijineend!=null) ew.le("chaoshijine", chaoshijineend);

        //查询结果
		PageUtils page = jieyuechaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieyuechaoshi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JieyuechaoshiEntity jieyuechaoshi){
       	EntityWrapper<JieyuechaoshiEntity> ew = new EntityWrapper<JieyuechaoshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jieyuechaoshi, "jieyuechaoshi"));
        return R.ok().put("data", jieyuechaoshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JieyuechaoshiEntity jieyuechaoshi){
        EntityWrapper< JieyuechaoshiEntity> ew = new EntityWrapper< JieyuechaoshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jieyuechaoshi, "jieyuechaoshi"));
		JieyuechaoshiView jieyuechaoshiView =  jieyuechaoshiService.selectView(ew);
		return R.ok("查询借阅超时成功").put("data", jieyuechaoshiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JieyuechaoshiEntity jieyuechaoshi = jieyuechaoshiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jieyuechaoshi,deSens);
        return R.ok().put("data", jieyuechaoshi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JieyuechaoshiEntity jieyuechaoshi = jieyuechaoshiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jieyuechaoshi,deSens);
        return R.ok().put("data", jieyuechaoshi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JieyuechaoshiEntity jieyuechaoshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieyuechaoshi);
        jieyuechaoshiService.insert(jieyuechaoshi);
        return R.ok().put("data",jieyuechaoshi.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JieyuechaoshiEntity jieyuechaoshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieyuechaoshi);
        jieyuechaoshiService.insert(jieyuechaoshi);
        return R.ok().put("data",jieyuechaoshi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JieyuechaoshiEntity jieyuechaoshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieyuechaoshi);
        //全部更新
        jieyuechaoshiService.updateById(jieyuechaoshi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jieyuechaoshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
