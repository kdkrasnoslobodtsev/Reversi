package org.example;

import java.io.IOException;
import java.rmi.UnexpectedException;

public class Game {
    Player first;
    Player second;
    Table table;


    public Game(Player player1, Player player2) {
        first = player1;
        second = player2;
        table = new Table(8);
        table.set(3, 3, "w");
        table.set(4, 4, "w");
        table.set(3, 4, "b");
        table.set(4, 3, "b");
    }

    public void startGame() {
        int i = 0;
        while (!table.findMoves(first.chip).isEmpty() || !table.findMoves(second.chip).isEmpty()) {
            if (i % 2 == 0) {
                try {
                    table.printTable(first);
                    System.out.println("Первый игрок: " + table.findPoints(first.chip) + " очков");
                    System.out.println("Второй игрок: " + table.findPoints(second.chip) + " очков");
                    System.out.println("Ход первого игрока (b): ");
                    first.makeMove(table);
                } catch(IllegalArgumentException e) {
                    System.out.println("Нельзя совершить такой ход, попробуйте снова");
                    continue;
                } catch(UnexpectedException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Введены некорректные данные, попробуйте еще раз");
                    continue;
                }
            } else {
                try {
                    table.printTable(second);
                    System.out.println("Первый игрок: " + table.findPoints(first.chip) + " очков");
                    System.out.println("Второй игрок: " + table.findPoints(second.chip) + " очков");
                    System.out.println("Ход второго игрока (w): ");
                    second.makeMove(table);
                } catch(IllegalArgumentException e) {
                    System.out.println("Нельзя совершить такой ход, попробуйте снова");
                    continue;
                } catch(UnexpectedException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Введены некорректные данные, попробуйте еще раз");
                    continue;
                }
            }
            ++i;
        }
        if (table.findPoints(first.chip) > table.findPoints(second.chip)) {
            System.out.println("Победил первый игрок со счетом " + table.findPoints(first.chip) + ":" + table.findPoints(second.chip));
        } else if (table.findPoints(first.chip) < table.findPoints(second.chip)) {
            System.out.println("Победил второй игрок со счетом " + table.findPoints(first.chip) + ":" + table.findPoints(second.chip));
        } else {
            System.out.println("Ничья со счетом " + table.findPoints(first.chip) + ":" + table.findPoints(second.chip));
        }
    }
}
