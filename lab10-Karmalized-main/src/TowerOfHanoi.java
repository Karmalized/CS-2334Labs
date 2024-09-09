import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TowerOfHanoi {
	
	private Map<Peg, Deque<Integer>> diskStacks;
	
	public TowerOfHanoi(int numDisks, Peg start) throws IllegalArgumentException, NullPointerException {
		diskStacks = new HashMap<>();
		
		if(start == null)
			throw new NullPointerException();
		if(numDisks <= 0)
			throw new IllegalArgumentException();
		
		if(start == Peg.LEFT) {
			diskStacks.put(Peg.MIDDLE, new LinkedList<>());
			diskStacks.put(Peg.RIGHT, new LinkedList<>());
		}
		if(start == Peg.RIGHT) {
			diskStacks.put(Peg.MIDDLE, new LinkedList<>());
			diskStacks.put(Peg.LEFT, new LinkedList<>());
		}
		if(start == Peg.MIDDLE) {
			diskStacks.put(Peg.LEFT, new LinkedList<>());
			diskStacks.put(Peg.RIGHT, new LinkedList<>());
		}
		
		Deque<Integer> AQueue = new LinkedList<>();
		for(int i = 1; i <= numDisks; i++) {
			AQueue.add(i);
		}
		
		diskStacks.put(start, AQueue);
		
	}
	
	public Deque<Integer> getDiskStack(Peg peg) throws NullPointerException {
		if(peg == null)
			throw new NullPointerException();
		Deque<Integer> AQueue = new LinkedList<>();
		for(Integer tempQueue : diskStacks.get(peg))
			AQueue.add(tempQueue);
		return AQueue;
		
	}
	
	public void moveDisk(Move move) throws NullPointerException, IllegalArgumentException {
		if(move == null)
			throw new NullPointerException();
		if(diskStacks.get(move.from).size() == 0)
			throw new IllegalArgumentException();
		if(diskStacks.get(move.from).size() != 0 && diskStacks.get(move.to).size() != 0) {
		if(diskStacks.get(move.from).getLast() > diskStacks.get(move.to).getLast())
			throw new IllegalArgumentException();
		}
		
		diskStacks.get(move.to).addFirst(diskStacks.get(move.from).removeFirst());
	}
	
	public String toString() {
		Map<Peg, Deque<Integer>> sortedValues = new TreeMap<Peg, Deque<Integer>>(diskStacks);
		String game = "";
		int count = 0;
		for(Peg pegs : sortedValues.keySet()) {
			if(pegs == Peg.LEFT) {
				String line = "  " + pegs.toString() + ": " + reverseValues(diskStacks.get(pegs)) + System.lineSeparator();
				game = game + line;
			}
			if(pegs == Peg.MIDDLE) {
				String line = pegs.toString() + ": " + reverseValues(diskStacks.get(pegs)) + System.lineSeparator();
				game = game + line;
			}
			if(pegs == Peg.RIGHT) {
				String line = " " + pegs.toString() + ": " + reverseValues(diskStacks.get(pegs));
				game = game + line;
			}

		}
		return game;
	}
	
	private Deque<Integer> reverseValues(Deque<Integer> reversible){
		Deque<Integer> copyQueue = new LinkedList<>(reversible);
		Deque<Integer> reversedValues = new LinkedList<>();
		for(int i = reversible.size()-1; i >= 0; i--) {
			reversedValues.add(copyQueue.removeLast());
		}
		return reversedValues;
	}
	
	public static List<Move> solve(int numDisks, Peg start, Peg end) throws IllegalArgumentException, NullPointerException {
		
		if(numDisks < 0)
			throw new IllegalArgumentException();
		if(start == null || end == null)
			throw new NullPointerException();
		if(numDisks == 0)
			return new LinkedList<Move>();
		
		List<Move> movesToMake = new LinkedList<Move>();
		//base case: if 1 ring is on the start peg, move to the end peg
		if(numDisks == 1) {
			movesToMake.add(Move.move(start,end));
		} else {
			if(start == Peg.LEFT && end == Peg.RIGHT) {
				movesToMake.addAll(solve(numDisks-1,start,Peg.MIDDLE));
				movesToMake.addAll(solve(1,start,end));
				movesToMake.addAll(solve(numDisks-1,Peg.MIDDLE,end));
			}
			if(start == Peg.LEFT && end == Peg.MIDDLE) {
				movesToMake.addAll(solve(numDisks-1,start,Peg.RIGHT));
				movesToMake.addAll(solve(1,start,end));
				movesToMake.addAll(solve(numDisks-1,Peg.RIGHT,end));
			}
			if(start == Peg.RIGHT && end == Peg.LEFT) {
				movesToMake.addAll(solve(numDisks-1,start,Peg.MIDDLE));
				movesToMake.addAll(solve(1,start,end));
				movesToMake.addAll(solve(numDisks-1,Peg.MIDDLE,end));
			}
			if(start == Peg.RIGHT && end == Peg.MIDDLE) {
				movesToMake.addAll(solve(numDisks-1,start,Peg.LEFT));
				movesToMake.addAll(solve(1,start,end));
				movesToMake.addAll(solve(numDisks-1,Peg.LEFT,end));
			}
			if(start == Peg.MIDDLE && end == Peg.RIGHT) {
				movesToMake.addAll(solve(numDisks-1,start,Peg.LEFT));
				movesToMake.addAll(solve(1,start,end));
				movesToMake.addAll(solve(numDisks-1,Peg.LEFT,end));
			}
			if(start == Peg.MIDDLE && end == Peg.LEFT) {
				movesToMake.addAll(solve(numDisks-1,start,Peg.RIGHT));
				movesToMake.addAll(solve(1,start,end));
				movesToMake.addAll(solve(numDisks-1,Peg.RIGHT,end));
			}
			
		}
		return movesToMake;
	}
	
}
