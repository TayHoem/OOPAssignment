/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass;

/**
 *
 * @author nicho
 */
public class Person {
    private String name;
    private String phoneNo;
    private char gender;
    private String email;
    private String icNo;

    public Person(String name, String phoneNo, char gender, String email, String icNo) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.email = email;
        this.icNo = icNo;
    }

    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getIcNo() {
        return icNo;
    }
    
    public String toString(){
        return "Name: "+name+"\nPhone No: "+phoneNo+"\nGender"+gender+"\nEmail"+email+"Ic No"+icNo;
    }
    
}
