import enums.InputTypeEnum;

public class Main {

	/**
	 * For reading from console or file, change to CLI or FILE.
	 */
	private static final InputTypeEnum INPUT_TYPE = InputTypeEnum.CLI;

	public static void main(String[] args) {
		new InputProcessingFactory().processInput(INPUT_TYPE);
	}

}
