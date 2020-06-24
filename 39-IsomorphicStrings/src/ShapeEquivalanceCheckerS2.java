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
public class ShapeEquivalanceCheckerS2 implements ShapeEquivalanceChecker {

	
	/**
	 * ########################### Note: this strategy is more time-efficient.#######################################
	 * 
	 * Problem: Isomorphic Strings
	 * 
	 * 
	 * Description:
	 * Given two strings s and t, determine if they are isomorphic.
	 * Two strings are isomorphic if the characters in s can be replaced to get t.
	 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
	 * No two characters may map to the same character but a character may map to itself.
	 * 
	 * Solution:
	 * 1- Consider a mapping table that maps each char from the first string to one and only char in the second string.
	 * 2- Consider a mappedBefore table that record each char from the second string that is already related to a char from the second string.
	 * 3- Read characters of the first string one by one.
	 * 4- If the read char from the first string is in the mapping table get its mapping.
	 * 5- Read the related char from the second string.
	 * 6- If the mapping and the read char from the second string are not the same return false.
	 * 7- Else If the read char from the first string does not exist in the mapping table,
	 *    1- read the related char from the second string,
	 *    2- If the char exist in the mappedBefore table, return false.
	 *    3- Else, add the read char from the first table and the read char from the second table to the mapping table.
	 * 8- Go to 3- and continue
	 * 9 - Return true;
	 *    
	 */
	
	Map <Character, Character>  mapping;
	Map <Character, Boolean> mappedBefore;
	boolean equivalent;
	@Override
	public boolean isIsomorphic(String s, String t) {

		mapping = new HashMap <Character, Character> ();
		mappedBefore = new HashMap <Character, Boolean> ();
		equivalent = true;



		for (int i = 0; i < s.length(); i++)
		{
			if (mapping.containsKey(s.charAt(i)))
			{
				char mapped = mapping.get(s.charAt(i));

				if (mapped != t.charAt(i))
				{
					equivalent = false;
					break;
				}
			}

			else
			{
				if (mappedBefore.containsKey(t.charAt(i)))
				{
					equivalent = false;
					break;
				}
				else
				{ 
					mappedBefore.put(t.charAt(i), true);
					mapping.put(s.charAt(i), t.charAt(i));
				}

			}
		}
		return equivalent;
	}

}
