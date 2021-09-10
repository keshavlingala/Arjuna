/*
 * 
Given a list of flight tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from BZA. Thus, the itinerary must begin with BZA.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["BZA", "LGA"] has a smaller lexical order than ["BZA", "LGB"].

All airports are represented by three capital letters.
You may assume all tickets form at least one valid itinerary.

Example 1:

Input:4
DEL HYD
BZA DEL
BLR MAA
HYD BLR

Output: ["BZA", "DEL", "HYD", "BLR", "MAA"]

Example 2:

Input:5
BZA BLR
BZA CCU
BLR CCU
CCU BZA
CCU BLR
Output: ["BZA","BLR","CCU","BZA","CCU","BLR"]

              
             
 */

package Elite2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReconstructItinerary {

	public static  List<String> findItinerary(String[][] tickets) {
	    Map<String, PriorityQueue<String>> targets = new HashMap<>();
	    for (String[] ticket : tickets)
	        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
	    List<String> route = new LinkedList();
	    Stack<String> stack = new Stack<>();
	    stack.push("BZA");
	    while (!stack.empty()) {
	        while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
	            stack.push(targets.get(stack.peek()).poll());
	        route.add(0, stack.pop());
	    }
	    return route;
	}
	
	  public static void main(String args[] ) throws IOException {
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int n=Integer.parseInt(br.readLine());
				String[][] tickets = new String[n][2];
				

			       for(int i=0; i<n; i++)
			       {
			        	  String line=br.readLine();
			        	  String words[]=line.split(" ");
			        	  tickets[i][0]=words[0];
			        	  tickets[i][1]=words[1];			             
			       }
			      System.out.println(findItinerary(tickets));
		}
	
}
