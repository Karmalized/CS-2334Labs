import java.util.Objects;

public class Card implements Comparable<Card> {
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) throws NullPointerException {
		if(rank == null || suit == null)
			throw new NullPointerException();
		
		this.rank = rank;
		this.suit = suit;
	}
	
	public int compareTo(Card card) {
		int comparative = 0;
		if(suit.toString().compareTo(card.getSuit().toString()) > 0) {
			comparative = 1;
		}
		
		if(suit.toString().compareTo(card.getSuit().toString()) < 0) {
			comparative = -1;
		}
		
		if(suit.toString().compareTo(card.getSuit().toString()) == 0) {
			if(rank.toString().compareTo(card.getRank().toString()) > 0) {
				comparative = 1;
			}
			
			if(rank.toString().compareTo(card.getRank().toString()) < 0) {
				comparative = -1;
			}
			
			if(rank.toString().compareTo(card.getRank().toString()) == 0) {
				comparative = 0;
			}
		}
		
		return comparative;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Card) {
			Card referenceCard = (Card)obj;
			if(compareTo(referenceCard) == 0)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public int hashCode() {
		return Objects.hash(rank,suit);
	}
	
	public String toString() {
		return rank.toString() + suit.toString();
	}
}
