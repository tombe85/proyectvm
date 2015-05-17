package tp.pr5.mv;

/**
 * 
 * @author Miguel Higuera Romero y David Israel garcía Díaz
 *
 */
public interface MVObserver {
	/**
	 * Function to update the views when the cpu has loaded the program
	 * @param program
	 */
	public void programLoaded(ProgramMV program);
	
	/**
	 * Function to update the views when one instruction starts its execution.
	 * It receive the instruction string.
	 * @param inst
	 */
	public void instructionStarts(String inst);
	
	/**
	 * Function to update the views when an instruction has been successfully executed
	 * 
	 * @param pc the current index of the program
	 * @param memo TODO
	 * @param stack TODO
	 */
	public void instructionEnds(int pc, Memory memo, OperandStack stack);
	
	/**
	 * Function to update the views when an error has occurred at an instruction execution
	 * @param error The error String
	 */
	public void executionError(String error);
	
	/**
	 * Function to update the views when the MV has been stopped or halted
	 */
	public void mVStoped();
	
	/**
	 * Function to update the views when a bad command has been introduced 
	 */
	public void badCommand();
}
