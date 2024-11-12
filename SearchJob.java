package jobportal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class SearchJob extends JFrame implements ActionListener {
    JTable table;
    DefaultTableModel model;
    JButton applyButton;
    String[] columns = {"Job Title", "Company Name", "Qualification Required", "Apply"};
    Connection conn;

    public SearchJob() {
        setTitle("Search Jobs");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        fetchJobs();

        applyButton = new JButton("Apply");
        applyButton.addActionListener(this);
        add(applyButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void fetchJobs() {
        String url = "jdbc:mysql://localhost:3306/job_portal";
        String user = "root";
        String password = "MRIKAL1409";

        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT job_title, company_name, qualification FROM jobs";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String jobTitle = rs.getString("job_title");
                String companyName = rs.getString("company_name");
                String qualification = rs.getString("qualification");
                model.addRow(new Object[]{jobTitle, companyName, qualification, "Apply"});
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String jobTitle = (String) model.getValueAt(selectedRow, 0);
            
            JOptionPane.showMessageDialog(this, "You've successfully applied for " + jobTitle);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a job to apply.");
        }
    }

    public static void main(String[] args) {
        new SearchJob();
    }
}

