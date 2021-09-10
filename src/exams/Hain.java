package exams;

import java.util.Scanner;

public class Hain {
    static int findCost(String str, int arr[], int n) {
        long costofC = 0, costofO = 0,
                costofD = 0, costofE = 0;

        // Traverse the string
        for (int i = 0; i < n; i++) {

            // Min Cost to remove 'c'
            if (str.charAt(i) == 'c')
                costofC += arr[i];

                // Min Cost to remove subsequence "co"
            else if (str.charAt(i) == 'o')
                costofO = Math.min(costofC, costofO + 1);

                // Min Cost to remove subsequence "cod"
            else if (str.charAt(i) == 'd')
                costofD = Math.min(costofO, costofD + 1);

                // Min Cost to remove subsequence "code"
            else if (str.charAt(i) == 'e')
                costofE = Math.min(costofD, costofE + 1);
        }

        // Return the minimum cost
        return (int) costofE;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = 0; t < scanner.nextInt(); t++) {
            scanner.nextInt();
            String str = scanner.next();
            int ans = 0;


            System.out.println(ans);
        }
    }
}
