/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author nicho
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Flight {

    private String flightID;
    private int bdTime;
    private int dpTime;
    private int estimateArrivalTime;
    private String dpDate;
    private double ecoPrice;
    private double bsPrice;
    private String arrCountry;
    private String dpCOuntry;
    private Plane plane;
    private String arrivalDate;

    public Flight() {
    }

    public Flight(String flightID, String arrCountry, String dpCOuntry, int bdTime, int dpTime, int estimateArrivalTime, String dpDate, String arrivalDate, double ecoPrice, double bsPrice, Plane plane) {
        this.flightID = flightID;
        this.arrCountry = arrCountry;
        this.dpCOuntry = dpCOuntry;
        this.bdTime = bdTime;
        this.dpTime = dpTime;
        this.estimateArrivalTime = estimateArrivalTime;
        this.dpDate = dpDate;
        this.arrivalDate = arrivalDate;
        this.ecoPrice = ecoPrice;
        this.bsPrice = bsPrice;
        this.plane = plane;

    }

    public String getFlightID() {
        return flightID;
    }

    public int getBdTime() {
        return bdTime;
    }

    public int getDpTime() {
        return dpTime;
    }

    public int getEstimateArrivalTime() {
        return estimateArrivalTime;
    }

    public String getDpDate() {
        return dpDate;
    }

    public double getEcoPrice() {
        return ecoPrice;
    }

    public double getBsPrice() {
        return bsPrice;
    }

    public String getArrCountry() {
        return arrCountry;
    }

    public String getDpCOuntry() {
        return dpCOuntry;
    }

    public Plane getPlane() {
        return plane;
    }

    public int getNumOfSeat() {
        return plane.getNumOfSeat();
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public void setBdTime(int bdTime) {
        this.bdTime = bdTime;
    }

    public void setDpTime(int dpTime) {
        this.dpTime = dpTime;
    }

    public void setEstimateArrivalTime(int estimateArrivalTime) {
        this.estimateArrivalTime = estimateArrivalTime;
    }

    public void setDpDate(String dpDate) {
        this.dpDate = dpDate;
    }

    public void setEcoPrice(double ecoPrice) {
        this.ecoPrice = ecoPrice;
    }

    public void setBsPrice(double bsPrice) {
        this.bsPrice = bsPrice;
    }

    public void setArrCountry(String arrCountry) {
        this.arrCountry = arrCountry;
    }

    public void setDpCOuntry(String dpCOuntry) {
        this.dpCOuntry = dpCOuntry;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public static String country(int country) {
        String countryName = "";

        if (country == 1) {
            countryName = "Japan";
        } else if (country == 2) {
            countryName = "Malaysia";
        } else if (country == 3) {
            countryName = "England";
        } else if (country == 4) {
            countryName = "China";
        } else if (country == 5) {
            countryName = "Australia";
        }
        return countryName;
    }

    @Override
    public String toString() {
        return "\nFlight ID: " + flightID
                + "\nDeparture COuntry: " + dpCOuntry
                + "\nArrival Country: " + arrCountry
                + "\nBoarding Time: " + bdTime
                + "\nDeparture Time: " + dpTime
                + "\nEstimate Arrival Time: " + estimateArrivalTime
                + "\nDeparture Date: " + dpDate
                + "\nArrival Date: " + arrivalDate
                + "\nEconomy Price: RM " + ecoPrice
                + "\nBusiness Price: RM " + bsPrice
                + plane;
    }

    public boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static int displayFlight(ArrayList<Flight> arrFlight, ArrayList<Seat> arrSeat) {
        Scanner input = new Scanner(System.in);
        int numSeat;
        int indexOfFlight = -1;
        String searchID;
        do{
        System.out.print("              Enter the Flight ID : ");
         searchID = input.nextLine();
        }while(!Flight.validFlightID(arrFlight, searchID));
        
        System.out.println("");
        System.out.println("                   o = Economy Seat    x = Booked Seat  * = Business Seat");
        System.out.println("            ==============================================================");
        for (int i = 0; i < arrFlight.size(); i++) {
            if (arrFlight.get(i).flightID.equals(searchID)) {
                numSeat = arrFlight.get(i).plane.getNumOfSeat();
                displaySeat(arrSeat, numSeat, arrFlight.get(i));
                indexOfFlight = i;

            }
        }
        System.out.println("            ==============================================================");
        return indexOfFlight;
    }

    public static void displaySeat(ArrayList<Seat> arrSeat, int NumberSeat, Flight tFlight) {

        System.out.printf("                  0    1  \t  2    3\n");
        System.out.println("                -------------------------");
        for (int i = 1; i <= (NumberSeat / 4); i++) {
            System.out.printf("             %d|   ", i);
            for (int j = 0; j < 4; j++) {
                
                if (arrSeat.get(i).findSeatEmpty(arrSeat, (i * 10 + j), tFlight)) {
                    if(i == 1){
                        System.out.print("*    ");
                        
                    }
                    else{
                    System.out.print("o    ");
                        
                    }
                } 
                else {
                    System.out.print("x    ");
                    
                }
                if (j == 1) {
                    System.out.printf("\t  ");
                }

            }
            System.out.println("");
        }
    }
    
    public static boolean validFlightID(ArrayList<Flight> arrFlight,String searchID){
        boolean valid = false;
        for(int i=0;i<arrFlight.size();i++){
            if(arrFlight.get(i).getFlightID().equalsIgnoreCase(searchID)){
                valid = true;
            }
        }
        if (!valid){
            System.out.println("                Flight ID does not exist.Please enter again!!!");
        }
        return valid;
    }
    
         public void defineSeat(ArrayList<Seat> arrSeat,Flight dFlight){
         //i=1 type = business
         for(int i=1;i<=(dFlight.getNumOfSeat()/4);i++){
             for(int j=0;j<4;j++){
                 if(i==1){
                     arrSeat.add(new Seat((i*10+j),"business","Empty",dFlight));
                 }
                 else {
                 Seat dSeat = new Seat((i*10+j),"economy","Empty",dFlight);
                 arrSeat.add(dSeat);
             }
                
             }
         }                              
}
         

}
