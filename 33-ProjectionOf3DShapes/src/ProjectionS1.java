import java.util.*;
/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 02
 * 
 * license: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 * 
 *
 */

public class ProjectionS1 implements Projection {

	/**
	 * Problem: Projection Area of 3D Shapes
	 * 
	 * 
	 * Description:
	 * 
	 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
	 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
	 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
	 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane. 
	 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
	 * Return the total area of all three projections.
	 * 
	 * 
	 * Solution:
	 * 
	 * 1- projection of 3D bars on x plane  = find the sum of the max number in each column. 
	 * 2- projection of 3D bars on y plane  = find the sum of the max number in each row. 
	 * 3- projection of 3D shape on z plane = the count of those cells whose value is greater than 0.
	 * 4- Return the sum of the above three values;
	 */
	@Override
	public int projectionArea(int[][] grid) {

		int xProjection, yProjection, zProjection;
		xProjection = yProjection = zProjection = 0;

		for (int i = 0;  i < grid.length;  i++)
		{
			int max  = 0;

			for  (int j = 0; j< grid [i].length; j++)
			{ 

				if (grid [i][j] > max)
					max = grid [i][j];

				if (grid [i][j] > 0)
					zProjection++;
			}

			yProjection += max;
		}


		for (int j = 0; j < grid[0].length; j++)
		{ 


			int max  =  0; 

			for (int i = 0; i < grid.length; i++ )
			{ 
				if (grid [i][j] > max)
					max = grid [i][j];
			}

			xProjection += max;
		}


		return xProjection + yProjection + zProjection;
	}

}
