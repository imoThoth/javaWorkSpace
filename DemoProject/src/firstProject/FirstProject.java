package firstProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class FirstProject {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstProject window = new FirstProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 490, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button1 = new JButton("Press Me");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Welcome to your first pop-up on java GUI");
			}
		});
		button1.setForeground(Color.RED);
		button1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button1.setBounds(212, 324, 97, 35);
		frame.getContentPane().add(button1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(77, 81, 150, 35);
		frame.getContentPane().add(comboBox);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(267, 77, 137, 42);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 259, 230, 52);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(128, 193, 230, 52);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Introduction to Java Gui");
		lblNewLabel.setBounds(88, 29, 316, 35);
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(33, 169, 408, -16);
		frame.getContentPane().add(separator);
		
	}
}
