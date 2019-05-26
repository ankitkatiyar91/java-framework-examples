/**
 * 
 */
package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.HibernateDao;
import com.jdbc.HibernateTemplateDao;
import com.jdbc.JDBCDao;
import com.jdbc.JDBCDaoSupportImpl;
import com.jdbc.JDBCTemplateDao;

/**
 * @author ipg
 * 
 */
public class JDBCApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		getDataFromSql(context);
		getDataFromJDBCTemplate(context);
		getDataFromHibernate(context);
		getDataFromJDBCDaoSupportImpl(context);
		getDataFromHibernateTemplateDao(context);

		getDataFromHibernate(context);

	}

	protected static void getDataFromSql(ApplicationContext context) {
		JDBCDao dao = context.getBean(JDBCDao.class);
		dao.getData();
	}

	protected static void getDataFromJDBCTemplate(ApplicationContext context) {
		System.out.println("Using JDBCTemplate");
		JDBCTemplateDao dao = context.getBean(JDBCTemplateDao.class);
		// dao.getData();
		System.out.println("Fetch for Id 1->" + dao.getById(1));
	}

	protected static void testTransactionManager(ApplicationContext context) {
		/*
		 * HibernateDao dao = context.getBean(HibernateDao.class);
		 * dao.testTransaction();
		 */
	}

	protected static void getDataFromHibernate(ApplicationContext context) {
		HibernateDao dao = context.getBean(HibernateDao.class);
		dao.getData();
	}

	protected static void getDataFromJDBCDaoSupportImpl(ApplicationContext context) {
		JDBCDaoSupportImpl impl = context.getBean("jdbcdaosupportimpl", JDBCDaoSupportImpl.class);
		impl.getData();
	}

	protected static void getDataFromHibernateTemplateDao(ApplicationContext context) {
		HibernateTemplateDao dao = context.getBean("hibernatetemplatedao", HibernateTemplateDao.class);
		dao.getData();

	}
}
