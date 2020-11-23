package Practice_4;

public class Circle extends Shape{
	protected  double radius;
	public Circle()
	{}
	public Circle(double radius)
	{
		this.radius=radius;
	}

	public Circle(double radius, String color,boolean filled)
	{
		this.radius=radius;
		this.color=color;
		this.filled=filled;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI*Math.pow(radius,2);
	}

	@Override
	public double getPerimetr() {
		return 2*Math.PI*radius;
	}

	@Override
	public String toString() {
		return "Circle{" +
				"radius=" + radius +
				", color='" + color + '\'' +
				", filled=" + filled +
				'}';
	}
}
