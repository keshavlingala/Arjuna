package Tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class NumberOfLinesFromPoints {
    static boolean isCollinear(HashSet<Point> v) {
        if (v.size() < 3) return false;
        Iterator<Point> iter = v.iterator();
        Point a = iter.next();
        Point b = iter.next();
        for (Point p : v)
            if ((b.x - a.x) * (p.y - b.y) != (p.x - b.x) * (b.y - a.y))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }
        HashMap<Float, HashSet<Point>> sp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                float s = points[i].slope(points[j]);
                sp.putIfAbsent(s, new HashSet<>());
                sp.get(s).add(points[i]);
                sp.get(s).add(points[j]);
            }
        }
        int ans = 0;
        for (HashSet<Point> v : sp.values()) if (isCollinear(v)) ans++;
        System.out.println(ans);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        float slope(Point p) {
            return (float) (p.y - this.y) / (p.x - this.x);
        }

        @Override
        public String toString() {
            return "(" + x +
                    " " + y +
                    ')';
        }
    }
}


