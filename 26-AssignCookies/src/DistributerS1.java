/**
 * @author Mahsa Sadi
 * 
 * @since 2020 - 05 - 08
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 */



import java.util.*;
import java.util.Collections;

import ArrayOperations.*;

public class DistributerS1 implements Distributer {

	int numberOfContentChildren = 0;

	public int findContentChildren(int[] g, int[] s) {
		/**
		 * Problem: Assign Cookies
		 * 
		 * Description:
		 * Assume you are an awesome parent and want to give your children some cookies. 
		 * But, you should give each child at most one cookie. 
		 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; 
		 * and each cookie j has a size sj. 
		 * If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. 
		 * Your goal is to maximize the number of your content children and output the maximum number.
		 * 
		 * Note: 
		 * You may assume the greed factor is always positive. 
		 * You cannot assign more than one cookie to one child.
		 * 
		 * 
		 * @see https://leetcode.com/problems/assign-cookies/
		 * 
		 * Solution:
		 * 
		 * 1- Sort cookie size
		 * 2- Sort Greed Factors
		 * 3- Assign the minimum size to the minimum Greed Factor that matches the size.
		 * 4- Increase count
		 * 5- Continue until all the sizes are checked.
		 * 6- Return count
		 *
		 */



		int i, j;
		i = j = 0;
		boolean assigned;
		int next = 0;


		Arrays.sort(g);

		Arrays.sort(s);

		while (i < s.length && next < g.length )
		{

			assigned = false;

			j = next;
			while (j < g.length && !assigned )
			{

				if (s [i] >= g [j])
				{
					this.numberOfContentChildren ++;
					assigned = true;
					next = j + 1;
				}

				else
					j++; 
			}


			i++;
		}

		return numberOfContentChildren;
	}

}
