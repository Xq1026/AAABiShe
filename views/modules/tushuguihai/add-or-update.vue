
































<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="图书编号" prop="tushubianhao" >
					<el-input v-model="ruleForm.tushubianhao" placeholder="图书编号" clearable  :readonly="ro.tushubianhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="图书编号" prop="tushubianhao" >
					<el-input v-model="ruleForm.tushubianhao" placeholder="图书编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="图书名称" prop="tushumingcheng" >
					<el-input v-model="ruleForm.tushumingcheng" placeholder="图书名称" clearable  :readonly="ro.tushumingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="图书名称" prop="tushumingcheng" >
					<el-input v-model="ruleForm.tushumingcheng" placeholder="图书名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="图书类型" prop="tushuleixing" >
					<el-input v-model="ruleForm.tushuleixing" placeholder="图书类型" clearable  :readonly="ro.tushuleixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="图书类型" prop="tushuleixing" >
					<el-input v-model="ruleForm.tushuleixing" placeholder="图书类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.tushufengmian" label="图书封面" prop="tushufengmian" >
					<file-upload
						tip="点击上传图书封面"
						action="file/upload"
						:limit="3"
						:disabled="ro.tushufengmian"
						:multiple="true"
						:fileUrls="ruleForm.tushufengmian?ruleForm.tushufengmian:''"
						@change="tushufengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.tushufengmian" label="图书封面" prop="tushufengmian" >
					<img v-if="ruleForm.tushufengmian.substring(0,4)=='http'&&ruleForm.tushufengmian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tushufengmian" width="100" height="100" @click="imgPreView(ruleForm.tupian)">
					<img v-else-if="ruleForm.tushufengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tushufengmian.split(',')[0]" width="100" height="100" @click="imgPreView(ruleForm.tupian.split(',')[0])">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tushufengmian.split(',')" :src="$base.url+item" width="100" height="100" @click="imgPreView($base.url+item)">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="图书作者" prop="tushuzuozhe" >
					<el-input v-model="ruleForm.tushuzuozhe" placeholder="图书作者" clearable  :readonly="ro.tushuzuozhe"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="图书作者" prop="tushuzuozhe" >
					<el-input v-model="ruleForm.tushuzuozhe" placeholder="图书作者" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="作者国籍" prop="zuozheguoji" >
					<el-input v-model="ruleForm.zuozheguoji" placeholder="作者国籍" clearable  :readonly="ro.zuozheguoji"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="作者国籍" prop="zuozheguoji" >
					<el-input v-model="ruleForm.zuozheguoji" placeholder="作者国籍" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="图书语言" prop="tushuyuyan" >
					<el-input v-model="ruleForm.tushuyuyan" placeholder="图书语言" clearable  :readonly="ro.tushuyuyan"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="图书语言" prop="tushuyuyan" >
					<el-input v-model="ruleForm.tushuyuyan" placeholder="图书语言" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="可借天数" prop="kejietianshu" >
					<el-input v-model="ruleForm.kejietianshu" placeholder="可借天数" clearable  :readonly="ro.kejietianshu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="可借天数" prop="kejietianshu" >
					<el-input v-model="ruleForm.kejietianshu" placeholder="可借天数" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="图书押金" prop="tushuyajin" >
					<el-input v-model="ruleForm.tushuyajin" placeholder="图书押金" clearable  :readonly="ro.tushuyajin"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="图书押金" prop="tushuyajin" >
					<el-input v-model="ruleForm.tushuyajin" placeholder="图书押金" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="开始时间" prop="kaishishijian" >
					<el-input v-model="ruleForm.kaishishijian" placeholder="开始时间" clearable  :readonly="ro.kaishishijian"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="开始时间" prop="kaishishijian" >
					<el-input v-model="ruleForm.kaishishijian" placeholder="开始时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="归还时间" prop="guihaishijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.guihaishijian" 
						type="datetime"
						:readonly="ro.guihaishijian"
						placeholder="归还时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.guihaishijian" label="归还时间" prop="guihaishijian" >
					<el-input v-model="ruleForm.guihaishijian" placeholder="归还时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'" label="借阅时长" prop="jieyueshizhang" >
					<el-input v-model="jieyueshizhang" placeholder="借阅时长" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.jieyueshizhang" label="借阅时长" prop="jieyueshizhang" >
					<el-input v-model="ruleForm.jieyueshizhang" placeholder="借阅时长" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="申请人账号" prop="shenqingrenzhanghao" >
					<el-input v-model="ruleForm.shenqingrenzhanghao" placeholder="申请人账号" clearable  :readonly="ro.shenqingrenzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="申请人账号" prop="shenqingrenzhanghao" >
					<el-input v-model="ruleForm.shenqingrenzhanghao" placeholder="申请人账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="申请人姓名" prop="shenqingrenxingming" >
					<el-input v-model="ruleForm.shenqingrenxingming" placeholder="申请人姓名" clearable  :readonly="ro.shenqingrenxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="申请人姓名" prop="shenqingrenxingming" >
					<el-input v-model="ruleForm.shenqingrenxingming" placeholder="申请人姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-queren15"></span>
					确定 
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-guanbi2"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui13"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
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
					kaishishijian : false,
					guihaishijian : false,
					jieyueshizhang : false,
					yonghuzhanghao : false,
					yonghuxingming : false,
					shenqingrenzhanghao : false,
					shenqingrenxingming : false,
				},
			
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
					kaishishijian: '',
					guihaishijian: '',
					jieyueshizhang: '',
					yonghuzhanghao: '',
					yonghuxingming: '',
					shenqingrenzhanghao: '',
					shenqingrenxingming: '',
				},

				rules: {
					tushubianhao: [
					],
					tushumingcheng: [
					],
					tushuleixing: [
					],
					tushufengmian: [
					],
					tushuzuozhe: [
					],
					zuozheguoji: [
					],
					tushuyuyan: [
					],
					kejietianshu: [
					],
					tushuyajin: [
					],
					kaishishijian: [
					],
					guihaishijian: [
					],
					jieyueshizhang: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					yonghuzhanghao: [
					],
					yonghuxingming: [
					],
					shenqingrenzhanghao: [
					],
					shenqingrenxingming: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {
			sessionForm() {
				return JSON.parse(this.$storage.getObj('userForm'))
			},
			sessionTable() {
				return this.$storage.get('sessionTable')
			},
			jieyueshizhang : {
				get: function () {
					let d = this.ruleForm
					let a = 'd1.kaishishijian-d1.guihaishijian'
					let n = a.split('-')
					let day = this.getDay(d[n[0].split('d1.')[1]], d[n[1].split('d1.')[1]])
					this.ruleForm.jieyueshizhang = day?day:0
					return day?day:0
				}
			},



		},
		components: {
		},
		created() {
		},
		methods: {
			imgPreView(url){
				this.$parent.imgPreView(url)
			},
			// 获取日期间隔 单位天
			getDay(first, last) {
				let date1 = new Date(first)
				let date2 = new Date(last)
				let a = date1.getTime();
				let b = date2.getTime();
				var count = 0;
				for (var i = a; i < b; i += 24 * 3600 * 1000) {
					count++;
				}
				return count;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type ) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
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
							this.ruleForm.tushufengmian = obj[o];
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
						if(o=='kaishishijian'){
							this.ruleForm.kaishishijian = obj[o];
							this.ro.kaishishijian = true;
							continue;
						}
						if(o=='guihaishijian'){
							this.ruleForm.guihaishijian = obj[o];
							this.ro.guihaishijian = true;
							continue;
						}
						if(o=='jieyueshizhang'){
							this.ruleForm.jieyueshizhang = obj[o];
							this.ro.jieyueshizhang = true;
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
				// 获取用户信息
				this.$http({
					url: `${this.sessionTable}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.sessionTable!="users"){
							this.ruleForm.shenqingrenzhanghao = json.yonghuzhanghao
							this.ro.shenqingrenzhanghao = true;
						}
						if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.sessionTable!="users"){
							this.ruleForm.shenqingrenxingming = json.yonghuxingming
							this.ro.shenqingrenxingming = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			async info(id) {
				await this.$http({
					url: `tushuguihai/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.jieyueshizhang==0){
						this.$message.error('借阅时长不能为空')
						return false
					}
					if(this.ruleForm.tushufengmian!=null) {
						this.ruleForm.tushufengmian = this.ruleForm.tushufengmian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							await this.$http({
								url: `tushuguihai/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.tushuguihaiCrossAddOrUpdateFlag = false;
											this.parent.search();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.tushuguihaiCrossAddOrUpdateFlag = false;
			},
			tushufengmianUploadChange(fileUrls) {
				this.ruleForm.tushufengmian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
	}
	.add-update-preview {
		border: 1px solid  #FFFFFF;
		border-radius: 32px;
		padding: 50px 30px;
		box-shadow: none;
		background: #f1f7fd;
		display: flex;
		flex-wrap: wrap;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: 50%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #365E77;
		white-space: nowrap;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		align-content: flex-start;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		height: 100%;
	}
	.add-update-preview /deep/ .el-form-item.editorBox {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.editorBox /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 500;
		display: block;
		width: 165px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.editorBox /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor {
		border: 0px solid #6579FE;
		border-radius: 8px;
		color: #6579FE;
		max-width: 100% !important;
		align-content: flex-start;
		background: none;
		display: flex;
		width: 100%;
		align-items: flex-start;
		flex-wrap: wrap;
		height: auto;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-toolbar {
		border: 1px solid #6579FE30;
		background: none;
		width: 100%;
		border-width: 1px 1px 0;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-container {
		border: 1px solid #6579FE30;
		background: none;
		width: 100%;
		min-height: 200px;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-container .ql-blank::before {
		color: #999;
	}
	
	.add-update-preview /deep/ .el-form-item.textBox {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.textBox /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 400;
		width: 165px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.textBox /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		align-content: flex-start;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		height: 100%;
	}
	.add-update-preview /deep/.el-form-item.textBox span.text {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 12px 12px;
		outline: none;
		color: #6579FE;
		display: block;
		width: 100%;
		font-size: 16px;
		border-width: 0;
		height: auto;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 0 30px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 0 30px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #6579FE;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #6579FE;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 15px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px;
		outline: none;
		background: #6579FE;
		width: 100%;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #6579FE30;
		cursor: pointer;
		border-radius: 4px;
		color: #6579FE;
		background: none;
		font-weight: 600;
		width: 100px;
		font-size: 30px;
		line-height: 100px;
		text-align: center;
		height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #6579FE30;
		cursor: pointer;
		border-radius: 4px;
		color: #6579FE;
		background: none;
		font-weight: 600;
		width: 100px;
		font-size: 30px;
		line-height: 100px;
		text-align: center;
		height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #6579FE30;
		cursor: pointer;
		border-radius: 4px;
		color: #6579FE;
		background: none;
		font-weight: 600;
		width: 100px;
		font-size: 30px;
		line-height: 100px;
		text-align: center;
		height: 100px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		padding: 0 10px;
		color: #365E77;
		font-size: 15px;
	}
	.add-update-preview /deep/ .el-form-item.fileupload {
		margin: 10px 0px 10px 0 ;
		display: flex;
		width: calc(50% - 0px);
	}
	.add-update-preview .el-form-item.fileupload /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #365E77;
		white-space: nowrap;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.fileupload /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		align-content: flex-start;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		height: 100%;
	}
	.add-update-preview .el-form-item.fileupload /deep/ .el-upload-dragger {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		outline: none;
		color: #333;
		background: none;
		display: flex;
		width: 100%;
		font-size: 16px;
		align-items: center;
		flex-wrap: wrap;
		height: 100px;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-icon-upload {
		margin: 0;
		color: #206cb480;
		width: 100%;
		font-size: 66px;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-upload__text {
		color: #606266;
		textalign: center;
		width: 100%;
		fontsize: 14px;
		line-height: 1;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-upload__text em {
		fontstyle: normal;
		color: #409EFF;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #6579FE30;
		border-radius: 4px;
		padding: 12px;
		outline: none;
		color: #6579FE;
		background: none;
		width: 100%;
		font-size: 16px;
		height: auto;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
		border: 0px solid #ddd;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 8px 12px 12px;
		outline: none;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: auto;
	}
	.add-update-preview /deep/ .el-form-item.btn {
		padding: 0 30px;
		margin: 30px  auto 0 auto;
		background: none;
		display: flex;
		width: auto;
		justify-content: center;
		flex-wrap: wrap;
		.btn1 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #fff;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px;
			outline: none;
			background: #6579FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #fff;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px;
			outline: none;
			background: #6579FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #fff;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px;
			outline: none;
			background: #6579FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #365E77;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px  24px  24px  24px;
			outline: none;
			background: #BED6FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #365E77;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px  24px  24px  24px;
			outline: none;
			background: #BED6FE;
			width: auto;
			min-width: 176px;
			height: 47px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 16px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
	.add-update-preview .el-form-item.btn /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #365E77;
		white-space: nowrap;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item.btn /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		align-content: flex-start;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
		height: 100%;
	}
</style>
