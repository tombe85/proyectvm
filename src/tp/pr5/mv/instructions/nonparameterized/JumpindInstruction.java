package tp.pr5.mv.instructions.nonparameterized;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.NonParameterizedInstruction;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public class JumpindInstruction extends NonParameterizedInstruction {
	
	/**
	 * JumpindInstruction constructor
	 */
	public JumpindInstruction() {
	}

	public void execute(OperandStack os, Memory mem, ProgramCounter pc,
			OutMethod om, InMethod im)
			throws InstructionExecutionException {
		int line = os.pop();
		if(line >= 0){
			pc.setCounter(line);
			pc.setBranched(true);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": línea incorrecta (" + line + ")");
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && insString.trim().equalsIgnoreCase("jumpind")){
			instruction = new JumpindInstruction();
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "JUMPIND";
	}

	@Override
	public boolean checkOperandStack(OperandStack os) {
		return true;
	}

}
