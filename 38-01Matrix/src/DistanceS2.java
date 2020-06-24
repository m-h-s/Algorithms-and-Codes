import java.util.*;
/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 17
 * 
 * License : Creative Commons
 * 
 * Copyright by Mahsa Sadi
 * 
 */
public class DistanceS2 implements Distance {

	int [][] distance;
	boolean [][] visited;
	List <Tuple> queue;
	int maxDistance;

	@Override
	public int[][] updateMatrix(int[][] matrix) {
		/**
		 * 
		 * ############# Note: This strategy is more time-efficient than the strategy one. ##############
		 * Note: In this implementation we consider a separate matrix for checking whether a cell has been visited or not.
		 * 
		 * Problem: 01 Matrix
		 * 
		 * Description:
		 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
		 * The distance between two adjacent cells is 1.
		 * 
		 * 
		 * Solution:
		 * 
		 * 
		 * Main Idea:
		 * 
		 * 1- Find all zero cells first.
		 * 2- Start from these cells and perform a breadth-first visit of their neighbors.
		 * 3- While visiting the neighbors calculate their distance.
		 * 4- Continue until all cells are visited.
		 * 
		 * 
		 * Steps: 
		 * 
		 * 1- Consider a distance array which is the same size as the given matrix.
		 * 
		 * 2- Find all zeros in the given matrix.
		 * 
		 * 3- Set the related cell to each zero cell in the matrix to 0 in the distance array.
		 * 
		 * 4- Enqueue the neighbors of zero cells.
		 * 
		 * 
		 * 
		 * 5- while the queue is not empty.
		 * 
		 *    1- dequeue the first cell.
		 *    
		 *    2- Find its nearest distance to a zero cell.
		 *    
		 *    3-Enqueue its neighbors if the distance of the neighbors is not identified yet.
		 *    
		 * 6- Return the distance array.
		 * 
		 */

		this.distance  = new int [matrix.length][matrix[0].length];
		this.visited = new boolean [matrix.length][matrix[0].length];
		maxDistance = Math.max(matrix.length, matrix[0].length) * 2;
		queue  = new ArrayList <Tuple> ();


		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix [0].length; j++)
			{
				if (matrix [i][j] != 0 )
					distance [i][j] = maxDistance;
				else
				{
					distance [i][j] = 0;
					visited [i][j] = true;
					enqueueNeighbors (matrix, i, j);
				}
			}


		while (! queue.isEmpty())
		{
			Tuple t = queue.remove(0);
			findDistance(matrix, t);
			enqueueNeighbors (matrix, t.i, t.j);
		}


		return distance;
	}


	public void enqueueNeighbors (int[][] matrix, int i , int j)
	{


		if (i - 1 >= 0   &&   !visited [i - 1] [j] && matrix [i-1] [j] != 0 )
		{ queue.add(new Tuple (i-1, j));
		visited [i- 1] [j] = true;
		}

		if ( j - 1 >= 0 && !visited [i] [j - 1] && matrix [i] [j - 1] != 0  )
		{
			queue.add(new Tuple (i, j-1));
			visited [i] [j - 1] = true;
		}

		if ( i + 1 < matrix.length && !visited [i + 1] [j] && matrix [i + 1] [j] != 0  )
		{ 
			queue.add(new Tuple (i+1, j));
			visited [i + 1] [j] = true;
		}

		if ( j + 1 < matrix[0].length  && !visited [i] [j + 1] && matrix [i] [j +  1] != 0   )
		{ 
			queue.add(new Tuple (i, j+1));
			visited [i] [j + 1] = true;
		}
	}


	public void findDistance (int [][] matrix, Tuple t)
	{
		int row = t.i;
		int col = t.j;
		int n1,n2,n3,n4;

		if ( row - 1 >= 0)
			n1 = distance[row - 1][col];
		else
			n1 = maxDistance;

		if ( col - 1 >= 0 )
			n2 = distance[ row ][ col - 1 ];

		else
			n2 = maxDistance;


		if ( row + 1 < matrix.length) 
			n3 = distance[ row + 1 ][col];

		else
			n3 = maxDistance;

		if ( col + 1 < matrix[0].length ) 
			n4 = distance[ row ][ col + 1 ];

		else
			n4 = maxDistance;


		distance [row][col] = Math.min ( Math.min (n1, n2 ), Math.min (n3, n4 )) + 1 ;


	}

	public class Tuple 
	{
		public int i;
		public int j;


		public Tuple (int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}


}
