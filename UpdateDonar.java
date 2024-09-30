package blood;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public  class UpdateDonar extends JFrame   {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_1;
	public UpdateDonar() {
		getContentPane().setBackground(new Color(255, 250, 205));
		
		setSize(700,700);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 133, 99, 39);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(109, 133, 170, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Father Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 194, 113, 37);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mother Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 278, 113, 30);
		getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setBounds(133, 271, 136, 45);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Birth");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 331, 123, 38);
		getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setBounds(121, 333, 148, 39);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(111, 402, 158, 39);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_5.setColumns(10);
		textField_5.setBounds(372, 123, 271, 39);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Mobile No.");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(10, 400, 123, 38);
		getContentPane().add(lblNewLabel_5_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(121, 200, 148, 45);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_5_2 = new JLabel("Gender");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5_2.setBounds(303, 183, 159, 58);
		getContentPane().add(lblNewLabel_5_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "other"}));
		comboBox.setBackground(new Color(211, 211, 211));
		comboBox.setEditable(true);
		comboBox.setBounds(384, 193, 259, 38);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(306, 123, 91, 34);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(70, 541, 99, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(273, 541, 89, 44);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Blood Group");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(303, 252, 107, 41);
		getContentPane().add(lblNewLabel_7);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A+", "B+", "AB+", "O+", "O-", "AB-", "B-", "A-"}));
		comboBox_1.setBounds(430, 254, 213, 37);
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(310, 304, 87, 39);
		getContentPane().add(lblNewLabel_8);
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Dialog", Font.BOLD, 14));
		textArea.setBounds(320, 344, 323, 97);
		getContentPane().add(textArea);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(477, 542, 91, 42);
		getContentPane().add(btnNewButton_2);

		setSize(700,700);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Update Donar Details");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 26));
		lblNewLabel.setBounds(66, -20, 362, 109);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Donor ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(99, 76, 87, 30);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 74, 96, 39);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(331, 82, 89, 23);
		getContentPane().add(btnNewButton_3);
   btnNewButton_1.addActionListener(new ActionListener() {
        	
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
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HomePage();			}
		});
        btnNewButton_3.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
                String donor_id = textField_1.getText();
                if (donor_id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Donor ID cannot be empty.");
                    return;
                }

                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "Roshni@07");

                    String query = "SELECT * FROM donors WHERE donorid = ?";
                    PreparedStatement pst = c.prepareStatement(query);
                    pst.setString(1, donor_id);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                       
                        textField.setText(rs.getString("fullname"));
                        textField_6.setText(rs.getString("fathername"));
                        textField_2.setText(rs.getString("mothername"));
                        textField_3.setText(rs.getString("dob"));
                        textField_4.setText(rs.getString("mobileno"));
                        comboBox.setSelectedItem(rs.getString("gender"));
                        textField_5.setText(rs.getString("email"));
                        comboBox_1.setSelectedItem(rs.getString("bloodgroup"));
                        textArea.setText(rs.getString("address")); 
                        
                        }
                    else {
                        JOptionPane.showMessageDialog(null, "Donor not found with the provided ID.");
                    }

                    c.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error fetching donor details.");
                }
            }
        });
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
                String updateQuery = "UPDATE donors SET fullname = ?,fathername=?,mothername=?,dob=?,mobileno=?,gender=?,email=?, bloodgroup = ?,address=? WHERE donorid = ?";

                // Establishing the connection and executing the update statement
                try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "Roshni@07");
                     PreparedStatement preparedStatement = c.prepareStatement(updateQuery)) {

                    // Set parameters for the PreparedStatement
                    preparedStatement.setString(1,textField.getText() );
                    preparedStatement.setString(2,textField_6.getText() );
                    preparedStatement.setString(3, textField_2.getText());
                    preparedStatement.setString(4,textField_3.getText());
                    preparedStatement.setString(5,textField_4.getText() );
                    preparedStatement.setString(6, (String) comboBox.getSelectedItem());
                    preparedStatement.setString(7,textField_5.getText() );
                    preparedStatement.setString(8, (String) comboBox_1.getSelectedItem());
                
                   
                    preparedStatement.setString(9,textArea.getText() );
                    preparedStatement.setInt(10,Integer.parseInt(textField_1.getText()));
                    int rowsAffected = preparedStatement.executeUpdate();
                    if(rowsAffected==1)
                    {
                    	JOptionPane.showMessageDialog(null, "Record updated succesfully");
                    }
                    else
                    {
                    	JOptionPane.showMessageDialog(null, "Error");
                    }
                    

                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
        	}
        });
            

	
	}
 
	public static void main(String[] args) {
		new UpdateDonar();

	}



}
