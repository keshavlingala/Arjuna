/*
You have a set of tiles, where each tile has one letter tiles[i] printed on it.  
Return the number of possible non-empty sequences of letters you can make.


Example 1:
Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: "AAABBC"
Output: 188

 
Note:
    1 <= tiles.length <= 7
    tiles consists of uppercase English letters.


*/

class LetterTilePossibilities
{
	public static int numTilePossibilities(String tiles) {
		int[] count = new int[26];
		for (char c : tiles.toCharArray()) count[c - 'A']++;
		return dfs(count);
	}
    
	int dfs(int[] arr) {
		int sum = 0;
		for (int i = 0; i < 26; i++) {
		    if (arr[i] == 0) continue;
		    sum++;
		    arr[i]--;
		    sum += dfs(arr);
		    arr[i]++;
		}
		return sum;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(Syetm.in);
		String s=sc.next();
		System.out.println(numTilePossibilities(s));
	}
}