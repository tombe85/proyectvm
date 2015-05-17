package tp.pr5.mv.instructions.nonparameterized.oneop;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */
public class FileOut implements OutMethod {
	
	FileWriter fw;
	String out;
	
	@Override
	public void write(int n) throws IOException {
		fw.write(n);
		out = out + (char) n;
	}
	
	/**
	 * Configures the File Writer for the OutInstruction
	 * @param fileName
	 * @throws IOException
	 */
	public void configureFileOut(String fileName) throws IOException{
		
		try{
			this.fw = new FileWriter(fileName);
			this.out = "";
		}catch(IOException ioe){
			throw new IOException("Uso incorrecto: Error al acceder al fichero de salida (" + fileName + ")");
		}
	}
	
	/**
	 * Closes the File Writer for the OutInstruction
	 * @throws IOException
	 */
	public void close() throws IOException {
		fw.close();
	}
}
