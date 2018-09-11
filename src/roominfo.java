import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class roominfo{

	public JFrame frame;
	public  JTable table;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					roominfo window = new roominfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public roominfo() {
		initialize();
		fetch();
	}

		private void initialize() {
		frame=new JFrame();
		frame.setBounds(100, 100, 1033, 683);
		frame.getContentPane().setLayout(null);
		
		JButton baddroom = new JButton("Add Rooms");
		baddroom.setFont(new Font("Tahoma", Font.BOLD, 16));
		baddroom.setBounds(607, 76, 125, 59);
		frame.getContentPane().add(baddroom);
		
		JButton brefresh = new JButton("Refresh");
		brefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new roominfo();
				frame.setVisible(false);
			}
		});
		brefresh.setFont(new Font("Tahoma", Font.BOLD, 16));
		brefresh.setBounds(607, 167, 125, 59);
		frame.getContentPane().add(brefresh);
		
		JButton bback = new JButton("Back");
		bback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			}
		});
		bback.setFont(new Font("Tahoma", Font.BOLD, 16));
		bback.setBounds(607, 263, 125, 59);
		frame.getContentPane().add(bback);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 38, 529, 559);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
		public void fetch() {
			try {
			connection c=new connection();
			PreparedStatement ps=(PreparedStatement) c.ce.prepareStatement("select * from hospital_room");
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
}
