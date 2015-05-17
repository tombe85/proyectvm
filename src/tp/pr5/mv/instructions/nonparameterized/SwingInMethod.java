package tp.pr5.mv.instructions.nonparameterized;

import java.io.IOException;

import tp.pr5.mv.window.OutputPanel;

public class SwingInMethod implements InMethod {
	
	private InMethod im;
	private String entrada;
	private int pos;
	private OutputPanel ip; //¿?
	
	/**
	 * SwingInMethod constructor
	 * @param im
	 * @throws IOException
	 */
	public SwingInMethod(InMethod im) throws IOException {
		this.im = im;
		entrada = readInputString(this.im);
		this.pos = 0;
		this.ip = null;
	}
	
	/**
	 * Reads all the input string from the input method and returns it
	 * @param im
	 * @return the input string
	 * @throws IOException
	 */
	private String readInputString(InMethod im) throws IOException {
		int caracter = 0;
		String input = "";
		caracter = im.read();
		if(caracter != -1){
			do{
				input = input + (char) caracter;
				caracter = im.read();
			}while(caracter != -1);
		}
		//input = input.trim();
		return input;
	}
	
	@Override
	public int read() throws IOException {
		int retorno;
		if(pos < entrada.length()){
			retorno = entrada.charAt(this.pos);
			char[] tmp = entrada.toCharArray();
			if(tmp[pos] != '\n')
				tmp[pos] = '*';
			entrada = new String(tmp);
			ip.update(this.entrada);
			this.pos++;
		}else
			retorno = -1;
		
		return retorno;
	}
	
	/**
	 * Configures the input panel in order to update the input text
	 * @param ip
	 */
	public void configureInputPanel(OutputPanel ip){
		this.ip = ip;
		this.ip.update(entrada);
	}

}
