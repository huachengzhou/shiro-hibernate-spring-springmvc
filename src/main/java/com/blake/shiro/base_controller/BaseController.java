package com.blake.shiro.base_controller;

public interface BaseController {
	
	/**显示数据集合*/
	public String showList();
	
	/**删除数据*/
	public String remove();
	
	/**转发到更新数据页面*/
	public String update_Forward();
	
	/**更新数据*/
	public String update();
	
	/**转发到添加数据页面*/
	public String save_ForWard();
	
	/**保存数据*/
	public String save();
	
}
