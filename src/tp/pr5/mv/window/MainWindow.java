package tp.pr5.mv.window;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.Controller;
import tp.pr5.mv.MVObserver;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramMV;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */

public class MainWindow extends JFrame implements MVObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WindowController control;
	private final MemoryPanel memoPan;
	private final StackPanel stackPan;
	private final ProgramPanel programPan;
	private final OutputPanel inPan;
	private final OutputPanel outPan;
	private final ActionsPanel actionPan;
	private final StatePanel statePan;
	
	/**
	 * MainWindow constructor. Creates the Main Window
	 * @param title
	 * @param ctrl
	 * @throws HeadlessException
	 */
	public MainWindow(String title, Controller ctrl) throws HeadlessException {
		super(title);
		this.control = (WindowController) ctrl;
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPan = new JPanel();
		mainPan.setSize(320, 200);
		this.add(mainPan);
		
		mainPan.setLayout(new BorderLayout());
		
		memoPan = new MemoryPanel(this.control);
		this.control.addMemoryObserver(memoPan);
		stackPan = new StackPanel(this.control);
		this.control.addStackObserver(stackPan);
		programPan = new ProgramPanel();
		this.control.addMVObserver(programPan);
		inPan = new OutputPanel();
		this.control.configureSwingInMethod(inPan);
		outPan = new OutputPanel();
		this.control.configureSwingOutMethod(outPan);
		actionPan = new ActionsPanel(this.control, this);
		actionPan.setBorder(new TitledBorder("Acciones"));
		mainPan.add(actionPan, "North");
		programPan.setBorder(new TitledBorder("Programa"));
		mainPan.add(programPan, "West");
		JPanel centerPanel = new JPanel();
		mainPan.add(centerPanel, "Center");
		
		centerPanel.setLayout(new GridLayout(2, 1));
		JPanel memstackPan = new JPanel();
		centerPanel.add(memstackPan);
		JPanel infoPanel = new JPanel();
		centerPanel.add(infoPanel);
		
		memstackPan.setLayout(new GridLayout(1,2));
		stackPan.setBorder(new TitledBorder("Pila de Operandos"));
		memoPan.setBorder(new TitledBorder("Memoria de la máquina"));
		memstackPan.add(stackPan);
		memstackPan.add(memoPan);
		
		infoPanel.setLayout(new GridLayout(2,1));
		inPan.setBorder(new TitledBorder("Entrada del programa-p"));
		outPan.setBorder(new TitledBorder("Salida del programa-p"));
		infoPanel.add(inPan);
		infoPanel.add(outPan);
		
		statePan = new StatePanel();
		this.control.addMemoryObserver(statePan);
		this.control.addStackObserver(statePan);
		this.control.addMVObserver(statePan);
		mainPan.add(statePan, "South");
		
		this.control.addMVObserver(this);
	}

	@Override
	public void programLoaded(ProgramMV program) {
		// Nada
	}

	@Override
	public void instructionEnds(int pc, Memory memo, OperandStack stack) {
		// Nada
	}

	@Override
	public void executionError(String error) {
		JOptionPane.showMessageDialog(null, error);
	}

	@Override
	public void mVStoped() {
		this.stackPan.disableButtons();
		this.memoPan.disableButtons();
		this.actionPan.disableButtons();
	}
	
	@Override
	public void instructionStarts(String inst) {
		// nada
	}

	@Override
	public void badCommand() {
		// Not used
	}
}
