
package op2;
import ad.Ad;
import by.By;
import cp.Cp;
import disp.Disp;
import javax.swing.*;
import java.awt.event.*;
public class OP2 extends JFrame implements ActionListener
{
  JMenuItem b1,b2,b3,b4;
  JMenu b;
  JMenuBar mb;
  String nam;
 public OP2(String nm,String id)
 {
     nam=nm;
     setSize(1400,750);
     setLocationRelativeTo(null);
     if(nm.equals("milk")||nm.equals("otherdairy"))
     { setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\dairyproducts.jpg")));}
     else if(nm.equals("fruits")||nm.equals("vegetables"))
     {setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\Grocer.jpg")));} 
     else if(nm.equals("gensto"))
     {setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\access.jpg")));}
   setVisible(true);
   mb=new JMenuBar();
   b=new JMenu("What do you want to do?");
   b1=new JMenuItem("Add");
   b2=new JMenuItem("Display");
   b3=new JMenuItem("Buy");
   b4=new JMenuItem("Change the price");
     b.add(b1);
    b.add(b2);
     b.add(b3);
      b.add(b4);
        if(id.equals("Worker"))
     {b3.setEnabled(false);
    
   }
   else if(id.equals("Customer"))
   {
       b1.setEnabled(false);
       b4.setEnabled(false);
   }
        if(nm.equals("GenSto")){}
    b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);        
   
  
      mb.add(b);
  
    
   
     setJMenuBar(mb);
     setSize(1399,749);
   setSize(1400,750);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {new Ad(nam);}
        else if(e.getSource()==b2)
        { new Disp(nam);}
        else if(e.getSource()==b3)
        { new By(nam);}
        else if(e.getSource()==b4)
        {   new Cp(nam);}
    }
  }
