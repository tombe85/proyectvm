package tp.pr5.mv.commands;

import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.exceptions.InstructionExecutionException;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class RunCommand extends StepCommand {
	
	/**
	 * RunCommand constructor
	 */
	public RunCommand() {
	}
	
	public void executeCommand(){
		try{
			while(!getCpu().isHalt() && !getCpu().programFinalized()){
				super.executeCommand();
				//Thread.sleep(500);
			}
		}catch(InstructionExecutionException ce){
			
		}/*catch (InterruptedException e) {
		}*/
	}
	
	public CommandInterpreter parse(String line) {
		CommandInterpreter command = null;
		line.trim();
		String [] words = line.split(" ");
		if(words[0].equalsIgnoreCase("run") && words.length == 1){
			command = new RunCommand();
		}
		return command;
	}
	
	public String toString(){
		return "run";
	}
}
