<template>
	<view class="content">
		<view class="login-box" :style="{'backgroundImage': indexBgUrl?`url(${$base.url + indexBgUrl})`:''}">
			<view :style='{"border":"2rpx solid #fff","padding":"100rpx 48rpx 144rpx","margin":"360rpx 0 0","textAlign":"center","display":"flex","justifyContent":"space-between","alignContent":"flex-start","borderRadius":"0px 180rpx 0 0","flexWrap":"wrap","background":"rgba(255,255,255,1)","width":"100%","position":"relative","height":"auto"}'>
				<image :style='{"margin":"0 auto 24rpx auto","borderRadius":"20rpx","top":"-220rpx","left":"40%","display":"none","width":"160rpx","position":"absolute","height":"160rpx"}' :src="indexLogoUrl?($base.url + indexLogoUrl):'http://codegen.caihongy.cn/20241111/d1c8963d79a6452b8b41e8d08594c191.png'" mode="aspectFill"></image>
				<view v-if="loginType==1" :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">账号：</view>
					<input v-model="username" :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' type="text" class="uni-input" name="" placeholder="请输入账号" />
				</view>
				<view v-if="loginType==1" :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">密码：</view>
					<input v-model="password" password :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' type="password" class="uni-input" name="" placeholder="请输入密码" />
				</view>
				<view v-if="loginType==3" :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' class="uni-form-item uni-column">
					<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">邮箱：</view>
					<input v-model="email" :style='{"border":"0px solid #23baf7","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' type="text" class="uni-input" name="" placeholder="请输入邮箱" />
				</view>
				<view v-if="loginType==3" class="code" :style='{"border":"0px solid #1ccb96","margin":"0 0 48rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}'>
					<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">验证码：</view>
					<input :style='{"border":"0px solid #23baf7","padding":"0 24rpx","margin":"0 10rpx 0 0","color":"rgb(0, 0, 0)","borderRadius":"20rpx","textAlign":"left","background":"#f5f5f5","width":"calc(100% - 240rpx)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' type="text" v-model="emailcode" placeholder="请输入验证码" />
					<view v-if="isEndFlag" class="getCodeBt" :style='{"border":"0px solid #ddd","padding":"0px","margin":"0 0 0 20rpx","alignItems":"center","borderRadius":"20rpx","background":"#174add","borderWidth":"0px 0px 0px 0","display":"flex","width":"240rpx","lineHeight":"80rpx","justifyContent":"center","height":"80rpx"}' @click="emailClick()">
						发送验证码
					</view>
					<view v-if="!isEndFlag" class="getCodeBt" :style='{"border":"0px solid #ddd","padding":"0px","margin":"0 0 0 20rpx","alignItems":"center","borderRadius":"20rpx","background":"#174add","borderWidth":"0px 0px 0px 0","display":"flex","width":"240rpx","lineHeight":"80rpx","justifyContent":"center","height":"80rpx"}'>
						{{emailText}}
					</view>
				</view>
				<view v-if="emailroles.length>2&&loginType==3" :style='{"border":"0px solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}'>
					<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">用户类型：</view>
					<picker @change="emailrolesChange" :value="emailrolesIndex" :range="emailroles" range-key="roleName" :style='{"border":"0px solid #23baf7","padding":"0 20rpx","color":"#666","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'>
						<view class="uni-picker-type">{{emailroles[emailrolesIndex].roleName}}</view>
					</picker>
				</view>
				<view v-if="roleNum>1&&loginType<=2" :style='{"border":"0px solid #1ccb96","margin":"0 0 24rpx 0","borderRadius":"20rpx","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}'>
					<view :style='{"color":"#333","borderRadius":"20rpx","textAlign":"right","background":"none","width":"auto","lineHeight":"60rpx","fontSize":"28rpx","minWidth":"160rpx"}' class="label">用户类型：</view>
					<picker @change="optionsChange" :value="index" :range="options" :style='{"border":"0px solid #23baf7","padding":"0 20rpx","color":"#666","borderRadius":"20rpx","textAlign":"left","flex":"1","background":"#f5f5f5","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'>
						<view class="uni-picker-type">{{options[index]}}</view>
					</picker>
				</view>
				

				
				<button v-if="loginType==1||loginType==3||loginType==4" class="btn-submit" @tap="onLoginTap" type="primary" :style='{"border":"0","padding":"0 40rpx","margin":"24rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"20rpx","background":"#333333","display":"inline-block","width":"auto","lineHeight":"96rpx","fontSize":"32rpx","minWidth":"100%","height":"96rpx"}'>登录</button>
				<button v-if="loginType==2" class="btn-submit" @tap="onFaceLoginTap" type="primary" :style='{"border":"0","padding":"0 40rpx","margin":"24rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"20rpx","background":"#333333","display":"inline-block","width":"auto","lineHeight":"96rpx","fontSize":"32rpx","minWidth":"100%","height":"96rpx"}'>人脸识别登录</button>
				<view class="links" :style='{"width":"100%","padding":"0","margin":"0","flexWrap":"wrap","display":"inline-block","height":"auto"}'>
					<view class="link-highlight" @tap="onRegisterTap('yonghu')" :style='{"border":"0px solid #1ccb96","padding":"0 0px","margin":"24rpx 20rpx 30rpx 0","color":"#174add","borderRadius":"16rpx","display":"inline-block","width":"auto","fontSize":"32rpx","lineHeight":"88rpx","height":"88rpx"}'>注册用户</view>
					<view v-if="loginType==1" @tap="changeLogin(3)" :style='{"border":"0px solid #1ccb96","padding":"16rpx 0","color":"#174add","borderRadius":"16rpx","textAlign":"center","width":"calc(100% - 0px)","fontSize":"30rpx","textDecoration":"underline"}'>邮箱登录</view>
					<view v-if="loginType==2||loginType==3||loginType==4" @tap="changeLogin(1)" :style='{"border":"0px solid #1ccb96","padding":"16rpx 0","color":"#174add","borderRadius":"16rpx","textAlign":"center","width":"calc(100% - 0px)","fontSize":"30rpx","textDecoration":"underline"}'>用户密码登录</view>
				</view>
				
				<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
				<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
				<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
			</view>
		</view>
	</view>
