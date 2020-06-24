import java.util.*;
/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 24
 * 
 * License: Cretaive Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class ValidAnagramS1 implements ValidAnagram {

	@Override
	public boolean isAnagram(String s, String t) {
		boolean isAnagram = true;
		Map <Character, Integer> sMap = new HashMap <Character,Integer> ();
		Map <Character, Integer> tMap = new HashMap <Character,Integer> ();
			
		
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
	
	
	public void crossPut (Map <Character, Integer>map1, Map<Character, Integer> map2, char c)
	
	{
		if (map2.containsKey(c) && map2.get (c) != 0)
			map2.put (c, map2.get (c) - 1);
		else
		{
			if (map1.containsKey(c))
				map1.put (c, map1.get (c) + 1);
			else
				map1.put (c, 1);
		}
		
	}
	
	public boolean crossCheck (Map <Character, Integer> map)
	{
		boolean check = true;
		
		for (Character key : map.keySet())
			if (map.get(key) != 0)
			{
				check = false;
				break;
			}
		return check;
	}

}
