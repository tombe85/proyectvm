package tp.pr5.mv.instructions.nonparameterized;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */

public class FileIn implements InMethod {
	
	FileReader fr;
	
	/**
	 * FileIn constructor
	 */
	public FileIn(){
		this.fr = null;
	}
	
	@Override
	public int read() throws IOException {
		int c = fr.read();
		return c;
	}
	
	/**
	 * Configures the File Reader for the InInstruction
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void configureFileIn(String fileName) throws FileNotFoundException{
		try{
			this.fr = new FileReader(fileName);
		}catch(FileNotFoundException fnfe){
			throw new FileNotFoundException("Uso incorrecto: Error al acceder al fichero de entrada (" + fileName + ")");
		}
	}
	
	/**
	 * Closes the File Reader for the InInstruction
	 * @throws IOException
	 */
	public void close() throws IOException {
		if(this.fr != null)
			fr.close();
	}

}
