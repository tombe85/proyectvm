package tp.pr5.mv.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import tp.pr5.mv.MemoryObserver;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class MemoryPanel extends JPanel implements MemoryObserver{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final MemoryModel memoryMod;
	private boolean canOperate;
	/**
	 * MemoryPanel constructor
	 * @param cpu
	 */
	public MemoryPanel(final WindowController control){
		this.setLayout(new BorderLayout());
		this.memoryMod = new MemoryModel();
		this.canOperate = true;
		JTable tabla = new JTable(memoryMod);
		JScrollPane spCont = new JScrollPane(tabla);
		tabla.setFillsViewportHeight(true);
		spCont.setPreferredSize(new Dimension(300, 150));
		this.add(spCont, BorderLayout.CENTER);
		
		JPanel inferior = new JPanel();
		inferior.setLayout(new GridLayout(2,1));
		
		JPanel valuesPan = new JPanel();
		valuesPan.setLayout(new FlowLayout());
		
		JLabel posLab = new JLabel("Pos");
		valuesPan.add(posLab);
		
		final JTextArea posTxt = new JTextArea();
		posTxt.setPreferredSize(new Dimension(100, 20));
		valuesPan.add(posTxt);
		
		JLabel valLab = new JLabel("Val");
		valuesPan.add(valLab);
		
		final JTextArea valTxt = new JTextArea();
		valuesPan.add(valTxt);
		valTxt.setPreferredSize(new Dimension(100, 20));
		
		inferior.add(valuesPan);
		
		JButton writeBut = new JButton("Write");
		writeBut.setPreferredSize(new Dimension(100, 20));
		inferior.add(writeBut);
		
		writeBut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(canOperate){
						Integer pos = Integer.parseInt(posTxt.getText());
						Integer val = Integer.parseInt(valTxt.getText());
						control.writeMemoPressed(pos, val);
					}else{
						JOptionPane.showMessageDialog(null, "La máquina está parada");
					}
				}catch(NumberFormatException ne){
					JOptionPane.showMessageDialog(null, "Debes escribir valores enteros únicamente");
				}
			}
			
		});
		
		this.add(inferior, BorderLayout.SOUTH);
	}
	
	/**
	 * Updates the memory panel
	 */
	private void update(){
		memoryMod.fireTableDataChanged();
	}

	@Override
	public void LoadEvent() {
		
	}

	@Override
	public void StoreEvent(int index, int val) {
		this.memoryMod.storeEvent(index, val);
		update();
	}
	
	public void disableButtons(){
		this.canOperate = false;
	}
	
}
