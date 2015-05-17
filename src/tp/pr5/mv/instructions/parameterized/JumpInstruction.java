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

public class JumpInstruction extends ParameterizedInstruction {
	
	/**
	 * JumpInstruction constructor
	 * @param arg
	 */
	public JumpInstruction(int arg) {
		super(arg);
	}
	
	/**
	 * Constructor for testing purposes
	 */
	public JumpInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		if(getArgument() >= 0){
			pc.setCounter(getArgument());
			pc.setBranched(true);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": línea incorrecta (" + getArgument() + ")");
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && extractInstructionString(insString).equalsIgnoreCase("jump")){
			Integer argument = extractArgument(insString);
			if(argument != null)
				instruction = new JumpInstruction(argument);
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "JUMP " + getArgument().toString();
	}

}
