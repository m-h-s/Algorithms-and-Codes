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
import java.util.ArrayList;
import java.util.List;

public class PermutationFinderS3 {

	/**
	 * Problem: Permutations
	 * 
	 * 
	 * Description:
	 * 
	 * Given a collection of **distinct** integers, return all possible permutations.
	 * 
	 * 
	 * Solution:
	 * 
	 * 1- Receive a copy of the input sequence and a copy of the permutation sequence.
	 * 2- Remove the first element from the copy of the input sequence.
	 * 3- Add the removed element to a copy of a permutation sequence. 
	 * 4- If the length of the copy of the permutation sequence is equal to the length of the original input sequence,
     *    add the copy of the permutation sequence to the list of permutations.	 
	 * 5- Repeat the solution (Go to 1-).
	 * 
	 * @see: https://leetcode.com/problems/permutations/
	 * 
	 * 
	 */


	List <List<Integer>> permutationsList;



	public List<List<Integer>> permute(int[] nums)  {

		List <Integer> sequence = new ArrayList <Integer> ();
		permutationsList = new ArrayList <List<Integer>> ();

		for (int i = 0; i < nums.length; i++)
			sequence.add(nums [i]);

		List<Integer> permutation = new ArrayList <Integer> ();
		findPermutations (permutation, sequence);

		return permutationsList;
	}


	public void findPermutations (List<Integer> p, List <Integer> s)
	{


		for (int i = 0; i < s.size (); i++)
		{ 
			List <Integer> copyOfS = new ArrayList <Integer> (s);  
			List <Integer> copyOfP = new ArrayList <Integer> (p);  
			copyOfP.add (s.get(i));
			copyOfS.remove(i);
			findPermutations (copyOfP, copyOfS);
		}

		if (s.isEmpty())
		{
			permutationsList.add(p);
		}

	}


	public void printPermutationsList ()
	{
		for (int i = 0; i < this.permutationsList.size(); i++)
			System.out.println(this.permutationsList.get(i));
	}

}
