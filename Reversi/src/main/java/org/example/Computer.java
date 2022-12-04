package org.example;

import java.io.IOException;
import java.rmi.UnexpectedException;

public class Computer extends Player {
    @Override
    public void makeMove(Table table) throws IOException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        if (table.moves.isEmpty()) {
            throw new UnexpectedException("Невозможно совершить ход");
        }
        Double x = 0.0, y = 0.0, max = 0.0;
        for (int i = 0; i < table.moves.size(); ++i) {
            if (table.moves.get(i).get(2) > max) {
                x = table.moves.get(i).get(0);
                y = table.moves.get(i).get(1);
                max = table.moves.get(i).get(2);
            }
        }
        if (max - 0.0 > 1e-6) {
            table.set(x.intValue(), y.intValue(), chip);
        }
    }
}
