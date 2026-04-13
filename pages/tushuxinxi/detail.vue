
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback" @scroll="scrollChange">
	<view class="content">
		<view class="container" :style='{"minHeight":"100vh","width":"100%","padding":"0","position":"relative","background":"#fff","height":"auto"}'>
			<swiper :style='{"width":"100%","background":"#fff","height":"440rpx","zIndex":"0"}' class="swiper" :indicator-dots='false' :autoplay='false' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","background":"#fff","height":"440rpx"}' v-for="(swiper,index) in swiperList" :key="index">
					<img :style='{"width":"100%","objectFit":"cover","display":"block","height":"440rpx"}' v-if="swiper.substring(0,4)=='http'" :src="swiper" @tap="imgView(swiper)">
					<img :style='{"width":"100%","objectFit":"cover","display":"block","height":"440rpx"}' v-else :src="baseUrl+swiper" @tap="imgView(baseUrl+swiper)">
				</swiper-item>
			</swiper>
			<view :style='{"alignContent":"flex-start","padding":"0","margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","height":"auto","zIndex":"9"}' class="detail-content">
				<view :style='{"padding":"0","margin":"0px 0 0 0","borderColor":"#ccc","display":"flex","justifyContent":"flex-end","borderRadius":"0","flexWrap":"wrap","borderWidth":"0 0 0px 0","background":"#d3e5ff","width":"100%","position":"relative","borderStyle":"solid","height":"80rpx","zIndex":"999"}' class="detail-list-item price">
					<view :style='{"margin":"12rpx 20rpx 0 0","display":"flex"}' v-if="storeupFlag==1" @click="shoucang">
						<text class="icon iconfont icon-shoucang12" :style='{"padding":" 0 10rpx","margin":"0 0px 0 0","color":"#ffc441","borderRadius":"8rpx","background":"#303230","lineHeight":"56rpx","fontSize":"32rpx","order":"2","height":"56rpx"}'></text>
						<text :style='{"margin":"0 10rpx 0 0","lineHeight":"56rpx","fontSize":"30rpx","color":"#666"}'>已收藏</text>
					</view>
					<view :style='{"margin":"12rpx 20rpx 0 0","display":"flex"}' v-if="storeupFlag==0" @click="shoucang">
						<text class="icon iconfont icon-shoucang10" :style='{"padding":" 0 10rpx","margin":"0 0px 0 0","color":"#fff","borderRadius":"8rpx","background":"#303230","lineHeight":"56rpx","fontSize":"32rpx","order":"2","height":"56rpx"}'></text>
						<text :style='{"margin":"0 10rpx 0 0","lineHeight":"56rpx","fontSize":"30rpx","color":"#666"}'>收藏</text>
					</view>
				</view>

				<view :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="lable">图书名称：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text" >{{detail.tushumingcheng}}</view>
				</view>
				<view :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="lable">图书状态：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text" >{{detail.tushuzhuangtai}}</view>
				</view>
				<view :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}' class="lable">图书押金：</view>
					<view :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' class="text" >{{detail.tushuyajin}}</view>
				</view>

				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>图书编号：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.tushubianhao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>图书类型：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.tushuleixing}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>图书作者：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.tushuzuozhe}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>作者国籍：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.zuozheguoji}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>图书语言：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.tushuyuyan}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>出版公司：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.chubangongsi}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>图书标签：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.tushubiaoqian}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>受众群体：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.shouzhongqunti}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>可借天数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.kejietianshu}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>借书地点：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.jieshudidian}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>用户账号：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.yonghuzhanghao}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>用户姓名：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.yonghuxingming}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>点击次数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.clicknum}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>评论数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.discussnum}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>评分：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.totalscore}}</view>
				</view>
				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>收藏数：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}' >{{detail.storeupnum}}</view>
				</view>

				<view :style='{"padding":"0 20rpx 40rpx 50%","margin":"0","background":"#fff","display":"flex","width":"100%","justifyContent":"center","order":"4"}'>
					<view :style='{"margin":"0","borderRadius":"60rpx 0 0 60rpx","color":"#fff","background":"#174add","display":"flex","width":"50%","fontSize":"30rpx","justifyContent":"center","height":"auto"}' class="detail-list-item" v-if="!thumbsupFlag&&!crazilyFlag" @tap="zan">
						<view :style='{"padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"inherit","color":"inherit","textAlign":"right"}' class="lable">赞</view>
						<view :style='{"color":"inherit","lineHeight":"80rpx","fontSize":"inherit"}'>{{detail.thumbsupnum}}</view>
						<view :style='{"margin":" 0 0 0 10rpx","lineHeight":"80rpx","fontSize":"inherit","color":"inherit"}' class="icon iconfont icon-zan10"></view>
					</view>
					<view :style='{"margin":"0","borderRadius":"60rpx","color":"#fff","background":"#174add","display":"flex","width":"100%","fontSize":"30rpx","justifyContent":"center","height":"auto"}' class="detail-list-item" v-if="thumbsupFlag" @tap="zan">
						<view :style='{"padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"inherit","color":"inherit","textAlign":"right"}' class="lable">取消赞</view>
						<view :style='{"color":"inherit","lineHeight":"80rpx","fontSize":"inherit"}'>{{detail.thumbsupnum}}</view>
						<view :style='{"margin":" 0 0 0 10rpx","lineHeight":"80rpx","fontSize":"inherit","color":"inherit"}' class="icon iconfont icon-zan10"></view>
					</view>
					<view :style='{"margin":"0","borderRadius":"0 60rpx 60rpx 0","color":"#666","background":"#f1f1f1","display":"flex","width":"50%","fontSize":"30rpx","justifyContent":"center","height":"auto"}' class="detail-list-item" v-if="!thumbsupFlag&&!crazilyFlag" @tap="cai">
						<view :style='{"padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"inherit","color":"inherit","textAlign":"right"}' class="lable">踩</view>
						<view :style='{"color":"inherit","lineHeight":"80rpx","fontSize":"inherit"}'>{{detail.crazilynum}}</view>
						<view :style='{"margin":" 0 0 0 10rpx","lineHeight":"80rpx","fontSize":"inherit","color":"inherit"}' class="icon iconfont icon-cai11"></view>
					</view>
					<view :style='{"margin":"0","borderRadius":"60rpx","color":"#666","background":"#f1f1f1","display":"flex","width":"100%","fontSize":"30rpx","justifyContent":"center","height":"auto"}' class="detail-list-item" v-if="crazilyFlag" @tap="cai">
						<view :style='{"padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"inherit","color":"inherit","textAlign":"right"}' class="lable">取消踩</view>
						<view :style='{"color":"inherit","lineHeight":"80rpx","fontSize":"inherit"}'>{{detail.crazilynum}}</view>
						<view :style='{"margin":" 0 0 0 10rpx","lineHeight":"80rpx","fontSize":"inherit","color":"inherit"}' class="icon iconfont icon-cai11"></view>
					</view>
				</view>


				<view class="detail-list-item" :style='{"padding":"0 20rpx","boxShadow":"none","margin":"10rpx","borderColor":"#ccc","borderRadius":"20rpx","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 20rpx 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"28rpx"}'>图书简介：</view>
					<view class="text" :style='{"padding":"0px","margin":"0px","lineHeight":"80rpx","fontSize":"28rpx","color":"rgb(0, 0, 0)"}'>{{detail.tushujianjie}}</view>
				</view>




				<view class="time-content" :style='{"width":"100%","padding":"0 24rpx","margin":"40rpx 0 24rpx 0","height":"auto","order":"10"}'>
					<view class="comoment-header" :style='{"border":"2rpx solid #174add","padding":"0 0 0 20rpx","margin":"0 0 40rpx 0","borderRadius":"60rpx","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<view :style='{"padding":"0 24rpx","lineHeight":"80rpx","fontSize":"32rpx","color":"#333","flex":"1"}'>评论</view>
						<view :style='{"padding":"0 30rpx","borderRadius":"60rpx","textAlign":"center","background":"#174add","display":"flex"}' @click="onCommentTap" class="btn-comment-content" style="display: flex;align-items: center;">
							<view :style='{"margin":"0 8rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff","display":"none","order":"2"}' class="cuIcon-add"></view>
							<view :style='{"margin":"0 10rpx 0 0","lineHeight":"80rpx","fontSize":"30rpx","color":"#fff"}'>添加评论</view>
						</view>
					</view>
				
					<view :style='{"border":"2rpx solid #dddddd","padding":"24rpx","margin":"24rpx 0 0 0","borderRadius":"20rpx","background":"none","width":"100%","position":"relative","height":"auto"}' v-for="(item,index) in commentList" v-bind:key="index" class="cu-item comment-item">
						<view :style='{"position":"absolute","right":"20rpx","top":"20rpx","background":"none"}' v-if="item.istop">
							<span class="icon iconfont icon-jiantou24" :style='{"color":"#666","fontSize":"40rpx"}'></span>
						</view>
						<view :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}'>
							<image :style='{"width":"76rpx","margin":"0 8rpx 0 0","borderRadius":"100%","display":"block","height":"76rpx"}' v-if="item.avatarurl" mode="aspectFill" :src="baseUrl+item.avatarurl"></image>
							<view :style='{"color":"#333","lineHeight":"60rpx","fontSize":"32rpx"}' class="text-grey">{{item.nickname}}</view>
						</view>
						<view :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"30rpx","color":"#333"}' class="text-gray text-content text-df">
							<rich-text :nodes="item.content"></rich-text>
						</view>
						<view :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"30rpx","color":"#333"}' class="text-gray text-content text-df">
							<uni-rate disabled :value="item.score" disabled-color="#ffca3e" />
						</view>
						<view :style='{"width":"100%","margin":"16rpx 0 0 0","alignItems":"center","justifyContent":"flex-end","display":"flex","height":"60rpx"}'>
							<view v-if="!comzanChange(item)&&!comcaiChange(item)" :style='{"alignItems":"center","margin":"0 20rpx 0 0","display":"flex"}' @click="comzanClick(item)">
								<span class="icon iconfont icon-zan07" :style='{"fontSize":"28rpx"}'></span>
								<span :style='{"fontSize":"28rpx","display":"none"}'>赞</span>
								<span :style='{"fontSize":"28rpx"}'>({{item.thumbsupnum}})</span>
							</view>
							<view v-if="comzanChange(item)" :style='{"margin":"0 20rpx 0 0","background":"none"}' @click="comzanClick(item)">
								<span class="icon iconfont icon-zan11" :style='{"color":"#ffc441","fontSize":"28rpx"}'></span>
								<span :style='{"color":"#ffc441","fontSize":"28rpx","display":"none"}'>已赞</span>
								<span :style='{"color":"#ffc441","fontSize":"28rpx"}'>({{item.thumbsupnum}})</span>
							</view>
							<view v-if="!comzanChange(item)&&!comcaiChange(item)" :style='{"alignItems":"center","display":"flex"}' @click="comcaiClick(item)">
								<span class="icon iconfont icon-cai15" :style='{"fontSize":"28rpx"}'></span>
								<span :style='{"fontSize":"28rpx","display":"none"}'>踩</span>
								<span :style='{"fontSize":"28rpx"}'>({{item.crazilynum}})</span>
							</view>
							<view v-if="comcaiChange(item)" :style='{"background":"none"}' @click="comcaiClick(item)">
								<span class="icon iconfont icon-cai16" :style='{"color":"#ffc441","fontSize":"28rpx"}'></span>
								<span :style='{"color":"#ffc441","fontSize":"28rpx","display":"none"}'>已踩</span>
								<span :style='{"color":"#ffc441","fontSize":"28rpx"}'>({{item.crazilynum}})</span>
							</view>
						</view>
						<view :style='{"width":"100%","lineHeight":"48rpx","fontSize":"28rpx","color":"#999","textAlign":"left"}' class="margin-top-sm text-gray text-df">{{item.addtime}}</view>
						<view v-if="item.reply" :style='{"margin":"8rpx 0","lineHeight":"1.5","fontSize":"30rpx","color":"#333"}' class="text-gray text-content text-df">
							回复:<rich-text :nodes="item.reply"></rich-text>
						</view>
						<view style="display: flex;display: flex;justify-content: flex-end;padding: 6rpx 0;" v-if="user&&user.id==item.userid">
							<view style="color: #999;font-size: 16rpx;" @click="delClick(item.id)">删除</view>
						</view>
					</view>
				</view>

				<view class="bottom-content bg-white tabbar border shop" :style='{"padding":"0 24rpx","margin":"40rpx auto","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto","order":"20"}'>

					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#174add","borderRadius":"8rpx","background":"#d3e5ff","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-if="userid&&isAuth('tushuxinxi','借阅')" @tap="onAcrossTap('shenqingjieyue','','','tushuzhuangtai','已借出',tushuzhuangtaiCrossSelect[0])" class="cu-btn bg-brown round shadow-blur" >借阅</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#174add","borderRadius":"8rpx","background":"#d3e5ff","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('tushuxinxi','借阅')" @tap="onAcrossTap('shenqingjieyue','','','tushuzhuangtai','已借出',tushuzhuangtaiCrossSelect[0])" class="cu-btn bg-brown round shadow-blur" >借阅</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#174add","borderRadius":"8rpx","background":"#d3e5ff","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-if="userid&&isAuth('tushuxinxi','私聊')" @tap="chatClick">联系TA</button>
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#174add","borderRadius":"8rpx","background":"#d3e5ff","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-if="!userid&&isAuthFront('tushuxinxi','私聊')" @tap="chatClick">联系TA</button>
					<!-- #ifdef MP-WEIXIN -->
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#fff","borderRadius":"8rpx","background":"#22c0f5","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' open-type="share">分享</button>
					<!-- #endif -->
					<!-- #ifdef APP-PLUS -->
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#fff","borderRadius":"8rpx","background":"#22c0f5","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' @click="uniShare">分享</button>
					<!-- #endif -->
					<!-- #ifdef H5 -->
					<button :style='{"border":"0","padding":"0 20rpx","boxShadow":"none","margin":"0 10rpx 10rpx 0","color":"#fff","borderRadius":"8rpx","background":"#22c0f5","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' @click="shareClick">分享</button>
					<!-- #endif -->
				</view>
			</view>
		</view>
	</view>
