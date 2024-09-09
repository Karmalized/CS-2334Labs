import java.util.Arrays;
import java.util.*;
public class RandomPlayer extends Player {
	public RandomPlayer(String name) {
		super(name);
	}
	
	public int[] getMove(int[] pileSizes) {
		
		Random random = new Random();
		boolean confirmMove = false;
		int pileIdx = 0;
		int numObjects = 0;
		while(confirmMove == false) {
			pileIdx = random.nextInt(pileSizes.length);
			if(pileSizes[pileIdx] != 0) {
			numObjects = random.nextInt(pileSizes[pileIdx]) + 1;
			confirmMove = true;
			} else {
				confirmMove = false;
			}
		}
		return new int[] {pileIdx, numObjects};
	}
}
