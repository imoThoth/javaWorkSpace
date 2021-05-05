package sudoku.problemDomain;
import sudoku.constants.GameState;

import java.io.Serializable;

public class SudokuGame implements Serializable { //Serializable, write to file on operating system

    private final GameState gameState;
    private final int [][] gridState;

    public static final int GRID_BOUNDARY = 9;

    public SudokuGame(int gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public int getGameState() {
        return GameState;
    }

    /**
     * Generates new copy of sudoku area
     * ensures the game cannot be corrupted
     * @return
     */
    public int[][] getCopyOfGridState() {
        return SudokuUtilitiies.copyToNewArray(gridState);
    }


}
