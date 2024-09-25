package shape;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Maincls {

	private JFrame frmLetsLearnShapes;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	protected Object arr;
	private int option = 0;
	private Color color = Color.blue;
	private Dot[] change = new Dot[6];
	private static Graphics2D g;
	static Canvas canvas;
	static boolean n = true;
	String filename = "m.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maincls window = new Maincls();
					window.frmLetsLearnShapes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Maincls() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLetsLearnShapes = new JFrame();
		frmLetsLearnShapes.setTitle("Let's Learn Shapes");
		frmLetsLearnShapes.getContentPane().setBackground(new Color(255, 230, 255));
		frmLetsLearnShapes.setBounds(100, 100, 655, 489);
		frmLetsLearnShapes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetsLearnShapes.getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(255, 230, 255));
		layeredPane.setBackground(new Color(255, 230, 255));
		layeredPane.setBounds(10, 11, 619, 428);
		frmLetsLearnShapes.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);

		JSlider slider = new JSlider();
		slider.setValue(10);
		slider.setMaximum(20);
		JSlider slider_1 = new JSlider();
		slider_1.setValue(75);
		slider_1.setMaximum(150);
		JSlider rotate = new JSlider();
		rotate.setValue(180);
		rotate.setMaximum(360);

		JButton Serialization = new JButton("Serialization");
		JButton Deserialization = new JButton("Deserialization");
		canvas = new Canvas();
		canvas.setForeground(new Color(0, 0, 0));
		canvas.setBackground(new Color(255, 255, 255));
		canvas.setBounds(217, 167, 392, 251);
		layeredPane.add(canvas);

		JRadioButton DotPoly = new JRadioButton("Dot Polygon");
		DotPoly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 0;
				updateShape(slider, slider_1, rotate);
				changeColor();
			}
		});
		DotPoly.setBackground(new Color(255, 255, 255));
		DotPoly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(DotPoly);
		DotPoly.setBounds(6, 7, 164, 23);
		layeredPane.add(DotPoly);

		JRadioButton Poly = new JRadioButton("Polygon");
		Poly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 1;
				updateShape(slider, slider_1, rotate);
				changeColor();

			}
		});
		Poly.setBackground(new Color(255, 255, 255));
		Poly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(Poly);
		Poly.setBounds(6, 42, 164, 23);
		layeredPane.add(Poly);

		JRadioButton MeshPoly = new JRadioButton("Mesh Polygon");
		MeshPoly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 2;
				updateShape(slider, slider_1, rotate);
				changeColor();

			}
		});
		MeshPoly.setBackground(new Color(255, 255, 255));
		MeshPoly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(MeshPoly);
		MeshPoly.setBounds(6, 79, 164, 23);
		layeredPane.add(MeshPoly);

		JRadioButton SpokePoly = new JRadioButton("Spoke Polygon");
		SpokePoly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 3;
				updateShape(slider, slider_1, rotate);
				changeColor();

			}
		});
		SpokePoly.setBackground(new Color(255, 255, 255));
		SpokePoly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(SpokePoly);
		SpokePoly.setBounds(6, 122, 164, 23);
		layeredPane.add(SpokePoly);

		JRadioButton WheelPoly = new JRadioButton("Wheel");
		WheelPoly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 4;
				updateShape(slider, slider_1, rotate);
				changeColor();

			}
		});
		WheelPoly.setBackground(new Color(255, 255, 255));
		WheelPoly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(WheelPoly);
		WheelPoly.setBounds(6, 161, 164, 23);
		layeredPane.add(WheelPoly);

		JRadioButton SpiralPoly = new JRadioButton("Spiral Polygon");
		SpiralPoly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 5;
				updateShape(slider, slider_1, rotate);
				changeColor();
			}
		});
		SpiralPoly.setBackground(new Color(255, 255, 255));
		SpiralPoly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonGroup.add(SpiralPoly);
		SpiralPoly.setBounds(6, 200, 164, 23);
		layeredPane.add(SpiralPoly);

		JLabel lblNewLabel = new JLabel("Sides");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(215, 11, 46, 14);
		layeredPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Radius");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(215, 42, 60, 23);
		layeredPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Rotation");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(217, 79, 60, 23);
		layeredPane.add(lblNewLabel_2);

//		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int sides = slider.getValue();
				change[option].setSides(sides);
				System.out.println("Sides:" + sides);
				changeColor();
			}
		});
		slider.setBackground(new Color(255, 255, 255));
		slider.setBounds(282, 7, 327, 26);
		layeredPane.add(slider);

//		JSlider slider_1 = new JSlider();
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int radius = slider_1.getValue();
				change[option].setRadius(radius);
				updateShape(slider, slider_1, rotate);
				System.out.println("Radius:" + radius);
				changeColor();
			}
		});
		slider_1.setBackground(new Color(255, 255, 255));
		slider_1.setBounds(282, 42, 327, 26);
		layeredPane.add(slider_1);

