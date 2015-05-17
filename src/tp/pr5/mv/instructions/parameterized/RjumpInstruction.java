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

public class RjumpInstruction extends ParameterizedInstruction {

	/**
	 * RjumpInstruction constructor
	 * @param arg
	 */
	public RjumpInstruction(int arg) {
		super(arg);
	}
	/**
	 * Constructor for testing purposes
	 */
	public RjumpInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		if((getArgument() >= 0) || 
				(getArgument() < 0 && getArgument() + pc.getCounter() >= 0)){
			
			pc.setCounter(pc.getCounter() + getArgument());
			pc.setBranched(true);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": línea incorrecta (" + getArgument() + ")");
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && extractInstructionString(insString).equalsIgnoreCase("rjump")){
			Integer argument = extractArgument(insString);
			if(argument != null)
				instruction = new RjumpInstruction(argument);
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "RJUMP " + getArgument().toString();
	}

}
