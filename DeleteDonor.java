package blood;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

public class DeleteDonor extends JFrame implements ActionListener {

    private JTextField donorIdField;
    private JButton deleteButton, backButton;

    public DeleteDonor() {
    	getContentPane().setBackground(new Color(0, 139, 139));
        
    	setTitle("Delete Donor");
        setVisible(true);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

       
        JLabel donorIdLabel = new JLabel("Enter Donor ID to Delete:");
        donorIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        donorIdLabel.setBounds(50, 50, 250, 30);
        getContentPane().add(donorIdLabel);

        
        donorIdField = new JTextField();
        donorIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        donorIdField.setBounds(50, 90, 200, 30);
        getContentPane().add(donorIdField);
        donorIdField.setColumns(10);


        deleteButton = new JButton("Delete Donor");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setBounds(30, 171, 150, 30);
        deleteButton.addActionListener(this);
        getContentPane().add(deleteButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBounds(226, 171, 100, 30);
        backButton.addActionListener(this);
        getContentPane().add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            String donorId = donorIdField.getText().trim();
            if (donorId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Donor ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            deleteDonor(donorId);
        } else if (e.getSource() == backButton) {
            new HomePage();
            
        }
    }

    private void deleteDonor(String donorId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "Roshni@07");

           
            String sql = "DELETE FROM Donors WHERE DonorID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, donorId);

            
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Donor deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                donorIdField.setText(""); 
            } else {
                JOptionPane.showMessageDialog(this, "Donor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting donor", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public static void main(String[] args) {
       new DeleteDonor();
        
    }
}
