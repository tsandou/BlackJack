package domain;

public class PlayerBean {

	private String name;
	private HandBean hand;

	/*
	 * contructeur
	 */

	public PlayerBean(String name, HandBean hand) {
		super();
		this.name = name;
		this.hand = hand;
	}

	/*
	 * getters /setters
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HandBean getHand() {
		return hand;
	}

	public void setHand(HandBean hand) {
		this.hand = hand;
	}
}
