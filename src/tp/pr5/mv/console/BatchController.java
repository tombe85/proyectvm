package tp.pr5.mv.console;

import tp.pr5.mv.CPU;
import tp.pr5.mv.commands.RunCommand;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class BatchController extends ConsoleController {
	
	/**
	 * BatchController constructor
	 * @param cpu
	 */
	public BatchController(CPU cpu) {
		super(cpu);
	}
	
	/**
	 * Runs the entire program
	 */
	public void runProgram() {
		RunCommand run = new RunCommand();
		this.cpu.executeCommand(run);
	}

}
