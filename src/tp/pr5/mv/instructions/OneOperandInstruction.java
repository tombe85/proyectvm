package tp.pr5.mv.instructions;

import tp.pr5.mv.OperandStack;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public abstract class OneOperandInstruction extends NonParameterizedInstruction {
	
	/**
	 * OneOperandInstruction constructor
	 */
	public OneOperandInstruction() {
	}

	@Override
	public boolean checkOperandStack(OperandStack os) {
		return os.size() >= 1;
	}

	public String getError() {
		return "faltan operandos en la pila (Hay 0)";
	}
	
}
