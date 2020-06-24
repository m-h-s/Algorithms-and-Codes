/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 05 - 13
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 * 
 *
 */
public class CountWaysS2 implements CountWays {

	/**
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
	 * 
	 * 
	 * Main idea:
	 * There are two distinct groups of ways to reach to step n:
	 *   1- The last step is 1-step long.
	 *   2- The last step is 2-step long.
	 * 
	 * If the last step is 1-step long, we should count the number of distinct ways to reach step n-1.
	 * If the last step is 2-step long, we should count the number of distinct ways to reach n-2.
	 * 
	 * => # ways to reach step n = #  ways to reach step n-1 + # ways to reach step n-2
	 * =>  F (n) = F (n-1) + F (n-2);  F (1) = 1; F (2) = 2;
	 * 
	 * 
	 * Steps:
	 * 1- F (1) = 1;
	 * 2- F (2) = 2;
	 * 3- For i = 3 to n 
	 *    F (i) = F (i - 1) + F ( i - 2 );
	 * 4- Return F (n);
	 * 
	 */


	@Override
	public int climbStairs(int n) {

		int Fn, Fn_1, Fn_2;
		Fn = 0; // This line is added only for the sake of mandatory initialization.
		Fn_2 = 1;
		Fn_1 = 2;

		for (int i = 3; i <= n ; i++)
		{
			Fn = Fn_2 + Fn_1;
			Fn_2 = Fn_1;
			Fn_1 = Fn;
		}

		if (n == 2 )
			Fn = Fn_1;

		else if (n == 1 )
			Fn = Fn_2;

		return Fn ;
	}

}
