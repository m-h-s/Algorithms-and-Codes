import java.util.*;
/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 08
 * 
 * License: Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class CycleDetectorInDAGS2 implements CycleDetectorInDAG {


	/**
	 * Problem: Course Schedule
	 * 
	 * 
	 * Description:
	 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
	 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses? 
	 * 
	 * 
	 * Solution:
	 * Main Idea: Courses can be finished if there is no cycle in the graph of the course dependencies.
	 * The solution should find and detect a cycle in a directed graph.
	 * If no such cycle exists, then the given courses can be finished.
	 * To find such cycle, we find nodes with inDegree of zero and remove these nodes and their related edges from the graph.
	 * We continue this process until all nodes are removed.
	 * If there is no node with inDegree of zero in the remaining graph, it means there is a cycle in the graph.
	 * 
	 * 
	 * Strategy 1:
	 * 
	 * 1 - Consider a map or array of adjacency for the graph; i.e.; Map of <node, List <node>>.
	 * The keys are source nodes and the values are destination nodes the edges starting from the source.
	 * 
	 * 2 - Consider a map or array of inDegrees for the graph; i.e; Map <node, Integer>.
	 * 
	 * 3- For each edge in the prerequisite array, update adjacency and inDegree tables.
	 * 
	 * 4- Consider a counter for the number of nodes with inDegree of Zero.
	 * 
	 * 5- Scan the inDegree Table, find all the nodes with inDegree of zero.
	 * 
	 * 6- If no node with inDegree zero exists and the counter defined in step 4- is not equal to the total number of courses,
	 * return false; i.e.; there is a cycle in the graph.
	 * 
	 * 7- Update the counter defined in step 4-.
	 * 
	 * 8- Remove the nodes with inDegree of Zero and the edges starting from them by decreasing the inDegree of their neighbors.
	 * 
	 * 9- Go to 5- and continue.
	 * 
	 * 10- If the  counter identified in 4- equals to the number of courses return true.
	 * 
	 *           
	 */

	ArrayList <Integer> [] graph;
	int [] inDegrees;
	boolean canBeFinished;


	@Override
	public boolean canFinish(int numCourses, int[][] prerequisites) {


		if (prerequisites.length == 0)
			canBeFinished = true;
		else
		{
			graph = new ArrayList [numCourses];
			inDegrees = new int [numCourses];

			for (int i = 0;  i < prerequisites.length; i++ )
			{
				int source = prerequisites [i][1];
				int dest = prerequisites [i][0];

				if (graph [source]  == null)
					graph [source] = new ArrayList <Integer> ();

				graph [source].add(dest);
				inDegrees [dest]++;


			}


			int counter = 0;
			while (counter < numCourses)
			{
				List <Integer>  nodesToBeRemoved = findDegreeZeros (numCourses);

				if  ( nodesToBeRemoved.isEmpty())
				{ 
					canBeFinished = false;
					break;
				}

				counter += nodesToBeRemoved.size();

				updateIndegrees (nodesToBeRemoved);

			}

			if ( counter  == numCourses)
				canBeFinished = true;
		}

		return canBeFinished;

	}



	List <Integer> findDegreeZeros (int numCourses)
	{
		List <Integer> degreeZero= new ArrayList <Integer> ();
		for (int i  =  0 ;  i < numCourses; i++ )
		{
			if ( inDegrees [i] == 0 )
			{
				degreeZero.add(i);
				inDegrees [i] = -1;
			}
		}

		return degreeZero;
	}



	void updateIndegrees (List <Integer> removedSourceNodes)
	{
		for (int i = 0; i < removedSourceNodes.size (); i++ )
		{
			ArrayList <Integer>  dests = graph [removedSourceNodes.get(i)];
			if (dests != null)
			{
				for (int j = 0; j < dests.size(); j++)
					inDegrees [dests.get(j)]--;	
			}

		}
	}

}
