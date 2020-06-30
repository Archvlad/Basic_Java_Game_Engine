package bjamee;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private static boolean[] key = new boolean[250];
	
	public void keyPressed(KeyEvent e) {
		key[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		key[e.getKeyCode()] = false;
	}
	
	public static boolean getKey(int keyCode) {
		return key[keyCode];
	}

}
