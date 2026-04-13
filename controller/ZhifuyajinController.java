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

import com.entity.ZhifuyajinEntity;
import com.entity.view.ZhifuyajinView;

import com.service.ZhifuyajinService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 支付押金
 * 后端接口
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
@RestController
@RequestMapping("/zhifuyajin")
public class ZhifuyajinController {
    @Autowired
    private ZhifuyajinService zhifuyajinService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhifuyajinEntity zhifuyajin,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhifuyajinEntity> ew = new EntityWrapper<ZhifuyajinEntity>();

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
		PageUtils page = zhifuyajinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhifuyajin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZhifuyajinEntity zhifuyajin,
                @RequestParam(required = false) Double tushuyajinstart,
                @RequestParam(required = false) Double tushuyajinend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zhifushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date zhifushijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhifuyajinEntity> ew = new EntityWrapper<ZhifuyajinEntity>();
        if(tushuyajinstart!=null) ew.ge("tushuyajin", tushuyajinstart);
        if(tushuyajinend!=null) ew.le("tushuyajin", tushuyajinend);
        if(zhifushijianstart!=null) ew.ge("zhifushijian", zhifushijianstart);
        if(zhifushijianend!=null) ew.le("zhifushijian", zhifushijianend);

        //查询结果
		PageUtils page = zhifuyajinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhifuyajin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhifuyajinEntity zhifuyajin){
       	EntityWrapper<ZhifuyajinEntity> ew = new EntityWrapper<ZhifuyajinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhifuyajin, "zhifuyajin"));
        return R.ok().put("data", zhifuyajinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhifuyajinEntity zhifuyajin){
        EntityWrapper< ZhifuyajinEntity> ew = new EntityWrapper< ZhifuyajinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhifuyajin, "zhifuyajin"));
		ZhifuyajinView zhifuyajinView =  zhifuyajinService.selectView(ew);
		return R.ok("查询支付押金成功").put("data", zhifuyajinView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhifuyajinEntity zhifuyajin = zhifuyajinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhifuyajin,deSens);
        return R.ok().put("data", zhifuyajin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhifuyajinEntity zhifuyajin = zhifuyajinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhifuyajin,deSens);
        return R.ok().put("data", zhifuyajin);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhifuyajinEntity zhifuyajin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhifuyajin);
        zhifuyajinService.insert(zhifuyajin);
        return R.ok().put("data",zhifuyajin.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhifuyajinEntity zhifuyajin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhifuyajin);
        zhifuyajinService.insert(zhifuyajin);
        return R.ok().put("data",zhifuyajin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhifuyajinEntity zhifuyajin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhifuyajin);
        //全部更新
        zhifuyajinService.updateById(zhifuyajin);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhifuyajinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
