import javax.swing.*;

public class SimpleGui {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // Creates a frame
        JButton button = new JButton("Click Me"); // creates a button

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //tells programme to stop when exited
        frame.getContentPane().add(button); // adds button into the frame
        frame.setSize(300, 300);
        frame.setVisible(true); //allows the frame to be seen by user


    }

}
