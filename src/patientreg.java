import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class patientreg extends JFrame implements ItemListener {
	
	JLabel lpatientid,linfo,lname,lage,lgender,laddress,lpincode,lmale,lfemale,lcheckin,ldate,lroom,lprice;
    JTextField tpatientid,tname,tage,tpincode,tprice;  
	  JTextArea taddress;
	  Choice cgender,croom;
	 JButton bsave,bback;
	
	public void clock(){
		Calendar cl=new GregorianCalendar();
		int day=cl.get(Calendar.DAY_OF_MONTH);
		int month=cl.get(Calendar.MONTH);
		int year=cl.get(Calendar.YEAR);
		month=month+1;
lcheckin.setText(day+"-"+month+"-"+year);

	} 
public  patientreg() {
	
		
	          setVisible(true);
	          setLayout(null);
	          setSize(900,900);
	       Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
	       int Width=getSize().width;
	       int Height=getSize().height;
	       
	       int locationX=((dm.width-Width)/2);
           int locationY=((dm.height-Height)/2);	
           setLocation(locationX,locationY);
           
          
	     	setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\ho.jpg")));
//	     	setAlwaysOnTop(true);


// JLabel    
	      	
	      	linfo=new JLabel("Fill the following details");
	           linfo.setBounds(400,30,150,50);
	          add(linfo);
	           
	         ldate=new JLabel("Checkin Date :");
	         ldate.setBounds(100,120,100,40);
	         add(ldate);
	         
	         lcheckin=new JLabel();
	         lcheckin.setBounds(250,120,80,40);
	         add(lcheckin);
	         
			  lname=new JLabel("Name : ");
	          lname.setBounds(100,170,80,40);
	       add(lname);
		
	         lage=new JLabel("Age : ");
	         lage.setBounds(100,230,80,40);
	      add(lage);
			
	        lgender=new JLabel("Gender :");
	        lgender.setBounds(100,300,80,40);
	       add(lgender);
			
	        laddress=new JLabel("Address :");
	        laddress.setBounds(100,395,80,40);
	       add(laddress);
	        
	        lpincode=new JLabel("Area Pincode :");
	        lpincode.setBounds(100,510,100,40);
	   add(lpincode);
	   
	   lroom =new JLabel("RoomNo");
	   lroom.setBounds(100,585,100,40);
	   add(lroom);
	   
	   lprice=new JLabel("Price");
	   lprice.setBounds(100,655,100,40);
	   add(lprice);
	   
	   
	   

// textfield
	       tname=new JTextField(20);
	       tname.setBounds(250,175,300,40);
	     add(tname); 
	       
	       tage=new JTextField(20);
	       tage.setBounds(250,235,300,40);
	    add(tage); 
	       
	       tpincode=new JTextField(20);
	       tpincode.setBounds(250,515,300,40);
	      add(tpincode);
	      
	      tprice=new JTextField(20);
	      tprice.setBounds(250,660,100,40);
	      add(tprice);
	      
	    	  
	      
	       
 //JRadiobutton
	       cgender=new Choice();
	       cgender.setBounds(250,305,150,30);
	       add(cgender);
	       cgender.add("Male");
	       cgender.add("Female");
	       
	       croom=new Choice();
	       croom.setBounds(250,590,150,30);
	    croom.addItemListener(this);
	       add(croom);
	       croom.add("select room");
      try {
	    	  	    	 
	    		connection c=new connection();
    			PreparedStatement ps=c.ce.prepareStatement("select * from hospital_room where Status='Available'");
    			ResultSet rs=ps.executeQuery();
    			while(rs.next())
    			{
    				croom.add(rs.getString("Room_No"));
    			}
      }
      catch(Exception e)
      {
    	  e.printStackTrace();
      }
//	   	int index=croom.getSelectedIndex();
//		croom.removeItemAt(index);
//	    
	       
	       taddress=new JTextArea();
	       taddress.setBounds(250,390,300,80);
	     add(taddress);
	    
	
 // JButton(actionlistener)
	   
	   // add new patient    
	      
	       bback=new JButton("Back");  // back button
	       bback.setBounds(300,760,100,60);
	       add(bback);
	    
	      bback.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent arg0) {
	    	     setVisible(false);        
	    		     		
	    		     		
	    		
	    	  }
	      });
	// Patient Save button   	       
	      
	      bsave=new JButton("Save");
	       bsave.setBounds(150,760,100,60);
	    add(bsave);
	  
	  
            bsave.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent arg0) {

	    if(tname.getText().isEmpty() && tage.getText().isEmpty() && taddress.getText().isEmpty() && tpincode.getText().isEmpty()) {
	    	javax.swing.JOptionPane.showMessageDialog(null, "Please fill all the details");
	    }		   
	    else {	   
	    		   try {
	    		connection c=new connection();
	    		PreparedStatement r=c.ce.prepareStatement("insert into patientreg(name,age,gender,address,pincoode,room,price) values(?,?,?,?,?,?,?)");
	    		
	    		r.setString(1, tname.getText());
	    		r.setString(2,tage.getText());
	    		r.setString(3,cgender.getSelectedItem().toString());
	    		r.setString(4, taddress.getText());
	    		r.setString(5,tpincode.getText());
	    		r.setString(6, croom.getSelectedItem().toString());
                r.setString(7, tprice.getText());
	    		int i=r.executeUpdate();
	    		if(i==1) {
	    			javax.swing.JOptionPane.showMessageDialog(null, "Saved");
	    			  setVisible(false);
	    		}
	    		else
	    			javax.swing.JOptionPane.showMessageDialog(null, "Error");
	    	}  
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    		
	    		  
	    }
	  
	 
	    }
	       });
            
			clock();
		
		
			}
public static void main(String[]args) {
	new patientreg();
}
@Override
public void itemStateChanged(ItemEvent arg0) {
	try {
	    	 
		connection c=new connection();
		PreparedStatement ps=c.ce.prepareStatement("select * from hospital_room where Room_No='"+croom.getSelectedItem()+"'");
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		tprice.setText(""+rs.getDouble("price"));
		}
}
catch(Exception e)
{
  e.printStackTrace();
}
	
}
	
		
	  }
	  
