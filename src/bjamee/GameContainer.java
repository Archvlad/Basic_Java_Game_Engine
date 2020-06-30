package bjamee;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class GameContainer {

	private static short width;
	private static short height;
	private static String title;
	private static byte fps = 60;
	private static byte ups = 20;
	
	private Window window;
	private Graphics2D g;
	private BufferStrategy bs;
	
	private GameManager gm;
	
	public GameContainer(GameManager gm, String title, short width, short height, byte fps, byte ups) {
		setTitle(title);
		setSize(width, height);
		setFPS(fps);
		setUPS(ups);
		window = new Window(width, height, title);
		this.gm = gm;
	}
	
	public GameContainer(GameManager gm) {
		this(gm, "Game", (short) (640), (short) (480), (byte) 60, (byte) 20);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setSize(short width, short height) {
		this.width = width;
		this.height = height;
	}
	
	public static short getWidth() {
		return width;
	}
	
	public static short getHeight() {
		return height;
	}
	
	public void setFPS(byte fps) {
		this.fps = fps;
	}
	
	public void setUPS(byte ups) {
		this.ups = ups;
	}
	
	public void start() {
		window.getCanvas().requestFocus();
		long previous = System.currentTimeMillis();
		long current = 0;
		float elapsedTickTime = 0.0f;
		float elapsedRenderTime = 0.0f;
		float timePerTick = 1000.0f / ups;
		float timePerRender = 1000.0f / fps;
		long timer = previous;
		int ticks = 0;
		int frames = 0;
		while (true) {
			current = System.currentTimeMillis();
			elapsedTickTime += (current - previous) / timePerTick;
			elapsedRenderTime += (current - previous) / timePerRender;
			previous = current;
			while (elapsedTickTime >= 1) {
				tick();
				ticks++;
				elapsedTickTime--;
			}
			while (elapsedRenderTime >= 1) {
				render();
				frames++;
				elapsedRenderTime--;
			}
			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.printf("UPS: %3d, FPS %3d%n", ticks, frames);
				timer += 1000;
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	public void tick() {
		gm.tick();
	}
	
	public void render() {
		bs = window.getCanvas().getBufferStrategy();
		if (bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		gm.render(g);
		g.dispose();
		bs.show();
	} 

}
