package vechilehiringsystem;

/**
 *
 * @author ATA
 */
public class CarStationWagon_19 extends Car_19 implements Remotable_19, Rentable_19{

    public int loadingcap; //can maximum 100kgs.
 
    public CarStationWagon_19(){
    
}

  
    public CarStationWagon_19(int id,final byte platenum,final byte numoftires,
            int dailyfee ,String color,byte SeatingCap,byte numOfDoors,int loadingcap){
    super(id,  platenum, numoftires,
             dailyfee, color, SeatingCap,numOfDoors);
    this.loadingcap=loadingcap;
}

    
    public int getLoadingcap() {
        return loadingcap;
    }


    public void setLoadingcap(int loadingcap) {
        this.loadingcap = loadingcap;
    }

    @Override
    public void rentme() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
