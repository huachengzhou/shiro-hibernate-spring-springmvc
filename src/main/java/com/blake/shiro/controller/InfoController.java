package com.blake.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.SecurityManager;
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

import com.blake.base.dao.PageResult;
import com.blake.common.USER;
import com.blake.entiyi.Info;
import com.blake.entiyi.User;
import com.blake.shiro.service.InfoService;

@Controller
public class InfoController{
	
	@Autowired
	@Qualifier("infoService")
	private InfoService infoService;
	
	@Autowired
	SecurityManager securityManager;

	@RequiresPermissions(value = { "user:select" })
	@RequestMapping(value = "/showInfoList")
	public String showList(Model model,@RequestParam(defaultValue="1") Integer pageNo,@RequestParam(defaultValue="4") Integer pageSize) {
		PageResult pageResult = infoService.getPages(pageNo, pageSize);
		model.addAttribute("pageResult", pageResult);
		return "info/showInfoList";
	}

	@RequiresPermissions(value = { "user:remove" })
	@RequestMapping(value="/removeInfo")
	public String removeInfo(@RequestParam Integer info_id) {
		infoService.delete(info_id);
		return "redirect:/showInfoList";
	}

	public String update_Forward() {
		return null;
	}

	public String update() {
		return null;
	}

	@RequiresPermissions(value = { "user:save" })
	@RequestMapping("/save_ForWardInfo")
	public String save_ForWard(Model model) {
		model.addAttribute("info",new Info());
		return "info/save_ForWardInfo";
	}

	@RequiresPermissions(value = { "user:save" })
	@RequestMapping(value="/saveInfo",method=RequestMethod.POST)
	public String save(@ModelAttribute Info info) {
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		User user = (User) session.getAttribute(USER.User_sessionName);
		info.setUser(user);
		infoService.save(info);
		return "redirect:/showInfoList";
	}

}
