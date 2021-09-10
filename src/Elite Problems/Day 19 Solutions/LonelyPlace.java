/*
There are many islands that are connected by one-way roads, that is, 
if a road connects places 'a' and 'b', then you can only use the road to go from  
'a' to 'b' but you cannot travel back by using the same. If you are on place 'a', 
then you select (uniformly and randomly) one of the places that are directly reachable
from 'a' through the one-way road and move to that place. 
You are stuck on an place if you cannot move any further. 
It is guaranteed that after leaving any place it is not possible to come back to that place.

Find the place that you are most likely to get stuck on. 
Two places are considered equally likely if the absolute difference 
of the probabilities of ending up on them is <=(10^(-9)).

Input format
First line: Three integers 'n' (the number of places),  'm' (the number of one-way roads), 
and 'r' (the index of the place you are initially on)
Next 'm' lines: Two integers 'xi' and 'yi' representing a one-way road from place 'xi' to 'yi' .

Output format
Print the index of the place that you are most likely to get stuck on. 
If there are multiple places,then print them in the increasing order of indices 
(space separated values in a single line).

Sample:
Input= 5 7 1
		1 2
		1 3
		1 4
		1 5
		2 4
		2 5
		3 4
Output= 4
Explanation
There are two places on which you could get stuck- 4 and 5 with 4 being more probable
*/


import java.util.*;
 
class LonelyPlace {
    
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numberOfPlaces = s.nextInt();
		int numberOfRoads = s.nextInt();
		int startingPlace = s.nextInt();
		startingPlace--;
		int[] indegree = new int[numberOfPlaces];
		int[] outdegree = new int[numberOfPlaces];
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
		for (int i = 0; i < numberOfPlaces; i++) {
			adjList.put(i, new LinkedList<Integer>());
		}
		int start;
		int end;
		for (int i = 0; i < numberOfRoads; i++) {
			start = s.nextInt() - 1;
			end = s.nextInt() - 1;
			indegree[end]++;
			outdegree[start]++;
			adjList.get(start).add(end);
		}
		s.close();
		Queue<Integer> placeWithZeroIndegree = new LinkedList<>();
		for (int i = 0; i < numberOfPlaces; i++) {
			if (indegree[i] == 0) {
				placeWithZeroIndegree.add(i);
			}
		}
		double[] probabilty = new double[numberOfPlaces];
		probabilty[startingPlace] = 1;
		while (!placeWithZeroIndegree.isEmpty()) {
			int current = placeWithZeroIndegree.remove();
			for (Integer i : adjList.get(current)) {
				probabilty[i] += (probabilty[current] * ((double)1 / (double)outdegree[current]));
				indegree[i]--;
				if (indegree[i] == 0) {
					placeWithZeroIndegree.add(i);
				}
			}
 
		}
		double max = 0;
		for (int i = 0; i < numberOfPlaces; i++) {
			if (outdegree[i] == 0 && (probabilty[i] > max)) {
				max = probabilty[i];
			}
		}
		for(int i=0;i<numberOfPlaces;i++) {
			if(outdegree[i]==0  && Math.abs(probabilty[i]-max) < 1e-9) {
				System.out.print(i+1+" ");
			}
		}
	}
}