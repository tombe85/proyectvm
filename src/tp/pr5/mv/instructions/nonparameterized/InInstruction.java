package tp.pr5.mv.instructions.nonparameterized;

import java.io.IOException;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.NonParameterizedInstruction;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class InInstruction extends NonParameterizedInstruction {
	
	/**
	 * InInstruction constructor
	 */
	public InInstruction(){
		
	}
	
	
	public void execute(OperandStack os, Memory mem, ProgramCounter pc,
			OutMethod om, InMethod im) throws InstructionExecutionException {
		try{
			int value = im.read();
			os.push(value);
		}catch(IOException e){
			throw new InstructionExecutionException(e);
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("in")){
			instruction = new InInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "IN";
	}

	@Override
	public boolean checkOperandStack(OperandStack os) {
		return true;
	}

}
