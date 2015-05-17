package tp.pr5.mv.instructions.nonparameterized.oneop;

import java.io.IOException;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public interface OutMethod {
	/**
	 * Writes the given integer as a character in the output
	 * @param n
	 * @throws IOException
	 */
	public void write(int n) throws IOException;
}
