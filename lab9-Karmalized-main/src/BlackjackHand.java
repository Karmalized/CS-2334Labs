import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
	
	private static Map<Rank, Integer> CARD_VALUES;
	private int MAX_VALUE = 21;
	private List<Card> cards = new ArrayList<>();;
	private int value = 0;
	private int numAcesAs11 = 0;
	
	static {
		CARD_VALUES = new HashMap<>();
		
		CARD_VALUES.put(Rank.TWO, 2);
		CARD_VALUES.put(Rank.THREE, 3);
		CARD_VALUES.put(Rank.FOUR, 4);
		CARD_VALUES.put(Rank.FIVE, 5);
		CARD_VALUES.put(Rank.SIX, 6);
		CARD_VALUES.put(Rank.SEVEN, 7);
		CARD_VALUES.put(Rank.EIGHT, 8);
		CARD_VALUES.put(Rank.NINE, 9);
		CARD_VALUES.put(Rank.TEN, 10);
		CARD_VALUES.put(Rank.JACK, 10);
		CARD_VALUES.put(Rank.QUEEN, 10);
		CARD_VALUES.put(Rank.KING, 10);
		CARD_VALUES.put(Rank.ACE, 11);
	}
	
	public BlackjackHand(Card c1, Card c2) {
		cards.add(c1);
		cards.add(c2);
	}
	
	public List<Card> getCards(){
		return new ArrayList<>(cards);
	}
	
	public int size() {
		return cards.size();
	}
	
	public String toString() {
		return cards.toString();
	}
	
	public void addCard(Card card) throws NullPointerException {
		if(card == null)
			throw new NullPointerException();
		if(value < MAX_VALUE) {
			if(card.getRank().toString() == "A")
				numAcesAs11++;
			cards.add(card);
			value += CARD_VALUES.get(card.getRank());
		}
	}
	
	public static Map<Rank, Integer> getCardValues(){
		return new HashMap<>(CARD_VALUES);
	}
	
	public int getValue() {
		value = 0;
		
		for(int i = 0; i < cards.size(); i++) {
			if(value + CARD_VALUES.get(cards.get(i).getRank()) > MAX_VALUE && cards.get(i).getRank() == Rank.ACE)
				value += 1;
			else
				value += CARD_VALUES.get(cards.get(i).getRank());
		}
		
		if(value > MAX_VALUE) {
			value = 0;
			for(int i = 0; i < cards.size(); i++) {
				if(cards.get(i).getRank() == Rank.ACE)
					value += 1;
				else
					value += CARD_VALUES.get(cards.get(i).getRank());
			}
		}
		
		return value;
	}
}
