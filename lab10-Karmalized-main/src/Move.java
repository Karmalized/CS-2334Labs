
public enum Move {
	
	LEFT_TO_MIDDLE(Peg.LEFT, Peg.MIDDLE),
	LEFT_TO_RIGHT(Peg.LEFT, Peg.RIGHT),
	MIDDLE_TO_LEFT(Peg.MIDDLE, Peg.LEFT),
	MIDDLE_TO_RIGHT(Peg.MIDDLE, Peg.RIGHT),
	RIGHT_TO_LEFT(Peg.RIGHT, Peg.LEFT),
	RIGHT_TO_MIDDLE(Peg.RIGHT, Peg.MIDDLE);
	
	public final Peg from;
	public final Peg to;
	
	private Move(Peg from, Peg to) {
		this.from = from;
		this.to = to;
	}
	
	public static Move move(Peg from, Peg to) throws IllegalArgumentException, NullPointerException {
		
		if(from == to)
			throw new IllegalArgumentException();
		if(from == null || to == null)
			throw new NullPointerException();
		
		Move move = null;
		if(from == Peg.LEFT && to == Peg.MIDDLE)
			move = LEFT_TO_MIDDLE;
		if(from == Peg.LEFT && to == Peg.RIGHT)
			move = LEFT_TO_RIGHT;
		if(from == Peg.MIDDLE && to == Peg.LEFT)
			move = MIDDLE_TO_LEFT;
		if(from == Peg.MIDDLE && to == Peg.RIGHT)
			move = MIDDLE_TO_RIGHT;
		if(from == Peg.RIGHT && to == Peg.LEFT)
			move = RIGHT_TO_LEFT;
		if(from == Peg.RIGHT && to == Peg.MIDDLE)
			move = RIGHT_TO_MIDDLE;
		
		return move;
	}
	
}
