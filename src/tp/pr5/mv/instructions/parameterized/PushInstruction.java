package tp.pr5.mv.instructions.parameterized;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.ParameterizedInstruction;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class PushInstruction extends ParameterizedInstruction {
	
	/**
	 * PushInstruction constructor
	 * @param arg
	 */
	public PushInstruction(int arg) {
		super(arg);
	}
	
	/**
	 * Constructor for testing purposes
	 */
	public PushInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		os.push(getArgument());
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && extractInstructionString(insString).equalsIgnoreCase("push")){
			Integer argument = extractArgument(insString);
			if(argument != null)
				instruction = new PushInstruction(argument);
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "PUSH " + getArgument().toString();
	}

}
