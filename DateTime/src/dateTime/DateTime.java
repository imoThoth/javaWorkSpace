package dateTime;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
//import java.util.Calendar;

public class DateTime {

	private JFrame frame;
	private JLabel lblClock; // make the variable global

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateTime window = new DateTime();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void datetime() {
		Thread datetime = new Thread() {
		
			public void run() {
				try { // catches any possible exception
					for(;;) {
						Calendar cal = new GregorianCalendar();
						
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						
						int sec = cal.get(Calendar.SECOND);
						int min = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);
						
						lblClock.setText("Time " + hour + ":" + min + ":" + sec + " "
						+ "Date " + day + "/"+ month + "/" + year );
					}
					
				} catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, "an error occured, please restart");
				}
			}
		};
		
		datetime.start();
	}

	/**
	 * Create the application.
	 */
	public DateTime() {
		initialize();
		datetime();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblClock = new JLabel("Clock"); 
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblClock.setBounds(12, 27, 408, 128);
		frame.getContentPane().add(lblClock);
	}
}
