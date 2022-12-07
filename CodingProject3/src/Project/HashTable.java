package Project;

import java.util.Arrays;

/**
 * Represents the HashTable object class.
 * 
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class HashTable {
    /**
     * Array of Anagram objects.
     */
	public Anagram [] hashtable;
    /**
     * Size of the array.
     */
	private static int SIZE = 75149;
    /**
     * Stores number of collisions during Hashing.
     */    		
	public int collisions;

    public HashTable() {
    	this.hashtable = new Anagram[SIZE];
    	this.collisions = 0;
    }      
    
    /**
     * Take in a string and calls my hash code function for a index and adds a new anagram object to the array or
     * adds the string to a anagram objects list at that index.
     * 
     * @param theString
     */
    public void add(String theString) {
    	String newStr = theString.toLowerCase();

    	String key = sort(newStr);
    	
    	int index = hashCode(key);
    	
    	if(hashtable[index] == null) {
    		Anagram temp = new Anagram(key);
    		temp.addValue(newStr);
    		hashtable[index] = temp;
    	} else {
    		hashtable[index].addValue(newStr);    		
    	}
    }
    
    /**
     * Take in a string and calls Java's String hash code function for a index and adds a new anagram object to the array or
     * adds the string to a anagram objects list at that index.
     * 
     * @param theString
     */
    public void addJava(String theString) {
    	String newStr = theString.toLowerCase();

    	String key = sort(newStr);
    	
    	int index = hashCodeJava(key);
    	
    	if(hashtable[index] == null) {
    		Anagram temp = new Anagram(key);
    		temp.addValue(newStr);
    		hashtable[index] = temp;
    	} else {
    		hashtable[index].addValue(newStr);    		
    	}
    }
    
    
    /**
     * Takes in a string as a key and uses Java's hash code function to determine a index and if it can't
     * insert the word there uses quadratic probing to find a new hash value.
     * 
     * @param theKey
     * @return key index
     */
    public int hashCodeJava(String theKey) {
    	String newKeyS = theKey;
    	
    	int key = newKeyS.hashCode();       
    	key = Math.abs(key);
    	key = key % SIZE;
    	
        if(hashtable[key] != null && hashtable[key].getKey() != newKeyS) {
        	int addCollisions =0;
        	for(int i = 0; i < SIZE; i++) {
        		int add = i * i;
        		int newKey = (key + add) % SIZE;
        		if(hashtable[newKey] == null || hashtable[newKey].getKey().equals(theKey)) {
        			collisions += addCollisions;
        			return newKey;
        		}
        		addCollisions++;
        	}
        } 
        
        return key;
    } 
    
    
    /**
     * Takes in a string as a key and uses my hash code function to determine a index and if it can't
     * insert the word there uses quadratic probing to find a new hash value.
     * 
     * @param theKey
     * @return key index
     */
    public int hashCode(String theKey) {
    	String newKeyS = theKey;
    	int  asciiVal = 0, key = 0;    	
    	int p = 31;
    	
    	for(int i = 0; i < newKeyS.length(); i++) {
    		int mult = (int) Math.pow(p,i);
    		asciiVal = (asciiVal + mult * (int) newKeyS.charAt(i));
    	}

    	
    	key = asciiVal;
    	
    	key = key * key;
    	
        key = Math.abs(key);
        
        key = key % SIZE;
        
    	
        if(hashtable[key] != null && hashtable[key].getKey() != newKeyS) {
        	int addCollisions =0;
        	for(int i = 0; i < SIZE; i++) {
        		int add = i * i;
        		int newKey = (key + add) % SIZE;
        		if(hashtable[newKey] == null || hashtable[newKey].getKey().equals(theKey)) {
        			collisions += addCollisions;
        			return newKey;
        		}
        		addCollisions++;
        	}
        } 
        
        return key;
    } 

    /**
     * Takes in a word computes the key and uses my Hash code function to compute its index.
     * 
     * @param theString
     * @return Index
     */
    public int search(String theString) {
    	String newString = theString.toLowerCase();
    	
    	String theKey = sort(newString);
    	
    	return hashCode(theKey);    	
    }
    
    /**
     * Takes in a word computes the key and uses the Java Hash code function to compute its index.
     * 
     * @param theString
     * @return Index
     */
    public int searchJava(String theString) {
    	String newString = theString.toLowerCase();
    	
    	String theKey = sort(newString);
    	
    	return hashCodeJava(theKey);    	
    }
    
    /**
     * helper method that takes in a word and sorts it to compute its key.
     * 
     * @param theString
     * @return key
     */
    public String sort(String theString) {
    	char[] arr1 = theString.toCharArray();
    	Arrays.sort(arr1);
    	String key = new String(arr1);
    	return key;
    }
    
    
}