//		JSlider rotation = new JSlider();
		rotate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int Rotation = rotate.getValue();
				change[option].setRotation(Rotation);
				System.out.println("Rotation:" + Rotation);
//				canvas.paintAll(g);
				changeColor();
			}
		});
		rotate.setBackground(Color.WHITE);
		rotate.setBounds(282, 79, 327, 26);
		layeredPane.add(rotate);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.repaint();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(43, 337, 92, 23);
		layeredPane.add(btnNewButton_1);

		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(6, 264, 164, 33);
		layeredPane.add(panel);

		JButton Black = new JButton("");
		Black.setBackground(new Color(0, 0, 0));
		Black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.black;
				changeColor();
			}
		});
		panel.add(Black);

		JButton Blue = new JButton("");
		Blue.setBackground(new Color(0, 0, 255));
		Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.blue;
				changeColor();
			}
		});
		panel.add(Blue);

		JButton Green = new JButton("");
		Green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.green;
				changeColor();
			}
		});
		Green.setBackground(new Color(0, 255, 0));
		panel.add(Green);

		JButton Red = new JButton("");
		Red.setBackground(new Color(255, 0, 0));
		Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.red;
				changeColor();
			}
		});

		JButton Pink = new JButton("");
		Pink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.pink;
				changeColor();
			}
		});
		Pink.setBackground(new Color(255, 128, 192));
		panel.add(Pink);

		JButton Brown = new JButton("");
		Brown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.cyan;
				changeColor();
			}
		});
		Brown.setBackground(new Color(0, 255, 255));
		panel.add(Brown);

		JButton Orange = new JButton("");
		Orange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.orange;
				changeColor();
			}
		});
		Orange.setBackground(new Color(255, 128, 0));
		panel.add(Orange);
		panel.add(Red);

		JButton Yellow = new JButton("");
		Yellow.setBackground(new Color(255, 255, 0));
		Yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.yellow;
				changeColor();
			}
		});
		panel.add(Yellow);

//		JButton Serialization = new JButton("Serialization");
		Serialization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Save(new Slider(slider.getValue(), slider_1.getValue(), rotate.getValue(), option, color));
			}
		});
		Serialization.setFont(new Font("Tahoma", Font.BOLD, 11));
		Serialization.setBounds(217, 124, 123, 23);
		layeredPane.add(Serialization);

//		JButton Deserialization = new JButton("Deserialization");
		Deserialization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Slider s = load();
				if (s != null) {
					slider.setValue(s.sides);
					slider_1.setValue(s.radius);
					rotate.setValue(s.rotation);
					option = s.selectedOption;
					color = s.color;
					changeColor();
					updateShape(slider, slider_1, rotate);
				}
			}
		});
		Deserialization.setFont(new Font("Tahoma", Font.BOLD, 11));
		Deserialization.setBounds(486, 124, 123, 23);
		layeredPane.add(Deserialization);

		slider.addChangeListener(e -> updateShape(slider, slider_1, rotate));
		slider_1.addChangeListener(e -> updateShape(slider, slider_1, rotate));
		rotate.addChangeListener(e -> updateShape(slider, slider_1, rotate));
	}

	private void updateShape(JSlider sidesSlider, JSlider radiusSlider, JSlider rotationSlider) {
		int sides = sidesSlider.getValue();
		int radius = radiusSlider.getValue();
		int rotation = rotationSlider.getValue();
		g = (Graphics2D) canvas.getGraphics();
		ShapeFactory factory = new ShapeFactory();
		change = factory.getDot(g, sides, canvas.getWidth(), canvas.getHeight(), rotation, radius, option, color);
		changeColor();
	}

	private void Save(Slider saveDot) {
		try (FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(file)) {
			out.writeObject(saveDot);
			System.out.println("Object has been serialized.");
		} catch (IOException ex) {
			System.out.println("IOException is caught.");

		}
	}

	private Slider load() {
		try (FileInputStream file = new FileInputStream(filename); ObjectInputStream in = new ObjectInputStream(file)) {
			Object obj = in.readObject();
			if (obj instanceof Slider) {
				Slider slider = (Slider) obj;
				System.out.println("Object has been Deserialized.");
				System.out.println("Sides: " + slider.sides);
				System.out.println("Radius: " + slider.radius);
				System.out.println("Rotation: " + slider.rotation);
				System.out.println("Option: " + slider.selectedOption);
				System.out.println("Color: " + slider.color);
				color = slider.color;
				return slider;
			} else {
				System.out.println("The file contain the data of" + obj.getClass().getName() + "instead of slider.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File is not found.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("An File error found.");
		}
		return null;
	}

	protected void changeColor() {
		if (change[option] != null) {
			change[option].setColor(color);
			change();
		}
	}

	private void change() {
		if (change[option] != null) {
			change[option].PointsOfDot();
			change[option].design();
		}
	}
}
