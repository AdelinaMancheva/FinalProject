import java.util.Scanner;

/**
 * @author AMancheva
 * 
 *         When InputFromConsole object is created, a new Scanner is also
 *         created and user can start writing commands in command line.
 *
 */
public class InputFromConsole implements InputProcessing {

	private Scanner scan;

	public InputFromConsole() {
		scan = new Scanner(System.in);
		process();
	}

	/**
	 * Getting input from console and processing input line by line by calling
	 * the function processInput(line)
	 */
	public void process() {
		try {
			while (true) {
				String line = scan.nextLine();
				new ParseInput().processInput(line);
			}
		} finally {
			scan.close();
		}
	}

}
