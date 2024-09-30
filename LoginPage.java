package blood;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage  extends JFrame implements ActionListener{
	JButton bNewButton;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JButton btnNewButton_1;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPopupMenu popupMenu;
	public LoginPage() {
		getContentPane().setBackground(new Color(240, 128, 128));
		setTitle("Login Page");
		getContentPane().setLayout(null);
		setVisible(true);
		
		 lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(71, 194, 269, 109);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(228, 227, 293, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		 lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1.setBounds(71, 294, 141, 71);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(228, 302, 293, 40);
		getContentPane().add(passwordField);
		
		 bNewButton = new JButton("Login");
		 bNewButton.setForeground(Color.BLUE);
		bNewButton.setFont(new Font("Arial", Font.BOLD, 24));
		bNewButton.setBounds(127, 426, 124, 45);
		getContentPane().add(bNewButton);
		bNewButton.addActionListener(this);
		
		 btnNewButton_1 = new JButton("Close");
		 btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 24));
		btnNewButton_1.setBounds(322, 426, 116, 45);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Online Blood Bank Management System");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_2.setBounds(36, 22, 710, 121);
		getContentPane().add(lblNewLabel_2);
		
		 ImageIcon imageIcon = new ImageIcon("\\Users\\pradeep\\eclipse-workspace\\core_java\\src\\blood\\feeling.jpg");
		 Image image = imageIcon.getImage();
	     Image scaledImage = image.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
	     imageIcon = new ImageIcon(scaledImage);
	     JLabel backgroundLabel = new JLabel(imageIcon);
	    
	     backgroundLabel.setLabelFor(bNewButton);
	     getContentPane().add(backgroundLabel);
	     backgroundLabel.setBounds(-15, -41, 875, 770);
	    

		 lblNewLabel.setVisible(true);
		 setSize(800,800);
	}
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/bloodbank";
	    private static final String DB_USER = "root";
	    private static final String DB_PASS = "Roshni@07";

	    
	    private boolean checkLogin(String username, String password) {
	        boolean isValidUser = false;
	        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
	        
	        try {
	           
	            Class.forName("com.mysql.cj.jdbc.Driver");
	          
	            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, username);
	            ps.setString(2, password);

	            ResultSet rs = ps.executeQuery();
	           
	            if (rs.next()) {
	                isValidUser = true; 
	            }
	            
	            rs.close();
	            ps.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return isValidUser;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == bNewButton) {
	            String username = textField.getText();
	            String password = new String(passwordField.getPassword());

	            if (checkLogin(username, password)) {
	            	JOptionPane.showMessageDialog(getContentPane(), "You have successfully loggedIn!");
	                HomePage h = new HomePage(); 
	                h.setVisible(true);
	                setVisible(false); 
	            } else {
	                JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
	            }
	        } else if (e.getSource() == btnNewButton_1) {
	            int a = JOptionPane.showConfirmDialog(this, "Do you really want to close the application?", "Select", JOptionPane.YES_NO_OPTION);
	            if (a == 0) {
	                System.exit(0);
	            }
	        }
	    }
	    private void ActionPerformed(java.awt.event.ActionEvent evt) {
			int a=JOptionPane.showConfirmDialog(btnNewButton_1, "Do you really want to close Application","select",JOptionPane.YES_NO_OPTION);
			if(a==0) {
				System.exit(0);
			}
		}

	    public static void main(String[] args) {
	        new LoginPage();
	    }
	
	
}

	
