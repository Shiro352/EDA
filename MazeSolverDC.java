// MazeSolverDC.java
import java.util.*;

public class MazeSolverDC implements MazeSolver {
    @Override
    public List<int[]> solve(Maze maze, int[] origin, int[] destination) {
        boolean[][] visited = new boolean[maze.rows][maze.cols];
        List<int[]> path = solveRecursive(maze, origin[0], origin[1], destination, visited);
        if (path != null) {
            for (int[] cell : path) {
                if (maze.data[cell[0]][cell[1]] == Maze.EMPTY) {
                    maze.data[cell[0]][cell[1]] = Maze.PATH;
                }
            }
        }
        return path;
    }

    private List<int[]> solveRecursive(Maze maze, int r, int c, int[] dest, boolean[][] visited) {
        if (r<0||c<0||r>=maze.rows||c>=maze.cols) return null;
        if (maze.data[r][c]==Maze.WALL||visited[r][c]) return null;
        if (r==dest[0] && c==dest[1]) {
            List<int[]> p=new ArrayList<>(); p.add(new int[]{r,c}); return p;
        }
        visited[r][c]=true;
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        List<int[]> best=null;
        for(int[] d:dirs){
            List<int[]> sub = solveRecursive(maze,r+d[0],c+d[1],dest,visited);
            if(sub!=null && (best==null||sub.size()<best.size())) best=sub;
        }
        visited[r][c]=false;
        if(best!=null){best.add(0,new int[]{r,c}); return best;}
        return null;
    }
}
