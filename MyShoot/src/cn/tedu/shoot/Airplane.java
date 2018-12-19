package cn.tedu.shoot;
import java.util.Random;
import java.awt.image.BufferedImage;
public class Airplane extends FlyingObject implements Enemy{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for(int i =0;i<images.length;i++) {
			images[i] = loadImage("airplane"+i+".png");
		}
	}
	private int speed;
	public Airplane(){
		super(49,36);
		speed = 2;
	}	
	public void step() {
		y += speed;
	}
	 int deadIndex = 1;
	public BufferedImage getImage() {
		if(isLife()) {
			return images[0];
		}else if(isDead()) {
			BufferedImage img = images[deadIndex++];
			if(deadIndex==images.length) {
				state = REMOVE;
			}		
			return img;
		}
		return null;
		}
	public boolean outOfBounds() {
		return this.y>=World.HEIGHT;
	}
	public int getScore() {
		return 1;
	}
}
