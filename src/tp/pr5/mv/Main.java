package tp.pr5.mv;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.cli.*;

import tp.pr5.mv.console.BatchController;
import tp.pr5.mv.console.InteractiveController;
import tp.pr5.mv.console.MainConsole;
import tp.pr5.mv.exceptions.ASMFileParserException;
import tp.pr5.mv.instructions.nonparameterized.FileIn;
import tp.pr5.mv.instructions.nonparameterized.InMethod;
import tp.pr5.mv.instructions.nonparameterized.NullIn;
import tp.pr5.mv.instructions.nonparameterized.StdIn;
import tp.pr5.mv.instructions.nonparameterized.SwingInMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.FileOut;
import tp.pr5.mv.instructions.nonparameterized.oneop.NullOut;
import tp.pr5.mv.instructions.nonparameterized.oneop.OutMethod;
import tp.pr5.mv.instructions.nonparameterized.oneop.StdOut;
import tp.pr5.mv.instructions.nonparameterized.oneop.SwingOutMethod;
import tp.pr5.mv.window.MainWindow;
import tp.pr5.mv.window.WindowController;

/**
 * 
 * @author Miguel Higuera Romero y David Israel García Díaz
 *
 */

public class Main {
	
	/**
	 * Main program
	 * @param args
	 */
	private static FileIn fi = null;
	private static FileOut fo = null;
	
