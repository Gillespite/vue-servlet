# vue-servlet
前端vue 后端servlet 数据库jdbc 的混搭 

没有上过web课程 但是学校的实训课要求做web项目 讲的是jsp+servlet 搜了一下jsp的相关资料 发现好多都是在劝退jsp的 所以打算前端用vue做 后端用servlet 前后端交互用vue-resource这个插件 (借鉴了https://blog.csdn.net/cnds123321/article/details/103995065 ) 不过后来发现这个插件官方已经不推荐使用了 官方现在推荐的是axios **vue-resource貌似只支持低版本vue,如果你要使用高版本vue的特性 请提前测试** 但是当时没时间改了 所以就这么用下来了

## 免责提醒
赶工赶了一天半出来的,所以很多地方写的非常之烂(尤其是页面跳转),请酌情参考

## 功能介绍:
1. 主页(登陆,注册按钮) ✅index.html
2. 登陆页面✅login.html
3. 注册页面✅reg.html

1. 普通员工页面✅me.html
2. 员工修改个人信息页面✅fix.html
3. 员工打卡页面✅dayevent.html

1. 员工申请页面(选择申请加薪,申请离职,申请升职)✅want.html
2. 员工申请加薪页面✅wantmoney.html
3. 员工申请离职页面✅wantquit.html

1. 员工申请升职页面✅wantup.html
2. 领导页面✅admin.html
3. 查看员工页面✅getall.html

1. 员工管理页面(开除员工)✅manage.html

1. 查看员工打卡情况页面✅dayeventresult.html
2. 查看时间✅world.html
3. 改变时间,用于测试打卡等功能✅timefix.html

## 数据库
要连接数据库,需要修改src/jdbc/dao/daoBas.java里的数据库链接
建立数据库代码如下
```sql
create table user
(
	id char(20) primary key,#编号
	name char(20) not null,#姓名
	password char(20) not null,#密码
	loc char(20),#地址
	tel char(20),#电话
	pay int,#工资
	pro char(20) check(pro in ('助教','讲师','副教授','教授')),#职称
	isadmin int not null #是否为管理员(领导)
);
#insert into user (id,name,password,loc,tel,pay,pro,isadmin) values (?,?,?,?,?,?,?,?)
#update user set name='bot3',password='1234',loc='new',tel='110',pay=2000,pro=2,isadmin=1 where id='2020001';
create table act
(
	actid char(20) primary key,#事件编号
	id char(20) not null,#员工编号
	foreign key(id) references user(id),
	str char(100),
	want char(100),
	event char(50)check(event in ('加薪','升职','离职')),#申请种类
	ispass int#是否通过
);

create table dayevent
(
	dayday int not null,#日期
	id char(20) not null,#员工编号
	primary key(dayday,id),
	foreign key(id) references user(id),
	isover int
);

create table world
(
	id int primary key,#日期
	myday int
);

```
