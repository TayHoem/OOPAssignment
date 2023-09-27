/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author ANG
 */
public class Passenger extends Person{
    private String passportNo;

    public Passenger() {
        super("","","",""); 
        passportNo = null;
    }
    
    

    public Passenger(String passportNo, String name, String email, String phoneNumber, String gender) {
        super(name, email, phoneNumber, gender);
        this.passportNo = passportNo;
    }
    
    public Passenger(String passportNo){
        super("","","","");
        this.passportNo = passportNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public boolean ValidPassportNo(String passportNo) {
        // Basic validation: Check if the name contains only letters and spaces
        if (passportNo.matches("[A-Z]\\d{8}")) {
            this.passportNo = passportNo;
            return true;
        } else {
            System.out.println("                Invalid Passport Number. Please enter a valid passport number.");
            System.out.printf("\n");
        }
        return false;
    }
    
    
    
    
}