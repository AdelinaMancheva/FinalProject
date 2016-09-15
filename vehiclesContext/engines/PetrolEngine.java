package engines;

public class PetrolEngine extends Engine {

	private static final int KW_DEFAULT = 55;

	private int kw;

	public PetrolEngine() {
		super();
		this.kw = KW_DEFAULT;
	}

	public PetrolEngine(int kw, boolean hasTurbo, String euroStandard) {
		super(hasTurbo, euroStandard);
		this.kw = kw;
	}

	@Override
	public String toString() {
		return " Engine: petrol" + " Kw: " + kw + super.toString();
	}

}
