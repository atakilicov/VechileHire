
package vechilehiringsystem;

/**
 *
 * @author ATA
 */
public class VechileHiringSystem_19 extends VechilePark_19 {

   public static void main(String[] args) {
  boolean t=true;
    while(t){
        
    
        if (Areyouadmin()) {
            readfile();
            AdminPanel();
        } else 
            customerpanel();
        
    }
   }
}

       
        
  
    

   

