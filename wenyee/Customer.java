/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author ANG
 */
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author KY YAP
 */
public class Customer extends Person {

    private String custIcNo;
    private String custPassword;

    public Customer(String name, String email, String phoneNumber, String gender) {
        super(name, email, phoneNumber, gender);
    }

    public Customer(String custIcNo, String custPassword, String name, String email, String phone, String gender) {
        super(name, email, phone, gender);
        this.custIcNo = custIcNo;
        this.custPassword = custPassword;
    }

    public String getCustIcNo() {
        return custIcNo;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public boolean login(String logInIC, String logInPassword) {
        if (logInIC.equals(custIcNo) && logInPassword.equals(custPassword)) {
            System.out.println("-->Log In Successful<--");
            return true;
        }
        return false;
    }

    public boolean getValidPassword(String password) {
        // Basic validation: Check if the password has a minimum length
        if (password.length() >= 8 && password.length() <= 8) {
            this.custPassword = password;
            return true;
        } else {
            System.out.println("Password must be only 8 characters.");
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
        return super.toString() + "Customer{" + "custIcNo=" + custIcNo + ", custPassword=" + custPassword + '}';
    }

    public ArrayList bookingTicket(ArrayList<Seat> arrSeat, ArrayList<Flight> arrFlight, int bookFlight, Customer tcustomer) {
        Scanner input = new Scanner(System.in);
        char isContinue;
        String tempName, tempPassport, tempPhoneNo;
        int tempSeatID;
        ArrayList<Ticket> tempArrTicket = new ArrayList<Ticket>();
        tempArrTicket.clear();
        Passenger validpassenger = new Passenger();
        //Passenger tempPassenger = new Passenger("");
        do {
            System.out.println("                Seat ID = xy(x = row , y = column)          ");
            System.out.println("");
            do {
                System.out.print("              Enter your Seat ID                  : ");
                tempSeatID = input.nextInt();
                input.nextLine();
            } while (!Seat.validSeatID(arrSeat, arrFlight, tempSeatID, bookFlight));
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
            Seat tempSeat = Seat.findSeat(arrSeat, arrFlight, tempSeatID, bookFlight);
            tempArrTicket.add(new Ticket(tempSeat, tempPassenger, tcustomer));

            System.out.printf("\n\n");
            System.out.print("              Are you want to buy another ticket in the same Flight?(Y/N) :");
            isContinue = Character.toUpperCase(input.nextLine().charAt(0));
           
           
        } while (isContinue == 'Y');
        Seat.returnEmpty(arrSeat);
        return tempArrTicket;
    }



    public void booking(ArrayList<Flight> arrFlight, ArrayList<Seat> arrSeat, ArrayList<Payment> arrPayment, ArrayList<Ticket> arrTicket, Customer customer1) {
        ArrayList<Ticket> tempTckt = new ArrayList<Ticket>();

        System.out.println("                +=========================================+");
        System.out.println("                |                                         |");
        System.out.println("                |               BOOKING TICKET            |");
        System.out.println("                |                                         |");
        System.out.println("                +=========================================+");
        System.out.printf("\n\n");
            
        int indexBookFlight = Flight.displayFlight(arrFlight, arrSeat);
        tempTckt = customer1.bookingTicket(arrSeat, arrFlight, indexBookFlight, customer1);     
        
        double totalPayment = Payment.calcPayment(tempTckt);

        if (Payment.makePayment(arrPayment, totalPayment)) {
            //System.out.println(tempTckt.get(0).toString());
            Ticket.generateTicket(arrTicket, tempTckt);
        }
    }

    public static boolean continueBooking() {
        Scanner input = new Scanner(System.in);
        System.out.print("              Are you continue to booking ? (Y = yes / N = no) : ");
        char respond = Character.toUpperCase(input.nextLine().charAt(0));
        if (respond == 'Y') {
            return true;
        } else {
            return false;
        }
    }
    
        public void displayTicket(ArrayList<Ticket> arrTicket) {
            int success=0;
        System.out.println("                +=========================================+");
        System.out.println("                |                                         |");
        System.out.println("                |               DISPLAY TICKET            |");
        System.out.println("                |                                         |");
        System.out.println("                +=========================================+");
        System.out.printf("\n\n");

        for (int i = 0; i < arrTicket.size(); i++) {
            if (arrTicket.get(i).getCustomer().getCustIcNo().equals(this.custIcNo)) {
                System.out.printf("                                 Ticket No. %d\n",success+1);
                System.out.printf("        <<---------------------------(%d)--------------------------->>\n",success+1);
               arrTicket.get(i).ticketDisplay(arrTicket.get(i));
                System.out.printf("\n        <<---------------------------(%d)--------------------------->>\n\n\n",success+1);
               success++;
            }
        }
        if(success == 0){
            System.out.printf("\n               You have book any ticket.\n");
        }
    }
        
        
}
