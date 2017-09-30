package com.blake.shiro.dao;

import java.util.List;

import com.blake.base.dao.BaseDao;
import com.blake.entiyi.User;

public interface UserDao extends BaseDao {
	public User login(String username);
	public List<User> findUsersByAcccountAndPass(String username, String password);
}
