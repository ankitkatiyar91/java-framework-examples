package com.action;

import java.util.List;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.persistance.UserUtil;

public class UserListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<User> users;

	public String list() {
		System.out.println("UserListAction.list()");
		users=UserUtil.getUsers();
		System.out.println("Listed "+users);
		return SUCCESS;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
