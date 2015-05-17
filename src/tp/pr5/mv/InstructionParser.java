package tp.pr5.mv;

import tp.pr5.mv.instructions.*;
import tp.pr5.mv.instructions.nonparameterized.*;
import tp.pr5.mv.instructions.nonparameterized.oneop.*;
import tp.pr5.mv.instructions.nonparameterized.twoop.*;
import tp.pr5.mv.instructions.parameterized.*;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class InstructionParser {
	
	private Instruction [] possible = {new NotInstruction(), new PopInstruction(), new AddInstruction(),
			new AndInstruction(), new DivInstruction(), new EqInstruction(), new FlipInstruction(),
			new GtInstruction(), new LeInstruction(), new LtInstruction(), new MultInstruction(),
			new OrInstruction(), new SubInstruction(), new HaltInstruction(), new OutInstruction(),
			new DupInstruction(),new BfInstruction(), new BtInstruction(), new JumpInstruction(),
			new LoadInstruction(), new StoreInstruction(), new PushInstruction(),
			new RjumpInstruction(), new RbtInstruction(), new RbfInstruction(), new InInstruction(),
			new LoadindInstruction(), new StoreindInstruction(), new JumpindInstruction()};
	/**
	 * Constructor of InstructionParser without parameters
	 */
	public InstructionParser(){
	}
	
	/**
	 * Generates the Instruction, saves it and returns it
	 * @return
	 */
	public Instruction parseInstruction(String line){
		Instruction inst = null;
		int i = 0;
		while(i < possible.length && inst == null){
			inst=possible[i].parse(line);
			i++;
		}
		return inst;
	}
	
}
