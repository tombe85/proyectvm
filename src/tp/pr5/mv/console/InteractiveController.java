package tp.pr5.mv.console;

import java.util.Scanner;

import tp.pr5.mv.CPU;
import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.CommandParser;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public class InteractiveController extends ConsoleController {
	
	private Scanner input;
	private CommandParser commandParser;
	private CommandInterpreter command;
	
	/**
	 * InteractiveController constructor
	 * @param cpu
	 */
	public InteractiveController(CPU cpu) {
		super(cpu);
		input = new java.util.Scanner(System.in);
		commandParser = new CommandParser();
		command = null;
	}
	
	/**
	 * Checks if it is possible to continue getting input strings
	 * @return
	 */
	public boolean canContinue() {
		return input.hasNext();
	}
	
	/**
	 * Closes the system input reader
	 */
	public void closeInput() {
		input.close();
	}
	
	/**
	 * Gets the next command from the system input and tries to execute it
	 */
	public void nextCommand() {
		command = commandParser.parseCommand(input.nextLine());
		this.cpu.executeCommand(command);
	}
	
	
}
