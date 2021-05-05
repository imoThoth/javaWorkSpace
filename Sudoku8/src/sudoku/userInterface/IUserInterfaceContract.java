package sudoku.userInterface;

import sudoku.problemDomain.SudokuGame;

public class IUserInterfaceContract {

    interface EventListener{
        /**
         * Diffrentiates between the features
         * Acts as a controller/presenter
         * @param x
         * @param y
         * @param input
         */
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }

    interface View{
        /**
         * Binds to the user interface
         * @param listener
         */
        void setListener(IUserInterfaceContract.EventListener listener);
        void updateSquare(int x, int y, int input);
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);

    }

}
