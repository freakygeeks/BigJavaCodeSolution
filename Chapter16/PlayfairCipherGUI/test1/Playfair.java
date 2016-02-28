
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * Used by the British military during the Boer war and even during World War I
 * the Playfair code was actually invented by Charles Wheatstone, a pionner of the telegraphic era,
 *  in 1854 but was popularized by Lyon Playfair.
 *
 * At the beginning of the XIX a great inventor, Charles Babbage, had decipher the Vigenere
 * code and the invention of the telgraph required a safer code.
 *
 * To start we use a key and we build a 5 X 5 square using the letters of the key (not repeating a letter) 
 * then the rest of the alphabet is put.
 * The letters I and J use the same spot.
 *
 * So if the key is DREAMINCODE the sqare will have this look
 * 
 *   D   R   E   A   M
 *  I/J  N   C   O   B   <--- second D and E is dropped then rest of the alphabet
 *   F   G   H   K   L  
 *   P   Q   S   T   U
 *   V   W   X   Y   Z
 *   
 *   Then we take the message and make blocks of 2 letters
 *   When a letter is repeated the second one is replaced by an X (there is no word in English
 *   where two X follow each other)
 *   If the number of letters in the message is odd, a X is appended
 *   
 *   So if the message is
 *   
 *   "secret message two" the formating by pairs gives:
 *   se-cr-et-me-sX-sa-ge-tw-oX
 *   
 *   Now the pairs of letters are tested against the alphabet grid. Three things might happen:
 *   1) the two letters are in the same row
 *   2) the two letters are in the same column
 *   3) the two letters are neither in the same row neither in the same column
 *   
 *   Case 1: the two letters are in the same row
 *   Each letter will be replaced by the letter immediatly to its right. If a letter is at
 *   the end of the line it is replaced by the first letter of that row.
 *   So in our case "me" will become "DA"
 *   
 *   Case 2: the two letters are in the same column
 *   Each letter will be replaced by the letter immediatly under it. If a letter is at the bottom
 *   of the column it is replaced by the top letter of that row.
 *   So in our case "se" will become "XC" and "sx" will become "XE"
 *   
 *   Case 3: the two letters are neither in the same row or column
 *   The first letter is replaced by the letter, in the same row, that is on the column where the
 *   second letter resides.
 *   The second letter is replaced by the letter, in the same row, that is on the column where the
 *   first letter resides.
 *   So in our case "cr" will become "NE" and "et" will become "AS" and "tw" will become "QY" 
 */
public class Playfair {

	// the grid that will be build when a new key is entered
	private char[][] grid;

	/**
	 * Constructor that receives the key as parameter
	 */
	public Playfair(String key) {
		// build the grid only once
		grid = new char[5][5];
		// and add our key
		setKey(key);
	}

