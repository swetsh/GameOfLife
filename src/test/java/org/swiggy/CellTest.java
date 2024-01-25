package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void TestCellIsDeadOrAlive() {
        Cell cell = new Cell(Cell.State.Alive, new Cell[0]);
        assertTrue(cell.state() == Cell.State.Alive || cell.state() == Cell.State.Dead);
    }
    @Test
    public void TestCellIsDead() {
        Cell cell = new Cell(Cell.State.Dead, new Cell[0]);
        assertEquals(Cell.State.Dead, cell.state());
    }

    public void TestCellIsAlive() {
        Cell cell = new Cell(Cell.State.Alive, new Cell[0]);
        assertEquals(Cell.State.Alive, cell.state());
    }

    @Test
    public void TestCellDiesIfAllNeighboursAreDead() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            neighbours[i] = new Cell(Cell.State.Dead, new Cell[0]);
        }

        Cell cell = new Cell(Cell.State.Alive, neighbours);
        cell.evolve();

        assertEquals(Cell.State.Dead, cell.state());
    }

    @Test
    public void TestCellGetAliveIf3NeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            if (i < 5)
                neighbours[i] = new Cell(Cell.State.Dead, new Cell[0]);
            else
                neighbours[i] = new Cell(Cell.State.Alive, new Cell[0]);
        }

        Cell cell = new Cell(Cell.State.Dead, neighbours);
        cell.evolve();

        assertEquals(Cell.State.Alive, cell.state());
    }

    @Test
    public void TestCellRemainsAliveIf2NeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            if (i < 6)
                neighbours[i] = new Cell(Cell.State.Dead, new Cell[0]);
            else
                neighbours[i] = new Cell(Cell.State.Alive, new Cell[0]);
        }

        Cell cell = new Cell(Cell.State.Alive, neighbours);
        cell.evolve();

        assertEquals(Cell.State.Alive, cell.state());
    }

    @Test
    public void TestCellShouldNotGetAliveIf2NeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            if (i < 6)
                neighbours[i] = new Cell(Cell.State.Dead, new Cell[0]);
            else
                neighbours[i] = new Cell(Cell.State.Alive, new Cell[0]);
        }

        Cell cell = new Cell(Cell.State.Dead, neighbours);
        cell.evolve();

        assertEquals(Cell.State.Dead, cell.state());
    }

    @Test
    public void TestCellDiesIfAllNeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            neighbours[i] = new Cell(Cell.State.Alive, new Cell[0]);
        }

        Cell cell = new Cell(Cell.State.Alive, neighbours);
        cell.evolve();

        assertEquals(Cell.State.Dead, cell.state());
    }

    @Test
    public void TestCellDiesIf$NeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            if (i%2 == 0) neighbours[i] = new Cell(Cell.State.Alive, new Cell[0]);
            else neighbours[i] = new Cell(Cell.State.Dead, new Cell[0]);
        }

        Cell cell = new Cell(Cell.State.Alive, neighbours);
        cell.evolve();

        assertEquals(Cell.State.Dead, cell.state());
    }

}