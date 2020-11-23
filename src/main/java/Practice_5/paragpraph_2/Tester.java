package Practice_5.paragpraph_2;

public class Tester {
	public static void main(String[] args) {
		MovableRectangle rectangle = new MovableRectangle(0, 1, 1, 0, 1, 1);
		rectangle.moveDown();
		rectangle.moveUp();
		rectangle.setLength(2);
		rectangle.setWidth(2);
		rectangle.moveRight();
		rectangle.moveLeft();
	}
}


