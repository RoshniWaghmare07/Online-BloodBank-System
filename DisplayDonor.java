package blood;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class DisplayDonor extends JFrame {
    private JTable table; 
    JButton btnBack ;
    public DisplayDonor() {
        getContentPane().setBackground(new Color(238, 232, 170));
        setSize(1000, 600);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("All Donor Details");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 42));
        lblNewLabel.setBounds(255, 11, 650, 101);
        getContentPane().add(lblNewLabel);
        
        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 900, 300);
        getContentPane().add(scrollPane);
        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnClose.setBounds(573, 465, 89, 36);
        getContentPane().add(btnClose);
       
        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnBack.setBounds(241, 465, 89, 31);
        getContentPane().add(btnBack);

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
           

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HomePage();            }
        });

        performSearch(); 
        setVisible(true);
    }

   
    private void performSearch() {
        String query = "SELECT * FROM Donors"; 
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "Roshni@07");

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            table.setModel(buildTableModel(rs));

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static DefaultTableModel buildTableModel(ResultSet rs) throws Exception {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        
        Vector<String> columnNames = new Vector<String>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> row = new Vector<Object>();
            for (int column = 1; column <= columnCount; column++) {
                row.add(rs.getObject(column));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }

    
    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 
    }

    public static void main(String[] args) {
        new DisplayDonor(); 
    }
}
