package tp.pr5.mv.instructions;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.OperandStack;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public abstract class ParameterizedInstruction extends Instruction {
	
	private Integer argument;
	
	/**
	 * ParameterizedInstruction constructor
	 * @param arg
	 */
	public ParameterizedInstruction(int arg) {
		this.argument = arg;
	}
	
	/**
	 * ParameterizedInstruction constructor for testing purposes
	 */
	public ParameterizedInstruction() {
	}
	

	@Override
	public boolean checkLine(String line) {
		boolean good = false;
		line.trim();
		String [] words = line.split(" ");
		if(words.length == 2)
			good = true;
		return good;
	}


	/**
	 * Gets the argument of the instruction
	 * @return the argument
	 */
	public Integer getArgument() {
		return argument;
	}
	
	/**
	 * Extracts the argument from the given line. The line should have been checked
	 * @param inString
	 * @return the argument from the checked line
	 */
	public Integer extractArgument(String inString){
		Integer arg;
		String [] words = inString.trim().split(" ");
		try{
			arg = Integer.parseInt(words[1]);
		}catch(NumberFormatException e){
			arg = null;
		}
		return arg;
	}
	
	/**
	 * Extracts the instruction String from the given line. The line should have been checked
	 * @param inString
	 * @return a String with the instruction
	 */
	public String extractInstructionString(String inString){
		String [] words = inString.trim().split(" ");
		return words[0];
	}
	
	/**
	 * Checks if the operand stack has one operand or more
	 * @param os
	 * @return true if there is one operand or more, false otherwise
	 */
	public boolean operandStackHasOneOperand(OperandStack os){
		return os.size() >= 1;
	}

}
