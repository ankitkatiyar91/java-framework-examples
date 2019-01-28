package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.persistance.UserUtil;

public class UserDeleteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4647957224961708831L;
	private Integer id;

	public String delete() {
		try {
			System.out.println("UserDeleteAction.delete()" + id);
			UserUtil.deleteUser(id);
			System.out.println("User deleted successfully");
			addActionMessage("User deleted with id-" + id);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Unable to delete User with id-" + id + " due to "
					+ e.toString());
			return INPUT;
		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
