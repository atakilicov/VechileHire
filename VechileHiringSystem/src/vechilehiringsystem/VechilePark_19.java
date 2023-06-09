
package vechilehiringsystem;

import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author atakilic
 */
public class VechilePark_19 {
  ArrayList<Vechile_19> AllVechilelist = new ArrayList<>(); 
  ArrayList<Vechile_19> Availablevechiles= new ArrayList<>(); //buraya kaydedilirken Başlangıç ve bitiş tarihleri set edilmelidir
  ArrayList<Vechile_19> BookedVechiles = new ArrayList<>(); // yukarıda belitrilen şart uygulanmalı.
  ArrayList<Vechile_19> RentedVechiles = new ArrayList<>();
  ArrayList<String> Customers = new ArrayList<>();
  
  
  public void displayAllvechiles(){
      for (Vechile_19 V : AllVechilelist) {
          System.out.println("id: "+V.getId());
          System.out.println("Type: "+V.getClass());
          System.out.println("platenum: " +V.getPlateNum());
          System.out.println("-*-*-*-*-*-*-");
      }
  }
  
  
  public void addVechile(ArrayList<Vechile_19> Arr ,Vechile_19 vech){ //ADMİN ONLY !!
      Arr.add(vech);
  }
  
  public void removeVechile(ArrayList<Vechile_19> Arr ,Vechile_19 vech){
      Arr.remove(vech);
  }
    
  
  public boolean isAvailable(Vechile_19 a){
     return Availablevechiles.contains(a) || RentedVechiles.contains(a);
     
      
  }
  
  public void displayAvailableOnes(){
      for(Vechile_19 V : Availablevechiles){
        System.out.println("id: "+V.getId());
          System.out.println("Type: "+V.getClass());
          System.out.println("platenum: " +V.getPlateNum());
          System.out.println("-*-*-*-*-*-*-") ; 
      }
  }
  
  public void bookVechile(Vechile_19 vechile, Date S, Date f){
      if (isAvailable(vechile)) {
          System.out.println("this vechile is not available "); 
      }
      else{
         vechile.setVechileStartDate(S);
      vechile.setVechileEndDay(f);
      Availablevechiles.add(vechile); 
      }
      
  }
  
  public void cancelBooking(Vechile_19 vec){
      if (isAvailable(vec)&& BookedVechiles.contains(vec)) {
        BookedVechiles.remove(vec);
        vec.setVechileEndDay(null);
        vec.setVechileStartDate(null);
          
      }
      else{
          System.out.println("there is no such booking!");
      }
  }
  
  
  public void RentVechile(Vechile_19 vechile, Date S, Date f){
      if (isAvailable(vechile)) {
          System.out.println("this vechile is not available "); 
      }
      else{
         vechile.setVechileStartDate(S);
      vechile.setVechileEndDay(f);
      RentedVechiles.add(vechile); 
      }
      
  }
  
  public void cancelRenting(Vechile_19 vec){
      if (isAvailable(vec)&& RentedVechiles.contains(vec)) {
        RentedVechiles.remove(vec);
        vec.setVechileEndDay(null);
        vec.setVechileStartDate(null);
          
      }
      else{
          System.out.println("there is no such booking!");
      }
  }
  
  public void dropVechile(Vechile_19 vec , String Address){
      if (vec instanceof Remotable_19) {
          System.out.println("the Vechile succesfully dropped!"); 
          
      }
      else{
          System.out.println("sorry, this vechile can not be dropped");
      }
  }
  
  public void load(Truck_19 truck, Vechile_19 car){
      //dayı bura sende kafam yetmedi
  }
  
  public void dailyReport(){
      //mainle beraber yapılması gerek. pdfi oku
  }
  
}
