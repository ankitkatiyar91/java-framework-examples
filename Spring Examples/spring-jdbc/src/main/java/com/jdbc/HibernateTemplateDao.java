package com.jdbc;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.domain.Address;

public class HibernateTemplateDao extends HibernateDaoSupport {

	public HibernateTemplateDao() {
		super();
	}

	public HibernateTemplateDao(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public void getData() {
		System.out
				.println("%%%% Hibernate fetching data using hibernate template %%%%");
		String queryString = "from Address";
		List<Address> addresses = (List<Address>) getHibernateTemplate()
				.find(queryString);
		for (Address address : addresses) {
			System.out.println(address);
		}
	}
}
