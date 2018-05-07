
package disp;
public class Disp 
{
  public Disp(String nam)
  {
   if(nam.equals("vegetables")||nam.equals("fruits"))
   { new DispRF(nam).setVisible(true); }
   else if(nam.equals("milk"))
       new DispM().setVisible(true);
   else if(nam.equals("otherdairy"))
       new DispODP().setVisible(true);
   else if(nam.equals("gensto"))
       new DispGen().setVisible(true);
  }    

}     
  