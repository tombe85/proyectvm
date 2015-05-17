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

public class BfInstruction extends ParameterizedInstruction {
	
	/**
	 * BfInstruction constructor
	 * @param arg
	 */
	public BfInstruction(int arg) {
		super(arg);
	}
	
	/**
	 * Constructor for testing purposes
	 */
	public BfInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		if(operandStackHasOneOperand(os)){
			if(getArgument() >= 0){
				int cond = os.pop();
				if(cond == 0){
					pc.setCounter(getArgument());
					pc.setBranched(true);
				}
			}else{
				throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": línea incorrecta (" + getArgument() + ")");
			}
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": faltan operandos en la pila (Hay " + os.size() + ")");	
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && extractInstructionString(insString).equalsIgnoreCase("bf")){
			Integer argument = extractArgument(insString);
			if(argument != null)
				instruction = new BfInstruction(argument);
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "BF " + getArgument().toString();
	}

}
