package com.DAA;

/* Java program for solution of M Coloring problem
using backtracking
Test case=1

Solution Exists: Following are the assigned colors
 1  2  3  2

*/
public class MColoring {
    final int V = 4;
    int color[];


    boolean isSafe(int v, int graph[][], int color[],
                   int c) {
        //write code
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;


    }

    boolean graphColoringUtil(int graph[][], int m,
                              int color[], int v) {
		/* base case: If all vertices are assigned
		a color then return true */
        if (v == V)
            return true;

		/* Consider this vertex v and try different
		colors */
        for (int c = 1; c <= m; c++) {
			/* Check if assignment of color c to v
			is fine*/
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

				/* recur to assign colors to rest
				of the vertices */
                if (graphColoringUtil(graph, m,
                        color, v + 1))
                    return true;


                color[v] = 0;
            }
        }


        return false;
    }


    boolean graphColoring(int graph[][], int m) {
        //write code
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Not Possible");
            return false;
        }

        printSolution(color);
        return true;
    }


    void printSolution(int color[]) {
        System.out.println("Solution Exists: Following" +
                " are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }

    // driver program to test above function
    public static void main(String args[]) {
        MColoring Coloring = new MColoring();
		/* Create following graph and test whether it is
		3 colorable
		(3)----(2)
		 |     /|
		 |    /  |
		 |   /   |
	    (0)----(1)
		*/
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        int m = 3; // Number of colors
        Coloring.graphColoring(graph, m);
    }
}

