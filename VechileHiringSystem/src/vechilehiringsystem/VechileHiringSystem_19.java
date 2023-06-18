
package vechilehiringsystem;

/**
 *
 * @author ATA
 */
public class VechileHiringSystem_19 extends UserOperations_19 {

   public static void main(String[] args) {
  boolean t=true;
    while(t){
       readfile(); 
    
        if (Areyouadmin()) {
            
            AdminPanel();
        } else 
            customerpanel();
        
    }
   }
}

       
        
  
    

   

