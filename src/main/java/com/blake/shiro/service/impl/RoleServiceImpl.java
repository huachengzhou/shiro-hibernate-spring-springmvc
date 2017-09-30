package com.blake.shiro.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blake.base.dao.PageResult;
import com.blake.entiyi.Role;
import com.blake.shiro.dao.RoleDao;
import com.blake.shiro.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	@Qualifier("roleDao")
	private RoleDao roleDao;
	
	@Transactional(readOnly=false)
	public void save(Role entity) {
		roleDao.save(entity);
	}

	@Transactional(readOnly=false)
	public void update(Role entity) {
		roleDao.update(entity);
	}

	@Transactional(readOnly=false)
	public void delete(Serializable id) {
		roleDao.delete(Role.class, id);
	}

	@Transactional
	public Role findObjectById(Serializable id) {
		return roleDao.findObjectById(Role.class, id);
	}

	@Transactional
	public List<Role> findObjects() {
		return roleDao.findObjects(Role.class);
	}

	@Transactional(readOnly=false)
	public void delete(Serializable[] ids) {
		roleDao.delete(Role.class, ids);
	}

	@Transactional
	public PageResult getPages(Integer pageNo, Integer pageSize) {
		return roleDao.getPages(pageNo, pageSize,Role.class);
	}

}
