/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

/**
 *
 * @author ANG
 */
import java.util.ArrayList;

public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Flight> arrFlight = new ArrayList<Flight>();
        ArrayList<Seat> arrSeat = new ArrayList<Seat>();
       
        ArrayList<Ticket> arrTicket = new ArrayList<Ticket>();
        ArrayList<Payment> arrPayment = new ArrayList<Payment>();
        
        Plane plane1 = new Plane("P01",36);
        Plane plane2 = new Plane("P02",20);
        Flight flight1 = new Flight("F03","Malaysia","Japan",1200,1300,2000,"12-02-2023","12-02-2023",200.00,600.00,plane1);
        Flight flight2 = new Flight("F04","Japan","England",900,1000,2100,"16-04-2023","16-04-2023",900.00,1600.00,plane2);
        arrFlight.add(flight1);
        arrFlight.add(flight2);
        //Flight.displaySeat();
        flight1.defineSeat(arrSeat, flight1);
        flight2.defineSeat(arrSeat, flight2);
        
        Customer customer1 = new Customer("012345567","lily","Lily","lily@hotmail","010-2345678","Female");
        arrSeat.get(5).setStatusSeat("Booked");
      
        
do{
        customer1.booking(arrFlight, arrSeat, arrPayment, arrTicket, customer1);
}while(Customer.continueBooking());

        customer1.displayTicket(arrTicket);
    }
    
}
