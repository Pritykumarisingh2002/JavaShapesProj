package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class ShapeFactory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -149593617044818952L;

	public Dot[] getDot(Graphics2D g,int sides, int w,  int h, int rotate, int radius,int selectedOption, Color color) {
			System.out.println("Radius: "+radius +" Side: "+ sides  +" W: "+ w  +" H: "+ h  +" ROT: "+ rotate + " Option: " + selectedOption + " Color: " + color);
		 Dot[] change = new Dot[6];
		   change[0] = new PolyDot(g,radius, sides, w, h, rotate, selectedOption, color);
		   change[1] = new Polygon(g,radius, sides, w, h, rotate, selectedOption, color);
		   change[2] = new PolyMesh(g,radius, sides, w, h, rotate, selectedOption, color);
		   change[3] = new PolySpoke(g,radius, sides, w, h, rotate, selectedOption, color);
		   change[4] = new PolyWheel(g,radius, sides, w, h, rotate, selectedOption, color);
		   change[5] = new Spiral(g,radius, sides, w, h, rotate, selectedOption, color);
           return change;    
           
}   
}
