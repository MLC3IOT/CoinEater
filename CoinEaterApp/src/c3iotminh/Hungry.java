package c3iotminh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Minh Ly
 * @version 1.0
 * 
 */
public class Hungry {
	
	public static void main(String[] args) throws Exception{
		System.out.println("Running some test input files..." + "\n");
		
		Integer numberoftestinputfiles = 9;
		for (int i=1;i<numberoftestinputfiles+1;i++) {
			runFile("input-file"+i+".txt");
		}
		System.out.println("\n" + "Finished running some test input files..." + "\n");

		System.out.println("Running parameter input file..." + "\n");
		if(args.length > 0) {
			runFile(args[0]);
	    } else {
	        System.out.println("\n" + "Missing filename parameter. Please input filename parameter.  e.g. run.bat input.txt");
	    }
	}
	
	public static void runFile(String filename) {
		try{			
			ArrayList<String> lines = readFile(filename);
			
			Board board = new Board(lines);
			CoinEater coinEater = new CoinEater(lines);
			System.out.println("Coin Eater's Initial Position: "+coinEater.getInitialPosition().getX()+" "+coinEater.getInitialPosition().getY());
			coinEater.eatCoins(board);
			System.out.println("Coin Eater's Final Position: "+coinEater.getEndPosition().getX()+" "+coinEater.getEndPosition().getY());
			System.out.println("Coin Eater's Final number of coins eaten: "+coinEater.getCoinsPickedUp()+ "\n");
		}
		catch (Exception e){
			System.out.println("Error: "+ e.getMessage());
		}
	}
	
	public static ArrayList<String> readFile(String filename) throws Exception {
		ArrayList<String> lines = null;
		String line = "newline";
		
		try{
			if (filename == null) {
				throw new Exception("filename is null");
			}
			BufferedReader bufferReader = new BufferedReader(new FileReader(filename));
			lines = new ArrayList<String>();
			
			while ((line = bufferReader.readLine()) != null) {
				lines.add(line);
				//System.out.println("Lines: "+line);
			}
			bufferReader.close();
		} catch (Exception e) {
			throw new Exception(Hungry.class.getName() + " readFile: Error " + e.getMessage());
		} 
		
		return lines;
	}

}
