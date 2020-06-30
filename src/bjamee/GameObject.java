package bjamee;

import java.awt.Graphics2D;

public abstract class GameObject {
	
	private float x = 0.0f;
	private float y = 0.0f;
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}

}
