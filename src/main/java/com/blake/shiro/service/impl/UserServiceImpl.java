package com.blake.shiro.service.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blake.base.dao.PageResult;
import com.blake.entiyi.Privilege;
import com.blake.entiyi.Role;
import com.blake.entiyi.User;
import com.blake.shiro.dao.UserDao;
import com.blake.shiro.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier(value="userDao")
	private UserDao userDao;

	@Transactional(readOnly=false)
	public void save(User entity) {
		userDao.save(entity);
	}

	@Transactional(readOnly=false)
	public void update(User entity) {
		userDao.update(entity);
	}

	@Transactional(readOnly=false)
	public void delete(Serializable id) {
		userDao.delete(User.class, id);
	}

	@Transactional
	public User findObjectById(Serializable id) {
		return userDao.findObjectById(User.class, id);
	}

	@Transactional
	public List<User> findObjects() {
		return userDao.findObjects(User.class);
	}

	@Transactional(readOnly=false)
	public void delete(Serializable[] ids) {
		userDao.delete(User.class, ids);
	}

	@Transactional
	public User login(String username) {
		return userDao.login(username);
	}

	@Transactional
	public List<User> findUsersByAcccountAndPass(String username, String password) {
		return userDao.findUsersByAcccountAndPass(username, password);
	}

	@Transactional
	public Set<String> findRoles(String username) {
		User user = userDao.login(username);
		Set<Role> roles = user.getRoles();
		Set<String> rSet = new HashSet<String>();
		for (Role role : roles) {
			rSet.add(role.getRole());
		}
		return rSet;
	}

	@Transactional
	public Set<String> findPermissions(String username) {
		Set<String> permissions = new HashSet<String>();
		User user = userDao.login(username);
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			Set<Privilege> privileges = role.getPrivileges();
			for (Privilege privilege : privileges) {
				permissions.add(privilege.getDescription());
			}
		}
		return permissions;
	}

	@Transactional
	public PageResult getPages(Integer pageNo, Integer pageSize) {
		return userDao.getPages(pageNo, pageSize,User.class);
	}

}
