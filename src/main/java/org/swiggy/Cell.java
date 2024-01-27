package org.swiggy;

public class Cell {
    public enum State {
        Alive, Dead
    }

    private State currentState;
    private State previousState;
    private Cell[] neighbours;

    public Cell(State state) {
        this.currentState = state;
        this.previousState = state;
    }

    public void addNeighbours(Cell[] neighbours) {
        this.neighbours = neighbours;
    }

    public State state() {
        return this.currentState;
    }

    public void evolve() {
        int aliveCount = 0;
        for (Cell neighbour : neighbours) {
            if (neighbour.previousState == State.Alive)
                aliveCount++;
        }

        if (aliveCount == 3)
            this.currentState = State.Alive;
        else if (aliveCount < 2 || aliveCount > 3)
            this.currentState = State.Dead;
    }

    private void updateFrame() {
        this.previousState = this.currentState;
    }
}