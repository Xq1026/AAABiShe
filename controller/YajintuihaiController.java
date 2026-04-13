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

import com.entity.YajintuihaiEntity;
import com.entity.view.YajintuihaiView;

import com.service.YajintuihaiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 押金退还
 * 后端接口
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
@RestController
@RequestMapping("/yajintuihai")
public class YajintuihaiController {
    @Autowired
    private YajintuihaiService yajintuihaiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YajintuihaiEntity yajintuihai,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YajintuihaiEntity> ew = new EntityWrapper<YajintuihaiEntity>();

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
		PageUtils page = yajintuihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yajintuihai), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YajintuihaiEntity yajintuihai,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tuihaishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date tuihaishijianend,
                @RequestParam(required = false) Double jieyueshizhangstart,
                @RequestParam(required = false) Double jieyueshizhangend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YajintuihaiEntity> ew = new EntityWrapper<YajintuihaiEntity>();
        if(tuihaishijianstart!=null) ew.ge("tuihaishijian", tuihaishijianstart);
        if(tuihaishijianend!=null) ew.le("tuihaishijian", tuihaishijianend);
        if(jieyueshizhangstart!=null) ew.ge("jieyueshizhang", jieyueshizhangstart);
        if(jieyueshizhangend!=null) ew.le("jieyueshizhang", jieyueshizhangend);

        //查询结果
		PageUtils page = yajintuihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yajintuihai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YajintuihaiEntity yajintuihai){
       	EntityWrapper<YajintuihaiEntity> ew = new EntityWrapper<YajintuihaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yajintuihai, "yajintuihai"));
        return R.ok().put("data", yajintuihaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YajintuihaiEntity yajintuihai){
        EntityWrapper< YajintuihaiEntity> ew = new EntityWrapper< YajintuihaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yajintuihai, "yajintuihai"));
		YajintuihaiView yajintuihaiView =  yajintuihaiService.selectView(ew);
		return R.ok("查询押金退还成功").put("data", yajintuihaiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YajintuihaiEntity yajintuihai = yajintuihaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yajintuihai,deSens);
        return R.ok().put("data", yajintuihai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YajintuihaiEntity yajintuihai = yajintuihaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yajintuihai,deSens);
        return R.ok().put("data", yajintuihai);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YajintuihaiEntity yajintuihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yajintuihai);
        yajintuihaiService.insert(yajintuihai);
        return R.ok().put("data",yajintuihai.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YajintuihaiEntity yajintuihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yajintuihai);
        yajintuihaiService.insert(yajintuihai);
        return R.ok().put("data",yajintuihai.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YajintuihaiEntity yajintuihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yajintuihai);
        //全部更新
        yajintuihaiService.updateById(yajintuihai);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yajintuihaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