</template>

<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				username: '',
				password: '',
				loginType:1,
				email: '',
				emailcode: '',
				emailroles: [
					{
						tableName: '',
						roleName: '请选择登录用户类型'
					},
					{
						tableName: 'yonghu',
						roleName: '用户'
					},
				],
				emailrolesIndex: 0,
				// 倒计时时间
				count: 60,
				// 倒计时定时器
				inter: null,
				// 倒计时是否结束
				isEndFlag: true,
				codes: [{
					num: 1,
					color: '#000',
					rotate: '10deg',
					size: '16px'
				}, {
					num: 2,
					color: '#000',
					rotate: '10deg',
					size: '16px'
				}, {
					num: 3,
					color: '#000',
					rotate: '10deg',
					size: '16px'
				}, {
					num: 4,
					color: '#000',
					rotate: '10deg',
					size: '16px'
				}],
				options: [
					'请选择登录用户类型',
				],
				optionsValues: [
					'',
					'yonghu',
				],
				index: 0,
				roleNum:0,

				indexBgUrl: '',
				indexLogoUrl: '',
			}
		},
		computed: {
			emailText: function() {
				var time = this.count;
				if (null != time && "" != time) {
					time = parseInt(time) + "秒后重发";
				}
				return time;
			}
		},
		onLoad() {
			let options = ['请选择登录用户类型'];
			let menus = menu.list();
			this.menuList = menus;
			for(let i=0;i<this.menuList.length;i++){
				if(this.menuList[i].hasFrontLogin=='是'){
					options.push(this.menuList[i].roleName);
					this.roleNum++;
				}
			}
			if(this.roleNum==1) {
				this.index = 1;
			}	
			this.options = options;
			this.styleChange()
			
		},
		onShow() {
		},
		mounted() {
		},
		methods: {
			async emailClick() {
				var roles = ''
				if(!this.email){
					this.$utils.msg(`邮箱不能为空`);
					return
				}
				if(this.email&&(!this.$validate.isEmail(this.email))){
					this.$utils.msg(`请输入正确的邮箱格式`);
					return
				}
				if (this.emailroles.length>2) {
					if (!this.emailroles[this.emailrolesIndex].tableName) {
						this.$utils.msg("请选择登录用户类型");
						return false;
					}
					roles = this.emailroles[this.emailrolesIndex].tableName
				}else {
					roles = this.emailroles[1].tableName
				}
				var _this = this;
				let res = await this.$api.getPublic(`${roles}/sendemail/login?email=${this.email}`);
				if(res.code==0) {
					this.isEndFlag = false;
					this.inter = setInterval(function() {
						_this.count = _this.count - 1;
						if (_this.count <= 0) {
							clearInterval(_this.inter);
							_this.isEndFlag = true;
							_this.count=60;
						}
					}, 1000);
					this.$utils.msg("发送成功！");
				}else {
					this.$utils.msg(res.msg);
				}
			},
			async emailLogin() {
				var roles = ''
				var rolesName = ''
				if (this.emailroles.length>2) {
					roles = this.emailroles[this.emailrolesIndex].tableName
					rolesName = this.emailroles[this.emailrolesIndex].roleName
				}else {
					roles = this.emailroles[1].tableName
					rolesName = this.emailroles[1].roleName
				}
				let res = await this.$api.postPublic(`${roles}/email/login?email=${this.email}&&emailcode=${this.emailcode}`);
				uni.removeStorageSync("useridTag");
				uni.setStorageSync("appToken", res.token);
				uni.setStorageSync("nickname",res.username);
				uni.setStorageSync("nowTable", `${roles}`);
				res = await this.$api.session(`${roles}`);
				if(res.data.touxiang) {
					uni.setStorageSync('frontHeadportrait', res.data.touxiang);
				} else if(res.data.headportrait) {
					uni.setStorageSync('frontHeadportrait', res.data.headportrait);
				}
				uni.setStorageSync('userSession',JSON.stringify(res.data))
				// 保存用户id
				uni.setStorageSync("appUserid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("appRole", `${rolesName}`);
				this.$utils.tab('../index/index');
			},
			emailrolesChange(e){
				this.emailrolesIndex = e.target.value
			},
			async styleChange() {
				let rs = await this.$api.getPublic('config/info?name=appLoginBackgroundImg')
				this.indexBgUrl = rs.data?rs.data.value:''
				rs = await this.$api.getPublic('config/info?name=appLoginLogo')
				this.indexLogoUrl = rs.data?rs.data.value:''
			},
			onRegisterTap(tableName) {
				uni.setStorageSync("loginTable", tableName);
				this.$utils.jump('../register/register')
			},
			async onLoginTap() {
				if(this.loginType==1) {
					if (!this.username) {
						this.$utils.msg('请输入用户名')
						return
					}
					if (!this.password) {
						this.$utils.msg('请输入用户密码')
						return
					}
					if (!this.optionsValues[this.index]) {
						this.$utils.msg('请选择登录用户类型')
						return
					}
				}
				if(this.loginType==3) {
					if (!this.email) {
						this.$utils.msg('请输入邮箱')
						return
					}
					if (!this.emailcode) {
						this.$utils.msg('请输入邮箱验证码')
						return
					}
					if (this.emailroles.length>2&&!this.emailroles[this.emailrolesIndex].tableName) {
						this.$utils.msg('请选择登录用户类型')
						return
					}
				}

				this.loginPost()

			},
			async loginPost() {
				let that = this
				if(this.loginType==3) {
					this.emailLogin()
					return false
				}
				let res = await this.$api.login(`${this.optionsValues[this.index]}`, {
					username: this.username,
					password: this.password
				});
				uni.removeStorageSync("useridTag");
				uni.setStorageSync("appToken", res.token);
				uni.setStorageSync("nickname",this.username);
				uni.setStorageSync("nowTable", `${this.optionsValues[this.index]}`);
				res = await this.$api.session(`${this.optionsValues[this.index]}`);
				if(res.data.touxiang) {
					uni.setStorageSync('frontHeadportrait', res.data.touxiang);
				} else if(res.data.headportrait) {
					uni.setStorageSync('frontHeadportrait', res.data.headportrait);
				}
				uni.setStorageSync('userSession',JSON.stringify(res.data))
				// 保存用户id
				uni.setStorageSync("appUserid", res.data.id);
				if(res.data.vip) {
					uni.setStorageSync("vip", res.data.vip);
				}
				uni.setStorageSync("appRole", `${this.options[this.index]}`);
				this.$utils.tab('../index/index');
			},
			changeLogin(type){
				this.loginType = type
			},
			optionsChange(e) {
				this.index = e.target.value
			}
		}
	}
</script>

<style lang="scss" scoped>
	page {
		height: 100%;
	}
	
	.content {
		height: 100%;
		box-sizing: border-box;
	}
	.login-box {
		padding: 48rpx 0 24rpx;
		background: url(http://codegen.caihongy.cn/20250811/b73cc3455c69490fa046c5d2901e067f.jpg) no-repeat center top / 100% auto,#fff;
		width: 100%;
		min-height: 100vh;
		height: auto;
	}
</style>
