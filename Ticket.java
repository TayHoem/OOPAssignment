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
public class Ticket implements Cloneable{
    private static int ticketNo = 1001;   //T01


    private Seat seat;
    private Passenger passenger;
    private Customer customer;

    public Ticket(Seat seat, Passenger passenger, Customer customer) {
        this.ticketNo = ticketNo;
        this.seat = seat;
        this.passenger = passenger;
        this.customer = customer;
        ticketNo++;
    }

    public static int getTicketNo() {
        return ticketNo;
    }

    public Seat getSeat() {
        return seat;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public static ArrayList generateTicket(ArrayList<Ticket> arrTicket,ArrayList<Ticket> tempTckt){
        for(int i=0;i<tempTckt.size();i++){
            //Ticket tempTk = (Ticket)tempTckt.get(i).clone();
            tempTckt.get(i).getSeat().setStatusSeat("Booked");
            arrTicket.add(tempTckt.get(i));
    }
        
        return arrTicket;
    }

    @Override
    public Object clone(){
        try{
            return super.clone();
        }
     catch(CloneNotSupportedException ex){
         return null;
     }
    }

    @Override
    public String toString() {
        return "Ticket{" + "seat=" + seat + ", passenger=" + passenger + ", customer=" + customer + '}';
    }
    
    
}
