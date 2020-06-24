/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 -05 - 13
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class CountWaysS1 implements CountWays {
	
	/**
	 * ###########  Note: This solution is brute force and is not time-efficient. ##########
	 * 
	 * Problem: Climbing Stairs
	 * 
	 * @see https://leetcode.com/problems/climbing-stairs/
	 * 
	 * 
	 * Description:
	 * 
	 * 
	 * You are climbing a stair case. 
	 * It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. 
	 * In how many distinct ways can you climb to the top?
	 * 
	 * 
	 * Note: Given n will be a positive integer.
	 * 
	 * 
	 * Solution:
	 * Main Idea: 
	 * Count all the possible ways, by taking one-step and two-step long steps until step n is reached.
	 * Return back and try a different way.
	 * 
	 */
	
	int distinctWays  = 0 ;

	@Override
	public int climbStairs(int n) {
		
		
		countWays (n);
		return this.distinctWays;
	}
	
	
	public void countWays (int n)
	{
		if (n == 0 )
			this.distinctWays++;
		
		else
		{
			for (int i =  1; i<= 2 ; i++)
				if (n - i >= 0)
					countWays (n - i);
		}
	}

}
