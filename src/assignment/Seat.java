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
import java.util.Objects;

public class Seat {

    private int seatID;
    private String typeOfSeat;
    private String statusSeat;
    private Flight flight;
    //constructor
    public Seat(int seatID, String typeOfSeat, String statusSeat, Flight flight) {
        this.seatID = seatID;
        this.typeOfSeat = typeOfSeat;
        this.statusSeat = statusSeat;
        this.flight = flight;

    }
    //setter
    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public void setStatusSeat(String statusSeat) {
        this.statusSeat = statusSeat;
    }
    //getter
    public int getSeatID() {
        return seatID;
    }

    public String getTypeOfSeat() {
        return typeOfSeat;
    }

    public String getStatusSeat() {
        return statusSeat;
    }

    public Flight getFlight() {
        return flight;
    }
    //use for checking the seat status is empty for displaying the seat status when customer booking
    public boolean findSeatEmpty(ArrayList<Seat> arrSeat, int id, Flight flight) {
        boolean valid = false;

        for (int i = 0; i < arrSeat.size(); i++) {
            if (arrSeat.get(i).seatID == id && arrSeat.get(i).statusSeat.equalsIgnoreCase("Empty") && arrSeat.get(i).getFlight().getFlightID().equalsIgnoreCase(flight.getFlightID())) {
                valid = true;
            }
        }
        return valid;
    }
    //find the seat object that customer book
    public static Seat findSeat(ArrayList<Seat> arrSeat, ArrayList<Flight> arrFlight, int seatID, int bookFlight) {
        int successIndex = -1;
        for (int i = 0; i < arrSeat.size(); i++) {
            if (arrSeat.get(i).getSeatID() == seatID && arrSeat.get(i).getFlight() == arrFlight.get(bookFlight)) {
                successIndex = i;
            }
        }
        return arrSeat.get(successIndex);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Seat other = (Seat) obj;
        if (this.seatID != other.seatID) {
            return false;
        }
        if (!Objects.equals(this.typeOfSeat, other.typeOfSeat)) {
            return false;
        }
        if (!Objects.equals(this.statusSeat, other.statusSeat)) {
            return false;
        }
        return Objects.equals(this.flight, other.flight);
    }

  

   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seat{");
        sb.append("seatID=").append(seatID);
        sb.append(", typeOfSeat=").append(typeOfSeat);
        sb.append(", statusSeat=").append(statusSeat);
        sb.append(", flight=").append(flight);
        sb.append('}');
        return sb.toString();
    }
    //validation the seat is empty and not be booked and selected by customers
    public static boolean validSeatID(ArrayList<Seat> arrSeat, ArrayList<Flight> arrFlight, int searchSeat, int bookFlightIndex) {
        boolean valid = false;
        int successFind =0;
        for (int i = 0; i < arrSeat.size(); i++) {
            if (arrSeat.get(i).seatID == searchSeat  && arrFlight.get(bookFlightIndex).getFlightID().equals(arrSeat.get(i).getFlight().getFlightID())) {
                successFind++;
                if (arrSeat.get(i).getStatusSeat().equalsIgnoreCase("Empty")) {
                    valid = true;
                    arrSeat.get(i).setStatusSeat("Selected");
                }
                else if(arrSeat.get(i).getStatusSeat().equalsIgnoreCase("Booked")){
                    System.out.println("                This seat has been booked.");
                }
                else if(arrSeat.get(i).getStatusSeat().equalsIgnoreCase("Selected")){
                    System.out.println("                This seat has been selected.");
                }
                else{
                    System.out.println("                Please enter the correct seat number.");
                }
            }
        }
        if (successFind ==0) {
            System.out.println("                Seat ID does not exist.Please enter a valid Seat ID !!!");      //if seat id does not exist
            return valid;
        } else {
            return valid;
        }
    }
    //return all the selected but not be book seat turn back to empty status
    public static void returnEmpty(ArrayList<Seat> arrSeat){
        for(int i=0;i<arrSeat.size();i++){
            if(arrSeat.get(i).getStatusSeat().equalsIgnoreCase("Selected")){
                arrSeat.get(i).setStatusSeat("Empty");
            }
        }
    }
    
}
