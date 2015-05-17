package tp.pr5.mv.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import tp.pr5.mv.MVObserver;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramMV;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class ProgramPanel extends JPanel implements MVObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea progTxt;
	private ProgramMV program;
	
	/**
	 * ProgramPanel constructor
	 * @param cpu
	 */
	public ProgramPanel(){
		this.setLayout(new BorderLayout());
		
		JPanel progPan = new JPanel();
		progPan.setLayout(new BorderLayout());
		progTxt = new JTextArea();
		progPan.add(progTxt, BorderLayout.CENTER);
		//progTxt.setPreferredSize(new Dimension(190, 500));
		progTxt.setBorder(new LineBorder(Color.gray));
		JScrollPane js = new JScrollPane(progPan);
		
		this.add(js, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(200, 400));
	}

	@Override
	public void programLoaded(ProgramMV program) {
		this.program = program;
		progTxt.setText(program.toString(0));
	}

	@Override
	public void instructionStarts(String inst) {
		//nada
	}

	@Override
	public void instructionEnds(int pc, Memory memo, OperandStack stack) {
		progTxt.setText(this.program.toString(pc));
	}

	@Override
	public void executionError(String error) {
		// nada
	}

	@Override
	public void mVStoped() {
		progTxt.setText(this.program.toString());
	}

	@Override
	public void badCommand() {
		// nada
	}
}
