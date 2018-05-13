package com.coffeepp;

import java.io.File;
import java.io.FileWriter;

/**
 * @author Andras
 *Logger osztaly, a fv hivasok menetet logolja ki file-ba. 
 */
public class Logger {
	/**
	 * file:
	 * egyszeri futtatas alatt minden fv ugyanebbe a file-ba logol.
	 */
	private static File file;
	/**
	 * numOfCalls:
	 * szamolja milyen melyen vagyunk a fv hivasokba. enter eseten novekszik, exit eseten csokken.
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
	 * fv-be lepeskor hivodik meg, logolja a hio objektumot fv-t es a fv parametereit.
	 * @param thisObj
	 * az objektum ami meghivta a fv-t, kell hogy legyen toString-je
	 * @param functionName
	 * a fv neve amiben a hivas tortent
	 * @param params
	 * a hivo fv parameterei String-kent.
	 */
	public void enter(Object thisObj, String functionName, String... params){
		try {
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	/**
	 * @param thisObj
	 * az objektum ami meghivta a fv-t, kell hogy legyen toString-je
	 * @param functionName
	 * a fv neve amiben a hivas tortent
	 * @param result
	 * a visszateresi ertek amivel a hivo fv visszater, String-kent.
	 */
	public void exit(Object thisObj, String functionName, String result){
		try {
			numOfCalls--;
		}
	    catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
