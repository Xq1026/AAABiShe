<template>
<view class="content">
	<view class="register-box" :style="{'backgroundImage': indexBgUrl?`url(${$base.url + indexBgUrl})`:''}">
		<view :style='{"border":"2rpx solid #fff","padding":"100rpx 48rpx 144rpx","margin":"360rpx 0 0","textAlign":"center","display":"flex","justifyContent":"space-between","alignContent":"flex-start","borderRadius":"0 180rpx 0 0","flexWrap":"wrap","background":"rgba(255,255,255,1)","width":"100%","position":"relative","height":"auto"}'>
			<image :style='{"margin":"0 auto 24rpx auto","borderRadius":"8rpx","top":"-220rpx","left":"40%","display":"none","width":"160rpx","position":"absolute","height":"160rpx"}' :src="indexLogoUrl?($base.url + indexLogoUrl):'http://codegen.caihongy.cn/20241111/fecb10e0826c4ad39b0954a5ecef94a1.png'" mode="aspectFill"></image>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">用户账号：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.yonghuzhanghao" v-model="ruleForm.yonghuzhanghao"  type="text"  class="uni-input" name="" placeholder="用户账号" />
			</view>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">密码：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.mima" v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">用户姓名：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.yonghuxingming" v-model="ruleForm.yonghuxingming"  type="text"  class="uni-input" name="" placeholder="用户姓名" />
			</view>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">性别：</view>
				<picker :style='{"border":"0px solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" :disabled="ro.xingbie" @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"border":"0px solid #23baf7","padding":"0 20rpx","color":"#666","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">手机：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.shouji" v-model="ruleForm.shouji"  type="text"  class="uni-input" name="" placeholder="手机" />
			</view>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","margin":"0px 0 0 10rpx","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"80rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
				<image :style='{"width":"120rpx","margin":"0px 0 0 10rpx","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"80rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
			</view>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">邮箱：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.email" type="text" class="uni-input" name="" placeholder="邮箱" />
			</view>
			<view :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='yonghu' && true" class="uni-form-item uni-column">
				<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">验证码：</view>
				<input :style='{"border":"0px solid #23baf7","padding":"0 24rpx","margin":"0","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","background":"#f5f5f5","width":"calc(100% - 240rpx)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="emailcode" type="text" class="uni-input" name="" placeholder="请输入邮箱验证码" />
				<button :style='{"border":"0px solid #ddd","padding":"0px","margin":"0px","whiteSpace":"nowrap","alignItems":"center","color":"#fff","display":"flex","justifyContent":"center","borderRadius":"20rpx","background":"#174add","borderWidth":"0px 0px 0px 0","width":"240rpx","lineHeight":"80rpx","fontSize":"26rpx","height":"80rpx"}' type="primary" v-if="isEndFlag" @tap="sendemailcode" class="bg-red">发送验证码</button>
				<button :style='{"border":"0px solid #ddd","padding":"0px","margin":"0px","whiteSpace":"nowrap","alignItems":"center","color":"#fff","display":"flex","justifyContent":"center","borderRadius":"20rpx","background":"#174add","borderWidth":"0px 0px 0px 0","width":"240rpx","lineHeight":"80rpx","fontSize":"26rpx","height":"80rpx"}' type="primary" v-if="!isEndFlag" disabled="disabled" class="bg-red">{{SecondToDate}}</button>
			</view>
			<button :style='{"border":"0","padding":"0 40rpx","margin":"24rpx auto","color":"rgb(255, 255, 255)","borderRadius":"20rpx","background":"#333333","display":"inline-block","width":"calc(100% - 0px)","lineHeight":"96rpx","fontSize":"36rpx","minWidth":"200rpx","height":"96rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				yonghuxingbieOptions: [],
				yonghuxingbieIndex: 0,
				ruleForm: {
				yonghuzhanghao: '',
				mima: '',
				yonghuxingming: '',
				xingbie: '',
				shouji: '',
				touxiang: '',
				email: '',
				},
				ro: {},
				emailcode: "",
				// 倒计时定时器
				inter: null,
				// 倒计时
				count: 10,
				//倒计时结束标识
				isEndFlag: true,
				tableName:"",
				indexBgUrl: '',
				indexLogoUrl: '',
			}
		},
		components: {
			multipleSelect
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			SecondToDate: function() {
				var time = this.count;
				time = parseInt(time) + "秒后重发";
				return time;
			}
		},
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
			this.tableName = table;

			if(this.tableName=='yonghu'){
				// 自定义下拉框值
				this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
				this.ro = {
					yonghuzhanghao: false,
					mima: false,
					yonghuxingming: false,
					xingbie: false,
					shouji: false,
					touxiang: false,
					email: false,
				}
			}
			
			this.styleChange()
		},
		methods: {
			// 发送邮箱验证码
			async sendemailcode(){
				if(!this.ruleForm.email){
					this.$utils.msg(`邮箱不能为空`);
					return
				}
				if(this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
					this.$utils.msg(`请输入正常的邮件格式`);
					return
				}
				if (this.count > 0) {
					this.isEndFlag = false;
					var _this = this;
					this.inter = setInterval(function() {
						_this.count = _this.count - 1;
						if (_this.count <= 0) {
							clearInterval(_this.inter);
							_this.count=60;
							_this.isEndFlag = true;
						}
					}, 1000);
				}
				let res = await this.$api.sendemail(`${this.tableName}`, this.ruleForm.email);
				if (res.code == 0) {
					this.$utils.msg(`发送成功`);
				} else {
					this.$utils.errMsg(`服务器异常，请稍后重试`);
					return;
				}
			},

			// 下拉变化
			yonghuxingbieChange(e) {
					this.yonghuxingbieIndex = e.target.value
					this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
			},
			yonghutouxiangTap() {
				if(this.ro.touxiang) {
					return false
				}
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},
			toggleTab(str,str1) {
				if(this.ro[str1]){
					return false
				}
				this.$refs[str + str1].show();
			},

			async styleChange() {
				let rs = await this.$api.getPublic('config/info?name=appRegisterBackgroudImg')
				this.indexBgUrl = rs.data?rs.data.value:''
				rs = await this.$api.getPublic('config/info?name=appRegLogo')
				this.indexLogoUrl = rs.data?rs.data.value:''
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`用户账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
				if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
					this.$utils.msg(`两次密码输入不一致`);
					return
				}
				if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$utils.msg(`用户姓名不能为空`);
					return
				}
				if((!this.ruleForm.shouji) && `yonghu` == this.tableName){
					this.$utils.msg(`手机不能为空`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
				await this.$api.registerEmail(`${this.tableName}`, this.ruleForm, this.emailcode);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.register-box{
		padding: 48rpx 0 24rpx;
		background: url(http://codegen.caihongy.cn/20250811/b73cc3455c69490fa046c5d2901e067f.jpg) no-repeat center top / 100% auto,#fff;
		width: 100%;
		min-height: 100vh;
		height: auto;
	}
</style>
