// MazeSolver.java
import java.util.*;
public interface MazeSolver {
    List<int[]> solve(Maze maze, int[] origin, int[] destination);
}