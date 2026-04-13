  

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
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书类型</view>
				<picker :disabled="ro.tushuleixing" :style='{"width":"100%","flex":"1","height":"auto"}' @change="tushuleixingChange" :value="tushuleixingIndex" :range="tushuleixingOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#174add"}' class="uni-input">{{ruleForm.tushuleixing?ruleForm.tushuleixing:"请选择图书类型"}}</view>
				</picker>
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
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">出版公司</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.chubangongsi" v-model="ruleForm.chubangongsi" placeholder="出版公司"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书标签</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.tushubiaoqian" v-model="ruleForm.tushubiaoqian" placeholder="图书标签"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">受众群体</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.shouzhongqunti" v-model="ruleForm.shouzhongqunti" placeholder="受众群体"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书状态</view>
				<picker :disabled="ro.tushuzhuangtai" :style='{"width":"100%","flex":"1","height":"auto"}' @change="tushuzhuangtaiChange" :value="tushuzhuangtaiIndex" :range="tushuzhuangtaiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"30rpx","color":"#174add"}' class="uni-input">{{ruleForm.tushuzhuangtai?ruleForm.tushuzhuangtai:"请选择图书状态"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">可借天数</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.kejietianshu" v-model="ruleForm.kejietianshu" placeholder="可借天数"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">借书地点</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.jieshudidian" v-model="ruleForm.jieshudidian" placeholder="借书地点"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 40rpx 0","borderColor":"#1ccb96","alignItems":"center","borderRadius":"20rpx","borderWidth":"0px 0","background":"#f5f5f5","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书押金</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"30rpx","height":"80rpx"}' :disabled="ro.tushuyajin" v-model="ruleForm.tushuyajin" placeholder="图书押金" type="digit" @input="numberChange"></input>
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
				<view :style='{"padding":"0 12rpx 0 0","whiteSpace":"nowrap","color":"#666","textAlign":"right","width":"auto","lineHeight":"80rpx","fontSize":"30rpx","fontWeight":"500"}' class="title">图书简介</view>
				<textarea :style='{"border":"0","padding":"24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.tushujianjie" placeholder="图书简介" :maxlength="-1" :disabled="ro.tushujianjie"></textarea>
			</view>
			
			<view :style='{"width":"100%","margin":"40rpx 0","flexDirection":"column","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0","margin":"0 0 40rpx 0","color":"rgb(255, 255, 255)","borderRadius":"16rpx","background":"#333333","width":"100%","lineHeight":"96rpx","fontSize":"30rpx","height":"96rpx"}' @tap="onSubmitTap(null)" class="bg-red">提交</button>
			</view>
		</form>
	</view>
	<view v-else-if="showType==2">
		<view style="width: 100%;display: flex;flex-wrap: wrap;padding: 10px;">
			<button style="margin: 0 10px 0 0" v-if="(userid&&isAuth('tushuxinxi','图书浏览量'))||(!userid&&isAuthFront('tushuxinxi','图书浏览量'))" size="mini" type="primary" @click="chartClick1()">
				图书浏览量
			</button>
			<button style="margin: 0 10px 0 0" v-if="(userid&&isAuth('tushuxinxi','图书收藏量'))||(!userid&&isAuthFront('tushuxinxi','图书收藏量'))" size="mini" type="primary" @click="chartClick2()">
				图书收藏量
			</button>
			<button style="margin: 0 10px 0 0" v-if="(userid&&isAuth('tushuxinxi','图书评分'))||(!userid&&isAuthFront('tushuxinxi','图书评分'))" size="mini" type="primary" @click="chartClick3()">
				图书评分
			</button>
			<button style="margin: 0 10px 0 0" v-if="(userid&&isAuth('tushuxinxi','图书类型'))||(!userid&&isAuthFront('tushuxinxi','图书类型'))" size="mini" type="primary" @click="chartClick4()">
				图书类型
			</button>
		</view>
		<view style="width: 100%;">
			<view v-if="chartType1" style="width: 100%;text-align: center;line-height: 2;font-size: 12px;color: #000">
				图书浏览量
			</view>
			<qiun-data-charts
				v-if="chartType1"
				style="width: 100%;height:"
				type="column"
				:opts="opts1"
				:chartData="chartData1">
			</qiun-data-charts>
			<view v-if="chartType2" style="width: 100%;text-align: center;line-height: 2;font-size: 12px;color: #000">
				图书收藏量
			</view>
			<qiun-data-charts
				v-if="chartType2"
				style="width: 100%;height:"
				type="bar"
				:opts="opts2"
				:chartData="chartData2">
			</qiun-data-charts>
			<view v-if="chartType3" style="width: 100%;text-align: center;line-height: 2;font-size: 12px;color: #000">
				图书评分
			</view>
			<qiun-data-charts
				v-if="chartType3"
				style="width: 100%;height:"
				type="line"
				:opts="opts3"
				:chartData="chartData3">
			</qiun-data-charts>
			<view v-if="chartType4" style="width: 100%;text-align: center;line-height: 2;font-size: 12px;color: #000">
				图书类型
			</view>
			<qiun-data-charts
				v-if="chartType4"
				style="width: 100%;height:"
				type="pie"
				:opts="opts4"
				:chartData="chartData4">
			</qiun-data-charts>
		</view>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	import qiunDataCharts from '@/components/qiun-data-charts/components/qiun-data-charts/qiun-data-charts.vue';
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
				chubangongsi: '',
				tushubiaoqian: '',
				shouzhongqunti: '',
				tushuzhuangtai: '未借出' ,
				kejietianshu: '',
				jieshudidian: '',
				tushuyajin: '',
				tushujianjie: '',
				yonghuzhanghao: '',
				yonghuxingming: '',
				discussnum: '',
				totalscore: '',
				storeupnum: '',
				},
				tushuleixingOptions: [],
				tushuleixingIndex: 0,
				tushuzhuangtaiOptions: [],
				tushuzhuangtaiIndex: 0,
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
				   chubangongsi : false,
				   tushubiaoqian : false,
				   shouzhongqunti : false,
				   tushuzhuangtai : false,
				   kejietianshu : false,
				   jieshudidian : false,
				   tushuyajin : false,
				   tushujianjie : false,
				   yonghuzhanghao : false,
				   yonghuxingming : false,
				   thumbsupnum : false,
				   crazilynum : false,
				   clicknum : false,
				   discussnum : false,
				   totalscore : false,
				   storeupnum : false,
				},
				virtualPay: false,
				showType: 1,
				userid: '',
				chartData1: {},
				opts1: {},
				chartType1: false,
				chartData2: {},
				opts2: {},
				chartType2: false,
				chartData3: {},
				opts3: {},
				chartType3: false,
				chartData4: {},
				opts4: {},
				chartType4: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
			qiunDataCharts,
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
			if(options.showType) {
				this.showType = 2
				if(options.userid&&options.userid!='') {
					this.userid = options.userid
				}
				return false
			}else {
				this.showType = 1
			}
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
						for(let x in this.tushuleixingOptions) {
							if(this.tushuleixingOptions[x] == this.ruleForm.tushuleixing) {
								this.tushuleixingIndex = Number(x)
							}
						}
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
					if(o=='chubangongsi'){
						this.ruleForm.chubangongsi = obj[o];
						this.ro.chubangongsi = true;
						continue;
					}
					if(o=='tushubiaoqian'){
						this.ruleForm.tushubiaoqian = obj[o];
						this.ro.tushubiaoqian = true;
						continue;
					}
					if(o=='shouzhongqunti'){
						this.ruleForm.shouzhongqunti = obj[o];
						this.ro.shouzhongqunti = true;
						continue;
					}
					if(o=='tushuzhuangtai'){
						this.ruleForm.tushuzhuangtai = obj[o];
						for(let x in this.tushuzhuangtaiOptions) {
							if(this.tushuzhuangtaiOptions[x] == this.ruleForm.tushuzhuangtai) {
								this.tushuzhuangtaiIndex = Number(x)
							}
						}
						this.ro.tushuzhuangtai = true;
						continue;
					}
					if(o=='kejietianshu'){
						this.ruleForm.kejietianshu = obj[o];
						this.ro.kejietianshu = true;
						continue;
					}
					if(o=='jieshudidian'){
						this.ruleForm.jieshudidian = obj[o];
						this.ro.jieshudidian = true;
						continue;
					}
					if(o=='tushuyajin'){
						this.ruleForm.tushuyajin = obj[o];
						this.ro.tushuyajin = true;
						continue;
					}
					if(o=='tushujianjie'){
						this.ruleForm.tushujianjie = obj[o];
						this.ro.tushujianjie = true;
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
					if(o=='thumbsupnum'){
						this.ruleForm.thumbsupnum = obj[o];
						this.ro.thumbsupnum = true;
						continue;
					}
					if(o=='crazilynum'){
						this.ruleForm.crazilynum = obj[o];
						this.ro.crazilynum = true;
						continue;
					}
					if(o=='clicknum'){
						this.ruleForm.clicknum = obj[o];
						this.ro.clicknum = true;
						continue;
					}
					if(o=='discussnum'){
						this.ruleForm.discussnum = obj[o];
						this.ro.discussnum = true;
						continue;
					}
					if(o=='totalscore'){
						this.ruleForm.totalscore = obj[o];
						this.ro.totalscore = true;
						continue;
					}
					if(o=='storeupnum'){
						this.ruleForm.storeupnum = obj[o];
						this.ro.storeupnum = true;
						continue;
					}
				}
			}

			var tushuleixingRefParams = {}
			// 下拉框
			res = await this.$api.option(`tushuleixing`,`tushuleixing`,tushuleixingRefParams);
			this.tushuleixingOptions = res.data;
			this.tushuleixingOptions.unshift("请选择图书类型");
			if(this.ruleForm.tushuleixing) {
				for(let x in this.tushuleixingOptions) {
					if(this.tushuleixingOptions[x] == this.ruleForm.tushuleixing) {
						this.tushuleixingIndex = Number(x)
					}
				}
			}
			// 自定义下拉框值
			this.tushuzhuangtaiOptions = "已借出,未借出".split(',')
			this.tushuzhuangtaiOptions.unshift("请选择图书状态");
			if(this.ruleForm.tushuzhuangtai) {
				for(let x in this.tushuzhuangtaiOptions) {
					if(this.tushuzhuangtaiOptions[x] == this.ruleForm.tushuzhuangtai) {
						this.tushuzhuangtaiIndex = Number(x)
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
				res = await this.$api.info(`tushuxinxi`, this.ruleForm.id);
				if(res.data.tushuleixing) {
					for(let x in this.tushuleixingOptions) {
						if(this.tushuleixingOptions[x] == res.data.tushuleixing) {
							this.tushuleixingIndex = Number(x)
						}
					}
				}
				if(res.data.tushuzhuangtai) {
					for(let x in this.tushuzhuangtaiOptions) {
						if(this.tushuzhuangtaiOptions[x] == res.data.tushuzhuangtai) {
							this.tushuzhuangtaiIndex = Number(x)
						}
					}
				}
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



			// 下拉变化
			tushuleixingChange(e) {
				this.tushuleixingIndex = e.target.value
				this.ruleForm.tushuleixing = this.tushuleixingOptions[this.tushuleixingIndex]
			},
			// 下拉变化
			tushuzhuangtaiChange(e) {
				this.tushuzhuangtaiIndex = e.target.value
				this.ruleForm.tushuzhuangtai = this.tushuzhuangtaiOptions[this.tushuzhuangtaiIndex]
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
				//跨表计算判断
				var obj;
				if(this.ruleForm.tushuyajin&&(!this.$validate.isNumber(this.ruleForm.tushuyajin))){
					this.$utils.msg(`图书押金应输入数字`);
					return
				}
				if(this.ruleForm.thumbsupnum&&(!this.$validate.isIntNumer(this.ruleForm.thumbsupnum))){
					this.$utils.msg(`赞应输入整数`);
					return
				}
				if(this.ruleForm.crazilynum&&(!this.$validate.isIntNumer(this.ruleForm.crazilynum))){
					this.$utils.msg(`踩应输入整数`);
					return
				}
				if(this.ruleForm.clicknum&&(!this.$validate.isIntNumer(this.ruleForm.clicknum))){
					this.$utils.msg(`点击次数应输入整数`);
					return
				}
				if(this.ruleForm.discussnum&&(!this.$validate.isIntNumer(this.ruleForm.discussnum))){
					this.$utils.msg(`评论数应输入整数`);
					return
				}
				if(this.ruleForm.totalscore&&(!this.$validate.isNumber(this.ruleForm.totalscore))){
					this.$utils.msg(`评分应输入数字`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
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
						let res = await this.$api.list(`tushuxinxi`, params);
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
					await this.$api.update(`tushuxinxi`, this.ruleForm);
				}else{
					oet = await this.$api.add(`tushuxinxi`, this.ruleForm);
				}
				if(this.cross){
					uni.setStorageSync('crossCleanType',true);
				}
				that.$utils.msgBack('提交成功');
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
			async chartClick1() {
				let res = await this.$api.getPublic('tushuxinxi/value/tushumingcheng/clicknum')
				res = res.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
					xAxis.push(res[i]['tushumingcheng']);
					yAxis.push(parseFloat((res[i].total)));
					pArray.push({
						value: parseFloat((res[i].total)),
						name: res[i]['tushumingcheng']
					})
				}
				this.opts1 = {
					color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
					padding: [15,15,10,5],
					enableScroll: false,
					xAxis: {
						disableGrid: true,
						rotateLabel: true,
						rotateAngle: 30
					},
					legend: {
						show: false
					},
					yAxis: {},
					extra: {
						column: {
							type: "group",
							width: 30,
							activeBgColor: "#000000",
							activeBgOpacity: 0.08
						}
					}
				}
				this.chartData1 = {
					categories: xAxis,
					series: [
						{
							data: yAxis
						}
					]
				};
				this.chartType1 = true
			},
			async chartClick2() {
				let res = await this.$api.getPublic('tushuxinxi/value/tushumingcheng/storeupnum')
				res = res.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
					xAxis.push(res[i]['tushumingcheng']);
					yAxis.push(parseFloat((res[i].total)));
					pArray.push({
						value: parseFloat((res[i].total)),
						name: res[i]['tushumingcheng']
					})
				}
				this.opts2 = {
					color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
					padding: [15,30,0,5],
					enableScroll: false,
					xAxis: {
						boundaryGap: "justify",
						disableGrid: false,
						min: 0,
						axisLine: false,
						max: 40
					},
					legend: {
						show: false
					},
					yAxis: {},
					extra: {
						bar: {
							type: "group",
							width: 30,
							meterBorde: 1,
							meterFillColor: "#FFFFFF",
							activeBgColor: "#000000",
							activeBgOpacity: 0.08,
							linearType: "custom",
							barBorderCircle: true,
							seriesGap: 2,
							categoryGap: 2
						}
					}
				}
				this.chartData2 = {
					categories: xAxis,
					series: [
						{
							data: yAxis
						}
					]
				};
				this.chartType2 = true
			},
			async chartClick3() {
				let res = await this.$api.getPublic('tushuxinxi/group/tushuleixing')
				res = res.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
					xAxis.push(res[i]['tushuleixing']);
					yAxis.push(parseFloat((res[i].total)));
					pArray.push({
						value: parseFloat((res[i].total)),
						name: res[i]['tushuleixing']
					})
				}
				this.opts3 = {
					color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
					padding: [15,10,0,15],
					enableScroll: false,
					legend: {
						show: false
					},
					xAxis: {
						disableGrid: true
					},
					yAxis: {
						gridType: "dash",
						dashLength: 2,
						showTitle: false
					},
					extra: {
						line: {
							type: "straight",
							width: 2,
							activeType: "hollow"
						}
					}
				}
				this.chartData3 = {
					categories: xAxis,
					series: [
						{
							data: yAxis
						}
					]
				};
				this.chartType3 = true
			},
			async chartClick4() {
				let res = await this.$api.getPublic('tushuxinxi/value/tushumingcheng/totalscore')
				res = res.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
					xAxis.push(res[i]['tushumingcheng']);
					yAxis.push(parseFloat((res[i].total)));
					pArray.push({
						value: parseFloat((res[i].total)),
						name: res[i]['tushumingcheng']
					})
				}
				this.opts4 = {
					color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
					padding: [5,5,5,5],
					enableScroll: false,
					extra: {
						pie: {
							activeOpacity: 0.5,
							activeRadius: 10,
							offsetAngle: 0,
							labelWidth: 15,
							border: false,
							borderWidth: 3,
							borderColor: "#FFFFFF"
						}
					}
				}
				this.chartData4 = {
					series: [
						{
							data: pArray
						}
					]
				};
				this.chartType4 = true
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
