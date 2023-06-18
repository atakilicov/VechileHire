
package vechilehiringsystem;

import java.util.Date;


public class Car_19 extends Vechile_19 implements Rentable_19 {
    
   
    public static int numofcar;
     public String color;

   
    public byte seatcapacity;

  
    public byte numofdoors;
     
   
    public Car_19(){
         
     }
    
    public Car_19(int id,final byte platenum,final byte numoftires,
            int dailyfee,String color,byte SeatingCap,byte numOfDoors){
        numofcar++;
        this.id=id;
        this.plateNum= platenum;
        this.numofTires=numoftires;
        this.dailyFee=dailyfee;
        this.color=color;
        this.numofdoors=numOfDoors;
        this.seatcapacity=SeatingCap;
        
        
    }

  
    public static int getNumofcar() {
        return numofcar;
    }

    public static void setNumofcar(int aNumofcar) {
        numofcar = aNumofcar;
    }

   
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

   
    public byte getSeatcapacity() {
        return seatcapacity;
    }

    
    public void setSeatcapacity(byte seatcapacity) {
        this.seatcapacity = seatcapacity;
    }

    public byte getNumofdoors() {
        return numofdoors;
    }

   
    public void setNumofdoors(byte numofdoors) {
        this.numofdoors = numofdoors;
    }

    @Override
    public void rentme() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
