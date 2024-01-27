package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogTest {
    @Test
    void TestContructBoardShouldReturnBoard() {
        // Set up
        GameLog gameLog = new GameLog();

        System.setIn(new java.io.ByteArrayInputStream("3\n4\n0.5\n".getBytes()));

        Board board = gameLog.contructBoard();

        assertNotNull(board);
    }
}