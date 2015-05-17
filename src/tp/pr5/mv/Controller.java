package tp.pr5.mv;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public abstract class Controller {
	protected CPU cpu;
	
	/**
	 * Controller constructor
	 * @param cpu
	 */
	public Controller(CPU cpu){
		this.cpu = cpu;
	}
	
}
