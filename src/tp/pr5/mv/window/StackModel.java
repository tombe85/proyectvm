package tp.pr5.mv.window;

import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractListModel;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class StackModel extends AbstractListModel<Integer> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rows;
	private List<Integer> stack;
	
	public StackModel(){
		this.rows = 0;
		this.stack = new LinkedList<Integer>();
	}
	
	/**
	 * Gets the element at given position
	 */
	public Integer getElementAt(int arg0) {
		return stack.get(this.rows-(arg0+1));
	}

	@Override
	public int getSize() {
		return this.rows;
	}
	
	/**
	 * function to call to the father method fireContentsChanged
	 */
	public void fireContentChanged() {
		super.fireContentsChanged(this, 0, getSize());
	}
	
	public void pushEvent(int elem){
		stack.add(this.rows, elem);
		this.rows++;
	}
	
	public void popEvent(){
		if(this.rows > 0){
			this.rows--;
			stack.remove(this.rows);
		}
	}

}
