package domain;

import java.util.ArrayList;

public class DeckBean {

	private ArrayList<domain.CardBean> list;

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

	public void printDeck() {
		for (CardBean card : list) {
			System.out.println(card.getValue() + " de " + card.getCouleur());
		}
	}

	/*
	 * getters / setters
	 */

	public ArrayList<domain.CardBean> getList() {
		return list;
	}

	public void setList(ArrayList<domain.CardBean> list) {
		this.list = list;
	}

}
