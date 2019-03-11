package domain;

public class CardBean {
	private FaceEnum face;
	private ColorEnum color;

	/*
	 * constructeur
	 */

	public CardBean(FaceEnum face, ColorEnum couleur) {
		super();
		this.face = face;
		color = couleur;
	}

	public CardBean() {
		super();
	}

	/*
	 * (non-Javadoc) * @see java.lang.Object#toString()
	 */

	/* override de la méthode générale String pour afficher la carte en string */
	@Override
	public String toString() {
		return face + " de " + color;
	}

	/*
	 * getters / setters
	 */

	public ColorEnum getCouleur() {
		return color;
	}

	public FaceEnum getFace() {
		return face;
	}

}
