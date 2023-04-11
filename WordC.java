package application;


/**
 * Creates an object that can be treated as a word.
 * Also stores an integer to show a count to keep track of occurrences of the word.
 * 
 * @author George Lopez
 *
 */

public class WordC {
	

	String word;
	int count;
	
	/**
	 * Creates the Word object and initializes the count at 1 automatically.
	 * Optionally the count can be provided in the parameter for custom starting count.
	 * 
	 * @param word The word itself
	 * 
	 */
	
	public WordC(String word) {
		this.word=word;
		count=1;
	}
	
	/**
	 * Creates the Word object and initializes the count at 1 automatically.
	 * Optionally the count can be provided in the parameter for custom starting count.
	 * 
	 * @param word The word itself
	 * @param num Count of the word
	 */
	
	public WordC(String word, int num) {
		this.word=word;
		count=num;
	}
	
	/**
	 * Prints out word and the current count into the console.
	 * Deprecated after moving to GUI development.
	 */
	
	public void getCountS() {
		
		System.out.println(word + ": " + count);
	}
	
	/**
	 * Creates string with word and count.
	 * @return word and count as String
	 */
	
	public String getCountSS() {
		
		return (word + ": " + count);
	}
	
	/**
	 * 
	 * @return Current count of word as integer
	 */
	
	public int getCount() {
		
		return count;
	}
	
	/**
	 * Increments word count value by 1
	 */
	
	public void upCount() {
		count++;
	}
	
	@Override
	public String toString() {

		return word;
	}
	
	
	/**
	 * Makes word count equal 0
	 * 
	 */
	public void setZero() {
		count=0;
	}
}
