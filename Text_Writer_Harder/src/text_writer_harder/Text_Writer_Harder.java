package text_writer_harder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Text_Writer_Harder {

    public static String fullDir;

    public static void getDir() {
        fullDir = System.getProperty("user.dir") + "\\myText.txt";
    }

    public static void main(String[] args) {
        getDir();
        System.out.println(fullDir);
        writeFile(fullDir);
        readFile(fullDir);
        exclusivereadFile(fullDir);
        arrayreadfile(fullDir);
    }

    public static void writeFile(String dir) {
        //writes string 
        Scanner input = new Scanner(System.in);
        System.out.println("Writing to file");
        System.out.println("Enter string:");
        String mystr = input.nextLine();

        try {
            FileWriter writeToFile = new FileWriter(dir, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(mystr);
            printToFile.close();     // if error, remove this line
            writeToFile.close();     // if error, remove this line
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void readFile(String dir1) {
        //prints all lines 
        System.out.println("Reading from file");
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(dir1));
            while ((inputLine = read.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void exclusivereadFile(String dir1) {
        //prints all lines that meet condition 
        System.out.println("exclusive read file");
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(dir1));
            while ((inputLine = read.readLine()) != null) {
                if ("jon".equals(inputLine)) {
                    System.out.println(inputLine);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void arrayreadfile(String fullDirectory) {
         //adds all lines to array and prints array
        System.out.println("array read file");
        String input_line;
        ArrayList<String> textItems = new ArrayList<String>();
        try {
            BufferedReader re = new BufferedReader(new FileReader(fullDirectory));
            while ((input_line = re.readLine()) != null) {
                textItems.add(input_line);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        Iterator myIteration = textItems.iterator();
        while (myIteration.hasNext()) {
            System.out.println(myIteration.next());
        }
    }
}
