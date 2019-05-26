/**
 * 
 */
package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Circle;
import com.service.ShapeService;

/**
 * @author ANKIT
 *
 */
public class AopApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
	
		ShapeService shapeService=context.getBean("shapeService", ShapeService.class);
		System.out.println("Instance of->"+(shapeService.getCircle() instanceof Circle)+"  Object->"+shapeService.getCircle().getClass());
		//shapeService.getCircle().setNameAndReturn("Circle Name setter");
		shapeService.getCircle().setName("Circle Name setter");
		System.out.println("Shape Service circle-"+shapeService.getCircle().getName());
		//System.out.println("Shape Service circle-"+shapeService.getTriangle().getName());
		//System.out.println("Shape Service Square-"+shapeService.getSquare().getName());
		
	}

}
