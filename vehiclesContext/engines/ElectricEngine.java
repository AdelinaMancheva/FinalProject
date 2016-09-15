package engines;

public class ElectricEngine extends Engine {

	private static final int KW_DEFAULT = 535;

	private int kw;

	public ElectricEngine() {
		super();
		this.kw = KW_DEFAULT;
	}

	public ElectricEngine(int kw) {
		super();
		this.kw = kw;
		System.out.println(kw);
	}

	@Override
	public String toString() {
		return " Engine: electric" + " Kw: " + kw;
	}
}
