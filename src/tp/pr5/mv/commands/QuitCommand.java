package tp.pr5.mv.commands;

import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.exceptions.InstructionExecutionException;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class QuitCommand extends CommandInterpreter {
	
	/**
	 * QuitCommand constructor
	 */
	public QuitCommand() {
	}

	@Override
	public void executeCommand() throws InstructionExecutionException {
		getCpu().shutDown();
	}

	@Override
	public CommandInterpreter parse(String line) {
		CommandInterpreter command = null;
		line.trim();
		String [] words = line.split(" ");
		if(words.length == 1 && line.equalsIgnoreCase("quit")){
			command = new QuitCommand();
		}
		return command;
	}
	
	public String toString(){
		return "quit";
	}

}
