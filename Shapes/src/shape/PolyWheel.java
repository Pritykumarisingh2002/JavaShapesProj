package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;


public class PolyWheel extends Dot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4935896536144565290L;
	Graphics2D g;
	int w,h;
	PolyWheel( Graphics2D g,int radius, int sides, int w, int h, int rotate, int selectedOption, Color color) {
		super( g, radius, sides, w, h, rotate, selectedOption, color);
		this.g=g;
		this.h=h;
		this.w=w;
		PointsOfDot();
	}
	

	public void design() {
		g.setColor(Color.WHITE);
		g.fillRect( 0, 0, w, h);
		g.setColor(getColor());
			g.drawOval(xc-getRadius(), yc-getRadius(), getRadius() * 2, getRadius() * 2);
			lines();
			}
				public void lines() {
					for (int i = 0; i < coordinates.length; i++) {//coordinates.length/360
						g.drawLine(coordinates[i][0],coordinates[i][1], xc,yc);
					}
				
					
				
	}

}

