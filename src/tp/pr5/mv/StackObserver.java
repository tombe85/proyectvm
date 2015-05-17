package tp.pr5.mv;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public interface StackObserver {
	
	/**
	 * Function to update the views when a value has been pushed into the stack
	 * @param element the pushed value
	 */
	public void PushEvent(Integer element);
	
	/**
	 * Function to update the views when the last value has been popped from the stack
	 */
	public void PopEvent();
	
	/**
	 * Function to update the views when the last value has been read from the stack
	 * Not used
	 */
	public void PeekEvent();
	
}
