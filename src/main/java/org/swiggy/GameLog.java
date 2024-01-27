package org.swiggy;

import java.util.Scanner;

public class GameLog {
    private final Scanner scanner;


    private int m;
    private int n;
    private double s;

    public GameLog() {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game of Life");
    }

    public Board contructBoard() {
        return new Board(3, 4, 1);
    }

}
