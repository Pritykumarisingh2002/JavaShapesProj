package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;   

public class Spiral extends Dot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3347170899788245962L;
	Graphics2D g;
	int w,h;
	Spiral(Graphics2D g, int radius, int sides, int w, int h, int rotate, int selectedOption, Color color) {
		super(g, radius, sides, w, h, rotate, selectedOption, color);
		this.g=g;
		this.h=h;
		this.w=w;
		this.PointsOfDot();
	}

public void design() {
	g.setColor(Color.WHITE);
	g.fillRect( 0, 0, w, h);
	g.setColor(getColor());

        double xCurrent = xc;
        double yCurrent = yc;
        g.fillRect(xc, yc, 0, 0);
        for (int i = 0; i < getSides() * 10; i++) {
            double t = i * 0.1;
            int xNext = (int) (xc + (getRadius() * t / getSides()) * Math.cos(i * 2 * Math.PI / getSides()));
            int yNext = (int) (yc + (getRadius() * t / getSides()) * Math.sin(i * 2 * Math.PI / getSides()));

            g.drawLine((int) xCurrent, (int) yCurrent, xNext, yNext);
            xCurrent = xNext;
            yCurrent = yNext;
        }
    }
       
	}


