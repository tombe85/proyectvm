package tp.pr5.mv.instructions.nonparameterized.oneop;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public class StdOut implements OutMethod {
	
	private String out = "";
	@Override
	public void write(int n) {
		char car = (char) n;
		System.out.print(car);
		out = out + car;
	}

}
