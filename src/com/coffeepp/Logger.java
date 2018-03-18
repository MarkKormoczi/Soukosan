package com.coffeepp;

import java.io.File;
import java.io.FileWriter;

/**
 * @author András
 *
 */
public class Logger {
	/**
	 * file:
	 * egyszeri futtatás alatt minden fv ugyanebbe a file-ba logol.
	 */
	private static File file;
	/**
	 * numOfCalls:
	 * számolja milyen mélyen vagyunk a fv hívásokba. enter esetén növekszik, exit esetén csökken.
	 */
	private static int numOfCalls = 0;
	
	/**
	 * inicializálja a file-t, és létrehoz egy új .log file-t a sorszámuk alapján. 
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
	 * fv-be lépéskor hívódik meg, logolja a híó objektumot fv-t és a fv paramétereit.
	 * @param thisObj
	 * az objektum ami meghívta a fv-t, kell hogy legyen toString-je
	 * @param functionName
	 * a fv neve amiben a hívás történt
	 * @param params
	 * a hívó fv paraméterei String-ként.
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
	 * a fv neve amiben a hívás történt
	 * @param result
	 * a visszatérési érték amivel a hívó fv visszatér, String-ként.
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
