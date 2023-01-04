package Project;

import java.util.ArrayList;

/**
 * Represents the Anagram object class.
 * 
 * 
 * @author thenry04
 * @version Fall 2019
 */
public class Anagram {

	/**
	 * Key for anagram objects
	 */
	private String key;
	
	/**
	 * List to store anagrams for anagram objects
	 */
	private ArrayList<String> values;
	
	/**
	 * Takes in a key to create a anagram object.
	 * @param theKey
	 */
	public Anagram(String theKey) {
		this.key = theKey;
		this.values = new ArrayList<String>();
	}
	
	/**
     * Returns the key of the anagram object.
     * 
     * @return anagram objects key
     */
	public String getKey() {
		return this.key;
	}
	
	/**
     * Returns the list of anagrams.
     * 
     * @return List of anagrams
     */
	public ArrayList<String> getValues() {
		return this.values;
	}
	
	/**
     * Takes in a value and adds it to the anagrams object list of anagrams.
     * 
     * @param theValue
     */
	public void addValue(String theValue) {
		values.add(theValue);
	}

}