</mescroll-uni>
	<!-- #ifdef H5 -->
	<view class="shareBG" v-if="shareShow" @click="shareShow = false"></view>
	<view class="shareBox" :class="shareShow?'shareBoxActive':''">
		<view class="shareView" @click="shareToMicroblog">
			<img src="@/static/share/weibo.png" style="width: 80%;" alt="">
			<view class="shareText">微博</view>
		</view>
		<view class="shareView" @click="shareToQQRom">
			<img src="@/static/share/qqkongjian.png" style="width: 80%;" alt="">
			<view class="shareText">QQ空间</view>
		</view>
	</view>
	<!-- #endif -->
	<uni-popup class="popup-content" ref="chatPopup" type="bottom" :maskClick="true" @change="clearChat">
		<view class="popup-chat">
			<scroll-view :scrollTop="scrollTop2" scroll-y="true" style="background: #eee;">
				<view class="chat-content" id="chat-content">
					<view v-bind:key="item.id" v-for="item in chatList">
						<div v-if="item.addtime" style="width: 100%;text-align: center;font-size: 10px;color: #666;">{{timeFormat(item.addtime)}}</div>
						<view v-if="item.uid==user.id" class="right-content">
							<view v-if="item.format==1" class="text-content">{{item.content}}</view>
							<img v-else-if="item.format==2" :src="item.content?baseUrl + item.content:''" @click="preViewImg(baseUrl + item.content)"
								style="width: 100px;height: 100px;object-fit: cover;" />
							<video :src="baseUrl + item.content" v-else-if="item.format==3" style="width: 150px;" controls></video>
							<view v-else-if="item.format==5" class="voice-content" @click="playVoice(baseUrl + item.content,item.id)">
								<text class="voice-icon">{{playingAudioId != item.id ? '🔊' : '⏸'}}</text>
							</view>
							<img :src="mpic?baseUrl + mpic:''" alt=""
								style="width: 40px;border-radius: 50%;height: 40px;margin: 0 0 0 10px;object-fit: cover;" />
						</view>
						<view v-else class="left-content">
							<img :src="fpic?baseUrl + fpic:''" alt=""
								style="width: 40px;border-radius: 50%;height: 40px;margin: 0 10px 0 0;object-fit: cover;" />
							<view v-if="item.format==1" class="text-content">{{item.content}}</view>
							<img v-else-if="item.format==2" :src="item.content?baseUrl + item.content:''" @click="preViewImg(baseUrl + item.content)"
								style="width: 100px;height: 100px;object-fit: cover;" />
							<video :src="baseUrl + item.content" v-else-if="item.format==3" style="width: 150px;" controls></video>
							<view v-else-if="item.format==5" class="voice-content" @click="playVoice(baseUrl + item.content,item.id)">
								<text class="voice-icon">{{playingAudioId != item.id ? '🔊' : '⏸'}}</text>
							</view>
						</view>
						<view class="clear-float"></view>
					</view>
				</view>
			</scroll-view>
			<view style="">
				<input v-model="chatForm.content" placeholder="请输入内容" confirm-type="send" @confirm="addChat"
					style="width: calc(100% - 20px);font-size: 14px;background: #eee;margin: 0 10px 10px;padding: 0 10px;">
				</input>
				<view style="display: flex;justify-content: space-around;">
					<button @click="addChat" style="width: auto;padding: 0 10px;background: #29A19C;font-size: 14px;border: none;color: #fff;">发送</button>
					<button class="voice-btn" :class="isRecording ? 'recording' : ''" @click="toggleRecord">
						{{isRecording ? '停止录音(' + recordDuration + 's)' : '开始录音'}}
					</button>
					<button @click="uploadSuccess" style="width: auto;padding: 0 10px;background: #0BB2C7;font-size: 14px;border: none;color: #fff;">上传图片</button>
					<button @click="uploadSuccess2" style="width: auto;padding: 0 10px;background: #0BB2C7;font-size: 14px;border: none;color: #fff;">上传视频</button>
					<button v-if="showSaveType" @click="saveGood" style="width: auto;padding: 0 10px;background: #eebebf;font-size: 14px;border: none;color: #fff;">详情图发送</button>
				</view>
				
			</view>
		</view>
	</uni-popup>
