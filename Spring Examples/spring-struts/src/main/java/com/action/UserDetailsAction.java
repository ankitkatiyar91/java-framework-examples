package com.action;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.persistance.UserUtil;

public class UserDetailsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;

	public String showDetails() {
		System.out.println("UserDetailsAction.showDetails() " + id);
		try {
			this.user = UserUtil.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			addActionMessage("Unable to load user with id -" + id);
			addActionError(e.toString());
		}
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
