package vechilehiringsystem;

import java.util.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


/**
 *
 * @author atakilic
 */
public class VechilePark_19  {

    public static ArrayList<Vechile_19> AllVechilelist = new ArrayList<>();
    public static ArrayList<Vechile_19> Availablevechiles = new ArrayList<>(); //buraya kaydedilirken Başlangıç ve bitiş tarihleri set edilmelidir
    public static ArrayList<Vechile_19> BookedVechiles = new ArrayList<>(); // yukarıda belitrilen şart uygulanmalı.
    public static ArrayList<Vechile_19> RentedVechiles = new ArrayList<>();
    public static ArrayList<String> Customers = new ArrayList<>();
    public static Scanner inputt = new Scanner(System.in);

    public static void displayAllvechiles() {
        for (Vechile_19 V : AllVechilelist) {
            System.out.println("id: " + V.getId());
            System.out.println("Type: " + V.getClass());
            System.out.println("platenum: " + V.getPlateNum());
            System.out.println("-*-*-*-*-*-*-");
        }
    }

    public static void addVechile(Vechile_19 vech) { //ADMİN ONLY !!
        AllVechilelist.add(vech);
    }

    public  static void removeVechile(Vechile_19 vech) {

        AllVechilelist.remove(vech);
    }

    public static boolean isAvailable(Vechile_19 a) {
        return Availablevechiles.contains(a) || RentedVechiles.contains(a);

    }

    public static void displayAvailableOnes(Date s, Date f) {

        for (Vechile_19 V : Availablevechiles) {
            if ((V.getVechileStartDate().equals(s) || V.getVechileStartDate().after(s))
                    && (V.getVechileEndDay().equals(f) || V.getVechileEndDay().before(f))) {
                System.out.println("id: " + V.getId());
                System.out.println("Type: " + V.getClass());
                System.out.println("platenum: " + V.getPlateNum());
                System.out.println("-*-*-*-*-*-*-");
            } else {
                System.out.println("Sorry. We dont have any available vechiles in the period that you want");
            }

        }
    }
    public static void displayAvailableOnes(Date s, Date f, String v) {
        String x = "vechilehiringsystem."+v;
        for (Vechile_19 V : Availablevechiles) {
            if (((V.getVechileStartDate().equals(s) || V.getVechileStartDate().after(s))
                    && (V.getVechileEndDay().equals(f) || V.getVechileEndDay().before(f))&& V.getClass().toString().equals(x))) {
                System.out.println("id: " + V.getId());
                System.out.println("Type: " + V.getClass());
                System.out.println("platenum: " + V.getPlateNum());
                System.out.println("-*-*-*-*-*-*-");
            } else {
                System.out.println("Sorry. We dont have any available vechiles in the period that you want");
            }

        }
    }

    public static void bookVechile(int id, Date S, Date f) {
       Vechile_19 vechile = AllVechilelist.get(id);
        if (isAvailable(vechile)) {
            System.out.println("this vechile is not available ");
        } else {
            vechile.setVechileStartDate(S);
            vechile.setVechileEndDay(f);
            Availablevechiles.add(vechile);
        }

    }

    public static void cancelBooking(int id) {
        Vechile_19 vec = AllVechilelist.get(id);
        if (isAvailable(vec) && BookedVechiles.contains(vec)) {
            BookedVechiles.remove(vec);
            vec.setVechileEndDay(null);
            vec.setVechileStartDate(null);

        } else {
            System.out.println("there is no such booking!");
        }
    }

    public static void RentVechile(int id, Date S, Date f) {
         Vechile_19 vechile = AllVechilelist.get(id);
        if (isAvailable(vechile)) {
            System.out.println("this vechile is not available ");
        } else {
            vechile.setVechileStartDate(S);
            vechile.setVechileEndDay(f);
            RentedVechiles.add(vechile);
        }

    }

    public static void cancelRenting(int id) {
        Vechile_19 vec = AllVechilelist.get(id);
        if (isAvailable(vec) && RentedVechiles.contains(vec)) {
            RentedVechiles.remove(vec);
            vec.setVechileEndDay(null);
            vec.setVechileStartDate(null);

        } else {
            System.out.println("there is no such booking!");
        }
    }

    public static void dropVechile(int id, String Address) {
        Vechile_19 vec = AllVechilelist.get(id);
        if (vec instanceof Remotable_19) {
            System.out.println("the Vechile succesfully dropped!");

        } else {
            System.out.println("sorry, this vechile can not be dropped");
        }
    }

    public void load(Truck_19 truck, Vechile_19 car) throws OverWeightExpection_19 {
        System.out.println("");
    }

    

