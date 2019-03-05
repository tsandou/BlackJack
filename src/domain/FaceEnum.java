package domain;

public enum FaceEnum {

	deux(2, "2"), trois(3, "3"), quatre(4, "4"), cinq(5, "5"), six(6, "6"), sept(7, "7"), huit(8, "8"), neuf(9, "9"),
	dix(10, "10"), Valet(10, "Valet"), Dame(10, "Dame"), Roi(10, "Roi"), As(11, "As");

	/*
	 * constructeur
	 */

	private FaceEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	// il faut mettre les attributs après l'énumération
	private int value;
	private String name;

	/*
	 * getters / setters
	 */

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
