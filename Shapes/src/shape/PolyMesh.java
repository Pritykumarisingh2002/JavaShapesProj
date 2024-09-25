package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.io.Serializable;

public class PolyMesh extends Dot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7651160157991149771L;
	Graphics g;
	int h;
	int w;

	PolyMesh(Graphics2D g, int radius, int sides, int w, int h, int rotate, int selectedOption, Color color) {
		super(g, radius, sides, w, h, rotate, selectedOption, color);
		this.g = g;
		this.h = h;
		this.w = w;

	}

	public void design() {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		g.setColor(getColor());
//		g.fillRect(0, 0, xc*2, yc*2); 
		Polygon p = new Polygon();
		g.drawPolygon(p);

		for (int i = 0; i < coordinates.length; i++) {
			for (int j = 0; j < coordinates.length; j++) {
				g.drawLine(coordinates[i][0], coordinates[i][1], coordinates[j][0], coordinates[j][1]);
			}
		}
//		g.setColor(Color.white);
	}
}
