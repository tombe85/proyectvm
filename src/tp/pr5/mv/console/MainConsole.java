package tp.pr5.mv.console;

import tp.pr5.mv.Controller;
import tp.pr5.mv.MVObserver;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramMV;

/**
 * 
 * @author Miguel Higuera Romero y David
 *
 */
public class MainConsole implements MVObserver{
	
	private ConsoleController control;
	private boolean canOperate;
	
	/**
	 * MainConsole constructor
	 * @param control
	 */
	public MainConsole(Controller control){
		this.control = (ConsoleController) control;
		this.canOperate = true;
	}
	
	@Override
	public void programLoaded(ProgramMV program) {
		System.out.println("El programa introducido es:");
		System.out.print(program.toString());
		System.out.flush();
	}

	@Override
	public void instructionStarts(String inst) {
		System.out.println("Comienza la ejecución de " + inst);
	}

	@Override
	public void instructionEnds(int pc, Memory memo, OperandStack stack) {
		System.out.println("El estado de la maquina tras ejecutar la instrucción es:");
		System.out.println("Memoria: " + memo.toString());
		System.out.println("Pila de operandos: " + stack.toString());
	}

	@Override
	public void executionError(String error) {
		System.err.println(error);
	}

	@Override
	public void mVStoped() {
		this.canOperate = false;
	}

	@Override
	public void badCommand() {
		System.out.println("No te entiendo.");
		System.out.print(">");
		System.out.flush();
	}
	
	/**
	 * Method to start the interactive mode MV
	 */
	public void interactiveStart(){
		InteractiveController interControl = (InteractiveController) this.control;
		System.out.print(">");
		System.out.flush();
		while(canOperate && interControl.canContinue()){
			interControl.nextCommand();
			if(canOperate){
				System.out.print(">");
				System.out.flush();
			}
				
		}
		interControl.closeInput();
	}
	
	/**
	 * Method to start the batch mode MV
	 */
	public void batchStart(){
		BatchController batch = (BatchController) this.control;
		batch.runProgram();
	}
}
