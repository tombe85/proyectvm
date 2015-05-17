package tp.pr5.mv.commands;

import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.instructions.parameterized.PushInstruction;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class PushCommand extends CommandInterpreter {
	
	private int argument;
	
	/**
	 * PushCommand constructor
	 * @param argument
	 */
	public PushCommand(int argument) {
		this.argument = argument;
	}
	/**
	 * PushCommand constructor without parameters
	 * For testing purposes
	 */
	public PushCommand() {
	}

	@Override
	public void executeCommand(){
		PushInstruction pushInst = new PushInstruction(this.argument);
		getCpu().executeInstruction(pushInst);
		
	}

	@Override
	public CommandInterpreter parse(String line) {
		CommandInterpreter command = null;
		line.trim();
		String [] words = line.split(" ");
		if(words.length == 2 && words[0].equalsIgnoreCase("push")){
			try{
				int arg = Integer.parseInt(words[1]);
				command = new PushCommand(arg);
			}catch(Exception e){
				//El argumento es erróneo
			}
		}
		return command;
	}
	
	/**
	 * Gets the command string
	 */
	public String toString(){
		return "push";
	}

}
