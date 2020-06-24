import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		
		CycleDetectorInDAG cd = new CycleDetectorInDAGS2 ();
		
		int numCourses = 2;
		int [][] prerequisites = {{1,0},{0,1}};
		//int [][] prerequisites = {{1,0}};
		//int [][] prerequisites = {{0,1}};
		System.out.println (cd.canFinish(numCourses, prerequisites));
		
		
	}

}
