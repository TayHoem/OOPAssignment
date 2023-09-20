/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author nicho
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Staff[] staffArray = new Staff[10]; // You can adjust the size as needed
        int staffCount = 0;
        String notStaff = null;

        // Populate the array with staff members
        staffArray[0] = new Staff("S001", "Manager", 11111, "Apple Doe", 1234567890, 'M', "john@example.com", 123456789);
        staffArray[1] = new Staff("S002", "Airline Controller", 22222, "Bun Smith", 987654321, 'F', "jane@example.com", 987654321);
        staffArray[2] = new Staff("S003", "Airline Controller", 33333, "Coocies Johnson", 456789012, 'M', "bob@example.com", 456789012);
        staffArray[3] = new Staff("S004", "Airline Controller", 44444, "Duck Brown", 654321789, 'F', "alice@example.com", 654321789);
        staffArray[4] = new Staff("S005", "Airline Controller", 55555, "Egg Lee", 321987654, 'M', "eva@example.com", 321987654);
        staffArray[5] = new Staff("S006", "Airline Controller", 66666, "Fruit Chan", 322345654, 'F', "owom@example.com", 819273849);
        staffArray[6] = new Staff("S007", "Airline Controller", 77777, "Grass wong", 989887654, 'M', "pema@example.com", 738291037);
        staffArray[7] = new Staff("S008", "Airline Controller", 88888, "Ham chan", 321981234, 'F', "sosy@example.com", 123098764);
        staffArray[8] = new Staff("S009", "Airline Controller", 99999, "Ice loo", 321980000, 'M', "kokonut@example.com", 716253418);
        staffArray[9] = new Staff("S000", "Airline Controller", 00000, "Juice hee", 367987689, 'F', "polipo@example.com", 847927304);

        do {
            System.out.print("Enter Staff ID: ");
            String stfID = sc.nextLine();
            System.out.print("Enter Password (5-digit): ");
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
                System.out.println("![Invalid please Log in agian]!\n");
            } else {
                System.out.println("\n" + staffArray[staffCount].toString());
            }

        } while (notStaff == null);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|1. Add Flight                |");
        System.out.println("|2. Modify Flight             |");
        System.out.println("|2. Delete Flight             |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("");
    }
}
