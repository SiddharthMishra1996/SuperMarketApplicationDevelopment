
package options;
import groc.Groc;
import DairyPro.DairyPro;
import java.awt.event.*;
import javax.swing.*;
import op2.OP2;

public class Options extends JFrame implements ActionListener 
{
  JMenuItem b1,b2,b3;
  JMenu b;
  JMenuBar mb;
  String S;
  public Options(String s)
  {
      S=s;
    setTitle("Which section you want to access");
      setSize(1400,800);
      setLocationRelativeTo(null);
     setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\access.jpg")));
    setVisible(true); 
    mb=new JMenuBar();
    b=new JMenu("Select The Section");
    b1=new JMenuItem("Groceries");
    b2=new JMenuItem("Dairy Products");
    b3=new JMenuItem("General Products");
    b.add(b1); b.add(b2); b.add(b3);
    mb.add(b);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    setJMenuBar(mb);
      setSize(1399,799);
    setSize(1400,800);
    
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2)
        new DairyPro(S);
        else if(e.getSource()==b1)
            new Groc(S);
        else if(e.getSource()==b3)
            new OP2("gensto",S);
            
    }
}
