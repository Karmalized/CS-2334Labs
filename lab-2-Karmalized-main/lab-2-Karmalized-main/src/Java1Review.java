/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
import java.util.*;
public class Java1Review {
	//@param String[] (String array needing to be lowercase)
	public static String[] toLowerCase(String[] stringed){
		for(int i = 0; i < stringed.length; i++){
		String needsLowerCase = stringed[i];
		needsLowerCase = needsLowerCase.toLowerCase();
		stringed[i] = needsLowerCase;
		System.out.println(stringed[i]); //@test all lowercase string
		}
		return stringed;
	}
	
	public static String[] toLowerCaseCopy(String[] copyString) {
		String[] copiedString = new String[copyString.length];
		for(int i = 0; i < copyString.length; i++) {
			copiedString[i] = copyString[i];
		}
		copiedString = toLowerCase(copiedString);
		return copiedString;
	}
	public static void removeDuplicates(int[] numArray) {
		if(numArray.length > 1) {
			for(int i = 0; i < numArray.length-1; i++) {
				int counting = 0;
				int newGuy = numArray[i];
				for(int j = 0; j < numArray.length; j++) {
					if(newGuy == numArray[j])
						counting++;
				}
				if(counting > 1) {
					for(int k = 0; k < numArray.length; k++) {
						if(newGuy == numArray[k])
							numArray[k] = 0;
					}
				}
			}
		System.out.println(numArray);
		}
	}
	
	public static int findMin(int num1, int num2, int num3) {
		int lowest = num1;
		if(num2 < lowest)
			lowest = num2;
		if(num3 < lowest)
			lowest = num3;
		return lowest;
			
		
	}
	
	public static int findMin(int[] arrays) {
		int lowest = arrays[0];
		for(int i = 0; i < arrays.length; i++) {
			if(arrays[i] < lowest)
				lowest = arrays[i];
		}
		return lowest;
	}
	
	public static boolean isDivisibleBy7(int num) {
		double number = num/7.0;
		System.out.print(number);
		int checker = num/7;
		System.out.print(checker);
		if(number != checker)
			return false;
			else
				return true;
	}
	
	public static double average(int[] arrays) {
		double sum = 0;
		double counter = 0;
		for(int i = 0; i < arrays.length; i++) {
			sum = sum + arrays[i];
			counter++;
		}
		return sum / counter;
	}
	
	public static double divide(double num1, double num2) {
		return num1 / num2;
	}
	
	public static int divide(int number1, int number2) {
		return number1 / number2;
	}
	
	public static String main(String newStuff) {
		return "Overloaded main method was passed \"" + newStuff + "\".";
	}
	

	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
	}
	

}
