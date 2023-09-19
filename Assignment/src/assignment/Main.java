/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author nicho
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class Main {

    public static void addFlight(ArrayList<Flight> flights) {
//        ArrayList<Flight> flights = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        char cont;
        int dpCountry, arrCountry, reinputCountry = 0;

        // ... (previous code to add flights to the ArrayList)
        System.out.print("Do you want to add Flight (Yes=Y, No=no): ");
        char choose = sc.next().charAt(0);
        sc.nextLine();

        if (choose == 'Y' || choose == 'y') {
            do {
                // ... (previous code to collect flight data)
                String flightID = "F0" + ((flights.size()) + 1);

                System.out.println("\nChoose Country \n1.Japan\n2.Malaysia\n3.England\n4.China\n5.Australia");   //Input country 

                do {
                    reinputCountry = 0;
                    System.out.print("Departure Country: ");
                    dpCountry = sc.nextInt();
                    Flight.country(dpCountry);

                    System.out.print("Arrival Country: ");
                    arrCountry = sc.nextInt();
                    Flight.country(arrCountry);
                    sc.nextLine();

                    if (dpCountry < 1 || arrCountry < 1 || dpCountry > 5 || arrCountry > 5) {
                        System.out.println("! Please enter 1-5 Country !");
                        reinputCountry = 1;
                    }
                } while (reinputCountry == 1);

                System.out.print("Boarding Time(0100-2300): ");
                int bdTime = Integer.parseInt(sc.nextLine());

                System.out.print("Departure Time: ");
                int dpTime = Integer.parseInt(sc.nextLine());

                System.out.print("Estimate Arrival Time: ");
                int estimateArrivalTime = Integer.parseInt(sc.nextLine());

                System.out.print("Departure Date: ");
                String dpDate = sc.nextLine();

                System.out.print("Arrival Date: ");
                String arrDate = sc.nextLine();

                System.out.print("Economy Price: RM ");
                double ecoPrice = Double.parseDouble(sc.nextLine());

                System.out.print("Business Price: RM ");
                double bsPrice = Double.parseDouble(sc.nextLine());

                System.out.print("Plane No: ");
                String planeNo = sc.nextLine();

                System.out.print("Number of Seat: ");
                int numOfSeat = sc.nextInt();

                // Create a Plane object with the user-entered data
                Plane plane = new Plane(planeNo, numOfSeat);

                // Create a Flight object and add it to the ArrayList
                Flight flight = new Flight(flightID, Flight.country(arrCountry), Flight.country(dpCountry), bdTime, dpTime, estimateArrivalTime, dpDate, arrDate, ecoPrice, bsPrice, plane);
                flights.add(flight);

                System.out.print("Do you want to continue (Yes=Y, No=no):");
                cont = sc.next().charAt(0);
                sc.nextLine();
            } while (cont == 'Y' || cont == 'y');

            // Ask the user if they want to save the data to a file
            System.out.print("Do you want to update Flight data(Yes=Y, No=no): ");
            char saveToFile = sc.next().charAt(0);

            if (saveToFile == 'Y' || saveToFile == 'y') {
                try {
                    // Create a FileWriter to write to the flight.txt file
                    FileWriter fileWriter = new FileWriter("flight.txt",true);

                    // Create a PrintWriter to write data to the file
                    BufferedWriter printWriter = new BufferedWriter(fileWriter);

                    // Iterate over the flights ArrayList and write each Flight object's data to the file
                    for (Flight flight : flights) {
                        printWriter.write(flight.toString()); // Assuming you have implemented toString() in your Flight class
                    }

                    // Close the PrintWriter and FileWriter
                    printWriter.close();
                    fileWriter.close();

                    System.out.println("Flight data has been updated !");
                } catch (IOException e) {
                    System.out.println("Cant updated to file!");
                }
            }
        }

        // ... (rest of your code)
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Staff[] staffArray = new Staff[10]; // You can adjust the size as needed
        int staffCount = 0, selection = 0;
        String notStaff = null;
        ArrayList<Flight> flights = new ArrayList<>();

        // Populate the array with staff members
        staffArray[0] = new Staff("S001", "Manager", 11111, "Apple Doe", "015-5555555", 'M', "john@example.com", "030402-07-1526");
        staffArray[1] = new Staff("S002", "Airline Controller", 22222, "Bun Smith", "012-345678", 'F', "jane@example.com", "040222-08-0437");
        staffArray[2] = new Staff("S003", "Airline Controller", 33333, "Coocies Johnson", "014-567890", 'M', "bob@example.com", "02222-18-1234");
        staffArray[3] = new Staff("S004", "Airline Controller", 44444, "Duck Brown", "019-7899908", 'F', "alice@example.com", "191203-18-8768");
        staffArray[4] = new Staff("S005", "Airline Controller", 55555, "Egg Lee", "013-2727589", 'M', "eva@example.com", "170807-14-9087");
        staffArray[5] = new Staff("S006", "Airline Controller", 66666, "Fruit Chan", "019-9999999", 'F', "owom@example.com", "020405-09-8967");
        staffArray[6] = new Staff("S007", "Airline Controller", 77777, "Grass wong", "018-7976902", 'M', "pema@example.com", "010917-08-7869");
        staffArray[7] = new Staff("S008", "Airline Controller", 88888, "Ham chan", "017-7787960", 'F', "sosy@example.com", "010416-11-1996");
        staffArray[8] = new Staff("S009", "Airline Controller", 99999, "Ice loo", "0197891111", 'M', "kokonut@example.com", "111111-01-1111");
        staffArray[9] = new Staff("S000", "Airline Controller", 00000, "Juice hee", "014-4444444", 'F', "polipo@example.com", "040404-08-0918");

        do {
            System.out.print("Enter Staff ID: ");
            String stfID = sc.nextLine();
            System.out.print("Enter Password (5-digit): ");
            int stfpassword = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < staffArray.length; i++) {
                if (staffArray[i].login(stfID, stfpassword)) {
                    staffCount = i;
                    notStaff = stfID;
                    break;
                }
            }
            if (notStaff == null) {
                System.out.println("![Invalid please Log in agian]!\n");
            } else {
                System.out.println("\n" + staffArray[staffCount].toString());
            }

        } while (notStaff == null);

        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("|1. Add Flight                |");
            System.out.println("|2. Modify Flight             |");
            System.out.println("|3. Delete Flight             |");
            System.out.println("|4. View Flight               |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.println("Enter your option: ");
            selection = sc.nextInt();

            if(selection==1){
                addFlight(flights);
                selection=0;
            }else
                selection=0;
//            switch (selection) {
//                case 1:
//                    addFlight(flights);
//                    break;
//            case 2:
//                modifyFlight;
//                break;
//            case 3:
//                deleteFlight();
//                break;
//            case 4:
//                viewFilght();
//                break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//                    break;
//            }
        } while (selection == 0);

    }

  

}
