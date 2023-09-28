/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Acer
 */
import java.util.Scanner;
import java.util.ArrayList;

public class main {

    public static void main(String args[]) {
        int staffCount = 0, selection = 0;
        String notStaff = null;
        int toMenu = 0;
        int chooseUser;
        Scanner sc = new Scanner(System.in);
        Staff[] staffArray = new Staff[10]; // You can adjust the size as needed
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<Customer> cust = new ArrayList();
        ArrayList<Seat> arrSeat = new ArrayList<>();
        ArrayList<Payment> arrPayment = new ArrayList<>();
        ArrayList<Ticket> arrTicket = new ArrayList<>();
        Plane plane = new Plane();

        //declare default object
        flights.add(new Flight("F001", "Malaysia", "Japan", 1200, 1300, 2000, "11/11/2023", "12/11/2023", 200.00, 400.00, new Plane("PL04", 32)));
        flights.add(new Flight("F002", "Malaysia", "Japan", 1300, 1400, 1800, "11/11/2023", "14/11/2023", 300.00, 600.00, new Plane("PL05", 32)));
        flights.add(new Flight("F003", "Malaysia", "Japan", 1400, 1500, 1900, "11/11/2023", "13/11/2023", 400.00, 700.00, new Plane("PL03", 36)));
        flights.add(new Flight("F004", "England", "Australia", 1200, 1300, 2100, "14/11/2023", "15/11/2023", 500.00, 800.00, new Plane("PL09", 32)));
        flights.add(new Flight("F005", "Australia", "China", 1300, 1600, 2300, "15/11/2023", "16/11/2023", 600.00, 900.00, new Plane("PL02", 32)));
        flights.add(new Flight("F006", "Japan", "Australia", 1400, 1500, 1900, "16/12/2023", "17/12/2023", 700.00, 1000.00, new Plane("PL01", 36)));
        flights.add(new Flight("F007", "England", "China", 1200, 1400, 2000, "17/12/2023", "18/12/2023", 100.00, 400.00, new Plane("PL05", 32)));
        flights.add(new Flight("F008", "Japan", "Australia", 1300, 1400, 2200, "10/12/2023", "11/12/2023", 300.00, 600.00, new Plane("PL11", 36)));
        flights.add(new Flight("F009", "Australia", "Japan", 1200, 1500, 2100, "13/12/2023", "14/12/2023", 200.00, 500.00, new Plane("PL01", 36)));
        flights.add(new Flight("F010", "Malaysia", "Malaysia", 1100, 1200, 2100, "20/12/2023", "21/12/2023", 100.00, 400.00, new Plane("PL07", 32)));
        for (int i = 0; i < flights.size(); i++) {
            flights.get(i).defineSeat(arrSeat, flights.get(i));
        }

        // Populate the array with staff members
        staffArray[0] = new Staff("S001", "Manager", 11111, "Apple Doe", "015-5555555", "MALE", "john@example.com");
        staffArray[1] = new Staff("S002", "Airline Controller", 22222, "Bun Smith", "012-345678", "FEMALE", "jane@example.com");
        staffArray[2] = new Staff("S003", "Airline Controller", 33333, "Coocies Johnson", "014-567890", "MALE", "bob@example.com");
        staffArray[3] = new Staff("S004", "Airline Controller", 44444, "Duck Brown", "019-7899908", "FEMALE", "alice@example.com");
        staffArray[4] = new Staff("S005", "Airline Controller", 55555, "Egg Lee", "013-2727589", "MALE", "eva@example.com");
        staffArray[5] = new Staff("S006", "Airline Controller", 66666, "Fruit Chan", "019-9999999", "FEMALE", "owom@example.com");
        staffArray[6] = new Staff("S007", "Airline Controller", 77777, "Grass wong", "018-7976902", "MALE", "pema@example.com");
        staffArray[7] = new Staff("S008", "Airline Controller", 88888, "Ham chan", "017-7787960", "FEMALE", "sosy@example.com");
        staffArray[8] = new Staff("S009", "Airline Controller", 99999, "Ice loo", "0197891111", "MALE", "kokonut@example.com");
        staffArray[9] = new Staff("S000", "Airline Controller", 00000, "Juice hee", "014-4444444", "FEMALE", "polipo@example.com");

        Customer cust1 = new Customer("040225-14-1143", "12345678", "KY YAP", "kyyap@gmail.com", "011-0818007", "Male");
        Customer cust2 = new Customer("981024-13-1985", "24681012", "Mei Ling", "123@gmail.com", "012-3456789", "Female");
        Customer cust3 = new Customer("030908-10-1983", "13579138", "Kim Ho", "secret@gmail.com", "018-2432320", "Male");
        Customer cust4 = new Customer("030908-08-1072", "13145209", "CKS", "chuchu@gmail.com", "018-9557368", "Female");

        cust.add(cust1);
        cust.add(cust2);
        cust.add(cust3);
        cust.add(cust4);
        
         //main program start
        do {
            System.out.println("         /$$$$$$$$/$$      /$$  /$$$$$$  /$$     /$$");
            System.out.println("        |__  $$__/ $$  /$ | $$ /$$__  $$|  $$   /$$/");
            System.out.println("           | $$  | $$ /$$$| $$| $$  \\__/ \\  $$ /$$/ ");
            System.out.println("           | $$  | $$/$$ $$ $$| $$        \\  $$$$/  ");
            System.out.println("           | $$  | $$$$_  $$$$| $$         \\  $$/   ");
            System.out.println("           | $$  | $$$/ \\  $$$| $$    $$    | $$    ");
            System.out.println("           | $$  | $$/   \\  $$|  $$$$$$/    | $$    ");
            System.out.println("           |__/  |__/     \\__/ \\______/     |__/    \n");
            System.out.println("                      >>> WELCOME <<<      ");
            System.out.println("                ===========================");
            System.out.println("                |       1. Staff          |");
            System.out.println("                |       2. Customer       |");
            System.out.println("                |       3. Exit           |");
            System.out.println("                ===========================");

            try {
                System.out.print("                  Enter (1 or 2 ):");
                chooseUser = sc.nextInt();
            } catch (Exception e) {
                System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                chooseUser = 0;
            }

            switch (chooseUser) {
                case 1:
                    Staff.defineStaff(staffArray, flights, arrSeat, arrTicket, arrPayment);  //into staff module
                    chooseUser = 0;
                    break;
                case 2:         //customer module
                    char yesNo;
                    int numOfCust = 0;
                    int next = 0;
                    int choose = 0;
                    char book = 0;
                    boolean back = false;
                    for (Customer customer : cust) {
                        do {
                            System.out.println("                     ==================                ");
                            System.out.println("                     |    CUSTOMER    |                ");
                            System.out.println("                     ==================                ");
                            System.out.print("              Do you have any Account?(y=Yes/n=No) > ");
                            yesNo = sc.next().toUpperCase().charAt(0);
                            sc.nextLine(); // Consume the newline character
                            if (yesNo == 'N') {
                                next = customer.register(cust);
                            }
                            if (yesNo == 'Y' || next == 1) {
                                numOfCust = customer.login(cust);
                            } else {
                                System.out.printf("                Invalid character...Input y/n only\n\n");
                            }
                        } while (yesNo != 'Y' && yesNo != 'N');
                        do {
                            Customer.displayCustomerAction();   //display customer main menu
                            do {
                                try {
                                    System.out.printf("             Choose one action from the list > ");
                                    choose = sc.nextInt();
                                } catch (Exception e) {
                                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                                }

                                switch (choose) {
                                    case 1:
                                        customer.displaySearchFlight(sc, flights);
                                        do {
                                            System.out.print("              Proceed to Booking(y=Yes/n=No) : ");
                                            book = sc.next().toUpperCase().charAt(0);
                                            if (book == 'Y') {
                                                do {
                                                    back = cust.get(numOfCust).booking(flights, arrSeat, arrPayment, arrTicket, cust.get(numOfCust));
                                                } while (Customer.continueBooking());
                                            } else if (book != 'N' && book != 'Y') {
                                                System.out.printf("             Invalid character...Input y/n only\n\n");
                                            }
                                        } while (book != 'Y' && book != 'N');
                                        break;
                                    case 2:
                                        back = Customer.displayCustInfo(cust, numOfCust);
                                        break;
                                    case 3:
                                        do {
                                            back = cust.get(numOfCust).booking(flights, arrSeat, arrPayment, arrTicket, cust.get(numOfCust));
                                        } while (Customer.continueBooking());
                                        break;
                                    case 4:
                                        back = cust.get(numOfCust).displayTicket(arrTicket);
                                        break;
                                    case 5:
                                        System.out.println("                You have logout.");
                                        back = false;
                                        book = 'Y';
                                        break;
                                    default:
                                        System.out.printf("     Input is not in the action list...Please select again!!!\n\n", choose);
                                        break;
                                }
                            } while (choose < 1 || choose > 5);
                        } while (book == 'N' || back == true);
                        break;
                    }
                    chooseUser = 0;
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter 1, 2, and 3 only");
                    break;
            }
        } while (chooseUser < 1 || chooseUser > 2);
    }

}
