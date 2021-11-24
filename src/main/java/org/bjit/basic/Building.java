package org.bjit.basic;

public class Building {
	private double height;
	private double width;
	private String type;

	public Building() {
	}

	public Building(double height, double width) {
		this.height = height;
		this.width = width;
	}

	public Building(double height, double width, String type) {
		super();
		this.height = height;
		this.width = width;
		this.type = type;
	}
	public double getArea(){return  getHeight() *  getWidth(); }
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Building{" +
				"height=" + height +
				", width=" + width +
				", type='" + type + '\'' +
				'}';
	}
}
