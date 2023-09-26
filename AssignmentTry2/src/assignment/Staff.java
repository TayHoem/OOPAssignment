/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment; 

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nicho
 */
public class Staff extends Person {

    private String staffId;
    private String position;
    private int stfPass;

    public Staff(String name, String phoneNo, String gender, String email, String icNo) {
        super(name, phoneNo, gender, email, icNo);
    }

    public Staff(String staffId, String position, int stfpass, String name, String phoneNo, String gender, String email, String icNo) {
        super(name, phoneNo, gender, email, icNo);
        this.staffId = staffId;
        this.position = position;
        this.stfPass = stfpass;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getPosition() {
        return position;
    }

    public int getStfpass() {
        return stfPass;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStfpass(int stfpass) {
        this.stfPass = stfpass;
    }

    public boolean login(String staffID, int staffPassword) {
        if (staffID.equals(this.staffId) && staffPassword == this.stfPass) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "               Staff ID: " + staffId
                + "\n               Staff Position: " + position
                + "\n               Staff name: " + super.getName()
                + "\n               Phone No: " + super.getPhoneNumber()
                + "\n               Gender: " + super.getGender()
                + "\n               Email: " + super.getEmail()
                + "\n               Ic No: " + super.getIcNo();
    }
    
    
    public static void defineStaff(Staff[] staffArray, ArrayList<Flight> flights,ArrayList<Seat> arrSeat){
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int staffCount = 0, selection = 0;
        String notStaff = null;
        Plane plane = new Plane();
        //int toMenu = 0;
        
        //do {
            do {
                System.out.println("                    ===================");
                System.out.println("                    |   STAFF LOG IN  |");
                System.out.println("                    ===================");
                System.out.print("                  Enter Staff ID: ");
                String stfID = scanner.nextLine();

                try {
                    System.out.print("                  Enter Password (5-digit): ");
                    int stfpassword = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < staffArray.length; i++) {
                        if (staffArray[i].login(stfID, stfpassword)) {
                            staffCount = i;
                            notStaff = stfID;
                            break;
                        }
                    }

                    if (notStaff == null) {
                        System.out.println("            ![Invalid please Log in agian]!\n");
                    } else {
                        System.out.println("\n              ===================================");
                        System.out.println("              |           STAFF DETAILS          |");
                        System.out.println("              ===================================");
                        System.out.println(staffArray[staffCount].toString());
                        System.out.println("              ===================================\n");
                    }
                } catch (Exception e) {
                    System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                    notStaff = null;
                }
            } while (notStaff == null);

            do {
                System.out.println("                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("                |         |STAFF MENU|        |");
                System.out.println("                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("                |1. Add Flight                |");
                System.out.println("                |2. Delete Flight             |");
                System.out.println("                |3. Modify Flight Time        |");
                System.out.println("                |4. View All Flight           |");
                System.out.println("                |0. To Exit                   |");
                System.out.println("                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                try {
                    System.out.print("                Enter your option: ");
                    selection = sc.nextInt();
                    int count = 0;
                    char modify, addF, dltMore;

                    if (selection == 1) {
                        count = 10;
                        do {
                            count++;
                            Flight.addFlight(flights,arrSeat, count);
                            System.out.print("              Need to Add Flight? (Y/N): ");
                            addF = sc.next().charAt(0);
                        } while (addF == 'Y' || addF == 'y');
                        selection = -1;
                    } else if (selection == 2) {
                        do {
                            Flight.dltFlight(flights);
                            System.out.print("Do you want to delete another Flight?(Y=yes, N=no): ");
                            dltMore = sc.next().charAt(0);
                            sc.nextLine();
                        } while (dltMore == 'y' || dltMore == 'Y');

                        selection = -1;
                    } else if (selection == 3) {
                        do {
                            Flight.modifyFlight(flights);
                            System.out.print("Do you want to modify another Flight?(Y/y=yes, N/n=no): ");
                            modify = sc.next().charAt(0);
                        } while (modify == 'Y' || modify == 'y');
                        selection = -1;
                    } else if (selection == 4) {
                        Flight.viewFlight(flights);
                        selection = -1;
                    } else if (selection == 0) {
                        selection = 0;
                        //toMenu = 1;
                    } else {
                        System.out.println("            Please enter the integer given (1-5)...");
                        selection = -1;
                    }
                } catch (Exception e) {
                    System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                    selection = -1;
                }

            } while (selection == -1);
        //} while (toMenu == 1);

    }
}