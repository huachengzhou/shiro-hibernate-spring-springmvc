package com.blake.base.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {
	// 新增
	public <T> void save(T entity);

	// 更新
	public <T> void update(T entity);

	public <T> void delete(Class<T> entityClass, Serializable[] ids);

	// 根据id删除
	public <T> void delete(Class<T> entityClass, Serializable id);

	// 根据id查找
	public <T> T findObjectById(Class<T> entityClass, Serializable id);

	// 查找列表
	public <T> List<T> findObjects(Class<T> entityClass);

	@Deprecated
	/** 查询 搜索 */
	public <T> List<T> findObjecTs_(String hql, List<Object> params);
	
	public <T> PageResult getPages(Integer pageNo,Integer pageSize,Class<T> entityClass);

}
