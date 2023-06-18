
package vechilehiringsystem;
import java.util.Date;

/**
 *
 * @author ATA
 */
public abstract class Vechile_19 implements Rentable_19 {
    
   public Date vechileStartDate;
   public Date vechileEndDay;
    public int id;

   
    public byte plateNum;

  
    public byte numofTires;

    
    public int dailyFee;
    
 
    public int getDailyFee(Date exitday)
    {
        
        Date d = new Date();
        int daypassed = (int)((exitday.getTime()-d.getTime())/86400000);
        return getDailyFee()*daypassed;
      }   


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public byte getPlateNum() {
        return plateNum;
    }

    
    public void setPlateNum(byte plateNum) {
        this.plateNum = plateNum;
    }

 
    public byte getNumofTires() {
        return numofTires;
    }

    public void setNumofTires(byte numofTires) {
        this.numofTires = numofTires;
    }

    public int getDailyFee() {
        return dailyFee;
    }


    public void setDailyFee(int dailyFee) {
        this.dailyFee = dailyFee;
    }

   
    public Date getVechileStartDate() {
        return vechileStartDate;
    }

    public void setVechileStartDate(Date vechileStartDate) {
        this.vechileStartDate = vechileStartDate;
    }

    
    public Date getVechileEndDay() {
        return vechileEndDay;
    }

   
    public void setVechileEndDay(Date vechileEndDay) {
        this.vechileEndDay = vechileEndDay;
    }
        
            
   
    
}
