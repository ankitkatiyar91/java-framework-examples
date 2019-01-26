package com.service;

import com.model.Circle;
import com.model.Triangle;

public class FactoryService {

	public Object getBean(String beanName) {
		if (beanName.equals("shapeService")) {
			return new ShapeService();
		} else if (beanName.equals("circle")) {
			return new Circle();
		} else if (beanName.equals("triangle")) {
			return new Triangle();
		}
		return null;
	}

}
