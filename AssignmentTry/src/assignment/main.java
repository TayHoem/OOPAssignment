/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Acer
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String args[]){
        int staffCount = 0, selection = 0;
        String notStaff = null;
        int toMenu = 0;
        int chooseUser;
        Scanner sc = new Scanner(System.in);
        Staff[] staffArray = new Staff[10]; // You can adjust the size as needed
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<Customer> cust = new ArrayList();
        Plane plane = new Plane();
        

        flights.add(new Flight("F001", "Malaysia", "Japan", 1200, 1300, 2000, "11/11/2023", "12/11/2023", 200.00, 400.00, new Plane("PL04", 32)));
        flights.add(new Flight("F002", "Malaysia", "Japan", 1300, 1400, 1800, "11/11/2023", "14/11/2023", 300.00, 600.00, new Plane("PL05", 32)));
        flights.add(new Flight("F003", "Malaysia", "Japan", 1400, 1500, 1900, "11/11/2023", "13/11/2023", 400.00, 700.00, new Plane("PL03", 36)));
        flights.add(new Flight("F004", "England", "Australia", 1200, 1300, 2100, "14/11/2023", "15/11/2023", 500.00, 800.00, new Plane("PL09", 32)));
        flights.add(new Flight("F005", "Australia", "China", 1300, 1600, 2300, "15/11/2023", "16/11/2023", 600.00, 900.00, new Plane("PL02", 32)));
        flights.add(new Flight("F006", "Japan", "Australia", 1400, 1500, 1900, "16/12/2023", "17/12/2023", 700.00, 1000.00, new Plane("PL01", 36)));
        flights.add(new Flight("F007", "England", "China", 1200, 1400, 2000, "17/12/2023", "18/12/2023", 100.00, 400.00, new Plane("PL05", 32)));
        flights.add(new Flight("F008", "Japan", "Australia", 1300, 1400, 2200, "10/12/2023", "11/12/2023", 300.00, 600.00, new Plane("PL11", 36)));
        flights.add(new Flight("F009", "Australia", "Japan", 1200, 1500, 2100, "13/12/2023", "14/12/2023", 200.00, 500.00, new Plane("PL01", 36)));
        flights.add(new Flight("F010", "Malaysia", "Malaysia", 1100, 1200, 2100, "20/12/2023", "21/12/2023", 100.00, 400.00, new Plane("PL07", 32)));

        // Populate the array with staff members
        staffArray[0] = new Staff("S001", "Manager", 11111, "Apple Doe", "015-5555555", "MALE", "john@example.com", "030402-07-1526");
        staffArray[1] = new Staff("S002", "Airline Controller", 22222, "Bun Smith", "012-345678", "FEMALE", "jane@example.com", "040222-08-0437");
        staffArray[2] = new Staff("S003", "Airline Controller", 33333, "Coocies Johnson", "014-567890", "MALE", "bob@example.com", "02222-18-1234");
        staffArray[3] = new Staff("S004", "Airline Controller", 44444, "Duck Brown", "019-7899908", "FEMALE", "alice@example.com", "191203-18-8768");
        staffArray[4] = new Staff("S005", "Airline Controller", 55555, "Egg Lee", "013-2727589", "MALE", "eva@example.com", "170807-14-9087");
        staffArray[5] = new Staff("S006", "Airline Controller", 66666, "Fruit Chan", "019-9999999", "FEMALE", "owom@example.com", "020405-09-8967");
        staffArray[6] = new Staff("S007", "Airline Controller", 77777, "Grass wong", "018-7976902", "MALE", "pema@example.com", "010917-08-7869");
        staffArray[7] = new Staff("S008", "Airline Controller", 88888, "Ham chan", "017-7787960", "FEMALE", "sosy@example.com", "010416-11-1996");
        staffArray[8] = new Staff("S009", "Airline Controller", 99999, "Ice loo", "0197891111", "MALE", "kokonut@example.com", "111111-01-1111");
        staffArray[9] = new Staff("S000", "Airline Controller", 00000, "Juice hee", "014-4444444", "FEMALE", "polipo@example.com", "040404-08-0918");

        
        Customer cust1 = new Customer("040225-14-1143", "12345678", "KY YAP", "kyyap@gmail.com", "011-0818007", "Male");
        Customer cust2 = new Customer("981024-13-1985", "24681012", "Mei Ling", "123@gmail.com", "012-3456789", "Female");
        Customer cust3 = new Customer("030908-10-1983", "13579138", "Kim Ho", "secret@gmail.com", "018-2432320", "Male");
        Customer cust4 = new Customer("030908-08-1072", "13145209", "CKS", "chuchu@gmail.com", "018-9557368", "Female");

        cust.add(cust1);
        cust.add(cust2);
        cust.add(cust3);
        cust.add(cust4);
        
        do{
            System.out.println("===========================");
            System.out.println("|       1. Staff          |");
            System.out.println("|       2. Customer       |");
            System.out.println("|       3. Exit           |");
            System.out.println("===========================");

            try{
            System.out.print("Enter (1 or 2 ):");
            chooseUser = sc.nextInt();
            }catch (Exception e) {
                    System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                    chooseUser = 0;
            }
            
            switch(chooseUser){
            case 1 :
                Staff.defineStaff(staffArray,flights);
                chooseUser = 0;
                break;
            case 2:
                Customer.customerAction(cust, flights);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Please enter 1, 2, and 3 only");
                break;
        }
        }while(chooseUser < 1 || chooseUser > 2);
    }
    

}

