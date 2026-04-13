  <template>
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback" @scroll="scrollChange">
		<view class="content">
			<view :style='{"minHeight":"100vh","width":"100%","padding":"0 20rpx 160rpx","position":"relative","background":"#fff","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"width":"100%","padding":"20rpx 0","background":"none","display":"flex","height":"auto"}'>
				</view>
			

				<view :style='{"padding":"0px","margin":"20rpx 10% 20rpx 10%","flexWrap":"wrap","background":"none","display":"flex","width":"80%","justifyContent":"center"}'>
					<view @click="sortClick('addtime')" :style='{"border":"0","padding":"0 20rpx","margin":"0 8rpx 0 0","outline":"0","borderRadius":"40rpx","background":"#fff","display":"flex"}'>
						<text :style='{"color":"inherit","lineHeight":"60rpx","fontSize":"inherit"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"60rpx","fontSize":"inherit","color":"inherit"}'></text>
					</view>
				</view>
				<view :style='{"alignContent":"flex-start","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","width":"100%","height":"auto"}'>
					<!-- 样式2 -->
					<view class="list" :style='{"width":"100%","padding":"0","margin":"40rpx 0 0","height":"auto"}'>
						<view @tap="onDetailTap(product)" class="listm flex flex-between" :style='{"padding":"20rpx","margin":"0 0 20rpx 0","borderColor":"#dddddd","borderRadius":"0px","flexWrap":"wrap","background":"#fff","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-for="(product,index) in list" :key="index">
							<image :style='{"border":"0px solid #174add","width":"240rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"240rpx"}' mode="aspectFill" class="listmpic" v-if="preHttp(product.tushufengmian)" :src="product.tushufengmian.split(',')[0]"></image>
							<image :style='{"border":"0px solid #174add","width":"240rpx","objectFit":"cover","borderRadius":"20rpx","display":"block","height":"240rpx"}' mode="aspectFill" class="listmpic" v-else :src="product.tushufengmian?baseUrl+product.tushufengmian.split(',')[0]:''"></image>

							<view class="listmr" :style='{"padding":"0","margin":"0","color":"#888","flexWrap":"wrap","display":"flex","width":"calc(100% - 240rpx)","fontSize":"28rpx","height":"auto"}'>
								<view class="col3 f30 elip mb15" :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}'>{{product.tushumingcheng}}</view>
								<view :style='{"padding":"0 20rpx"}'>
									<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit"}'></text>
									<text :style='{"lineHeight":"1.5"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
								</view>
								<view :style='{"padding":"0 20rpx"}'>
									<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"inherit"}'></text>
									<text :style='{"lineHeight":"1.5"}'>{{product.yonghuzhanghao}}</text>
								</view>
							</view>
							<!-- #ifdef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"20rpx 0 0 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"border":"2rpx solid #174add","padding":"10rpx","background":"#d3e5ff","display":"flex"}' v-if="(userid && isAuth('yajintuihai','修改')) || (!userid && isAuthFront('yajintuihai','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#174add","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#174add","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"border":"2rpx solid #9a9a9a","padding":"10rpx","background":"#ecebeb","display":"flex"}' v-if="(userid && isAuth('yajintuihai','删除')) || (!userid && isAuthFront('yajintuihai','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
							<!-- #ifndef MP-WEIXIN -->
							<view :style='{"width":"100%","padding":"8rpx 20rpx","margin":"20rpx 0 0 0","justifyContent":"space-between","display":"flex","height":"auto"}'>
								<view :style='{"border":"2rpx solid #174add","padding":"10rpx","background":"#d3e5ff","display":"flex"}' v-if="(userid && isAuth('yajintuihai','修改')) || (!userid && isAuthFront('yajintuihai','修改'))" @tap.stop.proevent="onUpdateTap(product)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#174add","display":"inline-block"}' class="cuIcon-edit"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#174add","display":"inline-block"}'>修改</text>
								</view>
								<view :style='{"border":"2rpx solid #9a9a9a","padding":"10rpx","background":"#ecebeb","display":"flex"}' v-if="(userid && isAuth('yajintuihai','删除')) || (!userid && isAuthFront('yajintuihai','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
									<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}' class="cuIcon-delete"></text>
									<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"#666","display":"inline-block"}'>删除</text>
								</view>
							</view>
							<!-- #endif -->
						</view>
					</view>
			
			
			


			
			
			
			
				</view>
				<button :style='{"border":"0","color":"#fff","right":"20rpx","outline":"none","borderRadius":"100%","top":"120rpx","background":"#EF7061","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="userid && isAuth('yajintuihai','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","color":"#fff","right":"20rpx","outline":"none","borderRadius":"100%","top":"120rpx","background":"#EF7061","width":"80rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"999"}' v-if="!userid && isAuthFront('yajintuihai','新增')" class="add-btn" @click="onAddTap()">新增</button>
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
				ispayOptions: ['已支付','未支付'],
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
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
					ispay: '',
				},
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
				scrollTop: 0,
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
				let remindRes = null
			} else {
				this.userid = "";
			}
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
			this.$forceUpdate()
		},
		async onLoad(options) {
			this.hasNext = true
			// 重新加载数据
			// if (this.mescroll) this.mescroll.resetUpScroll()
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
			ispayChange(e){
				this.searchForm.ispay = e
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

				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`yajintuihai`, params);
                } else {
                    res = await this.$api.list(`yajintuihai`, params);
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
							await that.$api.del('yajintuihai', JSON.stringify([id]));
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

				if(this.searchForm.ispay){
					searchForm['ispay'] = this.searchForm.ispay
				}
				let res = {};
				if(this.userid) {
					res = await this.$api.page(`yajintuihai`, searchForm);
				} else {
					res = await this.$api.list(`yajintuihai`, searchForm);
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
</style>
