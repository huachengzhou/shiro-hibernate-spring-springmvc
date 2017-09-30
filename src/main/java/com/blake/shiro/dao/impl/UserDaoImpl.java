package com.blake.shiro.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.blake.base.dao.impl.BaseDaoImpl;
import com.blake.entiyi.User;
import com.blake.shiro.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao{
	
	@Resource
	private SessionFactory sessionFactory;
   
	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	@Override
	public User login(String username) {
		String hql = "from User"+" u where u.username = :name";
		Query query = getSession().createQuery(hql);
		query.setString("name",username);
		User user = (User) query.uniqueResult();
		return user;
	}
	@SuppressWarnings("unchecked")
	public List<User> findUsersByAcccountAndPass(String username, String password) {
		Query query = getSession().createQuery("FROM User WHERE username=? AND password=?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		return query.list();
	}

}
