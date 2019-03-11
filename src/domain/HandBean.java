package domain;

import java.util.ArrayList;

public class HandBean {
	private ArrayList<CardBean> hand;

	/*
	 * constructeur
	 */

	public HandBean() {
		super();
	}

	public HandBean(CardBean card1, CardBean card2) {
		hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
	}

	/* méthodes */

	public int calculateHandScore(ArrayList<CardBean> hand) {
		int handScore = 0;
		for (CardBean cardBean : hand) {
			handScore = handScore + cardBean.getValue().getValue();
		}
		return handScore;
	}

	public void addCard(CardBean card) {
		hand.add(card);
	}

	/*
	 * getters / setters
	 */
	public ArrayList<CardBean> getHand() {
		return hand;
	}

	public void setHand(ArrayList<CardBean> hand) {
		this.hand = hand;
	}
}
