/**
 * Caitlyn Jones
 * @author caitlyn jones
 * caitlynj@brandeis.edu
 * March 19, 2023
 * PA 3
 * 
 * This class includes the properties and
 * methods of a singular card. It initializes
 * the card's value and suit. It includes 
 * methods to get the value, color, and suit 
 * of the card, and it also contains a 
 * toString method to return the card when
 * it is drawn in the Deck class.
 * 
 * Known Bugs: none.
 *
 */
public class Card {
	//fields to hold the properties of a card
	private String suit;
	private String color;
	private int value;


	/**
	 * Initializes a card with its value and suit
	 * @param value
	 * @param suit
	 */
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;

	}
	
	/**
	 * returns the value of the card
	 * @return
	 */
	public int getValue() {
		return this.value;		
	}

	/**
	 * returns the color of the card
	 * Hearts and Diamonds = red
	 * Club and Spades = black
	 * @return
	 */
	public String getColor() {
		if(this.suit == "Hearts" || this.suit == "Diamonds") {
		
			this.color = "red";
		}
		else {
			this.color = "black";
		}
		return this.color;
	}
	/**
	 * returns the suit of the card
	 * @return
	 */
	public String getSuit() {
		return this.suit;
	}
	
	/**
	 * returns a String that produces the
	 * format for printing a card.
	 * ex: 2 of Clubs
	 * exceptions: changes 1, 11, 12, 13 
	 * to Ace, Jack, Queen, King when
	 * printing the card
	 */
	public String toString() {
		if(this.value == 1) {
			return "Ace of " + this.getSuit();
		}
		else if(this.value == 11) {
			return "Jack of " + this.getSuit();
		}
		else if(this.value == 12) {
			return "Queen of " + this.getSuit();
		}
		else if (this.value == 13) {
			return "King of " + this.getSuit();
		}
		else {
			return this.getValue() + " of " + this.getSuit();
		}

	}

}
