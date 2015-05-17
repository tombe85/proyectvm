package tp.pr5.mv;

import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public abstract class Instruction {
	
	/**
	 * Constructor without parameters of Instruction
	 */
	public Instruction(){
	}
	
	/**
	 * Executes the instruction
	 * @param os
	 * @param mem
	 * @param pc
	 * @param om TODO
	 * @param im TODO
	 * @throws InstructionExecutionException TODO
	 */
	public abstract void execute(OperandStack os, Memory mem, ProgramCounter pc, 
			OutMethod om, InMethod im) throws InstructionExecutionException;
	
	/**
	 * Parses the instruction and returns a new Instruction object 
	 * @param insString
	 * @return the new Instruction object
	 */
	public abstract Instruction parse(String insString);
	
	/**
	 * Checks the number of words given in the instruction
	 * @param line
	 * @return true if the number of arguments is correct, false otherwise
	 */
	public abstract boolean checkLine(String line);
	
	/**
	 * Generates a String with information about the instruction to execute
	 */
	public abstract String toString();
	
	
}
