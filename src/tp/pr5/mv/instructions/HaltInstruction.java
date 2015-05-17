package tp.pr5.mv.instructions;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Main;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class HaltInstruction extends Instruction {
	
	/**
	 * HaltInstruction constructor
	 */
	public HaltInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		pc.haltCounter();
		Main.closeFileRW();
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("halt")){
			instruction = new HaltInstruction();
		}
		return instruction;
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

	@Override
	public String toString() {
		return "HALT";
	}

}
