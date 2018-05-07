
package by;
public class By 
{
       
    public By(String nam)
    {
       if(nam.equals("vegetables")||nam.equals("fruits"))
           new BuyVF(nam).setVisible(true);
       else if(nam.equals("milk"))
           new BuyM().setVisible(true);
       else if(nam.equals("otherdairy"))
           new BuyODP().setVisible(true); 
       else if(nam.equals("gensto"))
           new BuyGen().setVisible(true); 
           
    }     
}     
