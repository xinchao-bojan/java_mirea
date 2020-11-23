package Practice_2;

public class Shape {
	private int height;
	private int length;
	private int thickness;
	private int volume;

	public Shape(int height,int length, int thickness,int volume)
	{
		this.height=height;
		this.length=length;
		this.thickness=thickness;
		this.volume=volume;
	}

	@Override
	public String toString() {
		return "Shape{" +
				"height=" + height +
				", length=" + length +
				", thickness=" + thickness +
				", volume=" + volume +
				'}';
	}
}