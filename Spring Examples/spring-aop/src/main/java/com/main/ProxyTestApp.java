package com.main;

import com.service.FactoryService;
import com.service.ShapeService;

public class ProxyTestApp {

	
	public static void main(String[] args) {
		FactoryService factoryService=new FactoryService();
		ShapeService shapeService=(ShapeService) factoryService.getBean("shapeService");
		
		
		System.out.println("Got Circle->"+shapeService.getCircle());
	}
}
