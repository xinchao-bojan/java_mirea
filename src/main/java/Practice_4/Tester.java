package Practice_4;

public class Tester {
	public static void main(String[] args) {
		Square sq=new Square(4.58,"orange",true);
		System.out.println(sq.toString());
		Circle circle=new Circle(4);
		System.out.println(circle.getArea());
		Rectangle rec=new Rectangle();
		rec.setLength(9);
		rec.setWidth(1);
		System.out.println(rec.getPerimetr());


	}
}
