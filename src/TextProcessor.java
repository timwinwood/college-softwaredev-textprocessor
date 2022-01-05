/**
class TextProcessor - an instantiable class, a class that performs operations for a Text Processing application

@author Tim Winwood - x20213638
 
*/

public class TextProcessor {

	// declare instance variables for Question 1
	private String text;
	private String encodedText;
	private final String VOWELS = "aAeEiIoOuU";
	private final String INITIALS = "dT";
	/** Note: the computeEncodedText() method processes the text in reverse.
		knowing this, the initials have been stored in reverse order, for simplicity and performance (we do not need to reverse the initials).
		however, it the requirements were to specify that the initials were stored in first/last order, they could be reversed using the reverseText() method.
	*/ 
	
	
	// declare instance variables for Question 2
	private String longestWords[];
	
	// TextProcessor() constructor, called when an object of type TextProcessor is initialised
	public TextProcessor() {
		
		this.text = "";
		this.encodedText = "";
		this.longestWords = new String[0];
		
	}// end TextProcessor() constructor
	
	// -- Question 1 - Text Encoder
	
	// getText() method, get the text
	public String getText() {
		
		return text;
		
	}// end getText() method

	// setText() method, set the text
	public void setText(String text) {
		
		this.text = text;
		
	}// end setText() method
	
	// getEncodedText() method, get the encodedText
	public String getEncodedText() {
		
		return encodedText;
		
	}// end getEncodedText() method
	
	/** computeEncodedText() method
	-- traverse the text from the end to beginning
	   -- check if the character is '?', if so, increment interSentences to keep track of the number of interrogative sentences
	   -- check if the character is a vowel, if so, append the initials to stringBuffer
	   -- append the character to stringBuffer
	-- append interSentences to stringBuffer
	-- convert stringBuffer to String reversedEncodedText using StringBuffer.toString() method
	-- reverse reversedEncodedText using reverseText() method and assign the result to encodedText
	Note: the brief requires us to insert interSentences at the beginning of encodedText
	      we have only covered the StringBuffer.append() method in lectures, not methods such as StringBuffer.insert() or StringBuffer.reverse() 
	      Therefore, this implementation traverses the text in reverse, appends interSentences at the end of the reversed text to
	      compute reversedEncodedText, then reverses reversedEncodedText using the reverseText() method to compute encodedText
	*/
	public void computeEncodedText() {
		
		// declare local variables
		StringBuffer stringBuffer = new StringBuffer();
		int interSentences = 0;
		
		// traverse the text from the end to beginning
		for (int i = text.length() - 1; i >= 0; i--) {
			
			// check if the character is '?', if so, increment interSentences to keep track of the number of interrogative sentences
			char letter = text.charAt(i);
			if (letter == '?') {
				interSentences++;
			}// end if
			
			// check if the character is a vowel, if so, append the initials to stringBuffer
			int letterIndex = VOWELS.indexOf(letter);
			if (letterIndex >= 0) {
				stringBuffer.append(INITIALS);
			}// end if
			
			// append the character to stringBuffer
			stringBuffer.append(letter);

		}// end for loop
		
		// append interSentences to stringBuffer
		stringBuffer.append(interSentences);
		
		// convert stringBuffer to String reversedEncodedText using StringBuffer.toString() method
		String reversedEncodedText = stringBuffer.toString();
		
		// reverse reversedEncodedText using reverseText() method and assign the result to encodedText
		this.encodedText = reverseText(reversedEncodedText);

	}// end computeEncodedText() method
	
	
	/**  reverseText() method
	-- traverse the text from the end to beginning
	   -- append the character to stringBuffer
	-- convert stringBuffer to String reversedText using StringBuffer.toString() method
	-- return reversedText
	*/
	private String reverseText(String text) {
		
		// declare local variables
		StringBuffer stringBuffer = new StringBuffer();
		
		// traverse the text from the end to beginning
		for (int i = text.length() - 1; i >= 0; i--) {
			
			// append the character to stringBuffer
			char letter = text.charAt(i);
			stringBuffer.append(letter);

		}// end for loop
		
		// convert stringBuffer to String reversedText using StringBuffer.toString() method
		String reversedText = stringBuffer.toString();
		
		// return reversedText
		return reversedText;

	}// end reverseText()
	
	
	// -- Question 2 - Longest Word(s) Search
	
	/**  computeLongestWords() method
	-- traverse the array of words
		-- store the current word length
		-- if current word length is more than the longest word length
			-- initialise/reinitialise the longestWords array and add the current word 
		-- if current word length is equal to the longest word length 
			-- resize the longestWords array to longestWords.length+1 and add the current word
				-- initialise/reinitialise the tempLongestWords of size longestWords.length+1
				-- traverse longestWords array and add to tempLongestWords array
					-- add each longestWords to tempLongestWords
				-- add the current word to tempLongestWords
			-- set longestWords to tempLongestWords
	-- return longestWords array
	*/
	public String[] computeLongestWords(String[] words) {
		
		// declare local variables
		int longestWordLength = 0;
		String[] tempLongestWords;
		
		// traverse the array of words
		for(int i = 0; i < words.length; i++) {
			
			// store the current word length
			int currWordLength = words[i].length();
			
			// if current word length is more than the longest word length
			if(currWordLength > longestWordLength) {
				
				// initialise/reinitialise the longestWords array and add the current word 
				longestWords = new String[1];
				longestWords[0] = words[i];
				longestWordLength = currWordLength;
			
			// if current word length is equal to the longest word length 	
			}else if (currWordLength == longestWordLength){
	
				// resize the longestWords array to longestWords.length+1 and add the current word
				// initialise/reinitialise the tempLongestWords of size longestWords.length+1
				tempLongestWords = new String[longestWords.length + 1];
				
				// traverse longestWords array and add to tempLongestWords array
				for(int j = 0; j < longestWords.length; j++) {
					
					// add each longestWords to tempLongestWords
					tempLongestWords[j] = longestWords[j];
					
				}// end for
				
				// add the current word to tempLongestWords
				tempLongestWords[tempLongestWords.length - 1] = words[i];
				
				// set longestWords to tempLongestWords
				longestWords = tempLongestWords;
				
			}// end if/else
			
		}// end for loop
		
		// return longestWords array
		return longestWords;
		
	}// end computeLongestWords() method

}// end TextProcessor class
