package transmissions;

public class ManualTransmission extends Transmission {

	private static final int GEARS_DEFAULT = 4;
	public static final int[] GEARS_MANUAL = { 4, 5, 6 };

	private int gears;

	public ManualTransmission() {
		this.gears = GEARS_DEFAULT;
	}

	public ManualTransmission(int gears) {
		this.gears = gears;
	}

	@Override
	public String toString() {
		return " Transmission: manual" + " Gears: " + gears;
	}
}
