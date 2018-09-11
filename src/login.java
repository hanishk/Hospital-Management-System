import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class login extends JFrame{


	   JLabel lloginsystem,luserid,lpassword,ltype;
	   JComboBox<String> ctype;
	    JTextField tuserid;
	    JPasswordField tpassword;
	    JButton blogin,breset,bexit;
	    JCheckBox showp;
	    Font f=new Font("Aerial",Font.BOLD,20);


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public login() {
	
		
	      getContentPane().setLayout(null);
	        setSize(703,566);
	    //    setLocation(433,233);
	   	 Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
		    int Width=getSize().width;
		    int height=getSize().height;
		    
		    int locationX=((dm.width-Width)/2);
		    int locationY=((dm.height-height)/2);
		    setLocation(locationX,locationY);  
	        setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\ho.jpg")));


	lloginsystem=new JLabel("Login System");
	lloginsystem.setForeground(new Color(0, 0, 205));
	lloginsystem.setBounds(200,30,250,80);
	lloginsystem.setFont(new Font("Dialog", Font.BOLD, 26));

	luserid=new JLabel("User-Id : ");
	luserid.setForeground(new Color(0, 0, 0));
	luserid.setBounds(50,120,150,100);
	luserid.setFont(new Font("Dialog", Font.BOLD, 24));
	
	lpassword=new JLabel("Password : ");
	lpassword.setForeground(new Color(0, 0, 0));
	lpassword.setBounds(50,200,150,100);
	lpassword.setFont(new Font("Dialog", Font.BOLD, 24));

	ltype=new JLabel("User Type");
	lpassword.setForeground(new Color(0, 0, 0));
	ltype.setBounds(50,280,150,100);
	ltype.setFont(new Font("Dialog", Font.BOLD, 24));
	add(ltype);
	
	ctype=new JComboBox<String>();
	ctype.setBounds(200,310,200,50);
	 ctype.setFont(f);
	add(ctype);
	ctype.addItem("admin");
	ctype.addItem("staff");
	
	
	tuserid=new JTextField(20);
	tuserid.setBounds(200,150,250,50);
	tuserid.setFont(f);
  
	tpassword=new JPasswordField(20);
	tpassword.setBounds(200,230,250,50);
	tpassword.setFont(f);
	
	showp=new JCheckBox("Show Password");
	showp.setBounds(200,280,150,20);
    add(showp);
    
    showp.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent arg0) {
    		if(showp.isSelected()) {
    			tpassword.setEchoChar((char)0);
    		}
    		else {
    			tpassword.setEchoChar('*');
    		}
    	}
    });
    
	blogin=new JButton("Login");
	blogin.setForeground(Color.ORANGE);
	blogin.setFont(new Font("Tahoma", Font.BOLD, 18));
	blogin.setBounds(50,400,100,60);

	breset=new JButton("Reset");
	breset.setForeground(Color.ORANGE);
	breset.setFont(new Font("Tahoma", Font.BOLD, 18));
	breset.setBounds(250,400,100,60);

	bexit=new JButton("Exit");
	bexit.setForeground(Color.ORANGE);
	bexit.setFont(new Font("Tahoma", Font.BOLD, 18));
	bexit.setBounds(450,400,100,60);

		 
	getContentPane().add(lloginsystem);
	getContentPane().add(luserid);
	getContentPane().add(lpassword);
	getContentPane().add(tuserid);
	getContentPane().add(tpassword);
	getContentPane().add(blogin);
	getContentPane().add(breset);
	getContentPane().add(bexit); 

	// login button
	blogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				String user=tuserid.getText();
				@SuppressWarnings("deprecation")
				String pwd=tpassword.getText();
				String status=String.valueOf(ctype.getSelectedItem());
				String query=("select * from login1 where user='"+user+"' and pwd='"+pwd+"' and status ='"+status+"' ");
				connection c=new connection();
                ResultSet rs=c.st.executeQuery(query);
			
			if(rs.next()) {
				javax.swing.JOptionPane.showMessageDialog(null, "Welcome "+rs.getString("status"));
			
				if(ctype.getSelectedIndex()==0) {
					 new mainpage();
				        tuserid.setText(null);
						tpassword.setText(null);
					setVisible(false);	
				}
				
				else if(ctype.getSelectedIndex()==1) {
	               new staffmain();
			        tuserid.setText(null);
					tpassword.setText(null);
				setVisible(false);	
				}
				}
			
			else {
		javax.swing.JOptionPane.showMessageDialog(null,"invalid userid and password");
		  }
			
			   }
			catch(Exception e) {
				e.printStackTrace();
			}
		
			
		}


		});

	 

	//  reset button  
	 breset.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		tuserid.setText(null);
		tpassword.setText(null);
		
	   }
	    });

	//  exit button
	bexit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}	

	}); 

	} 
	

}
