package com.coffeepp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestProcessor {
    private String testFile;
    private List<String> input;
    private List<String> output = new ArrayList<>();
    private ByteArrayOutputStream baos;
    TestProcessor(ByteArrayOutputStream b){
        this.baos = b;
    }

    public void ProcessTest(String s) {
        ReadTestFile(s);
        if(Validate()){
            System.out.println("Test Successful");
        } else {
            System.out.println("Test Failed");
        }
    }

    private void ReadTestFile(String s){
        try(BufferedReader br = new BufferedReader(new FileReader("test/" + s))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String testFile = sb.toString();

            String lines[] = testFile.split("\\r?\\n");

            int i = 1;
            while (!lines[i].contains("output:")){
                System.out.println(lines[i]);
                Controller.Command(lines[i]);
                i++;
            }
            i++;
            for (; i < lines.length ; i++){
                //System.out.println(lines[i]);
                output.add(lines[i]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean Validate(){
        String console[] = baos.toString().split("\\r?\\n");
        String lastCommandResut[] = new String[20];
        // az output sizeig megyünk.
        for (int i = 0; i < output.size(); i++){
            // a konzol utolsó soraira vagyunk kiváncsial.
            lastCommandResut[i] = console[console.length-output.size()+i].toLowerCase();

            if (!lastCommandResut[i].trim().equals(output.get(i).trim().toLowerCase())){
                System.out.println(lastCommandResut[i]);
                System.out.println(output.get(i).toLowerCase());
                System.out.println("Test Failed on this lines");
                return false;
            }
        }

        System.out.println("Expected output:");
        for (int i = 0; i < output.size();i++){

            System.out.println(output.get(i));
        }
        return  true;
        //return console[console.length - 1].contains(output.get(output.size() - 1));
    }
}
