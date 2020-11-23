package Practice_5.paragraph_1;

public class MovableCircle implements Movable {
	private int radius;
	private MovablePoint center;
	public MovableCircle(int x,int y,int xSpeed, int ySpeed,int radius)
	{
		this.radius=radius;
		this.center=new MovablePoint(x,y,xSpeed,ySpeed);
	}

	@Override
	public void moveUp() {
		center.moveUp();
		System.out.println("Circle with radius "+radius+" was moved with the point");
	}

	@Override
	public void moveDown() {
		center.moveDown();
		System.out.println("Circle with radius "+radius+" was moved with the point");
	}

	@Override
	public void moveLeft() {
		center.moveLeft();
		System.out.println("Circle with radius "+radius+" was moved with the point");
	}

	@Override
	public void moveRight() {
		center.moveRight();
		System.out.println("Circle with radius "+radius+" was moved with the point");
	}

	@Override
	public String toString() {
		return "MovableCircle{" +
				"radius=" + radius +
				", center=" + center +
				'}';
	}
}
