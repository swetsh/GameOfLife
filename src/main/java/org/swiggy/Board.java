package org.swiggy;

public class Board {
    private Cell[][] cellGrid;

    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        cellGrid = new Cell[rows][columns];

        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.columns; j++) {
                cellGrid[i][j] = new Cell(Cell.State.Dead);
            }
        }
    }



//    public void evolve() {
//        for (int i=0; i<this.rows; i++) {
//            for (int j=0; j<this.columns; j++) {
//                cellGrid[i][j].evolve();
//            }
//        }
//    }
}
