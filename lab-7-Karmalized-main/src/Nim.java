public class Nim {

	private Player currentPlayer;
	private Player waitingPlayer;
	private Piles piles;
	private Player winner = null;
	private Player loser = null;

	public Nim(Player p1, Player p2, int[] initSizes) {
		currentPlayer = p1;
		waitingPlayer = p2;
		piles = new Piles(initSizes);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Player getWaitingPlayer() {
		return waitingPlayer;
	}

	public int[] getPileSizes() {
		return piles.getSizes();
	}

	public Player getWinner() {
		return winner;
	}

	public Player getLoser() {
		return loser;
	}

	public void takeTurn() {
		boolean completedMove = false;
		while(completedMove == false) {
			try {
			int[] move = currentPlayer.getMove(getPileSizes());
			piles.removeObjects(move);
			waitingPlayer.notifyOpponentMove(currentPlayer.getName(), move);
			completedMove = true;
			} catch (Exception e) {
				currentPlayer.notifyIllegalMove(e.getMessage());
				completedMove = false;
			}
		}
	}

	public void checkGameOver() {
		if (piles.isEmpty()) {
			winner = waitingPlayer;
			loser = currentPlayer;
		}
	}

	public void swapPlayers() {
		Player temp = currentPlayer;
		currentPlayer = waitingPlayer;
		waitingPlayer = temp;
	}

	public void play() {
		while (winner == null || loser == null) {
			takeTurn();
			checkGameOver();
			swapPlayers();
		}
		winner.notifyWin();
		loser.notifyLose();
	}
}
