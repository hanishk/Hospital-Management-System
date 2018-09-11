import java.awt.event.*;
import java.sql.PreparedStatement;
import java.awt.*;
import javax.swing.*;

public class signup extends JFrame {
		
	  JLabel luser,lpwd,lstatus,lcnt,lemail;
		JButton csignup,bback;
		JTextField tuser,tpwd,tcnt,temail;
		JComboBox<String> status;
		Font f=new Font("Aerial",Font.BOLD,20);
		
	public signup() {
			
			setVisible(true);
			setLayout(null);
           setSize(800,700);
            Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
 	       int Width=getSize().width;
 	       int Height=getSize().height;
 	       
 	       int locationX=((dm.width-Width)/2);
            int locationY=((dm.height-Height)/2);	
            setLocation(locationX,locationY);
            
           
 	      	setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\ho.jpg")));
 
		    
		  luser=new JLabel("UserId :");
		  luser.setBounds(100,100,80,40);
		  luser.setFont(f);
		  add(luser);
		  
		  lpwd=new JLabel("Password :");
		  lpwd.setBounds(100,170,100,30);
		  lpwd.setFont(f);
		  add(lpwd);
		  
		  lstatus=new JLabel("Status :");
		  lstatus.setBounds(100,240,90,50);
		  lstatus.setFont(f);
		  add(lstatus);
				  
		  lcnt=new JLabel("Mobile No. :");
		  lcnt.setBounds(100,310,130,70);
		  luser.setFont(f);
		  add(lcnt);
		  
		  lemail=new JLabel("e-mail-id :");
		  lemail.setBounds(100,380,160,90);
		  lemail.setFont(f);
		  add(lemail);
		 
		  tuser=new JTextField(20);
		  tuser.setBounds(300,105,200,30);
		  tuser.setFont(f);
		  add(tuser);
		  
		  tpwd=new JTextField(20);
		  tpwd.setBounds(300,175,200,30);
		  tpwd.setFont(f);
		  add(tpwd);
		  
		  status=new JComboBox<String>();
		  status.setBounds(300,250,200,30);
		  status.setFont(f);
		  add(status);
          status.addItem("staff");
		  
		  tcnt=new JTextField(20);
		  tcnt.setBounds(300,340,200,30);
		  lcnt.setFont(f);
		  add(tcnt);
		  
		  temail=new JTextField(20);
		  temail.setBounds(300,420,200,30);
		  lemail.setFont(f);
		  add(temail);
		
		  
		  csignup=new JButton("Signup");
		  csignup.setBounds(200,500,100,50);
		  luser.setFont(f);
		  add(csignup);
		  
		  csignup.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
		
		if(tuser.getText().isEmpty() && tpwd.getText().isEmpty() && tcnt.getText().isEmpty() && temail.getText().isEmpty()) {
			javax.swing.JOptionPane.showMessageDialog(null,"Please Enter all details");
		}
		else
		
			try
		{
			connection con=new connection();
			PreparedStatement ps=con.ce.prepareStatement("insert into login1(user,pwd,status,contact,email) values(?,?,?,?,?)");
			ps.setString(1,tuser.getText());
			ps.setString(2, tpwd.getText());
			ps.setString(3, status.getSelectedItem().toString()); //JCombobox getSelectedItems().to String();
			ps.setString(4, tcnt.getText());
			ps.setString(5, temail.getText());
			int i=ps.executeUpdate();
			if(i==1)
			{
				javax.swing.JOptionPane.showMessageDialog(null,"saved");
				setVisible(false);
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(null,"server failure");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
			  }
		  });
		 
		 bback=new JButton("Back");
		 bback.setBounds(350,500,100,50);
		 luser.setFont(f);
		 add(bback);
		 
		 bback.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 
				 
				 setVisible(false);
			 }
		 });
		  
	}
	public static void main(String[]args) {
		new signup();
	}
}

