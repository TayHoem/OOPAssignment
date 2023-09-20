/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Acer
 */
import java.time.LocalDate;

public class Payment {
    private int paymentID;
    private double amount;
    private final LocalDate paymentDate = LocalDate.now();
    private boolean paymentStatus;
    private String bankName;
    private String cardNo;
    private int cvNo;
    private static int nextPaymentID = 1001;

    public Payment(double amount) {
        this.paymentID = nextPaymentID;
        this.amount = amount;
        this.cardNo = "";
        this.cvNo = 0;
        this.bankName = "";
        this.paymentStatus = false;
    }

    public int getPaymentID() {
        nextPaymentID++;
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public boolean getPaymentSatus() {
        return paymentStatus;
    }

    public String getCardNo() {
        return cardNo;
    }

    public int getCvNo() {
        return cvNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentSatus(boolean paymentSatus) {
        this.paymentStatus = paymentSatus;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setCvNo(int cvNo) {
        this.cvNo = cvNo;
    }

    public void setBankName(String bankName) {    
        this.bankName = bankName;
    }
    
    
    public static void choosePay(){
        System.out.println("\t==========================");
        System.out.println("\t||         Bank          ||");
        System.out.println("\t==========================");
        System.out.println("\t||  1. Public Bank       ||");
        System.out.println("\t||  2. MayBank           ||");
        System.out.println("\t||  3. Hong Leong Bank   ||");
        System.out.println("\t==========================");
    }

    @Override
    public String toString() {
        if(paymentStatus == true)
            return String.format("\nPayment Success!!!\n\nPayment ID = %-10d\nBank: %s\nTotal Amount: RM %.2f\nCard Number: %s\nCV number: %d",paymentID,bankName,amount,cardNo,cvNo);
        else
          return "Payment Failed !!! Please try again";
        
    }
    
    
    
}
