package demo;

import java.util.List;

public class Triangle {

	private List<Point> p;
	

	public List<Point> getP() {
		return p;
	}

	public void setP(List<Point> p) {
		this.p = p;
	}

	public void draw() {
		for (Point point:p)
		System.out.println("x= "+point.getX()+" y="+point.getY());
	}
}
