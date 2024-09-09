
public class IsoscelesTrapezoid extends Polygon {
	
	private double top;
	private double base;
	private double leg;
	private double area;
	private double triangleBase;
	private double height;
	
	public IsoscelesTrapezoid(double top, double base, double leg) {
		super(top,base,leg,leg);
		this.top = top;
		this.base = base;
		this.leg = leg;
		this.triangleBase = (base-top)/2;
		height = Math.sqrt(Math.pow(leg, 2) - Math.pow(triangleBase, 2));
	}
	
	public double getTop() {
		return top;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getLeg() {
		return leg;
	}
	
	public double getArea() {
		return height * ((top+base)/2);
	}
	
	public Rectangle getCenterRectangle() {
		if(top < base)
			return new Rectangle(top,height);
		else
			return new Rectangle(base,height);
	}
}
