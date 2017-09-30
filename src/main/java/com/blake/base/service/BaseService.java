package com.blake.base.service;

import java.io.Serializable;
import java.util.List;

import com.blake.base.dao.PageResult;


public interface BaseService<T> {
	/**
	 * 新增
	 * @param entity
	 */
	public  void save(T entity);
	/**
	 * 更新
	 * @param entity
	 */
	public  void update(T entity);
	/**
	 * 根据id删除
	 * @param entityClass
	 * @param id
	 */
	public  void delete(Serializable id);
	/**
	 * 根据id查找
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public  T findObjectById(Serializable id);
	/**
	 * 查找列表
	 */
	public  List<T> findObjects();
	
	/**条件查询实体列表--查询助手queryHelper*/
	/**批量删除*/
	public  void delete(Serializable[] ids);
	/**获取分页实体*/
	public  PageResult getPages(Integer pageNo,Integer pageSize);
}
