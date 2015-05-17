package tp.pr5.mv.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp.pr5.mv.MVObserver;
import tp.pr5.mv.Memory;
import tp.pr5.mv.MemoryObserver;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramMV;
import tp.pr5.mv.StackObserver;

public class StatePanel extends JPanel implements MVObserver, StackObserver, MemoryObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel stop;
	private JLabel numInst;
	private JCheckBox memo;
	private JCheckBox stack;
	private int executed;
	private JLabel error;

	public StatePanel() {
		this.executed = 0;
		this.setSize(320, 50);
		this.setLayout(new BorderLayout());
		
		JPanel leftPan = new JPanel();
		stop = new JLabel();
		stop.setText("");
		leftPan.add(stop);
		this.add(leftPan, "West");
		
		JPanel centerPan = new JPanel();
		centerPan.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel labelInst = new JLabel("Número de instrucciones ejecutadas: ");
		centerPan.add(labelInst);
		
		this.numInst = new JLabel("0");
		centerPan.add(this.numInst);
		
		this.memo = new JCheckBox("Memoria Modificada");
		this.memo.setSelected(false);
		centerPan.add(this.memo);
		
		this.stack = new JCheckBox("Pila Modificada");
		this.stack.setSelected(false);
		centerPan.add(this.stack);
		this.add(centerPan, "Center");
		
		this.error = new JLabel("");
		this.add(this.error, "East");
		
	}

	@Override
	public void programLoaded(ProgramMV program) {
		// Not used
	}

	@Override
	public void instructionStarts(String inst) {
		this.memo.setSelected(false);
		this.stack.setSelected(false);
		this.error.setText("");
	}

	@Override
	public void instructionEnds(int pc, Memory memo, OperandStack stack) {
		this.executed++;
		String text = "" + this.executed;
		this.numInst.setText(text);
	}

	@Override
	public void executionError(String error) {
		this.error.setText("Error");
		this.error.setForeground(Color.RED);
	}

	@Override
	public void badCommand() {
		//Not used
	}

	@Override
	public void StoreEvent(int index, int val) {
		this.memo.setSelected(true);
	}

	@Override
	public void LoadEvent() {
		// Not used
	}

	@Override
	public void PushEvent(Integer element) {
		this.stack.setSelected(true);
	}

	@Override
	public void PopEvent() {
		this.stack.setSelected(true);
	}

	@Override
	public void PeekEvent() {
		// Not used
	}

	@Override
	public void mVStoped() {
		stop.setText("Máquina Parada");
		stop.setForeground(Color.RED);
	}

}
