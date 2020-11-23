package Practice_5.paragpraph_2;

public class MovableRectangle implements Movable {
	private MovablePoint topLeft;
	private MovablePoint botRight;
	private Rectangle rectangle;

	public MovableRectangle(double tX, double tY, double bX, double bY, int xSpeed, int ySpeed) {
		this.topLeft = new MovablePoint(tX, tY, xSpeed, ySpeed);
		this.botRight = new MovablePoint(bX, bY, xSpeed, ySpeed);
		double len = bX - tX;
		double wid = tY - bY;
		this.rectangle = new Rectangle(wid, len);
	}

	public void setLength(double length) {
		topLeft.setX(topLeft.getX() - (length - rectangle.getLength()) / 2);
		botRight.setX(botRight.getX() + (length - rectangle.getLength()) / 2);
		rectangle.setLength(length);
	}

	public void setWidth(double width) {
		topLeft.setY(topLeft.getY() + (width - rectangle.getWidth()) / 2);
		botRight.setY(botRight.getY() - (width - rectangle.getWidth()) / 2);
		rectangle.setWidth(width);
	}

	public double getLength() {
		return rectangle.getLength();
	}

	public double getWidth() {
		return rectangle.getWidth();
	}

	private boolean speedIsEqual() {
		if ((rectangle.getWidth() == topLeft.getY() - botRight.getY()) && (rectangle.getLength() == botRight.getX() - topLeft.getX())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "MovableRectangle{" +
				"topLeft=" + topLeft +
				", botRight=" + botRight +
				", rectangle=" + rectangle +
				'}';
	}

	@Override
	public void moveUp() {
		System.out.println("Top left point moved to coordinates");
		topLeft.moveUp();
		System.out.println("Bot right point moved to coordinates");
		botRight.moveUp();
		if (speedIsEqual())
			System.out.println("Speed is equal");
		else
			System.out.println("Something wrong with speed");
	}

	@Override
	public void moveDown() {
		System.out.println("Top left point moved to coordinates");
		topLeft.moveDown();
		System.out.println("Bot right point moved to coordinates");
		botRight.moveDown();
		if (speedIsEqual())
			System.out.println("Speed is equal");
		else
			System.out.println("Something wrong with speed");
	}

	@Override
	public void moveLeft() {
		System.out.println("Top left point moved to coordinates");
		topLeft.moveLeft();
		System.out.println("Bot right point moved to coordinates");
		botRight.moveLeft();
		if (speedIsEqual())
			System.out.println("Speed is equal");
		else
			System.out.println("Something wrong with speed");
	}

	@Override
	public void moveRight() {
		System.out.println("Top left point moved to coordinates");
		topLeft.moveRight();
		System.out.println("Bot right point moved to coordinates");
		botRight.moveRight();
		if (speedIsEqual())
			System.out.println("Speed is equal");
		else
			System.out.println("Something wrong with speed");
	}
}

