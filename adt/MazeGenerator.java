package adt;
// MazeGenerator.java

import ds.Maze;

public interface MazeGenerator {
    Maze generate(int logicalRows, int logicalCols);
}