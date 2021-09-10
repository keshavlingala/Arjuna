import java.util.*;
class countbits {
    public static int[] countBits(int start,int num) {
        int[] ans = new int[num -start + 1];
        for (int i = 0; start <= num; ++i,++start)
            ans[i] = popcount(start);
        return ans;
    }
    private static int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count)
          x &= x - 1; //zeroing out the least significant nonzero bit
        return count;
    }
    public static void main(String args[])
    {
	Scanner sc=new Scanner(System.in);
	int start=sc.nextInt();
	int end=sc.nextInt();
	for(int n:countBits(start,end))
	System.out.print(n+" ");
    }

}
