package Tests.kp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Janiator {
    static List<Long> distinctNumbers(List<Long> arr, int n) {
        List<Long> cout = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cout.add(0L);
        }
        for (int i = 1; i < n; i++) {
            if (arr.get(i - 1) < arr.get(i)) {
                cout.set(i, cout.get(i) + Math.abs(cout.get(i - 1)));
            } else {
                cout.set(i, cout.get(i) - Math.abs(cout.get(i - 1)));
            }
        }
        return cout;
    }

    public static void main(String[] args) {

        System.out.println(distinctNumbers(Arrays.asList(2L, 4L, 3L), 3));
    }
}
