package tp.pr5.mv;

import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.SwingInMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.SwingOutMethod;
import tp.pr5.mv.window.OutputPanel;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class CPU extends Observable<MVObserver> {
	
	private Memory memory;
	private OperandStack stack;
	private ProgramCounter progCount;
	private ProgramMV progMV;
	private OutMethod om;
	private InMethod im;
	
	
	/**
	 * CPU constructor
	 * @param om
	 * @param im
	 */
	public CPU(OutMethod om, InMethod im){
		this.memory = new Memory();
		this.stack = new OperandStack();
		this.progCount = new ProgramCounter();
		this.progMV = null;
		this.om = om;
		this.im = im;
	}
	
	/**
	 * Generates a String with the memory info
	 * @return a String with the memory info
	 */
	public String memoryToString(){
		return "Memoria: " + this.memory.toString();
	}
	
	/**
	 * Generates a String with the operand stack info
	 * @return a String with the operand stack info
	 */
	public String stackToString(){
		return "Pila de operandos: " + this.stack.toString();
	}
	
	/**
	 * Loads the given program into the CPU and starts the program counter
	 * @param prog
	 */
	public void loadProgram(ProgramMV prog){
		this.progMV = prog;
		this.progCount.startCounter(prog.size());
		notifyProgramLoaded(prog);
	}
	
	/**
	 * Notifies to all the observers that the program has been loaded
	 * @param program
	 */
	private void notifyProgramLoaded(ProgramMV program) {
		for(MVObserver obs : observers)
			obs.programLoaded(program);
	}

	/**
	 * Executes the next instruction of the program. Updates the Strings which contains the collection
	 * of input and output characters. Updates the program counter state.
	 * @throws InstructionExecutionException 
	 */
	public void step() throws InstructionExecutionException{
		try{
			Instruction inst = this.progMV.getInstruction(this.progCount.getCounter());
			notifyInstructionStarted(inst.toString());
			if(inst != null){
				
				inst.execute(this.stack, this.memory, this.progCount, this.om, this.im);
				
				if(!this.progCount.isBranched() && !isHalt()){
					this.progCount.increaseCounter();
				}
				if(this.progCount.isBranched()){
					this.progCount.setBranched(false);
				}
				notifyInstructionExecuted();
				checkHalt();
			}
		}catch (InstructionExecutionException ie){
			notifyExecutionError(ie);
			throw ie;
		}
	}
	
	/**
	 * Checks if the MV has been halted and notifies to the observers if true
	 */
	private void checkHalt() {
		if(this.isHalt() || this.programFinalized())
			notifyMVStopped();
	}
	
	/**
	 * Notifies to the observers that an error has occurred
	 * @param e
	 */
	private void notifyExecutionError(Exception e) {
		for(MVObserver obs : observers){
			obs.executionError(e.getLocalizedMessage());
		}
	}

	/**
	 * Returns if the machine is halted or not
	 * @return true if the machine is halted, false if not
	 */
	public boolean isHalt() {
		return this.progCount.isHalted();
	}
	
	/**
	 * Returns a boolean informing about if the machine has executed all its instructions
	 * @return true if all the instructions have been executed, false if not
	 */
	public boolean programFinalized(){
		return this.progCount.hasEnded();
	}
	
	/**
	 * Gets the size of the program
	 * @return The size of the program
	 */
	public int getPorgramSize(){
		return this.progCount.getLimit();
	}
	
	/**
	 * Halts the machine
	 */
	public void shutDown(){
		this.progCount.haltCounter();
		notifyMVStopped();
		Main.closeFileRW();
	}
	
	/**
	 * Notifies to the observers that the MV has been stopped
	 */
	private void notifyMVStopped() {
		for(MVObserver obs : observers)
			obs.mVStoped();
	}
	
	/**
	 * Executes the given instruction
	 * @param inst
	 */
	public void executeInstruction(Instruction inst){
		try{
			notifyInstructionStarted(inst.toString());
			inst.execute(stack, memory, progCount, om, im);
			notifyInstructionExecuted();
		}catch(InstructionExecutionException ie){
			notifyExecutionError(ie);
		}
	}
	
	/**
	 * Notifies to the observers that an instruction has been executed successfully
	 */
	private void notifyInstructionExecuted() {
		for(MVObserver obs : observers){
			obs.instructionEnds(this.progCount.getCounter(), this.memory, this.stack);
		}
	}
	
	/**
	 * Notifies to the observers that an instruction has started its execution
	 * @param inst
	 */
	private void notifyInstructionStarted(String inst) {
		for (MVObserver obs : observers) {
            obs.instructionStarts(inst);
		}
	}
	
	/**
	 * Gets the string with the program instructions to show them in console mode.
	 * @return
	 */
	public String getProgramResume(){
		return this.progMV.toString();
	}
	
	/**
	 * Adds an observer to the stack observers
	 * @param so
	 */
	public void addStackObserver(StackObserver so){
		this.stack.addObserver(so);
	}
	
	/**
	 * Adds an observer to the memory observers
	 * @param mo
	 */
	public void addMemoryObserver(MemoryObserver mo){
		this.memory.addObserver(mo);
	}
	
	/**
	 * Executes the given command.
	 * It notifies the observers if any error occurs
	 * @param cmd
	 */
	public void executeCommand(CommandInterpreter cmd) {
		try {
			if(cmd == null)
				notifyBadCommand();
			else
				cmd.executeCommand();
		} catch (InstructionExecutionException e) {
			notifyExecutionError(e);
		}
	}
	
	private void notifyBadCommand() {
		for(MVObserver obs : observers){
			obs.badCommand();
		}
	}

	/**
	 * Configures the SwingInMethod with the input panel
	 * @param inPan
	 */
	public void configureSwingInMethod(OutputPanel inPan) {
		SwingInMethod sim = (SwingInMethod) this.im;
		sim.configureInputPanel(inPan);
	}
	
	/**
	 * Configures the SwingOutPanel with the output panel
	 * @param outPan
	 */
	public void configureSwingOutMethod(OutputPanel outPan) {
		SwingOutMethod som = (SwingOutMethod) this.om;
		som.configureOutputPanel(outPan);
	}
}
