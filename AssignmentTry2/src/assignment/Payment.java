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
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Payment {
    private int paymentID;  
    private double amount;
    private LocalDate paymentDate;
    private LocalTime paymentTime;
    private boolean paymentStatus;
    private String bankName;
    private String cardNo;
    private int cvNo;
    private static int nextPaymentID = 1001;
    public static int countPayment = 0;

    public Payment(double amount,String cardNo,int cvNo,String bankName,boolean paymentStatus) {
        this.paymentID = nextPaymentID;
        this.amount = amount;
        this.cardNo = cardNo;
        this.cvNo = cvNo;
        this.bankName = bankName;
        this.paymentStatus = paymentStatus;
        paymentDate = LocalDate.now();
        paymentTime = LocalTime.now();
        nextPaymentID++;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public boolean getPaymentStatus() {
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

    public void setPaymentStatus(boolean paymentSatus) {
        this.paymentStatus = paymentSatus;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setCvNo(int cvNo) {
        this.cvNo = cvNo;
    }

    public void setBankName(String bankName) {    
        this.bankName= bankName;
    }

    public static void choosePay(){
        System.out.println("\n\n\t==========================");
        System.out.println("\t||         Bank          ||");
        System.out.println("\t==========================");
        System.out.println("\t||  1. Public Bank       ||");
        System.out.println("\t||  2. MayBank           ||");
        System.out.println("\t||  3. Hong Leong Bank   ||");
        System.out.println("\t==========================");
    }

    @Override
    public String toString() {     
        if(this.paymentStatus == true){
        return  "\n=================================\n|"+ bankName +"\t\t\t|\n|      Payment Success!!!       |\n|Payment ID: "+ paymentID
               +"\t\t|\n|Date: " + paymentDate
               +"\t\t|\n|Time: " + paymentTime
               +"\t|\n|Total Amount: RM "+ amount 
               +"\t\t|\n|Card Number: "+cardNo
               +"\t|\n|CV number: "+ cvNo
               +"\t\t\t|\n=================================\n";  
        
        
        }
        else
        return "\nPayment Failed!!!\n Payment ID: "+ paymentID
               +"\nDate: " + paymentDate
               +"\nTime: " + paymentTime
               +"\nBank: "+bankName
               +"\nTotal Amount: RM "+ amount 
               +"\nCard Number: "+cardNo
               +"\nCV number: "+ cvNo;
    }
    
    public static double calcPayment(ArrayList<Ticket> tempTckt){
        double total =0;
        for(int i=0;i<tempTckt.size();i++){
            if(tempTckt.get(i).getSeat().getTypeOfSeat().equalsIgnoreCase("business")){
                total += tempTckt.get(i).getSeat().getFlight().getBsPrice();
            }
            else if(tempTckt.get(i).getSeat().getTypeOfSeat().equalsIgnoreCase("economy")){
                total += tempTckt.get(i).getSeat().getFlight().getEcoPrice();
            }
        }
        return total;
    }
    
    public static boolean makePayment(ArrayList<Payment> payment,double amount){ 
        Scanner sc = new Scanner(System.in);
        String cardNum = null;
        char confirmPayment;
        int cvNum=0;
        int chooseBank=0;
        String tempbankName=null; 
        int length = 0;
        int errYesNoCount = 0;
        boolean valid = false;
        boolean vPayment;
        
        do{
                if(errYesNoCount > 0){
                    System.out.println("Please key in y or n only !!!");
                }
                System.out.print("\nConfirm Booking(yes=y /no=n) :");
                confirmPayment = sc.next().charAt(0);
                errYesNoCount++;
        }while(confirmPayment != 'y' && confirmPayment != 'n');
        
        errYesNoCount = 0;
        
        if(confirmPayment == 'y'){   
            System.out.printf("\n\nTotal Payment Amount: RM %.2f",amount);

            Payment.choosePay();
                     do{
                 try{
                    System.out.print("        Chosee Bank(1 to 3) :" );
                    chooseBank = sc.nextInt();
                        switch(chooseBank){
                        case 1 :{
                           tempbankName = "Public Bank";
                        }
                        break;
                        case 2:{
                            tempbankName = "MayBank";
                        }
                        break;
                        case 3:{
                            tempbankName = "Hong Leong Bank";  
                        }
                        break;
                        default:{
                            System.out.println("Wrong Select!!! Please only select 1,2 and 3\n");
                            tempbankName= null;
                        }
                    } 
                  }catch (Exception e) {
                    System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                    sc.nextLine(); // Consume the invalid input to avoid an infinite loop
                    chooseBank = 0;
                  }
                }while(chooseBank < 1 || chooseBank > 3);

              do{    
                        System.out.print("        Enter the card number :");
                        cardNum = sc.next();
                        length = String.valueOf(cardNum).length();
                        Pattern pattern = Pattern.compile("^[0-9]+$");
                        Matcher matcher = pattern.matcher(cardNum);
                        
                        valid = matcher.matches();
                        if(valid == false){
                            System.out.println("\nCard Number must got number only !!!");
                        }
                        
                        if(length != 16){
                        System.out.println("Wrong Format of card number!!! It should be 16 number\n");
                        }
                }while (length != 16 || !valid);

               do{
                    try{
                        System.out.print("        Enter the CV Num :");
                        cvNum = sc.nextInt();
                        length = String.valueOf(cvNum).length();
                        if(length != 3){
                        System.out.println("Wrong Format of CV number!!! It should be 3 number only\n");
                        }
                    }catch (Exception e) {
                        System.out.println("      Alphabets Are Not Acceptable...Please input an Integer\n");
                        sc.nextLine();    // Consume the invalid input to avoid an infinite loop
                    }
                }while(length != 3);
                
                do{
                if(errYesNoCount > 0){
                    System.out.println("Please key in y or n only !!!");
                }
                
                System.out.print("Confirm Payment(yes=y /no=n) :");
                confirmPayment = sc.next().charAt(0);
                errYesNoCount++;
                }while(confirmPayment != 'y' && confirmPayment != 'n');
                
                if(confirmPayment == 'y'){
                    Payment payment1 = new Payment(amount,cardNum,cvNum,tempbankName,true);
                    payment.add(payment1);
                    System.out.println(payment.get(countPayment));
                    countPayment++;
                    vPayment = true;
                }
                else
                {
                    Payment payment1 = new Payment(amount,cardNum,cvNum,tempbankName,false);
                    System.out.println( "Payment Cancelled,see you next time. Thank you");
                    payment.add(payment1);
                    vPayment = false;
                }
        }
        else
        {
            System.out.println("Booking was cancelled...");
            Payment payment1 = new Payment(0.00,"",0,"",false);
            payment.add(payment1);
            vPayment = false;
        }
        return vPayment;
    }

}