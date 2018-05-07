
package cp;
import CoNect.Cnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Cp extends JFrame implements ActionListener
{
     
     String name="";

    float p;
    String type="";
    String siz="",NM="";

    int y=0;
    JLabel  l1,l2,l3,l4;
    JButton b1,b2,b3,b4;
    JTextField t1,t2,t4;
    JFormattedTextField l5;
   public Cp(String nam)
   {
       int x;
        NM=nam;
       System.out.println(NM+" "+nam);
       setSize(1400,700);
     setTitle("Change The Price");
     setLocationRelativeTo(null);
     if(nam.equals("milk")||nam.equals("otherdairy"))
     { setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\dairyproducts.jpg")));}
     else if(nam.equals("fruits")||nam.equals("vegetables"))
     {setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\Ofveg.jpg")));}  
     else if(nam.equals("gensto"))
     {setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\access.jpg")));} 
       setVisible(true);
        Connection con=Cnection.connect();
      l1=new JLabel("Enter the name ");
      l3=new JLabel("Old price (in RS.): ");
      l2=new JLabel("Enter the size (1litre/0.5litre for milk and Small,Medium,Large for other dairy products): ");
      l4=new JLabel("Enter the new price (per kg for Grocery Items and as-it-is for others in RS.): ");
      l1.setBounds(500,200,100,30);
      l3.setBounds(400,300,200,30);
      l2.setBounds(200,250,500,30);
      l4.setBounds(200,350,500,30);
      
      t1=new JTextField(); l5=new JFormattedTextField();  t4=new JTextField(); t2=new JTextField(); 
      t1.setBounds(720,200,100, 30);
      l5.setBounds(720,300,100, 30);
      t2.setBounds(720,250,100, 30);
      t4.setBounds(720,350,100, 30);
   
      b1=new JButton("OK"); b2=new JButton("OK"); b4=new JButton("OK"); b3=new JButton("OK"); 
      b1.setBounds(850,200,80, 30);
      b2.setBounds(850,250,80, 30); 
      b3.setBounds(850,300,80, 30); 
      b4.setBounds(180,500,80, 30);
      
       b1.addActionListener(new ActionListener()
      {
            @Override
         public void actionPerformed(ActionEvent e) {
          name=t1.getText();
          System.out.println(name);
         }
      });
            
      if(nam.equals("vegetables")||nam.equals("fruits"))
      {
          t2.setEnabled(false);
          b2.setEnabled(false);
      }
      else
      {    
          t2.setEnabled(true);
          b2.setEnabled(true);
          b2.addActionListener(new ActionListener()
          {
            @Override
         public void actionPerformed(ActionEvent e) {
          siz=t2.getText();
          System.out.println(siz);
         }
      });
      }
     
    b3.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e)
           {
              int x;
            
               if(name!=null)
               {
                   try{
        Statement stm=con.createStatement();
        ResultSet st=stm.executeQuery("Select * from "+nam+" where Name='"+name+"'");  
        if(nam.equals("vegetables")||nam.equals("fruits"))
        {
           System.out.println(1);
          
         if(st.next())
         {
              l5.setValue(st.getFloat("Pricepkg"));
              b4.addActionListener(new ActionListener(){    

              @Override
              public void actionPerformed(ActionEvent e) 
              {
                  int x=-1;
               p=Float.parseFloat(t4.getText());
                y=1;
               try{ Statement stm2=con.createStatement();
              x=stm2.executeUpdate("update "+NM+" set Pricepkg='"+p+"' where Name='"+name+"'");
              System.out.println(x);
              
              if(x>0&&y==1)
              {
               JOptionPane.showMessageDialog(null,"Price Updated");
              }}catch(Exception ex){};
              }});
              
        }
       }
        else if(nam.equals("milk"))
            {
                if(st.next())
               {
                 if(siz.equalsIgnoreCase("0.5litre"))
                 {
                 l5.setValue(st.getFloat("Price1"));
                    b4.addActionListener(new ActionListener(){    

              @Override
              public void actionPerformed(ActionEvent e) 
              {
               p=Float.parseFloat(t4.getText());
                y=1;
                
               int x=-1;
                  try{ 
                      Statement stm2=con.createStatement();
                      x = stm2.executeUpdate("update "+NM+" set Price1='"+p+"' where Name='"+name+"'");
                  } catch (SQLException ex) {}
                  System.out.println(x);
            
              if(x>0&&y==1)
              {
               JOptionPane.showMessageDialog(null,"Price Updated");
              }
              }});
              
            }
            else if(siz.equalsIgnoreCase("1litre"))
                 {
                 l5.setValue(st.getFloat("Price2"));
                 b4.addActionListener(new ActionListener(){    

              @Override
              public void actionPerformed(ActionEvent e) 
              {
                  int x=-1;
               p=Float.parseFloat(t4.getText());
                y=1;
                try{
                Statement stm2=con.createStatement();
              x=stm2.executeUpdate("update "+NM+" set Price2='"+p+"' where Name='"+name+"'");
              System.out.println(x);
              
              if(x>0&&y==1)
              {
               JOptionPane.showMessageDialog(null,"Price Updated");
              }
                }catch(Exception ex){}
              }});
              
            }    
            }
           }
        else if((nam.equals("otherdairy"))||nam.equals("gensto"))
            {
                if(st.next())
               {
                 if(siz.equalsIgnoreCase("Small"))
                 {
                 l5.setValue(st.getFloat("PSmall"));
                   b4.addActionListener(new ActionListener(){    

              @Override
              public void actionPerformed(ActionEvent e) 
              { int x=-1;
               p=Float.parseFloat(t4.getText());
                y=1;
                try{
                    Statement stm2=con.createStatement();
              x=stm2.executeUpdate("update "+NM+" set PSmall='"+p+"' where Name='"+name+"'");
              System.out.println(x);
            
              if(x>0&&y==1)
              {
               JOptionPane.showMessageDialog(null,"Price Updated");
              }
                }catch(Exception ex){}
              }});
              
            }
            else if(siz.equalsIgnoreCase("Medium"))
                 {
                 l5.setValue(st.getFloat("PMedium"));
              Statement stm2=con.createStatement();
                b4.addActionListener(new ActionListener(){    

              @Override
              public void actionPerformed(ActionEvent e) 
              {int x=-1;
               p=Float.parseFloat(t4.getText());
                y=1;
                try{
                  x=stm2.executeUpdate("update "+NM+" set PMedium='"+p+"' where Name='"+name+"'");
              System.out.println(x);
            
              if(x>0&&y==1)
              {
               JOptionPane.showMessageDialog(null,"Price Updated");
              }
                }catch(Exception ex){}
              }});
             
            }                 
            else if(siz.equalsIgnoreCase("Large"))
                 {
                 l5.setValue(st.getFloat("PLarge"));
              Statement stm2=con.createStatement();
               b4.addActionListener(new ActionListener(){    

              @Override
              public void actionPerformed(ActionEvent e) 
              { int x=-1;
               p=Float.parseFloat(t4.getText());
                y=1;
                try{
                  x=stm2.executeUpdate("update "+NM+" set PLarge='"+p+"' where Name='"+name+"'");
              System.out.println(x);
             
              if(x>0&&y==1)
              {
               JOptionPane.showMessageDialog(null,"Price Updated");
              }
                }catch(Exception ex){}
              }});
              
            }    
            }
           }    
       }catch(Exception ex){}
       }}});

            
   
    add(l1); add(l2); add(l3); add(l4); add(l5); add(t1); add(t2); add(t4);
    add(b1); add(b2); add(b3); add(b4);
       setSize(1399,699);
    setSize(1400,700);
      
   }    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
     p=Float.parseFloat(t4.getText());
    }
}