package blood;


import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AddDonar extends JFrame {
    public String fullname, fathername, mothername, dob, mobileno, gender, email,bloodgroup, city, address;
    JButton btnNewButton_1;
    JButton btnNewButton;
    int id=0;
    JComboBox<String> comboBox_1;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JDateChooser dateChooser;
    JComboBox<String> comboBox;
    private JTextField textField_id;

    public AddDonar() {
    	setTitle("Add Donor");
        getContentPane().setForeground(new Color(0, 0, 0));
        getContentPane().setFont(new Font("Tibetan Machine Uni", Font.BOLD, 19));
        getContentPane().setBackground(new Color(250, 128, 114));
        getContentPane().setLayout(null);
        setSize(1400, 700);
        setVisible(true);

        JLabel lblAddNewDonar = new JLabel("Add New Donar");
        lblAddNewDonar.setFont(new Font("Tibetan Machine Uni", Font.BOLD, 24));
        lblAddNewDonar.setForeground(new Color(0, 0, 0));
        lblAddNewDonar.setBounds(147, 7, 282, 38);
        getContentPane().add(lblAddNewDonar);

        JLabel lblAddNewDonar_1 = new JLabel("New Donar Id");
        lblAddNewDonar_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lblAddNewDonar_1.setForeground(new Color(0, 0, 0));
        lblAddNewDonar_1.setBounds(12, 57, 136, 15);
        getContentPane().add(lblAddNewDonar_1);

        JLabel lblNewLabel = new JLabel("Full Name");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel.setBounds(12, 84, 108, 38);
        getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.BOLD, 14));
        textField.setForeground(new Color(0, 0, 0));
        textField.setBounds(122, 88, 200, 32);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Father Name");
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setBounds(12, 142, 108, 30);
        getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Dialog", Font.BOLD, 14));
        textField_1.setForeground(new Color(0, 0, 0));
        textField_1.setBounds(122, 142, 200, 30);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Dialog", Font.BOLD, 14));
        textField_2.setBounds(122, 196, 200, 30);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblMotherName = new JLabel("Mother Name");
        lblMotherName.setFont(new Font("Dialog", Font.BOLD, 14));
        lblMotherName.setForeground(new Color(0, 0, 0));
        lblMotherName.setBounds(12, 196, 121, 40);
        getContentPane().add(lblMotherName);

        JLabel lblNewLabel_2 = new JLabel("Date of Birth");
        lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setBounds(12, 248, 108, 23);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Mobile No.");
        lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_3.setBounds(12, 285, 98, 26);
        getContentPane().add(lblNewLabel_3);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Dialog", Font.BOLD, 14));
        textField_4.setBounds(122, 281, 176, 27);
        getContentPane().add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Gender");
        lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setBounds(12, 323, 70, 25);
        getContentPane().add(lblNewLabel_4);

        comboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
        comboBox.setBackground(new Color(238, 238, 238));
        comboBox.setToolTipText("\n");
        comboBox.setBounds(122, 320, 111, 24);
        getContentPane().add(comboBox);

        JLabel lblNewLabel_5 = new JLabel("Email");
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_5.setBounds(374, 73, 98, 61);
        getContentPane().add(lblNewLabel_5);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField_5.setBounds(437, 90, 220, 32);
        getContentPane().add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Blood Group");
        lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_6.setForeground(Color.BLACK);
        lblNewLabel_6.setBounds(364, 146, 108, 23);
        getContentPane().add(lblNewLabel_6);

        comboBox_1 = new JComboBox<>(new String[]{"A+", "B+", "AB+", "O+", "O-", "A-", "B-", "AB-"});
        comboBox_1.setFont(new Font("Dialog", Font.BOLD, 12));
        comboBox_1.setBounds(486, 145, 123, 24);
        getContentPane().add(comboBox_1);

        JLabel lblNewLabel_7 = new JLabel("City");
        lblNewLabel_7.setForeground(Color.BLACK);
        lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_7.setBounds(374, 199, 57, 22);
        getContentPane().add(lblNewLabel_7);

        textField_6 = new JTextField();
        textField_6.setFont(new Font("Dialog", Font.BOLD, 14));
        textField_6.setBounds(437, 196, 220, 24);
        getContentPane().add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Complete Address");
        lblNewLabel_8.setForeground(Color.BLACK);
        lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 14));
        lblNewLabel_8.setBounds(352, 232, 151, 33);
        getContentPane().add(lblNewLabel_8);

        btnNewButton = new JButton("Reset");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(147, 384, 78, 25);
        getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("Add");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setBounds(324, 384, 78, 25);
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Back");
        btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 14));
        btnNewButton_2.setForeground(Color.BLACK);
        btnNewButton_2.setBounds(501, 384, 89, 25);
        getContentPane().add(btnNewButton_2);

        TextArea textArea = new TextArea();
        textArea.setBounds(362, 266, 275, 87);
        getContentPane().add(textArea);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(122, 252, 176, 19);
        getContentPane().add(dateChooser);
        textField_id = new JTextField();
	     textField_id.setFont(new Font("Tahoma", Font.BOLD, 14));
	     textField_id.setBounds(122, 56, 96, 20);
	     getContentPane().add(textField_id);
	     textField_id.setColumns(10);
        
        try {
        	 
        		    Class.forName("com.mysql.cj.jdbc.Driver");
        		    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "Roshni@07");
        		    Statement st=c.createStatement();
        		    ResultSet rs=st.executeQuery("SELECT MAX(donorid) from donors");
        		while(rs.next()) {
        			id=rs.getInt(1);
        			
        		}
       textField_id.setText(""+(id+1));
       textField_id.setEditable(false);
           
        }catch(Exception e) {
	    	System.out.println(e);
	    }

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	fullname = textField.getText();
                fathername = textField_1.getText();
                mothername = textField_2.getText();
                Date date = dateChooser.getDate();
                dob = date != null ? new SimpleDateFormat("yyyy-MM-dd").format(date) : "";
                mobileno = textField_4.getText();
               
               gender = (String) comboBox.getSelectedItem();
                email = textField_5.getText();
                bloodgroup = (String) comboBox_1.getSelectedItem();
                city = textField_6.getText();
                address = textArea.getText(); 
                
                if (fullname.isEmpty() || fathername.isEmpty() || mothername.isEmpty() || dob.isEmpty() || mobileno.isEmpty() ||
                        gender.isEmpty() || email.isEmpty() || bloodgroup.isEmpty() || city.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    
			 }
                if (!mobileno.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Please enter a 10-digit number.");
                    return;
                }

                // Validation for Email
                if (!validateEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid Email Address. Please enter a valid email.");
                    return;
                }
                else{ 
                	insertValueIntoDatabase();

                // Show success message
                JOptionPane.showMessageDialog(getContentPane(), "You have successfully added as User");
                }
            }
        });

        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HomePage();
            }
        });
        btnNewButton.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				 textField_1.setText("");
				 textField_2.setText("");
				 textField_4.setText("");
				 textField_5.setText("");
				 textField_6.setText("");
				 textArea.setText(" ");
				 
			}
        });
        ImageIcon imageIcon = new ImageIcon("\\Users\\pradeep\\eclipse-workspace\\core_java\\src\\blood\\bgroup.png");
		 Image image = imageIcon.getImage();
	     Image scaledImage = image.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
	     imageIcon = new ImageIcon(scaledImage);
	     JLabel backgroundLabel = new JLabel(imageIcon);
	     backgroundLabel.setBackground(new Color(255, 0, 0));
	     getContentPane().add(backgroundLabel);
	     backgroundLabel.setBounds(667, 7, 606, 656);
	     
	    
        
    }
    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    

    public static void main(String[] args) {
        new AddDonar();
    }

    void insertValueIntoDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "Roshni@07");
            PreparedStatement ps = c.prepareStatement("INSERT INTO Donors (fullname, fathername, mothername, dob, mobileno, gender, email, bloodgroup, city, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, fullname);
            ps.setString(2, fathername);
            ps.setString(3, mothername);
            ps.setString(4, dob);
            ps.setString(5,mobileno);
            ps.setString(6, gender);
            ps.setString(7, email);
            ps.setString(8, bloodgroup);
            ps.setString(9, city);
            ps.setString(10, address);
            int i = ps.executeUpdate();
            System.out.println(i + " row(s) inserted.");
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}