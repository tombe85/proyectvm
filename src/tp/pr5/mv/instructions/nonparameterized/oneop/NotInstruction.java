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

public class NotInstruction extends OneOperandInstruction {
	
	/**
	 * NotInstruction constructor
	 */
	public NotInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException{
		
		if(checkOperandStack(os)){
			int arg = os.pop();
			if(arg != 0)
				arg = 0;
			else
				arg = 1;
			os.push(arg);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": " + super.getError());		
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		insString.trim();
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("not")){
			instruction = new NotInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "NOT";
	}

}
