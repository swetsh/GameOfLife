package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void TestCellIsDeadOrAlive() {
        Cell cell = new Cell();
        assertTrue(cell.state == Cell.State.Alive || cell.state == Cell.State.Dead);
    }
}