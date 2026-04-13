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

import com.entity.ShenqingjieyueEntity;
import com.entity.view.ShenqingjieyueView;

import com.service.ShenqingjieyueService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 申请借阅
 * 后端接口
 * @author 
 * @email 
 * @date 2026-02-20 17:41:34
 */
@RestController
@RequestMapping("/shenqingjieyue")
public class ShenqingjieyueController {
    @Autowired
    private ShenqingjieyueService shenqingjieyueService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingjieyueEntity shenqingjieyue,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShenqingjieyueEntity> ew = new EntityWrapper<ShenqingjieyueEntity>();

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
		PageUtils page = shenqingjieyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingjieyue), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShenqingjieyueEntity shenqingjieyue,
                @RequestParam(required = false) Double tushuyajinstart,
                @RequestParam(required = false) Double tushuyajinend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shenqingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shenqingshijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShenqingjieyueEntity> ew = new EntityWrapper<ShenqingjieyueEntity>();
        if(tushuyajinstart!=null) ew.ge("tushuyajin", tushuyajinstart);
        if(tushuyajinend!=null) ew.le("tushuyajin", tushuyajinend);
        if(shenqingshijianstart!=null) ew.ge("shenqingshijian", shenqingshijianstart);
        if(shenqingshijianend!=null) ew.le("shenqingshijian", shenqingshijianend);

        //查询结果
		PageUtils page = shenqingjieyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingjieyue), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingjieyueEntity shenqingjieyue){
       	EntityWrapper<ShenqingjieyueEntity> ew = new EntityWrapper<ShenqingjieyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingjieyue, "shenqingjieyue"));
        return R.ok().put("data", shenqingjieyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingjieyueEntity shenqingjieyue){
        EntityWrapper< ShenqingjieyueEntity> ew = new EntityWrapper< ShenqingjieyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingjieyue, "shenqingjieyue"));
		ShenqingjieyueView shenqingjieyueView =  shenqingjieyueService.selectView(ew);
		return R.ok("查询申请借阅成功").put("data", shenqingjieyueView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingjieyueEntity shenqingjieyue = shenqingjieyueService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shenqingjieyue,deSens);
        return R.ok().put("data", shenqingjieyue);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingjieyueEntity shenqingjieyue = shenqingjieyueService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shenqingjieyue,deSens);
        return R.ok().put("data", shenqingjieyue);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShenqingjieyueEntity shenqingjieyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingjieyue);
        shenqingjieyueService.insert(shenqingjieyue);
        return R.ok().put("data",shenqingjieyue.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingjieyueEntity shenqingjieyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingjieyue);
        shenqingjieyueService.insert(shenqingjieyue);
        return R.ok().put("data",shenqingjieyue.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShenqingjieyueEntity shenqingjieyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingjieyue);
        //全部更新
        shenqingjieyueService.updateById(shenqingjieyue);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShenqingjieyueEntity> list = new ArrayList<ShenqingjieyueEntity>();
        for(Long id : ids) {
            ShenqingjieyueEntity shenqingjieyue = shenqingjieyueService.selectById(id);
            shenqingjieyue.setSfsh(sfsh);
            shenqingjieyue.setShhf(shhf);
            list.add(shenqingjieyue);
        }
        shenqingjieyueService.updateBatchById(list);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shenqingjieyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
