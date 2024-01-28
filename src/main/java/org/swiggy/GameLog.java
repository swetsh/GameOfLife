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
        System.out.println("Enter board height");
        this.m = scanner.nextInt();
        System.out.println("Enter board width");
        this.n = scanner.nextInt();
        System.out.println("Enter seed Value");
        this.s = scanner.nextDouble();
        return new Board(this.m, this.n, this.s);
    }

}
