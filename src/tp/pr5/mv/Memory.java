package tp.pr5.mv;

import java.util.Vector;

/**
 * 
 * @author Miguel Higuera Romero y David Israel Garc
 * This class implements the memory of the TPMV.
 * It creates the memory and controls its functionality
 *
 */
public class Memory extends Observable<MemoryObserver>{
	
	private Vector<Integer> memory;
	private int stored;
	
	/**
	 * Constructor of the class Memory. Initializes the memory
	 */
	public Memory() {
		this.memory = new Vector<>();
		this.stored = 0;
	}
	
	
	/**
	 * It stores the given value in the given position of the memory
	 * @param pos
	 * @param value
	 */
	public void add(int pos, int value) {
		if(pos >= this.memory.size() - 1){
			this.memory.setSize(pos + 1);
			this.memory.add(pos, value);
			this.stored++;
		}else{
			if(this.memory.get(pos) == null)
				this.stored++;
			this.memory.set(pos,value);
		}
		notifyStoreEvent(pos, value);
	}
	
	/**
	 * Notifies to the observers that a value has been stored at one position
	 * @param pos
	 * @param value
	 */
	private void notifyStoreEvent(int pos, int value) {
		for(MemoryObserver obs : observers)
			obs.StoreEvent(pos, value);
	}


	/**
	 * Gets the value stored in the given position of the memory
	 * @param pos
	 * @return The stored value at the given position
	 */
	public Integer getValueAt(int pos){
		notifyLoadEvent();
		if(pos >= 0 && pos < this.size())
			return this.memory.get(pos);
		else
			return null;
	}
	
	/**
	 * Notifies to the observers that a value has been loaded
	 */
	private void notifyLoadEvent() {
		for(MemoryObserver obs : observers)
			obs.LoadEvent();
	}


	/**
	 * Returns a string with the values of the stored positions in memory
	 */
	public String toString(){
		String line = "";
		
		if(this.memory.size() == 0)
			line = line + "<vacia>";
		else{
			for(int i = 0; i < this.memory.size(); i++){
				if(this.memory.get(i) != null){
					line = line + "[" + i + "]:" + this.memory.get(i) + " ";
				}
			}
		}
		return line;
	}
	
	/**
	 * Returns the size of the memory
	 * @return
	 */
	public int size(){
		return this.memory.size();
	}
	
	/**
	 * Gets the number of the stored positions in memory
	 * @return
	 */
	public int getStored(){
		return this.stored;
	}
}
