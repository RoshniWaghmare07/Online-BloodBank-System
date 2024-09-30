package blood;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DecreaseStock extends JFrame {
    private JTextField textField;
    private JComboBox<String> comboBox;
    private JButton btnUpdate, btnPrint, btnClose;
    private JTable table;
    int u1,u,  units;
    String query;
    String bloodgroup;

    public DecreaseStock() {
      
        getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
        getContentPane().setBackground(new Color(135, 206, 250));
        getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("STOCK (DECREASE)");
        lblTitle.setFont(new Font("FreeSerif", Font.BOLD, 35));
        lblTitle.setBounds(159, 25, 417, 51);
        getContentPane().add(lblTitle);

        JLabel lblBloodGroup = new JLabel("Blood Group");
        lblBloodGroup.setFont(new Font("FreeSerif", Font.BOLD, 16));
        lblBloodGroup.setBounds(52, 88, 108, 15);
        getContentPane().add(lblBloodGroup);

        comboBox = new JComboBox<>(new String[]{"A+", "B+", "AB+", "O+", "O-", "A-", "B-", "AB-"});
        comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
        comboBox.setBounds(153,82, 92, 24);
        getContentPane().add(comboBox);

        JLabel lblUnits = new JLabel("Units");
        lblUnits.setFont(new Font("Dialog", Font.BOLD, 14));
        lblUnits.setBounds(277, 87, 70, 19);
        getContentPane().add(lblUnits);

        textField = new JTextField();
        textField.setBounds(331, 82, 108, 25);
        getContentPane().add(textField);
        textField.setColumns(10);

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnUpdate.setBounds(520, 82, 92, 25);
        getContentPane().add(btnUpdate);

        btnPrint = new JButton("Print");
        btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnPrint.setBounds(108, 528, 108, 40);
        getContentPane().add(btnPrint);

        btnClose = new JButton("Close");
        btnClose.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnClose.setBounds(381, 528, 108, 40);
        getContentPane().add(btnClose);

        
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 150, 600, 291);
        getContentPane().add(scrollPane);

        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 performSearch();
                updateStock();
               
            }
        });
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNotepad();
            }
        });

        getContentPane().add(btnPrint);

        setVisible(true);
    }

    public void openNotepad() {
        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe");
            pb.start();  
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to open Notepad", "Error", JOptionPane.ERROR_MESSAGE);
        }
    

        

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
    }

    private void updateStock() {
         bloodgroup = (String) comboBox.getSelectedItem();
       units = Integer.parseInt(textField.getText());
      
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root", "Roshni@07");
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select stock_count from BloodStock where bloodgroup='"+bloodgroup+"'");
           if(rs.next()) {
            u=rs.getInt(1);
           }
           
           
            
        } catch (Exception e) {
        	System.out.println(e);
            JOptionPane.showMessageDialog(this, "Please enter a valid number for units.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(u>=units) {
        	 u1=u-units;
        	  query = "UPDATE bloodstock SET stock_count=? WHERE bloodgroup = ?";
  

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "Roshni@07");
          
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, u1);
            ps.setString(2, bloodgroup);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Stock updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Blood group not found.");
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }else {
    	JOptionPane.showMessageDialog(this, "Blood units are insufficient!");
    }
    }
    
  
    private void performSearch() {
        String query = "SELECT * FROM bloodstock";

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

    private static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int column = 1; column <= columnCount; column++) {
                row.add(rs.getObject(column));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }

    public static void main(String[] args) {
        new DecreaseStock();
    }
}