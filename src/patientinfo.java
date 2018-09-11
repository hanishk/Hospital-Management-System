import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class patientinfo {

	public JFrame frame;
	public JTable table;
	public JScrollPane scrollPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientinfo window = new patientinfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public patientinfo() {
		initialize();
	fetch();
	}

	
	public void initialize() {
		
		frame = new JFrame();
		frame.setVisible(true);
		   Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
		   frame.setSize(1100,800);

		   int Width=frame.getSize().width;
	       int Height=frame.getSize().height;
	       
	       int locationX=((dm.width-Width)/2);
           int locationY=((dm.height-Height)/2);	
           frame.setLocation(locationX,locationY);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 37, 901, 716);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	   
		
		JButton bupdate = new JButton("ADD");
		bupdate.setBounds(954, 78, 106, 52);
		bupdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		bupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new patientreg();
				
			}
		});
		frame.getContentPane().add(bupdate);
		
		JButton brefresh = new JButton("Refresh");
		brefresh.setBounds(954, 167, 106, 52);
		brefresh.setFont(new Font("Tahoma", Font.BOLD, 16));
		brefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    new patientinfo();
				frame.setVisible(false);
			
				
			}
		});
		frame.getContentPane().add(brefresh);
		
		JButton bback = new JButton("Back");
		bback.setBounds(954, 253, 106, 52);
		bback.setFont(new Font("Tahoma", Font.BOLD, 16));
		bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 frame.setVisible(false);
			}
		});
		frame.getContentPane().add(bback);
	}
  public void fetch() {
	  try { 
	 		connection c=new connection();
	          PreparedStatement ps= (PreparedStatement) c.ce.prepareStatement("select * from patientreg");
	          ResultSet rs=ps.executeQuery();
	          table.setModel(DbUtils.resultSetToTableModel(rs));
	          
	         
	         }
	         catch(Exception e) {
	         	e.printStackTrace();
	         }
  }
}
