package vechilehiringsystem;

import java.util.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;

/**
 *
 * @author atakilic
 */
public class VechilePark_19 {

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

    public void load(Truck_19 truck, Vechile_19 car) {
        //dayı bura sende kafam yetmedi
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

            SUV_19 suv = new SUV_19(id, platenum, numoftires, dailyfee, color, seatingCap, numOfDoors, WD);
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

            StationWagon_19 sw = new StationWagon_19(id, platenum, numoftires, dailyfee, color, seatingCap, numOfDoors, loadingCapacity);
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

            Sports_19 sportsCar = new Sports_19(id, platenum, numoftires, dailyfee, color, seatingCap, numOfDoors, horsePower);
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

            Smalltruck_19 smallTruck = new Smalltruck_19(id, platenum, numoftires, dailyfee, loadingCapacity);
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

            TransportTruck_19 transportTruck = new TransportTruck_19(id, platenum, numoftires, dailyfee, loadingCapacity, g);
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
            System.out.println("datas have writed to document.");
        } catch (IOException e) {
            System.out.println("an expection occured during the writing: " + e.getMessage());
        }
    }

    public static boolean Areyouadmin() {

        System.out.println("******* WELCOME TO THE VPARK COMPANY SYSTEM! *******");
        Scanner input = new Scanner(System.in);
        System.out.println("Please press 1 if you are an admin, or any other number to login as a customer: ");

        try {
            int a = input.nextInt();
            return a == 1;
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer value.");
        } catch (NoSuchElementException e) {
            System.out.println("Something went wrong. Please try again.");
        }

        return false;
    }
    static boolean admin = true;

    public static void AdminPanel() {
        while (admin) {

            try {
                System.out.println("Welcome Admin! Please choose the operation you want to do:");
                System.out.println("1 - Display all Vechiles");
                System.out.println("2 - Display available vechiles by date");
                System.out.println("3 - Add vechile");
                System.out.println("4 - Remove vechile");
                System.out.println("5 - Create report");
                System.out.println("6 - Quit");

                Scanner input = new Scanner(System.in);
                int c = input.nextInt();

                switch (c) {
                    case 1:
                        displayAllvechiles();

                        break;

                    case 2:
                        Date startDate = getUserDate("Starting");
                        Date finishDate = getUserDate("Finish");
                        displayAvailableOnes(startDate, finishDate);
                        break;

                    case 3:
                        addvechile();
                        writetofolder(AllVechilelist);

                        break;

                    case 4:
                        removeVechilex();
                        writetofolder(AllVechilelist);
                        break;

                    case 5:
                        writetofolder(AllVechilelist);
                        System.exit(c);
                        break;

                    case 6:
                        System.out.println("Goodbye!");
                        admin = false; // Döngüyü sonlandır
                        break;

                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 6.");

                        break;
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {

                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
    static boolean customer = true;

    public static void customerpanel() {
        while (customer) {
            System.out.println("Welcome customer! please tell us your name!");
            String customername = inputt.next();
            Customers.add(customername);
            System.out.println("Welcome again " + customername + "! what you want to do?");
            System.out.println("1-Display all vechiles");
            System.out.println("2-Display available vechiles ");
            System.out.println("3-Display availible vechiles by type");
            System.out.println("4- book vechile");
            System.out.println("5-cancel booking");
            System.out.println("6-rent a vechile");
            System.out.println("7-drop a vechile");
            System.out.println("8-quit");
            int i = inputt.nextInt();
            switch (i) {
                case 1:
                    displayAllvechiles();
                    break;

                case 2:
                      Date startDate = getUserDate("Starting");
                        Date finishDate = getUserDate("Finish");
                        displayAvailableOnes(startDate, finishDate);
                        break; 
                   

                case 3:
                         Date startDate1 = getUserDate("Starting");
                        Date finishDate1 = getUserDate("Finish");
                        System.out.println("enter the desired type");
                        String des = inputt.next();
                        
                        displayAvailableOnes(startDate1, finishDate1, des);
                        break;
                    
                case 4:
                    System.out.println("enter the id of vechile you want to book");
                    int id = inputt.nextInt();
                    Date startDate11 = getUserDate("Starting");
                        Date finishDate11 = getUserDate("Finish");
                    bookVechile(id,startDate11,finishDate11);

                    break;
                case 5:
                     System.out.println("enter the id of booked vechile to cancel");
                     int id1 = inputt.nextInt();
                     cancelBooking(id1);
                    break;
                case 6:
                    System.out.println("please enter the id of the car do you want to rent");
                    int id2 =inputt.nextInt();
                     Date startdate111 = getUserDate("Starting");
                        Date finishdate111 = getUserDate("Finish");
                    RentVechile(id2, startdate111,finishdate111);
                    break;
                case 7:
                     System.out.println("please enter the id of the vechile you want to drop");
                     int id4= inputt.nextInt();
                     System.out.println("enter the adress you want to drop");
                     String adres = inputt.next();
                     dropVechile(id4,adres);
                    break;
                case 8:
                    System.out.println("bye!");
                    
                    System.exit(2);

                default:
                    throw new AssertionError();
            }

        }

    }

    public static Date getUserDate(String date) {

        Scanner scb = new Scanner(System.in);
        System.out.println("Please enter a " + date + "date (dd/MM/yyyy):");
        String userInput = scb.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date userDate = null;
        try {
            userDate = dateFormat.parse(userInput);
        } catch (ParseException e) {
            System.out.println("Geçersiz tarih formatı!");
            // Hata durumunda uygun bir işlem yapılabilir.
        }
        return userDate;
    }

    public static void addvechile() {

        System.out.println("Enter the type of vechile");
        Scanner scn = new Scanner(System.in);
        String object = scn.nextLine();

        if (object.equalsIgnoreCase("car")) {

            try {
                System.out.println("Enter the type of the car as numbers follow:");
                System.out.println("1 - SUV");
                System.out.println("2 - SW");
                System.out.println("3 - Sport");
                int s = scn.nextInt();

                switch (s) {
                    case 1:
                        createSUV();
                        break;

                    case 2:
                        createStationWagon();
                        break;

                    case 3:
                        createSportsCar();
                        break;

                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 3.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

        } else if (object.equalsIgnoreCase("truck")) {
            try {
                System.out.println("Enter the type of the truck as numbers follow:");
                System.out.println("1 - Small Truck");
                System.out.println("2 - Transport Truck");
                int s = scn.nextInt();

                switch (s) {
                    case 1:
                        createSmallTruck();
                        break;

                    case 2:
                        createTransportTruck();
                        break;

                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 2.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            scn.close();
        }

    }

    public static void removeVechilex() {
        System.out.println("please enter the id");
        Scanner input = new Scanner(System.in);
        int imp = input.nextInt();
        for (Vechile_19 v : AllVechilelist) {
            if (v.id == imp) {
                removeVechile(v);

            }
        }
    }

    public static void readfile() {
        try {
            FileInputStream fileIn = new FileInputStream("vechiles.txt");
            try (ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                AllVechilelist = (ArrayList<Vechile_19>) objectIn.readObject();
            }
            System.out.println("Veriler dosyadan yüklendi.");

            // AllVechilelist ile yapmak istediğiniz işlemleri gerçekleştirin
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);;
        }
    }
}
