package Practice_4;

public class Square extends Rectangle{
	public Square()
	{}

	public Square(double side)
	{
		this.length=side;
		this.width=side;
	}

	public Square(double side,String color,boolean filled)
	{
		this.length=side;
		this.width=side;
		this.color=color;
		this.filled=filled;
	}

	public double getSide()
	{
		return length;
	}

	public void setSide(double side)
	{
		this.length=side;
		this.width=side;
	}

	@Override
	public double getArea() {
		return Math.pow(getSide(),2);
	}

	@Override
	public double getPerimetr() {
		return 4*getSide();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
