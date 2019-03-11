package domain;

import java.util.ArrayList;
import java.util.Collections;

public class DeckBean {

	private ArrayList<CardBean> list;

	public DeckBean() {
		list = new ArrayList<>();
		for (ColorEnum colorEnum : ColorEnum.values()) {
			for (FaceEnum faceEnum : FaceEnum.values()) {
				CardBean card = new CardBean(faceEnum, colorEnum);
				list.add(card);
			}
		}
	}

	/*
	 * méthodes
	 */

	public DeckBean prepare() {
		DeckBean deck = new DeckBean();
		// deck.printDeck();
		System.out.println("Le paquet contient " + deck.getDeckNbOfCards() + " cartes. \n");
		deck.shuffle();
		// afficher le deck
		System.out.println(deck);
		return deck;
	}

	/* override de la méthode générale String pour afficher le deck en string */
	@Override
	public String toString() {
		String deckToString = "";
		for (CardBean cardBean : list) {
			deckToString += cardBean.toString();
		}
		return deckToString;
	}

	// @Deprecated pour garder une méthode que l'on a remplacé par une autre
	// lorsqu'on ne veut pas modifier partout tout de suite.
	// remplacé par les méthodes ToString de DeckBean et CardBean.
	@Deprecated
	public void printDeck() {
		for (CardBean card : list) {
			System.out.println(card.getFace() + " de " + card.getCouleur());
		}
	}

	/* mélanger le paquet */
	public void shuffle() {
		Collections.shuffle(list);
	}

	/**
	 * Renvoie le nombre de cartes disponibles.
	 *
	 * @return Retourne le nombre de cartes disponibles.
	 */
	public int getDeckNbOfCards() {
		return list.size();
	}

	/*
	 * Randomly select a card from a card deck
	 *
	 * @ return The selected card
	 */
	public CardBean pickACard() {
		CardBean card = list.remove(0);
		return card;
	}

	/*
	 * getters / setters
	 */

	public ArrayList<CardBean> getList() {
		return list;
	}

	public void setList(ArrayList<CardBean> list) {
		this.list = list;
	}

}
