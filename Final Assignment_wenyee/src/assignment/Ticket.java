/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author ANG
 */
import java.util.ArrayList;

public class Ticket {

    private Seat seat;
    private Passenger passenger;
    private Customer customer;
    //constructor
    public Ticket(Seat seat, Passenger passenger, Customer customer) {

        this.seat = seat;
        this.passenger = passenger;
        this.customer = customer;
    }
    //getter
    public Seat getSeat() {
        return seat;
    }
    
    public Passenger getPassenger() {
        return passenger;
    }

    public Customer getCustomer() {
        return customer;
    }
    //generate ticket object after the customer make payment 
    public static ArrayList generateTicket(ArrayList<Ticket> arrTicket, ArrayList<Ticket> tempTckt) {
        for (int i = 0; i < tempTckt.size(); i++) {
            //Ticket tempTk = (Ticket)tempTckt.get(i).clone();
            tempTckt.get(i).getSeat().setStatusSeat("Booked");
            arrTicket.add(tempTckt.get(i));
        }

        return arrTicket;
    }
    //display ticket that book by the customer
    public void ticketDisplay(Ticket ticket) {
        //  return "Ticket{" + "seat=" + seat + ", passenger=" + passenger + ", customer=" + customer + '}';
        System.out.printf("             %-10s: %-35s\n", "Name ", ticket.getPassenger().getName());
        System.out.printf("             %-10s: %-10s\n", "Passport ", ticket.getPassenger().getPassportNo());
        System.out.printf("             %-10s: %-13s --------->    %-13s\n", "From - To ", ticket.getSeat().getFlight().getDpCOuntry(), ticket.getSeat().getFlight().getArrCountry());
        System.out.printf("             %-10s: %-10s    --------->    %-10s\n", "Date ", ticket.getSeat().getFlight().getDpDate(), ticket.getSeat().getFlight().getArrivalDate());
        System.out.printf("             %-10s: %04d          --------->    %04d\n", "Time ", ticket.getSeat().getFlight().getDpTime(), ticket.getSeat().getFlight().getEstimateArrivalTime());
        System.out.printf("\n");
        System.out.printf("             %-8s\t%-5s\t%-10s\t%-10s\n", "Flight", "Seat", "Class", "Board Till");
        System.out.printf("             --------\t-----\t----------\t----------\n");
        System.out.printf("             %-8s\t%-5s\t%-10s\t%04d\n", ticket.getSeat().getFlight().getFlightID(), ticket.getSeat().getSeatID(), ticket.getSeat().getTypeOfSeat(), ticket.getSeat().getFlight().getBdTime());
    }

}
