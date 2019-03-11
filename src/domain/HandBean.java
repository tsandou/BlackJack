package domain;

import java.util.ArrayList;
import java.util.List;

public class HandBean {
	private List<CardBean> cardList;

	/*
	 * constructeur
	 */

	public HandBean() {
		super();
		cardList = new ArrayList<>();
	}

	public HandBean(CardBean card1, CardBean card2) {
		this();
		cardList.add(card1);
		cardList.add(card2);
	}

	/* méthodes */

	public int calculateHandScore() {
		int handScore = 0;
		for (CardBean cardBean : cardList) {
			handScore += cardBean.getFace().getValue();
		}
		return handScore;
	}

	public void addCard(CardBean card) {
		cardList.add(card);
	}

	/*
	 * getters / setters
	 */
	public List<CardBean> getHand() {
		return cardList;
	}

	// setter inutile dans le jeu du black Jack : on ne reset jamais la main !!
	@Deprecated
	public void setHand(List<CardBean> hand) {
		cardList = hand;
	}
}
