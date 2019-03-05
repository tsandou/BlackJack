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

	/*
	 * (non-Javadoc) * @see java.lang.Object#toString()
	 */

	/* override de la m�thode g�n�rale String pour afficher la carte en string */
	@Override
	public String toString() {
		return face + " de " + color + "\n";
	}

	/*
	 * getters / setters
	 */

	public FaceEnum getValue() {
		return face;
	}

	public ColorEnum getCouleur() {
		return color;
	}

}
