package commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import validations.CreateInputValidation;

/**
 * @author AMancheva
 * 
 *         By given vin updates euro emission. 
 *         Expected input: update <vin>
 */
public class UpdateCmd implements BaseCommand {

	private static final String COMMAND_NAME = "update";

	private File inputFile = new File("vehicles.txt");
	private File tempFile = new File("vehicles_report.txt");

	private final Lock mutex = new ReentrantLock(true);

	CreateInputValidation createValid = new CreateInputValidation();

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	private void update(String vin) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			if (null != currentLine && currentLine.contains(vin)) {
				writer.write(currentLine.replace("euro5", "euro6") + System.getProperty("line.separator"));
			} else {
				writer.write(currentLine + System.getProperty("line.separator"));
			}
		}
		writer.close();
		reader.close();

		inputFile.delete();
		if (!tempFile.renameTo(inputFile)) {
			throw new IOException("Could not rename file.");
		}
	}

	@Override
	public boolean execute(String args) {
		String[] splittedArgs = args.split(" ");

		String vin = splittedArgs[0];

		if (createValid.validateVinByLength(vin)) {
			try {
				mutex.lock();
				update(splittedArgs[0]);
				mutex.unlock();
				return true;

			} catch (IOException e) {
				return false;
			}
		}
		return false;
	}

}
