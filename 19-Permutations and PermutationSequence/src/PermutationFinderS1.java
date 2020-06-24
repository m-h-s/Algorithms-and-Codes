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

public class PermutationFinderS1 implements PermutationFinder {



	/**
	 * 
	 * ########### This solution is brute force and it is not time efficient.##############
	 * 
	 * 
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
	 *    Brute Force:
	 *       Generate All mutations and count them until the wanted mutation is reached.
	 */


	List <Integer> permutationsList;
	int counter;
	String permutationKth;

	@Override
	public String getPermutation(int n, int k) {

		List <Integer> sequence = new ArrayList <Integer> ();
		permutationsList = new ArrayList <Integer> ();

		for (int i = 1; i <= n; i++)
			sequence.add(i);

		findPermutations ("", sequence, k);

		return permutationKth;
	}


	public void findPermutations (String p, List <Integer> s, int k)
	{


		for (int i = 0; i < s.size (); i++)
		{ 
			List <Integer> copy = new ArrayList <Integer> (s);   
			copy.remove(i);
			findPermutations (p + s.get(i), copy, k);
		}

		if (s.isEmpty())
		{
			permutationsList.add(Integer.valueOf(p));
			counter++;
			if (counter == k)
				permutationKth = p;
		}

	}


	public void printPermutationsList ()
	{
		for (int i = 0; i < this.permutationsList.size(); i++)
			System.out.println(this.permutationsList.get(i));
	}

}
