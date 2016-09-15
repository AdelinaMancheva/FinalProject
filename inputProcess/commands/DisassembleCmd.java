package commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import validations.CommandValidation;
import validations.CreateInputValidation;

/**
 * @author AMancheva
 * 
 *         By given vin deletes car from file. 
 *         Expected input: disassemble <vin>
 */
public class DisassembleCmd implements BaseCommand {

	private final static String COMMAND_NAME = "disassemble";

	private File inputFile = new File("vehicles.txt");
	private File tempFile = new File("vehicles_report.txt");

	private final Lock mutex = new ReentrantLock(true);

	CreateInputValidation crateValid = new CreateInputValidation();
	CommandValidation cmdValid = new CommandValidation();

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @param vin of a car
	 * 
	 *            Rewrites all lines in a new different file, except the one
	 *            line that contains the vin. The old file is deleted and the
	 *            new one is renamed like the previous.
	 * 
	 * @throws IOException
	 */
	private void disassembleCar(String vin) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			if (null != currentLine && !currentLine.contains(vin)) {
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
		if (cmdValid.validateDisassembleByLength(splittedArgs)) {
			return false;
		}

		if (crateValid.validateVinByLength(splittedArgs[0])) {
			try {
				mutex.lock();
				disassembleCar(splittedArgs[0]);
				mutex.unlock();
				return true;

			} catch (IOException e) {
				return false;
			}
		}
		return false;
	}

}
