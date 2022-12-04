package org.example;

import java.io.IOException;

public abstract class Player {
    public String chip;
    public abstract void makeMove(Table table) throws IOException;
}
