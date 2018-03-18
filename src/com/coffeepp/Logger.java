package com.coffeepp;

import java.io.File;
import java.io.FileWriter;

public class Logger {
	private static File file;
	private static int numOfCalls = 0;
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