    public static int randnumgenerator() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000) + 1; // 1 ile 1000 arasında rastgele sayı üretir
        return randomNumber;
    }
    static Scanner scanner = new Scanner(System.in);

    public static void createSUV() {
        try {
            System.out.println("Enter the attributes of SUV:");
            int id = AllVechilelist.size();

            System.out.print("Plate Number: ");
            byte platenum = scanner.nextByte();

            System.out.print("Number of Tires: ");
            byte numoftires = scanner.nextByte();

            System.out.print("Daily Fee: ");
            int dailyfee = scanner.nextInt();

            System.out.print("Color: ");
            String color = scanner.next();

            System.out.print("Seating Capacity: ");
            byte seatingCap = scanner.nextByte();

            System.out.print("Number of Doors: ");
            byte numOfDoors = scanner.nextByte();

            System.out.print("WD: ");
            String WD = scanner.next();

            CarSUV_19 suv = new CarSUV_19(id, platenum, numoftires, dailyfee, color, seatingCap, numOfDoors, WD);
            addVechile(suv);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid attribute values.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void createStationWagon() {
        try {
            System.out.println("Enter the attributes of SW car:");
            int id = AllVechilelist.size();

            System.out.print("Plate Number: ");
            byte platenum = scanner.nextByte();

            System.out.print("Number of Tires: ");
            byte numoftires = scanner.nextByte();

            System.out.print("Daily Fee: ");
            int dailyfee = scanner.nextInt();

            System.out.print("Color: ");
            String color = scanner.next();

            System.out.print("Seating Capacity: ");
            byte seatingCap = scanner.nextByte();

            System.out.print("Number of Doors: ");
            byte numOfDoors = scanner.nextByte();

            System.out.print("Loading Capacity: ");
            int loadingCapacity = scanner.nextInt();

            CarStationWagon_19 sw = new CarStationWagon_19(id, platenum, numoftires, dailyfee, color, seatingCap, numOfDoors, loadingCapacity);
            addVechile(sw);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid attribute values.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void createSportsCar() {
        try {
            System.out.println("Enter the attributes of Sport car:");
            int id = AllVechilelist.size();

            System.out.print("Plate Number: ");
            byte platenum = scanner.nextByte();

            System.out.print("Number of Tires: ");
            byte numoftires = scanner.nextByte();

            System.out.print("Daily Fee: ");
            int dailyfee = scanner.nextInt();

            System.out.print("Color: ");
            String color = scanner.next();

            System.out.print("Seating Capacity: ");
            byte seatingCap = scanner.nextByte();

            System.out.print("Number of Doors: ");
            byte numOfDoors = scanner.nextByte();

            System.out.print("Horse Power: ");
            int horsePower = scanner.nextInt();

            CarSports_19 sportsCar = new CarSports_19(id, platenum, numoftires, dailyfee, color, seatingCap, numOfDoors, horsePower);
            addVechile(sportsCar);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid attribute values.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void createSmallTruck() {
        try {
            System.out.println("Enter the attributes of Small Truck:");
            int id = AllVechilelist.size();

            System.out.print("Plate Number: ");
            byte platenum = scanner.nextByte();

            System.out.print("Number of Tires: ");
            byte numoftires = scanner.nextByte();

            System.out.print("Daily Fee: ");
            int dailyfee = scanner.nextInt();

            System.out.print("Loading Capacity: ");
            int loadingCapacity = scanner.nextInt();
            scanner.next();

            TruckSmall_19 smallTruck = new TruckSmall_19(id, platenum, numoftires, dailyfee, loadingCapacity);
            addVechile(smallTruck);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid attribute values.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void createTransportTruck() {
        try {
            System.out.println("Enter the attributes of Transport Truck:");
            int id = AllVechilelist.size();

            System.out.print("Plate Number: ");
            byte platenum = scanner.nextByte();

            System.out.print("Number of Tires: ");
            byte numoftires = scanner.nextByte();

            System.out.print("Daily Fee: ");
            int dailyfee = scanner.nextInt();

            System.out.print("Loading Capacity: ");
            int loadingCapacity = scanner.nextInt();

            System.out.print("Goes Abroad (true/false): ");
            boolean g;
            String goesabroad2 = scanner.next();
            g = goesabroad2.equals("true");

            TruckTransportTruck_19 transportTruck = new TruckTransportTruck_19(id, platenum, numoftires, dailyfee, loadingCapacity, g);
            addVechile(transportTruck);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid attribute values.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void writetofolder(ArrayList<Vechile_19> vechiles) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vechiles.txt"))) {
            for (Vechile_19 v : vechiles) {
                writer.write(v.getId() + "," + v.getClass().toString() + "," + v.getPlateNum());
                writer.newLine();

            }
            writer.close();
            System.out.println("datas have writen to document.");
        } catch (IOException e) {
            System.out.println("an expection occured during the writing: " + e.getMessage());
        }
    }

  
}
