/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.Objects;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author KY YAP
 */
public class Customer extends Person {

    private String custIcNo;
    private String custPassword;

    public Customer(String name, String email, String phoneNumber, String gender) {
        super(name, phoneNumber, gender, email);
    }

    public Customer(String custIcNo, String custPassword, String name, String email, String phone, String gender) {
        super(name, phone, gender, email);
        this.custIcNo = custIcNo;
        this.custPassword = custPassword;
    }

    public String getCustIcNo() {
        return custIcNo;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public int login(ArrayList<Customer> cust) {
        Scanner sc = new Scanner(System.in);
        int countCust = 0;
        System.out.println("                ^^=======================^^ ");
        System.out.println("                ||     Log In Module     ||");
        System.out.println("                <<=======================>> ");
        do {
            System.out.print("              Enter I/C number : ");
            String logInIC = sc.nextLine();
            System.out.print("              Enter password to Log In: ");
            String logInPassword = sc.nextLine();
            for (int i = 0; i < cust.size(); i++) {
                if (logInIC.equals(cust.get(i).custIcNo) && logInPassword.equals(cust.get(i).custPassword)) {
                    System.out.println("                  -->Log In Successful<--");
                    System.out.printf("\n          [...%s Welcome back to Airline System....]\n\n", cust.get(i).getName());
                    countCust = i;
                    return countCust;
                }
            }
            if (countCust == 0) {
                System.out.printf("-->Log In Unsuccessful...Please input valid I/C number and Password<--\n\n");
            }
        } while (countCust == 0);
        return countCust;
    }

    public boolean getValidPassword(String password) {
        // Basic validation: Check if the password has a minimum length
        if (password.length() >= 8 && password.length() <= 8) {
            this.custPassword = password;
            return true;
        } else {
            System.out.println("         Password must be only 8 characters.");
            System.out.printf("\n");
        }
        return false;
    }

    public boolean getValidICNumber(String icNumber) {
        // Basic validation: Check if the I/C number has the expected format
        if (icNumber.matches("\\d{6}-\\d{2}-\\d{4}")) {
            this.custIcNo = icNumber;
            return true;
        } else {
            System.out.println("Invalid I/C number format. Please use the format XXXXXX-XX-XXXX.");
            System.out.printf("\n");
        }
        return false;
    }

    public int register(ArrayList<Customer> cust) {
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        Customer newCustomer = new Customer(" ", " ", " ", " ");
        boolean registerCorrect;
        boolean valid = false;
        String password;
        String icNumber;
        String name;
        String email;
        String gender;
        String phoneNumber;
        System.out.println("                ^^=======================^^ ");
        System.out.println("                ||    REGISTER Module    ||");
        System.out.println("                <<=======================>> ");
        System.out.printf(">>*=**==**==**==**==**==[Register Your Name]=**==**==**==**==**==**<<\n");
        do {
            System.out.print("          Enter your name (Only Letter and Space): ");
            name = sc.nextLine();
            registerCorrect = newCustomer.getValidName(name);
        } while (!registerCorrect);
        System.out.printf("\n");
        System.out.printf(">>=**==**==**==**==**==[Register I/C Number]=**==**==**==**==**==**<<\n");
        do {
            System.out.print("          Enter I/C number (Format: XXXXXX-XX-XXXX): ");
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
        System.out.printf("\n");
        System.out.printf(">>=**==**==**==**==**==[Register Your Gender]=**==**==**==**==**==*<<\n");
        do {
            System.out.print("          Enter your gender (Male/Female): ");
            gender = sc.nextLine();
            registerCorrect = newCustomer.getValidGender(gender);
        } while (!registerCorrect);
        System.out.printf("\n");
        System.out.printf(">>**==**==**==**==**==[Register Email Address]=**==**==**==**==**==<<\n");
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
        System.out.printf("\n");
        System.out.printf(">>=**==**==**==**==**==[Register Phone Number]=**==**==**==**==**==<<\n");
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
        System.out.printf("\n");
        System.out.printf(">>=**==**==**==**==**==[Register With Password]=**==**==**==**==**=<<\n");
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
        System.out.printf("\n");
        System.out.printf(">>*==**==**==**==**==[Glad To Become Part Of Us]=**==**==**==**==**<<\n");
        System.out.printf("               -->Successfully Register Account...<--\n");

        // Create a new Customer object and add it to the ArrayList
        cust.add(new Customer(icNumber, password, name, email, phoneNumber, gender));
        cont = 1;
        return cont;
    }

    public int searchFlight(String departCountry, String arriveCountry, String inputDate, ArrayList<Flight> flight) {
        int countFlight = 0;
        for (int i = 0; i < flight.size(); i++) {
            if (departCountry.equalsIgnoreCase(flight.get(i).getDpCOuntry()) && inputDate.equalsIgnoreCase(flight.get(i).getDpDate()) && arriveCountry.equalsIgnoreCase(flight.get(i).getArrCountry())) {
                System.out.printf("           =========================================\n");
                System.out.printf("           ||          Flight ID : %s           ||\n", flight.get(i).getFlightID());
                System.out.printf("           =========================================\n");
                System.out.printf("           ||  DepartTime     --->    ArriveTime  ||\n");
                System.out.printf("           ||    %d                    %d     ||\n", flight.get(i).getDpTime(), flight.get(i).getEstimateArrivalTime());
                System.out.printf("           ||                 --->                ||\n");
                System.out.printf("           || DepartCountry         ArriveCountry ||\n");
                System.out.printf("           ||    %s        --->     %s   ||\n", flight.get(i).getDpCOuntry(), flight.get(i).getArrCountry());
                System.out.printf("           =========================================\n");
                System.out.printf("           ||      Economy Price : %.2f         ||\n", flight.get(i).getEcoPrice());
                System.out.printf("           =========================================\n");
                System.out.printf("           ||     Business Price : %.2f         ||\n", flight.get(i).getBsPrice());
                System.out.printf("           =========================================\n\n");
                ++countFlight;
            }
        }
        return countFlight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.custIcNo, other.custIcNo)) {
            return false;
        }
        return Objects.equals(this.custPassword, other.custPassword);
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "\n                Customer I/C Number : %s\n                Customer Password : %s\n", custIcNo, custPassword);
    }
    
    // booking ticket process for select flight and seat
    public ArrayList bookingTicket(ArrayList<Seat> arrSeat, ArrayList<Flight> flights, int bookFlight, Customer tcustomer) {
        Scanner input = new Scanner(System.in);
        char isContinue = 'N';
        boolean isdigit = false;
        boolean invalid = true;
        String tempName, tempPassport, tempPhoneNo;
        int tempSeatID = 0;
        ArrayList<Ticket> tempArrTicket = new ArrayList<Ticket>();
        tempArrTicket.clear();
        Passenger validpassenger = new Passenger();
        //Passenger tempPassenger = new Passenger("");

        do {
            System.out.println("                Example : ");
            System.out.println("                Seat ID = 10(1 = row , 0 = column)          ");
            System.out.println("");

            do {
                try {
                    System.out.print("              Enter your Seat ID                  : ");
                    tempSeatID = input.nextInt();

                } catch (Exception E) {

                }
                isdigit = Seat.validSeatID(arrSeat, flights, tempSeatID, bookFlight);
                input.nextLine();
            } while (!isdigit);

            //turn status to selected
            do {
                System.out.print("              Enter the Passenger Name            : ");
                tempName = input.nextLine();
            } while (!validpassenger.getValidName(tempName));

            do {
                System.out.print("              Enter the Passenger Passport Number : ");
                tempPassport = input.nextLine();
            } while (!validpassenger.ValidPassportNo(tempPassport));

            do {
                System.out.print("              Enter the Passenger Phone Number    : ");
                tempPhoneNo = input.nextLine();
            } while (!validpassenger.getValidPhoneNumber(tempPhoneNo));

            Passenger tempPassenger = new Passenger(tempPassport, tempName, "", tempPhoneNo, "");
            Seat tempSeat = Seat.findSeat(arrSeat, flights, tempSeatID, bookFlight);
            tempArrTicket.add(new Ticket(tempSeat, tempPassenger, tcustomer));      //add to temp arraylist to convenient for recover when customer cancel booking

            do {
                System.out.printf("\n\n");
                invalid = false;
                try {
                    System.out.print("              Are you want to buy another ticket in the same Flight?(Y/N) :");
                    isContinue = Character.toUpperCase(input.nextLine().charAt(0));
                } catch (Exception e) {
                    System.out.println("                Invalid Respond. Please enter Y or N ");
                    invalid = true;
                }
            } while (invalid);

        } while (isContinue == 'Y');
        Seat.returnEmpty(arrSeat);
        return tempArrTicket;
    }

    //the complete booking flight ticket process
    public boolean booking(ArrayList<Flight> flights, ArrayList<Seat> arrSeat, ArrayList<Payment> arrPayment, ArrayList<Ticket> arrTicket, Customer customer1) {
        Scanner input = new Scanner(System.in);
        char respond;
        ArrayList<Ticket> tempTckt = new ArrayList<Ticket>();

        System.out.println("                +=========================================+");
        System.out.println("                |                                         |");
        System.out.println("                |               BOOKING TICKET            |");
        System.out.println("                |                                         |");
        System.out.println("                +=========================================+");
        System.out.printf("\n\n");

        int indexBookFlight = Flight.displayFlight(flights, arrSeat);
        do {
            System.out.print("Continue to book ticket on this flight?(Y=yes/N=no) :");
            respond = Character.toUpperCase(input.next().charAt(0));

            if (respond == 'Y') {

                tempTckt = customer1.bookingTicket(arrSeat, flights, indexBookFlight, customer1);

                double totalPayment = Payment.calcPayment(tempTckt);

                if (Payment.makePayment(arrPayment, totalPayment)) {
                    //System.out.println(tempTckt.get(0).toString());
                    Ticket.generateTicket(arrTicket, tempTckt);
                }

            } else if (respond == 'N') {
                System.out.println("You will reset the booking process.");
            } else {
                System.out.println("Please select Y or N only!");
            }
        } while (respond != 'Y' && respond != 'N');
        return true;
    }
    
    //ask customer to continue booking 
    public static boolean continueBooking() {
        Scanner input = new Scanner(System.in);
        System.out.print("              Are you continue to booking ? (Y = yes / N = no) : ");
        char respond = Character.toUpperCase(input.next().charAt(0));
        if (respond == 'Y') {
            return true;
        } else {
            return false;
        }
    }

    //display ticket that book by the customer
    public boolean displayTicket(ArrayList<Ticket> arrTicket) {
        Scanner input = new Scanner(System.in);
        int success = 0;
        System.out.println("                +=========================================+");
        System.out.println("                |                                         |");
        System.out.println("                |               DISPLAY TICKET            |");
        System.out.println("                |                                         |");
        System.out.println("                +=========================================+");
        System.out.printf("\n\n");

        for (int i = 0; i < arrTicket.size(); i++) {
            if (arrTicket.get(i).getCustomer().getCustIcNo().equals(this.custIcNo)) {
                System.out.printf("                                 Ticket No. %d\n", success + 1);
                System.out.printf("        <<---------------------------(%d)--------------------------->>\n", success + 1);
                arrTicket.get(i).ticketDisplay(arrTicket.get(i));
                System.out.printf("\n        <<---------------------------(%d)--------------------------->>\n\n\n", success + 1);
                success++;
            }
        }
        if (success == 0) {
            System.out.printf("\n                    You have not book any ticket yet.....\n");
        }
        System.out.println("");
        System.out.print("Enter any key to back to main menu : ");
        char nothing = input.next().charAt(0);
        return true;
    }

    public static boolean displayCustInfo(ArrayList<Customer> cust, int numOfCust) {
        System.out.printf("\n                ^^============================^^\n");
        System.out.println("                || Customer Infomation Module ||");
        System.out.println("                <<============================>> ");
        System.out.println(cust.get(numOfCust));
        return true;
    }

    public void displaySearchFlight(Scanner sc, ArrayList<Flight> flight) {
        char yesNo;
        int selectDepart;
        int selectArrive;
        int getCountFlight;
        boolean checkDate;
        String tempSelectDepart = " ";
        String tempArriveDepart = " ";
        String tempInputDate = " ";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();

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
                    System.out.printf("Input Date is Invalid...Please Input Correct Date with after %s\n\n", dateFormat.format(currentDate));
                }
            } while (checkDate == false);

            System.out.println("           <>==*****=====<^_^_^_^_^_^>=====*****==<>");
            System.out.println("           |||        Flight Search Result       |||");
            System.out.println("           <>==*****=====<^_^_^_^_^_^>=====*****==<>");
            getCountFlight = searchFlight(tempSelectDepart, tempArriveDepart, tempInputDate, flight);

            if (getCountFlight > 0) {
                System.out.printf("       %d flight record  successfully found on [%s]\n", getCountFlight, tempInputDate);
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
        System.out.println("              ||  3. Book Flight Ticket       ||");
        System.out.println("              ||  4. Display Flight Ticket    ||");
        System.out.println("              ||  5. Logout to main menu      ||");
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
                System.out.printf("        Invalid Date Format. Please fulfill Format: dd/MM/yyyy.\n\n");
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
