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

import com.entity.TushuguihaiEntity;
import com.entity.view.TushuguihaiView;

import com.service.TushuguihaiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书归还
 * 后端接口
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
@RestController
@RequestMapping("/tushuguihai")
public class TushuguihaiController {
    @Autowired
    private TushuguihaiService tushuguihaiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushuguihaiEntity tushuguihai,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TushuguihaiEntity> ew = new EntityWrapper<TushuguihaiEntity>();

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
		PageUtils page = tushuguihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuguihai), params), params));
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
    public R list(@RequestParam Map<String, Object> params,TushuguihaiEntity tushuguihai,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date guihaishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date guihaishijianend,
                @RequestParam(required = false) Double jieyueshizhangstart,
                @RequestParam(required = false) Double jieyueshizhangend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TushuguihaiEntity> ew = new EntityWrapper<TushuguihaiEntity>();
        if(guihaishijianstart!=null) ew.ge("guihaishijian", guihaishijianstart);
        if(guihaishijianend!=null) ew.le("guihaishijian", guihaishijianend);
        if(jieyueshizhangstart!=null) ew.ge("jieyueshizhang", jieyueshizhangstart);
        if(jieyueshizhangend!=null) ew.le("jieyueshizhang", jieyueshizhangend);

        //查询结果
		PageUtils page = tushuguihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuguihai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushuguihaiEntity tushuguihai){
       	EntityWrapper<TushuguihaiEntity> ew = new EntityWrapper<TushuguihaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushuguihai, "tushuguihai"));
        return R.ok().put("data", tushuguihaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushuguihaiEntity tushuguihai){
        EntityWrapper< TushuguihaiEntity> ew = new EntityWrapper< TushuguihaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushuguihai, "tushuguihai"));
		TushuguihaiView tushuguihaiView =  tushuguihaiService.selectView(ew);
		return R.ok("查询图书归还成功").put("data", tushuguihaiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushuguihaiEntity tushuguihai = tushuguihaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tushuguihai,deSens);
        return R.ok().put("data", tushuguihai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushuguihaiEntity tushuguihai = tushuguihaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tushuguihai,deSens);
        return R.ok().put("data", tushuguihai);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushuguihaiEntity tushuguihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuguihai);
        tushuguihaiService.insert(tushuguihai);
        return R.ok().put("data",tushuguihai.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushuguihaiEntity tushuguihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuguihai);
        tushuguihaiService.insert(tushuguihai);
        return R.ok().put("data",tushuguihai.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushuguihaiEntity tushuguihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuguihai);
        //全部更新
        tushuguihaiService.updateById(tushuguihai);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushuguihaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
