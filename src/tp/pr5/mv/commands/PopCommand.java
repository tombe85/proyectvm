package tp.pr5.mv.commands;

import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.instructions.nonparameterized.oneop.PopInstruction;



/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class PopCommand extends CommandInterpreter {
	
	/**
	 * PopCommand constructor
	 */
	public PopCommand() {
	}

	@Override
	public void executeCommand(){
		PopInstruction popInst = new PopInstruction();
		getCpu().executeInstruction(popInst);
		
	}

	@Override
	public CommandInterpreter parse(String line) {
		CommandInterpreter command = null;
		line.trim();
		String [] words = line.split(" ");
		if(words.length == 1 && line.equalsIgnoreCase("pop")){
			command = new PopCommand();
		}
		return command;
	}
	
	public String toString(){
		return "pop";
	}

}
