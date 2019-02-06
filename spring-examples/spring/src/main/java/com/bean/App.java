package com.bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		Shape shape;
		/*@SuppressWarnings("deprecation")
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/main/resources/spring.xml"));
		System.out.println("BeanFactory created");
		Shape shape=(Shape) factory.getBean("traingle");
		shape.draw();
		*/
		/*shape=(Shape) factory.getBean("traingle1");
		shape.draw();*/
		/*
		 * ClassPathXmlApplicationContext does not need a fully qualified path name
		 * It will set create all beans on create
		 */
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		//context.registerShutdownHook();
		
		//System.out.println("Context created "+context);
		/*shape=(Shape) context.getBean("traingle");
		shape.draw();*/
		shape=(Shape) context.getBean("circle");
		//shape.draw();
		System.out.println("message->"+context.getMessage("greeting", new Object[]{"Ankit"}, null));
		
		

	}

}