</view>
</template>

<script>
	// #ifdef APP-PLUS
	import UniShare from 'components/uni-share/js_sdk/uni-share.js';
	const uniShare = new UniShare();
	// #endif
	import uniRate from "@/components/uni-rate/uni-rate.vue";
	import timeMethod from '@/utils/timeMethod'
	export default {
		// #ifdef APP-PLUS
		onBackPress({from}) {
			if(from=='backbutton'){
				this.$nextTick(function(){
					uniShare.hide()
				})
				return uniShare.isShow;
			}
		},
		// #endif
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
				userid: '',
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
					onScroll: true,
					toTop: true
				},
				hasNext: true,
				user: {},
				storeupFlag: 0,
				thumbsupFlag: 0,
				crazilyFlag: 0,
				tushuzhuangtaiCrossSelect:'已借出,未借出'.split(','),
				count: 0,
				timer: null,
				title:'',
				// #ifdef APP-PLUS
				href: '',
				// #endif
				// #ifdef H5
				shareShow: false,
				shareUrl: location.href,
				// #endif
				chatList: [],
				scrollTop2: 0,
				chatForm: {
					content: ''
				},
				fpic: '',
				fname: '',
				fid: '',
				mpic: uni.getStorageSync('frontHeadportrait'),
				// 语音聊天
				recorderManager: null,
				isRecording: false,
				recordDuration: 0,
				recordTimer: null,
				playingAudioId: null,
				innerAudioContext: null,
				// H5环境录音相关
				mediaRecorder: null,
				audioChunks: [],
				audioStream: null,
				showSaveType: true,
				scrollTop: 0,
			}
		},
		components: {
			uniRate,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			username() {
				return uni.getStorageSync("nickname")
			},
		},
		async onLoad(options) {
			// #ifdef APP-PLUS
			let page = getCurrentPages()
			this.href = this.baseUrl + 'front/h5/#/' + page[page.length - 1].route
			// #endif
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.id = options.id;
			if(options.userid) {
				this.userid = options.userid;
			}
			// 渲染数据
			this.init();
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		// #ifdef MP-WEIXIN
		onShareAppMessage(){
			var obj = {
				title: this.title,
				imageUrl: this.swiperList[0]?this.baseUrl + this.swiperList[0]: ''
			}
			return obj
		},
		// #endif
		onUnload() {
			if(this.timer) {
				clearInterval(this.timer);
			}
		},
		async onShow(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.getStoreup();
			this.getThumbsup();
			let cleanType = uni.getStorageSync('discusstushuxinxiCleanType')
			if(cleanType){
				uni.removeStorageSync('discusstushuxinxiCleanType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
				this.init(2);
			}
			let crossCleanType = uni.getStorageSync('crossCleanType')
			if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
				res = await this.$api.info('tushuxinxi', this.id);
				let reg=new RegExp('http://localhost:8080/xiaoyuan1rxvwvck/upload','g')//g代表全部
				this.detail = res.data;
				this.title = this.detail.tushumingcheng
			}
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			scrollChange(e){
				this.scrollTop = e.scrollTop
			},
			scrollTopClick(){
				uni.pageScrollTo({
					scrollTop: 0
				})
			},
			imgView(url){
				let arr = []
				for(let x in this.swiperList){
					arr.push(this.swiperList[x].substr(0,4)=='http'?this.swiperList[x]:this.baseUrl + this.swiperList[x])
				}
				uni.previewImage({
					current: url,
					urls: arr
				})
			},
			// 拨打电话
			callClick(row){
				uni.makePhoneCall({
					phoneNumber: row
				})
			},
			// #ifdef H5
			// 分享微博
			shareToMicroblog() {
				//跳转地址
				window.open(
					"https://service.weibo.com/share/share.php?url=" +
					encodeURIComponent(this.shareUrl) +
					"&title=" + this.title
				);
			},
			// 分享qq空间
			shareToQQRom() {
				//跳转地址
				window.open(
					"https://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=" +
					encodeURIComponent(this.shareUrl) +
					"&title=" +
					this.title +
					"&summary=" +
					this.title
				);
			},
			shareClick(){
				this.shareShow = true
			},
			// #endif
			// #ifdef APP-PLUS
			uniShare() {
				uniShare.show({
					content: { //公共的分享参数配置  类型（type）、链接（herf）、标题（title）、summary（描述）、imageUrl（缩略图）
						type: 0,
						href: this.href,
						title: this.title,
						summary: this.title,
						imageUrl: this.swiperList[0]?this.baseUrl + this.swiperList[0]: ''
					},
					menus: [{
							"img": "/static/share/weixin.png",
							"text": "微信好友",
							"share": { //当前项的分享参数配置。可覆盖公共的配置如下：分享到微信小程序，配置了type=5
								"provider": "weixin",
								"scene": "WXSceneSession"
							}
						},
						{
							"img": "/static/share/pengyouquan.png",
							"text": "微信朋友圈",
							"share": {
								"provider": "weixin",
								"scene": "WXSceneTimeline"
							}
						},
						{
							"img": "/static/share/xiaochengxu.png",
							"text": "微信小程序",
							"share": {
								provider: "weixin",
								scene: "WXSceneSession",
								type: 5,
								miniProgram: {
									id: '123',
									path: '/pages/huodongxinxi/list',
									webUrl: '/#/pages/huodongxinxi/list',
									type: 0
								},
							}
						},
						{
							"img": "/static/share/weibo.png",
							"text": "微博",
							"share": {
								"provider": "sinaweibo"
							}
						},
						{
							"img": "/static/share/qq.png",
							"text": "QQ",
							"share": {
								"provider": "qq"
							}
						},
						{
							"img": "/static/share/fuzhi.png",
							"text": "复制",
							"share": "copyurl"
						},
						{
							"img": "/static/share/gengduo.png",
							"text": "更多",
							"share": "shareSystem"
						}
					],
					cancelText: "取消分享",
				}, e => { //callback
				})
			},
			// #endif
			// 支付
			onPayTap(){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				uni.setStorageSync('paytable','tushuxinxi');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
			onDetailTap(item) {
				uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			// 收藏
			async getStoreup() {
				if(!this.user){
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid : this.id,
					tablename : 'tushuxinxi',
					userid: this.user.id,
					type: '1',
				}
				let res = await this.$api.list(`storeup`, params);
				this.storeupFlag = res.data.list.length;
			},
			async shoucang(){
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid : _this.detail.id,
					tablename : 'tushuxinxi',
					userid: _this.user.id,
					type: '1',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length == 1) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消',
						success: async function(res) {
							if (res.confirm) {
								_this.detail.storeupnum--
								await _this.$api.update('tushuxinxi',_this.detail)
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.$utils.msg('取消成功');
								_this.getStoreup();
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否收藏',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.tushumingcheng,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'tushuxinxi',
								type: '1'
							});
							_this.detail.storeupnum++
							await _this.$api.update('tushuxinxi',_this.detail)
							_this.$utils.msg('收藏成功');
							_this.getStoreup();
						}
					}
				});
			},
			// 跨表
			async onAcrossTap(tableName,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
				let that = this
				if(tableName == 'shenqingjieyue') {
					let nickname = uni.getStorageSync("nickname")
					if(this.detail.yonghuzhanghao == nickname) {
						this.$utils.msg('无操作权限');
						return false
					}
				}
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				uni.setStorageSync('crossTable','tushuxinxi');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(type=1){
				if(this.timer) {
					clearInterval(this.timer);
				}
				let res = await this.$api.info('tushuxinxi', this.id);
				if (res.data.touxiang) {
					this.fpic = res.data.touxiang.split(',')[0]
				} else if (res.data.headportrait) {
					this.fpic = res.data.headportrait.split(',')[0]
				}
				let reg=new RegExp('http://localhost:8080/xiaoyuan1rxvwvck/upload','g')//g代表全部
				this.detail = res.data;

				this.title = this.detail.tushumingcheng



				// 轮播图片
				this.swiperList = this.detail.tushufengmian ? this.detail.tushufengmian.split(",") : [];
				




















				if(type==2){
					this.detail.discussnum++
					await this.$api.update('tushuxinxi',this.detail)
				}
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				if(uni.getStorageSync("appUserid")){
					let res = await this.$api.list('discusstushuxinxi', {
						page: mescroll.num,
						limit: 10,
						refid: Number(this.id),
						sort: 'istop',
						order: 'desc',
					});
					// 如果是第一页数据置空
					if (mescroll.num == 1) this.commentList = [];
					for(let x in res.data.list){
						if(res.data.list[x].content){
							res.data.list[x].content = res.data.list[x].content.replace(/img src/gi,"img style=\"width:100%;\" src")
						}
					}
					this.commentList = this.commentList.concat(res.data.list);
					if (res.data.list.length == 0) this.hasNext = false;
				}
				mescroll.endSuccess(mescroll.size, this.hasNext);

			},
			comzanChange(row){
				if(row.tuserids){
					let arr = String(row.tuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							return true
						}
					}
				}
				return false
			},
			async comzanClick(row){
				if(!this.user){
					return false
				}
				if(!this.comzanChange(row)){
					row.thumbsupnum++
					if(row.tuserids){
						row.tuserids = row.tuserids + ',' + this.user.id
					}else {
						row.tuserids = this.user.id
					}
					await this.$api.update('discusstushuxinxi',row)
					this.$utils.msg('点赞成功');
				}else {
					row.thumbsupnum--
					let arr = String(row.tuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							arr.splice(x,1)
						}
					}
					row.tuserids = arr.join(',')
					await this.$api.update('discusstushuxinxi',row)
					this.$utils.msg('取消成功');
				}
				this.$forceUpdate()
			},
			comcaiChange(row){
				if(row.cuserids){
					let arr = String(row.cuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							return true
						}
					}
				}
				return false
			},
			async comcaiClick(row){
				if(!this.user){
					return false
				}
				if(!this.comcaiChange(row)){
					row.crazilynum++
					if(row.cuserids){
						row.cuserids = row.cuserids + ',' + this.user.id
					}else {
						row.cuserids = this.user.id
					}
					await this.$api.update('discusstushuxinxi',row)
					this.$utils.msg('点踩成功');
				}else {
					row.crazilynum--
					let arr = String(row.cuserids).split(',')
					for(let x in arr){
						if(arr[x] == this.user.id){
							arr.splice(x,1)
						}
					}
					row.cuserids = arr.join(',')
					await this.$api.update('discusstushuxinxi',row)
					this.$utils.msg('取消成功');
				}
				this.$forceUpdate()
			},



			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url ){
				if(!url){
					return false
				}
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							// #ifdef H5
							 window.open(url);
							// #endif
							// #ifndef H5
							uni.saveFile({
								tempFilePath: res.tempFilePath, //临时路径
								success: function(obj) {
									uni.showToast({
										icon: 'success',
										mask: true,
										title: '下载成功' , 
										duration: 2000,
									});
									setTimeout(() => {
										console.log('obj.savedFilePath',obj.savedFilePath);
										var filePath = obj.savedFilePath;
										uni.openDocument({ //新开页面打开文档，支持格式：doc, xls, ppt, pdf, docx, xlsx, pptx。
											filePath: filePath,
											showMenu: true,
											success: function(res) {
												console.log('打开文档成功');
											}
										});
									}, 2000)
								}
							});
							// #endif
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let res = {}
				let obj = {
					page: 1,
					limit: 1,
					refid: this.id,
					userid: uni.getStorageSync('appUserid')
				}
				res = await this.$api.page('discusstushuxinxi',obj)
				if(res.data.list.length){
					this.$utils.msg('每个人只能评论一次');
					return;
				}
				this.$utils.jump(`../discusstushuxinxi/add-or-update?refid=${this.id}` )
			},
			delClick(id){
				let that = this
				uni.showModal({
					title: '提示',
					content: '是否删除此评论？',
					async success(res) {
						if(res.confirm){
							await that.$api.del('discusstushuxinxi',JSON.stringify([id]))
							that.$utils.msg('删除成功')
							that.detail.discussnum--
							await that.$api.update('tushuxinxi',that.detail)
							setTimeout(()=>{
								that.mescroll.num = 1
								that.upCallback(that.mescroll)
							},1500)
						}
					}
				})
			},
			// 获取赞踩
			async getThumbsup() {
				if(!this.user){
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid: this.id,
					tablename: 'tushuxinxi',
					userid: this.user.id,
					type: '%2%',
				}
				let res = await this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					if(res.data.list[0].type=='21') {
						this.thumbsupFlag = 1;
					} else {
						this.crazilyFlag = 1;
					}
				}

			},
			// 点赞
			async zan() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid: _this.detail.id,
					tablename : 'tushuxinxi',
					userid: _this.user.id,
					type: '%2%',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消点赞',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.thumbsupnum = parseInt(_this.detail.thumbsupnum) - 1;
								await _this.$api.update('tushuxinxi', _this.detail);
								_this.$utils.msg('取消成功');
								_this.thumbsupFlag=0;
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否点赞',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.tushumingcheng,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'tushuxinxi',
								type: '21'
							});
							_this.detail.thumbsupnum = parseInt(_this.detail.thumbsupnum) + 1;
							await _this.$api.update('tushuxinxi', _this.detail);
							_this.$utils.msg('点赞成功');
							_this.thumbsupFlag=1;
						}
					}
				});
			},
			// 踩
			async cai() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid: _this.detail.id,
					tablename: 'tushuxinxi',
					userid: _this.user.id,
					type: '%2%',
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length > 0) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消点踩',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.crazilynum = parseInt(_this.detail.crazilynum) - 1;
								await _this.$api.update('tushuxinxi', _this.detail);
								_this.$utils.msg('取消成功');
								_this.crazilyFlag=0;
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否点踩',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.tushumingcheng,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'tushuxinxi',
								type: '22'
							});
							_this.detail.crazilynum = parseInt(_this.detail.crazilynum) + 1;
							await _this.$api.update('tushuxinxi', _this.detail);
							_this.$utils.msg('点踩成功');
							_this.crazilyFlag=1;
						}
					}
				});
			},
			
			async chatClick() {
				let that = this
				if(!this.user){
					this.$utils.msg("请先登录")
					setTimeout(()=>{
						that.$utils.jump('../login/login')
					},1500)
					return false
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
				if(this.detail.yonghuzhanghao == user.yonghuzhanghao){
					this.$utils.msg('不能给自己发信息！');
					return false
				}
				// 非角色聊天设置对了吗
				let res = await this.$api.query('yonghu',{
					yonghuzhanghao: this.detail.yonghuzhanghao
				})
				this.fid = res.data.id
				this.fname = res.data.yonghuzhanghao
				if (res.data.touxiang) {
					this.fpic = res.data.touxiang.split(',')[0]
				} else if (res.data.headportrait) {
					this.fpic = res.data.headportrait.split(',')[0]
				}
				// 初始化音频播放器（如果未初始化）
				if (!this.innerAudioContext) {
					this.innerAudioContext = uni.createInnerAudioContext();
					this.innerAudioContext.onEnded(() => {
						this.playingAudioId = null
					});
					this.innerAudioContext.onError((err) => {
						this.playingAudioId = null
						this.$utils.msg('播放失败')
					});
				}
				this.getChatList()
				uni.connectSocket({
					url: 'ws' + this.$base.url.split('http')[1] + '/ws?user_id=' + uni.getStorageSync("appUserid") + '&to_id=' + this.fid
				})
				uni.onSocketMessage((res)=> {
					this.getChatList()
				})
				this.$refs.chatPopup.open()
			},
			async saveGood(){
				this.showSaveType = false
				let _this = this;
				let res = await _this.$api.page('friend', {
					uid: _this.user.id,
					fid: _this.fid,
				})
				if(!res.data.list.length){
					await _this.$api.add('friend',{
						uid: _this.user.id,
						fid: _this.fid,
						name: _this.fname,
						picture: _this.fpic,
						type: 2,
						tablename:  'yonghu' ,
					})
					await _this.$api.add('friend',{
						fid: _this.user.id,
						uid: _this.fid,
						name: uni.getStorageSync("nickname"),
						picture: _this.mpic,
						type: 2,
						tablename: uni.getStorageSync("nowTable")
					})
				}
				await _this.$api.add('chatmessage',{
					uid: _this.user.id,
					fid: _this.fid,
					content: _this.swiperList[0],
					format: 2
				})
				_this.chatForm = {
					content: ''
				}
				uni.sendSocketMessage({
					data: _this.swiperList[0]
				})
				_this.getChatList()
			},
			formatMessages(messages) {
				let lastTime = null;
				messages.forEach((message, index) => {
					const currentTime = new Date(message.addtime).getTime();
					if (lastTime !== null) {
						const timeDiff = (currentTime - lastTime) / 1000 / 60; // 转换为分钟
						if (timeDiff < 3) {
							message.addtime = ''; // 如果小于3分钟，不显示时间
						}
					}
					lastTime = currentTime;
				});
				return messages;
			},
			timeFormat(time) {
				const Time = timeMethod.getTime(time).split("T");
				//当前消息日期属于周
				const week = timeMethod.getDateToWeek(time);
				//当前日期0时
				const nti = timeMethod.setTimeZero(timeMethod.getNowTime());
				//消息日期当天0时
				const mnti = timeMethod.setTimeZero(timeMethod.getTime(time));
				//计算日期差值
				const diffDate = timeMethod.calculateTime(nti, mnti);
				//本周一日期0时 （后面+1是去除当天时间）
				const fwnti = timeMethod.setTimeZero(timeMethod.countDateStr(-timeMethod.getDateToWeek(timeMethod
					.getNowTime()).weekID + 1));
				//计算周日期差值
				const diffWeek = timeMethod.calculateTime(mnti, fwnti);
			
				if (diffDate === 0) { //消息发送日期减去当天日期如果等于0则是当天时间
					return Time[1].slice(0, 5);
				} else if (diffDate < 172800000) { //当前日期减去消息发送日期小于2天（172800000ms）则是昨天-  一天最大差值前天凌晨00:00:00到今天晚上23:59:59
					return "昨天 " + Time[1].slice(0, 5);
				} else if (diffWeek >= 0) { //消息日期减去本周一日期大于0则是本周
					return week.weekName;
				} else { //其他时间则是日期
					return Time[0].slice(5, 10);
				}
			},
			async getChatList() {
				this.scrollTop2 = 0
				let res = await this.$api.mlist('chatmessage',{
					page: 1,
					limit: 1000,
					uid: this.user.id,
					fid: this.fid
				})
				this.chatList = this.formatMessages(res.data.list)
				setTimeout(() => {
					this.scrollTop2 = 1000000
				}, 100)
				
			},
			clearChat(e) {
				if(!e.show){
					uni.closeSocket()
				}
			},
			// 语音聊天功能 - 切换录音状态
			toggleRecord() {
				// 检查是否已选择聊天对象
				if (!this.fid || !this.user || !this.user.id) {
					this.$utils.msg('请先选择聊天对象')
					return;
				}
				
				if (this.isRecording) {
					// 如果正在录音，则停止
					this.stopRecord();
				} else {
					// 如果未录音，则开始
					this.startRecord();
				}
			},
			startRecord() {
				// #ifdef H5
				// H5环境使用浏览器MediaRecorder API
				this.startRecordH5();
				// #endif
				// #ifndef H5
				// 非H5环境使用uni-app录音管理器
				this.startRecordNative();
				// #endif
			},
			// H5环境录音
			async startRecordH5() {
				try {
					// 检查浏览器是否支持MediaRecorder
					if (!navigator.mediaDevices || !navigator.mediaDevices.getUserMedia) {
						this.$utils.msg('您的浏览器不支持录音功能')
						return;
					}
					
					// 获取麦克风权限
					const stream = await navigator.mediaDevices.getUserMedia({ audio: true });
					this.audioStream = stream;
					this.audioChunks = [];
					
					// 创建MediaRecorder
					const mimeType = MediaRecorder.isTypeSupported('audio/webm') ? 'audio/webm' : 
									MediaRecorder.isTypeSupported('audio/mp4') ? 'audio/mp4' : 
									'audio/webm';
					
					this.mediaRecorder = new MediaRecorder(stream, {
						mimeType: mimeType
					});
					
					this.mediaRecorder.ondataavailable = (event) => {
						if (event.data.size > 0) {
							this.audioChunks.push(event.data);
						}
					};
					
					this.mediaRecorder.onstop = () => {
						const audioBlob = new Blob(this.audioChunks, { type: this.mediaRecorder.mimeType });
						const audioUrl = URL.createObjectURL(audioBlob);
						
						// 将Blob转换为File对象用于上传
						const file = new File([audioBlob], 'recording.' + (mimeType.includes('webm') ? 'webm' : 'mp4'), {
							type: mimeType
						});
						
						// 停止所有音频轨道
						if (this.audioStream) {
							this.audioStream.getTracks().forEach(track => track.stop());
							this.audioStream = null;
						}
						
						// 上传录音文件
						this.uploadVoiceH5(file);
					};
					
					this.mediaRecorder.onerror = (err) => {
						this.isRecording = false;
						this.recordDuration = 0;
						clearInterval(this.recordTimer);
						if (this.audioStream) {
							this.audioStream.getTracks().forEach(track => track.stop());
							this.audioStream = null;
						}
						this.$utils.msg('录音失败');
					};
					
					// 开始录音
					this.mediaRecorder.start();
					this.isRecording = true;
					this.recordDuration = 0;
					
					// 开始计时
					this.recordTimer = setInterval(() => {
						this.recordDuration = this.recordDuration + 1;
						// 最长60秒
						if (this.recordDuration >= 60) {
							this.stopRecord();
						}
					}, 1000);
					
				} catch (e) {
					this.$utils.msg('录音失败: ' + (e.message || '无法访问麦克风'));
					this.isRecording = false;
					this.recordDuration = 0;
				}
			},
			// 原生环境录音（小程序、APP）
			startRecordNative() {
				try {
					// 检查是否已初始化录音管理器
					if (!this.recorderManager) {
						this.recorderManager = uni.getRecorderManager();
						this.recorderManager.onStart(() => {
							this.isRecording = true
							this.recordDuration = 0
							// 开始计时
							this.recordTimer = setInterval(() => {
								this.recordDuration = this.recordDuration + 1
							}, 1000);
						});
						this.recorderManager.onStop((res) => {
							clearInterval(this.recordTimer);
							this.isRecording = false
							this.recordDuration = 0
							if (res.tempFilePath) {
								this.uploadVoice(res.tempFilePath);
							} else {
								this.$utils.msg('录音文件不存在')
							}
						});
						this.recorderManager.onError((err) => {
							clearInterval(this.recordTimer);
							this.isRecording = false
							this.recordDuration = 0
							this.$utils.msg('录音失败: ' + (err.errMsg || '未知错误'))
						});
					}
					
					// 录音配置参数
					const recordOptions = {
						duration: 60000, // 最长录音时间60秒
						sampleRate: 16000,
						numberOfChannels: 1,
						encodeBitRate: 96000,
						frameSize: 50
					};
					
					// 根据平台设置录音格式
					// #ifdef MP-WEIXIN
					recordOptions.format = 'mp3';
					// 请求录音权限
					uni.authorize({
						scope: 'scope.record',
						success: () => {
							// 开始录音
							try {
								this.recorderManager.start(recordOptions);
							} catch (e) {
								this.$utils.msg('开始录音失败')
							}
						},
						fail: () => {
							uni.showModal({
								title: '提示',
								content: '需要录音权限才能使用语音功能',
								showCancel: false
							});
						}
					});
					// #endif
					// #ifdef APP-PLUS
					recordOptions.format = 'mp3';
					// 开始录音
					try {
						this.recorderManager.start(recordOptions);
					} catch (e) {
						this.$utils.msg('开始录音失败: ' + (e.message || '未知错误'))
					}
					// #endif
					// #ifndef MP-WEIXIN || APP-PLUS
					// 其他平台默认使用aac格式
					recordOptions.format = 'aac';
					// 开始录音
					try {
						this.recorderManager.start(recordOptions);
					} catch (e) {
						this.$utils.msg('开始录音失败: ' + (e.message || '未知错误'))
					}
					// #endif
				} catch (e) {
					this.$utils.msg('录音功能初始化失败')
				}
			},
			stopRecord() {
				// #ifdef H5
				// H5环境停止录音
				this.stopRecordH5();
				// #endif
				// #ifndef H5
				// 非H5环境停止录音
				this.stopRecordNative();
				// #endif
			},
			// H5环境停止录音
			stopRecordH5() {
				try {
					if (this.isRecording && this.mediaRecorder && this.mediaRecorder.state !== 'inactive') {
						this.mediaRecorder.stop();
					}
					if (this.recordTimer) {
						clearInterval(this.recordTimer);
					}
					this.isRecording = false;
				} catch (e) {
					this.isRecording = false;
					this.recordDuration = 0;
					if (this.recordTimer) {
						clearInterval(this.recordTimer);
					}
					if (this.audioStream) {
						this.audioStream.getTracks().forEach(track => track.stop());
						this.audioStream = null;
					}
				}
			},
			// 原生环境停止录音
			stopRecordNative() {
				try {
					if (this.isRecording && this.recorderManager) {
						this.recorderManager.stop();
					}
				} catch (e) {
					this.isRecording = false
					this.recordDuration = 0
					if (this.recordTimer) {
						clearInterval(this.recordTimer);
					}
				}
			},
			// H5环境上传语音文件
			async uploadVoiceH5(file) {
				let that = this;
				uni.showLoading({
					title: '上传中...',
					mask: true
				});
				
				// 使用FormData上传
				const formData = new FormData();
				formData.append('file', file);
				
				try {
					const response = await fetch(`${this.baseUrl}file/upload`, {
						method: 'POST',
						headers: {
							'Token': uni.getStorageSync("appToken")
						},
						body: formData
					});
					
					const result = await response.json();
					uni.hideLoading();
					
					if (result.code == 0) {
						// 检查好友关系
						let res = await this.$api.page('friend', {
							uid: that.user.id,
							fid: that.fid,
							type: 2
						});
						if (!res.data.list.length) {
							await this.$api.add('friend', {
								uid: that.user.id,
								fid: that.fid,
								name: that.fname,
								picture: that.fpic,
								type: 2,
								tablename: 'yonghu'
							});
							await this.$api.add('friend', {
								fid: that.user.id,
								uid: that.fid,
								name: uni.getStorageSync("nickname"),
								picture: that.mpic,
								type: 2,
								tablename: uni.getStorageSync("nowTable")
							});
						}
						// 发送语音消息
						await this.$api.add('chatmessage', {
							uid: that.user.id,
							fid: that.fid,
							content: 'upload/' + result.file,
							format: 5,
						});
						uni.sendSocketMessage({
							data: 'upload/' + result.file
						});
						that.getChatList();
					} else {
						uni.showToast({
							title: result.msg || '上传失败',
							icon: 'none',
							duration: 2000
						});
					}
				} catch (err) {
					uni.hideLoading();
					uni.showToast({
						title: '上传失败',
						icon: 'none',
						duration: 2000
					});
				}
			},
			// 上传语音文件（原生环境）
			async uploadVoice(tempFilePath) {
				let that = this;
				uni.showLoading({
					title: '上传中...',
					mask: true
				});
				
				// 上传音频文件
				uni.uploadFile({
					url: `${this.baseUrl}file/upload`,
					filePath: tempFilePath,
					name: 'file',
					header: {
						'Token': uni.getStorageSync("appToken")
					},
					success: async (uploadRes) => {
						uni.hideLoading();
						let result = JSON.parse(uploadRes.data);
						if (result.code == 0) {
							// 检查好友关系
							let res = await this.$api.page('friend', {
								uid: that.user.id,
								fid: that.fid,
								type: 2
							});
							if (!res.data.list.length) {
								await this.$api.add('friend', {
									uid: that.user.id,
									fid: that.fid,
									name: that.fname,
									picture: that.fpic,
									type: 2,
									tablename: 'yonghu'
								});
								await this.$api.add('friend', {
									fid: that.user.id,
									uid: that.fid,
									name: uni.getStorageSync("nickname"),
									picture: that.mpic,
									type: 2,
									tablename: uni.getStorageSync("nowTable")
								});
							}
							// 发送语音消息
							await this.$api.add('chatmessage', {
								uid: that.user.id,
								fid: that.fid,
								content: 'upload/' + result.file,
								format: 5,
							});
							uni.sendSocketMessage({
								data: 'upload/' + result.file
							});
							that.getChatList();
						} else {
							uni.showToast({
								title: result.msg || '上传失败',
								icon: 'none',
								duration: 2000
							});
						}
					},
					fail: (err) => {
						uni.hideLoading();
						uni.showToast({
							title: '上传失败',
							icon: 'none',
							duration: 2000
						});
					}
				});
			},
			// 播放语音
			playVoice(audioUrl, audioId) {
				
				// 如果正在播放同一个音频，则停止
				if (this.playingAudioId === audioId) {
					if (this.innerAudioContext) {
						this.innerAudioContext.stop();
						this.innerAudioContext.destroy();
					}
					this.playingAudioId = null
					this.$forceUpdate();
					return;
				}
				
				// 确保URL是完整的
				if (!audioUrl) {
					this.$utils.msg('音频地址无效');
					return;
				}
				
				// 创建新的音频上下文
				this.innerAudioContext = uni.createInnerAudioContext();
				this.innerAudioContext.autoplay = false;
				
				// 绑定事件监听
				this.innerAudioContext.onPlay(() => {
					this.$forceUpdate();
				});
				this.innerAudioContext.onEnded(() => {
					this.playingAudioId = null
					this.$forceUpdate();
				});
				this.innerAudioContext.onError((err) => {
					this.playingAudioId = null
					let errMsg = '播放失败';
					if (err.errMsg) {
						errMsg += ': ' + err.errMsg;
					}
					this.$utils.msg(errMsg);
					this.$forceUpdate();
				});
				this.innerAudioContext.onPause(() => {
					this.$forceUpdate();
				});
				this.innerAudioContext.onStop(() => {
					this.playingAudioId = null
					this.$forceUpdate();
				});
				
				// 设置音频源
				this.innerAudioContext.src = audioUrl;
				this.playingAudioId = audioId
				
				// 使用$nextTick确保在设置src后播放
				this.$nextTick(() => {
					try {
						this.innerAudioContext.play();
						this.$forceUpdate();
					} catch (e) {
						this.playingAudioId = null
						this.$utils.msg('播放失败: ' + (e.message || '未知错误'))
						this.$forceUpdate();
					}
				});
			},
			preViewImg(img){
				uni.previewImage({
					urls: [img],
					current:img
				})
			},
			async uploadSuccess() {
				let _this = this;
				await this.$api.upload(async function(obj) {
					let res = await _this.$api.page('friend', {
						uid: _this.user.id,
						fid: _this.fid,
					})
					if(!res.data.list.length){
						await _this.$api.add('friend',{
							uid: _this.user.id,
							fid: _this.fid,
							name: _this.fname,
							picture: _this.fpic,
							type: 2,
							tablename:  'yonghu' ,
						})
						await _this.$api.add('friend',{
							fid: _this.user.id,
							uid: _this.fid,
							name: uni.getStorageSync("nickname"),
							picture: _this.mpic,
							type: 2,
							tablename: uni.getStorageSync("nowTable")
						})
					}
					await _this.$api.add('chatmessage',{
						uid: _this.user.id,
						fid: _this.fid,
						content: 'upload/' + obj.file,
						format: 2
					})
					_this.chatForm = {
						content: ''
					}
					uni.sendSocketMessage({
						data: 'upload/' + obj.file
					})
					_this.getChatList()
				})
			},
			async uploadSuccess2() {
				let _this = this;
				await this.$api.uploadMedia(async function(obj) {
					let res = await _this.$api.page('friend', {
						uid: _this.user.id,
						fid: _this.fid,
					})
					if(!res.data.list.length){
						await _this.$api.add('friend',{
							uid: _this.user.id,
							fid: _this.fid,
							name: _this.fname,
							picture: _this.fpic,
							type: 2,
							tablename:  'yonghu' ,
						})
						await _this.$api.add('friend',{
							fid: _this.user.id,
							uid: _this.fid,
							name: uni.getStorageSync("nickname"),
							picture: _this.mpic,
							type: 2,
							tablename: uni.getStorageSync("nowTable")
						})
					}
					await _this.$api.add('chatmessage',{
						uid: _this.user.id,
						fid: _this.fid,
						content: 'upload/' + obj.file,
						format: 3
					})
					_this.chatForm = {
						content: ''
					}
					uni.sendSocketMessage({
						data: 'upload/' + obj.file
					})
					_this.getChatList()
				})
			},
			async addChat() {
				let res = await this.$api.page('friend', {
					uid: this.user.id,
					fid: this.fid,
				})
				if(!res.data.list.length){
					await this.$api.add('friend',{
						uid: this.user.id,
						fid: this.fid,
						name: this.fname,
						picture: this.fpic,
						type: 2,
						tablename:  'yonghu' ,
					})
					await this.$api.add('friend',{
						fid: this.user.id,
						uid: this.fid,
						name: uni.getStorageSync("nickname"),
						picture: this.mpic,
						type: 2,
						tablename: uni.getStorageSync("nowTable")
					})
				}
				await this.$api.add('chatmessage',{
					uid: this.user.id,
					fid: this.fid,
					content: this.chatForm.content,
					format: 1
				})
				uni.sendSocketMessage({
					data: this.chatForm.content
				})
				this.chatForm = {
					content: ''
				}
				this.getChatList()
			},

		}
	}
