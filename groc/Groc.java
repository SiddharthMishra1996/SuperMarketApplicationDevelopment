
package groc;

import java.util.Scanner;
import op2.OP2;
import javax.swing.*;
import java.awt.event.*;
public class Groc extends JFrame implements ActionListener
{   
   
    JMenuItem b1,b2;
    JMenu b;
    JMenuBar mb;
    String S="";
    public Groc(String s)
    {
         S=s;
        setTitle("Grocery Section");
        setSize(1400,800);
        setLocationRelativeTo(null);
        setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\Grocer.jpg")));
        
        setVisible(true);
       mb=new JMenuBar();
       b=new JMenu("Select From Here"); 
       b1=new JMenuItem("Vegetables");
       b2=new JMenuItem("Fruits");
       b.add(b1); b.add(b2);
       b1.addActionListener(this);
       b2.addActionListener(this);
       mb.add(b);
        setJMenuBar(mb);
   
        setSize(1399,799);
        setSize(1400,800);
      
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        { new OP2("vegetables",S);}
        else if(e.getSource()==b2)
        {  new OP2("fruits",S);}
    }
   
}
