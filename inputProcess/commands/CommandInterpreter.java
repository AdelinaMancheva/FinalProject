package commands;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandInterpreter {

	public CommandInterpreter() {
	}

	private final Collection<BaseCommand> COMMANDS = Arrays
			.asList(new BaseCommand[] { 
					new CreateCmd(), 
					new PrintCmd(), 
					new DisassembleCmd(), 
					new UpdateCmd() 
					});

	@SuppressWarnings("serial")
	private Map<String, BaseCommand> COMMANDS_MAP = new HashMap<String, BaseCommand>() {
		{
			for (BaseCommand command : COMMANDS) {
				put(command.getCommandName(), command);
			}
		}
	};;

	public void executeCmd(String[] line) {
		BaseCommand command = COMMANDS_MAP.get(line[0]);
		String commandArgs = getCmdArgs(line);
		command.execute(commandArgs);
	}

	public String getCmdArgs(String[] line) {
		StringBuilder builder = new StringBuilder();

		for (int i = 1; i < line.length; i++) {
			builder.append(line[i] + " ");
		}
		return builder.toString();
	}

	public boolean hasCommand(String cmd) {
		return COMMANDS_MAP.containsKey(cmd);
	}

}
