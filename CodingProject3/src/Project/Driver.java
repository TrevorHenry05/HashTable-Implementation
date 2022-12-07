package Project;


 
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Driver provides the main methods for taking the word input file and testing both hashing to the table using my hashFunction and Java 
 * string hashFunction. Takes the inputs from the the input file and searches the table for anagrams of the words.
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class Driver {
	
	/**
     * Main method for Driver.
     * 
     * @param theArgs argument for main method.
	 * @throws IOException 
     */
    public static void main(String[] theArgs) throws IOException {
    	BufferedWriter out = new BufferedWriter(new FileWriter("D:\\School\\Eclipse-workspace-external\\CodingProject3\\Resources\\Output.txt"));
	
        Scanner input1 = new Scanner(new FileInputStream("D:\\School\\Eclipse-workspace-external\\CodingProject3\\Resources\\input.txt"));
        Scanner input2 = new Scanner(new FileInputStream("D:\\School\\Eclipse-workspace-external\\CodingProject3\\Resources\\words.txt"));
        Scanner input3 = new Scanner(new FileInputStream("D:\\School\\Eclipse-workspace-external\\CodingProject3\\Resources\\words.txt"));
        Scanner input4 = new Scanner(new FileInputStream("D:\\School\\Eclipse-workspace-external\\CodingProject3\\Resources\\input.txt"));
        
        
        //Test Java String HashFunction
        long start1 = System.currentTimeMillis();
        HashTable table1 = new HashTable();
         
        out.write("\n\nJavas HashFunction\n\n");  
        while(input3.hasNext()) {
        	String add1 = input3.next();
        	add1.replaceAll("\\p{Punct}", "");
        	table1.addJava(add1);
        	
        	if(input3.hasNextLine()) {
        		input3.nextLine();
        	}
        } 
        
      //Search HashTable for anagrams using Java HashFunction
        while(input4.hasNext()) {
        	String word = input4.next();
        	StringBuilder sb = new StringBuilder();
        	sb.append("[");
        	sb.append(word);
        	sb.append("]");
        	
        	int index = table1.searchJava(word);
        	if(index >= 0 && table1.hashtable[index] != null) {
        	    ArrayList<String> temp = table1.hashtable[index].getValues();
        	
        	    sb.append(formatOutPut(temp));
        	} else {
        		sb.append("[" + 0 + "]");
        	}
        	out.write(sb.toString());
        	out.newLine();
        	
        	if(input4.hasNextLine()) {
        	    input4.nextLine();
        	}
        } 
        
        long end1 = System.currentTimeMillis();
        
        out.write("My HashFUnction\n\n");
        
        //Test my Hash function
        long start = System.currentTimeMillis();
        HashTable table = new HashTable();
        
        while(input2.hasNext()) {
        	String add = input2.next();
        	add.replaceAll("\\p{Punct}", "");
        	table.add(add);
        	
        	if(input2.hasNextLine()) {
        		input2.nextLine();
        	}
        } 
        
        //Search HashTable for anagrams using my HashFunction
        while(input1.hasNext()) {
        	String word = input1.next();
        	StringBuilder sb = new StringBuilder();
        	sb.append("[");
        	sb.append(word);
        	sb.append("]");
        	
        	int index = table.search(word);
        	if(index >= 0 && table.hashtable[index] != null) {
        	    ArrayList<String> temp = table.hashtable[index].getValues();
        	
        	    sb.append(formatOutPut(temp));
        	} else {
        		sb.append("[" + 0 + "]");
        	}
        	out.write(sb.toString());
        	out.newLine();
        	
        	if(input1.hasNextLine()) {
        	    input1.nextLine();
        	}
        } 
        
        long end = System.currentTimeMillis();
        
       
        
         
        
        out.newLine();
        
        NumberFormat formatter = new DecimalFormat("#0.00000");
        out.write("My program runtime: " + formatter.format( (end - start) / 1000d) + " seconds");
        out.newLine();
        out.write("Java program runtime: " + formatter.format((end1 - start1) / 1000d) + " seconds");
        out.newLine();
        
        out.newLine();
        out.write("Collisions  Count: " + table.collisions);
        out.newLine();
        out.write("Java's Collision Count: " + table1.collisions);
        out.newLine();
        out.newLine();
        
        
        
        
        out.close();
    }
    
    /**
     * Helper for formating the Anagram List to output.
     * 
     * @param theList
     */
    public static String formatOutPut(ArrayList<String> theList) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("[" + theList.size() + "]");
    	
    	Iterator<String> iter = theList.iterator();
    	
    	while(iter.hasNext()) {
    		String s = iter.next();
    		sb.append("[" + s + "]");
    	}
    	
    	return sb.toString();
    }
	
}
