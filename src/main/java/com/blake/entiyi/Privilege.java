package com.blake.entiyi;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * <p>Date: 17-9-28
 * <p>Version: 1.0
 */
@SuppressWarnings("serial")
public class Privilege implements Serializable {
	private Integer pid;
	private String description;
	private Set<Role> roles = new HashSet<Role>();
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Privilege() {
	}
	@Override
	public String toString() {
		return "Privilege [pid=" + pid + ", description=" + description + "]";
	}
	
}
