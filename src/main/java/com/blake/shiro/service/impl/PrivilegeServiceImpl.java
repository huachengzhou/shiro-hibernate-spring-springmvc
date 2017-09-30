package com.blake.shiro.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blake.base.dao.PageResult;
import com.blake.entiyi.Privilege;
import com.blake.shiro.dao.PrivilegeDao;
import com.blake.shiro.service.PrivilegeService;

@Service(value="privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	@Qualifier("privilegeDao")
	private PrivilegeDao privilegeDao;
	
	@Transactional(readOnly=false)
	public void save(Privilege entity) {
		privilegeDao.save(entity);
	}

	@Transactional(readOnly=false)
	public void update(Privilege entity) {
		privilegeDao.update(entity);
	}

	@Transactional(readOnly=false)
	public void delete(Serializable id) {
		privilegeDao.delete(Privilege.class, id);
	}

	@Override
	public Privilege findObjectById(Serializable id) {
		return privilegeDao.findObjectById(Privilege.class, id);
	}

	@Override
	public List<Privilege> findObjects() {
		return privilegeDao.findObjects(Privilege.class);
	}

	@Transactional(readOnly=false)
	public void delete(Serializable[] ids) {
		privilegeDao.delete(Privilege.class, ids);
	}

	@Override
	public PageResult getPages(Integer pageNo, Integer pageSize) {
		return privilegeDao.getPages(pageNo, pageSize,Privilege.class);
	}

}
