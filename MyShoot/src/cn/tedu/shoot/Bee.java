package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject implements Award{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for(int i =0;i<images.length;i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	private int xSpeed;
	private int ySpeed;
	private int awardType;
	public Bee(){
		super(60,50);		
		Random rand = new Random();
		xSpeed = 1;
		ySpeed = 2;
		awardType = rand.nextInt(2);
	}	
	public void step() {
		x+=xSpeed;
		y+=ySpeed;
		if(x<=0||x>=World.WIDTH-this.width) {
			xSpeed*=-1;
		}
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
	public int getAwardType() {
		return awardType;
	}
}
