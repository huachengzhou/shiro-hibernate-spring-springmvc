package com.blake.entiyi;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Date: 17-9-28
 * <p>Version: 1.0
 */
@SuppressWarnings("serial")
public class Role implements Serializable {
    private Integer rid; //编号
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户
    private Set<Privilege> privileges = new HashSet<Privilege>();
    private Set<User> users = new HashSet<User>();
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", role=" + role + ", description="
				+ description + ", available=" + available + "]";
	}
	public Role() {
	}
}
