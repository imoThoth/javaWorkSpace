package sudoku;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uImpl;

    @Override
    public void start(Stage primaryStage) throws Exception{
        uiImpl = new UserInterfaceImpl(primaryStage);

        try {
            SudokuBuildLogic.build(uImpl);
        } catch (IOException e){
            e.printStackTrace();
            throw e;
        }

    }

    public static void main(String[] args){
            launch(args);
    }
}
