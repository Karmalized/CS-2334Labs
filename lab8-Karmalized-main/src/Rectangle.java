
public class Rectangle extends IsoscelesTrapezoid {
	public Rectangle(double width, double height) {
		super(width,width,height);
	}
	
	public double getWidth() {
		return super.getTop();
	}
	
	public double getHeight() {
		return Math.sqrt(Math.pow(getLeg(), 2) - Math.pow((getBase()-getTop())/2, 2));
	}
}
