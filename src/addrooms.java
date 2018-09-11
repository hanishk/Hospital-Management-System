import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class addrooms {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addrooms window = new addrooms();
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
	public addrooms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 693, 608);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddRooms = new JLabel("Add Rooms");
		lblAddRooms.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddRooms.setBounds(138, 44, 135, 46);
		frame.getContentPane().add(lblAddRooms);
		
		JLabel lroomno = new JLabel("Room No.");
		lroomno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lroomno.setBounds(79, 156, 89, 46);
		frame.getContentPane().add(lroomno);
		
		JLabel lstatus = new JLabel("Status");
		lstatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lstatus.setBounds(79, 234, 89, 46);
		frame.getContentPane().add(lstatus);
		
		JLabel lprice = new JLabel("Price");
		lprice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lprice.setBounds(79, 318, 89, 54);
		frame.getContentPane().add(lprice);
		
		textField = new JTextField();
		textField.setBounds(207, 164, 212, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(207, 330, 212, 33);
		frame.getContentPane().add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(207, 242, 212, 33);
		frame.getContentPane().add(comboBox);
		
	}
}
