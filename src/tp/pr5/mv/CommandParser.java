package tp.pr5.mv;

import tp.pr5.mv.commands.*;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class CommandParser {
	
	private CommandInterpreter[] possible = {new StepCommand(), new RunCommand(), new QuitCommand(), 
			new PopCommand(),new StepsCommand(), new PushCommand(),new WriteCommand()};
	/**
	 * CommandParser constructor
	 */
	public CommandParser() {
		
	}
	
	/**
	 * Receives a String line and parses it to return the right command
	 * @param line
	 * @return the parsed command
	 */
	public CommandInterpreter parseCommand(String line){
		CommandInterpreter command = null;
		
		int i = 0;
		while(i<possible.length && command == null){
			command = possible[i].parse(line);
			i++;
		}
		return command;
	}

}
