import commands.CommandInterpreter;
import exceptions.InvalidCommandException;

public class ParseInput {

	private CommandInterpreter interpreter = new CommandInterpreter();

	public ParseInput() {
	}

	/**
	 * @param line
	 *            If the command from the input exists, it calls execute on this
	 *            command.
	 */
	public void processInput(String line) {

		String[] splittedLine = line.split(" ");
		if (interpreter.hasCommand(splittedLine[0])) {
			interpreter.executeCmd(splittedLine);
		} else {
			try {
				throw new InvalidCommandException("Invalid command.");
			} catch (InvalidCommandException ex) {
			}
		}
	}

}
