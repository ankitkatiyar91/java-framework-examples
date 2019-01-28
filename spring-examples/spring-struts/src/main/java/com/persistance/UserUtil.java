package com.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;

@Service
public class UserUtil {

	private static UserImpl impl;

	public static User addUser(User user) {
		return impl.addUser(user);
	}

	public static User getUser(Integer id) {
		return impl.getUser(id);
	}

	public static List<User> getUsers() {
		return impl.getUsers();
	}

	public static void deleteUser(Integer id) {
		impl.deleteUser(id);
	}

	@Autowired
	public void setImpl(UserImpl impl) {
		UserUtil.impl = impl;
	}

}
