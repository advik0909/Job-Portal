package jobportal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewCVs extends JFrame {
    private JTable table;
    private JButton viewButton;
    private File selectedFile;

    public ViewCVs() {
        setTitle("View Uploaded CVs");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        viewButton = new JButton("View Selected CV");
        viewButton.addActionListener(new ViewCVAction());
        add(viewButton, BorderLayout.SOUTH);

        loadCVs();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadCVs() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Seeker Name");
        model.addColumn("Qualification");
        model.addColumn("CV File");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal", "root", "MRIKAL1409");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT seeker_name, qualification, cv_file_path FROM applied_jobs");

            while (rs.next()) {
                String seekerName = rs.getString("seeker_name");
                String qualification = rs.getString("qualification");
                String cvFilePath = rs.getString("cv_file_path");
                model.addRow(new Object[]{seekerName, qualification, cvFilePath});
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        table.setModel(model);
    }

    private class ViewCVAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String cvFilePath = (String) table.getValueAt(selectedRow, 2);
                selectedFile = new File(cvFilePath);
                openCV();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a CV to view.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }

        private void openCV() {
            if (selectedFile.exists()) {
                try {
                    Desktop.getDesktop().open(selectedFile);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Unable to open the CV file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "The selected CV file does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
