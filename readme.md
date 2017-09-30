采用的是maven管理工程
项目架构是 springmvc4.2.4.RELEASE+spring4.2.4.RELEASE+shiro1.22+hibernate5.1.0.Final
前端框架采用的是bootstrap
实现了角色+权限+用户的控制,另外为了能够更好的查看效果我加了一个实体类
即Info
权限才用的是注解方式

root -> admin可以添加角色,在添加的时候就可以选择所有的权限
其他用户可以根据权限的情况能够增加Info删除Info查看Info

然后是密码采用的是Base64加密
加密思路为
加密密码 String pass = password+salt(盐)==>然后调用Base64UU工具类的setString获取到加密密码
然后把加密密码和salt存入数据库  --->salt我是用uuid生成然后截取前面15位
解密同样很简单的String password = Base64UU.getString(password+salt);
解密后的密码要注意假如你的密码是123456盐是xxsdgshsgs
那么解密后的密码是123456xxsdgshsgs,利用String的截取方法截取password即可

String pass = Base64UU.getString(user.getPassword());
pass = pass.substring(0,pass.lastIndexOf(user.getSalt()));
UserRealm Class主要是身份验证以及验证成功利用username获取角色和权限,然后在注入Subject中

之后就可以在Controller上面利用注解比如:
@RequiresPermissions(value = { "user:select" })
当然也可以利用Spring的aop也是一样呢
