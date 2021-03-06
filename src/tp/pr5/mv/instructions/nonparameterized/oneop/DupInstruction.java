package tp.pr5.mv.instructions.nonparameterized.oneop;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.OneOperandInstruction;
import tp.pr5.mv.instructions.nonparameterized.InMethod;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class DupInstruction extends OneOperandInstruction {
	
	/**
	 * DupInstruction constructor
	 */
	public DupInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException{
		if(checkOperandStack(os)){
			int value = os.peek();
			os.push(value);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": " + super.getError());		
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("dup")){
			instruction = new DupInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "DUP";
	}

}
