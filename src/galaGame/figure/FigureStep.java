package galaGame.figure;


import galaGame.Cell;
import galaGame.Figure;
import galaGame.FigureType;
import galaGame.Game;

import java.util.List;
import java.util.Map;

public interface FigureStep {

    FigureType getType();

    Map<Boolean, List<Cell>> process(Figure figure, Game game);

}
