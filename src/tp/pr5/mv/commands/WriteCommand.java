package tp.pr5.mv.commands;

import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.instructions.parameterized.PushInstruction;
import tp.pr5.mv.instructions.parameterized.StoreInstruction;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class WriteCommand extends CommandInterpreter {
	
	private int value;
	private int pos;
	
	/**
	 * WriteCommand constructor
	 * @param pos
	 * @param val
	 */
	public WriteCommand(int pos, int val) {
		this.value = val;
		this.pos = pos;
	}
	
	/**
	 * Constructor for testing purposes
	 */
	public WriteCommand() {
	}
	
	@Override
	public void executeCommand(){
		StoreInstruction storeInst = new StoreInstruction(this.pos);
		PushInstruction pushInst = new PushInstruction(this.value);
		getCpu().executeInstruction(pushInst);
		getCpu().executeInstruction(storeInst);
	}

	@Override
	public CommandInterpreter parse(String line) {
		CommandInterpreter command = null;
		line.trim();
		String [] words = line.split(" ");
		if(words.length == 3 && words[0].equalsIgnoreCase("write")){
			try{
				int arg1 = Integer.parseInt(words[1]);
				int arg2 = Integer.parseInt(words[2]);
				command = new WriteCommand(arg1, arg2);
			}catch(Exception e){
				//El argumento es erróneo
			}
		}
		return command;
	}
	
	public String toString(){
		return "write";
	}

}
