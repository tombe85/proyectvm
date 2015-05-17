package tp.pr5.mv;

import java.util.Vector;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 * This class implements the Stack.
 *
 */
public class OperandStack extends Observable<StackObserver> {
	private Vector<Integer> stack;
	private int posStack;
	private final int STACK_INCREASE = 5;
	
	/**
	 * Constructor of the OperandStack class. Initializes the stack.
	 */
	public OperandStack() {
		this.stack = new Vector<>();
		this.posStack = -1;
	}
	
	/**
	 * Adds a value to the stack
	 * @param value
	 */
	public void push(int value){
		this.posStack++;
		if(this.posStack >= this.stack.size())
			this.stack.setSize(this.posStack+this.STACK_INCREASE);
		this.stack.add(posStack, value);
		notifyPushEvent();
	}
	
	/**
	 * Notifies the observers that a value has been pushed into the stack
	 */
	private void notifyPushEvent() {
		for(StackObserver obs : observers)
			obs.PushEvent(peek());
	}

	/**
	 * Gets the last added value from the stack 
	 * @return the last value in the stack
	 */
	public int peek(){
		return this.stack.get(this.posStack);
	}
	
	/**
	 * Gets the last added value from the stack and removes it from the stack
	 * @return
	 */
	public int pop(){
		int value = this.peek();
		this.stack.set(this.posStack, null);
		this.posStack--;
		notifyPopEvent();
		return value;
	}
	
	/**
	 * Notifies to the observers that the last value has been popped from the stack
	 */
	private void notifyPopEvent() {
		for(StackObserver obs : observers)
			obs.PopEvent();
	}

	/**
	 * Returns a String with all the values in the stack, starting with the last one
	 */
	public String toString(){
		String line = "";
		if(this.posStack == -1)
			line = line + "<vacia>";
		else{
			for(int i = 0; i <= this.posStack; i++){
				line = line + this.stack.get(i) + " ";
			}
		}
		return line;
	}
	
	/**
	 * Gets the size of the operand stack
	 * @return the size of the operand stack
	 */
	public int size(){
		return this.posStack + 1;
	}
	
	/**
	 * Function for showing the stack in window mode
	 * @param index
	 * @return
	 */
	public Integer getElementAt(int index){
		return this.stack.elementAt(index);
	}
	
}
