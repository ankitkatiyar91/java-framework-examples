package com.bean;

public class Traingle implements Shape {

	private String type;
	private Point point;

	public Traingle(Point point) {
		super();
		this.point = point;
	}

	
	public Traingle() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw() {
		System.out.println("Drawing Traingle "+type+" "+point.getX()+"  "+point.getY());		
	}

	
}
