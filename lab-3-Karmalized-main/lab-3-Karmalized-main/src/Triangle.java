
public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1;
	
	public Triangle() {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	
	//currently for individual, if fail make it so all variables are assigned DEFAULT
	public Triangle(double A, double B, double C) {
	boolean checker = false;	
	if(A >= 1 && B + C > A) {
		sideA = A;
	} else {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
		checker = true;
	}
	
	
	if(B >= 1 && A + C > B && checker != true) {
		sideB = B;
	} else {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
		checker = true;
	}
	
	if(C >= 1 && B + A > C && checker != true) {
		sideC = C;
	} else {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
		checker = true;
	}
	}
	//currently for individual, if fail make it so it affects
	public Triangle(double[] sides) {
		boolean brokeInequality = false;
		if(sides != null && sides.length == 3) {

			if(sides[0] >= 1 && sides[1] + sides[2] > sides[0]) {
				sideA = sides[0];
			} else {
				sideA = DEFAULT_SIDE;
				sideB = DEFAULT_SIDE;
				sideC = DEFAULT_SIDE;
				brokeInequality = true;
			}
			if(sides[1] >= 1 && sides[0] + sides[2] > sides[1] && brokeInequality != true) {
				sideB = sides[1];
			} else {
				sideB = DEFAULT_SIDE;
				sideA = DEFAULT_SIDE;
				sideC = DEFAULT_SIDE;
				brokeInequality = true;
			}
			if(sides[2] >= 1 && sides[0] + sides[1] > sides[2] && brokeInequality != true) {
				sideC = sides[2];
			} else {
				sideC = DEFAULT_SIDE;
				sideA = DEFAULT_SIDE;
				sideB = DEFAULT_SIDE;
				brokeInequality = true;
			}
			
		} else {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
		}
	
	public Triangle(Triangle triangle) {
			if(triangle == null) {
				sideA = DEFAULT_SIDE;
				sideB = DEFAULT_SIDE;
				sideC = DEFAULT_SIDE;
			} else {
				sideA = triangle.sideA;
				sideB = triangle.sideB;
				sideC = triangle.sideC;
			}
				
		}
	
	public double getSideA() {
		return sideA;
		}
	
	public double getSideB() {
		return sideB;
		}
	
	public double getSideC() {
		return sideC;
		}
	
	public double[] getSides() {
		double[] sideList = new double[3];
		sideList[0] = sideA;
		sideList[1] = sideB;
		sideList[2] = sideC;
		return sideList;
		}
	
	public double getAngleA() {
		return lawOfCosines(sideB,sideC,sideA);
	}
	
	public double getAngleB() {
		return lawOfCosines(sideA,sideC,sideB);
	}
	
	public double getAngleC() {
		return lawOfCosines(sideA,sideB,sideC);
	}
	
	public double[] getAngles() {
		double[] angles = new double[3];
		angles[0] = getAngleA();
		angles[1] = getAngleB();
		angles[2] = getAngleC();
		return angles;
	}
	
	public boolean setSideA(double sideA) {
		if(sideA >= 1 && isTriangle(sideA, this.sideB, this.sideC) == true) {
			this.sideA = sideA;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setSideB(double sideB) {
		if(sideB >= 1 && isTriangle(this.sideA, sideB, this.sideC) == true) {
			this.sideB = sideB;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setSideC(double sideC) {
		if(sideC >= 1 && isTriangle(this.sideA, this.sideB, sideC) == true) {
			this.sideC = sideC;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean setSides(double[] sides) {
		if(sides != null && sides.length == 3) {
			double storageA = 0;
			double storageB = 0;
			double storageC = 0;
			if(sides[0] >= 1 && sides[1] + sides[2] > sides[0]) {
				storageA = sides[0];
			} else {
				return false;
			}
			if(sides[1] >= 1 && sides[0] + sides[2] > sides[1]) {
				storageB = sides[1];
			} else {
				return false;
			}
			if(sides[2] >= 1 && sides[0] + sides[1] > sides[2]) {
				storageC = sides[2];
			} else {
				return false;
			}
			
			sideA = storageA;
			sideB = storageB;
			sideC = storageC;
			return true;
		} else {
			return false;
		}

		}
	
	public static boolean isTriangle(double a, double b, double c) {
			boolean isItATriangle = false;
			if(a >= 1 && b + c > a)
				isItATriangle = true;
			else
				return false;
			
			if(b >= 1 && a + c > b)
				isItATriangle = true;
			else
				return false;
			
			if(c >= 1 && b + a > c)
				isItATriangle = true;
			else
				return false;
			return isItATriangle;
		}
	
	public static boolean isTriangle(double[] sides) {
		boolean isItATriangle = false;
		if(sides != null && sides.length == 3) {
		if(sides[0] >= 1 && sides[1] + sides[2] > sides[0])
			isItATriangle = true;
		else
			return false;
		
		if(sides[1] >= 1 && sides[0] + sides[2] > sides[1])
			isItATriangle = true;
		else
			return false;
		
		if(sides[2] >= 1 && sides[0] + sides[1] > sides[2])
			isItATriangle = true;
		else
			return false;
		return isItATriangle;
		}
		return false;
	}
	
	public static double lawOfCosines(double a, double b, double c) {
		return Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2))/(2*a*b)) * 180/Math.PI;
		}
	
	public String toString() {
		return String.format("Triangle(%.4f, %.4f, %.4f)", this.sideA, this.sideB, this.sideC);
	}
	}