package Practice_12;

public enum Palette {
	PINK("\u001B[95m"),
	WHITE("\u001B[30m"),

	RED("\u001B[31m"),
	YELLOW("\u001B[33m"),
	GREEN("\u001B[32m"),
	CYAN("\u001B[36m"),
	BLUE("\u001B[34m"),
	MAGENTA("\u001B[35m"),
	RESET("\u001B[0m");

	private String color;

	Palette(String color)
	{
		this.color=color;
	}

	public String getColor() {
		return color;
	}
}
