package org.example;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.Scanner;

public class Human extends Player {

    @Override
    public void makeMove(Table table) throws IOException {
        if (table.moves.isEmpty()) {
           throw new UnexpectedException("Невозможно совершить ход");
        }
        Scanner in = new Scanner(System.in);
        Integer x = in.nextInt();
        Integer y = in.nextInt();
        if (table.get(x - 1, y - 1) == "w" || table.get(x - 1, y - 1) == "b" || table.get(x - 1, y - 1) == "*") {
            throw new IllegalArgumentException();
        }
        table.set(x - 1, y - 1, chip);
    }
}
