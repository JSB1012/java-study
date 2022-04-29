package paint;

public class Circle extends Shape {
	private int x, y;
	private int raduis;
	
	@Override
	public void draw() {
		System.out.println("원을 그렸습니다.");

	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRaduis() {
		return raduis;
	}

	public void setRaduis(int raduis) {
		this.raduis = raduis;
	}



}
