import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.ResultSet;

import javax.swing.JFrame;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class staffinfo {

	public JFrame frame;
	public JTable table;
	private JButton bback;
	private JButton badd;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffinfo window = new staffinfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public staffinfo() {
		initialize();
		fetch();
	}

	
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setVisible(true);
		   Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
		   frame.setSize(1100,800);

		   int Width=frame.getSize().width;
	       int Height=frame.getSize().height;
	       
	       int locationX=((dm.width-Width)/2);
           int locationY=((dm.height-Height)/2);	
           frame.setLocation(locationX,locationY);
           
	
		
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 66, 879, 635);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		bback = new JButton("Back");
		bback.setForeground(Color.BLACK);
		bback.setFont(new Font("Tahoma", Font.BOLD, 16));
		bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		bback.setBounds(962, 254, 97, 51);
		frame.getContentPane().add(bback);
		
		badd = new JButton("Add");
		badd.setFont(new Font("Tahoma", Font.BOLD, 16));
		badd.setForeground(Color.BLACK);
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new staffreg();
			}
		});
		badd.setBounds(962, 108, 97, 51);
		frame.getContentPane().add(badd);
		
		JButton button = new JButton("Refresh");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new staffinfo();
				frame.setVisible(false);
			}
		});
		button.setBounds(962, 180, 97, 51);
		frame.getContentPane().add(button);
	}

	
	public void fetch() {
		try {
		connection c=new connection();
		PreparedStatement ps=(PreparedStatement) c.ce.prepareStatement("select * from addstaff");
		ResultSet rs=ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
}
