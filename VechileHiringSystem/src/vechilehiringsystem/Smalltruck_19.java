package vechilehiringsystem;



/**
 *
 * @author Ata
 */
public class Smalltruck_19 extends Truck_19 implements Bookable_19,Rentable_19,Remotable_19 {
     
    
    public Smalltruck_19(){
        
    }
    
    public Smalltruck_19(int id,final byte platenum,final byte numoftires,
            int dailyfee,int loading){
        super( id,  platenum,  numoftires,
             dailyfee,loading);
        
    }
    
  
    
}
    
