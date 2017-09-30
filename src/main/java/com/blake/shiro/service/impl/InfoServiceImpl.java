package com.blake.shiro.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blake.base.dao.PageResult;
import com.blake.entiyi.Info;
import com.blake.shiro.dao.InfoDao;
import com.blake.shiro.service.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService{

	@Autowired
	@Qualifier("infoDao")
	private InfoDao infoDao;
	
	@Transactional(readOnly=false)
	public void save(Info entity) {
		infoDao.save(entity);
	}

	@Transactional(readOnly=false)
	public void update(Info entity) {
		infoDao.update(entity);
	}

	@Transactional(readOnly=false)
	public void delete(Serializable id) {
		infoDao.delete(Info.class, id);
	}
	@Transactional
	public Info findObjectById(Serializable id) {
		return infoDao.findObjectById(Info.class, id);
	}
	@Transactional
	public List<Info> findObjects() {
		return infoDao.findObjects(Info.class);
	}

	@Transactional(readOnly=false)
	public void delete(Serializable[] ids) {
		infoDao.delete(Info.class, ids);
	}
	
	@Transactional
	public PageResult getPages(Integer pageNo, Integer pageSize) {
		return infoDao.getPages(pageNo, pageSize, Info.class);
	}



}
