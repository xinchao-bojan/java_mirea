package Practice_5.paragraph_1;

public class Tester {
	public static void main(String[] args) {
		MovablePoint point=new MovablePoint(0,0,10,15);
		MovableCircle circle=new MovableCircle(1,1,2,2,15);
		point.moveRight();
		point.moveUp();
		point.moveLeft();
		point.moveDown();
		circle.moveDown();
		circle.moveUp();
		circle.moveLeft();
		circle.moveRight();
	}
}
