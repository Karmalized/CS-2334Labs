import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				Card addingCard = new Card(rank,suit);
				cards.add(addingCard);
			}
		}
	}
	
	public int size() {
		return cards.size();
	}
	
	public Card draw() {
		if(cards.size() == 0) {
			return null;
		} else {
			return cards.remove(0);
		}
	}
	
	public String toString() {
		return Arrays.toString(cards.toArray());
	}
	
	public List<Card> draw(int count){
		List<Card> returnedDraws = new ArrayList<>();
		if(count > cards.size()) {
			for(Card addCard : cards) {
				returnedDraws.add(addCard);
			}
			cards.clear();
			return returnedDraws;
		}
		
		if(count < 0) {
			return returnedDraws;
		}
		
		for(int i = 0; i < count; i++) {
			returnedDraws.add(cards.remove(0));
		}
		return returnedDraws;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public List<Card> getCardsByRank(Rank rank){
		List<Card> selectedRank = new ArrayList<>();
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).getRank() == rank)
				selectedRank.add(cards.get(i));
		}
		return selectedRank;
	}
}
