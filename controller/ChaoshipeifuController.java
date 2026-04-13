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

import com.entity.ChaoshipeifuEntity;
import com.entity.view.ChaoshipeifuView;

import com.service.ChaoshipeifuService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 超时赔付
 * 后端接口
 * @author 
 * @email 
 * @date 2026-02-20 17:41:35
 */
@RestController
@RequestMapping("/chaoshipeifu")
public class ChaoshipeifuController {
    @Autowired
    private ChaoshipeifuService chaoshipeifuService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChaoshipeifuEntity chaoshipeifu,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChaoshipeifuEntity> ew = new EntityWrapper<ChaoshipeifuEntity>();

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
		PageUtils page = chaoshipeifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chaoshipeifu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChaoshipeifuEntity chaoshipeifu,
                @RequestParam(required = false) Double kejietianshustart,
                @RequestParam(required = false) Double kejietianshuend,
                @RequestParam(required = false) Double tushuyajinstart,
                @RequestParam(required = false) Double tushuyajinend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date peifushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date peifushijianend,
                @RequestParam(required = false) Double jieyueshizhangstart,
                @RequestParam(required = false) Double jieyueshizhangend,
                @RequestParam(required = false) Double chaochushizhangstart,
                @RequestParam(required = false) Double chaochushizhangend,
                @RequestParam(required = false) Double chaoshijinestart,
                @RequestParam(required = false) Double chaoshijineend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChaoshipeifuEntity> ew = new EntityWrapper<ChaoshipeifuEntity>();
        if(kejietianshustart!=null) ew.ge("kejietianshu", kejietianshustart);
        if(kejietianshuend!=null) ew.le("kejietianshu", kejietianshuend);
        if(tushuyajinstart!=null) ew.ge("tushuyajin", tushuyajinstart);
        if(tushuyajinend!=null) ew.le("tushuyajin", tushuyajinend);
        if(peifushijianstart!=null) ew.ge("peifushijian", peifushijianstart);
        if(peifushijianend!=null) ew.le("peifushijian", peifushijianend);
        if(jieyueshizhangstart!=null) ew.ge("jieyueshizhang", jieyueshizhangstart);
        if(jieyueshizhangend!=null) ew.le("jieyueshizhang", jieyueshizhangend);
        if(chaochushizhangstart!=null) ew.ge("chaochushizhang", chaochushizhangstart);
        if(chaochushizhangend!=null) ew.le("chaochushizhang", chaochushizhangend);
        if(chaoshijinestart!=null) ew.ge("chaoshijine", chaoshijinestart);
        if(chaoshijineend!=null) ew.le("chaoshijine", chaoshijineend);

        //查询结果
		PageUtils page = chaoshipeifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chaoshipeifu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChaoshipeifuEntity chaoshipeifu){
       	EntityWrapper<ChaoshipeifuEntity> ew = new EntityWrapper<ChaoshipeifuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chaoshipeifu, "chaoshipeifu"));
        return R.ok().put("data", chaoshipeifuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChaoshipeifuEntity chaoshipeifu){
        EntityWrapper< ChaoshipeifuEntity> ew = new EntityWrapper< ChaoshipeifuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chaoshipeifu, "chaoshipeifu"));
		ChaoshipeifuView chaoshipeifuView =  chaoshipeifuService.selectView(ew);
		return R.ok("查询超时赔付成功").put("data", chaoshipeifuView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChaoshipeifuEntity chaoshipeifu = chaoshipeifuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chaoshipeifu,deSens);
        return R.ok().put("data", chaoshipeifu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChaoshipeifuEntity chaoshipeifu = chaoshipeifuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chaoshipeifu,deSens);
        return R.ok().put("data", chaoshipeifu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChaoshipeifuEntity chaoshipeifu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chaoshipeifu);
        chaoshipeifuService.insert(chaoshipeifu);
        return R.ok().put("data",chaoshipeifu.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChaoshipeifuEntity chaoshipeifu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chaoshipeifu);
        chaoshipeifuService.insert(chaoshipeifu);
        return R.ok().put("data",chaoshipeifu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChaoshipeifuEntity chaoshipeifu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chaoshipeifu);
        //全部更新
        chaoshipeifuService.updateById(chaoshipeifu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chaoshipeifuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
