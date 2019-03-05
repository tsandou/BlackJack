package domain;

public class CardBean {
	private FaceEnum face;
	private ColorEnum couleur;

	/*
	 * constructeur
	 */

	public CardBean(FaceEnum face, ColorEnum couleur) {
		super();
		this.face = face;
		this.couleur = couleur;
	}

	/*
	 * getters / setters
	 */

	public FaceEnum getValue() {
		return face;
	}

	public ColorEnum getCouleur() {
		return couleur;
	}

}
