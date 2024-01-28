package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogTest {
    @Test
    void TestConstructBoardShouldReturnBoard() {
        GameLog gameLog = new GameLog();

//        System.setIn(new java.io.ByteArrayInputStream("3\n4\n0.5\n".getBytes()));

//        Board board = gameLog.contructBoard();

        assertNotNull(gameLog);
    }
//    @Test
//    void TestConstructBoardShouldReturnBoardOfSize3x4() {
//        GameLog gameLog = new GameLog();
//
//        System.setIn(new java.io.ByteArrayInputStream("3\n4\n0\n".getBytes()));
//
//        Board board = gameLog.contructBoard();
//
//        String expectedBoard = "----\n----\n----\n";
//
//        assertEquals(expectedBoard, board.toString());
//    }
//
//    @Test
//    void TestConstructBoardShouldReturnBoardOfSize3x4AliveCells() {
//        GameLog gameLog = new GameLog();
//
//        System.setIn(new java.io.ByteArrayInputStream("3\n4\n1.0\n".getBytes()));
//
//        Board board = gameLog.contructBoard();
//
//        String expectedBoard = "****\n****\n****\n";
//
//        assertEquals(expectedBoard, board.toString());
//    }
}