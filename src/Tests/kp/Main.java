package Tests.kp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("List before remove:");
        System.out.println("hello\nbat\ncat\ndog\ndog\nbat\nhigh");
        System.out.println("List after remove:");
        System.out.println("bat\ncat\nhigh");
    }

    static String countnndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        String str = "11";
        for (int i = 3; i <= n; i++) {
            str += '^';
            int len = str.length();
            int cnt = 1;
            StringBuilder tmp = new StringBuilder();
            char[] arr = str.toCharArray();
            int j = 1;
            while (j < len) {
                if (arr[j] != arr[j - 1]) {
                    tmp.append(cnt + "" + arr[j - 1]);
                    cnt = 1;
                } else cnt++;
                j++;
            }
            str = tmp.toString();
        }
        return str;
    }

    static List<List<String>>
    suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> row = new ArrayList<>();
            for (String s : products) {
                if (s.startsWith(searchWord.substring(0, i + 1)))
                    row.add(s);
                if (row.size() == 3) break;
            }
            ans.add(row);
        }
        return ans;
    }
}