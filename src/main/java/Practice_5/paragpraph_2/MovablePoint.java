package Practice_5.paragpraph_2;

	public class MovablePoint implements Movable {
		private double x;
		private double y;
		private int xSpeed;
		private int ySpeed;

		public MovablePoint(double x, double y, int xSpeed, int ySpeed) {
			this.x = x;
			this.y = y;
			this.xSpeed = xSpeed;
			this.ySpeed = ySpeed;
		}

		public void setX(double x) {
			this.x = x;
		}

		public void setY(double y) {
			this.y = y;
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		@Override
		public void moveUp() {
			this.y += ySpeed;
			System.out.println("(" + x + ";" + y + ")");
		}

		@Override
		public void moveDown() {
			this.y -= ySpeed;
			System.out.println("(" + x + ";" + y + ")");
		}

		@Override
		public void moveLeft() {
			this.x -= xSpeed;
			System.out.println("(" + x + ";" + y + ")");
		}

		@Override
		public void moveRight() {
			this.x += xSpeed;
			System.out.println("(" + x + ";" + y + ")");
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


