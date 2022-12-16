package galaGame.figure;
import galaGame.Cell;
import galaGame.Figure;
import galaGame.FigureType;
import galaGame.Game;

import java.util.List;
import java.util.Map;

public class Knight implements FigureStep {
    @Override
    public FigureType getType() {
        return FigureType.KNIGHT;
    }

    @Override
    public Map<Boolean, List<Cell>> process(Figure figure, Game game) {
        return null;
    }
}
