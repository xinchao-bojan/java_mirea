package Practice_5.paragpraph_2;

public class Rectangle extends Shape {

	protected double width;
	protected double length;


	public void Rectangle() {
	}

	public Rectangle(double width, double length) {
		this.length = length;
		this.width = width;
	}

	public void Rectangle(double width, double length, String color, boolean filled) {
		this.length = length;
		this.width = width;
		this.color = color;
		this.filled = filled;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public double getPerimetr() {
		return 2 * (length + width);
	}

	@Override
	public String toString() {
		return "Rectangle{" +
				"width=" + width +
				", length=" + length +
				", color='" + color + '\'' +
				", filled=" + filled +
				'}';
	}
}