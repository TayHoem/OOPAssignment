/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass;

/**
 *
 * @author nicho
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Flight {

    public static int counterFlight, pCount;
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

    public String getArrivalDate() {
        return arrivalDate;
    }

    public static int getCounterFlight() {
        return counterFlight;
    }

    public static void setCounterFlight(int counterFlight) {
        Flight.counterFlight = counterFlight;
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
        } else {
            System.out.printf("Unknown Selection %d...Input (1-5) only\n\n", country);
            return "Unknown";
        }
        return countryName;
    }

    public static void addFlight(ArrayList<Flight> flight) {
//        ArrayList<Flight> flight = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        char addF;
        int reinputCountry, dpCountry, arrCountry;
        int countFlight = 10;

        do {
            int i = 0;
//            System.out.print("Flight ID: ");
            String fgID = "F0" + ++countFlight;

            System.out.println("\n                  Choose Country "
                    + "\n                   1.Japan"
                    + "\n                   2.Malaysia"
                    + "\n                   3.England"
                    + "\n                   4.China"
                    + "\n                   5.Australia");   //Input country 

            do {
                reinputCountry = 0;
                System.out.print("              Departure Country: ");
                dpCountry = sc.nextInt();
                Flight.country(dpCountry);

                System.out.print("              Arrival Country: ");
                arrCountry = sc.nextInt();
                Flight.country(arrCountry);
                sc.nextLine();

                if (dpCountry < 1 || arrCountry < 1 || dpCountry > 5 || arrCountry > 5) {
                    reinputCountry = 1;
                }
            } while (reinputCountry == 1);

            System.out.print("              Boarding Time(0100-2300): ");
            int bdTime = sc.nextInt();

            System.out.print("              Departure Time(0100-2300): ");
            int dpTime = sc.nextInt();

            System.out.print("              Estimate Arrival Time(0100-2300): ");
            int EsArrTime = sc.nextInt();

            System.out.print("              Departure Date(dd/MM/yyyy): ");
            String dpDate = sc.nextLine();
            sc.nextLine();

            System.out.print("              Arrival Date(dd/MM/yyyy): ");
            String arrDate = sc.nextLine();

            System.out.print("              Economic Price: RM");
            double ecoP = sc.nextDouble();

            System.out.print("              Business Price: RM");
            double busP = sc.nextDouble();

            System.out.print("              Plane No: ");
            String planeNo = sc.nextLine();
            sc.nextLine();

            System.out.print("              Number of Seat: ");
            int numOfSeat = sc.nextInt();

            Plane plane = new Plane(planeNo, numOfSeat);
            i++;

            Flight flights = new Flight(fgID, Flight.country(dpCountry), Flight.country(arrCountry), bdTime, dpTime, EsArrTime, dpDate, arrDate, ecoP, busP, plane);
            flight.add(flights);
            System.out.print("              Add more Flight? (Y/N): ");
            addF = sc.next().charAt(0);
        } while (addF == 'Y' || addF == 'y');

            System.out.println("                [Flight Updated...]");
//        System.out.println("\n");
//        for (Flight fli : flight) {
//            System.out.println(fli);
//        }
    }

    public static void viewFlight(ArrayList<Flight> flight) {
        for (Flight fg : flight) {
            System.out.println(fg);
        }
    }

    public static void dltFlight(ArrayList<Flight> flight) {
        Scanner sc = new Scanner(System.in);
        System.out.print("          Which  Flight ID need to delete: F0");
        int dltFg = sc.nextInt();
        dltFg--;

        System.out.print("          Confirm delete?(Y=yes, N=no): ");
        char confirmDlt = sc.next().charAt(0);
        if (confirmDlt == 'Y' || confirmDlt == 'y') {

            flight.remove(dltFg);
            System.out.println("            ![Flight have been deleted]!");
        }

    }

    @Override
    public String toString() {
        return "Flight ID: " + flightID
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
}
