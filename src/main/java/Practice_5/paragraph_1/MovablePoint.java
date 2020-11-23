package Practice_5.paragraph_1;

public class MovablePoint implements Movable {
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;

	public MovablePoint(int x,int y, int xSpeed,int ySpeed)
	{
		this.x=x;
		this.y=y;
		this.xSpeed=xSpeed;
		this.ySpeed=ySpeed;
	}

	@Override
	public void moveUp() {
		this.y+=ySpeed;
		System.out.println("Point moved up to cords("+x+";"+y+")");
	}

	@Override
	public void moveDown() {
		this.y-=ySpeed;
		System.out.println("Point moved down to cords("+x+";"+y+")");
	}

	@Override
	public void moveLeft() {
		this.x-=xSpeed;
		System.out.println("Point moved left to cords("+x+";"+y+")");
	}

	@Override
	public void moveRight() {
		this.x+=xSpeed;
		System.out.println("Point moved right to cords("+x+";"+y+")");
	}

	@Override
	public String toString() {
		return "MovablePoint{" +
				"x=" + x +
				", y=" + y +
				", xSpeed=" + xSpeed +
				", ySpeed=" + ySpeed +
				'}';
	}
}
