package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите режим игры:");
        System.out.println("1 - одиночный режим");
        System.out.println("2 - вдвоем");
        Scanner in = new Scanner(System.in);
        Integer mode = in.nextInt();
        Human pl1 = new Human();
        pl1.chip = "b";
        Player pl2;
        if (mode == 1) {
            pl2 = new Computer();
        } else {
            pl2 = new Human();
        }
        pl2.chip = "w";
        Game g = new Game(pl1, pl2);
        g.startGame();
    }
}