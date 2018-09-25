import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

//Stack Overflow
public class Palindrome {

	static WordDictionary dictionary = new WordDictionary();


	// Get all words that can be formed starting at this index
	public static String[] getWords(String text, int index) {
		ArrayList<String> words = new ArrayList<String>();
		for (int i = 0; i <= text.length() - index; i++) {
			String maybeWord = text.substring(index, index + i);
			if (dictionary.isWord(text.substring(index, index + i))) {
				words.add(maybeWord);
			}
		}

		return words.toArray(new String[0]);
	}



	public static String reverseStringAndRemoveNonAlpha(String text) 
	{
		/*
		* TODO 3 x2
		*/
		Stack<Character> reverseStack = new Stack<Character>();
		String toReturn = new String("");
		
		
		for(int i = 0; i < text.length(); i++)
		{
			Character current = new Character(text.charAt(i));
			
			
			if(Character.isAlphabetic(current))
			{
				
				reverseStack.push(current);
				//System.out.println(reverseStack.peek()); //test
				//toReturn = current + "" +  toReturn ; //shows what is in the stack
		
				
			}
			
		
			
			for(int k = 0; k < reverseStack.size(); k++)
			{
				toReturn = reverseStack.pop() + toReturn;
				
			}
			//	System.out.println(toReturn);
			
		}
			
			
		
		//string is reversed now
		
		//System.out.println(toReturn); //TEST : )))))))))))
		return toReturn;
	
	}



	// Returns true if the text is a palindrome, false if not.
	public static boolean isPalindrome(String text) {
	// text is a fed in reversed string
		/*
		* TODO 4: Implement "explorePalindrome" x2
		*/
		String reverseString = reverseStringAndRemoveNonAlpha(text);
		reverseString = reverseString.toLowerCase();
		//Stack<Character>
		//System.out.println("reversed lowercase: " + reverseString); //test
		
		Stack<Character> palindromeStack = new Stack<Character>();
		Queue<Character> palindromeQueue = new Queue<Character>();
		int matchingLetterCount = 0;
		
		for(int i = 0; i < reverseString.length(); i ++)
		{
			Character currentChar = new Character(reverseString.charAt(i));
			palindromeStack.push(currentChar);
			palindromeQueue.enqueue(currentChar);
			//System.out.println("The current char is " + palindromeStack.peek() + " " + palindromeQueue.peekEnd() + " " + currentChar); //test
			
		}
		
		for(int i = 0; i < reverseString.length(); i++)
		{
			
			if(palindromeStack.pop().equals(palindromeQueue.dequeue()))
			{
				//System.out.println("Yass queen"); //test
				matchingLetterCount++;
			}
			
		}
		
		if(matchingLetterCount == reverseString.length())
		{//is palindrome
			//System.out.println("This set of letters is a palindrome :)"); //test
			return true;
		}
		else
		{//not palindrome
		//System.out.println("This set of letters is not a palindrome >:|"); //test
			return false;
		}	
	}



	public static void explorePalindrome(String text) 
	{
		String originalText = text.toLowerCase();
		String cleanReverseText = reverseStringAndRemoveNonAlpha(originalText);
		//System.out.println(cleanReverseText);
		
		decomposeText(originalText, cleanReverseText, 0, new Stack<String>());
		
		

	/*
	* TODO 5: Implement "explorePalindrome" & helper function x2
	*/

	

	}

	public static void decomposeText( String originalText,
                                    String textToDecompose,
                                    int index,
                                    Stack<String> decomposition) {

    	/*
    	* TODO 5: Implement "explorePalindrome" & helper function
    	*/
		if(index == textToDecompose.length())
		{// if we hit the end, stop
		
			Stack<String> tempStack = new Stack<String>();
			String toPrint = ":\t";
			
			while(decomposition.size() > 0)
			{
				String data = decomposition.pop();
				tempStack.push(data);
			}
			
			while(tempStack.size() > 0)
			{
				String data = tempStack.pop();
				toPrint += data + " ";
				decomposition.push(data);
			}
			//System.out.println("Base case"); //test
			System.out.println(originalText + " " + toPrint);
			return;
		}
		
		String[] wordsGotten = getWords(textToDecompose, index);
		for (String str : wordsGotten)
		{
			if(str.length() > 0)
			{
				decomposition.push(str);
				decomposeText(originalText, textToDecompose, index + str.length(), decomposition);
				decomposition.pop();
			}
		}
		
		//System.out.println("DECOMPOSING TEXT"); //test DONT WORRY ABOUT IT
	}

	// This function looks at the arguments that are passed
	// and decides whether to test palindromes or expand them
	public static void main(String[] args) throws IOException {

		//String testString = reverseStringAndRemoveNonAlpha("1234567890adccda");
		//isPalindrome(testString);
		//Stack<String> testStack = new Stack<String>();
		//decomposeText("BIGb oy test 213", " ", 0, testStack);
		
		if (args.length == 0) {
			System.out.println("ERROR: Remember to set the mode with an argument: 'test' or 'expand'");
		} else {
			String mode = args[0];

			// Default palindromes to use if none are provided
			String[] testPalindromes = {"A", "ABBA", "oh no an oboe", "salami?", "I'm alas, a salami"};
			if (args.length > 1)
				testPalindromes = Arrays.copyOfRange(args, 1, args.length);


			// Test whether the provided strings are palindromes
			if (mode.equals("test")) {

				for (int i = 0; i < testPalindromes.length; i++) {
					String text = testPalindromes[i];
					boolean result = isPalindrome(text);
					System.out.println("'" + text + "': " + result);
				}

			} else if (mode.equals("expand")) {
				for (int i = 0; i < testPalindromes.length; i++) {

					explorePalindrome(testPalindromes[i]);
				}
			}
			else {
				System.out.println("unknown mode: " + mode);
			}
		}
		
		//decomposeText("BIGb oy test 213", " ", 0, testStack); //test not to worry about :)
	}
}
