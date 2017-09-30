package com.blake.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.blake.common.USER;
import com.blake.entiyi.User;
import com.blake.shiro.service.UserService;
public class UserSessionFilter extends AccessControlFilter {
	
	@Autowired
	private UserService userService;
	
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		return true;
	}

	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		return true;
	}


	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		org.apache.shiro.subject.Subject subject = getSubject(request, response);
	      if (subject == null) {
	          // 没有登录
	          return false;
	      }
	      HttpSession session = WebUtils.toHttp(request).getSession();
	      Object sessionUsername = session.getAttribute(USER.User_sessionName);
	      if (sessionUsername == null) {
	         // 你自己的逻辑
	    	  String username = (String)SecurityUtils.getSubject().getPrincipal();
	    	  User user = userService.login(username);
	    	  HttpServletRequest req = (HttpServletRequest) request;
	    	  req.getSession().setAttribute(USER.User_sessionName,user);
	      }
	      return true;
	}

}
