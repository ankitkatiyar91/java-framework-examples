package com.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository
public class UserImpl {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Session session;

	@org.springframework.transaction.annotation.Transactional
	public User addUser(User user) {
		System.out.println("getSessionFactory()->" + sessionFactory
				+ "  session->" + session);
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public User getUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@SuppressWarnings("unchecked")
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> user = session.createQuery("from User").list();
		return user;
	}
	
	@org.springframework.transaction.annotation.Transactional
	public void deleteUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(User.class, id));
	}

}
