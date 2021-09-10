import java.util.*;
class ThirdMaxNumber {

    static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
    public static void main(String args[])
    {
	Scanner sc=new Scanner(System.in);
	String[] str=sc.nextLine().split(" ");
	int arr[]=new int[str.length];
	int i=0;
	for(String s:str){
	    arr[i]=Integer.parseInt(s);
	    i++;
	}
	System.out.print(thirdMax(arr));
    }
}
