
package mainintro;


import options.Options;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import workerlogin.WorkerLogin;

public class MainIntro implements ActionListener
{
    JFrame f;
  
    JMenuBar bg;
    JMenu b;
     JMenuItem rb1,rb2;
     JLabel l1,l2;
     static String s="";
     public MainIntro()
    {
        f=new JFrame();
         f.setSize(1400,700);
         f.setLocationRelativeTo(null);
         f.setDefaultCloseOperation(EXIT_ON_CLOSE);
         f.setTitle("MainIntro");
         f.setVisible(true);
        
        try{
          f.setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\Intro.jpg")));
          l1=new JLabel(new ImageIcon("C:\\MyJava\\heading1.png"));
         l1.setBounds(250,20,500,27);
         bg=new JMenuBar();
         b=new JMenu("Select Your Identity");
         rb1=new JMenuItem("Customer");
         rb2=new JMenuItem("Worker");
         b.add(rb1); b.add(rb2);
         bg.add(b); 
         rb1.addActionListener(this);
         rb2.addActionListener(this);
         
         
         f.add(l1); f.setJMenuBar(bg); 
         f.setSize(1399,699);
         f.setSize(1400,700);
         
        }catch(Exception e){}
        
         
          
       }

    @Override
    public void actionPerformed(ActionEvent e) {
     
       if(e.getSource()==rb1)
       {
           s="Customer";
           new Options(s);
       }
       else if(e.getSource()==rb2)
       {
           s="Worker";
           new WorkerLogin(s);
       }
          
       
    }

 
}
