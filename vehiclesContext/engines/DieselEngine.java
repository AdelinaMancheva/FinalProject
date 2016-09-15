package engines;

public class DieselEngine extends Engine {

	public static final int KW_LOWER_LIMIT = 136;
	public static final int KW_UPPER_LIMIT = 510;

	private int kw;

	public DieselEngine() {
		super();
		this.kw = KW_LOWER_LIMIT;
	}

	public DieselEngine(int kw, boolean hasTurbo, String euroStandard) {
		super(hasTurbo, euroStandard);
		this.kw = kw;
	}

	@Override
	public String toString() {
		return " Engine: diesel" + " Kw: " + kw + super.toString();
	}

}
