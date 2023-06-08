package vechilehiringsystem; 

import java.util.Date;


/**
 *
 * @author Ata
 */
public  class Truck_19 extends Vechile_19 implements Rentable_19, Bookable_19{
    public int loadingcap;
    
    public Truck_19(){
        
    }
    
    public Truck_19(int id,final byte platenum,final byte numoftires,
            int dailyfee, int loadingcap){
        
        
    }

    public int getLoadingcap() {
        return loadingcap;
    }

    public void setLoadingcap(int loadingcap) {
        this.loadingcap = loadingcap;
    }
    
     @Override
    public void bookMe(Date S , Date F){
            
       
    } 
    
    @Override
    public void cancelMe(){
        
    }
    
}






