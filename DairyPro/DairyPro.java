
package DairyPro;

import java.util.Scanner;

import CoNect.Cnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.event.*;
import op2.OP2;

public class DairyPro extends JFrame implements ActionListener
{
    JMenuItem b1,b2;
    JMenu b;
    JMenuBar mb;
    String S="";
    public DairyPro(String s)
    {
        S=s;
         setSize(1400,800);
        setTitle("Dairy Products Section");
        setLocationRelativeTo(null);
        setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\dairyproducts.jpg")));
       setVisible(true);
         b=new JMenu("Select From Here");
        mb=new JMenuBar();
        b1=new JMenuItem("Milk Products");
       b2=new JMenuItem("Other Dairy Products");
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
        {new OP2("milk",S);}
        else if(e.getSource()==b2)
        {new OP2("otherdairy",S);}
      
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   