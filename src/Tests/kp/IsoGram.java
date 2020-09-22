package Tests.kp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IsoGram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        HashSet<Character> set = IntStream.range(0, s.length()).mapToObj(s::charAt).collect(Collectors.toCollection(HashSet::new));
        System.out.println(set.size() == s.length() ? "TRUE" : "FALSE");
    }
}
