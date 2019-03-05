import domain.DeckBean;

public class Main {

	public static void main(String[] args) {
		DeckBean deck = new DeckBean();
		// deck.printDeck();
		System.out.println("Le paquet contient " + deck.getDeckNbOfCards() + " cartes. \n");
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.pickACard());
	}

}