</script>

<style lang="scss">
	page {
	  --animate-duration: 1s;
	  --animate-delay: 1s;
	  --animate-repeat: 1;
	}
	
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio .uni-audio-default {
		width: inherit !important;
	}
	// #ifdef H5
	.shareBG{
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		background: rgba(0,0,0,.3);
		z-index: 665;
	}
	.shareBox {
		width: 100%;
		position: fixed;
		height: 20%;
		right: 0;
		bottom: 0;
		z-index: 666;
		-webkit-transform: translate3d(0, 100%, 0);
		transform: translate3d(0, 100%, 0);
		transition: transform .3s;
		overflow-y: scroll;
		background: #fff;
		display: flex;
		align-items: center;
		justify-content: space-around;
	}
	.shareBoxActive {
		-webkit-transform: translate3d(0%, 0, 0);
		transform: translate3d(0%, 0, 0);
	}
	.shareView {
		width: 20%;
		display: flex;
		flex-direction: column;
		align-items: center;
		.shareText {
			font-size: 24rpx;
			padding: 10rpx 0 0 ;
		}
	}
	// #endif
	

	.popup-chat{
		 background: #fff;
		 padding-bottom: 40px;
		 .chat-content {
			padding-bottom: 20px;
			width: 100%;
			margin-bottom: 10px;
			max-height: 400px;
			height: 400px;
			border: 1px solid #eeeeee;
			display: flex;
			flex-direction: column;
			
		 
			.left-content {
				float: left;
				margin-bottom: 10px;
				padding: 10px;
				max-width: 80%;
				display: flex;
				align-items: center;
				.text-content{
					background: #e5ffff;
					padding: 8px 12px;
					border-radius: 5px;
				}
				.voice-content {
					background: #e5ffff;
					padding: 8px 12px;
					border-radius: 5px;
					display: flex;
					align-items: center;
					cursor: pointer;
					.icon {
						font-size: 20px;
						margin-right: 5px;
						color: #007aff;
					}
					.voice-duration {
						font-size: 12px;
						color: #666;
						margin-left: 5px;
					}
				}
			}
					 
			.right-content {
				float: right;
				margin-bottom: 10px;
				padding: 10px;
				max-width: 80%;
				display: flex;
				align-items: center;
				.text-content{
					background: #fff;
					padding: 8px 12px;
					border-radius: 5px;
				}
				.voice-content {
					background: #fff;
					padding: 8px 12px;
					border-radius: 5px;
					display: flex;
					align-items: center;
					cursor: pointer;
					.icon {
						font-size: 20px;
						margin-right: 5px;
						color: #007aff;
					}
					.voice-duration {
						font-size: 12px;
						color: #666;
						margin-left: 5px;
					}
				}
			}
		 }
	}
	
	.voice-btn {
		width: auto;
		padding: 0 10px;
		background: #ff6b6b;
		font-size: 14px;
		border: none;
		color: #fff;
		transition: all 0.3s;
	}
	.voice-btn.recording {
		background: #ff4757;
		animation: pulse 1s infinite;
	}
	@keyframes pulse {
		0% {
			opacity: 1;
		}
		50% {
			opacity: 0.7;
		}
		100% {
			opacity: 1;
		}
	}
</style>
