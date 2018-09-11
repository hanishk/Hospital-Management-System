import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class staffreg extends JFrame{
   
	JLabel heading,lid,lname,lage,lqualification,lspeciality,laddress,lstatus;
   JTextField tid,tname,tage,tqualification,tspeciality;
   JTextArea taddress;
   JButton save,back;
   JComboBox status;
	
	public staffreg() {

//design of frame		
		setVisible(true);
    	setLayout(null);
		setSize(800,800);
	     Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
	       int Width=getSize().width;
	       int Height=getSize().height;
	       
	       int locationX=((dm.width-Width)/2);
         int locationY=((dm.height-Height)/2);	
         setLocation(locationX,locationY);
         
       	setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\ho.jpg")));
//      setAlwaysOnTop(true);
    	

  // Labels		
    heading=new JLabel("Fill the following details");	  
    heading.setBounds(400,10,150,150);
    add(heading);
    

    status=new JComboBox();
    status.setBounds(250,285,100,30);
    add(status);
    status.addItem("Doctor");
    status.addItem("Nurse");
    status.addItem("Cleaner");
    
    lstatus=new JLabel("Status");
    lstatus.setBounds(100,280,100,30);
    add(lstatus);
    
    lname=new JLabel(" Name :");
    lname.setBounds(100,150,80,40);
    add(lname);
    
    lage=new JLabel("Age :");
    lage.setBounds(100,220,80,40);
    add(lage);
    
    lqualification=new JLabel("Qualification :");
    lqualification.setBounds(100,350,80,40);
    add(lqualification);
    
    lspeciality=new JLabel("Speciality :");
    lspeciality.setBounds(100,420,80,40);
    add(lspeciality);
    
    laddress=new JLabel("Address :");
    laddress.setBounds(100,490,80,40);
    add(laddress);
    
 //textfield 

    
    tname=new JTextField(20);
    tname.setBounds(250,155,300,40);
    add(tname);
    
    tage=new JTextField(20);
    tage.setBounds(250,225,300,40);
    add(tage);
    
    tqualification=new JTextField(20);
    tqualification.setBounds(250,355,300,40);
    add(tqualification);
    
    tspeciality=new JTextField(20);
    tspeciality.setBounds(250,425,300,40);
    add(tspeciality);
    
 // textarea
    taddress=new JTextArea();
    taddress.setBounds(250,495,300,100);
    add(taddress);
    
 // buttons
    save=new JButton("SAVE");
    save.setBounds(150,650,100,60);
    add(save);
    
    save.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    	
    	if(tname.getText().isEmpty() && tage.getText().isEmpty() && tqualification.getText().isEmpty() && taddress.getText().isEmpty() && tspeciality.getText().isEmpty()) {
    		javax.swing.JOptionPane.showMessageDialog(null,"Please fill all the details");
    	}	
    	else {
    		try {
    			connection c=new connection();
    			PreparedStatement rs=c.ce.prepareStatement("insert into addstaff(name,age,status,qualification,speciality,address) values(?,?,?,?,?,?)");
    			rs.setString(1,tname.getText());
    			rs.setString(2, tage.getText());
    			rs.setString(3, status.getSelectedItem().toString());
    			rs.setString(4, tqualification.getText());
    			rs.setString(5, tspeciality.getText());
    			rs.setString(6, taddress.getText());
    			int i=rs.executeUpdate();
    			
    			if(i==1) {
	    			javax.swing.JOptionPane.showMessageDialog(null, "Saved");
	    		}
	    		else
	    			javax.swing.JOptionPane.showMessageDialog(null, "Error");

    			
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	}
    });
    
    
    
    back=new JButton("BACK");
    back.setBounds(350,650,100,60);
    add(back);
    
    back.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent agr0) {
    		setVisible(false);
    	}
    });
		
	}
	

}//class
