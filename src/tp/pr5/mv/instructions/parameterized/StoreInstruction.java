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

public class StoreInstruction extends ParameterizedInstruction {
	
	/**
	 * StoreInstruction constructor
	 * @param arg
	 */
	public StoreInstruction(int arg) {
		super(arg);
	}
	
	/**
	 * Constructor for testing purposes
	 */
	public StoreInstruction() {
	}

	@Override
	public void execute(OperandStack os, Memory mem, ProgramCounter pc, OutMethod om, InMethod im) throws InstructionExecutionException {
		if(operandStackHasOneOperand(os)){
			if(getArgument() != null && getArgument() >= 0){
				int valor = os.pop();
				mem.add(getArgument(), valor);
			}else{
				throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": dirección incorrecta (" + getArgument() + ")");
			}
		}else{
			throw new InstructionExecutionException("Error ejecutando " + this.toString() + ": faltan operandos en la pila (Hay " + os.size() + ")");	
		}
	}

	@Override
	public Instruction parse(String insString) {
		Instruction instruction = null;
		if(checkLine(insString) && extractInstructionString(insString).equalsIgnoreCase("store")){
			int argument = extractArgument(insString);
			instruction = new StoreInstruction(argument);
		}
		return instruction;
	}

	@Override
	public String toString() {
		return "STORE " + getArgument().toString();
	}

}
