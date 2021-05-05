package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculator {

	private JFrame frame;
	private JTextField firstValue;
	private JTextField secondValue;
	private JTextField textDisplay;
	private JButton btnDivide;
	private JButton btnMultiply;
	private JButton btnModulus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		firstValue = new JTextField();
		firstValue.setHorizontalAlignment(SwingConstants.CENTER);
		firstValue.setFont(new Font("Tahoma", Font.BOLD, 20));
		firstValue.setBounds(27, 51, 148, 64);
		frame.getContentPane().add(firstValue);
		firstValue.setColumns(10);
		
		secondValue = new JTextField();
		secondValue.setHorizontalAlignment(SwingConstants.CENTER);
		secondValue.setFont(new Font("Tahoma", Font.BOLD, 20));
		secondValue.setColumns(10);
		secondValue.setBounds(289, 51, 148, 64);
		frame.getContentPane().add(secondValue);
		
		JButton btnPlus = new JButton("Plus");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num1,num2,result;
				try { //used to generate error message with catch
					num1 = Integer.parseInt(firstValue.getText()); //gets String value, and sets it to a integer
					num2 = Integer.parseInt(secondValue.getText()); 
					result = num1 + num2;
					textDisplay.setText(Integer.toString(result)); //turns integer to string then shows in display
				}
				catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Only integers accepted"); // shows error message with non-integer input
					
				}
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPlus.setBounds(106, 147, 118, 52);
		frame.getContentPane().add(btnPlus);
		
		JButton btnSub = new JButton("Sub");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num1, num2, result;
				try {
					num1 = Integer.parseInt(firstValue.getText());
					num2 = Integer.parseInt(secondValue.getText());
					result = num1 - num2;
					textDisplay.setText(Integer.toString(result));
				}
				catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Only integers accepted");
				}
				
			}
		});
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSub.setBounds(246, 147, 118, 52);
		frame.getContentPane().add(btnSub);
		
		textDisplay = new JTextField();
		textDisplay.setFont(new Font("Arial", Font.BOLD, 40));
		textDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		textDisplay.setBounds(84, 351, 298, 64);
		frame.getContentPane().add(textDisplay);
		textDisplay.setColumns(10);
		
		btnDivide = new JButton("Divide");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, result;
				try {
					num1 = Integer.parseInt(firstValue.getText());
					num2 = Integer.parseInt(secondValue.getText());
					result = num1 / num2;
					textDisplay.setText(Integer.toString(result));
				}
				catch(Exception error){
					JOptionPane.showMessageDialog(null, "Only integers accepted");
				}
				
			}
		});
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDivide.setBounds(106, 212, 118, 52);
		frame.getContentPane().add(btnDivide);
		
		btnMultiply = new JButton("Multiply");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num1, num2, result;
				try {
					num1 = Integer.parseInt(firstValue.getText());
					num2 = Integer.parseInt(secondValue.getText());
					result = num1 * num2;
					textDisplay.setText(Integer.toString(result));
				} catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Only integers accepted");
				}
			}
		});
		btnMultiply.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMultiply.setBounds(246, 212, 118, 52);
		frame.getContentPane().add(btnMultiply);
		
		btnModulus = new JButton("Modulus");
		btnModulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float num1, num2, result;
				try {
					num1 = Float.parseFloat(firstValue.getText());
					num2 = Float.parseFloat(secondValue.getText());
					result = num1 % num2;
					textDisplay.setText(Float.toString(result));
				} catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Only integers accepted");
				}
			}
		});
		btnModulus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnModulus.setBounds(167, 277, 148, 52);
		frame.getContentPane().add(btnModulus);
		
		
		
		
	}

}
