
package vechilehiringsystem;

/**
 *
 * @author Ata
 */
public class TruckTransportTruck_19 extends Truck_19 implements Rentable_19, Bookable_19 {
    public boolean goesabroad;
    
    public TruckTransportTruck_19(){
        
    }
    
    public TruckTransportTruck_19(int id,final byte platenum,final byte numoftires,
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

    @Override
    public void rentme() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cancelme() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
}
