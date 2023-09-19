/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author nicho
 */
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

    
    
    public Flight(String flightID, String arrCountry, String dpCOuntry, int bdTime, int dpTime, int estimateArrivalTime, String dpDate,String arrivalDate, double ecoPrice, double bsPrice, Plane plane) {
        this.flightID = flightID;
        this.arrCountry = arrCountry;
        this.dpCOuntry = dpCOuntry;
        this.bdTime = bdTime;
        this.dpTime = dpTime;       
        this.estimateArrivalTime = estimateArrivalTime;
        this.dpDate = dpDate;
        this.arrivalDate=arrivalDate;
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
        String countryName="";
        
        if (country == 1) {
            countryName="Japan";
        } else if (country == 2) {
            countryName= "Malaysia";
        } else if (country == 3) {
            countryName= "England";
        } else if (country == 4) {
            countryName= "China";
        } else if (country == 5){
            countryName= "Australia";}
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
                +"\nArrival Date: " + arrivalDate
                + "\nEconomy Price: RM " + ecoPrice
                + "\nBusiness Price: RM " + bsPrice
                +plane
                ;
    }
        public boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

}
