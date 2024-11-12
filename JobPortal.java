package jobportal;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
class AddObject
{
    Employer e=new Employer();
    Employer ep=new Employer();
     Employer emp=new Employer();
     Jobseeker job=new Jobseeker();
     Jobseeker job1=new Jobseeker();
     Jobseeker job2=new Jobseeker();
      static ArrayList<Employer> al=new ArrayList<Employer>();
      static ArrayList<Jobseeker> alj=new ArrayList<Jobseeker>();
    public  void Adde(String name, String user, String phone, char[] pwd, String email)
    {
    
        ep.setName(name);
        ep.setUserName(user);
        ep.setPhone(phone);
        ep.setPassword(pwd);
        ep.setEmail(email);  
        //System.out.println("before adding");
         printArrayList();
        al.add(ep);
        //System.out.println("after adding");
        printArrayList();
    }
    
    public  void Addj(String name, String user, String phone, char[] pwd, String email,String qual)
    {
    
        //System.out.println("inside add j");
        job2.setName(name);
        job2.setUserName(user);
        job2.setPhone(phone);
        job2.setPassword(pwd);
        job2.setEmail(email);   
        job2.setQual(qual);
        alj.add(job2);
        
        //System.out.println(job2.getUserName());
    }
    void printArrayList()
    {
          Iterator<Employer>  itr=al.iterator();
        
        while(itr.hasNext())
        {
           
            //System.out.println("inside iterator");
            
            e= itr.next();
           
            //System.out.println("us "+ e.getName()+ " pass "+ e.getPassword());
        }
    }
    void printArrayListjs()
    {
          Iterator<Jobseeker>  itr1=alj.iterator();
        
        while(itr1.hasNext())
        {
           
            //System.out.println("inside iterator");
            
            job= itr1.next();
            // System.out.println(count);
            //System.out.println("us "+ job.getName()+ " pass "+ job.getPassword());
        }
    }
    
    public void setArrayList() 
    {
        //ArrayList<Employer> al=new ArrayList();
      int count=0;
        try{
       File in=new File("Employer.ser");
       //ObjectInputStream in=new ObjectInputStream(fileIn);
       int size=(int)in.length();
       
       if(size!=0){
        
            FileInputStream fileIn=new FileInputStream("Employer.ser");
            BufferedInputStream bf=new BufferedInputStream(fileIn);
            ObjectInputStream i=new ObjectInputStream(bf);           
           
             al=(ArrayList)i.readObject();
             //System.out.println("reading employer");
            
          
            
            
            i.close();
            bf.close();
            fileIn.close();
              
            Iterator<Employer>  itr=al.iterator();
        
        while(itr.hasNext())
        {
            count++;
            //System.out.println("inside iterator");
            
            e= itr.next();
             //System.out.println(count);
            //System.out.println("us "+ e.getName()+ " pass "+ e.getPassword());
        }
      //  System.out.println(count);
        }
        }catch(Exception e){
           // System.out.println("Error");
           // e.printStackTrace();
           
       }
       finally{
         
       }
     
      
        try{
       File in1=new File("Jobseeker.ser");
       //ObjectInputStream in=new ObjectInputStream(fileIn);
       int size=(int)in1.length();
       
       if(size!=0){
        
             FileInputStream fileIn=new FileInputStream("Jobseeker.ser");
            BufferedInputStream bf=new BufferedInputStream(fileIn);
             ObjectInputStream i=new ObjectInputStream(bf);           
           
            
            
             alj=(ArrayList)i.readObject();
           
            i.close();
            bf.close();
            fileIn.close();
            //System.out.println("Reading Jobseeker");
            
             Iterator<Jobseeker>  itr1=alj.iterator();
        count=0;
        while(itr1.hasNext())
        {
            count++;
            //System.out.println("inside iterator");
            
            job= itr1.next();
            //System.out.println(count);
            //System.out.println("us "+ job.getName()+ " pass "+ job.getPassword());
        }
            
             
             
       }

      
       
       }catch(NullPointerException e)
       {
           
       }
       catch(Exception e){
           
       }
       finally{
            
         
       }        

    }
   public void setfile()
    {
        try{
          
            FileOutputStream fileout=new FileOutputStream("Employer.ser");
            ObjectOutputStream out=new ObjectOutputStream(fileout);
            out.writeObject(al);
            out.close();
            fileout.close();
        }catch(IOException ex){
           
        }
        
        try{
           printArrayListjs();
            FileOutputStream fileout1=new FileOutputStream("Jobseeker.ser");
            ObjectOutputStream out1=new ObjectOutputStream(fileout1);
            out1.writeObject(alj);
            
            out1.close();
            fileout1.close();
        }catch(IOException ex){
           
        }
       System.exit(0);
        
        
    }
   boolean existUser(String username)
   {
       Iterator<Employer> itr=al.iterator();
       while(itr.hasNext())
        {
              e= itr.next();
              if(e.getUserName().equals(username))
              {
                 JOptionPane.showMessageDialog(null, "Username already exists");
                 return false; // false if user exi
                 
              }
          
        }
       return true; //if user do not exits
   }
   boolean checkUser(String user,char[] pwd)
   {
       char[] passwd;
      // char[] str;
       int count=0;
       printArrayListjs();
       //System.out.println("in check user");
      Iterator<Employer> itr=al.iterator();
      
       while(itr.hasNext())
        {
            //System.out.println(++count);
              emp= itr.next();
              passwd=emp.getPassword();
             //str= passwd.toCharArray();
              if(emp.getUserName().equals(user) )
              {
                  if(Arrays.equals(pwd, passwd))
                  
                  {
                      return true;
                  }
              }
            
       
   }
     
                 JOptionPane.showMessageDialog(null, "Invalid Username or Password");
   return false; 
}
    boolean existJobSeekerUser(String username) //At time of registration
   {
       Iterator<Jobseeker> itr2=alj.iterator();
       while(itr2.hasNext())
        {
              job1= itr2.next();
              if(job1.getUserName().equals(username))
              {
                 JOptionPane.showMessageDialog(null, "Username already exists");
                 return false;
                 
              }
          
        }
       return true;
   }
     boolean checkJobSeekerUser(String user,char[] pwd)//during login of jobseeker
   {
       char[] passwd;
      // char[] str;
       //System.out.println("in check user");
      Iterator<Jobseeker> itr=alj.iterator();
      
       while(itr.hasNext())
        {
              job= itr.next();
              passwd=job.getPassword();
             
              if(job.getUserName().equals(user) )
              {
                  if(Arrays.equals(pwd, passwd))
                  
                  {
                      return true;
                  }
              }
              
        }
     JOptionPane.showMessageDialog(null, "Invalid Username or Password");
   return false; 
}
        
