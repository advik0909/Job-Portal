package jobportal;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployerHome extends JFrame implements ActionListener {
    private JLabel label1;
    public static JLabel name;
    public JPanel panel, panel1, panel2;
    private JButton button1, button2; // Added button2 for viewing CVs
    private Font fnt;

    EmployerHome() {
        fnt = new Font("Times New Roman", Font.BOLD, 18);
        label1 = new JLabel("WELCOME   ");
        label1.setFont(fnt);
        name = new JLabel();
        name.setFont(fnt);
        
        button1 = new JButton("SELECT EMPLOYEE");
        button2 = new JButton("VIEW CVs"); // New button for viewing CVs
        
        panel = new JPanel(new GridLayout(4, 1));
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        panel1.add(label1);
        panel1.add(name);
        panel2.add(button1);
        panel2.add(button2); // Add button2 to the panel
        
        panel.add(panel1);
        panel.add(panel2); 
        add(panel);
        
        button1.addActionListener(this);
        button2.addActionListener(this); // Add ActionListener for button2
        
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1) {
            new JobSelect();
        } else if (ae.getSource() == button2) {
            new ViewCVs(); // Opens the ViewCVs class
        }
    }
}
