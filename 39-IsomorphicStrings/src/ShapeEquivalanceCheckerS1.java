import java.util.*;
/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 18 
 * 
 * License: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class ShapeEquivalanceCheckerS1 implements ShapeEquivalanceChecker {

	int counter1, counter2;
	Map<Character, Integer> charCode1, charCode2;
	boolean equivalant ;
	@Override
	public boolean isIsomorphic(String s, String t) {
		/**
		 * Solution:
		 * 
		 * Main Idea:
		 * 
		 * 1- Two strings are equivalent if the encoding of their characters are the same.
		 * 2- Map each characters in each string to a number.
		 * 3- Check if the two obtained mapping are the same.
		 * 4- At each step the code of the characters in the two given strings should be same.
		 * 
		 * 
		 */
		charCode1 = new HashMap <Character, Integer> ();
		charCode2 = new HashMap <Character, Integer> ();
		equivalant = true;


		for (int i = 0 ; i < s.length(); i++)
		{
			int code1, code2;

			if (charCode1.containsKey(s.charAt(i)))
			{
				code1 = charCode1.get(s.charAt(i));
			}

			else 
			{
				counter1++;
				code1 = counter1;
				charCode1.put(s.charAt(i), code1);
			}


			if (charCode2.containsKey(t.charAt(i)))
			{
				code2 = charCode2.get(t.charAt(i));
			}

			else
			{
				counter2++;
				code2 = counter2;
				charCode2.put(t.charAt(i), code1);
			}

			if (code1 != code2)
			{ 
				equivalant = false;
				break;
			}
		}

		return equivalant;
	}

}
