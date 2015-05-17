package tp.pr5.mv;

import tp.pr5.mv.exceptions.InstructionExecutionException;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public abstract class CommandInterpreter {
	private static CPU cpu;
	
	/**
	 * CommandInterpreter constructor
	 */
	public CommandInterpreter(){
		
	}
	
	/**
	 * Executes the command and returns a boolean to inform about the success
	 * @throws CommandExecutionException TODO
	 */
	public abstract void executeCommand() throws InstructionExecutionException;
	
	/**
	 * Parses the given line and returns the command if it has the right format
	 * @param line
	 * @return the parsed command or null
	 */
	public abstract CommandInterpreter parse(String line);
	
	/**
	 * Configures the CPU of the class CommandInterpreter
	 * @param aux
	 */
	public static void configureCommandInterpreter(CPU aux){
		cpu = aux;
	}
	
	/**
	 * Gets the shared CPU from the CommandInterpreter class
	 * @return the CPU
	 */
	public static CPU getCpu() {
		return cpu;
	}
}
