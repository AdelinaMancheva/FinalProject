import enums.InputTypeEnum;

public class InputProcessingFactory {

	/**
	 * @param inputType
	 * 
	 *            Decides from where to read the input commands from CLI or FILE
	 *            according to the parameter inputType.
	 * 
	 */
	public InputProcessing processInput(InputTypeEnum inputType) {
		InputProcessing inputProcessing;

		switch (inputType) {
		case CLI:
			inputProcessing = new InputFromConsole();
			break;
		case FILE:
			inputProcessing = new InputFromFile();
			break;
		default:
			inputProcessing = new InputFromConsole();
			break;
		}
		return inputProcessing;
	}

}
