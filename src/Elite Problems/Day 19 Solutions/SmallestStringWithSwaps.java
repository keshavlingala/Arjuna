/*

You are given a string s, and an array of pairs of indices in the string pairs 
where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

Example 1:
Input: s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[1] and s[2], s = "bacd"

Example 2:
Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
Output: "abcd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[0] and s[2], s = "acbd"
Swap s[1] and s[2], s = "abcd"

Example 3:
Input: s = "cba", pairs = [[0,1],[1,2]]
Output: "abc"
Explaination: 
Swap s[0] and s[1], s = "bca"
Swap s[1] and s[2], s = "bac"
Swap s[0] and s[1], s = "abc"
 

Constraints:
1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s only contains lower case English letters.
*/
import java.util.*;

class SmallestStringWithSwaps
{
			public String smallestStringWithSwaps(String s, ArrayList<ArrayList<Integer>> pairs) {
				int[] p = new int[s.length()];
				for (int i = 0; i < p.length; i++) p[i] = i;
				for (ArrayList<Integer> pair : pairs) {
					union(p, pair.get(0), pair.get(1));
				}
				Map<Integer, ArrayList<Integer>> map = new HashMap<>();
				for (int i = 0; i < p.length; i++) {
					int fath = find(p, i);
					if (!map.containsKey(fath)) map.put(fath, new ArrayList<Integer>());
					map.get(fath).add(i);
				}
				char[] arr = s.toCharArray();
				for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
					ArrayList<Integer> group = entry.getValue();
					ArrayList<Character> temp = new ArrayList<>();
					for (int ind : group) temp.add(arr[ind]);
					Collections.sort(temp);
					for (int i = 0; i < group.size(); i++) {
						arr[group.get(i)] = temp.get(i);
					}
				}
				return new String(arr);
			}
			public void union (int[] p, int nodeA, int nodeB) {
				int A = find(p, nodeA);
				int B = find(p, nodeB);
				if (A != B) p[A] = B;
			}
			
		public int find(int[] p, int node) {
				if (p[node] == node) return node;
				return p[node] = find(p, p[node]);
		}
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			String s1=sc.next();
			int n=sc.nextInt();
			ArrayList<ArrayList<Integer> > pairs =  new ArrayList<ArrayList<Integer> >(n); 
			for(int i=0;i<n; i++)
			{
					ArrayList<Integer> a=new ArrayList<Integer>();
					a.add(sc.nextInt());
					a.add(sc.nextInt());
					pairs.add(a);
			}
			System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps(s1,pairs));
		}
}