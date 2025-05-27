package solutions;
// Main.java
import java.util.*;

import adt.MazeSolver;
import ds.Maze;
import ds.MazeSolverDC;

public class Main {
    public static void main(String[] args) {
        int logicalRows=3, logicalCols=3;
        Maze maze = new Maze(logicalRows, logicalCols);
        MazeSolver solver = new MazeSolverDC();

        int[] origin={1,1};
        int[] destination={maze.rows-2, maze.cols-2};

        List<int[]> path = solver.solve(maze, origin, destination);
        if(path==null) System.out.println("No se encontró un camino.");
        System.out.println(maze);
    }
}
