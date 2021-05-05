package sudoku.userInterface;

import javafx.scene.control.TextField;

/**
 * Maintains x and y values
 */
public class SudokuTextField extends TextField {

    private final int x;
    private final int y;

    public SudokuTextField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    /**
     * regex, way of matching string
     * if string s matches number 1 from 9
     * super calls overriden method from parent class
     * espression = true
     */
    public void replaceText(int i, int i1, String s){
        if (!s.matches("[0-9]")){
            super.replaceText(i, i1, s);
        }
    }

    @Override
    public void replaceSelection(String s){
        if(!s.matches("0-9")){
            super.replaceSelection(s);
        }
    }


}
