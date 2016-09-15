package commands;

public interface BaseCommand {
	
	String getCommandName();
	
	/**
	 * @param args of the command
	 * 
	 * Executes command.
	 */
	boolean execute(String args);

}
