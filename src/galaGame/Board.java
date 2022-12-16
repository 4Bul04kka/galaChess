package galaGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private Cell leftDownCorner;
    private final Map<String, Cell> map = new HashMap<>();

    public void init() {
        leftDownCorner = new Cell('A', '1');
        List<List<Cell>> rows = new ArrayList<>();
        for (char i = 'A'; i < 'I'; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 1; j < 9; j++) {
                Cell cell = new Cell(i, (char) j); // char?
                map.put(i + String.valueOf(j), cell);
                row.add(cell);
            }
            for (int j = 2; j < 9; j++) {
                Cell cell = row.get(j);
                Cell prevCell = row.get(j - 1);
                cell.getDirectionsMap().put(Direction.LEFT, prevCell); // проставили влево вправо, надо еще вверх-вниз и по диагонали
                prevCell.getDirectionsMap().put(Direction.RIGHT, cell);
            }
            rows.add(row);
        }
    }

    private Cell getCellByIndex(Cell cell, int index, Direction direction) {
        Cell result = cell;
        for (int i = 0; i < index; i++) {
            if (result == null) {
                throw new RuntimeException("Null result");
            }
            result = result.getDirectionsMap().get(direction);
        }
        return result;
    }
}
