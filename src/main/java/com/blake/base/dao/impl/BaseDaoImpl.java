package com.blake.base.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.blake.base.dao.BaseDao;
import com.blake.base.dao.PageResult;

public  class BaseDaoImpl implements BaseDao {
	@Autowired
	private SessionFactory sessionFactory;
   
	public Session getSession() {
		Session session = null;
		try {
			session = getSessionFactory().getCurrentSession();
		} catch (Exception e) {
			session = getSessionFactory().openSession();//用这个最好,这样可以避免Could not obtain transaction-synchronized Session for current thread at org.
		}
		return session;
	}
	public <T> void save(T entity) {
		getSession().save(entity);
	}

	public <T> void update(T entity) {
//		getSession().merge(entity);
		getSession().update(entity);
	}

	public <T> void delete(Class<T> entityClass,Serializable id) {
		getSession().delete(findObjectById(entityClass, id));
	}
	
	public <T> void delete(Class<T> entityClass,Serializable[] ids){
		for (int i = 0; i < ids.length; i++) {
			getSession().delete(findObjectById(entityClass,ids[i]));
		}
	}

	public <T> T findObjectById(Class<T> entityClass, Serializable id) {
		T t = (T) getSession().get(entityClass, id);
		return t;
	}

	public <T> List<T> findObjects(Class<T> entityClass) {
		Query query = getSession().createQuery("FROM "+ entityClass.getSimpleName());
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}
    //新增和修改，hibernate根据id是否为null自动判断
	public <T> void saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public BaseDaoImpl() {
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findObjecTs_(String hql, List<Object> params) {
		Query query = getSession().createQuery(hql);
		if (params!=null) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i,params.get(i));
			}
		}
		return query.list();
	}
	
	public <T> PageResult getPages(Integer pageNo, Integer pageSize,Class<T> entityClass) {
		String hql = "FROM "+entityClass.getSimpleName();
		Query query = getSession().createQuery(hql);
		@SuppressWarnings("rawtypes")
		List list = query.setFirstResult(pageNo).setMaxResults(pageSize).list();
		Integer totalCount = getSession().createQuery("FROM "+entityClass.getSimpleName()).list().size();
		PageResult pageResult = new PageResult(totalCount, pageNo, pageSize, list);
		return pageResult;
	}
	
}
