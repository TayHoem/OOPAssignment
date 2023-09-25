/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass;

/**
 *
 * @author nicho
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.*;

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

    public Flight(Plane plane) {
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

    public static boolean isValidDateFormat(String date, String dateFormatPattern) {
        Pattern pattern = Pattern.compile(dateFormatPattern);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
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

    public static void addFlight(ArrayList<Flight> flight, int countFlight) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        char addF;
        int reinputCountry, dpCountry, arrCountry;
        int dpDateCount = 0;
        String dateFormatPattern = "\\d{2}/\\d{2}/\\d{4}";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String arrDate, dpDate;

        int i = 0;

        String fgID = "F0" + countFlight;

        System.out.println("\n              ===================================");
        System.out.println("              |             ADD FLIGHT          |");
        System.out.println("              ===================================");
        System.out.println("\n                  Choose Country: "
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
            } else if (arrCountry == dpCountry) {
                System.out.println("![Connot travel to the same Country]!");
                reinputCountry = 1;
            }
        } while (reinputCountry == 1);
        int bdWord = 0, bdTime = 0;
        do {
            try {
                System.out.print("              Boarding Time(0100-2300): ");
                bdTime = sc.nextInt();
                if (bdTime < 100 || bdTime > 2300) {
                    System.out.println("Invalid time format. Please enter a time between 0100 and 2300.\n");
                    bdWord = 1;
                } else {
                    bdWord = 0;
                }
            } catch (Exception e) {
                System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                bdWord = 1;
            }
        } while (bdWord == 1);

        int dpTime = 0, dpWord = 0;
        do {
            try {
                System.out.print("              Departure Time(0100-2300): ");
                dpTime = sc.nextInt();
                if (dpTime <= bdTime) {
                    System.out.println("      [Depature Time must be different/earliear than Boarding Time...]\n              [Please re-enter]\n");
                    dpWord = 1;
                } else if (dpTime < 100 || dpTime > 2300) {
                    System.out.println("Invalid time format. Please enter a time between 0100 and 2300.\n");
                    dpWord = 1;
                } else {
                    dpWord = 0;
                }
            } catch (Exception e) {
                System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                dpWord = 1;
            }

        } while (dpWord == 1);

        int esArrTime = 0, esWord = 0;
        do {
            try {
                System.out.print("              Estimate Arrival Time(0100-2300): ");
                esArrTime = sc.nextInt();
                if (esArrTime <= dpTime) {
                    System.out.println("      [Estimation Arrival Time must be different/earli than Depature Time...]\n              [Please re-enter]\n");
                    esWord = 1;
                } else if (esArrTime < 100 || esArrTime > 2300) {
                    System.out.println("Invalid time format. Please enter a time between 0100 and 2300.\n");
                    esWord = 1;
                } else {
                    esWord = 0;
                }
            } catch (Exception e) {
                System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                esWord = 1;
            }
        } while (esWord == 1);

        Date dpD = new Date(), currentDate = new Date(), dpA = new Date();
        do {
            System.out.print("              Departure Date(dd/MM/yyyy): ");
            dpDate = scanner.nextLine();
            try {
                dpD = dateFormat.parse(dpDate);
                currentDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                if (!isValidDateFormat(dpDate, dateFormatPattern) || !isValidDate(dpDate) || dpD.before(currentDate)) {
                    System.out.println("[Invalid date/date format. Please enter the date in dd/MM/yyyy format]");
                } else {
                    System.out.print("");
                }
            } catch (ParseException e) {
                System.out.println("[Invalid date/date format. Please enter the date in dd/MM/yyyy format]");

            }
        } while (!isValidDateFormat(dpDate, dateFormatPattern) || !isValidDate(dpDate) || dpD.before(currentDate));

        do {
            System.out.print("              Arrival Date (dd/MM/yyyy): ");
            arrDate = scanner.nextLine();
            try {
                dpA = dateFormat.parse(arrDate);
                currentDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);

                if (!isValidDateFormat(arrDate, dateFormatPattern) || !isValidDate(arrDate) || dpA.before(currentDate)) {
                    System.out.println("[Invalid date format. Please enter the date in dd/MM/yyyy format]");
                } else {
                    System.out.print("");
                }
            } catch (ParseException e) {
                System.out.println("[Invalid date/date format. Please enter the date in dd/MM/yyyy format]");
            }
        } while (!isValidDateFormat(arrDate, dateFormatPattern) || !isValidDate(arrDate) || dpA.before(currentDate));

        double ecoP = 0, ecoWord = 0;
        do {
            try {
                System.out.print("              Economic Price: RM");
                ecoP = sc.nextDouble();
                ecoWord = 0;
            } catch (Exception e) {
                System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                ecoWord = 1;
            }
        } while (ecoWord == 1);

        double busP = 0, busWord = 0;
        do {
            try {
                System.out.print("              Business Price: RM");
                busP = sc.nextDouble();
                if (busP <= ecoP) {
                    System.out.println("![Business price must expensive then Economic Price]!");
                    busWord = 1;
                } else {
                    busWord = 0;
                }
            } catch (Exception e) {
                System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                busWord = 1;
            }

        } while (busWord == 1);

        System.out.print("              Plane No: ");
        String planeNo = scanner.nextLine();

        System.out.print("              Number of Seat: ");
        int numOfSeat = sc.nextInt();

        Plane plane = new Plane(planeNo, numOfSeat);
        i++;

        Flight flights = new Flight(fgID, Flight.country(dpCountry), Flight.country(arrCountry), bdTime, dpTime, esArrTime, dpDate, arrDate, ecoP, busP, plane);
        System.out.print("Confirm to update this Flight?(Y=yes, N=no): ");

        char confirmUpdate = sc.next().charAt(0);
        if (confirmUpdate == 'Y' || confirmUpdate == 'y') {
            flight.add(flights);
            System.out.println("                [Flight Updated...]");
        }
    }

    public static void viewFlight(ArrayList<Flight> flight) {
        System.out.println("\n=============== View All The Flight ===============\n\n");
        for (Flight fg : flight) {
            System.out.println(fg);
        }
        System.out.println("================= End View Flight =================");
    }

    public static void dltFlight(ArrayList<Flight> flight) {
        Scanner sc = new Scanner(System.in);
        int count = 0, found = 0;
        char dltMore;
        System.out.print("              Enter the Flight ID : ");
        String searchID = sc.nextLine();
        System.out.println("\n              =============== Flight =============\n");

        for (int i = 0; i < flight.size(); i++) {
            if (flight.get(i).flightID.equals(searchID)) {
                System.out.println(flight.get(i));
                System.out.println("              ====================================");
                if (flight.get(i) != null) {
                    found = 1;
                    count = i;
                } else {
                    found = 0;
                }

            }
        }

        if (found != 1) {
            System.out.println("                    Can't find " + searchID);
            System.out.println("\n              ====================================");
            found = 0;
        } else {
            System.out.print("          Confirm delete?(Y=yes, N=no): ");
            char confirmDlt = sc.next().charAt(0);
            if (confirmDlt == 'Y' || confirmDlt == 'y') {
                flight.remove(count);
                System.out.println("            ![Flight have been deleted]!");
            } else {
                System.out.println("            ![No Flight have been deleted]!");
            }
        }

    }

    public static void modifyFlight(ArrayList<Flight> flight) {
        Scanner sc = new Scanner(System.in);
        char again;

        System.out.print("              Enter the Flight ID : ");

        String searchID = sc.nextLine();
        System.out.println("\n              =============== Flight =============\n");

        int count = 0, noCount = 0;

        for (int i = 0; i < flight.size(); i++) {
            if (flight.get(i).flightID.equals(searchID)) {
                System.out.println(flight.get(i));
                System.out.println("              ====================================");
                count = i;
            } else {
                noCount++;
            }
        }
        int modi = 0, modiWord = 0;

        if (noCount != flight.size()) {
            System.out.println("                What you want to modify:");
            System.out.println("                1. Boarding Time");
            System.out.println("                2. Departure Time");
            System.out.println("                3. Estimate Arrival Time\n");
            do {
                try {
                    System.out.print("              Select modify Time: ");
                    modi = sc.nextInt();
                    modiWord = 0;
                } catch (Exception e) {
                    System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                    modiWord = 1;
                }
            } while (modiWord == 1);

            int bTime = 0, bWord = 0, dTime = 0, dWord = 0, eaTime = 0, eaWord = 0;
            if (modi == 1) {
                System.out.println();
                System.out.println("              => Current Boarding Time(0100-2300): " + flight.get(count).bdTime);
                do {
                    try {
                        System.out.print("                 Enter New Boarding Time(0100-2300): ");
                        bTime = sc.nextInt();
                        bWord = 0;
                        if (bTime >= flight.get(count).dpTime) {
                            System.out.println("Boarding Time Cannot Be After/Same With Departure Time\n");
                            bWord = 1;
                        } else if (bTime < 100 || bTime > 2300) {
                            System.out.println("Invalid time format. Please enter a time between 0100 and 2300.\n");
                            bWord = 1;
                        } else {
                            bWord = 0;
                        }
                    } catch (Exception e) {
                        System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                        sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                        bWord = 1;
                    }
                } while (bWord == 1);
                flight.get(count).setBdTime(bTime);
                System.out.println("");
                System.out.println("\n              ========== Modified Flight ========\n");
                System.out.println(flight.get(count));
                System.out.println("              ====================================");
                System.out.println("           [Flight Boarding Time have been modify...]");

            } else if (modi == 2) {

                System.out.println();
                System.out.println("              => Current Departure Time(0100-2300): " + flight.get(count).dpTime);
                do {
                    try {
                        System.out.print("                 Enter New Departure Time(0100-2300): ");
                        dTime = sc.nextInt();
                        dWord = 0;
                        if (dTime >= flight.get(count).estimateArrivalTime) {
                            System.out.println("Boarding Time Cannot Be After/Same With Estiated Arrival Time\n");
                            dWord = 1;
                        } else if (dTime <= flight.get(count).bdTime) {
                            System.out.println("Boarding Time Cannot Be Before/Same With Boarding\n");
                            dWord = 1;
                        } else if (dTime < 100 || dTime > 2300) {
                            System.out.println("Invalid time format. Please enter a time between 0100 and 2300.\n");
                            dWord = 1;
                        } else {
                            dWord = 0;
                        }
                    } catch (Exception e) {
                        System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                        sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                        dWord = 1;
                    }
                } while (dWord == 1);
                flight.get(count).setDpTime(dTime);
                System.out.println("");
                System.out.println("\n              ========== Modified Flight ========\n");
                System.out.println(flight.get(count));
                System.out.println("              ====================================");
                System.out.println("           [Flight Departure Time have been modify...]");
            } else if (modi == 3) {
                System.out.println();
                System.out.println("              => Current Estimate Arrival Time(0100-2300): " + flight.get(count).estimateArrivalTime);
                do {
                    try {
                        System.out.print("                 Enter New Estimate Arrival Time(0100-2300): ");
                        eaTime = sc.nextInt();
                        eaWord = 0;
                        if (eaTime <= flight.get(count).dpTime) {
                            System.out.println("Boarding Time Cannot Be Before Departure/Boarding Time...\n");
                            eaWord = 1;
                        } else if (eaTime < 100 || eaTime > 2300) {
                            System.out.println("Invalid time format. Please enter a time between 0100 and 2300.\n");
                            eaWord = 1;
                        } else {
                            eaWord = 0;
                        }
                    } catch (Exception e) {
                        System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                        sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                        eaWord = 1;
                    }
                } while (eaWord == 1);
                flight.get(count).setEstimateArrivalTime(eaTime);
                System.out.println("");
                System.out.println("\n              ========== Modified Flight ========\n");
                System.out.println(flight.get(count));
                System.out.println("              ====================================");
                System.out.println("           [Flight Estimate Arrival Time have been modify...]");
            }
        } else {
            System.out.println("                Can't Find Flight " + searchID);
            System.out.println("\n              ====================================");
        }

    }

    @Override

    public String toString() {
        return "           ^^==================================^^"
                + "\n           ||               " + flightID + "               ||"
                + "\n           ^^==================================^^"
                + "\n               Flight ID: " + flightID
                + "\n               Departure Country: " + dpCOuntry
                + "\n               Arrival Country: " + arrCountry
                + "\n               Boarding Time: " + bdTime
                + "\n               Departure Time: " + dpTime
                + "\n               Estimate Arrival Time: " + estimateArrivalTime
                + "\n               Departure Date: " + dpDate
                + "\n               Arrival Date: " + arrivalDate
                + "\n               Economy Price: RM " + ecoPrice
                + "\n               Business Price: RM " + bsPrice
                + plane;
    }

}
