import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // contains action events and listeners

public class Main implements ActionListener {
    private JButton button;
    private JPanel panel;
    private JPanel panel2;


    public static void main(String[] args) {
        Main gui = new Main();

        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Click Me");
        panel = new JPanel();
        panel2 = new JPanel();


        button.addActionListener(this); // argument passed must be a class which implements action listener

        MyDrawPanel draw = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH , button).setSize(40, 40);
        frame.getContentPane().add(BorderLayout.CENTER, draw);
        frame.getContentPane().add(BorderLayout.EAST, panel).setSize(4000, 900);
        frame.getContentPane().add(BorderLayout.WEST, panel2).setSize( 4000, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("Ive been clicked");
    }
}
