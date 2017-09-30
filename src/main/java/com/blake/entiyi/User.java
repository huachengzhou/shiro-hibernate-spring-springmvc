package com.blake.entiyi;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Date: 17-9-28
 * <p>Version: 1.0
 */
@SuppressWarnings("serial")
public class User implements Serializable {
    private Integer uid; //编号
    private String organizationId; //所属公司
    private String username; //用户名
    private String password; //密码
    private String salt; //加密密码的盐
    private Set<Role> roles = new HashSet<Role>();//拥有的角色列表
    private Boolean locked = Boolean.FALSE;
    
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", organizationId=" + organizationId + ", username=" + username + ", password="
				+ password + ", salt=" + salt + ", locked=" + locked + "]";
	}

	public User() {
	}
}
