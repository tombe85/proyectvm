package tp.pr5.mv;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public interface MemoryObserver {
	
	/**
	 * Function to update the views when some value has been stored in memory
	 * @param index
	 * @param val
	 */
	public void StoreEvent(int index, int val);
	
	/**
	 * Function to update the views when a value has been loaded
	 */
	public void LoadEvent();
	
	
}
