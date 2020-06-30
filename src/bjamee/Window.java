package bjamee;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Window {
	
	private Canvas canvas;
	private JFrame frame;
	private KeyInput key;
		
	public Window(int width, int height, String title) {
		canvas = new Canvas();
		canvas.setSize(width, height);
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(title);
		frame.add(canvas);
		frame.pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - width / 2, d.height / 2 - height / 2);
		frame.setVisible(true);
		key = new KeyInput();
		canvas.addKeyListener(key);
	}
	
	public Window() {
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
}