	public static void main(String[] args){
		
		MVModeEnum mvMode = MVModeEnum.UNKNOWN;
		Options options = new Options();
		Option helpOption = new Option("h", "help", false, "Shows this help message");
        options.addOption(helpOption);
        Option modeOption = new Option("m", "mode", true, "The execution mode (interactive, batch or window)");
        options.addOption(modeOption);
        Option asmOption = new Option("a", "asm", true, "The input file which contains the ASM code");
        options.addOption(asmOption);
        Option inputOption = new Option("i", "in", true, "The input file for instruction IN");
        options.addOption(inputOption);
        Option outputOption = new Option("o", "out", true, "The output file for the instruction OUT");
        options.addOption(outputOption);
        
        BasicParser parser = new BasicParser();
        CommandLine command = null;
    	
        try {
        	command = parser.parse(options, args);
        	OutMethod om = null;
        	InMethod im = null;
        	ProgramMV programMV = null;
        	
        	if(command.hasOption('h')){
        		HelpFormatter hf = new HelpFormatter();
        		hf.printHelp(Main.class.getCanonicalName() + " [-a <asmfile>] [-h] [-i <infile>] [-m <mode>] [-o <outfile>]", options);
        		return;
        	}
        	
        	if(command.hasOption('m')){
        		if(command.getOptionValue('m').equalsIgnoreCase("interactive")){
        			mvMode = MVModeEnum.INTERACTIVE;
        			if(command.hasOption('i')){
        				if(command.getOptionValue('i') != null){
        					fi = new FileIn();
            				fi.configureFileIn(command.getOptionValue('i'));
            				im = fi;
    					}else{
        					System.err.println("Uso incorrecto: Missing argument for option: i");
            				System.err.println("Use -h|--help para más detalles.");
            				System.exit(1);
        				}
        				
        				
        			}else{
        				NullIn ni = new NullIn();
        				im = ni;
        			}
        			if(command.hasOption('o')){
        				if(command.getOptionValue('o') != null){
        					fo = new FileOut();
            				fo.configureFileOut(command.getOptionValue('o'));
            				om = fo;
        				}else{
        					System.err.println("Uso incorrecto: Missing argument for option: o");
            				System.err.println("Use -h|--help para más detalles.");
            				System.exit(1);
        					
        				}
        			}else{
        				NullOut no = new NullOut();
        				om = no;
        			}
        			if(command.hasOption('a')){
        				String asmFileName = new String(command.getOptionValue('a'));
        				programMV = ASMFileParser.parseFile(asmFileName);
        				
        			}else{
        				programMV = new ProgramMV();
        				programInput(programMV);
        			}
        			
        		}else if(command.getOptionValue('m').equalsIgnoreCase("batch")){
        			mvMode = MVModeEnum.BATCH;
        			if(command.hasOption('a')){
        				String asmFileName = new String(command.getOptionValue('a'));
        				programMV = ASMFileParser.parseFile(asmFileName);
        				if(command.hasOption('i')){
        					if(command.getOptionValue('i') != null){
        						fi = new FileIn();
                				fi.configureFileIn(command.getOptionValue('i'));
                				im = fi;
        					}else{
            					System.err.println("Uso incorrecto: Missing argument for option: i");
                				System.err.println("Use -h|--help para más detalles.");
                				System.exit(1);
            				}
            			}else{
            				StdIn si = new StdIn();
            				im = si;
            			}
            			if(command.hasOption('o')){
            				if(command.getOptionValue('o') != null){
            					fo = new FileOut();
                				fo.configureFileOut(command.getOptionValue('o'));
                				om = fo;
            				}else{
            					System.err.println("Uso incorrecto: Missing argument for option: o");
                				System.err.println("Use -h|--help para más detalles.");
                				System.exit(1);
            				}
            				
            			}else{
            				StdOut so = new StdOut();
            				om = so;
            			}
        			}else{
        				System.err.println("Uso incorrecto: Fichero ASM no especificado.");
        				System.err.println("Use -h|--help para más detalles.");
        				System.exit(1);
        			}
        			
        		}else if(command.getOptionValue('m').equalsIgnoreCase("window")){
        			mvMode = MVModeEnum.SWING;
    				if(command.hasOption('i')){
        				if(command.getOptionValue('i') != null){
        					fi = new FileIn();
            				fi.configureFileIn(command.getOptionValue('i'));
            				im = fi;
    					}else{
        					System.err.println("Uso incorrecto: Missing argument for option: i");
            				System.err.println("Use -h|--help para más detalles.");
            				System.exit(1);
        				}
        				
        			}else{
        				NullIn ni = new NullIn();
        				im = ni;
        			}
        			if(command.hasOption('o')){
        				if(command.getOptionValue('o') != null){
        					fo = new FileOut();
            				fo.configureFileOut(command.getOptionValue('o'));
            				om = fo;
        				}else{
        					System.err.println("Uso incorrecto: Missing argument for option: o");
            				System.err.println("Use -h|--help para más detalles.");
            				System.exit(1);
        				}
        			}else{
        				StdOut no = new StdOut();
        				om = no;
        			}
        			if(command.hasOption('a')){
        				String asmFileName = new String(command.getOptionValue('a'));
        				programMV = ASMFileParser.parseFile(asmFileName);
        				
        			}else{
        				System.err.println("Uso incorrecto: Missing argument for option: a");
        				System.err.println("Use -h|--help para más detalles.");
        				System.exit(1);
        			}
        			SwingInMethod sim = new SwingInMethod(im);
        			SwingOutMethod som = new SwingOutMethod(om);
        			im = sim;
        			om = som;
    			}else{
        			System.err.println("Uso incorrecto: Modo incorrecto (parametro -m|--mode)");
        			System.err.println("Use -h|--help para más detalles.");
        			System.exit(1);
        		}
        		CPU cpu = new CPU(om, im);
    			CommandInterpreter.configureCommandInterpreter(cpu);
    			/*System.out.println("El programa introducido es:");
    			System.out.print(programMV.toString());*/
    			Controller control;
    			
    			switch(mvMode){
    				case SWING:
    					control = new WindowController(cpu);
    					MainWindow mainWindow = new MainWindow("MV", control);
    					mainWindow.setVisible(true);
    					cpu.loadProgram(programMV);
    					break;
    				case BATCH:
    					control = new BatchController(cpu);
    					MainConsole consoleb = new MainConsole(control);
    					cpu.addObserver(consoleb);
    					cpu.loadProgram(programMV);
    					consoleb.batchStart();
    					
    					break;
    				case INTERACTIVE:
    					control = new InteractiveController(cpu);
    					MainConsole consolei = new MainConsole(control);
    					cpu.addObserver(consolei);
    					cpu.loadProgram(programMV);
    					consolei.interactiveStart();
    					break;
    				default:
    					control = null;
    					break;
    			}
    			
    			if(command.hasOption('i') && !mvMode.equals(MVModeEnum.SWING)){
    				fi.close();
    			}
    			if(command.hasOption('o') && !mvMode.equals(MVModeEnum.SWING)){
    				fo.close();
    			}
        	}else{
        		System.err.println("Uso incorrecto: Modo incorrecto (parametro -m|--mode)");
    			System.err.println("Use -h|--help para más detalles.");
    			System.exit(1);
        	}
        } catch(ParseException pe){
        	System.err.print("Uso incorrecto: ");
        	System.err.print(pe.getMessage() + "\n");
			System.err.println("Use -h|--help para más detalles.");
			System.exit(1);
        	
        } catch(IOException ioe){
        	closeFileRW();
        	System.err.println(ioe.getMessage());
        	System.err.println("Use -h|--help para más detalles.");
        	System.exit(1);
        	
        } catch(ASMFileParserException afpe){
        	closeFileRW();
    		System.err.println(afpe.getLocalizedMessage());
			System.exit(1);
        }
	}

	/**
	 * Static method to manage the program input
	 * @param progMV
	 */
	private static void programInput(ProgramMV progMV){
		
		Scanner input = new java.util.Scanner(System.in);
		InstructionParser insParser = new InstructionParser();
		Instruction instruction;
		System.out.println("Introduce el programa fuente");
		System.out.print("> ");
		String line = "";
		
		while(!line.equalsIgnoreCase("end") && input.hasNext()){
			line = input.nextLine();
			if(!line.equalsIgnoreCase("end")){
				instruction = insParser.parseInstruction(line);
				if(instruction == null)
					System.err.println("Error: Instrucción incorrecta");
				else{
					progMV.addInstruction(instruction);
				}
				System.out.print("> ");
			}
		}
		input.close();
	}
	
	/**
	 * Closes the FileIn and FileOut for the in and out instructions if they have been opened 
	 */
	public static void closeFileRW(){
		if(fi != null){
			try {
				fi.close();
			} catch (IOException e) {
			}
		}
		if(fo != null){
			try {
				fo.close();
			} catch (IOException e) {
			}
		}
	}
	
	
}
