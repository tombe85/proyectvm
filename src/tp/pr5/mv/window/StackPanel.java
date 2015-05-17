package tp.pr5.mv.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tp.pr5.mv.StackObserver;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class StackPanel extends JPanel implements StackObserver {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StackModel stackMod;
	private boolean canOperate;
	
	/**
	 * StackPanel constructor
	 * @param cpu
	 */
	public StackPanel(final WindowController control){
		this.stackMod = new StackModel();
		this.canOperate=true;
		this.setLayout(new BorderLayout());
		
		JList<Integer> list = new JList<Integer>(stackMod);
		JScrollPane listPan = new JScrollPane(list);
		listPan.setPreferredSize(new Dimension(300, 150));
		
		this.add(listPan, BorderLayout.CENTER);
		
		JPanel inferior = new JPanel();
		inferior.setLayout(new GridLayout(2,1));
		
		JPanel pushPan = new JPanel();
		pushPan.setLayout(new FlowLayout());
		
		JLabel valueLab = new JLabel("Valor:");
		pushPan.add(valueLab);
		
		final JTextArea valTxt = new JTextArea();
		valTxt.setPreferredSize(new Dimension(100, 20));
		pushPan.add(valTxt);
		
		JButton pushBut = new JButton("Push");
		pushBut.setPreferredSize(new Dimension(100, 20));
		pushBut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(canOperate){
						Integer value = new Integer(Integer.parseInt(valTxt.getText()));
						control.pushPressed(value);
					}else{
						JOptionPane.showMessageDialog(null, "La máquina está parada");
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Debes escribir valores enteros únicamente");
				}
			}
			
		});
		pushPan.add(pushBut);
		
		inferior.add(pushPan);
		
		JPanel popPan = new JPanel();
		popPan.setLayout(new BorderLayout());
		JButton popBut = new JButton("Pop");
		popBut.setPreferredSize(new Dimension(100, 20));
		popBut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(canOperate)
					control.popPressed();
				else
					JOptionPane.showMessageDialog(null, "La máquina está parada");
			}
			
		});
		popPan.add(popBut);
		inferior.add(popPan);
		this.add(inferior, BorderLayout.SOUTH);
	}
	
	/**
	 * Updates the stack panel
	 */
	private void update(){
		this.stackMod.fireContentChanged();
	}

	@Override
	public void PushEvent(Integer element) {
		this.stackMod.pushEvent(element);
		update();
	}

	@Override
	public void PopEvent() {
		this.stackMod.popEvent();
		update();
	}

	@Override
	public void PeekEvent() {
		
	}
	
	public void disableButtons(){
		this.canOperate = false;
	}
}
