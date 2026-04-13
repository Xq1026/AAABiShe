  <template>
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback" @scroll="scrollChange">
		<view class="content">
			<view :style='{"minHeight":"100vh","width":"100%","padding":"0 20rpx 160rpx","position":"relative","background":"#fff","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"width":"100%","padding":"20rpx 0","background":"none","display":"flex","height":"auto"}'>
					<view  :style='{"margin":"0 12rpx","flex":"1","position":"relative"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"#666","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input  :style='{"border":"2rpx solid #666666","padding":"12rpx 20rpx 12rpx 80rpx","color":"#333","borderRadius":"20rpx","background":"#ffffff","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.tushumingcheng" type="text" placeholder="图书名称" ></input>
					</view>
					<button :style='{"border":"0","padding":"0px","margin":"0","color":"#fff","borderRadius":"20rpx","background":"#222","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			

				<view :style='{"padding":"0px","margin":"20rpx 10% 20rpx 10%","flexWrap":"wrap","background":"none","display":"flex","width":"80%","justifyContent":"center"}'>
					<view @click="sortClick('clicknum')" :style='{"border":"0","padding":"0 20rpx","margin":"0 20rpx 0 0","outline":"0","borderRadius":"40rpx","background":"#fff","display":"flex"}'>
						<text :style='{"color":"inherit","lineHeight":"60rpx","fontSize":"inherit"}'>点击量</text>
						<text v-if="listSort!='clicknum'" class="icon iconfont icon-liulan04" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='clicknum'&&listOrder=='asc'" class="icon iconfont icon-liulan04" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='clicknum'&&listOrder=='desc'" class="icon iconfont icon-liulan04" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
					</view>
					<view @click="sortClick('addtime')" :style='{"border":"0","padding":"0 20rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"40rpx","background":"#fff","display":"flex"}'>
						<text :style='{"color":"inherit","lineHeight":"60rpx","fontSize":"inherit"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
					</view>
					<view @click="sortClick('totalscore')" :style='{"border":"0","padding":"0 12rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"8rpx","background":"none","display":"flex"}'>
						<text :style='{"color":"#333333","lineHeight":"48rpx","fontSize":"24rpx"}'>评分</text>
						<text v-if="listSort!='totalscore'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#333333"}'></text>
						<text v-else-if="listSort=='totalscore'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#333333"}'></text>
						<text v-else-if="listSort=='totalscore'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 0 0 4rpx","lineHeight":"48rpx","fontSize":"24rpx","color":"#333333"}'></text>
					</view>
				</view>
				<view :style='{"alignContent":"flex-start","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto"}'>
					<scroll-view scroll-x="true" class="category-one" :style='{"border":"2rpx solid #dddddd","width":"100%","padding":"24rpx 24rpx 0","whiteSpace":"nowrap"}'>
						<view :class='categoryName === item.tushuleixing ? "active" : ""' class="tab" v-for="(item,index) in categoryList" :key="index" @tap="categoryClick(item.tushuleixing)">{{item.tushuleixing}}</view>
					</scroll-view>
					<!-- 样式2 -->
					<view class="list" :style='{"width":"100%","padding":"0","margin":"40rpx 0 0","height":"auto"}'>
						<view @tap="onDetailTap(product)" class="listm flex flex-between" :style='{"padding":"20rpx","margin":"0 0 20rpx 0","borderColor":"#dddddd","borderRadius":"0px","flexWrap":"wrap","background":"#fff","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-for="(product,index) in list" :key="index">
							<image :style='{"border":"0px solid #174add","width":"240rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"240rpx"}' mode="aspectFill" class="listmpic" v-if="preHttp(product.tushufengmian)" :src="product.tushufengmian.split(',')[0]"></image>
							<image :style='{"border":"0px solid #174add","width":"240rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"240rpx"}' mode="aspectFill" class="listmpic" v-else :src="product.tushufengmian?baseUrl+product.tushufengmian.split(',')[0]:''"></image>

							<view class="listmr" :style='{"padding":"0","margin":"0","color":"#888","flexWrap":"wrap","display":"flex","width":"calc(100% - 240rpx)","fontSize":"28rpx","height":"auto"}'>
								<view class="col3 f30 elip mb15" :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}'>{{product.tushumingcheng}}</view>
								<view class="col3 f30 elip mb15" :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}'>图书状态:{{product.tushuzhuangtai}}</view>
								<view class="col3 f30 elip mb15" :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}'>图书押金:{{product.tushuyajin}}</view>
								<view :style='{"padding":"0 20rpx"}'>
									<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit"}'></text>
									<text :style='{"lineHeight":"1.5"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
								</view>
								<view :style='{"padding":"0 20rpx"}'>
									<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit"}'></text>
									<text :style='{"lineHeight":"1.5"}'>{{product.yonghuzhanghao}}</text>
								</view>
								<view :style='{"color":"#174add","padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit"}'></text>
									<text :style='{"lineHeight":"1.5"}'>{{product.thumbsupnum}}</text>
								</view>
								<view :style='{"color":"#ffc431","padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit"}'></text>
									<text :style='{"lineHeight":"1.5"}'>{{product.storeupnum}}</text>
								</view>
								<view :style='{"color":"#f34858","padding":"0 20rpx","display":"inline-block"}'>
									<text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit"}'></text>
									<text :style='{"lineHeight":"1.5"}'>{{product.clicknum}}</text>
								</view>
							</view>
							<!-- #ifdef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"20rpx 0 0 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"border":"2rpx solid #174add","padding":"10rpx","background":"#d3e5ff","display":"flex"}' v-if="(userid && isAuth('tushuxinxi','修改')) || (!userid && isAuthFront('tushuxinxi','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#174add","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#174add","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"border":"2rpx solid #9a9a9a","padding":"10rpx","background":"#ecebeb","display":"flex"}' v-if="(userid && isAuth('tushuxinxi','删除')) || (!userid && isAuthFront('tushuxinxi','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
							<!-- #ifndef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"20rpx 0 0 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"border":"2rpx solid #174add","padding":"10rpx","background":"#d3e5ff","display":"flex"}' v-if="(userid && isAuth('tushuxinxi','修改')) || (!userid && isAuthFront('tushuxinxi','修改'))" @tap.stop.proevent="onUpdateTap(product)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#174add","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#174add","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"border":"2rpx solid #9a9a9a","padding":"10rpx","background":"#ecebeb","display":"flex"}' v-if="(userid && isAuth('tushuxinxi','删除')) || (!userid && isAuthFront('tushuxinxi','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
						</view>
					</view>
			
			
			


			
			
			
			
				</view>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx #00000030","whiteSpace":"nowrap","color":"#fff","outline":"none","borderRadius":"100%","top":"120rpx","left":"10rpx","background":"#03b882","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' class="add-btn" @click="screenBoxShow=true">筛</button>
				<button :style='{"border":"0","color":"#fff","right":"20rpx","outline":"none","borderRadius":"100%","top":"120rpx","background":"#EF7061","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('tushuxinxi','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","color":"#fff","right":"20rpx","outline":"none","borderRadius":"100%","top":"120rpx","background":"#EF7061","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('tushuxinxi','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx #00000030","color":"#ffffff","bottom":"160rpx","outline":"none","borderRadius":"100%","left":"10rpx","background":"#ffaa33","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="staticType" class="statics-btn" @click="staticClick()">
					统
				</button>
				<view :style='{"top":"0","left":"0","background":"rgba(0, 0, 0, .3)","width":"100%","position":"absolute","height":"100%","zIndex":"665"}' v-if="screenBoxShow" @click="screenBoxShow=false"></view>
				<view class="screenBox" :class="screenBoxShow?'screenBoxActive':''">
					<view  :style='{"width":"100%","padding":"0","alignItems":"center","justifyContent":"space-around","display":"flex"}'>
						<view :style='{"width":"auto","padding":"0 20rpx 0 20rpx","fontSize":"28rpx","whiteSpace":"nowrap"}'>图书作者</view>
						<input :style='{"border":"0","padding":"0 20rpx 0 20rpx","margin":"0 16rpx 0 0","borderRadius":"8rpx","background":"#f3f5f9","flex":"1","width":"75%","fontSize":"24rpx","height":"64rpx"}' placeholder="请输入图书作者" v-model="searchForm.tushuzuozhe">
					</view>
					<view  :style='{"width":"100%","padding":"0","alignItems":"center","justifyContent":"space-around","display":"flex"}'>
						<view :style='{"width":"auto","padding":"0 20rpx 0 20rpx","fontSize":"28rpx","whiteSpace":"nowrap"}'>图书语言</view>
						<input :style='{"border":"0","padding":"0 20rpx 0 20rpx","margin":"0 16rpx 0 0","borderRadius":"8rpx","background":"#f3f5f9","flex":"1","width":"75%","fontSize":"24rpx","height":"64rpx"}' placeholder="请输入图书语言" v-model="searchForm.tushuyuyan">
					</view>
					<view  :style='{"width":"100%","padding":"10rpx 0 10rpx 0"}'>
						<view :style='{"width":"100%","padding":"0 0 0px 10rpx","fontSize":"24rpx"}'>图书状态</view>
						<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-around","display":"flex"}'>
							<view @click="tushuzhuangtaiChange(item)" v-for="(item,index) in tushuzhuangtaiOptions" :key="index" class="screenTab" :class="searchForm.tushuzhuangtai==item?'screenTabActive':''">{{item}}</view>
						</view>
					</view>
					<view :style='{"width":"100%","padding":"20rpx 0 0","alignItems":"center","justifyContent":"space-around","display":"flex"}'>
						<div :style='{"color":"#888","borderRadius":"8rpx","textAlign":"center","background":"#ededed","width":"30%","lineHeight":"68rpx","height":"68rpx"}' @click="screenReset">重置</div>
						<div :style='{"color":"#fff","borderRadius":"8rpx","textAlign":"center","background":"#03b882","width":"30%","lineHeight":"68rpx","height":"68rpx"}' @click="search">搜索</div>
					</view>
				</view>
			</view>
		</view>
		<!-- <view v-if="scrollTop>200" @tap="scrollTopClick" :style='{"boxShadow":"0 8rpx 16rpx rgba(0,0,0,.3)","borderRadius":"50%","textAlign":"center","bottom":"20%","background":"#ff000030","width":"60rpx","lineHeight":"60rpx","position":"fixed","right":"20rpx","height":"60rpx","zIndex":"9999"}'>
			<span class="icon iconfont icon-jiantou07" :style='{"color":"#fff"}'></span>
		</view> -->
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				tushuzhuangtaiOptions:[],
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				clicknumColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
					onScroll: true,
					toTop: true
				},
				hasNext: true,
				searchForm:{
					tushumingcheng: '',
					tushuzuozhe: '',
					tushuyuyan: '',
					tushuzhuangtai: '',
				},
				categoryList:[],
				categoryName :'全部',
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
				scrollTop: 0,
				staticType: false,
				chartData1: {},
				opts1: {},
				chartData2: {},
				opts2: {},
				chartData3: {},
				opts3: {},
				chartData4: {},
				opts4: {},
			};
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			username() {
				return uni.getStorageSync("nickname")
			},
			role() {
				return uni.getStorageSync("appRole")
			},
		},
		onUnload() {
			uni.removeStorageSync("useridTag");
		},
		async onShow() {
			if(uni.getStorageSync("useridTag")==1){
				this.userid=uni.getStorageSync("useridTag");
				if(
					this.isAuth('tushuxinxi','图书浏览量')
					||this.isAuth('tushuxinxi','图书收藏量')
					||this.isAuth('tushuxinxi','图书评分')
					||this.isAuth('tushuxinxi','图书类型')
				) {
					this.staticType = true
				}else {
					this.staticType = false
				}
				let remindRes = null
			} else {
				this.userid = "";
				if(
					this.isAuthFront('tushuxinxi','图书浏览量')
					||this.isAuthFront('tushuxinxi','图书收藏量')
					||this.isAuthFront('tushuxinxi','图书评分')
					||this.isAuthFront('tushuxinxi','图书类型')
				) {
					this.staticType = true
				}else {
					this.staticType = false
				}
			}
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.clicknumColor = this.clicknumColor.sort(()=> {
				return (0.5-Math.random());
			});
			let res = {};
			if(this.userid) {
				res = await this.$api.page('tushuleixing', {page:1,limit:100});
			} else {
				res = await this.$api.list('tushuleixing', {page:1,limit:100});
			}
			res.data.list.splice(0,0,{id:0,tushuleixing:'全部'})
			this.categoryList = res.data.list;
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
			this.$forceUpdate()
		},
		async onLoad(options) {
			this.hasNext = true
			// 重新加载数据
			// if (this.mescroll) this.mescroll.resetUpScroll()
			let res = {};
			this.tushuzhuangtaiOptions = '已借出,未借出'.split(',')
		},
		components: {
		},
		methods: {
			queryChange(arr){
				for(let x in arr) {
					if(arr[x] == this.role) {
						return true
					}
				}
				return false
			},
			scrollChange(e){
				this.scrollTop = e.scrollTop
			},
			scrollTopClick(){
				uni.pageScrollTo({
					scrollTop: 0
				})
			},
			tushuzhuangtaiChange(e){
				this.searchForm.tushuzhuangtai = e
				this.$forceUpdate()
			},
			screenReset(){
				this.searchForm = {}
				this.search()
				this.$forceUpdate()
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//类别搜索
			categoryClick(categoryName){
				this.categoryName = categoryName;
				this.mescroll.resetUpScroll();
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size,
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.categoryName!='全部'){
					params.tushuleixing = '%' + this.categoryName + '%'
				}
				if(this.searchForm.tushumingcheng){
					params['tushumingcheng'] = '%' + this.searchForm.tushumingcheng + '%'
				}
				if(this.searchForm.tushuzuozhe){
					params['tushuzuozhe'] = '%' + this.searchForm.tushuzuozhe + '%'
				}
				if(this.searchForm.tushuyuyan){
					params['tushuyuyan'] = '%' + this.searchForm.tushuyuyan + '%'
				}
				if(this.searchForm.tushuzhuangtai){
					params['tushuzhuangtai'] = '%' + this.searchForm.tushuzhuangtai + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`tushuxinxi`, params);
                } else {
                    res = await this.$api.list(`tushuxinxi`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
				uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var that = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await that.$api.del('tushuxinxi', JSON.stringify([id]));
							let obj = await that.$api.list('storeup',{
								page: 1,
								limit: 100,
								tablename: 'tushuxinxi',
								refid: id,
							})
							if(obj.data.list.length){
								let arr = []
								for(let x in obj.data.list){
									arr.push(obj.data.list[x].id)
								}
								await that.$api.del('storeup',JSON.stringify(arr))
							}
							that.$utils.msg('删除成功');
							that.hasNext = true
							// 重置分页参数页数为1
							that.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size,
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.tushumingcheng){
					searchForm['tushumingcheng'] = '%' + this.searchForm.tushumingcheng + '%'
				}
				if(this.categoryName!='全部'){
					searchForm.tushuleixing = '%' + this.categoryName + '%'
				}
				if(this.searchForm.tushuzuozhe){
					searchForm['tushuzuozhe'] = '%' + this.searchForm.tushuzuozhe + '%'
				}
				if(this.searchForm.tushuyuyan){
					searchForm['tushuyuyan'] = '%' + this.searchForm.tushuyuyan + '%'
				}
				if(this.searchForm.tushuzhuangtai){
					searchForm['tushuzhuangtai'] = '%' + this.searchForm.tushuzhuangtai + '%'
				}
				let res = {};
				if(this.userid) {
					res = await this.$api.page(`tushuxinxi`, searchForm);
				} else {
					res = await this.$api.list(`tushuxinxi`, searchForm);
				}
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			},
			staticClick() {
				this.$utils.jump(`./add-or-update?showType=2&userid=` + this.userid)
			},
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.category-one .tab {
		cursor: pointer;
		padding: 0 20rpx 0 32rpx;
		color: #333;
		background: #fff;
		display: inline-block;
		width: auto;
		font-size: 30rpx;
		line-height: 80rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		padding: 0 20rpx 0 32rpx;
		color: #fff;
		background: #174add;
		display: inline-block;
		width: auto;
		font-size: 30rpx;
		line-height: 80rpx;
	}
	.screenBox {
		padding: 100rpx 0 20rpx 0;
		transform: translate3d(100%, 0, 0);
		z-index: 6666;
		top: 0;
		background: #fff;
		width: 80%;
		overflow-y: auto;
		position: absolute;
		right: 0;
		transition: transform .3s;
		height: 100%;
		.screenTab {
			border-radius: 8rpx;
			margin: 10rpx 0 10rpx 0;
			background: #f3f5f9;
			width: calc(100% / 3 - 24rpx);
			line-height: 64rpx;
			text-align: center;
		}
		.screenTabActive {
			border-radius: 8rpx;
			margin: 10rpx 0 10rpx 0;
			color: #fff;
			background: #03b882;
			width: calc(100% / 3 - 20rpx);
			line-height: 64rpx;
			text-align: center;
		}
	}
	.screenBoxActive {
		transform: translate3d(0, 0, 0);
	}
</style>
