package tp.pr5.mv.instructions;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.OperandStack;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public abstract class NonParameterizedInstruction extends Instruction {
	
	/**
	 * NonParameterizedInstruction constructor
	 */
	public NonParameterizedInstruction() {
	}

	@Override
	public boolean checkLine(String line) {
		boolean good = false;
		line.trim();
		String [] words = line.split(" ");
		if(words.length == 1)
			good = true;
		return good;
	}
	
	/**
	 * Checks if the operand stack has enough operands to execute an instruction
	 * @param os
	 * @return true if the instruction can be executed, false otherwise
	 */
	public abstract boolean checkOperandStack(OperandStack os);

}
