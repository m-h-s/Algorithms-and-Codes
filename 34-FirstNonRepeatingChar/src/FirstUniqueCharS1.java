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
 */
public class FirstUniqueCharS1 implements FirstUniqueChar {

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
	 * 1- Consider three arrays. One stores unique chars, the other stores the frequency of the chars, and the third one stores the index of first appearance.
	 * 2- Count the frequency of each char in the string and put into the two above array.
	 * 3- Scan the array and return the first one with frequency one.
	 */
	
	@Override
	public int firstUniqChar(String s) {

		int uniqueIndex = -1;

		if (s.length () > 0)
		{

			char [] chars = new char [s.length ()];
			int [] counts = new int [s.length ()];
			int [] firstIndices  =  new int [s.length ()];
			int lastIndex = 0;



			for (int i = 0; i < s.length (); i++ )
			{
				boolean found = false;
				int j = 0;

				while (j < s.length () && !found)
				{
					if (s.charAt(i) == chars [j])
					{ 
						counts [j] ++;
						found = true;
					}

					j++;
				}


				if ( !found )
				{
					chars [lastIndex] = s.charAt(i);
					counts [lastIndex] = 1;
					firstIndices [lastIndex] = i;
					lastIndex++;
				}

			}


			for (int i = 0; i <= lastIndex; i++ )
			{
				if (counts [i] == 1)
				{

					uniqueIndex = firstIndices [i];
					break;
				}
			}
		}


		return uniqueIndex;
	}

}
