
package vechilehiringsystem;

/**
 *
 * @author Ata
 */
public class TransportTruck_19 extends Truck_19 implements Rentable_19, Bookable_19 {
    public boolean goesabroad;
    
    public TransportTruck_19(){
        
    }
    
    public TransportTruck_19(int id,final byte platenum,final byte numoftires,
            int dailyfee,int loading, boolean goesabroad){
        super( id,  platenum,  numoftires,
             dailyfee,loading);
        this.goesabroad=goesabroad;
    }

    public boolean isGoesabroad() {
        return goesabroad;
    }

    public void setGoesabroad(boolean goesabroad) {
        this.goesabroad = goesabroad;
    }
    
   
}
