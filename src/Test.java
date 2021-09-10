import java.util.ArrayList;
import java.util.HashSet;

public class Test {
    static String k;

    static int operationMG(int c, int a, int b) {
        if (c == 1) return a + b;
        else if (c == 2) return a - b;
        else if (c == 3) return a * b;
        else return a / b;
    }

    static int[] rearrangeArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (arr[i] > 0) {
                    int j = i + 1;
                    while (arr[j++] > 0) ;
                    int t = arr[j];
                    arr[i] = arr[j];
                    arr[j] = t;

                }
            } else {

            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("s08e02 720".substring(4)));
//        ArrayList<String> ar=new ArrayList<>(10);
//        System.out.println(ar.size());
//        System.out.println(smallestSum(23792, 37221, 10270, 73391));
//        System.out.println(encodeThreeStrings("John", "Johny", "Janardhan"));
//        System.out.println(findPairs(new int[]{2, 5, 6, 4, 8}, 2));
        System.out.println(operationMG(2, 16, 20));
    }

    static int findPairs(int[] arr, int diff) {
        int count = 0;
        HashSet<Integer> hp = new HashSet<>();
        for (int i : arr) hp.add(i);
        for (int j : arr) if (hp.contains(j + diff)) count++;
        return count;
    }

    static int encodeThreeStrings(String input1, String input2, String input3) {
        String[] f = new String[3];
        String[] m = new String[3];
        String[] e = new String[3];
        String[] inputs = new String[]{input1, input2, input3};
        for (int i = 0; i < inputs.length; i++) {
            int l = inputs[i].length();
            String str = inputs[i];
            if (l % 3 == 0) {
                f[i] = str.substring(0, l / 3);
                m[i] = str.substring(l / 3, 2 * l / 3);
                e[i] = str.substring(2 * l / 3, l);
            } else if (l % 3 == 1) {
                f[i] = str.substring(0, l / 3);
                m[i] = str.substring(l / 3, 2 * l / 3 + 1);
                e[i] = str.substring(2 * l / 3 + 1, l);

            } else {
                f[i] = str.substring(0, l / 3 + 1);
                m[i] = str.substring(l / 3 + 1, 2 * l / 3);
                e[i] = str.substring(2 * l / 3, l);
            }
        }
        String outpu1 = f[0] + e[1] + m[2];
        String outpu2 = m[0] + f[1] + e[2];
        String outpu3 = e[0] + m[1] + f[2];
        String output3f = "";
        for (int i = 0; i < outpu3.length(); i++) {
            char c = outpu3.charAt(i);
            if (c >= 'a' && c <= 'z')
                output3f += Character.toUpperCase(c);
            else
                output3f += Character.toLowerCase(c);

        }
        System.out.println(outpu1 + " " + outpu2 + " " + output3f);

        return 0;
    }


    static int smallestSum(int input1, int input2, int input3, int input4) {
        int sum = 0;
        int min1 = Integer.MAX_VALUE, min2 = min1;
        for (int num : new int[]{input1, input2, input3, input4}) {
            min1 = Integer.MAX_VALUE;
            min2 = min1;
            while (num > 0) {
                int d = num % 10;
                if (d < min1) {
                    min2 = min1;
                    min1 = d;
                } else if (d < min2) {
                    min2 = d;
                }
                num /= 10;
            }
            System.out.println(min1 + " " + min2);
            System.out.println("SUM " + min1 + 10 + min2);
            sum += min1 * 10 + min2;
            System.out.println(sum);
        }
        return sum;
    }


    static int leastNumbers(int sum, int[] arr) {
        if (arr.length < 2) return -1;
        int f = 0, s = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < arr[f])
                f = i;
        for (int i = 0; i < arr.length; i++)
            if (i != f && arr[i] < arr[s]) s = i;
        if (f == s || arr[f] + arr[s] > sum) return 0;
        return arr[f] * arr[s];
    }

    static int relativeSpeed(int direction, int distance1, int time1, int distance2, int time2) {

        int speed1 = distance1 / time1;
        int speed2 = distance2 / time2;
        if (direction == 0) {
            return speed1 + speed2;
        } else {
            return speed1 - speed2;
        }

    }

    static int lastManStanding(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        int i = 0;
        while (arr.size() > 1) {
            arr.remove(i);
            if (i == arr.size()) {
                i = 0;
            }
            if (i == arr.size() - 1) {
                i = 0;
            } else
                i += 1;

        }
        return arr.get(0) + 1;
    }

    static int findLength(char[] A, char[] B, HashSet<Character> ex) {
        if (A == null || B == null) return 0;
        int m = A.length;
        int n = B.length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (A[i - 1] == B[j - 1] && !ex.contains(A[i - 1])) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}
