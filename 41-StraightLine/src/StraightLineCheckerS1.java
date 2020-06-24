/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 23 
 * 
 * License: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class StraightLineCheckerS1 implements StraightLineChecker {

	@Override
	public boolean checkStraightLine(int[][] coordinates) {

		boolean isStraight = true;
		if (coordinates.length > 2)
		{
			double previousSlope, currentSlope;
			previousSlope  = 0 ;

			for (int i = 0; i < coordinates.length - 1; i++)
			{
				double deltaY = (coordinates [i+1][1] - coordinates [i][1]);
				double deltaX = (coordinates [i+1][0] - coordinates [i][0]);

				if (deltaY == 0)
					currentSlope = 999999;
				
				else if  (deltaX == 0)
					currentSlope = 0;
				
				else
					currentSlope =  deltaY / deltaX;


				if (i > 0) 
				{

					if (previousSlope  != currentSlope )
					{ 
						isStraight = false;
						break;
					}

				}

				previousSlope = currentSlope;
			}
		}

		return isStraight;
	}

}
