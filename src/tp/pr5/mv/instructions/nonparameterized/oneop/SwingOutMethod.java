package tp.pr5.mv.instructions.nonparameterized.oneop;

import java.io.IOException;

import tp.pr5.mv.window.OutputPanel;

public class SwingOutMethod implements OutMethod {
	
	private OutMethod om;
	private OutputPanel op;
	
	/**
	 * SwingOutMethod constructor
	 * @param om
	 */
	public SwingOutMethod(OutMethod om) {
		this.om = om;
		this.op = null;
	}

	@Override
	public void write(int n) throws IOException {
		this.om.write(n);
		this.op.update(this.op.getText() + (char) n);
	}
	
	/**
	 * Configures the output panel in order to update the output text
	 * @param op
	 */
	public void configureOutputPanel(OutputPanel op){
		this.op = op;
	}

}
