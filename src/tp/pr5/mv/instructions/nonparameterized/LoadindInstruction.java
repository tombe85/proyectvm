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
public class LoadindInstruction extends NonParameterizedInstruction {
	
	/**
	 * LoadindInstruction
	 */
	public LoadindInstruction() {
	}

	@Override
	public boolean checkOperandStack(OperandStack os) {
		return true;
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc,
			OutMethod om, InMethod im)
			throws InstructionExecutionException {
		int pos = os.pop();
		Integer valor = mem.getValueAt(pos);
		if(valor != null){
			os.push(valor);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": dirección incorrecta (" + pos + ")");
		}

	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("loadind")){
			instruction = new LoadindInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "LOADIND";
	}

}
