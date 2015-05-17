package tp.pr5.mv.instructions.nonparameterized.twoop;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.TwoOperandsInstruction;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class LeInstruction extends TwoOperandsInstruction {
	
	/**
	 * LeInstruction constructor
	 */
	public LeInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		
		if(checkOperandStack(os)){
			int arg1 = os.pop();
			int arg2 = os.pop();
			if(arg2 <= arg1)
				os.push(1);
			else
				os.push(0);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": " + super.getError().replace("$", Integer.toString(os.size())));
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("le")){
			instruction = new LeInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "LE";
	}

}
