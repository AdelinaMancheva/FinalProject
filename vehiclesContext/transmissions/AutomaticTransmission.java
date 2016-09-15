package transmissions;

public class AutomaticTransmission extends Transmission {

	private static final int GEARS_DEFAULT = 4;
	public static final int[] GEARS_AUTOMATIC = { 4, 5, 6, 8 };

	private int gears;

	public AutomaticTransmission() {
		this.gears = GEARS_DEFAULT;
	}

	public AutomaticTransmission(int gears) {
		this.gears = gears;
	}

	@Override
	public String toString() {
		return " Transmission: automatic" + " Gears: " + gears;
	}

}
