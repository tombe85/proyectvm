package tp.pr5.mv.commands;

import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.exceptions.InstructionExecutionException;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class StepCommand extends CommandInterpreter {
	
	/**
	 * StepCommand constructor
	 */
	public StepCommand() {
	}

	@Override
	public CommandInterpreter parse(String line) {
		CommandInterpreter command = null;
		line.trim();
		String [] words = line.split(" ");
		if(words.length == 1 && line.equalsIgnoreCase("step")){
			command = new StepCommand();
		}
		return command;
	}



	@Override
	public void executeCommand() throws InstructionExecutionException {
		if(!getCpu().isHalt() && !getCpu().programFinalized()){
			getCpu().step();
		}else{
			throw new InstructionExecutionException("Todas las instrucciones han sido ejecutadas.");
		}
	}
	
	public String toString(){
		return "step";
	}

}
