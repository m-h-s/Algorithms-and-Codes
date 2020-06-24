import java.util.*;
/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 03
 * 
 * License: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */

public class FirstUniqueCharS3 implements FirstUniqueChar {

	/**
	 * Problem:
	 * First Unique Char in a String
	 * 
	 * 
	 * Description:
	 * Given a string, find the first non-repeating character in it and return it's index. 
	 * If it doesn't exist, return -1.
	 * 
	 * Solution:
	 * 
	 * This design strategy is the same as Strategy 1.
	 * The only difference is that Map data structure is used.hhh
	 * 
	 */

	@Override
	public int firstUniqChar(String s) {

		Map <Character, Integer> frequency = new HashMap <Character, Integer> ();
		Map <Character, Integer> firstAppearance = new HashMap <Character, Integer> ();


		for (int i  = 0;  i < s.length (); i++)
		{
			if (frequency.containsKey(s.charAt(i))) 
				frequency.put(s.charAt(i), frequency.get(s.charAt(i)) + 1);

			else
			{ 
				frequency.put(s.charAt(i), 1);
				firstAppearance.put(s.charAt(i), i);
			}
		}


		int minIndex = -1;

		for (Character key : frequency.keySet())
			if (frequency.get(key) == 1 && ( firstAppearance.get(key) < minIndex || minIndex == -1))
			{
				minIndex = firstAppearance.get(key);
			}



		return minIndex;
	}

}
