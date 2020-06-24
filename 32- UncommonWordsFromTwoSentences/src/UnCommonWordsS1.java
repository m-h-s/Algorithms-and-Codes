/**
 * @author: Mahsa Sadi
 * 
 * @since: 2020 - 06 - 02
 * 
 * License: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 */


import java.util.*;
public class UnCommonWordsS1 implements UnCommonWords {

	/**
	 * 
	 * Problem: Uncommon Words from Two Sentences
	 * 
	 * 
	 * Description:
	 * We are given two sentences A and B. 
	 * (A sentence is a string of space separated words.  
	 * Each word consists only of lower case letters.)
	 * A word is uncommon if it appears exactly once in one of the sentences, 
	 * and does not appear in the other sentence.
	 * Return a list of all uncommon words. 
	 * You may return the list in any order.


	 * 
	 * Solution:
	 * 
	 * 1 - Consider a frequency map from a String to a pair of Integers.
	 * A pair represent the count of a word in each of the two input arrays.
	 * 2-  Split each sentence by space and put into two arrays.
	 * 3-  Update the pair related to the count of each word in the frequency map. 
	 * 4-  Return the keys in the map whose sum of pair is exactly one.
	 * 
	 */


	List <String> unCommonWords;
	Map <String, Pair> frequency = new HashMap <String, Pair> ();
	String [] AWords, BWords;


	@Override
	public String[] uncommonFromSentences(String A, String B) {


		AWords = A.split(" ");
		BWords = B.split(" ");

		this.unCommonWords = new ArrayList <String> ();


		int i;
		int minLength = Math.min (AWords.length, BWords.length);

		for (i = 0 ; i < minLength ; i++)
		{ 
			putInFrequencyMapA (i);
			putInFrequencyMapB (i);
		}

		for (int j = i; j < AWords.length; j++)
			putInFrequencyMapA (j);



		for (int j = i; j < BWords.length; j++)
			putInFrequencyMapB (j);


		int k = 0;


		for (String key : this.frequency.keySet())
		{
			if  ( this.frequency.get(key).sumOfValues() == 1)
			{ 
				this.unCommonWords.add(key);
			}

		}


		return this.unCommonWords.toArray(new String [this.unCommonWords.size()]);
	}



	public void putInFrequencyMapA (int index)
	{
		if (! frequency.containsKey(AWords [index]))
		{
			frequency.put(AWords [index], new Pair (1,0));
		}

		else
		{
			Pair vals = frequency.get(AWords [index]);
			vals.increaseValue1();

		}


	}

	public void putInFrequencyMapB (int index)
	{
		if (! frequency.containsKey(BWords [index]))
		{
			frequency.put(BWords [index], new Pair (0,1));
		}

		else
		{
			Pair vals = frequency.get(BWords [index]);
			vals.increaseValue2(); 
		}
	}

	public class Pair {

		private Integer value1, value2;

		public Pair (int i, int j)
		{
			value1 = i;
			value2 = j;
		}


		public void increaseValue1 ()
		{
			this.value1++;
		}

		public void increaseValue2 ()
		{
			this.value2++;
		}

		public Integer getValue1 ()
		{
			return value1;
		}

		public Integer getValue2 ()
		{
			return value2;
		}

		public Integer sumOfValues ()
		{
			return this.value1 + this.value2;
		}

	}

}
