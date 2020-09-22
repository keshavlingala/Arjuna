package Tests.kp;

import java.util.*;

public class BestSequence {
    static ArrayList<String> combi;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        String damage = scanner.nextLine().replace(" ", "");
        combi = new ArrayList<>();
        permu(damage, "");
//        System.out.println(combi);
        HashMap<String, Integer> hp = new HashMap<>();
        for (String c : combi) {
            int[] arr = zAlgorithm(sentence + "$" + c);
            hp.put(c, Arrays.stream(arr).sum());
        }
//        System.out.println(hp);
        System.out.println(Collections.max(hp.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());
    }

    static void permu(String str, String ans) {
        if (str.length() == 0) {
            combi.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            permu(ros, ans + ch);
        }
    }

    static int[] zAlgorithm(String s) {
        int n = s.length();
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r)
                z[i] = Math.min(r - i + 1, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                ++z[i];
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
