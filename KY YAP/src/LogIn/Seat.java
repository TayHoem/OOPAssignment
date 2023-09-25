/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogIn;

/**
 *
 * @author KY YAP
 */
import java.util.ArrayList;
import java.util.Objects;

public class Seat {

    private int seatID;
    private String typeOfSeat;
    private String statusSeat;
    private Flight flight;

    public Seat(int seatID, String typeOfSeat, String statusSeat, Flight flight) {
        this.seatID = seatID;
        this.typeOfSeat = typeOfSeat;
        this.statusSeat = statusSeat;
        this.flight = flight;

    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public void setStatusSeat(String statusSeat) {
        this.statusSeat = statusSeat;
    }

    public boolean findSeatEmpty(ArrayList<Seat> arrSeat, int id, Flight flight) {
        Seat fSeat = new Seat(0, "economics", "Empty", flight);
        fSeat.setSeatID(id);
        for (int i = 0; i < arrSeat.size(); i++) {
            if (arrSeat.get(i).equals(fSeat)) {
                return true;
            }
        }
        return false;
    }

    //added by KYYAP
    public static String searchSeat(int seat){ 
        switch(seat){
            case 1:
                return "Economy Seat";
            case 2:
                return "Business Seat";
            default:
                return "Unknown";
        }
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
        if (!Objects.equals(this.statusSeat, other.statusSeat)) {
            return false;
        }
        return Objects.equals(this.flight, other.flight);
    }

}
