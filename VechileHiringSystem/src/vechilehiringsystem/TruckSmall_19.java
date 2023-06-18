package vechilehiringsystem;



/**
 *
 * @author Ata
 */
public class TruckSmall_19 extends Truck_19 implements Bookable_19,Rentable_19,Remotable_19 {
     
    
    public TruckSmall_19(){
        
    }
    
    public TruckSmall_19(int id,final byte platenum,final byte numoftires,
            int dailyfee,int loading){
        super( id,  platenum,  numoftires,
             dailyfee,loading);
        
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
    
