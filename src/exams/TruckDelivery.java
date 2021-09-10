package exams;

import java.util.*;

class QItem {
    int row,col,dist;
    public QItem(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class TruckDelivery {
    static boolean isValid(int x, int y, List<List<Integer>> grid, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < grid.size()
                && y < grid.get(0).size() && grid.get(x).get(y) != 0
                && !visited[x][y];
    }
    static int minDistance(List<List<Integer>> grid) {
        System.out.println(grid);
        QItem source = new QItem(0, 0, 0);
        Queue<QItem> queue = new LinkedList<>();
        queue.add(new QItem(source.row, source.col, 0));
        boolean[][] visited
                = new boolean[grid.size()][grid.get(0).size()];
        visited[source.row][source.col] = true;
        while (!queue.isEmpty()) {
            QItem p = queue.remove();
            if (grid.get(p.row).get(p.col) == 9)
                return p.dist;
            int[][] delta = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
            for (int[] dir : delta) {
                if (isValid(p.row + dir[0], p.col + dir[1], grid, visited)) {
                    queue.add(new QItem(p.row + dir[0], p.col + dir[1],
                            p.dist + 1));
                    visited[p.row + dir[0]][p.col + dir[1]] = true;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(Arrays.asList(1, 1, 1));
        arr.add(Arrays.asList(0, 0, 1));
        arr.add(Arrays.asList(1, 1, 1));
        arr.add(Arrays.asList(1, 9, 1));
        System.out.println(minDistance(arr));
    }
}


