package engines;

public abstract class Engine {

	private static final boolean HAS_TURBO_DEFAULT = false;
	private static final String EURO_STANDARD_DEFAULT = "euro3";

	private boolean hasTurbo;
	private String euroStandard;

	public Engine() {
		this.hasTurbo = HAS_TURBO_DEFAULT;
		this.euroStandard = EURO_STANDARD_DEFAULT;
	}

	public Engine(boolean hasTurbo, String euroStandard) {
		this.hasTurbo = hasTurbo;
		this.euroStandard = euroStandard;
	}

	@Override
	public String toString() {
		return " Turbo: " + hasTurbo + " EuroStandard: " + euroStandard;
	}

}
