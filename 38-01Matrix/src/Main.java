import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		
		/* int [][] input  = {{0,0,0},
		                   { 0,1,0},
		                   { 0,0,0}};
		*/
		
		int [][] input  = {{ 0,0,0},
		                   { 0,1,0 },
		                   {1,1,1} };
		                
		
		//int [][] input = {{0},{1}};
		
		
		// Distance d = new DistanceS1 ();
		
		Distance d = new DistanceS2 ();
	    int [][] result = d.updateMatrix(input);
	    
	    
	    for (int i = 0; i < result.length; i++)
	      System.out.println(Arrays.toString(result [i]));
		

	}

}
