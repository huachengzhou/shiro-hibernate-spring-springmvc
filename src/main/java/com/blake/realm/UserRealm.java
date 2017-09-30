package com.blake.realm;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.blake.common.Base64UU;
import com.blake.entiyi.User;
import com.blake.shiro.service.UserService;

public class UserRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;
	
	/**获取身份验证相关信息*/
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		System.out.println("doGetAuthorizationInfo:"+username);
		Set<String> rSet = userService.findRoles(username);
		Set<String> stringPermissions = userService.findPermissions(username);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(rSet);//添加角色信息
		authorizationInfo.setStringPermissions(stringPermissions);//添加权限信息
		return authorizationInfo;
	}

	/**获取授权信息*/
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		User user = userService.login(username);
		System.out.println("username:"+username+"<------");
		System.out.println("user:"+user+"----->");
		if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
		String pass = Base64UU.getString(user.getPassword());
		pass = pass.substring(0,pass.lastIndexOf(user.getSalt()));
		//交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                pass, //密码-->加密之后再比较
                ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
                getName()  //realm name
        );
		return authenticationInfo;
	}

	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	protected void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}
	/**------------------------ok-----------------------------**/
	public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
