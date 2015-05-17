package tp.pr5.mv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import tp.pr5.mv.exceptions.ASMFileParserException;


/**
 * 
 * @author Miguel Higuera Romero y David Israel García
 *
 */
public class ASMFileParser {
	
	/**
	 * Parses the file given by its name and returns the parsed ProgramMV
	 * @param fileName
	 * @return the programMV
	 * @throws ASMFileParserException
	 */
	public static ProgramMV parseFile(String fileName) throws ASMFileParserException{
		ProgramMV pmv = new ProgramMV();
		InstructionParser ip = new InstructionParser();
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			line = br.readLine();
			while(line != null){
				if(!line.isEmpty() && !line.startsWith(";")){
					int pos;
					if(line.contains(";")){
						pos = line.indexOf(";") - 1;
					}else{
						pos = line.length();
					}
					Instruction inst = ip.parseInstruction(line.substring(0, pos));
					if(inst == null)
						throw new ASMFileParserException("Error en el programa. Línea: " + line);
					
					pmv.addInstruction(inst);
				}
				line = br.readLine();
			}
			
			
			
		} catch (FileNotFoundException e) {
			throw new ASMFileParserException(e.getLocalizedMessage());
		} catch (ASMFileParserException afpe){
			throw afpe;
		} catch (IOException e) {
			throw new ASMFileParserException(e.getLocalizedMessage());
		}
		return pmv;
	}
}
