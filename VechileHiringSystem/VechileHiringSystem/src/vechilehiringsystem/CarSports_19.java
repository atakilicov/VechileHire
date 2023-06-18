package vechilehiringsystem;

import java.util.Date;

/**
 *
 * @author ATA
 */
public class CarSports_19 extends Car_19 implements Rentable_19,Remotable_19,Bookable_19 {
    
   
    public int horsepower;

    
    public CarSports_19(){
       
   }
   
  
    public CarSports_19(int id,final byte platenum,final byte numoftires,
            int dailyfee ,String color,byte SeatingCap,byte numOfDoors,int hp)
   {
       super( id,  platenum, numoftires,
             dailyfee, color, SeatingCap,numOfDoors);
       this.horsepower=hp;
       
   }

    
    public int getHorsepower() {
        return horsepower;
    }

   
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
   
     @Override
    public void bookMe(Date S , Date F){
            
       
    }
    
    public void cancelMe(){
        
    }

    @Override
    public void rentme() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cancelme() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
