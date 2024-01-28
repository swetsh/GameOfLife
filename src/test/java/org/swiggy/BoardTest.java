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
    public void Test2x2BoardWithAllAliveCell() {
        Board board = new Board(2, 2, 1); //One seed value represent all alive cell

        String expectedBoard = "**\n**\n";

        assertEquals(expectedBoard, board.toString());
    }

    @Test
    public void testBoardWith60PercentAliveCell() {
        Board board = new Board(10, 10, 0.6);

        String boardString = board.toString();

        long aliveCount = boardString.chars().filter(ch -> ch == '*').count();

        assertTrue(Math.abs(aliveCount-60) < 10);
    }

    @Test
    public void testBoardWith20PercentAliveCell() {
        Board board = new Board(10, 10, 0.2);

        String boardString = board.toString();

        long aliveCount = boardString.chars().filter(ch -> ch == '*').count();

        assertTrue(Math.abs(aliveCount-20) < 10);
    }

    @Test
    public void testAliveCellCountShouldBeZero() {
        Board board = new Board(10, 10, 0);

        String boardString = board.toString();

        long aliveCount = boardString.chars().filter(ch -> ch == '*').count();

        assertEquals(aliveCount, board.aliveCount());
    }
}

