package tp.pr5.mv.instructions;

import tp.pr5.mv.OperandStack;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public abstract class TwoOperandsInstruction extends NonParameterizedInstruction {
	
	/**
	 * TwoOperandsInstruction constructor
	 */
	public TwoOperandsInstruction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkOperandStack(OperandStack os) {
		return os.size() >= 2;
	}

	public String getError() {
		return "faltan operandos en la pila (Hay $)";
	}

}
