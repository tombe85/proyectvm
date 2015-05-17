package tp.pr5.mv.window;

import tp.pr5.mv.CPU;
import tp.pr5.mv.Controller;
import tp.pr5.mv.MVObserver;
import tp.pr5.mv.MemoryObserver;
import tp.pr5.mv.StackObserver;
import tp.pr5.mv.commands.PopCommand;
import tp.pr5.mv.commands.PushCommand;
import tp.pr5.mv.commands.QuitCommand;
import tp.pr5.mv.commands.RunCommand;
import tp.pr5.mv.commands.StepCommand;
import tp.pr5.mv.commands.WriteCommand;

public class WindowController extends Controller {
	
	
	public WindowController(CPU cpu) {
		super(cpu);
	}

	public void stepPressed() {
		StepCommand step = new StepCommand();
		cpu.executeCommand(step);
	}

	public void runPressed() {
		RunCommand runCom = new RunCommand();
		this.cpu.executeCommand(runCom);
	}

	public void haltPressed(){
		QuitCommand quit = new QuitCommand();
		this.cpu.executeCommand(quit);
		System.exit(0);
	}

	public void writeMemoPressed(Integer pos, Integer val) {
		WriteCommand write = new WriteCommand(pos, val);
		this.cpu.executeCommand(write);
	}

	public void pushPressed(Integer value) {
		PushCommand pushCommand = new PushCommand(value);
		this.cpu.executeCommand(pushCommand);
	}

	public void popPressed() {
		PopCommand pop = new PopCommand();
		this.cpu.executeCommand(pop);
	}

	public void configureSwingInMethod(OutputPanel inPan) {
		this.cpu.configureSwingInMethod(inPan);
	}

	public void configureSwingOutMethod(OutputPanel outPan) {
		this.cpu.configureSwingOutMethod(outPan);
	}

	public void addStackObserver(StackObserver stackObs) {
		this.cpu.addStackObserver(stackObs);
	}

	public void addMemoryObserver(MemoryObserver memoObs) {
		this.cpu.addMemoryObserver(memoObs);
	}

	public void addMVObserver(MVObserver mvObs) {
		this.cpu.addObserver(mvObs);
	}

}
