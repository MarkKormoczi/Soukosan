package com.coffeepp;

import java.io.File;
import java.io.FileWriter;

/**
 * @author Andras
 *Logger osztaly, a fv hívasok menetet logolja ki file-ba. 
 */
public class Logger {
	/**
	 * file:
	 * egyszeri futtatas alatt minden fv ugyanebbe a file-ba logol.
	 */
	private static File file;
	/**
	 * numOfCalls:
	 * szamolja milyen melyen vagyunk a fv hívasokba. enter eseten novekszik, exit eseten csokken.
	 */
	private static int numOfCalls = 0;
	
	/**
	 * inicializalja a file-t, es letrehoz egy uj .log file-t a sorszamuk alapjan. 
	 */
	public static void loggerInit(){
		int num = 0;
		String s = "Log"+num+".log";
		try {
			File f = new File(s);
			while(f.exists()) {
				num++;
				s = "Log"+num+".log";
				f = new File(s);
			}
			file = f;
			file.createNewFile();
		}
		catch(Exception e) {System.err.println("Error during init");
			e.printStackTrace(System.err);
		}
		
	}
	/**
	 * fv-be lepeskor hívodik meg, logolja a hío objektumot fv-t es a fv parametereit.
	 * @param thisObj
	 * az objektum ami meghívta a fv-t, kell hogy legyen toString-je
	 * @param functionName
	 * a fv neve amiben a hívas tortent
	 * @param params
	 * a hívo fv parameterei String-kent.
	 */
	public void enter(Object thisObj, String functionName, String... params){
		try {
			FileWriter writer = new FileWriter(file,true);
			for(int i = 0; i < numOfCalls; i++)writer.write("  ");
			writer.write("-> Object: " + thisObj.toString() + " function: " + functionName + " parameters: ");
			for (String s : params) {
				writer.write(s + "; ");
			}
			writer.write(String.format("%n"));
			writer.flush();
		    writer.close();
		    numOfCalls++;
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	/**
	 * @param thisObj
	 * az objektum ami meghívta a fv-t, kell hogy legyen toString-je
	 * @param functionName
	 * a fv neve amiben a hívas tortent
	 * @param result
	 * a visszateresi ertek amivel a hívo fv visszater, String-kent.
	 */
	public void exit(Object thisObj, String functionName, String result){
		try {
			numOfCalls--;
			FileWriter writer = new FileWriter(file,true);
			for(int i = 0; i < numOfCalls; i++)writer.write("  ");
			writer.write("<- Object: " + thisObj.toString() + " function: " + functionName + " returned value: " + result);
			writer.write(String.format("%n"));
			writer.flush();
		    writer.close();
		}
	    catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
