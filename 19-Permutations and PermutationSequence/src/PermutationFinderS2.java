/**
 * @author Mahsa Sadi
 * 
 * @since 2020 - 04 - 09
 * 
 * License: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 * 
 * 
 *
 */
import java.util.*;

public class PermutationFinderS2 implements PermutationFinder {

	/**
	 * Problem: Permutation Sequence
	 * 
	 * 
	 * Description:
	 * 
	 * The set [1,2,3,...,n] contains a total of n! unique permutations.

	   By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
	    "123"
		"132"
		"213"
		"231"
		"312"
		"321"
	 * 
	 * Given n and k, return the kth permutation sequence.
	 * 
	 * Note:
	 *     Given n will be between 1 and 9 inclusive.
	 *     Given k will be between 1 and n! inclusive.
	 * 
	 * 
	 * 
	 * Solution:
	 * 
	 * Main Idea:
	 *  floor (k / (n-1)!) + 1 identifies the first number in the kth permutation sequence. 
	 *  floor ( k % (n-1) ! / (n-2)!) identifies the second number in the kth sequence.
	 *  floor (k % (n-1) ! / (n-2)! / (n-3) !) identifies the third number in the kth sequence.
	 *  and so on.....
	 *  
	 *  
	 *  
	 * 
	 * 1- Consider a list of integers containing numbers 1, ..., n.
	 * 
	 * 2- Calculate floor (k / (n-1)!)
	 * 
	 * 3- Calculate k % (n-1)!
	 * 
	 * 4- If k > 0
	 * 
	 *   add element number floor (k / (n-1)!)
	 *   remove the added element from the list of numbers
	 *   n = n-1
	 *   k = k % (n-1) !
	 *   go to (2-)
	 *   
	 * 5- else (i.e; k = 0) 
	 *   add element number floor (k / (n-1)! - 1)
	 * 
	 * 6- add whatever element that has not been added in reverse order.
	 * 
	 * @see: https://leetcode.com/problems/permutation-sequence/
	 * 
	 * 
	 */

	@Override
	public String getPermutation(int n, int k) {

		String KthPermutation = "";
		List <String> letters = new ArrayList <String> ();
		int iMinusOneFactorial = getFactorial (n);

		for (int i = 1; i <= n; i++)
			letters.add(String.valueOf(i));

		for (int i = n-1; i > 0; i--)
		{
			iMinusOneFactorial = iMinusOneFactorial / (i+1);

			if ( k >= iMinusOneFactorial) 
			{
				int number = Math.floorDiv(k , iMinusOneFactorial);
				k =  k % iMinusOneFactorial;

				if( k > 0)
					KthPermutation += letters.remove(number);

				else
				{ 
					KthPermutation += letters.remove(number - 1);
					break;
				}
			}

			else
			{ 
				KthPermutation += letters.remove(0);
			}


		}


		for(int i = letters.size() - 1; i >= 0; i-- )
			KthPermutation += letters.remove(i);

		return KthPermutation;
	}


	public int getFactorial (int n)
	{
		int result = 1;

		for (int i = n; i > 0; i--)
			result *= i;

		return result;
	}

}
