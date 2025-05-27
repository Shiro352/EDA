package adt;
// MazeSolver.java
import java.util.*;
import ds.Maze;

public interface MazeSolver {
    List<int[]> solve(Maze maze, int[] origin, int[] destination);
}