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

    public Passenger(String passportNo, String name, String email, String phoneNumber, String gender) {
        super(name, email, phoneNumber, gender);
        this.passportNo = passportNo;
    }
    
    public Passenger(String passportNo){
        super("","","","");
        this.passportNo = passportNo;
    }

 



    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
    
    
}
