package commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import validations.CommandValidation;

/**
 * @author AMancheva
 * 
 *         Print info about vehicles. 
 *         Expected input: print all || print vin <vin>
 */
public class PrintCmd implements BaseCommand {

	private static final String COMMAND_NAME = "print";

	CommandValidation cmdValid = new CommandValidation();

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * Prints all lines from file
	 */
	public void printAll() {

		Scanner scan = null;

		try {
			scan = new Scanner(new File("vehicles.txt"));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {

		} finally {
			scan.close();
		}
	}

	/**
	 * @param vin of a car
	 * @return line that contains the vin and prints the line on the console
	 */
	public void printVin(String vin) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("vehicles.txt"));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line.contains(vin)) {
					System.out.println(line);
				}
			}
		} catch (FileNotFoundException e) {

		} finally {
			scan.close();
		}
	}

	@Override
	public boolean execute(String args) {
		String[] splittedArgs = args.split(" ");
		if (!cmdValid.validatePrintByLength(splittedArgs)) {
			return false;
		}

		if (splittedArgs[0].equals("all")) {
			printAll();
		} else if (splittedArgs[0].equals("vin")) {
			printVin(splittedArgs[1]);
		} else {
			return false;
		}
		return true;
	}

}
