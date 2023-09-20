/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogIn;

import java.util.Objects;

/**
 *
 * @author KY YAP
 */
public class Customer extends Person {

    private String custIcNo;
    private String custPassword;

    public Customer(String name, String email, String phoneNumber, String gender) {
        super(name, email, phoneNumber, gender);
    }

    public Customer(String custIcNo, String custPassword, String name, String email, String phone, String gender) {
        super(name, email, phone, gender);
        this.custIcNo = custIcNo;
        this.custPassword = custPassword;
    }

    public String getCustIcNo() {
        return custIcNo;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public boolean login(String logInIC, String logInPassword) {
        if (logInIC.equals(custIcNo) && logInPassword.equals(custPassword)) {
            System.out.println("-->Log In Successful<--");
            return true;
        }
        return false;
    }

    public boolean getValidPassword(String password) {
        // Basic validation: Check if the password has a minimum length
        if (password.length() >= 8 && password.length() <= 8) {
            this.custPassword = password;
            return true;
        } else {
            System.out.println("Password must be only 8 characters.");
            System.out.printf("\n");
        }
        return false;
    }

    public boolean getValidICNumber(String icNumber) {
        // Basic validation: Check if the I/C number has the expected format
        if (icNumber.matches("\\d{6}-\\d{2}-\\d{4}")) {
            this.custIcNo = icNumber;
            return true;
        } else {
            System.out.println("Invalid I/C number format. Please use the format XXXXXX-XX-XXXX.");
            System.out.printf("\n");
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.custIcNo, other.custIcNo)) {
            return false;
        }
        return Objects.equals(this.custPassword, other.custPassword);
    }

    @Override
    public String toString() {
        return super.toString() + "Customer{" + "custIcNo=" + custIcNo + ", custPassword=" + custPassword + '}';
    }

}
