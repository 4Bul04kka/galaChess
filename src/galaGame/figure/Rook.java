package galaGame.figure;
import galaGame.Cell;
import galaGame.Figure;
import galaGame.FigureType;
import galaGame.Game;

import java.util.List;
import java.util.Map;
public class Rook implements FigureStep{
    @Override
    public FigureType getType() {
        return FigureType.ROOK;
    }

    @Override
    public Map<Boolean, List<Cell>> process(Figure figure, Game game) {
        return null;
    }
}
