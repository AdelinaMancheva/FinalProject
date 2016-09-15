package models;

public class Model {

	public static final String TYPE_DEFAULT = "sedan";

	private String model;
	private String type;

	public Model(String model) {

		this.model = model;
		this.type = TYPE_DEFAULT;
	}

	public Model(String model, String type) {
		this.model = model;
		this.type = type;
	}

	@Override
	public String toString() {
		return " Model: " + model + " Type: " + type;
	}

}
