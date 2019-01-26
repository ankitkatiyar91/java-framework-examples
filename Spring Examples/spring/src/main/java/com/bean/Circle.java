package com.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, InitializingBean, DisposableBean,
		ApplicationContextAware, BeanNameAware,MessageSourceAware {

	@Autowired
	private Point center;

	public void draw() {
		System.out.println(messageSource.getMessage("circle",new Object[]{center.getX(),center.getY()} ,null));
	}

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		System.out.println("Circle: center Point set");
		this.center = center;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Circle.afterPropertiesSet()");

	}

	public void myInit() {
		System.out.println("Circle my Init Aware ");
	}

	public void init() {
		System.out.println("Circle init Aware ");
	}

	public void destroy() throws Exception {
		System.out.println("Circle destroy");

	}

	public void myDestroy() throws Exception {
		System.out.println("Circle myDestroy");

	}

	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		System.out.println("Circle got context " + context);

	}

	public void setBeanName(String name) {
		System.out.println("Circle My Bean Name " + name);

	}

	public void setMessageSource(MessageSource arg0) {
		messageSource=arg0;
	}
	
	private MessageSource messageSource;

}
