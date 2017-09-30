package com.blake.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blake.common.USER;
import com.blake.entiyi.User;
import com.blake.shiro.service.UserService;

@Controller
public class Login_Logout {
	
	@Autowired
	@Qualifier(value="userService")
	private UserService userService;
	
	@Autowired
	SecurityManager securityManager;
	
	@RequestMapping(value="/login_forward")
	public String login_forward(Model model){
		System.out.println("login_forward");
		model.addAttribute("user",new User());
		return "login";
	}
	
	/**
	 * 登陆操作
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute User user,Model model,@RequestParam(defaultValue="true") boolean rememberMe){
		System.out.println("login  data:"+user);
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
//		token.setRememberMe(true);//记住我---?自动登陆
		try{
			subject.login(token);
			System.out.println("登陆成功!");
			Session session = subject.getSession();
			session.setAttribute(USER.User_sessionName,userService.login(user.getUsername()));
			session.setAttribute("info", "session的数据");
			return "main";
		}catch(Exception e){
			System.err.println("登陆失败!");
			System.err.println(e.getMessage());
			model.addAttribute("user",new User());
			model.addAttribute("errorMsg", "用户名或密码错误！");
			model.addAttribute("error", e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();//清空数据
		System.out.println("--->");
		return "login";
	}
}
