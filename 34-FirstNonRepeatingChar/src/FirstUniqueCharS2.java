/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 03
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 * 
 * 
 *
 */
public class FirstUniqueCharS2 implements FirstUniqueChar {


	/**
	 * 
	 * Problem:
	 * First Unique Char in a String
	 * 
	 * 
	 * Description:
	 * Given a string, find the first non-repeating character in it and return it's index. 
	 * If it doesn't exist, return -1.
	 * 
	 * 
	 * Solution:
	 * 
	 * 1- Consider an array of length 26 with all cell initialized to zero.
	 * This array represents all the English letters.
	 * 
	 * 2- Consider an array of length 26 registering the first appearance of a letter in the given string.
	 * 
	 * 3- For each char in the given string:
	 *   1- Turn it into lower case.
	 *   2- Find equivalent Ascii code.
	 *   3- Deduce 97.
	 *   4- Find the related position in the letter array.
	 *   5- If the value of the related cell in letter is zero,
	 *       Record the index of that letter in the first appearance array.
	 *   6 - Increase the value of the related cell in the letter array by one.
	 *   
	 * 4- Check the letters whose values are one, and find the minimum first appearance.
	 *  
	 */

	@Override
	public int firstUniqChar(String s) {

		int [] letter = new int [26];
		int [] firstAppearance = new int [26];
		int minIndex = -1;

		for (int i = 0; i< s.length(); i++)
		{
			int position = Character.toLowerCase(s.charAt(i)) - 97;

			if (letter [position] == 0)
			{
				firstAppearance [position] = i;
			}

			letter [position] ++;

		}


		for (int i = 0; i < 26; i++)
		{
			if ( letter [i] == 1 && ( firstAppearance [i] < minIndex || minIndex == -1) )
			{
				minIndex = firstAppearance [i];
			}
		}
		
		
		return minIndex;
	}

}
