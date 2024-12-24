import java.util.Arrays;
import java.util.Random;

/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * March 19, 2023
 * PA 3
 * 
 * This class initializes a deck, which is
 * an array of cards (52 total). The class 
 * first makes an array of cards (deck) and
 * puts the cards into the deck, and shuffles 
 * them. This class includes the mechanics for
 * a deck, such as drawNextCard() and discard(Card c),
 * which will be used when playing the game of War
 * in the Casino class.
 * 
 * Known Bugs: none.
 */
public class Deck {
	//fields for the deck class
	private Card [] deck; 
	private Card [] discardPile;
	
	private int numCards; //used for counting how many cards total there are
	private int numDiscards; //keeps track of # of cards being discarded
	
	/**
	 * Initializes a deck by creating an array of cards.
	 * Then, loops through and adds each card to the deck,
	 * 13 for each 4 suits; shuffles the deck when done.
	 */
	public Deck() {
		deck = new Card[52];
		discardPile = new Card[52];
		numCards = 0;
		numDiscards = 0;
		String[] cardSuits = {"Hearts", "Diamonds","Spades", "Clubs"};
		for(String suit : cardSuits) {
			for(int i = 1; i<=13; i++) {
				Card card = new Card(i,suit);
				deck[numCards] = card;
				numCards++;
			}
		}
		shuffle();
	}

	/**
	 * Implements the Fisher-Yates shuffle method
	 * stated in the assignment. Uses a basic
	 * swapping algorithm using a chair variable
	 * to successfully swap the cards.
	 * 
	 */
	public void shuffle() {
		Random rand = new Random();
		for(int i = numCards - 1; i>= 1; i--) {
			int j = rand.nextInt(i + 1);
			if(deck[j] != null && deck[i] != null) { //makes sure no null elements get shuffled
				//basic swap algorithm 
				Card chair = deck[i];
				deck[i] = deck[j];
				deck[j] = chair;
			}
		}
	}
	
	/**
	 * clones the discard pile if there are 
	 * no cards in the deck. shuffles the deck
	 * after the discard pile is cloned and 
	 * re-initialized to be an empty array/new 
	 * discard pile.
	 * @return card
	 */
	public Card drawNextCard() {
		if(numCards == 0) {
			deck = discardPile.clone();
			numCards = numDiscards;
			discardPile = new Card [52];
			numDiscards = 0;
			shuffle();
		}
		numCards--;
		Card card = deck[numCards];
		deck[numCards] = null;
		return card;
		
	}
	 
	/**
	 * adds the card to the discardPile
	 * and increases the number of discarded
	 * cards.
	 * @param c
	 */
	public void discard(Card c) {
		discardPile[numDiscards] = c;
		numDiscards++;
	}
 
}
