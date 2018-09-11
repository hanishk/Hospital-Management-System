import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pcheckout1 extends JFrame{
	public JTextField tname;
	public JTextField tage;
	public JTextField tgender;
	public JTextField taddress;
	public JTextField tpincode;
	public JTextField troom;
	public JTextField tmedicine;
	public JTextField ttotal;

	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pcheckout1 window = new pcheckout1();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public pcheckout1() {
		initialize();
//		  int medicineprice=Integer.parseInt(tmedicine.getText());
//		  patientreg p=new patientreg();
//		int regfees= Integer.parseInt(p.tprice.getText());
//		 int total=medicineprice+regfees;
//		 ttotal.setText(Integer.toString(total));
	}


	private void initialize() {
		
		setBounds(100, 100, 1047, 762);
		getContentPane().setLayout(null);
		
		JLabel lname = new JLabel("Name :");
		lname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lname.setBounds(239, 88, 69, 28);
		getContentPane().add(lname);
		
		JLabel lage = new JLabel(" Age :");
		lage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lage.setBounds(239, 146, 69, 28);
		getContentPane().add(lage);
		
		JLabel lgender = new JLabel("Gender :");
		lgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lgender.setBounds(239, 201, 69, 28);
		getContentPane().add(lgender);
		
		JLabel laddress = new JLabel("Address :");
		laddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		laddress.setBounds(239, 261, 69, 28);
		getContentPane().add(laddress);
		
		JLabel lpincode = new JLabel("Pincode :");
		lpincode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lpincode.setBounds(239, 314, 69, 28);
		getContentPane().add(lpincode);
		
		JLabel lroom = new JLabel("RoomNo :");
		lroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lroom.setBounds(239, 371, 85, 28);
		getContentPane().add(lroom);
		
		JLabel lprice = new JLabel("Total Price :");
		lprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lprice.setBounds(239, 500, 100, 28);
		getContentPane().add(lprice);
		
		tname = new JTextField();
		tname.setBounds(371, 86, 208, 35);
		getContentPane().add(tname);
		tname.setColumns(10);
		
		tage = new JTextField();
		tage.setColumns(10);
		tage.setBounds(371, 144, 208, 35);
		getContentPane().add(tage);
		
		tgender = new JTextField();
		tgender.setColumns(10);
		tgender.setBounds(371, 199, 208, 35);
		getContentPane().add(tgender);
		
		taddress = new JTextField();
		taddress.setColumns(10);
		taddress.setBounds(371, 259, 208, 35);
		getContentPane().add(taddress);
		
		tpincode = new JTextField();
		tpincode.setColumns(10);
		tpincode.setBounds(371, 312, 208, 35);
		getContentPane().add(tpincode);
		
		troom = new JTextField();
		troom.setColumns(10);
		troom.setBounds(371, 369, 208, 35);
		getContentPane().add(troom);
		
		tmedicine = new JTextField();
		tmedicine.setColumns(10);
		tmedicine.setBounds(371, 429, 208, 35);
		getContentPane().add(tmedicine);
		
		JLabel lblPatientCheckout = new JLabel("Patient CheckOut");
		lblPatientCheckout.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPatientCheckout.setBounds(289, 29, 290, 28);
		getContentPane().add(lblPatientCheckout);
		
		JButton bok = new JButton("OK");
		bok.setFont(new Font("Tahoma", Font.BOLD, 16));
		bok.setBounds(196, 609, 100, 45);
		getContentPane().add(bok);
		
		JButton bback = new JButton("Back");
		bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		bback.setFont(new Font("Tahoma", Font.BOLD, 16));
		bback.setBounds(370, 609, 100, 45);
		getContentPane().add(bback);
		
		JLabel lmedicine = new JLabel("Medicine");
		lmedicine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lmedicine.setBounds(239, 438, 71, 28);
		getContentPane().add(lmedicine);
		
		ttotal = new JTextField();
		ttotal.setColumns(10);
		ttotal.setBounds(371, 498, 208, 35);
		getContentPane().add(ttotal);
		

	 
	 
	}
}
