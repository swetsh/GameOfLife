package org.swiggy;

import java.lang.reflect.Method;

public class Board {
    private Cell[][] cellGrid;

    private final int rows;
    private final int columns;

    private int aliveCellCount = 0;

    public Board(int rows, int columns, double seed) {
        if (rows <= 0 || columns <= 0) throw new RuntimeException();
        if (seed < 0 || seed > 1) throw new RuntimeException();

        this.rows = rows;
        this.columns = columns;
        cellGrid = new Cell[rows][columns];

        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.columns; j++) {
                double randomValue = Math.random();
                Cell.State state = (randomValue < seed) ? Cell.State.Alive : Cell.State.Dead;
                if (state == Cell.State.Alive) this.aliveCellCount++;
                cellGrid[i][j] = new Cell(state);
            }
        }

        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.columns; j++) {
                cellGrid[i][j].addNeighbours(neighbours(i, j));
            }
        }
    }

    private Cell[] neighbours(int row, int column) {
        Cell[] cells = new Cell[8];
        int[][] positions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},            {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };

        for (int i = 0; i < 8; i++) {
            int newRow = (row + positions[i][0] + this.rows) % this.rows;
            int newColumn = (column + positions[i][1] + this.columns) % this.columns;
            cells[i] = cellGrid[newRow][newColumn];
        }

        return cells;
    }

    public void update() {
        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.columns; j++) {
                cellGrid[i][j].evolve();
            }
        }
        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.columns; j++) {
                cellGrid[i][j].updateFrame();
            }
        }
    }

    public int aliveCount() {
        return this.aliveCellCount;
    }

    @Override
    public String toString() {
        StringBuilder board= new StringBuilder();
        for(int i=0; i<this.rows; i++) {
            for(int j=0; j<this.columns; j++) {
                board.append(cellGrid[i][j].toString());
            }
            board.append("\n");
        }
        return board.toString();
    }

}
