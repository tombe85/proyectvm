package tp.pr5.mv.exceptions;

/**
 * 
 * @author Miguel Higuera Romero y David Israel Garcia
 *
 */

public class ASMFileParserException extends Exception {

	private static final long serialVersionUID = 1L;

	public ASMFileParserException() {
	}

	public ASMFileParserException(String message) {
		super(message);
	}

	public ASMFileParserException(Throwable cause) {
		super(cause);
	}

	public ASMFileParserException(String message, Throwable cause) {
		super(message, cause);
	}

	public ASMFileParserException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
