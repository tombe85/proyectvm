package tp.pr5.mv;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class ProgramMV {
	
	private Instruction [] instructionList;
	private int listCount;
	private final int PROGRAM_LIST_INCREASE = 5;
	
	/**
	 * ProgramMV constructor
	 */
	public ProgramMV() {
		this.instructionList = new Instruction[PROGRAM_LIST_INCREASE];
		this.listCount = 0;
	}
	
	/**
	 * Adds the given instruction to the instruction list
	 * @param ins
	 */
	public void addInstruction(Instruction ins){
		if(this.listCount == this.instructionList.length){
			extendInstructionList();
		}
		this.instructionList[this.listCount] = ins;
		this.listCount++;
	}
	
	/**
	 * Extends the instruction list in order to add more elements
	 */
	private void extendInstructionList() {
		Instruction [] newList = new Instruction[this.listCount + PROGRAM_LIST_INCREASE];
		for(int i = 0; i < listCount; i++){
			newList[i] = this.instructionList[i];
		}
		this.instructionList = newList;
	}
	
	/**
	 * Gets the instruction allocated in the given index
	 * @param index
	 * @return the instruction at the given index or null
	 */
	public Instruction getInstruction(int index){
		Instruction ins = null;
		if(index >= 0 && index < this.listCount){
			ins = this.instructionList[index];
		}
		return ins;
	}
	
	/**
	 * Gets the size of the instructions list
	 * @return the size of the instructions list
	 */
	public int size(){
		return this.listCount;
	}
	
	/**
	 * Generates a String with information about the instruction at the given position
	 * @param index
	 * @return a String with information about the instruction at the given position
	 */
	public String instructionToString(int index){
		String ins = "";
		
		if(index >= 0 && index < this.listCount){
			ins = this.instructionList[index].toString();
		}
		
		return ins;
	}
	
	/**
	 * Generates a String paragraph with information about all the instructions in the instructions list
	 */
	public String toString(){
		String prog = "";
		for(int i = 0; i < this.listCount; i++){
			prog = prog + i + ": " + instructionToString(i) + "\n";
		}
		return prog;
	}
	
	/**
	 * Generates a String paragraph with information about all the instructions in the instructions list.
	 * It receives also an integer parameter which points to the current instruction to be executed, and in the string 
	 * that instruction contains one *.
	 * @param index
	 * @return
	 */
	public String toString(int index){
		String prog = "";
		for(int i = 0; i < this.listCount; i++){
			if(i==index){
				prog = prog +" *       "+ i + ": " + instructionToString(i) + "\n";
			}else
				prog = prog +"         "+ i + ": " + instructionToString(i) + "\n";
		}
		return prog;
	}

}
