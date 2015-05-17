package tp.pr5.mv.window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */

public class ActionsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private boolean canOperate;
	
	/**
	 * Actions panel Constructor. Initializes the panel in order to add it to the main window.
	 * Initializes also the functions of the buttons
	 * @param control
	 * @param mw
	 */
	public ActionsPanel(final WindowController control, final MainWindow mw){
		this.canOperate = true;
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton stepButton = new JButton();
		JButton runButton = new JButton();
		JButton haltButton = new JButton();
		
		ImageIcon stepIcon = new ImageIcon("iconos/step.png");
		stepButton.setIcon(stepIcon);
		stepButton.setText("Step");
		
		ImageIcon runIcon = new ImageIcon("iconos/run.png");
		runButton.setIcon(runIcon);
		runButton.setText("Run");
		
		ImageIcon haltIcon = new ImageIcon("iconos/exit.png");
		haltButton.setIcon(haltIcon);
		haltButton.setText("Exit");
		
		stepButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(canOperate)
					control.stepPressed();
				else
					JOptionPane.showMessageDialog(null, "La máquina está parada");
			}
			
		});
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(canOperate)
					control.runPressed();
				else
					JOptionPane.showMessageDialog(null, "La máquina está parada");
				
			}
			
		});
		
		haltButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				control.haltPressed();
			}
			
		});
		
		this.add(stepButton);
		this.add(runButton);
		this.add(haltButton);
		
	}
	
	public void disableButtons(){
		this.canOperate = false;
	}
}
