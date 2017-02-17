import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable {
	private int xSpeed;
	private int ySpeed;

	public Ball() {
		super(200, 200, 10, 10, Color.BLACK);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int i, int j) {
		super(i, j, 10, 10, Color.BLACK);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int i, int j, int k, int l) {
		super(i, j, k, l, Color.BLACK);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int i, int j, int k, int l, Color m) {
		super(i, j, k, l, m);
		setXSpeed(3);
		setYSpeed(1);
	}

	public Ball(int i, int j, int k, int l, Color o, int m, int n) {
		super(i, j, k, l, o);
		setXSpeed(m);
		setYSpeed(n);
	}
	public boolean didCollideLeft(Object obj) {
		/*if (!(obj instanceof Block)) {
			throw new IllegalArgumentException("darn");
		}
		Block b = (Block) obj;
		
		boolean c = getX() <= b.getX() + b.getWidth() + Math.abs(getXSpeed());
		c = c && (getY() >= b.getY()
					&& getY() <= b.getY() + b.getHeight()
					|| getY() + getHeight() >= b.getY()
					&& getY() + getHeight() < b.getHeight());
		if (c) {
			if (getX() <= b.getX() + b.getWidth() - Math.abs(getXSpeed())) {
				setYSpeed(-getYSpeed());
			}
			else {
				setXSpeed(-getXSpeed());
			}
		}
		return c;*/
		if((getX())<=(((Block)obj).getX()+ ((Block)obj).getWidth())){
			return true;
		}
		return false;
	}

	public boolean didCollideRight(Object obj) {
		/*if (!(obj instanceof Block)) {
			throw new IllegalArgumentException("darn");
		}
		Block b = (Block) obj;
		boolean c = getX() >= b.getX() - b.getWidth() - Math.abs(getXSpeed());
		c = c && (getY() <= b.getY()
					&& getY() >= b.getY() + b.getHeight()
					|| getY() + getHeight() <= b.getY()
					&& getY() + getHeight() > b.getHeight());
		if (c) {
			if (getX() >= b.getX() - b.getWidth() - Math.abs(getXSpeed())) {
				setYSpeed(-getYSpeed());
			}
			else {
				setXSpeed(-getXSpeed());
			}
		}
		return c;*/
		if((getX()+getWidth())>=((Block)obj).getX()){
			return true;
		}
		return false;
	}

	public boolean didCollideTop(Object obj) {
		/*if (!(obj instanceof Block)) {
			throw new IllegalArgumentException("darn");
		}
		Block b = (Block) obj;
		
		boolean c = getY() <= b.getY() + b.getHeight() + Math.abs(getYSpeed());
		c = c && (getX() >= b.getX()
					&& getX() <= b.getX() + b.getWidth()
					|| getX() + getWidth() >= b.getX()
					&& getX() + getWidth() < b.getWidth());
		if (c) {
			if (getY() <= b.getY() + b.getHeight() - Math.abs(getYSpeed())) {
				setXSpeed(-getXSpeed());
			}
			else {
				setYSpeed(-getYSpeed());
			}
		}
		return c;*/
		if((getY())<=(((Block)obj).getY()+((Block)obj).getHeight()))
		{
			return true;
		}
		return false;
	}

	public boolean didCollideBottom(Object obj) {
		/*if (!(obj instanceof Block)) {
			throw new IllegalArgumentException("darn");
		}
		Block b = (Block) obj;
		
		boolean c = getY() >= b.getY() - b.getHeight() - Math.abs(getYSpeed());
		c = c && (getX() <= b.getX()
					&& getX() >= b.getX() + b.getWidth()
					|| getX() + getWidth() <= b.getX()
					&& getX() + getWidth() > b.getWidth());
		if (c) {
			if (getY() >= b.getY() + b.getHeight() - Math.abs(getYSpeed())) {
				setXSpeed(-getXSpeed());
			}
			else {
				setYSpeed(-getYSpeed());
			}
		}
		return c;*/
		if((getY()+getHeight())>=(((Block)obj).getY()))
		{
			return true;
		}
		return false;
	}

	public void setXSpeed(int i) {
		xSpeed = i;
	}

	public void setYSpeed(int i) {
		ySpeed = i;
	}

	public void moveAndDraw(Graphics window) {
		window.setColor(Color.WHITE);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
		// draw a white ball at old ball location
		setX(getX() + xSpeed);
		setY(getY() + ySpeed);
		// setY
		window.setColor(getColor());
		window.fillRect(getX(), getY(), getWidth(), getHeight());
		// draw the ball at its new location
	}

	public boolean equals(Object obj) {
		if (getX() == ((Ball) obj).getX() && getY() == ((Ball) obj).getY() && getWidth() == ((Ball) obj).getWidth()
				&& getHeight() == ((Ball) obj).getHeight() && getColor() == ((Ball) obj).getColor()
				&& getXSpeed() == ((Ball) obj).getXSpeed() && getYSpeed() == ((Ball) obj).getYSpeed()) {
			return true;
		}

		return false;
	}

	public int getXSpeed() {

		return xSpeed;
	}

	public int getYSpeed() {

		return ySpeed;
	}

	public String toString() {
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + "  " + getXSpeed()
				+ " " + getYSpeed();
	}
}