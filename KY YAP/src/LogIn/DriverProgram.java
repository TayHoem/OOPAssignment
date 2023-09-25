/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogIn;

/**
 *
 * @author KY YAP
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DriverProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Flight> flight = new ArrayList();
        Flight flight1 = new Flight("F001", "Malaysia", "Japan", 1200, 1300, 2000, "30-09-2023", "25-09-2023", 200.00, 400.00, new Plane("PL04", 32));
        Flight flight2 = new Flight("F002", "Japan", "Malaysia", 1300, 1400, 1800, "25-09-2023", "26-09-2023", 300.00, 600.00, new Plane("PL05", 32));
        Flight flight3 = new Flight("F003", "Malaysia", "Japan", 1400, 1500, 1900, "30-09-2023", "01-10-2023", 400.00, 700.00, new Plane("PL03", 36));
        Flight flight4 = new Flight("F004", "England", "Australia", 1200, 1300, 2100, "14-10-2023", "15-10-2023", 500.00, 800.00, new Plane("PL09", 32));
        Flight flight5 = new Flight("F005", "Australia", "China", 1300, 1600, 2300, "20-10-2023", "21-10-2023", 600.00, 900.00, new Plane("PL02", 32));
        Flight flight6 = new Flight("F006", "Japan", "Australia", 1400, 1500, 1900, "24-09-2023", "25-09-2023", 700.00, 1000.00, new Plane("PL01", 36));
        Flight flight7 = new Flight("F007", "England", "China", 1200, 1400, 2000, "25-09-2023", "26-09-2023", 100.00, 400.00, new Plane("PL05", 32));
        Flight flight8 = new Flight("F008", "Japan", "Australia", 1300, 1400, 2200, "24-09-2023", "25-09-2023", 300.00, 600.00, new Plane("PL11", 36));
        Flight flight9 = new Flight("F009", "Australia", "Japan", 1200, 1500, 2100, "20-10-2023", "21-10-2023", 200.00, 500.00, new Plane("PL01", 36));
        Flight flight10 = new Flight("F010", "Malaysia", "Australia", 1100, 1200, 2100, "20-10-2023", "21-10-2023", 100.00, 400.00, new Plane("PL07", 32));

        flight.add(flight1);
        flight.add(flight2);
        flight.add(flight3);
        flight.add(flight4);
        flight.add(flight5);
        flight.add(flight6);
        flight.add(flight7);
        flight.add(flight8);
        flight.add(flight9);
        flight.add(flight10);

        ArrayList<Customer> cust = new ArrayList();
        Customer cust1 = new Customer("040225-14-1143", "12345678", "KY YAP", "kyyap@gmail.com", "011-0818007", "Male");
        Customer cust2 = new Customer("981024-13-1985", "24681012", "Mei Ling", "123@gmail.com", "012-3456789", "Female");
        Customer cust3 = new Customer("030908-10-1983", "13579138", "Kim Ho", "secret@gmail.com", "018-2432320", "Male");
        Customer cust4 = new Customer("030908-08-1072", "13145209", "CKS", "chuchu@gmail.com", "018-9557368", "Female");

        cust.add(cust1);
        cust.add(cust2);
        cust.add(cust3);
        cust.add(cust4);

        char yesNo;
        int numOfCust = 0;
        do {
            System.out.print("              Do you have any Account?(y=Yes/n=No) > ");
            yesNo = sc.next().toUpperCase().charAt(0);
            sc.nextLine(); // Consume the newline character
            switch (yesNo) {
                case 'N':
                    System.out.println("                ^^=======================^^ ");
                    System.out.println("                ||    REGISTER Module    ||");
                    System.out.println("                <<=======================>> ");
                    Customer newCustomer = new Customer(" ", " ", " ", " ");
                    boolean registerCorrect;
                    boolean valid = false;
                    String password;
                    String icNumber;
                    String name;
                    String email;
                    String gender;
                    String phoneNumber;
                    do {
                        System.out.print("          Enter your name (Only Letter and Space): ");
                        name = sc.nextLine();
                        registerCorrect = newCustomer.getValidName(name);
                    } while (!registerCorrect);
                    do {
                        System.out.print("          Enter I/C number (Format: XXXX-XX-XXXX): ");
                        icNumber = sc.nextLine();
                        registerCorrect = newCustomer.getValidICNumber(icNumber);
                        for (Customer customer : cust) {
                            valid = icNumber.equals(customer.getCustIcNo());
                            if (valid == true) {
                                System.out.printf("   Customer I/C Number: %s already existed...Please Enter Again!!!\n\n", icNumber);
                                break;
                            }
                            valid = false;
                        }
                    } while (!registerCorrect || valid == true);
                    do {
                        System.out.print("          Enter your gender (Male/Female): ");
                        gender = sc.nextLine();
                        registerCorrect = newCustomer.getValidGender(gender);
                    } while (!registerCorrect);
                    do {
                        System.out.print("          Enter your email address (e.g: 123@gmail.com): ");
                        email = sc.nextLine();
                        registerCorrect = newCustomer.getValidEmail(email);
                        for (Customer customer : cust) {
                            valid = email.equals(customer.getEmail());
                            if (valid == true) {
                                System.out.printf("   Email: %s already existed...Please Enter Again!!!\n\n", email);
                                break;
                            }
                            valid = false;
                        }
                    } while (!registerCorrect || valid == true);
                    do {
                        System.out.print("          Enter your phone number (e.g: XXX-XXXXXXXX): ");
                        phoneNumber = sc.nextLine();
                        registerCorrect = newCustomer.getValidPhoneNumber(phoneNumber);
                        for (Customer customer : cust) {
                            valid = phoneNumber.equals(customer.getPhoneNumber());
                            if (valid == true) {
                                System.out.printf("   Phone Number: %s already existed...Please Enter Again!!!\n\n", phoneNumber);
                                break;
                            }
                            valid = false;
                        }
                    } while (!registerCorrect || valid == true);
                    do {
                        System.out.print("          Enter your password(8 digit): ");
                        password = sc.nextLine();
                        registerCorrect = newCustomer.getValidPassword(password);
                        for (Customer customer : cust) {
                            valid = password.equals(customer.getCustPassword());
                            if (valid == true) {
                                System.out.printf("    Password: %s already existed...Please Enter Again!!!\n\n", password);
                                break;
                            }
                            valid = false;
                        }
                    } while (!registerCorrect || valid == true);
                    System.out.printf("           -->Successfully Register Account...<--\n");

                    // Create a new Customer object and add it to the ArrayList
                    cust.add(new Customer(icNumber, password, name, email, phoneNumber, gender));
                case 'Y':
                    System.out.println("                ^^=======================^^ ");
                    System.out.println("                ||     Log In Module     ||");
                    System.out.println("                <<=======================>> ");
                    boolean loggedIn = false; // Flag to track if login is successful
                    do {
                        System.out.print("              Enter I/C number : ");
                        String logInIC = sc.nextLine();
                        System.out.print("              Enter password to Log In: ");
                        String logInPassword = sc.nextLine();
                        for (int i = 0; i < cust.size(); i++) {
                            loggedIn = cust.get(i).login(logInIC, logInPassword);
                            if (loggedIn == true) {
                                System.out.printf("\n          ...%s Welcome back to Airline System....\n\n", cust.get(i).getName());
                                numOfCust = i;
                                break;
                            }
                        }
                        if (loggedIn == false) {
                            System.out.printf("-->Log In Unsuccessful...Please input valid I/C number and Password<--\n\n");
                        }
                    } while (!loggedIn);
                    break;
                default:
                    System.out.println("                Invalid character...Input y/n only");
            }
        } while (yesNo != 'Y' && yesNo != 'N');

        int choose = 0;
        char book = 0;
        boolean back = false;
        do {
            displayCustomerAction();
            do {
                try {
                    System.out.printf("             Choose one action from the list > ");
                    choose = sc.nextInt();
                } catch (Exception e) {
                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                }

                switch (choose) {
                    case 1:
                        displaySearchFlight(sc, flight);
                        do {
                            System.out.print("              Proceed to Booking(y=Yes/n=No) : ");
                            book = sc.next().toUpperCase().charAt(0);
                            if (book != 'N' && book != 'Y') {
                                System.out.printf("             Invalid character...Input y/n only\n\n");
                            }
                        } while (book != 'Y' && book != 'N');
                        break;
                    case 2:
                        back = displayCustInfo(cust, numOfCust);
                        break;
                    default:
                        System.out.printf("     Input is not in the action list...Please select again!!!\n\n", choose);
                        break;
                }
            } while (choose != 1 && choose != 2);
        } while (book == 'N' || back == true);
    }

    public static boolean displayCustInfo(ArrayList<Customer> cust, int numOfCust) {
        System.out.printf("\n                ^^============================^^\n");
        System.out.println("                || Customer Infomation Module ||");
        System.out.println("                <<============================>> ");
        System.out.println(cust.get(numOfCust));
        return true;
    }

    public static void displaySearchFlight(Scanner sc, ArrayList<Flight> flight) {
        char yesNo;
        int selectDepart;
        int selectArrive;
        String tempSelectDepart = " ";
        String tempArriveDepart = " ";
        String tempInputDate = " ";

        System.out.println("\n                ^^========================^^ ");
        System.out.println("                ||  Search Flight Module  ||");
        System.out.println("                <<========================>> ");
        do {
            displayCountryOptions();
            System.out.printf("                         <====^^====>\n");
            System.out.printf("                         || Step 1 ||\n");
            System.out.printf("                         <====^^====>\n");
            do {
                try {
                    do {
                        System.out.print("         Select one departure country to search (1-5) : ");
                        selectDepart = sc.nextInt();
                        tempSelectDepart = Flight.country(selectDepart);
                    } while (tempSelectDepart.equals("Unknown"));
                    do {
                        System.out.print("    Confirm " + "[" + tempSelectDepart + "]" + " As Departure Country?(y=Yes/n=No) : ");
                        yesNo = sc.next().toUpperCase().charAt(0);
                        if (yesNo != 'N' && yesNo != 'Y') {
                            System.out.printf("           Invalid character...Input y/n only\n\n");
                        }
                    } while (yesNo != 'Y' && yesNo != 'N');
                } catch (Exception e) {
                    System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                    yesNo = 'N';
                }
            } while (yesNo == 'N');

            System.out.printf("\n");
            System.out.printf("                         <====**====>\n");
            System.out.printf("                         <> Step 2 <>\n");
            System.out.printf("                         <====**====>\n");
            do {
                try {
                    do {
                        System.out.print("           Select one arrival country to search (1-5) : ");
                        selectArrive = sc.nextInt();
                        tempArriveDepart = Flight.country(selectArrive);
                        if (tempArriveDepart.equals(tempSelectDepart)) {
                            System.out.printf("   Same Arrival Country and Departure Country Are Not Acceptable...\n\n");
                        }
                    } while (tempArriveDepart.equals("Unknown") || tempArriveDepart.equals(tempSelectDepart));
                    do {
                        System.out.print("   Confirm " + "[" + Flight.country(selectArrive) + "]" + " As Arrival Country?(y=Yes/n=No) : ");
                        yesNo = sc.next().toUpperCase().charAt(0);
                        if (yesNo != 'N' && yesNo != 'Y') {
                            System.out.printf("             Invalid character...Input y/n only\n\n");
                        }
                    } while (yesNo != 'Y' && yesNo != 'N');
                } catch (Exception e) {
                    System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                    yesNo = 'N';
                }
            } while (yesNo == 'N');

            System.out.printf("\n");
            System.out.printf("                         <====::====>\n");
            System.out.printf("                         <> Step 3 <>\n");
            System.out.printf("                         <====::====>\n");
            boolean checkDate;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date currentDate = new Date();
            System.out.printf("             ====================================\n");
            System.out.printf("             || Current Date Time: %s  ||\n", dateFormat.format(currentDate));
            System.out.printf("             ====================================\n");
            sc.nextLine();
            do {
                Date userInputDate = getUserInputDate(sc, dateFormat);
                checkDate = isValidDate(userInputDate, currentDate);

                if (checkDate == true) {
                    tempInputDate = dateFormat.format(userInputDate);
                    System.out.printf("             Input Date is Valid.\n\n");
                } else {
                    System.out.printf("       Input Date is Invalid...Please Input Correct Date with after %s\n\n", dateFormat.format(currentDate));
                }
            } while (checkDate == false);

            System.out.println("           <>==*****=====<^_^_^_^_^_^>=====*****==<>");
            System.out.println("           |||        Flight Search Result       |||");
            System.out.println("           <>==*****=====<^_^_^_^_^_^>=====*****==<>");
            boolean found = false; // Initialize a flag to track if any flight is found
            int countFlight = 0;
            for (int i = 0; i < flight.size(); i++) {
                if (flight.get(i).searchFlight(tempSelectDepart, tempArriveDepart, tempInputDate)) {
                    ++countFlight;
                    found = true; // Set the flag to true if a flight is found
                }
            }
            if (found) {
                System.out.printf("       %d flight record  successfully found on [%s]\n", countFlight, tempInputDate);
            } // Check the flag and print the appropriate message
            else {
                System.out.printf("  0 flight record found on [%s]...Please search another flight\n\n", tempInputDate);
            }
            do {
                System.out.print("              Continue Search Flight(y=Yes/n=No) : ");
                yesNo = sc.next().toUpperCase().charAt(0);
                if (yesNo != 'N' && yesNo != 'Y') {
                    System.out.printf("             Invalid character...Input y/n only\n\n");
                }
            } while (yesNo != 'Y' && yesNo != 'N');
        } while (yesNo == 'Y');
    }

    public static void displayCountryOptions() {
        System.out.println("    ^^==***===***===***==^^        ^^==***===***===***==^^");
        System.out.println("    || Departure Country || -----> ||  Arrival Country  ||");
        System.out.println("    ^^==***===***===***==^^  Both  ^^==***===***===***==^^");
        System.out.println("    ||   1) Japan        <> Choose <>   1) Japan        ||");
        System.out.println("    <>   2) Malaysia     || -----> ||   2) Malaysia     <>");
        System.out.println("    ||   3) England      <>  One   <>   3) England      ||");
        System.out.println("    <>   4) China        || Contry ||   4) China        <>");
        System.out.println("    ||   5) Australia    <> -----> <>   5) Australia    ||");
        System.out.println("    ^^==***===***===***==^^        ^^==***===***===***==^^");
    }

    public static void displayCustomerAction() {
        System.out.println("              ^^==============================^^");
        System.out.println("              ||        Customer Action       ||");
        System.out.println("              ^^==============================^^");
        System.out.println("              ||  1. Search Flight            ||");
        System.out.println("              ||  2. View Customer Infomation ||");
        System.out.println("              ^^==============================^^");
    }

    public static Date getUserInputDate(Scanner scanner, SimpleDateFormat dateFormat) {
        Date date = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.printf("          Input a Departure Date to search :");
            String input = scanner.nextLine();

            try {
                date = dateFormat.parse(input);
                validInput = true;
            } catch (ParseException e) {
                System.out.printf("        Invalid Date Format. Please fulfill Format: dd-MM-yyyy.\n\n");
            }
        }
        return date;
    }

    public static boolean isValidDate(Date userInputDate, Date currentDate) {
        Calendar userCalendar = Calendar.getInstance();

        userCalendar.setTime(userInputDate);
        if (userCalendar.get(Calendar.YEAR) > 2023 || userCalendar.get(Calendar.MONTH) > 12 || userCalendar.get(Calendar.DAY_OF_MONTH) > 31) {
            return false;
        }

        return !userInputDate.before(currentDate);
    }
}

//        displaySeatType();
//        do {
//            do {
//                System.out.print("Select a seat to search(1-2) : ");
//                seatSearch = sc.nextInt();
//                Seat.searchSeat(seatSearch);
//                if (Seat.searchSeat(seatSearch).equals("Unknown")) {
//                    System.out.printf("Invalid selection %d...Please enter 1 or 2 only\n\n", seatSearch);
//                }
//            } while (Seat.searchSeat(seatSearch).equals("Unknown"));
//            do {
//                System.out.print("Confirm " + "[" + Seat.searchSeat(seatSearch) + "]" + " As Type Of Seat?(y=Yes/n=No) : ");
//                yesNo = sc.next().toUpperCase().charAt(0);
//                if (yesNo != 'N' && yesNo != 'Y') {
//                    System.out.printf("Invalid character...Input y/n only\n\n");
//                }
//            } while (yesNo != 'Y' && yesNo != 'N');
//        } while (yesNo == 'N');
//    public static void displaySeatType() {
//        System.out.println("^^==<>=====<>=====<>==^^");
//        System.out.println("||    Type Of Seat    ||");
//        System.out.println("^^==<>=====<>=====<>==^^");
//        System.out.println("|| 1) Economy Seat    ||");
//        System.out.println("|| 2) Business Seat   ||");
//        System.out.println("^^==<>=====<>=====<>==^^");
//    }
