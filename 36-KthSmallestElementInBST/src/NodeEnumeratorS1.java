/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 09
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 * 
 * 
 * 
 *
 */
public class NodeEnumeratorS1 implements NodeEnumerator {

	int counter = 0;
	int kSmallest;
	@Override
	public int kthSmallest(TreeNode root, int k) {
		/**
		 * Problem: Kth Smallest Element in a BST
		 * 
		 * 
		 * Description:
		 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
		 * 
		 * 
		 * Solution:
		 * 1-Consider a counter initialized to zero.
		 * 2-Perform an In-order traversal and assign a number to each node.
		 * 
		 */

		enumerate (root, k);
		return kSmallest;
	}


	public void enumerate (TreeNode n, int k)
	{

		if (n != null)
		{
			enumerate (n.left, k);
			counter++;
			if (counter == k)
				kSmallest = n.val;
			else
				enumerate(n.right, k);
		}
	}

}
