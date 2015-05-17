package tp.pr5.mv;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Miguel Higuera Romero y David Israel garcía Díaz
 *
 * @param <T>
 */
public class Observable<T> {
	protected List<T> observers;
    
	/**
	 * Constructor
	 */
	public Observable()
    {
    	this.observers = new LinkedList<T>();
    }
    
	/**
	 * Adds an observer to the list
	 * @param observer
	 */
    public void addObserver(T observer) {
    	if (!observers.contains(observer))
    		observers.add(observer);
    }
    
    /**
     * Removes an observer from the list
     * @param observer
     */
    public void removeObserver(T observer) {
    	if(observers.contains(observer))
        	observers.remove(observer);
    }
}
