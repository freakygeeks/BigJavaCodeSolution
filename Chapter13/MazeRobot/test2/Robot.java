import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

public class Robot {

	int x, y;
	int direction, dx, dy;
	boolean isFinished = false;

	static int RIGHT = 0;
	static int DOWN = 1;
	static int LEFT = 2;
	static int UP = 3;

	String image;
	Image robotImages[];

	public Robot(int x, int y) {
		this.x = x;
		this.y = y;
		direction = 0;
		image = ">";
		dx = 1;
		dy = 0;
		robotImages = new Image[4];
		loadImages();
	}

	public Robot() {
		this.x = 0;
		this.y = 0;
		direction = 0;
		image = "^";
		robotImages = new Image[4];
		loadImages();
	}

	private void loadImages() {

		for (int i = 0; i < 4; i++)
			robotImages[i] = Toolkit.getDefaultToolkit().createImage(
					"robot" + i + ".gif");
	}

	public Robot(Robot r) {
		this.x = r.getX();
		this.y = r.getY();
		this.dx = r.dx;
		this.dy = r.dy;
		this.direction = r.direction;
		this.image = r.image;
		robotImages = new Image[4];
		loadImages();
	}

	public Point forwardLocation() {
		return new Point(getX() + dx, getY() + dy);
	}

	public Point rightLocation() {
		if (dx == 0)
			return new Point(getX() - dy, getY());
		else
			return new Point(getX(), getY() + dx);
	}

	public Point leftLocation() {
		if (dx == 0)
			return new Point(getX() + dy, getY());
		else
			return new Point(getX(), getY() - dx);
	}

	public String toString() {
		return image;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public void setDirection(String s) {

		if (s.equals(">")) {
			direction = RIGHT;
			dx = 1;
			dy = 0;
			image = ">";
			return;
		}
		if (s.equals("v")) {
			direction = DOWN;
			dx = 0;
			dy = 1;
			image = "v";
			return;
		}
		if (s.equals("<")) {
			direction = LEFT;
			dx = -1;
			dy = 0;
			image = "<";
			return;
		}
		if (s.equals("^")) {
			direction = UP;
			dx = 0;
			dy = -1;
			image = "^";
			return;
		}

		System.err.println("Bad input!");
	}

	public void setDirection(int dir) {
		if (dir == RIGHT) {
			direction = RIGHT;
			dx = 1;
			dy = 0;
			image = ">";
			return;
		}
		if (dir == DOWN) {
			direction = DOWN;
			dx = 0;
			dy = 1;
			image = "v";
			return;
		}
		if (dir == LEFT) {
			direction = LEFT;
			dx = -1;
			dy = 0;
			image = "<";
			return;
		}
		if (dir == UP) {
			direction = UP;
			dx = 0;
			dy = -1;
			image = "^";
			return;
		}

		System.err.println("Bad input!");

	}

	public boolean isFinished() {
		return isFinished;
	}

	public void spinClockwise() {
		setDirection((direction + 1) % 4);
	}

	public void spinCounterClockwise() {
		setDirection((direction + 3) % 4);
	}

	public void spinAround() {
		spinClockwise();
		spinClockwise();
	}

	public String nextMove() {
		String s = "";
		s = "Rob at (" + getX() + "," + getY() + ") moves " + toString()
				+ " to ";
		s += "(" + (getX() + dx) + "," + (getY() + dy) + ")";
		return s;
	}

	public void moveForward() {
		setX(getX() + dx);
		setY(getY() + dy);
	}

	public Image getRealImage() {
		return robotImages[direction];
	}

}
