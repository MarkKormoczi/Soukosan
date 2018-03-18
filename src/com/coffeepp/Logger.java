package com.coffeepp;

import java.io.File;
import java.io.FileWriter;

/**
 * @author Andr�s
 *
 */
public class Logger {
	/**
	 * file:
	 * egyszeri futtat�s alatt minden fv ugyanebbe a file-ba logol.
	 */
	private static File file;
	/**
	 * numOfCalls:
	 * sz�molja milyen m�lyen vagyunk a fv h�v�sokba. enter eset�n n�vekszik, exit eset�n cs�kken.
	 */
	private static int numOfCalls = 0;
	
	/**
	 * inicializ�lja a file-t, �s l�trehoz egy �j .log file-t a sorsz�muk alapj�n. 
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
	 * fv-be l�p�skor h�v�dik meg, logolja a h�� objektumot fv-t �s a fv param�tereit.
	 * @param thisObj
	 * az objektum ami megh�vta a fv-t, kell hogy legyen toString-je
	 * @param functionName
	 * a fv neve amiben a h�v�s t�rt�nt
	 * @param params
	 * a h�v� fv param�terei String-k�nt.
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
	 * az objektum ami megh�vta a fv-t, kell hogy legyen toString-je
	 * @param functionName
	 * a fv neve amiben a h�v�s t�rt�nt
	 * @param result
	 * a visszat�r�si �rt�k amivel a h�v� fv visszat�r, String-k�nt.
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
