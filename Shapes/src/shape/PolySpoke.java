package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class PolySpoke extends Polygon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1435223472418174775L;
	Graphics2D g;
	int w, h;

	PolySpoke(Graphics2D g, int radius, int Sides, int w, int h, int rotate, int selectedOption, Color color) {
		super(g, radius, Sides, w, h, rotate, selectedOption, color);
//		this.repaint(radius, Sides, w, h, rotate, g);
		this.g = g;
		this.h = h;
		this.w = w;
		this.PointsOfDot();
	}

	public void design() {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		g.setColor(getColor());
		super.design();
		lines();

	}

	public void lines() {
		for (int i = 0; i < coordinates.length; i++) {
			g.drawLine(coordinates[i][0], coordinates[i][1], xc, yc);
		}
	}

}
