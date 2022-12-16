package galaGame;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cell {

    private final Map<Direction, Cell> directionsMap = new LinkedHashMap<>();

    private final char row;
    private final char col;

    public Cell(char row, char col) {
        this.row = row;
        this.col = col;
    }

    public Map<Direction, Cell> getDirectionsMap() {
        return directionsMap;
    }

    public char getRow() {
        return row;
    }

    public char getCol() {
        return col;
    }
}

