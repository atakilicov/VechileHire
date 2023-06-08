package vechilehiringsystem;

import java.util.Date;

/**
 *
 * @author ATA
 */
public class Sports_19 extends Car_19 implements Rentable_19,Remotable_19,Bookable_19 {
    
   
    public int horsepower;

    
    public Sports_19(){
       
   }
   
  
    public Sports_19(int id,final byte platenum,final byte numoftires,
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
    @Override
    public void cancelMe(){
        
    }
    
    
}
