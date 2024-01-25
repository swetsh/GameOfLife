package org.swiggy;

public class Cell {
    enum State {
        Alive, Dead;
    }

    State state;

    public Cell() {
        this.state = State.Dead;
    }
}
