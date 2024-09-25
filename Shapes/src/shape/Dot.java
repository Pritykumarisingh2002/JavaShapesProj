package shape;

import java.awt.Color;

import java.awt.Graphics2D;
import java.io.Serializable;

public abstract class Dot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7444114586943228797L;
	public Dot change;
	protected int xc;
	protected int yc;
	protected double radian;
	protected int Sides;
	protected int Rotation;
	protected int coordinates[][];
	private int w;
	private int h;
	protected int radius;
	int selectedOption;
	Color color;

	Dot(Graphics2D g, int radius, int sides, int w, int h, int rotate,int selectedOption, Color color) {
		this.radius = radius;
		this.Sides = sides;
		this.Rotation = rotate;
		this.w = w;
		this.h = h;
		this.selectedOption = selectedOption;
		this.color = color;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getSides() {
		return Sides;
	}

	public void setSides(int sides) {
		this.Sides = sides;
	}

	public int getRotation() {
		return Rotation;
	}

	public void setRotation(int rotation) {
		this.Rotation = rotation;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void PointsOfDot() {
		coordinates = new int[Sides][2];
		xc = w / 2;
		yc = h / 2;
		radian = (2 * Math.PI / Sides);
		for (int i = 0; i < Sides; i++) {
			coordinates[i][0] = (int) (xc + radius * Math.cos(i * radian + Rotation));
			coordinates[i][1] = (int) (yc + radius * Math.sin(i * radian + Rotation));
		}

	}

	public abstract void design();
}