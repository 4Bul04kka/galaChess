package galaGame.figure;

import galaGame.Cell;
import galaGame.Figure;
import galaGame.FigureType;
import galaGame.Game;

import java.util.List;
import java.util.Map;

public class King implements FigureStep {
    @Override
    public FigureType getType() {
        return FigureType.KING;
    }

    @Override
    public Map<Boolean, List<Cell>> process(Figure figure, Game game) {
        if (figure.getType() != getType()) {
            throw new RuntimeException();
        }
        Cell cell = game.getFigureCellMap().get(figure);
        //return cell getDirectionsMap ? проверить есть ли там кто-то
        // мапа со списком ходов
        return null;
    }
}
