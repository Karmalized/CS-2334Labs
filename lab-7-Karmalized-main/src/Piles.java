import java.util.Arrays;

public class Piles {
	
	private int[] sizes;
	
	public Piles(int...initSizes) throws IllegalArgumentException {
		
		if(initSizes == null || initSizes.length == 0) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < initSizes.length; i++) {
			if(initSizes[i] <= 0) {
				throw new IllegalArgumentException();
			}
		}
		int[] copySizes = Arrays.copyOf(initSizes, initSizes.length);
		sizes = copySizes;
	}
	
	public int[] getSizes() {
		int[] copySizes = Arrays.copyOf(sizes, sizes.length);
		return copySizes;
	}
	
	public void removeObjects(int[] move) throws IllegalMoveException {
		if(move == null) {
			throw new IllegalMoveException("null move");
		}
		if(move.length != 2) {
			throw new IllegalMoveException("Invalid length: " + move.length);
		}
		if(move[0] <= -1 || move[0] >= sizes.length) {
			throw new IllegalMoveException("Index out of bounds: " + move[0]);
		}
		if(sizes[move[0]] == 0) {
			throw new IllegalMoveException("Pile " + move[0] + " is empty.");
		}
		if(move[1] <= 0) {
			throw new IllegalMoveException("Nonpositive object number: " + move[1]);
		}
		if(move[1] > sizes[move[0]]) {
			throw new IllegalMoveException("Object number greater than pile size: " + move[1] + " > " + sizes[move[0]]);
		}
		
		sizes[move[0]] = sizes[move[0]] - move[1];
	}
	
	public boolean isEmpty() {
		int emptyChecker = 0;
		for(int i = 0; i < sizes.length; i++) {
			if(sizes[i] == 0)
				emptyChecker++;
		}
		
		if(emptyChecker == sizes.length)
			return true;
		else
			return false;
	}
}
