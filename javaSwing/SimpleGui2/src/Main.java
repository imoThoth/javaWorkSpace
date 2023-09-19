import javax.swing.*;
import java.awt.event.*; // contains action events and listeners

public class Main implements ActionListener{
    private JButton button;

    public static void main(String[] args) {
        Main gui = new Main();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Click Me");

        button.addActionListener(this); // argument passed must be a class which implements action listener

        frame.getContentPane().add(button).setSize(40, 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("Ive been clicked");
    }
}
