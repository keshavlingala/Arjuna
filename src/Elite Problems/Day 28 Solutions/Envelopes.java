/*
 * 
 You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you put one inside other

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: 
The maximum number of envelopes you can put one inside other is 3 ([2,3] => [5,4] => [6,7]).


 */


import java.util.*;

public class Envelopes {
	 public static int lengthOfLIS(int[] nums) {
	        int[] dp = new int[nums.length];
	        int len = 0;
	        for (int num : nums) {
	            int i = Arrays.binarySearch(dp, 0, len, num);
	            if (i < 0) {
	                i = -(i + 1);
	            }
	            dp[i] = num;
	            if (i == len) {
	                len++;
	            }
	        }
	        return len;
	    }

	    public static int maxEnvelopes(int[][] envelopes) {
	        // sort on increasing in first dimension and decreasing in second
	        Arrays.sort(envelopes, new Comparator<int[]>() {
	            public int compare(int[] arr1, int[] arr2) {
	                if (arr1[0] == arr2[0]) {
	                    return arr2[1] - arr1[1];
	                } else {
	                    return arr1[0] - arr2[0];
	                }
	           }
	        });
	        // extract the second dimension and run LIS
	        int[] secondDim = new int[envelopes.length];
	        for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];
	        return lengthOfLIS(secondDim);
	    }
	    
	
	/*
	 * public static int maxEnvelopes(int[][] envelopes) {
	    if(envelopes == null || envelopes.length == 0 
	       || envelopes[0] == null || envelopes[0].length != 2)
	        return 0;
	    Arrays.sort(envelopes, new Comparator<int[]>(){
	        public int compare(int[] arr1, int[] arr2){
	            if(arr1[0] == arr2[0])
	                return arr2[1] - arr1[1];
	            else
	                return arr1[0] - arr2[0];
	       } 
	    });
	    int dp[] = new int[envelopes.length];
	    int len = 0;
	    for(int[] envelope : envelopes){
	        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
	        if(index < 0)
	            index = -(index + 1);
	        dp[index] = envelope[1];
	        if(index == len)
	            len++;
	    }
	    return len;
	}
	*/
	public static void main(String args[] ) {
		 Scanner scan = new Scanner(System.in);
			int n=scan.nextInt();

			int[][] envelopes=new int[n][2];
		       for(int i=0; i<n; i++)
		       {
		           for(int j=0; j<2; j++)
		           {
		        	   envelopes[i][j] = scan.nextInt();
		           }
		       }
		       System.out.println(maxEnvelopes(envelopes));
	}
	
}
