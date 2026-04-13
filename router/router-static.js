	import Vue from 'vue';
//配置路由
	import VueRouter from 'vue-router'
	Vue.use(VueRouter);
//1.创建组件
	import Index from '@/views/index'
	import Home from '@/views/home'
	import Login from '@/views/login'
	import NotFound from '@/views/404'
	import UpdatePassword from '@/views/update-password'
	import pay from '@/views/pay'
	import register from '@/views/register'
	import center from '@/views/center'
	import yonghu from '@/views/modules/yonghu/list'
	import tushuxinxi from '@/views/modules/tushuxinxi/list'
	import tushuleixing from '@/views/modules/tushuleixing/list'
	import shenqingjieyue from '@/views/modules/shenqingjieyue/list'
	import zhifuyajin from '@/views/modules/zhifuyajin/list'
	import tushuyuedu from '@/views/modules/tushuyuedu/list'
	import tushuguihai from '@/views/modules/tushuguihai/list'
	import jieyuechaoshi from '@/views/modules/jieyuechaoshi/list'
	import chaoshipeifu from '@/views/modules/chaoshipeifu/list'
	import yajintuihai from '@/views/modules/yajintuihai/list'
	import forum from '@/views/modules/forum/list'
	import forumreport from '@/views/modules/forumreport/list'
	import chatmessage from '@/views/modules/chatmessage/list'
	import friend from '@/views/modules/friend/list'
	import chat from '@/views/modules/chat/list'
	import aboutus from '@/views/modules/aboutus/list'
	import systemintro from '@/views/modules/systemintro/list'
	import emailregistercode from '@/views/modules/emailregistercode/list'
	import users from '@/views/modules/users/list'
	import discusstushuxinxi from '@/views/modules/discusstushuxinxi/list'
import config from '@/views/modules/config/list'

//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/tushuxinxi',
		name: '图书信息',
		component: tushuxinxi
	}
	,{
		path: '/tushuleixing',
		name: '图书类型',
		component: tushuleixing
	}
	,{
		path: '/shenqingjieyue',
		name: '申请借阅',
		component: shenqingjieyue
	}
	,{
		path: '/zhifuyajin',
		name: '支付押金',
		component: zhifuyajin
	}
	,{
		path: '/tushuyuedu',
		name: '图书阅读',
		component: tushuyuedu
	}
	,{
		path: '/tushuguihai',
		name: '图书归还',
		component: tushuguihai
	}
	,{
		path: '/jieyuechaoshi',
		name: '借阅超时',
		component: jieyuechaoshi
	}
	,{
		path: '/chaoshipeifu',
		name: '超时赔付',
		component: chaoshipeifu
	}
	,{
		path: '/yajintuihai',
		name: '押金退还',
		component: yajintuihai
	}
	,{
		path: '/forum',
		name: '社区互动',
		component: forum
	}
	,{
		path: '/forumreport',
		name: '论坛举报',
		component: forumreport
	}
	,{
		path: '/chatmessage',
		name: '消息表',
		component: chatmessage
	}
	,{
		path: '/friend',
		name: '好友表',
		component: friend
	}
	,{
		path: '/chat',
		name: '智能AI问答',
		component: chat
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/systemintro',
		name: '系统简介',
		component: systemintro
	}
	,{
		path: '/emailregistercode',
		name: '邮箱验证码',
		component: emailregistercode
	}
	,{
		path: '/users',
		name: '管理员',
		component: users
	}
	,{
		path: '/discusstushuxinxi',
		name: '图书信息评论',
		component: discusstushuxinxi
	}
	,{
		path: '/config/:type',
		name: '配置管理',
		component: config
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
