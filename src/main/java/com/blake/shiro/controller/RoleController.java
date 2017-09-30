package com.blake.shiro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blake.base.dao.PageResult;
import com.blake.entiyi.Privilege;
import com.blake.entiyi.Role;
import com.blake.shiro.base_controller.BController;
import com.blake.shiro.service.PrivilegeService;
import com.blake.shiro.service.RoleService;

@Controller
public class RoleController extends BController{

	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;
	
	@Autowired
	@Qualifier("privilegeService")
	private PrivilegeService privilegeService;
	
	@RequestMapping("/removeRole")
	public String remove(@RequestParam(defaultValue="") Integer rid) {
		try {
			roleService.delete(rid);
		} catch (Exception e) {
		}
		return "redirect:/showRoleList";
	}

	@RequestMapping("/showRoleList")
	public String showList(Model model,@RequestParam(defaultValue="1") Integer pageNo,@RequestParam(defaultValue="4") Integer pageSize) {
		PageResult pageResult = roleService.getPages(pageNo, pageSize);
		model.addAttribute("pageResult", pageResult);
		return "role/showRoleList";
	}

	@RequestMapping("/save_ForWardRole")
	public String save_ForWard(Model model) {
		List<Privilege> privileges = privilegeService.findObjects();
		model.addAttribute("role",new Role());
		model.addAttribute("privileges",privileges);
		return "role/save_ForWardRole";
	}

	@RequestMapping("/saveRole")
	public String save(@ModelAttribute Role role,@RequestParam String roleR,@RequestParam String pids) {
		role.setRole(roleR);
		String[] pid = pids.split(",");
		roleService.save(role);
		for (String string : pid) {
			Privilege privilege = privilegeService.findObjectById(Integer.parseInt(string));
			privilege.getRoles().add(role);
			privilegeService.update(privilege);
		}
		return "redirect:/showRoleList";
	}
	
}
