import java.util.*;
/**
 * @author Mahsa Sadi
 * 
 * @since 2020 - 04 - 14
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 */

public class ArrangementFinderV1 implements ArrangementFinder {


	/**
	 * Problem: Beautiful Arrangement
	 * 
	 * Description:
	 * 
	 * Suppose you have N integers from 1 to N. 
	 * We define a beautiful arrangement as an array that is constructed by these N numbers successfully 
	 * if one of the following is true for the ith position (1 <= i <= N) in this array:
	 *		The number at the ith position is divisible by i.
	 *		i is divisible by the number at the ith position.
	 *
	 * Now given N, how many beautiful arrangements can you construct?
	 *
	 * Note:
	 *     N is a positive integer and will not exceed 15.
	 *     
	 *     
	 *     
	 * Solution:
	 * 
	 * Main Idea: 
	 * 
	 * 1- Find the numbers with the strictest constraints. 
	 * 2- Start from them and arrange them in the array.
	 * 3- Eliminate them from the numbers that need to be arranged.
	 * 4- Go to 1- and continue until all the numbers are arranged in the array.
	 * 5- Try all the possible cases for arranging the numbers by undoing the decisions taken in the previous steps one by one.
	 * 
	 * Note: Some times backtracking is required since some numbers cannot be arranged in the array.
	 * 
	 * 
	 * Steps:
	 * 1- Find the divisors and multiples of all the numbers from 1 to N and put them in a table.
	 * This table identifies the location where a number can be put.
	 * 2- Sort the divisors table according the number of divisors and multiples of the numbers in an ascending order.
	 * 3- Start from the numbers with the smallest number of divisors and arrange them in the array.
	 * 4- Continue until all the numbers are arranged.
	 * 5- If all the numbers are arranged count the arrangement as one beautiful arrangement. 
	 * 6- Undo the last arrangement and try a different one.
	 * 7-Continue until all the possible arrangements have been tried.
	 * 
	 * 
	 */


	SortedMap <Integer, List <Integer>> constraints;

	List <List <Integer>> sortedConstraints;

	int NumberOflegitimatePaths;

	List <List <Integer>> legitimatePaths;

	int N;


	@Override
	public int countArrangement(int N) {


		this.N = N;

		constraints = new TreeMap <Integer, List <Integer>> (Collections.reverseOrder());

		/*
		 * 1- Find divisors and multiples of numbers between 1 and N.
		 *    Put them in a map.
		 */

		for (int i = N; i >= 1; i--)
		{	

			List <Integer> divisorsAndMultiples = new ArrayList <Integer> ();

			for (int j = 1; j <= N; j++)
				if (j % i == 0 || i % j == 0)
					divisorsAndMultiples.add(j);

			constraints.put(i, divisorsAndMultiples);

		}

		/*
		 * 2- Sort multiples and divisors based on the length of the set using
		 *    insertion sort.
		 */
		sortedConstraints = new ArrayList<List<Integer>> ();

		for (Integer key : constraints.keySet())
		{
			List <Integer> currentConstraints = constraints.get(key);




			if (sortedConstraints.isEmpty())
				sortedConstraints.add(currentConstraints);
			else 
			{
				boolean added = false;

				for (int i = sortedConstraints.size() - 1; i >= 0; i--)
				{


					if (currentConstraints.size() >= sortedConstraints.get(i).size ())
					{
						if (i < currentConstraints.size() - 1 )	
							sortedConstraints.add(i + 1, currentConstraints);
						else
							sortedConstraints.add(currentConstraints);

						added = true;
						break;
					}
				}

				if (!added)
					sortedConstraints.add(0, currentConstraints);
			}
		}

		/*
		 * 3- Start building all legitimate paths and count them
		 */

		legitimatePaths = new ArrayList <List <Integer>> ();
		BuildLegitimatePaths (sortedConstraints, new ArrayList <Integer> ());


		return NumberOflegitimatePaths;
	}


	void BuildLegitimatePaths ( List<List <Integer>> constraintsSet, ArrayList <Integer> builtPath)
	{

		if (constraintsSet.isEmpty() )
		{
			if (builtPath.size() == N)
			{
				legitimatePaths.add(new ArrayList (builtPath));
				NumberOflegitimatePaths ++;
			}

		}

		else
		{

			for (int i = 0 ; i < constraintsSet.get(0).size(); i++)
			{
				if (builtPath.isEmpty() || ! builtPath.contains(constraintsSet.get(0).get(i)))
				{ 
					builtPath.add(constraintsSet.get(0).get(i));

					BuildLegitimatePaths (constraintsSet.subList(1, constraintsSet.size()),builtPath);

					builtPath.remove(builtPath.size() - 1);
				}


			}
		}
	}


	void printNestedList (List <List <Integer>> nestedList)
	{
		for (int i = 0; i < nestedList.size (); i++)
		{
			System.out.print ("[ ");

			for (int j = 0; j < nestedList.get(i).size(); j++)
				System.out.print (nestedList.get(i).get(j) + " ");

			System.out.print ("]" + "\n");
		}
		System.out.println ("*******************");
	}

}
