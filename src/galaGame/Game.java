package galaGame;

import galaGame.figure.FigureStep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Game {

    // private boolean kingMove() - рокировка делается самим игроком в чем смысл? только если играют боты
    // паттерн команда?
    // каждый ход в шахматах объект степ будем записывать все ходы

    private Queue<Player> players;

    private Board board;

    private Map<Cell, Figure> cellFigureMap = new HashMap<>(); // мапа что лежит в ячейке фигуры на доске

    private Map<Figure, Cell> figureCellMap = new HashMap<>(); // для чего нужна?

    private Map<Figure, Player> figurePlayerMap = new HashMap<>(); // какого игрока фигура

    private Map<Player, Map<FigureType, List<Figure>>> playerFiguresMap = new HashMap<>(); // или хранить просто лист фигур?

    private Map<FigureType, FigureStep> stepMap = new HashMap<>(); // когда делаем ход в этой мапе по типу фигуры находим подходящую фигуру и получаем список ходов?


    // свой-чужой
    // логика ходов
    // алгоритм хода для каждой фигуры
    // расстановка фигур

    public void init() {
        board.init();
        // init players
        // доска отвязана от фигур
    }

    public void process() {
        while (players.size() > 1) {
            Player currPlayer = players.poll();
            Map<FigureType, List<Figure>> figureTypeListMap = playerFiguresMap.get(currPlayer);
            Figure currFigure = defineFigureStep(figureTypeListMap);
            // определяем как ходить фигуре
            FigureStep figureStep = stepMap.get(currFigure.getType());
            Map<Boolean, List<Cell>> cellsForStep = figureStep.process(currFigure, this);
            Cell targetCell = defineFinishCellStep(cellsForStep, currFigure); // куда пойти может
            doStep(currFigure, targetCell);
            // печатаем доску в конце вайла
        }
    }

    private void doStep(Figure figure, Cell targetCell) {  // через паттерны как то по другому?
        Cell cell = figureCellMap.get(figure);
        cellFigureMap.remove(cell);
        cellFigureMap.put(targetCell,figure);

        Figure killedFigure = cellFigureMap.get(targetCell);
        if (killedFigure != null) {
            figureCellMap.remove(killedFigure);
            figurePlayerMap.remove(killedFigure);
            // remove from player figures map
        }

        figureCellMap.put(figure,targetCell);
    }

    private Cell defineFinishCellStep(Map<Boolean, List<Cell>> cellsForStep, Figure figure) {
        return null;
    }

    public Figure defineFigureStep(Map<FigureType, List<Figure>> figureTypeListMap) { // взять первую попавшуюся?
        return null;
    }

    public void setFiguresOnBoard() {

    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Map<Cell, Figure> getCellFigureMap() {
        return cellFigureMap;
    }

    public Map<Figure, Cell> getFigureCellMap() {
        return figureCellMap;
    }

    public Map<Figure, Player> getFigurePlayerMap() {
        return figurePlayerMap;
    }

    public Map<Player, Map<FigureType, List<Figure>>> getPlayerFiguresMap() {
        return playerFiguresMap;
    }
}
