/**
TextProcessorApp - a class that enables a user to encode paragraph(s) and search for longest word(s) in a number of words
	- prompts the user to enter how many paragraphs they would like to enter, then:
		-- prompts the user to enter each paragraph
		-- encodes and outputs each paragraph to the screen
	- prompts the user to enter how many words they would like to enter, then
		-- prompts the user to enter each word
		-- searches the words for the longest word(s) and outputs them to the screen
	
comments and spacing have been used exhaustively to aide review and demonstrate understanding
in a commercial setting, comments would be limited to more technical aspects of the application

@author Tim Winwood - x20213638
 
*/

// import the java.util.Scanner class, used to gain input from the user
import java.util.Scanner;

public class TextProcessorApp {

	public static void main(String[] args) {

		// declare local variables
		Scanner input = new Scanner(System.in);
		
		// declare local variables for Question 1
		String text;
		int numParagraphs;
		
		// declare local variables for Question 2
		int numWords;
		String word;
		String[] words;
		String[] longestWords;

		// instantiate object of type TextProcessor
		TextProcessor textProcessor = new TextProcessor();
		
		// -- Question 1 - Text Encoder
		
		// input
		// prompt the user to input the number of paragraphs
		System.out.println("How many Paragraphs would you like to enter?");
		numParagraphs = input.nextInt();

		// consume the remaining next line using nextLine() method, as nextInt() method only consumes the next int
		input.nextLine();

		// loop numParagraphs
		int i = 0;
		while (i < numParagraphs) {

			// input
			// prompt the user to input a paragraph
			System.out.println("Please enter a Paragraph:");
			text = input.nextLine();
			
			// set text of the textProcessor object
			textProcessor.setText(text);

			// processing
			// compute the encoded text
			textProcessor.computeEncodedText();

			// output
			// get and output the encoded text
			String encodedText = textProcessor.getEncodedText();
			System.out.println("Encoded Text is: " + encodedText);
			
			i++;

		} // end while loop
				
		// -- Question 2 - Longest Word(s) Search
		
		// input
		// prompt the user to input the number of words
		System.out.println("How many Words would you like to enter?");
		numWords = input.nextInt();

		// consume the remaining next line using nextLine() method, as nextInt() method only consumes the next int
		input.nextLine();
		
		// initialise array words of size numWords
		words = new String[numWords];
		
		// loop numWords
		int j = 0;
		while (j < numWords) {

			// input
			// prompt the user to input a word
			System.out.println("Please enter a Word:");
			word = input.next();
			
			// add the word to the words array
			words[j] = word;
			
			j++;
			
		} // end while loop
		
		// compute the longest words
		longestWords = textProcessor.computeLongestWords(words);
		
		// print the longest words to the screen
		System.out.println("The longest word(s):");
		for (int k = 0; k < longestWords.length; k++) {
			
			System.out.println(longestWords[k]);
			
		}// end for loop

	}// end main() method

}// end TextProcessorApp class
