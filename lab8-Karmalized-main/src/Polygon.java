
public abstract class Polygon extends Shape {

	private double perimeter;
	
	public Polygon(double...sides) throws IllegalArgumentException {
		if(sides == null) {
			throw new IllegalArgumentException("null sides");
		}
		if(sides.length < 3) {
			throw new IllegalArgumentException("Invalid number of sides: " + sides.length);
		}
		for(int i = 0; i < sides.length; i++) {
			if(sides[i] <= 0)
				throw new IllegalArgumentException("Nonpositive side: " + sides[i]);
		}
			
			double secondCheck = 0;
			int counter = 0;
			for(int i = 0; i < sides.length; i++) {
			while(counter < sides.length) {
				if(i != counter)
					secondCheck += sides[counter];
				counter++;
			}
			counter = 0;
			if(sides[i] >= secondCheck)
				throw new IllegalArgumentException("Polygon inequality violated: " + sides[i] + " >= " + secondCheck);
			secondCheck = 0;
		}
			
		for(int i = 0; i < sides.length; i++) {
			perimeter += sides[i];
		}
		
	}
	
	public abstract double getArea();
	
	public double getPerimeter() {
		return perimeter;
	}
}
