package shape;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Line  {
	Graphics2D g;
	int x1; int y1; int x2; int y2;
//	private Object Graphics2D;
	Line(int x1, int y1, int x2, int y2, Graphics2D g){
//		super(x1, y1, x2, y2);
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.g=g;
		
	}
	
	

//	@Override
	public void design() {
		double m=(y2-y1)/(x2-x1);
		double b = y1 - m * x1; 
		for(int x=x1;x<x2;x++) {
			int y = (int) (m * x + b);
			Line2D line = new Line2D.Double(x, y, x, y);
	        g.draw(line);
		}
		// TODO Auto-generated method stub

	}

}
