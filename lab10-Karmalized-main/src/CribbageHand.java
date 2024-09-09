import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class CribbageHand {
	public static final Map<Rank, Integer> CARD_VALUES;
	public final List<Card> cards;
	
	static {
		CARD_VALUES = Map.ofEntries(
				entry(Rank.ACE,1),
				entry(Rank.TWO,2),
				entry(Rank.THREE,3),
				entry(Rank.FOUR,4),
				entry(Rank.FIVE,5),
				entry(Rank.SIX,6),
				entry(Rank.SEVEN,7),
				entry(Rank.EIGHT,8),
				entry(Rank.NINE,9),
				entry(Rank.TEN,10),
				entry(Rank.JACK,10),
				entry(Rank.QUEEN,10),
				entry(Rank.KING,10)
				);
	}
	
	public CribbageHand(Card c1, Card c2, Card c3, Card c4) throws NullPointerException {
		if(c1 == null || c2 == null || c3 == null || c4 == null)
			throw new NullPointerException();
		cards = List.of(c1,c2,c3,c4);
	}
	
	public static Set<Set<Card>> powerSet(List<Card> cards) {
		Set<Set<Card>> setsOfCards = new HashSet<>();
		//Establish new Set of Sets of Cards
		if(cards.size() <= 0) {
			//base case cards size is 0
			setsOfCards.add(new HashSet<Card>(cards));
			return setsOfCards;
		} else {
			Card beginnerCard = cards.get(0);
			//grab the first card
			List<Card> otherCards = cards.subList(1, cards.size());
			//establish a list with the rest of the cards
			Set<Set<Card>> otherCardSets = powerSet(otherCards);
			//create a subset of sets of cards that recursively utilizes the remaining cards not used
			for(Set<Card> otherCardSet : otherCardSets) {
				//this for loop creates multiple sets of cards from the remaining cards
				Set<Card> integrateSet = new HashSet<>(otherCardSet);
				//and integrates the first card to complete the set multiples to be added into the main set
				integrateSet.add(beginnerCard);
				setsOfCards.add(integrateSet);
			}
			//integrates the sets from all the other sets found recursively into the main set
			setsOfCards.addAll(otherCardSets);
		}
		
		return setsOfCards;
	}
	
	public Set<Set<Card>> fifteens(Card starter){
		Set<Set<Card>> fifteenSets = new HashSet<>();
		for(Set<Card> specificSet : powerSet(cards)) {
			int addedValues = 0;
			for(Card card : specificSet) {
				addedValues += CARD_VALUES.get(card.getRank());
			}
			if(addedValues == 15) {
				fifteenSets.add(specificSet);
			}
			if(addedValues + CARD_VALUES.get(starter.getRank()) == 15) {
				specificSet.add(starter);
				fifteenSets.add(specificSet);
			}
		}
		return fifteenSets;
	}
}
