// MazeGeneratorDFS.java
import java.util.*;

public class MazeGeneratorDFS implements MazeGenerator {
    private static final int[] dRow = {-1, 0, 1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    @Override
    public Maze generate(int logicalRows, int logicalCols) {
        int rows = 2 * logicalRows + 1;
        int cols = 2 * logicalCols + 1;
        Maze maze = new Maze(); // usa un constructor vacío si existe o inicializa abajo
        maze.rows = rows;
        maze.cols = cols;
        maze.data = new int[rows][cols];
        for (int r = 0; r < rows; r++) Arrays.fill(maze.data[r], Maze.WALL);
        boolean[][] visited = new boolean[logicalRows][logicalCols];
        dfs(0, 0, logicalRows, logicalCols, maze, visited);
        return maze;
    }

    private void dfs(int lr, int lc, int logicalRows, int logicalCols, Maze maze, boolean[][] visited) {
        visited[lr][lc] = true;
        int mr = 2 * lr + 1;
        int mc = 2 * lc + 1;
        maze.data[mr][mc] = Maze.EMPTY;

        List<Integer> dirs = Arrays.asList(0,1,2,3);
        Collections.shuffle(dirs);
        for (int dir : dirs) {
            int nlr = lr + dRow[dir];
            int nlc = lc + dCol[dir];
            if (nlr>=0 && nlr<logicalRows && nlc>=0 && nlc<logicalCols && !visited[nlr][nlc]) {
                int wallR = mr + dRow[dir];
                int wallC = mc + dCol[dir];
                maze.data[wallR][wallC] = Maze.EMPTY;
                dfs(nlr, nlc, logicalRows, logicalCols, maze, visited);
            }
        }
    }
}

