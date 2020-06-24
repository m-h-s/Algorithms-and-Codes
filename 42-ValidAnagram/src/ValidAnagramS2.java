import java.util.HashMap;
import java.util.Map;

/**
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 24
 * 
 * License: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *  
 *  
 */

public class ValidAnagramS2 implements ValidAnagram {

	@Override
	public boolean isAnagram(String s, String t) {
		boolean isAnagram = true;
		int [] sMap = new int [26];
		int [] tMap = new int [26];


		if (s.length() == t.length())
		{
			for (int i = 0; i < s.length (); i++)
			{
				crossPut (sMap, tMap, s.charAt(i));
				crossPut (tMap, sMap, t.charAt(i));
			}

			isAnagram = crossCheck (sMap) && crossCheck (tMap);			
		}


		else
			isAnagram = false;

		return isAnagram;
	}


	public void crossPut (int [] map1, int [] map2, char c)

	{
		int encodeChar = c - 97;

		if ( map2 [encodeChar] != 0 )
			map2 [encodeChar] --;

		else
			map1[encodeChar]++;

	}

	public boolean crossCheck (int [] map)
	{
		boolean check = true;

		for (int i = 0; i< map.length; i++)
			if (map [i] != 0)
			{
				check = false;
				break;
			}

		return check;
	}


}
