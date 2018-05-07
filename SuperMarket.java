
package SuperMarket;


import javax.swing.*;
import java.awt.event.*;        
import mainintro.MainIntro;
public class SuperMarket extends JFrame{
    JLabel l1,l2,l3;
    JPasswordField t2;
    JTextField t1;
    JButton b;
   
    SuperMarket()
    {
     try
     {
        l1=new JLabel(new ImageIcon("C:\\MyJava\\heading1.png"));
              
        l1.setBounds(280, 170,500, 27);
        l2=new JLabel("Username   :");
        l2.setBounds(300, 280,100, 30);
        t1=new JTextField();
        t1.setBounds(420, 280, 220, 30);
        l3=new JLabel("Password   :");
        l3.setBounds(300,340,100, 30);
        t2=new JPasswordField();
        t2.setBounds(420, 340, 220, 30);
       
        b=new JButton("LOGIN");
        b.setBounds(500,400,80,40);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             String a=t1.getText();
             String b=new String(t2.getPassword());
             if(a.equals("ADMIN")&&b.equals("SupMark123"))
             {
                 JOptionPane.showMessageDialog(null,"You are logged in");
                    new MainIntro();
                    setVisible(false);
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Either username or password is invalid");
                 t1.setText("");
                 t2.setText("");
              
             }
            }
        });
            
        add(l1); add(l2);add(t1); add(l3); add(t2); add(b);
        setSize(1300,800);
        setLayout(null);
        setVisible(true); 
     }catch(Exception e){}
    }
    public static void main(String[] args) throws Exception
    {
       new SuperMarket(); 
    }
         
}