     String[] str=new String[20];
     int i=0;
     
      public  String[] getList() {
       Iterator<Employer> itr5=al.iterator();
       Employer emp=new Employer();
       while(itr5.hasNext())
       {
         emp=itr5.next();
        
         str[i++]=emp.getName();
         // System.out.println(emp.getName());
       } 
       //for(i=0;i<str.length;i++)
       //.out.println(str[i]);
       return str;
     }
   
}
class WelcomeFrame extends JFrame implements ActionListener {

    private final JLabel label1,imglabel,infolabel,extral;
    private final JButton JregisterButton,closeButton;
    private final JButton JloginButton,Eregister,Elogin;
    private final JLabel label2,label3;
    private JPanel panel,panel1,panel2,panel3,panel4,panel5,panel6,imgpanel,infopanel,extra;
    int size;
    ImageIcon pic;
    AddObject ao ;
    
    public WelcomeFrame() {
      
      

        
        label1 = new JLabel("Jomble : JOB RECRUITMENT PORTAL");
        JregisterButton = new JButton("Register");
        JloginButton = new JButton("Login");
        label2 = new JLabel("Are You a Jobseeker?");
        label3=new JLabel("Employer");
        Eregister=new JButton("Register");
        Elogin=new JButton("Login");
        closeButton=new JButton("close");
        extral=new JLabel("\n");
        infolabel=new JLabel("If you are looking for a Job or an Employee, then you've come to the right place!"
                + "\n" + "   Register Below, IT'S FREE!");
     
        Font f = new Font("Times New Roman", Font.BOLD, 28);
        Font f1=new Font("Courier",Font.BOLD,22);
        label1.setFont(f);
        label1.setForeground(Color.cyan.darker());
        label2.setFont(f1);
        label3.setFont(f1);
        infolabel.setForeground(Color.orange.darker());
        infolabel.setFont(new Font("Calibri",Font.ITALIC,15));
        panel = new JPanel(new GridLayout(9,1));
        panel1 =new JPanel(new FlowLayout());
        panel2=new JPanel(new FlowLayout());
        panel3=new JPanel(new FlowLayout());
        panel4=new JPanel(new FlowLayout());
        panel5=new JPanel();
        panel6=new JPanel();
        extra=new JPanel();
        infopanel=new JPanel();
        imgpanel=new JPanel();
        pic=new ImageIcon(getClass().getResource("logo_1.jpg"));
        imglabel=new JLabel(pic);
        Dimension size = new Dimension(300,80);
        imglabel.setPreferredSize(size);
        panel1.add(label1);
        panel.add(panel1);
        imgpanel.add(imglabel);
        panel.add(imgpanel);
        
        extra.add(extral);
        panel.add(extra);
        
        infopanel.add(infolabel);
        panel.add(infopanel);
        
        panel3.add(label2);
        panel.add(panel2);
        
        
        panel4.add(JregisterButton);
        panel4.add(JloginButton);
        panel5.add(label3);
        panel6.add(Eregister);
        panel6.add(Elogin);
        panel6.add(closeButton);
        
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        panel.add(panel6);
       
        add(panel);
        JregisterButton.addActionListener(this);
        JloginButton.addActionListener(this);
        Eregister.addActionListener(this);
        Elogin.addActionListener(this);
        closeButton.addActionListener(this);
        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ao=new AddObject();
        ao.setArrayList();
     
        
       
    }
    
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==JregisterButton)
      {
          new RegisterJobSeeker();
          //setVisible(false);
      }
      else
          if(ae.getSource()==JloginButton)
          {
              new JobseekerLogin();
              //setVisible(false);
          }
          else 
              if(ae.getSource()==Eregister)
              {
                   RegisterEmployer remp=new RegisterEmployer();
        remp.setTitle("Registration");
        remp.setSize(600,600);
        remp.setLocationRelativeTo(null);
        remp.setVisible(true);
        remp.setDefaultCloseOperation(EXIT_ON_CLOSE);
              }
           else
                  if(ae.getSource()==Elogin)
                  {
                      new LoginEmployer();
                  }
                  else if(ae.getSource()==JloginButton)
                  {
                      new JobseekerLogin();
                  }
                  else if(ae.getSource()==closeButton)
                  {
                      ao.setfile();
                  }
                      
    }
    

}

public class JobPortal {
    

    public static void main(String[] args)  {
  
       new WelcomeFrame();
    }

}
