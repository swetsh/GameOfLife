package org.swiggy;

public class Board {
    private Cell[][] cellGrid;

    private final int rows;
    private final int columns;

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
                cellGrid[i][j] = new Cell(state);
            }
        }
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
