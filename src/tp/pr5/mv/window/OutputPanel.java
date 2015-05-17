package tp.pr5.mv.window;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class OutputPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private JTextArea textArea;
	
	/**
	 * OutputPanel constructor
	 */
	public OutputPanel(){
		this.setLayout(new BorderLayout());
		
		this.text = "";
		textArea= new JTextArea();
		textArea.setAutoscrolls(true);
		textArea.setBorder(new LineBorder(Color.gray));
		this.add(textArea);
	}
	
	public String getText(){
		return this.text;
	}
	
	/**
	 * Updates the text area with the given text.
	 */
	public void update(String text){
		this.text = text;
		textArea.setText(this.text);
	}
	
}
