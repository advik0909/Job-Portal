package jobportal;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

public class JobSeekerHomePage extends JFrame implements ActionListener {
    JPanel p, p1, p2, p3, p4;
    JButton b1, b2, b3;
    JLabel l;
    Font fnt;
    public static JLabel name;

    public JobSeekerHomePage() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        setLocationRelativeTo(null);

        p4 = new JPanel();

        fnt = new Font("Times New Roman", Font.BOLD, 18);
        p = new JPanel(new GridLayout(4, 1));
        l = new JLabel("WELCOME   ");
        l.setFont(fnt);
        name = new JLabel("");
        name.setFont(fnt);
        p4.add(l);
        p4.add(name);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        b1 = new JButton("Search for a job");
        p1.add(b1);

        b2 = new JButton("View result");
        p2.add(b2);

        b3 = new JButton("Upload CV");
        p3.add(b3);

        p.add(p4);
        p.add(p1);
        p.add(p2);
        p.add(p3);

        add(p);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            new SearchJob();
        } else if (ae.getSource() == b2) {
            new Result();
        } else if (ae.getSource() == b3) {
            new CVChooser();
            JOptionPane.showMessageDialog(null, "Your CV has been Uploaded.");
        }
    }

    public static void main(String[] args) {
        new JobSeekerHomePage();
    }
}
