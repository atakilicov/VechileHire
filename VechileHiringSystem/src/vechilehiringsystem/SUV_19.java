
package vechilehiringsystem;

/*
@author ATA
*/



public class SUV_19 extends Car_19 implements Rentable_19 {
    
    public String WD; // AWD, FWD, RWD
    
    public SUV_19(){
        
    }
    
    public SUV_19(int id,final byte platenum,final byte numoftires,
            int dailyfee ,String color,byte SeatingCap,byte numOfDoors,String WD){
        
        super( id,platenum, numoftires,
             dailyfee, color, SeatingCap,numOfDoors);
        this.WD=WD;
        
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }
    
    
    
    
}
