package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    public void TestCellIsDead() {
        Cell cell = new Cell(Cell.State.Dead);
        assertEquals(Cell.State.Dead, cell.state());
    }

    @Test
    public void TestCellIsAlive() {
        Cell cell = new Cell(Cell.State.Alive);
        assertEquals(Cell.State.Alive, cell.state());
    }

    @Test
    public void TestCellDiesIfAllNeighboursAreDead() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            neighbours[i] = new Cell(Cell.State.Dead);
        }

        Cell cell = new Cell(Cell.State.Alive);
        cell.addNeighbours(neighbours);
        cell.evolve();

        assertEquals(Cell.State.Dead, cell.state());
    }

    @Test
    public void TestCellGetAliveIf3NeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            if (i < 5)
                neighbours[i] = new Cell(Cell.State.Dead);
            else
                neighbours[i] = new Cell(Cell.State.Alive);
        }

        Cell cell = new Cell(Cell.State.Dead);
        cell.addNeighbours(neighbours);
        cell.evolve();

        assertEquals(Cell.State.Alive, cell.state());
    }

    @Test
    public void TestCellRemainsAliveIf2NeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            if (i < 6)
                neighbours[i] = new Cell(Cell.State.Dead);
            else
                neighbours[i] = new Cell(Cell.State.Alive);
        }

        Cell cell = new Cell(Cell.State.Alive);
        cell.addNeighbours(neighbours);
        cell.evolve();

        assertEquals(Cell.State.Alive, cell.state());
    }

    @Test
    public void TestCellShouldNotGetAliveIf2NeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            if (i < 6)
                neighbours[i] = new Cell(Cell.State.Dead);
            else
                neighbours[i] = new Cell(Cell.State.Alive);
        }

        Cell cell = new Cell(Cell.State.Dead);
        cell.addNeighbours(neighbours);
        cell.evolve();

        assertEquals(Cell.State.Dead, cell.state());
    }

    @Test
    public void TestCellDiesIfAllNeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            neighbours[i] = new Cell(Cell.State.Alive);
        }

        Cell cell = new Cell(Cell.State.Alive);
        cell.addNeighbours(neighbours);
        cell.evolve();

        assertEquals(Cell.State.Dead, cell.state());
    }

    @Test
    public void TestCellDiesIf4NeighboursAreAlive() {
        Cell[] neighbours = new Cell[8];
        for (int i =0; i<8; i++) {
            if (i%2 == 0) neighbours[i] = new Cell(Cell.State.Alive);
            else neighbours[i] = new Cell(Cell.State.Dead);
        }

        Cell cell = new Cell(Cell.State.Alive);
        cell.addNeighbours(neighbours);
        cell.evolve();

        assertEquals(Cell.State.Dead, cell.state());
    }

}