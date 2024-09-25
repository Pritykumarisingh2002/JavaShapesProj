package shape;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public class PolyDot extends Dot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4053476594131895882L;
	Graphics2D g;
	int w, h;

	PolyDot(Graphics2D g, int radius, int sides, int w, int h, int rotate, int selectedOption, Color color) {
		super(g, radius, sides, w, h, rotate, selectedOption, color);
		this.g = g;
		this.h = h;
		this.w = w;

	}

	public void design() {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		g.setColor(getColor());
		for (int i = 0; i < coordinates.length; i++) {
			Ellipse2D circle = new Ellipse2D.Double(coordinates[i][0], coordinates[i][1], 7, 7);
			((Graphics2D) g).fill(circle);
		}

	}

}
