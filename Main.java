public class Main {
    public static void main(String[] args) {
        // Crear un laberinto de 5x5
        Maze maze = new Maze(5, 5);

        // Crear un camino vacío en forma de cruz
        maze.data[2][1] = Maze.EMPTY;
        maze.data[2][2] = Maze.EMPTY;
        maze.data[2][3] = Maze.EMPTY;
        maze.data[1][2] = Maze.EMPTY;
        maze.data[3][2] = Maze.EMPTY;

        // Imprimir el laberinto
        System.out.println(maze.toString());
    }
}