
public abstract class Shape implements Comparable<Shape> {

	private int id;
	private static int nextID = 0;
	
	public Shape() {
		id = nextID;
		nextID = nextID + 1;
	}
	
	public int getID() {
		return id;
	}

	public abstract double getPerimeter();
	
	public abstract double getArea();
	
	public int compareTo(Shape other) {
		if(getClass().getName().compareTo(other.getClass().getName()) != 0)
			return getClass().getName().compareTo(other.getClass().getName());
		if(this.getPerimeter() != other.getPerimeter()) {
			if(this.getPerimeter() > other.getPerimeter())
				return 1;
			if(this.getPerimeter() < other.getPerimeter())
				return -1;
		}
		if(this.getArea() != other.getArea()) {
			if(this.getArea() > other.getArea())
				return 1;
			if(this.getArea() < other.getArea())
				return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "<"
				+ getClass().getName()
				+ ", ID: " + id
				+ ", PERIMETER: " + String.format("%.1f", getPerimeter())
				+ ", AREA: " + String.format("%.1f", getArea())
				+ ">";
	}
}