package tp.pr5.mv.instructions.nonparameterized;

import java.io.IOException;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public class StdIn implements InMethod {

	@Override
	public int read() throws IOException {
		int c = System.in.read();
		return c;
	}

}
