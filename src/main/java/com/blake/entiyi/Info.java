package com.blake.entiyi;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Info implements Serializable {
	private Integer info_id;
	private String description;
	private User user;
	public Integer getInfo_id() {
		return info_id;
	}
	public void setInfo_id(Integer info_id) {
		this.info_id = info_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Info [info_id=" + info_id + ", description=" + description
				+ "]";
	}
}
