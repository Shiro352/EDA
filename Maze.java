public class Maze {
    public static final int EMPTY = 0;
    public static final int WALL = 1;
    public static final int PATH = 2;

    public int[][] data;
    public int rows;
    public int cols;

    // Constructor predeterminado para uso interno en generador
    public Maze() {
    }

    // Constructor público: recibe dimensiones lógicas y obtiene laberinto generado
    public Maze(int logicalRows, int logicalCols) {
        // calculamos dimensiones reales
        this.rows = 2 * logicalRows + 1;
        this.cols = 2 * logicalCols + 1;
        MazeGeneratorDFS generator = new MazeGeneratorDFS();
        Maze genMaze = generator.generate(logicalRows, logicalCols);
        this.data = genMaze.data;
        this.rows = genMaze.rows;
        this.cols = genMaze.cols;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int v = data[i][j];
                if (v == WALL) sb.append('#');
                else if (v == EMPTY) sb.append(' ');
                else if (v == PATH) sb.append('.');
                else sb.append('?');
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}