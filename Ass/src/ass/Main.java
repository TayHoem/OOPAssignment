/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass;

/**
 *
 * @author nicho
 */

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Staff[] staffArray = new Staff[10]; // You can adjust the size as needed
        int staffCount = 0, selection = 0;
        String notStaff = null;
        ArrayList<Flight> flights = new ArrayList<>();
        Plane plane = new Plane();

        flights.add(new Flight("F001", "Malaysia", "Japan", 1200, 1300, 2000, "11-02-2023", "12-02-2023", 200.00, 400.00, new Plane("PL04", 32)));
        flights.add(new Flight("F002", "Japan", "Malaysia", 1300, 1400, 1800, "13-02-2023", "14-02-2023", 300.00, 600.00, new Plane("PL05", 32)));
        flights.add(new Flight("F003", "Malaysia", "England", 1400, 1500, 1900, "12-02-2023", "13-02-2023", 400.00, 700.00, new Plane("PL03", 36)));
        flights.add(new Flight("F004", "England", "America", 1200, 1300, 2100, "14-02-2023", "15-02-2023", 500.00, 800.00, new Plane("PL09", 32)));
        flights.add(new Flight("F005", "America", "China", 1300, 1600, 2300, "15-02-2023", "16-02-2023", 600.00, 900.00, new Plane("PL02", 32)));
        flights.add(new Flight("F006", "Japan", "America", 1400, 1500, 1900, "16-02-2023", "17-02-2023", 700.00, 1000.00, new Plane("PL01", 36)));
        flights.add(new Flight("F007", "England", "China", 1200, 1400, 2000, "17-02-2023", "18-02-2023", 100.00, 400.00, new Plane("PL05", 32)));
        flights.add(new Flight("F008", "Japan", "America", 1300, 1400, 2200, "10-02-2023", "11-02-2023", 300.00, 600.00, new Plane("PL11", 36)));
        flights.add(new Flight("F009", "America", "Japan", 1200, 1500, 2100, "13-02-2023", "14-02-2023", 200.00, 500.00, new Plane("PL01", 36)));
        flights.add(new Flight("F010", "Malaysia", "Malaysia", 1100, 1200, 2100, "20-02-2023", "21-02-2023", 100.00, 400.00, new Plane("PL07", 32)));

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
            System.out.println("            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("            |         |STAFF MENU|        |");
            System.out.println("            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("            |1. Add Flight                |");
            System.out.println("            |2. Delete Flight             |");
            System.out.println("            |3. View Flight               |");
            System.out.println("            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("                  Enter your option: ");
            selection = sc.nextInt();
            int count = 0;
            
            if (selection == 1) {
                Flight.addFlight(flights);
                selection = 0;
            } else if (selection == 2) {
                Flight.dltFlight(flights);
                selection = 0;
            } else if (selection == 3) {
                Flight.viewFlight(flights);
                selection = 0;
            }

        } while (selection == 0);

    }

}
