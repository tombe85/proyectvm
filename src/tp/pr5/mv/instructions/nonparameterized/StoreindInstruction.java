package tp.pr5.mv.instructions.nonparameterized;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.NonParameterizedInstruction;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public class StoreindInstruction extends NonParameterizedInstruction {
	
	/**
	 * StoreindInstruction constructor
	 */
	public StoreindInstruction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkOperandStack(OperandStack os) {
		return true;
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc,
			OutMethod om, InMethod im)
			throws InstructionExecutionException {
		int valor = os.pop();
		int pos = os.pop();
		if(pos < 0){
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": posición de memoria incorrecta (" + pos + ")");
		}
		mem.add(pos, valor);
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("storeind")){
			instruction = new StoreindInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "STOREIND";
	}

}
