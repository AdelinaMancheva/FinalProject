import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author AMancheva
 * 
 *         When InputFromFile object is created, program starts reading commands
 *         from different files.
 *
 */
public class InputFromFile implements InputProcessing {

	private ParseInput parseInput = new ParseInput();
	private String[] commandFiles = { "commands1.txt", "commands2.txt", "commands3.txt", "commands4.txt" };

	public InputFromFile() {
		startThreads();
	}

	public void startThreads() {
		for (String s : commandFiles) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					readFile(s);
				}

			}).start();
		}
	}

	/**
	 * Reading commands from file line by line and processing by calling
	 * function processInput for every line.
	 */
	public void readFile(String fileName) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				parseInput.processInput(line);
			}
		} catch (FileNotFoundException e) {

		} finally {
			scan.close();
		}
	}

}
