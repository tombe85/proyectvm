package tp.pr5.mv.instructions.nonparameterized.oneop;

import java.io.IOException;

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

public class OutInstruction extends OneOperandInstruction{
	
	/**
	 * OutInstruction constructor
	 */
	public OutInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		if(checkOperandStack(os)){
			int valor = os.pop();
			try{
				om.write(valor);
			}catch(IOException e){
				throw new InstructionExecutionException(e);
			}
			
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": " + super.getError());		
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("out")){
			instruction = new OutInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "OUT";
	}

}
