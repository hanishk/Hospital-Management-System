import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class staffmain extends JFrame{

	public JFrame frame;
	JLabel lhospitalname,lmenu;
	JButton patientreg,logout,staffinfo;
	JButton patientinfo;
//	JButton pcheckout;
//	JButton roominfo;
	Font f=new Font("Aerial",Font.BOLD,30);

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffmain window = new staffmain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public staffmain() {
		setVisible(true);
		Toolkit tk=Toolkit.getDefaultToolkit();	
		int xsize=(int) tk.getScreenSize().getWidth();
         int ysize=	(int) tk.getScreenSize().getHeight();
      setSize(xsize,ysize);
		 getContentPane().setLayout(null);

			setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\hospitalimage.jpg")));

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	
	public void initialize() {
		 
	
		
		lhospitalname=new JLabel(" HOSPITAL MANAGMENT ");
		lhospitalname.setForeground(Color.BLACK);
		lhospitalname.setFont(f);
		lhospitalname.setBounds(700,30,400,100);
        getContentPane().add(lhospitalname);
  
    
       lmenu=new JLabel("STAFF MENU");
       lmenu.setForeground(Color.BLACK);
       lmenu.setFont(f);
       lmenu.setBounds(60,120,200,50);
       getContentPane().add(lmenu);
       
		patientreg=new JButton(" Patient Registration ");
		patientreg.setBounds(50,180,200,50);
		getContentPane().add(patientreg);
		 
		patientreg.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				new patientreg();
			
			 }
				});

//patient info	button
		patientinfo=new JButton("Patient Information");
		patientinfo.setBounds(50,250,200,50);
	getContentPane().add(patientinfo);
	
patientinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	       new patientinfo();
	
				
		}
	});

staffinfo =new JButton("Staff Information");
staffinfo.setBounds(50,320,200,50);
   getContentPane().add(staffinfo);
   
 staffinfo.addActionListener(new ActionListener() {
 	  public void actionPerformed(ActionEvent e) {
 	staffinfo2 s=new staffinfo2();
 	  }
   });

logout=new JButton("Logout");
logout.setBounds(50,390,200,50);
getContentPane().add(logout);

logout.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	 setVisible(false); 
	 login n=new login();
	 n.setVisible(true);
}
});    

      
		
	}

}
