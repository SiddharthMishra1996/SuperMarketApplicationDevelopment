
package ad;
import CoNect.Cnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Ad extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3,b4,b5;
    String name="",NM="";
    int qty,n=0;
    float price;
    String size="",cc="";
     int x=0;
    public Ad(String nam)
    {
       NM=nam;
       System.out.println(NM+" "+nam);
      
       setSize(1400,800);
        setTitle("Add The Product");
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
      l2=new JLabel("Enter the quantity(*in kg for veg/fruits only): ");
      l3=new JLabel("Enter the size (1litre/0.5litre for milk and Small,Medium,Large for other products): ");
      l4=new JLabel("Enter the price(*per kg for veg/fruits only): ");
      l1.setBounds(480,220,100,30);
      l3.setBounds(180,270,500,30);
      l2.setBounds(180,320,500,30);
      l4.setBounds(180,370,500,30);
      
        
      t1=new JTextField(); t2=new JTextField(); t3=new JTextField(); t4=new JTextField(); 
      t1.setBounds(700,220,100, 30);
      t3.setBounds(700,270,100, 30);
      t2.setBounds(700,320,100, 30);
      t4.setBounds(700,370,100, 30);
      t4.setEnabled(false);
 
      
      b1=new JButton("OK"); b2=new JButton("OK"); b3=new JButton("OK"); b4=new JButton("OK"); b5=new JButton("Enter");
     
      b1.setBounds(830,220,100, 30);
      b3.setBounds(830,270,100, 30);
      b2.setBounds(830,320,100, 30); 
      b4.setBounds(830,370,100, 30);
      b5.setBounds(180,470,80,30);
      
      b1.addActionListener(new ActionListener()
      {
            @Override
         public void actionPerformed(ActionEvent e) {
          name=t1.getText();
          System.out.println(name);
         }
      });
      b2.addActionListener(new ActionListener()
      {
            @Override
         public void actionPerformed(ActionEvent e) {
          n=Integer.parseInt(t2.getText());
          System.out.println(n);
         }
      });
      if(nam.equals("vegetables")||nam.equals("fruits"))
      { t3.setEnabled(false);
       b3.setEnabled(false);
      }
      else
      {
       t3.setEnabled(true);
       b3.setEnabled(true);
       b3.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e)
           {
               size=t3.getText();
           }
       });
      }
      b4.setEnabled(false);
      
      b5.addActionListener(new ActionListener(){

           @Override
      public void actionPerformed(ActionEvent e)
      {
       if(name!=null)
      {
          System.out.println(1);
          
        try{
        Statement stm=con.createStatement();
        ResultSet st=stm.executeQuery("Select * from "+nam+" where Name='"+name+"'");  
        if(nam.equals("vegetables")||nam.equals("fruits"))
        {
           System.out.println(1);
          if(st.next())
         {
           
           
           qty=st.getInt("Qty");
           qty+=n;
                
              Statement stm2=con.createStatement();
              x=stm2.executeUpdate("update "+NM+" set Qty='"+qty+"' where Name='"+name+"'");
              System.out.println(x);
              if(x>0)
              {
               JOptionPane.showMessageDialog(null,"Quantity Updated");
              }
        
                       
         }
         else
         {
             b4.setEnabled(true);
             t4.setEnabled(true);
           b4.addActionListener(new ActionListener()
          {
            @Override
           public void actionPerformed(ActionEvent e) {
            price=Float.parseFloat(t4.getText());
                        
             
                try {
                    Statement stm1=con.createStatement();
                    x = stm1.executeUpdate("insert into "+nam+" (Name,Qty,Pricepkg)values('"+name+"','"+n+"','"+price+"')");
                   if(x>0)
              {
               JOptionPane.showMessageDialog(null,"New Entry added");
               b4.setEnabled(false);
              t4.setEnabled(false);
              }} catch (SQLException ex){}
          }}); 
         }
        }
        else if(nam.equals("milk"))
         {
            
             System.out.println(1);
                 if(st.next())
                 {
                     
                     if(size.equalsIgnoreCase("0.5litre"))
                     {System.out.println(0.5f);
                         qty=st.getInt("Qty1");
                      qty+=n;
                      Statement stm2=con.createStatement();
                      if(st.getFloat("Price1")==0)
                      {
                        b4.setEnabled(true);
                       t4.setEnabled(true);
                       b4.addActionListener(new ActionListener()
                       {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        price=Float.parseFloat(t4.getText());
                        }  
                      });   
                          x=stm2.executeUpdate("update "+NM+" set Qty1='"+qty+"',Price1='"+price+"' where Name='"+name+"'");
                      } 
                      else 
                       x=stm2.executeUpdate("update "+NM+" set Qty1='"+qty+"' where Name='"+name+"'");
                      
                     }
                     else if(size.equalsIgnoreCase("1litre"))
                     {System.out.println(1);
                         qty=st.getInt("Qty2");
                      qty+=n;
                      Statement stm2=con.createStatement();
                      if(st.getFloat("Price2")==0)
                      {
                           b4.setEnabled(true);
                       t4.setEnabled(true);
                       b4.addActionListener(new ActionListener()
                       {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        price=Float.parseFloat(t4.getText());
                        }  
                      });
                          x=stm2.executeUpdate("update "+NM+" set Qty2='"+qty+"',Price2='"+price+"' where Name='"+name+"'");
                      }
                      else 
                        x=stm2.executeUpdate("update "+NM+" set Qty2='"+qty+"' where Name='"+name+"'");
                                     
                     
                     }
                     System.out.println(x);
                      if(x>0)
                     {
                        JOptionPane.showMessageDialog(null,"Quantity Updated"); 
                     } 
                     
                 }
                 else
                 {
                      b4.setEnabled(true);
                      t4.setEnabled(true);
                      b4.addActionListener(new ActionListener()
                     {
                      @Override
                       public void actionPerformed(ActionEvent e) {
                       price=Float.parseFloat(t4.getText());
                        
             
                     try {
                        Statement stm1=con.createStatement();
                        if(size.equalsIgnoreCase("0.5litre"))
                        { x = stm1.executeUpdate("insert into "+nam+" (Name,Qty1,Qty2,Price1,Price2)values('"+name+"','"+n+"','"+0+"','"+price+"','"+0.0f+"')");
                         if(x>0)
                         {
                          JOptionPane.showMessageDialog(null,"New Entry added");
                          b4.setEnabled(false);
                          t4.setEnabled(false);
                         }
                        }
                         else
                         {  x = stm1.executeUpdate("insert into "+nam+" (Name,Qty1,Qty2,Price1,Price2)values('"+name+"','"+0+"','"+n+"','"+0.0f+"','"+price+"')");  
                             if(x>0)
                          {
                            JOptionPane.showMessageDialog(null,"New Entry added");
                            b4.setEnabled(false);
                            t4.setEnabled(false);
                          }
                         }         
                       } catch (SQLException ex){}
                      }}); 
                 }
              
         }
         else if((nam.equals("otherdairy"))||(nam.equals("gensto")))
         {
             System.out.println(1);
                 if(st.next())
                 {
                     
                     System.out.println(price);
                     if(size.equalsIgnoreCase("Small"))
                     {qty=st.getInt("NSmall");
                      qty+=n;
                      
                      Statement stm2=con.createStatement();
                      if(st.getFloat("PSmall")==0.0f)
                      {   
                          b4.setEnabled(true);
                       t4.setEnabled(true);
                          b4.addActionListener(new ActionListener()
                       {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        price=Float.parseFloat(t4.getText());
                        }  
                      });   
                       x=stm2.executeUpdate("update "+NM+" set NSmall='"+qty+"',PSmall='"+price+"' where Name='"+name+"'");
                    }       
                     else
                      x=stm2.executeUpdate("update "+NM+" set NSmall='"+qty+"' where Name='"+name+"'");
                     }
                     else if(size.equalsIgnoreCase("Medium"))
                     {qty=st.getInt("NMedium");
                      qty+=n;
                      Statement stm2=con.createStatement();
                      if(st.getFloat("PMedium")==0.0f)
                      { b4.setEnabled(true);
                       t4.setEnabled(true);
                          b4.addActionListener(new ActionListener()
                       {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        price=Float.parseFloat(t4.getText());
                        }  
                      }); 
                      x=stm2.executeUpdate("update "+NM+" set NMedium='"+qty+"',PMedium='"+price+"' where Name='"+name+"'");
                      } 
                       else
                       x=stm2.executeUpdate("update "+NM+" set NMedium='"+qty+"' where Name='"+name+"'");
                     }
                     else if(size.equalsIgnoreCase("Large"))
                     {qty=st.getInt("NLarge");
                      qty+=n;
                      Statement stm2=con.createStatement();
                      if(st.getFloat("PLarge")==0.0f)
                     {
                      b4.setEnabled(true);
                       t4.setEnabled(true);
                          b4.addActionListener(new ActionListener()
                       {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        price=Float.parseFloat(t4.getText());
                        }  
                      });
                       x=stm2.executeUpdate("update "+NM+" set NLarge='"+qty+"',PLarge='"+price+"' where Name='"+name+"'");
                     }
                      else
                      x=stm2.executeUpdate("update "+NM+" set NLarge='"+qty+"' where Name='"+name+"'");
                     }
                     System.out.println(x);
                                        
                     if(x>0)
                     {
                        JOptionPane.showMessageDialog(null,"Quantity Updated"); 
                     }
                     
                 }
                 else
                 {
                      b4.setEnabled(true);
                      t4.setEnabled(true);
                      b4.addActionListener(new ActionListener()
                     {
                      @Override
                       public void actionPerformed(ActionEvent e) {
                       price=Float.parseFloat(t4.getText());
                        
             
                     try {
                        Statement stm1=con.createStatement();
                        if(size.equalsIgnoreCase("Small"))
                         x = stm1.executeUpdate("insert into "+nam+" (Name,NSmall,NMedium,NLarge,PSmall,PMedium,PLarge)values('"+name+"','"+n+"','"+0+"','"+0+"','"+price+"','"+0.0f+"','"+0.0f+"')");
                        else if(size.equalsIgnoreCase("Medium"))
                         x = stm1.executeUpdate("insert into "+nam+" (Name,NSmall,NMedium,NLarge,PSmall,PMedium,PLarge)values('"+name+"','"+0+"','"+n+"','"+0+"','"+0.0f+"','"+price+"','"+0.0f+"')");
                        else if(size.equalsIgnoreCase("Large"))
                         x = stm1.executeUpdate("insert into "+nam+" (Name,NSmall,NMedium,NLarge,PSmall,PMedium,PLarge)values('"+name+"','"+0+"','"+0+"','"+n+"','"+0.0f+"','"+0.0f+"','"+price+"')");
            
                           
                        if(x>0)
                       {
                        JOptionPane.showMessageDialog(null,"New Entry added");
                        b4.setEnabled(false);
                        t4.setEnabled(false);
                        }} catch (SQLException ex){}
                      }}); 
                 }
              
         }
       
        
       }catch(Exception ex){}
        
      }
       
    }});
      
     
       
     
      add(l1); add(l2); add(l3); add(l4); 
      add(t1); add(t2); add(t3); add(t4); 
      add(b1); add(b2); add(b3); add(b4); add(b5);
        setSize(1399,799);
      setSize(1400,800);
     
      }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
   

    

   
    
   
}
