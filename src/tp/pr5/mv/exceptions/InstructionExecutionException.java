package tp.pr5.mv.exceptions;

/**
 * 
 * @author Miguel Higuera Romero y David Israel Garcia
 *
 */
public class InstructionExecutionException extends Exception {

	private static final long serialVersionUID = 1L;

	public InstructionExecutionException() {
	}

	public InstructionExecutionException(String message) {
		super(message);
	}

	public InstructionExecutionException(Throwable cause) {
		super(cause);
	}

	public InstructionExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public InstructionExecutionException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
