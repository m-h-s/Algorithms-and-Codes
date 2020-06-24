/**
 * @authro Mahsa Sadi
 * 
 * @since 2020 - 05 - 26
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 * 
 */
import java.util.*;

public class ElementFinderS1 implements ElementFinder {


	/**
	 * 
	 * 
	 * Problem: Majority Element
	 * 
	 * 
	 * Description:
	 * 
	 * Given an array of size n, find the majority element. 
	 * The majority element is the element that appears more than n/2 times.
	 * You may assume that the array is non-empty and the majority element always exist in the array.
	 * 
	 * 
	 * Solution:
	 * 
	 * 1- Consider a frequency table which records the frequency of the observed element.
	 * 2- For each element in the array, record and update the frequency of that element.
	 * 3- If the frequency of an element exceeds the length of the array divided by two, that element is the majority element.
	 * 
	 * Time Complexity: O (n)
	 * 
	 * 
	 * 
	 */

	@Override
	public int majorityElement(int[] nums) {

		int majorityElement = -1;

		Map <Integer, Integer> stat = new HashMap <Integer, Integer> ();

		int i = 0;

		boolean found = false;

		while (i < nums.length && !found)
		{

			int count = 1;

			if (stat.containsKey(nums[i])) 
				count = stat.get(nums[i]) + 1;

			stat.put(nums [i], count);

			if (count > nums.length / 2)
			{ 
				majorityElement = i;
				found = true;
			}

			i++;

		}

		return nums [majorityElement];
	}

}
