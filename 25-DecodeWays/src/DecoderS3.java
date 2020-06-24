/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 17
 * 
 * License: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class DecoderS3 implements Decoder {


	/**
	 * Problem: Decode Ways
	 * 
	 * 
	 * Description:
	 *  
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
	 * 'A' -> 1
	 * 'B' -> 2
	 * ...
	 * 'Z' -> 26
	 * 
	 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
	 * 
	 * 
	 * 
	 * 
	 * Solution:
	 * 
	 * Main Idea:
	 * In some cases F (n) = F (n + 1) + F (n + 2);         if char [n] and char [n+1] >= 1 and <= 26.
	 * In some cases F (n) = F (n + 1);                     if char [n] >= 3 or if char [n] and char [ n+1 ] >= 27 
	 * In some cases F (n) = F (n + 2);                     if char [n] and char [n+1] = 10 or 20;
	 * In one case F (n) = 0;                               if char [n] = 0;
	 * 
	 * 1- Consider an array of integer, called number of decodings, having the length of the given string.
	 * 
	 * 2- Start from the end of the given string, and scan the last character.
	 * 
	 * 3- If the number that the last char represents is between 1 and 9 then set the related cell in the number of decodings to 1.
	 * 
	 * 4- else if the number is zero then set the related cell to 0.
	 * 
	 * 5- Move to the previous char.
	 * 
	 * 6- If the number that the current char represents is greater or equal to three or if the current char is 2 and the next char is 7 or higher then
	 *      number of decodings [i] =  number of decodings [ i+1 ], since there is only one way to decode this char, and that way is to remove the current char alone.
	 * 
	 * 7- Else if the number the current char represents is 0, then
	 *      number of decodings [i] = 0, since there is no valid decoding for this char.
	 * 
	 * 
	 * 8- Else if the number that the current char and the next char represent is 10 or is 20, then 
	 *      number of decodings [i] = number of decodings [ i+2 ], since there is only one way to decode the current char and that way is to decode it together with the next char.
	 * 
	 * 9- Else if the number the current char and the next char represent is between 1 and 26, then 
	 *      number of decodings [i] = number of decodings [ i+1 ] + number of decodings [ i+2 ], since there are two ways to decode the current char
	 *      1- to decode the current char alone and go to the next char , or
	 *      2- to decode the current char with the next char, and then go to the char after the next char.
	 *      
	 * 10- Go to 5- and continue until all of the string is scanned.
	 * 
	 * 11- Return number of decodings [0];
	 *    
	 */

	@Override
	public int numDecodings(String s) {


		int [] numberOfDecodings = new int [s.length()];
		int currentNum, nextNum;

		currentNum = Integer.parseInt(s.charAt(s.length() - 1 )+"");
		if ( currentNum != 0 )
			numberOfDecodings [s.length() - 1 ] = 1;
		else
			numberOfDecodings [s.length() - 1 ] = 0;


		for (int i = s.length() - 2; i >= 0; i--)
		{ 	 
			nextNum = currentNum;
			currentNum =  Integer.parseInt(s.charAt(i) +"");


			if (currentNum == 0)
				numberOfDecodings [i] = 0; 
			else 
			{
				if ( currentNum >= 3 || 
						(currentNum == 2 && nextNum  >= 7 )
						)
					numberOfDecodings [i] = numberOfDecodings [i + 1];

				else if ( 
						i + 2 <= s.length() - 1 && 
						( ( currentNum == 1 || currentNum == 2 ) && nextNum == 0) 
						)
					numberOfDecodings [i] = numberOfDecodings [i + 2];

				else
				{ 
					if ( i + 2 <= s.length() - 1)
						numberOfDecodings [i] = numberOfDecodings [i + 1] + numberOfDecodings [i + 2];
					else
					{ 
						if ( ( currentNum == 1 || currentNum == 2 ) && nextNum == 0)
							numberOfDecodings [i] = 1;	
						else
							numberOfDecodings [i] = 2;	
					}
				}
			}
		}


		return numberOfDecodings [0];
	}

}
