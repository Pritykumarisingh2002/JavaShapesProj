package shape;

import java.awt.Color;
import java.io.Serializable;

public class Slider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -745409773647158289L;
	int sides;
	int radius;
	int rotation;
	int selectedOption;
	Color color;

	Slider(int sides, int radius, int rotation, int selectedOption, Color color) {
		this.sides = sides;
		this.radius = radius;
		this.rotation = rotation;
		this.selectedOption = selectedOption;
		this.color = color;
	}
}
