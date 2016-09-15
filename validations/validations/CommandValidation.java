package validations;

/**
 * @author AMancheva
 * 
 *         Contains validations by length for commands
 *
 */
public class CommandValidation {

	private static final int CREATE_ARGS_LENGTH = 4;
	private static final int PRINT_ARGS_LENGTH = 1;
	private static final int DISASSEMBLE_ARGS_LENGTH = 1;
	private static final int UPDATE_ARGS_LENGTH = 1;

	public CommandValidation() {
	}

	public boolean validateCreateByLength(String[] args) {
		if (args.length < CREATE_ARGS_LENGTH) {
			System.out.println("Invalid command. Not enough arguments. ");
			return false;
		}
		return true;
	}

	public boolean validatePrintByLength(String[] args) {
		if (args.length < PRINT_ARGS_LENGTH) {
			System.out.println("Invalid command. Not enough arguments. ");
			return false;
		}
		return true;
	}

	public boolean validateDisassembleByLength(String[] line) {
		if (line.length < DISASSEMBLE_ARGS_LENGTH) {
			System.out.println("Invalid command. Not enough arguments. ");
			return false;
		}
		return true;
	}

	public boolean validateUpdateByLength(String[] line) {
		if (line.length < UPDATE_ARGS_LENGTH) {
			System.out.println("Invalid command. Not enough arguments. ");
			return false;
		}
		return true;
	}

}
