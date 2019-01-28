package com.jdbc;

import java.util.List;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domain.Address;

@Component
public class HibernateDao {

	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public void getData() {
		System.out.println("%%%% Hibernate fetching data %%%%");
		Session session = factory.openSession();
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		List<Address> addresses = session.createQuery("from Address").list();
		System.out.println("Total Connectins = "
				+ factory.getStatistics().getConnectCount());
		for (Address address : addresses) {
			System.out.println(address);
		}
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