	/**
	 * To fill the grid the first time and when the key changes
	 */
	public void setKey(String key) {
		// avoid null key use the regular alphabet
		if(key == null)
			key = "A";
		// easier to work with a single dimension array and play with a single index
		// we will convert it later into our grid
		char[] single = new char[26];
		// the number of elements in that array
		int nbIn = 0;
		// flags to see if the letter has already been entered
		boolean[] done = new boolean[26];

		// convert the key into an array of char and make it uppercase
		char[] keyDigit = key.toUpperCase().toCharArray();
		// scan it letter by letter to start to fill the single array
		for(char c : keyDigit) {
			// if not a letter ignore it
			if(c < 'A' || c > 'Z')
				continue;
			// to convert the J into I
			char actual = c;
			if(actual == 'J')
				actual = 'I';
			// index in the done array
			int index = actual - 'A';
			// test if this letter already entered
			if(done[index])
				continue;
			// OK enter it both in our linear array and in the done ones
			done[index] = true;
			single[nbIn++] = actual;
		}

		// in case none of the characters in the key was valid
		// we'll meke it "A"
		if(nbIn == 0) {
			single[nbIn++] = 'A';
			done[0] = true;
		}
		// fill the rest of our linear array
		for(char c = 'A'; c <= 'Z'; c++) {
			// ignore the J
			if(c == 'J')
				continue;
			// test if already done
			if(done[c - 'A'])
				continue;
			// ok register it
			single[nbIn++] = c;
		}
		// now convert our single array into the two size array grid
		nbIn = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				grid[i][j] = single[nbIn++];
			}
		}
	}

	/**
	 * The encode the text received as parameter
	 */
	public String encode(String clear) {
		// avoid null message
		if(clear == null)
			return "";
		// convert the message into uppercase digits
		char[] digit = clear.toUpperCase().toCharArray();
		// create an ArrayList to store the pairs of letters
		ArrayList<LetterPair> aList = new ArrayList<LetterPair>();
		// index if we are at the first or second digit of the pair
		int index = 0;
		// scan through all our digits
		int i = 0;
		// the current LetterPair
		LetterPair lp = null;
		while(i < digit.length) {
			// change J to I
			if(digit[i] == 'J')
				digit[i] = 'I';
			// if invalid character ignore it
			if(digit[i] < 'A' || digit[i] > 'Z') {
				i++;
				continue;
			}
			// if we are doing the first letter no problem just create a new LetterPair object
			// and add it to the arrayList
			if(index == 0) {
				// new current LetterPair object for Coding
				lp = new LetterPair(digit[i++], true);
				aList.add(lp);							// add to ArrayList
				index = 1;								// looking for second letter
				continue;
			}
			// so it is the second digit test if it the same as the previous one
			if(lp.left == digit[i]) {
				// same letter so put a 'X' and do not increment i
				lp.setRight('X');
			}
			else {
				// add the digit and increment i
				lp.setRight(digit[i++]);
			}
			// next pair so index 0
			index = 0;
		}
		// if index is 1 it means we have to finish with a X
		if(index == 1)
			lp.setRight('X');

		// return the String representation of the ArrayList
		return aListToString(aList);
	}

	/**
	 * To decode the coded string received as parameter
	 */
	public String decode(String coded) {
		// empty String
		if(coded == null) {
			return "";
		}
		// the message shoul have an even number of characters
		char[] digit = coded.toUpperCase().toCharArray();
		// we copy the valid characters into a StringBuilder
		StringBuilder sb = new StringBuilder(digit.length);
		for(int i = 0; i < digit.length; i++) {
			// if not valid character just ignore it
			if(digit[i] < 'A' || digit[i] > 'Z')
				continue;
			// switch J for I
			if(digit[i] == 'J')
				digit[i] = 'I';
			// append the valid character
			sb.append(digit[i]);
		}
		// if not an even number of characters exit
		if(sb.length() % 2 != 0)
			return "--- Invalid coded message ---";
		
		// build an arrayList to hold our letter pairs
		ArrayList<LetterPair> aList = new ArrayList<LetterPair>();
		// make an array of the valid char[] out of the StringBuilder
		digit = sb.toString().toCharArray();
		// populate it
		for(int i = 0; i < digit.length; i += 2) {
			// create a decoding pair
			LetterPair lp = new LetterPair(digit[i], false);
			lp.setRight(digit[i+1]);
			aList.add(lp);
		}
		// return the String representation of the ArrayList
		return aListToString(aList).toLowerCase();
	}
	
	/** 
	 * Returns as a String the content of an ArraList of LetterPair
	 */
	private String aListToString(ArrayList<LetterPair> aList) {
		// if the ArrayList is empty just return "" as coded message
		if(aList.size() == 0)
			return "";
		// StringBuilder to cumulate the elements
		StringBuilder sb = new StringBuilder();
		// put the first element
		sb.append(aList.get(0).getPair());
		// put the other ones preceeded by "-"
		for(int i = 1; i < aList.size(); i++) {
			sb.append('-');
			sb.append(aList.get(i).getPair());
		}
		return sb.toString();
		
	}
	/**
	 * For debug purpose display the Grid
	 */
	public void dumpGrid() {
		System.out.println("--- GRID ---");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(" " + grid[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * For the GUI returns the Grid
	 */
     public char[][] getGrid() {
    	 return grid;
     }
	/**
	 * To unit test our class
	 */
	public static void main(String[] args) {
		
		//-----------------------------------------------------------
		// Automatic tests
		//-----------------------------------------------------------
		
		// see if invalid key I finish with a grid ABCDEFGH...
		Playfair pf = new Playfair("123456");
		System.out.println("Grid that should start with \"A\"");
		pf.dumpGrid();
		// test with our example
		pf = new Playfair("DreamInCode");
		System.out.print("Grid that should start with \"DreamInCode\"");
		System.out.println("  (Note: \"D\" and \"E\" won't be repeated)");	
		pf.dumpGrid();
		
		// see how will be encrypted the "secret message two" message
		String clear = "secret message two";
		System.out.println("Original: " + clear);
		String coded = pf.encode(clear);
		System.out.println("   Coded: " + coded);
		// and how it will be decoded
		System.out.println(" Decoded: " + pf.decode(coded));

		//-----------------------------------------------------------
		// End of Automatic tests
		// you can remove all the automatic tests code in production
		//-----------------------------------------------------------
		
		// now test from user input 
		// build a Scanner to read from the console
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the key: ");
		// read the key and create a Playfair object with it
		String key = scan.nextLine();
		Playfair userPlayfair = new Playfair(key);
		// input message from user
		System.out.print("Enter message: ");
		String message = scan.nextLine();
		System.out.println("          Original: " + message);
		// code it and decode it back
		coded = userPlayfair.encode(message);
		System.out.println("Encoded message is: " + coded);
		System.out.println("translated back ? : " + userPlayfair.decode(coded));		


	}
	
	/**
	 * A class to handle the pairs of letters
	 */
	private class LetterPair {
		// the first letter 
		private char left;
		// the coordinates of the letter in the Grid
		private Point pLeft, pRight;
		// the coded 2 letters
		private char[] digit;
		// if coding or decoding
		boolean coding;
		
		/**
		 * Constructor built with the first letter
		 */
		private LetterPair(char left, boolean coding) {
			// store the left letter
			this.left = left;
			// store if we are coding or decoding
			this.coding = coding;
			// and find its coordinates in the Grid
			pLeft = findPos(left);
			// prepare the array to hold the 2 coded values
			digit = new char[2];
		}
		/**
		 * To set the second letter
		 */
		private void setRight(char right) {
			// and find its position in the Grid
			pRight = findPos(right);
			
			// now we can determine the type and act accordingly
			if(pLeft.x == pRight.x)				// if in the same row
				sameRow();
			else if(pLeft.y == pRight.y)
				sameColumn();				// else if in the same column
			else
				diffRowCol();					// so neither of them
			
			// store the coded value
			digit[0] = grid[pLeft.x][pLeft.y];
			digit[1] = grid[pRight.x][pRight.y];
		}
		
		/**
		 * Code the 2 on the same row: 
		 * we take the column to the right when coding to the left when decoding
		 */
		private void sameRow() {
			if(coding) {
				// to the right
				pLeft.y++;
				pRight.y++;
				// wrap around at column 5
				pLeft.y %= 5;
				pRight.y %= 5;
			}
			else {
				// to the left
				pLeft.y--;
				pRight.y--;
				// wrap around at column 0
				if(pLeft.y < 0)
					pLeft.y = 4;
				if(pRight.y < 0)
					pRight.y = 4;
			}
				
		}
		/**
		 * Code the 2 on the same column: 
		 * we take the row under when coding the row over when decoding
		 */
		private void sameColumn() {
			if(coding) {
				// under it
				pLeft.x++;
				pRight.x++;
				// wrap around a row 5
				pLeft.x %= 5;
				pRight.x %= 5;
			}
			else {
				// over it
				pLeft.x--;
				pRight.x--;
				// wrap around at row 0
				if(pLeft.x < 0)
					pLeft.x = 4;
				if(pRight.x < 0)
					pRight.x = 4;
			}
		}
		/**
		 * Code the 2 on different row/col we take the letter at the other one column
		 */
		private void diffRowCol() {
			// the column of both of them (the one of the other letter)
			int leftColumn = pRight.y;
			int rightColumn = pLeft.y;
			// replace these value in our coordinates
			pLeft.y = leftColumn;
			pRight.y = rightColumn;
		}

		/** 
		 * To find the coordinates of a letter on the grid
		 */
		private Point findPos(char c) {
			// scan the whole grid for the letter
			for(int x = 0; x < 5; x++) {
				for(int y = 0; y < 5; y++) {
					// if found
					if(grid[x][y] == c) {
						return new Point(x, y);
					}
				}
			}
			// not found ?  BUG !!!
			throw new IllegalStateException("Letter " + c + " not found in the Grid");
		}
		
		/**
		 * to return as a String
		 */
		private String getPair() {
			return new String(digit);
		}
	}
}

