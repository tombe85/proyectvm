package tp.pr5.mv.instructions.nonparameterized.twoop;

import tp.pr5.mv.*;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.TwoOperandsInstruction;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class AddInstruction extends TwoOperandsInstruction {
	
	/**
	 * AddInstruction constructor
	 */
	public AddInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		if(checkOperandStack(os)){
			int arg1 = os.pop();
			int arg2 = os.pop();
			os.push(arg1 + arg2);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": " + super.getError().replace("$", Integer.toString(os.size())));
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("add")){
			instruction = new AddInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "ADD";
	}

}
