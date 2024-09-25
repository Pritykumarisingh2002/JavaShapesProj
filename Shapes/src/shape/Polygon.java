package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Polygon extends Dot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3968448027769949422L;
	Graphics2D g;
	int h;
	int w;

	Polygon(Graphics2D g, int radius, int sides, int w, int h, int rotate, int selectedOption, Color color) {
		super(g, radius, sides, w, h, rotate, selectedOption, color);
		this.g = g;
		this.h = h;
		this.w = w;

	}

	public void design() {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		g.setColor(getColor());

		for (int i = 0; i < coordinates.length - 1; i++) {
			g.drawLine(coordinates[i][0], coordinates[i][1], coordinates[i + 1][0], coordinates[i + 1][1]);
		}
		int s = coordinates.length;
		g.drawLine(coordinates[s - 1][0], coordinates[s - 1][1], coordinates[0][0], coordinates[0][1]);
	}

}
