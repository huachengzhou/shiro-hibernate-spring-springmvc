package com.blake.shiro.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blake.base.dao.PageResult;
import com.blake.common.Base64UU;
import com.blake.entiyi.Role;
import com.blake.entiyi.User;
import com.blake.shiro.base_controller.BController;
import com.blake.shiro.service.RoleService;
import com.blake.shiro.service.UserService;

@Controller
public class UserController extends BController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;

	@RequestMapping("/showListUser")
	public String showList(Model model,@RequestParam(defaultValue="1") Integer pageNo,@RequestParam(defaultValue="4") Integer pageSize) {
		PageResult pageResult = userService.getPages(pageNo, pageSize);
		model.addAttribute("pageResult", pageResult);
		return "user/showListUser";
	}

	@RequestMapping("/removeUser")
	public String remove(@RequestParam Integer uid) {
		userService.delete(uid);
		return "redirect:/showListUser";
	}

	public String update_Forward() {
		return null;
	}

	public String update() {
		return null;
	}

	@RequestMapping("/save_ForWardUser")
	public String save_ForWard(Model model) {
		List<Role> roles = roleService.findObjects();
		model.addAttribute("user", new User());
		model.addAttribute("roles", roles);
		return "user/save_ForWardUser";
	}

	@RequestMapping("/saveUser")
	public String save(@ModelAttribute User user, @RequestParam String rid) {
		String salt = UUID.randomUUID().toString().substring(15);
		String password = user.getPassword() + "" + salt;
		String[] rids = rid.split(",");
		Set<Role> roles = new HashSet<Role>();
		Role role = null;
		for (String string : rids) {
			role = roleService.findObjectById(Integer.parseInt(string));
			roles.add(role);
		}
		user.setRoles(roles);
		password = Base64UU.setString(password);
		user.setSalt(salt);
		user.setPassword(password);
		if (!StringUtils.isEmpty(user)) {
			userService.save(user);
		}
		for (Role role1 : roles) {
			role1.getUsers().add(user);
			roleService.update(role1);
		}
		return "redirect:/showListUser";
	}

}
