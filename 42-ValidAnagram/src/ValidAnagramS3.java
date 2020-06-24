/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 24
 *
 */
public class ValidAnagramS3 implements ValidAnagram {

	@Override
	public boolean isAnagram(String s, String t) {
		boolean isAnagram = true;
		int [] sMap = new int [26];


		if (s.length() == t.length())
		{
			for (int i = 0; i < s.length (); i++)
				sMap[s.charAt(i) - 97]++;
			
			for (int i = 0; i < t.length (); i++)
				sMap[t.charAt(i) - 97]--;
			
			for (int i = 0; i< sMap.length; i++)
				if (sMap [i] != 0)
				{
					isAnagram = false;
					break;
				}	
		}

		else
			isAnagram = false;

		return isAnagram;
	}


}
