package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void TestBoardWithNegativeDimensionExpectedRuntime() {
        assertThrows(RuntimeException.class, () -> new Board(-2, -2, 0));
    }

    @Test
    public void TestBoardWithZeroDimensionExpectedRuntime() {
        assertThrows(RuntimeException.class, () -> new Board(0, 2, 0));
    }

    @Test
    public void TestBoardWithNegativeSeedExpectedRuntime() {
        assertThrows(RuntimeException.class, () -> new Board(2, 2, -0.1));
    }

    @Test
    public void TestBoardWithSeedGreaterThan1ExpectedRuntime() {
        assertThrows(RuntimeException.class, () -> new Board(2, 2, -1.1));
    }

    @Test
    public void Test2x2BoardWithAllDeadCell() {
        Board board = new Board(2, 2, 0); //Zero seed value represent all dead cell

        String expectedBoard = "--\n--\n";

        assertEquals(expectedBoard, board.toString());
    }

    @Test
    public void Test2x2BoardWithAllAliceCell() {
        Board board = new Board(2, 2, 1); //One seed value represent all alive cell

        String expectedBoard = "**\n**\n";

        assertEquals(expectedBoard, board.toString());
    }
}

