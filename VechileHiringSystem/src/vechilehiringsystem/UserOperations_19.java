/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vechilehiringsystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 *
 * @author atakilic
 */
public class UserOperations_19 extends VechilePark_19 {
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

    public static void customerpanel() {System.out.println("Welcome customer! please tell us your name!");
            String customername = inputt.next();
            Customers.add(customername);
        while (customer) {
            
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

   
    public static void removeVechilex () {
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

            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    
}
