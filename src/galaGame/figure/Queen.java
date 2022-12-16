package galaGame.figure;
import galaGame.Cell;
import galaGame.Figure;
import galaGame.FigureType;
import galaGame.Game;

import java.util.List;
import java.util.Map;
public class Queen implements FigureStep{
    @Override
    public FigureType getType() {
        return FigureType.QUEEN;
    }

    @Override
    public Map<Boolean, List<Cell>> process(Figure figure, Game game) {
        return null;
    }
}
