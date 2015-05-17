package tp.pr5.mv.instructions.nonparameterized;

import java.io.IOException;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public class NullIn implements InMethod {

	@Override
	public int read() throws IOException {
		return -1;
	}

}
