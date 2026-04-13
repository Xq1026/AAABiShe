  

<template>
<view class="content">
	<view :style='{"width":"100%","padding":"24rpx","position":"relative","background":"#fff","height":"100%"}' v-if="showType==1">
		<form :style='{"width":"100%","padding":"48rpx 0 48rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">




































			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书编号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.tushubianhao" v-model="ruleForm.tushubianhao" placeholder="图书编号"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.tushumingcheng" v-model="ruleForm.tushumingcheng" placeholder="图书名称"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书类型</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.tushuleixing" v-model="ruleForm.tushuleixing" placeholder="图书类型"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="tushufengmianTap">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书封面</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.tushufengmian" :src="baseUrl+ruleForm.tushufengmian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书作者</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.tushuzuozhe" v-model="ruleForm.tushuzuozhe" placeholder="图书作者"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">作者国籍</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.zuozheguoji" v-model="ruleForm.zuozheguoji" placeholder="作者国籍"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书语言</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.tushuyuyan" v-model="ruleForm.tushuyuyan" placeholder="图书语言"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">可借天数</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.kejietianshu" v-model="ruleForm.kejietianshu" placeholder="可借天数" type="number" @input="numberChange"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书押金</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.tushuyajin" v-model="ruleForm.tushuyajin" placeholder="图书押金" type="digit" @input="numberChange"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">赔付时间</view>
				<input :disabled="ro.peifushijian" :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' v-model="ruleForm.peifushijian" placeholder="赔付时间" @tap="toggleTab('peifushijian')"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">借阅时长</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.jieyueshizhang" v-model="ruleForm.jieyueshizhang" placeholder="借阅时长" type="digit" @input="numberChange"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">超出时长</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.chaochushizhang" v-model="ruleForm.chaochushizhang" placeholder="超出时长" type="number" @input="numberChange"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">超时金额</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.chaoshijine" v-model="ruleForm.chaoshijine" placeholder="超时金额" type="digit" @input="numberChange"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">用户账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.yonghuzhanghao" v-model="ruleForm.yonghuzhanghao" placeholder="用户账号"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">用户姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.yonghuxingming" v-model="ruleForm.yonghuxingming" placeholder="用户姓名"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">申请人账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.shenqingrenzhanghao" v-model="ruleForm.shenqingrenzhanghao" placeholder="申请人账号"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">申请人姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.shenqingrenxingming" v-model="ruleForm.shenqingrenxingming" placeholder="申请人姓名"  type="text"></input>
			</view>
                  
			
			<view :style='{"width":"100%","margin":"40rpx 0","flexDirection":"column","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0","margin":"0 0 40rpx 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"#333333","width":"100%","lineHeight":"96rpx","fontSize":"30rpx","height":"96rpx"}' @tap="onSubmitTap(null)" class="bg-red">提交</button>
			</view>
		</form>
		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="peifushijianConfirm" ref="peifushijian" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				tushubianhao: '',
				tushumingcheng: '',
				tushuleixing: '',
				tushufengmian: '',
				tushuzuozhe: '',
				zuozheguoji: '',
				tushuyuyan: '',
				kejietianshu: '',
				tushuyajin: '',
				peifushijian: '',
				jieyueshizhang: '',
				chaochushizhang: '',
				chaoshijine: '',
				yonghuzhanghao: '',
				yonghuxingming: '',
				shenqingrenzhanghao: '',
				shenqingrenxingming: '',
				ispay: '',
				},
				// 登录用户信息
				user: {},
				ro:{
				   tushubianhao : false,
				   tushumingcheng : false,
				   tushuleixing : false,
				   tushufengmian : false,
				   tushuzuozhe : false,
				   zuozheguoji : false,
				   tushuyuyan : false,
				   kejietianshu : false,
				   tushuyajin : false,
				   peifushijian : false,
				   jieyueshizhang : false,
				   chaochushizhang : false,
				   chaoshijine : false,
				   yonghuzhanghao : false,
				   yonghuxingming : false,
				   shenqingrenzhanghao : false,
				   shenqingrenxingming : false,
				   ispay : false,
				},
				virtualPay: false,
				showType: 1,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			sessionForm() {
				return uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.yonghuzhanghao = this.user.yonghuzhanghao
			this.ro.yonghuzhanghao = true;
			this.ruleForm.yonghuxingming = this.user.yonghuxingming
			this.ro.yonghuxingming = true;

			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='tushubianhao'){
						this.ruleForm.tushubianhao = obj[o];
						this.ro.tushubianhao = true;
						continue;
					}
					if(o=='tushumingcheng'){
						this.ruleForm.tushumingcheng = obj[o];
						this.ro.tushumingcheng = true;
						continue;
					}
					if(o=='tushuleixing'){
						this.ruleForm.tushuleixing = obj[o];
						this.ro.tushuleixing = true;
						continue;
					}
					if(o=='tushufengmian'){
						this.ruleForm.tushufengmian = obj[o].split(",")[0];
						this.ro.tushufengmian = true;
						continue;
					}
					if(o=='tushuzuozhe'){
						this.ruleForm.tushuzuozhe = obj[o];
						this.ro.tushuzuozhe = true;
						continue;
					}
					if(o=='zuozheguoji'){
						this.ruleForm.zuozheguoji = obj[o];
						this.ro.zuozheguoji = true;
						continue;
					}
					if(o=='tushuyuyan'){
						this.ruleForm.tushuyuyan = obj[o];
						this.ro.tushuyuyan = true;
						continue;
					}
					if(o=='kejietianshu'){
						this.ruleForm.kejietianshu = obj[o];
						this.ro.kejietianshu = true;
						continue;
					}
					if(o=='tushuyajin'){
						this.ruleForm.tushuyajin = obj[o];
						this.ro.tushuyajin = true;
						continue;
					}
					if(o=='peifushijian'){
						this.ruleForm.peifushijian = obj[o];
						this.ro.peifushijian = true;
						continue;
					}
					if(o=='jieyueshizhang'){
						this.ruleForm.jieyueshizhang = obj[o];
						this.ro.jieyueshizhang = true;
						continue;
					}
					if(o=='chaochushizhang'){
						this.ruleForm.chaochushizhang = obj[o];
						this.ro.chaochushizhang = true;
						continue;
					}
					if(o=='chaoshijine'){
						this.ruleForm.chaoshijine = obj[o];
						this.ro.chaoshijine = true;
						continue;
					}
					if(o=='yonghuzhanghao'){
						this.ruleForm.yonghuzhanghao = obj[o];
						this.ro.yonghuzhanghao = true;
						continue;
					}
					if(o=='yonghuxingming'){
						this.ruleForm.yonghuxingming = obj[o];
						this.ro.yonghuxingming = true;
						continue;
					}
					if(o=='shenqingrenzhanghao'){
						this.ruleForm.shenqingrenzhanghao = obj[o];
						this.ro.shenqingrenzhanghao = true;
						continue;
					}
					if(o=='shenqingrenxingming'){
						this.ruleForm.shenqingrenxingming = obj[o];
						this.ro.shenqingrenxingming = true;
						continue;
					}
				}
			}


			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`chaoshipeifu`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap(null)
				}, 300)
			}
		},
		methods: {
			numberChange(e) {
				e = Number(e)
			},

			// 多级联动参数


			// 日长控件选择日期时间
			peifushijianConfirm(val) {
				this.ruleForm.peifushijian = val.result;
				this.$forceUpdate();
			},


			tushufengmianTap() {
				if(this.ro.tushufengmian){
					return false
				}
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.tushufengmian = 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap(subMitType=null) {
				let that = this
				if(!this.ruleForm.id) {
					this.ruleForm.ispay = '未支付'
				}
				//跨表计算判断
				var obj;
				if(this.ruleForm.kejietianshu&&(!this.$validate.isIntNumer(this.ruleForm.kejietianshu))){
					this.$utils.msg(`可借天数应输入整数`);
					return
				}
				if(this.ruleForm.tushuyajin&&(!this.$validate.isNumber(this.ruleForm.tushuyajin))){
					this.$utils.msg(`图书押金应输入数字`);
					return
				}
				if(this.ruleForm.jieyueshizhang&&(!this.$validate.isNumber(this.ruleForm.jieyueshizhang))){
					this.$utils.msg(`借阅时长应输入数字`);
					return
				}
				if(this.ruleForm.chaochushizhang&&(!this.$validate.isIntNumer(this.ruleForm.chaochushizhang))){
					this.$utils.msg(`超出时长应输入整数`);
					return
				}
				if(this.ruleForm.chaoshijine&&(!this.$validate.isNumber(this.ruleForm.chaoshijine))){
					this.$utils.msg(`超时金额应输入数字`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}
							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
								crossuserid=Number(uni.getStorageSync('appUserid'));
								crossrefid=obj['id'];
								crossoptnum=uni.getStorageSync('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						let params = {
							page: 1,
							limit:10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						let res = await this.$api.list(`chaoshipeifu`, params);
						if (res.data.total >= crossoptnum) {
							this.$utils.msg(uni.getStorageSync('tips'));
							uni.removeStorageSync('crossCleanType');
							return false;
						}
					}
					//跨表计算
				}
				let oet = {}
				if(this.ruleForm.id){
					await this.$api.update(`chaoshipeifu`, this.ruleForm);
				}else{
					oet = await this.$api.add(`chaoshipeifu`, this.ruleForm);
				}
				if(this.isAuth('chaoshipeifu','支付')&&this.cross) {
					uni.showModal({
						title: '提交成功！',
						content: '是否跳转支付？',
						success: async function(res) {
							if (res.confirm) {
								that.$utils.jump(`./detail?id=${oet.data}&userid=` + uni.getStorageSync("appUserid"))
							}else {
								if(that.cross){
									uni.setStorageSync('crossCleanType',true);
								}
								that.$utils.msgBack('提交成功');
							}
						}
					})
				}else {
					if(this.cross){
						uni.setStorageSync('crossCleanType',true);
					}
					that.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
