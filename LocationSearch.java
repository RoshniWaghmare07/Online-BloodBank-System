package blood;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LocationSearch extends JFrame {
    private JTextField textField;
    private JTable table;
    private JButton btnPrint, btnClose;

    public LocationSearch() {
        getContentPane().setFont(new Font("FreeSerif", Font.BOLD, 14));
        getContentPane().setBackground(new Color(255, 160, 122));
        setSize(1000, 900);
        setTitle("Donor Search Location");
        setVisible(true);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Search Blood Donor(Location)");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 46));
        lblNewLabel.setBounds(79, 13, 622, 72);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Address");
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("FreeSerif", Font.BOLD, 21));
        lblNewLabel_1.setBounds(126, 96, 101, 26);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.PLAIN, 14));
        textField.setBounds(237, 94, 202, 28);
        getContentPane().add(textField);
        textField.setColumns(10);

        btnPrint = new JButton("Search");
        btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnPrint.setBounds(121, 579, 92, 36);
        getContentPane().add(btnPrint);

        btnClose = new JButton("Close");
        btnClose.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnClose.setBounds(400, 579, 101, 36);
        getContentPane().add(btnClose);

        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(12, 150, 789, 359);
        getContentPane().add(scrollPane);

        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
    }

    private void performSearch() {
        String address = textField.getText();
        String query = "SELECT * FROM Donors WHERE Address LIKE ?";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "Roshni@07");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + address + "%");
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

    public static void main(String[] args) {
        new LocationSearch();
    }
}