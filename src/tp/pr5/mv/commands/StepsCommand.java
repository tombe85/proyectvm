package tp.pr5.mv.commands;

import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.exceptions.InstructionExecutionException;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class StepsCommand extends StepCommand {
	private int numSteps;
	
	/**
	 * StepsCommand constructor. Receives the number of steps
	 * @param numSteps
	 */
	public StepsCommand(int numSteps) {
		this.numSteps = numSteps;
	}
	
	public StepsCommand(){
		
	}

	public void executeCommand() throws InstructionExecutionException {
		int i = 0;
		try{
			while(i<this.numSteps && !getCpu().isHalt() && !getCpu().programFinalized()){
				super.executeCommand();
				i++;
			}
		}catch(InstructionExecutionException ce){
			throw ce;
		}
	}

	public CommandInterpreter parse(String line) {
		CommandInterpreter command = null;
		line.trim();
		String [] words = line.split(" ");
		if(super.parse(words[0]) != null && words.length == 2){
			try{
				int arg = Integer.parseInt(words[1]);
				command = new StepsCommand(arg);
			}catch(NumberFormatException e){
				
			}
		}
		return command;
	}
	
	public String toString(){
		return "steps";
	}
}
