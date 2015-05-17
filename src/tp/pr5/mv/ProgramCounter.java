package tp.pr5.mv;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class ProgramCounter {
	
	private int counter;
	private int limit;
	private boolean branched;
	private final int HALT_INDEX = -5;
	
	/**
	 * ProgramCounter constructor
	 */
	public ProgramCounter() {
		this.counter = -1;
		this.branched = false;
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int countera) {
		if (countera>=0)
			this.counter = countera;
	}
	
	/**
	 * Initializes the counter and sets the limit
	 * @param limit
	 */
	public void startCounter(int limit){
		this.counter = 0;
		this.limit = limit;
	}
	
	/**
	 * Changes the counter index to a halted index
	 */
	public void haltCounter(){
		this.counter = HALT_INDEX;
	}
	
	/**
	 * Increases the counter one position.
	 * if the counter has finished, it's set to an end index.
	 * 
	 */
	public void increaseCounter(){
		this.counter++;
	}
	
	/**
	 * Returns true if the machine is halted or false if it is not
	 * @return true if the machine is halted or false if it is not
	 */
	public boolean isHalted() {
		return (this.counter == HALT_INDEX);
	}
	
	/**
	 * Returns true if the counter has been ended
	 * @return true if the counter has been ended, false if not
	 */
	public boolean hasEnded(){
		return (this.counter >= this.limit);
	}

	/**
	 * Gets the limit of the program counter
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}
	
	/**
	 * Returns a boolean to inform if the program counter has been branched 
	 * @return true if the counter has been branched, false otherwise
	 */
	public boolean isBranched() {
		return branched;
	}
	
	/**
	 * Sets the branched attribute 
	 * @param branched
	 */
	public void setBranched(boolean branched) {
		this.branched = branched;
	}

}
