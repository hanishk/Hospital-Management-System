import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class mainpage extends JFrame {
	

	JLabel lhospitalname,lmenu;
	JButton patientreg,logout,addstaff,staffinfo;
	JButton bsignup;
	JButton patientinfo;
	JButton pcheckout;
	JButton roominfo;
	Font f=new Font("Aerial",Font.BOLD,30);
	
public mainpage(){
		
// main page
		

			setVisible(true);

			Toolkit tk=Toolkit.getDefaultToolkit();	
			int xsize=(int) tk.getScreenSize().getWidth();
	         int ysize=	(int) tk.getScreenSize().getHeight();
	         setSize(xsize,ysize);
			
	         setLayout(null);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // when close the main page all programs are close.
	
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\hospitalimage.jpg")));

		
// Heading on main page	
						lhospitalname=new JLabel(" HOSPITAL MANAGMENT ");
						lhospitalname.setFont(f);
						lhospitalname.setBounds(700,30,400,100);
	                    add(lhospitalname);
                  
	                
	                  
	                   lmenu=new JLabel("MENU");
	                   lmenu.setFont(f);
	                   lmenu.setBounds(110,120,200,50);
	                   add(lmenu);
	                  
	                   
	                    
// signup button
	                    bsignup=new JButton("Add New User");
	                    bsignup.setBounds(50,460,200,50);
	                   add(bsignup);
	                    
	              bsignup.addActionListener(new ActionListener(){
	            	  public void actionPerformed(ActionEvent e) {
	                      signup s=new signup();
	            		  
	            	  }
	              } );     
						
//new patient button						
			patientreg=new JButton(" Patient Registration ");
			patientreg.setBounds(50,180,200,50);
			add(patientreg);
			 
			patientreg.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
						patientreg newpatient=new patientreg();
				
				 }
					});

// patient info	button
			patientinfo=new JButton("Patient Information");
			patientinfo.setBounds(50,250,200,50);
		add(patientinfo);
		
   patientinfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		patientinfo info=new patientinfo();
		
					
			}
		});
               
 // patient checkout
//   pcheckout=new JButton("Patient Checkout");
//   pcheckout.setBounds(50,290,200,50);
//   add(pcheckout);
//   
//    pcheckout.addActionListener(new ActionListener() {
//    	public void actionPerformed(ActionEvent e) {
//    	pcheckout1 out=new pcheckout1();
//    	out.setVisible(true);
//    	}
//    });   
//   
 // room info
//    roominfo=new JButton("Room Information");
//    roominfo.setBounds(50,350,200,50);
//     add(roominfo);
//     
//    roominfo.addActionListener(new ActionListener() {
//    	public void actionPerformed(ActionEvent e) {
//    		roominfo room=new roominfo();
//    	}
//    }); 
    
    
//add doctors
             addstaff=new JButton("Staff Registration");
             addstaff.setBounds(50,320,200,50);
             add(addstaff);
             
             addstaff.addActionListener(new ActionListener() {
            	 public void actionPerformed(ActionEvent e) {

                       staffreg adddoc=new staffreg();
            	          	 }
             });
             
// doct info
         staffinfo =new JButton("Staff Information");
       staffinfo.setBounds(50,390,200,50);
          add(staffinfo);
          
        staffinfo.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent e) {
        	staffinfo s=new staffinfo();
        	  }
          });
             
             
      //logout button
             logout=new JButton("Logout");
             logout.setBounds(50,530,200,50);
             add(logout);
             
         logout.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 setVisible(false); 
        		 login n=new login();
        		 n.setVisible(true);
        	 }
         });    
             
			
			
	}//method

	

	
	
	}//class
	
	
	
	
	
	
	
	
