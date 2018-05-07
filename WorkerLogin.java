
package workerlogin;
import javax.swing.*;
import java.awt.event.*;
import options.Options;
import CoNect.Cnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkerLogin extends JFrame implements ActionListener 
{
    JTextField uid,uname,uadr,udob,udoj;
    JPasswordField upword;
    JButton b,b2,b3;
    JLabel l1,l2,lnm,laddr,ldob,ldoj;
     static String S="";
     String f1,f2,nm,addr,dob,doj;
    public WorkerLogin(String s)
    {
        S=s;
        
        setSize(500,600);
        setLocationRelativeTo(null);
        setTitle("Worker's Login");
         setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\wlogin.jpg")));
        setVisible(true);
      l1=new JLabel("WorkerID:");
      l2=new JLabel("Password");
      lnm=new JLabel("Enter the Name              :");
      laddr=new JLabel("Enter the Address         :");
      ldob=new JLabel("Enter you Date of Birth    :");
      ldoj=new JLabel("Enter the Date of Joining  :");
     
      
      l1.setBounds(50,50,80,30);
      l2.setBounds(50,100,80,30);
      lnm.setBounds(50,200,300,30);
      laddr.setBounds(50,250,300,30);
      ldob.setBounds(50,300,300,30);
      ldoj.setBounds(50,350,300,30);
      
       laddr.setVisible(false);
      ldob.setVisible(false);
      lnm.setVisible(false);
      ldoj.setVisible(false);
      
      uid=new JTextField();
      uid.setBounds(150,50,100,30);
      upword=new JPasswordField();
      upword.setBounds(150,100,100,30);
      uname=new JTextField();
      uname.setBounds(380,200,100,30);
      uadr=new JTextField();
      uadr.setBounds(380,250,200,30);
      udob=new JTextField();
      udob.setBounds(380,300,100,30);
      udoj=new JTextField();
      udoj.setBounds(380,350,100,30);
      
      uname.setVisible(false);
      uadr.setVisible(false);
      udob.setVisible(false);
      udoj.setVisible(false);
      
      b=new JButton();
      b.setBounds(70,160,80,30);
      b.setText("Login");
      b.addActionListener(this);
      b2=new JButton("Sign up");
      b2.setBounds(180,160,80,30);
      b3=new JButton("Create new Account");
      b3.setBounds(70,370,120,60);
      b3.setVisible(false);
      b2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                laddr.setVisible(true);
                ldob.setVisible(true);
                lnm.setVisible(true);
                ldoj.setVisible(true); 
                 uname.setVisible(true);
                uadr.setVisible(true);
                udob.setVisible(true);
                udoj.setVisible(true);
               b3.setVisible(true);    
            
            }});
     
      
      b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con=Cnection.connect();
                f1=uid.getText();
               f2=new String(upword.getPassword());
               nm=uname.getText();
              addr=uadr.getText();
               dob=udob.getText();
               doj=udoj.getText();
                try
        {
          Statement st=con.createStatement();
          int x=st.executeUpdate("insert into wdb (Name,userID,password,DOB,DOJ,Address)values('"+nm+"','"+f1+"','"+f2+"','"+dob+"','"+doj+"','"+addr+"')");
          if(x>0)
          {
              JOptionPane.showMessageDialog(null,"New Worker Account Created....");
               laddr.setVisible(false);
                ldob.setVisible(false);
                lnm.setVisible(false);
                ldoj.setVisible(false); 
                 uname.setVisible(false);
                uadr.setVisible(false);
                udob.setVisible(false);
                udoj.setVisible(false);
               b3.setVisible(false);  
               uid.setText("");
               upword.setText("");
          }
          else
          {
             JOptionPane.showMessageDialog(null,"Sorry, but due to some error we can't create a new Account");
          }
        }catch(Exception ex){}  
            }
        });
            
        
      add(uid);
      add(upword);add(b); add(b2); add(b3);
      add(uname); add(uadr); add(udob); add(udoj);
      add(lnm); add(ldoj); add(ldob); add(laddr);
      add(l1); add(l2);
      
        setSize(499,599);
      setSize(500,600);
    
      
      
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Connection con=Cnection.connect();
        String f1=uid.getText();
        String f2=new String(upword.getPassword());
        try
        {
          Statement st=con.createStatement();
          ResultSet r=st.executeQuery("select * from wdb where userID='"+f1+"' and password='"+f2+"'");
          if(r.next())
          {
              JOptionPane.showMessageDialog(null,"You are now logged in as "+r.getString("Name"));
              new Options(S);
              setVisible(false);
          }
          else
          {
             JOptionPane.showMessageDialog(null,"Either username or password is incorrect......");
             uid.setText("");
             upword.setText("");
          }
        }catch(Exception ex){}
       
    }
     
}
