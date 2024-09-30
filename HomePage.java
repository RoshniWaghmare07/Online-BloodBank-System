package blood;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class HomePage extends JFrame implements ActionListener {
	 private JMenuItem mNewMenuItem;
	 private JMenuItem mNewMenuItem_1 ;
	  private JMenuItem mntmNewMenuItem_2;
	  JMenu mnNewMenu_2;
	  JMenu mnNewMenu_3;
	  JMenuItem mntmNewMenuItem_3;
	  JMenuItem mntmNewMenuItem_4;
	  JMenuItem mntmNewMenuItem_5 ;
	  JMenuItem mntmNewMenuItem_6;
	  JMenuItem mntmNewMenuItem_7 ;
	  JMenuItem mntmNewMenuItem_8 ;

		JMenuItem mntmNewMenuItem;
	    public HomePage() {
	    	setTitle("Home Page");
		getContentPane().setBackground(new Color(255, 250, 205));
		setVisible(true);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBounds(0, 0, 629, 37);
		getContentPane().add(menuBar);
		
		JMenu NewMenu1 = new JMenu("Donar");
		NewMenu1.setForeground(SystemColor.desktop);
		NewMenu1.setBackground(new Color(240, 248, 255));
		menuBar.add(NewMenu1);
		NewMenu1.setFont(new Font("Arial", Font.BOLD, 19));
		
		 mNewMenuItem = new JMenuItem("Add new Donar");
		mNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		NewMenu1.add(mNewMenuItem);
		
	     mNewMenuItem_1 = new JMenuItem("Update Details");
		NewMenu1.add(mNewMenuItem_1);
		mNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		
		 mntmNewMenuItem_2 = new JMenuItem("All Donar Details");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		NewMenu1.add(mntmNewMenuItem_2);

		
		JMenu mnNewMenu_1 = new JMenu("Search Blood Donar");
		mnNewMenu_1.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 19));
	
		mntmNewMenuItem_3 = new JMenuItem("Location");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
	 mntmNewMenuItem_4 = new JMenuItem("Blood Group");
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		mnNewMenu_3 = new JMenu("Delete Donar  ");
		mnNewMenu_3.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu_3);
		mnNewMenu_3.setFont(new Font("Arial", Font.BOLD, 19));
		
	    mntmNewMenuItem = new JMenuItem("Delete Donor");
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnNewMenu_3.add(mntmNewMenuItem);
		
		 mnNewMenu_2 = new JMenu("Stock");
		 mnNewMenu_2.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu_2);
		mnNewMenu_2.setFont(new Font("Arial", Font.BOLD, 19));
		
		mntmNewMenuItem_5 = new JMenuItem("Increase");
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		 mntmNewMenuItem_6 = new JMenuItem("Decrease");
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_4 = new JMenu("Exit");
		mnNewMenu_4.setForeground(SystemColor.desktop);
		menuBar.add(mnNewMenu_4);
		mnNewMenu_4.setFont(new Font("Arial", Font.BOLD, 19));
		
		 mntmNewMenuItem_7 = new JMenuItem("Logout");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		 mntmNewMenuItem_8 = new JMenuItem("Exit Application");
		mntmNewMenuItem_8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_4.add(mntmNewMenuItem_8);
		 mnNewMenu_3.addActionListener(this);
		mNewMenuItem.addActionListener(this);
		mNewMenuItem_1.addActionListener(this);
		mntmNewMenuItem_2.addActionListener(this);
		mntmNewMenuItem_3.addActionListener(this);
		mntmNewMenuItem_4.addActionListener(this);
		mntmNewMenuItem_5.addActionListener(this);
		mntmNewMenuItem_6.addActionListener(this);
		 mntmNewMenuItem_7 .addActionListener(this);
		 mntmNewMenuItem_8 .addActionListener(this);	

	 mntmNewMenuItem.addActionListener(this);

		ImageIcon imageIcon = new ImageIcon("\\Users\\pradeep\\eclipse-workspace\\core_java\\src\\blood\\blooddonation.png");
		 Image image = imageIcon.getImage();
	     Image scaledImage = image.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
	     imageIcon = new ImageIcon(scaledImage);
	     JLabel backgroundLabel = new JLabel(imageIcon);
	     backgroundLabel.setBackground(new Color(255, 0, 0));
	     getContentPane().add(backgroundLabel);
	     backgroundLabel.setBounds(-216, -148, 1400, 975);
		setSize(1000,700);
	}

	public static void main(String[] args) {
		new HomePage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == mNewMenuItem) {
		        AddDonar a = new AddDonar();
		        a.setVisible(true);
		        setVisible(false); 
		    } else if (e.getSource() == mNewMenuItem_1) {
		        UpdateDonar u = new UpdateDonar();
		        u.setVisible(true);
		    }
		    else if(e.getSource()==mntmNewMenuItem_2) {
		    	DisplayDonor d=new DisplayDonor();
		    	d.setVisible(true);
		    	setVisible(false);
		    }
		    else if(e.getSource()== mntmNewMenuItem_5 ) {
		    	IncreaseStock i=new IncreaseStock();
		    	i.setVisible(true);
		    	setVisible(false);
		    }
		    else  if(e.getSource()== mntmNewMenuItem) {
		    	DeleteDonor d=new DeleteDonor();
		    	d.setVisible(true);
		    	setVisible(false);
		    }
		    else if(e.getSource()== mntmNewMenuItem_6) {
		    	DecreaseStock d=new DecreaseStock();
		    	d.setVisible(true);
		    	setVisible(false);
		    	}
		    else if(e.getSource()==mntmNewMenuItem_3)
		    {
		    	LocationSearch l=new LocationSearch();
		    	l.setVisible(true);
		    	setVisible(false);
		    }
		    else if(e.getSource()== mntmNewMenuItem_4) {
		    	BDSearch b=new BDSearch();
		    	b.setVisible(true);
		    	setVisible(false);
		    }
		    else if(e.getSource()== mntmNewMenuItem_7 ) {
		    	new LoginPage();
		    	setVisible(false);
		    }
		    else if (e.getSource() == mntmNewMenuItem_8) {
				int confirmed = JOptionPane.showConfirmDialog(null,
						"Do you really  want to exit the application?", "Exit Confirmation",
						JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					System.exit(0); 
				}
			}
		}
}
