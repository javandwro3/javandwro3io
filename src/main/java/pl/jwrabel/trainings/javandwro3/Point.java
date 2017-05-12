package pl.jwrabel.trainings.javandwro3;

/**
 * Created by jakubwrabel on 11/05/2017.
 */
public class Point {
	private double x;
	private double y;

	// Konstruktor tworzący punkt na podstawie String w formacie "x,y", np. "100,200"
	public Point(String text) {
		String[] split = text.split(",");

		this.x = Double.parseDouble(split[0]);
		this.y = Double.parseDouble(split[1]);
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "" + x + ", " + y;
	}
}
