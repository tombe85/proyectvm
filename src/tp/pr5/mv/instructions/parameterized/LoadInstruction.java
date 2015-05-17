package tp.pr5.mv.instructions.parameterized;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.exceptions.InstructionExecutionException;
import tp.pr5.mv.instructions.ParameterizedInstruction;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class LoadInstruction extends ParameterizedInstruction {
	
	/**
	 * LoadInstruction constructor
	 * @param arg
	 */
	public LoadInstruction(int arg) {
		super(arg);
	}
	
	/**
	 * Constructor for testing purposes
	 */
	public LoadInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		Integer valor = mem.getValueAt(getArgument());
		if(valor != null){
			os.push(valor);
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": dirección incorrecta (" + getArgument() + ")");
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && extractInstructionString(insString).equalsIgnoreCase("load")){
			Integer argument = extractArgument(insString);
			if(argument != null)
				instruction = new LoadInstruction(argument);
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "LOAD " + getArgument().toString();
	}

}
