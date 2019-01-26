package com.service;

import com.model.Circle;
import com.model.Triangle;
import com.model.sub.Square;

public class ShapeService {

	private Circle circle;
	private Triangle triangle;

	private Square square;

	public Circle getCircle() {
		System.out.println("Circle getter called");
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

}
