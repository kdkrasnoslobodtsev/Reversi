package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите режим игры:");
        System.out.println("1 - одиночный режим");
        System.out.println("2 - вдвоем");
        Scanner in = new Scanner(System.in);
        Integer mode;
        try {
            mode = in.nextInt();
        } catch (Exception e) {
            System.out.println("Введено некорректное число, загружается режим игры с компьютером");
            mode = 1;
        }
        if (mode == 1) {
            System.out.println("Введите yes, если хотите ходить первым, иначе введите любое другое слово");
            String ans = in.next();
            if (ans.equals("yes")) {
                Human pl1 = new Human();
                pl1.chip = "b";
                Computer pl2 = new Computer();
                pl2.chip = "w";
                Game g = new Game(pl1, pl2);
                g.startGame();
            } else {
                Human pl2 = new Human();
                pl2.chip = "w";
                Computer pl1 = new Computer();
                pl1.chip = "b";
                Game g = new Game(pl1, pl2);
                g.startGame();
            }
        } else if (mode == 2) {
            Human pl1 = new Human();
            pl1.chip = "b";
            Human pl2 = new Human();
            pl2.chip = "w";
            Game g = new Game(pl1, pl2);
            g.startGame();
        } else {
            System.out.println("Введено некорректное число, загружается режим игры с компьютером");
            System.out.println("Введите yes, если хотите ходить первым, иначе введите любое другое слово");
            String ans = in.nextLine();
            if (ans == "yes") {
                Human pl1 = new Human();
                pl1.chip = "b";
                Computer pl2 = new Computer();
                pl2.chip = "w";
                Game g = new Game(pl1, pl2);
                g.startGame();
            } else {
                Human pl2 = new Human();
                pl2.chip = "w";
                Computer pl1 = new Computer();
                pl1.chip = "b";
                Game g = new Game(pl1, pl2);
                g.startGame();
            }
        }
    }
}
