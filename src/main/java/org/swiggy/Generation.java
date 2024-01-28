package org.swiggy;

public class Generation {

    private int aliveCell;
    private final Board board;

    public Generation() {
        GameLog gameLog = new GameLog();
        this.board = gameLog.contructBoard();
        this.aliveCell = board.aliveCount();
    }

    void start() throws InterruptedException {
        do{
            System.out.println(board);
            board.update();
            aliveCell = board.aliveCount();
            Thread.sleep(1000);
        }while (aliveCell > 0);
    }
}
