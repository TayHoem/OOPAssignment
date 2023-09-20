/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Acer
 */
import java.util.Scanner;
public class main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Payment[] payment = new Payment[100]; 
        String cardNum;
        char confirmPayment;
        int cvNum;
        int chooseBank;
        String tempbankName;
        int length;
        int correctFormat = 0;
        int countPayment = 0;
        int errYesNoCount = 0;
        
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
            
            payment[countPayment]= new Payment(1000.00);
            System.out.printf("\n\nPayment : %d", payment[countPayment].getPaymentID());
            System.out.printf("\n\nTotal Payment Amount: RM %.2f",payment[countPayment].getAmount());

            Payment.choosePay();
                do{
                    System.out.print("Chosee Bank(1 to 3) :" );
                    chooseBank = sc.nextInt();
                    switch(chooseBank){
                    case 1 :{
                        tempbankName = "Public Bank";
                        payment[countPayment].setBankName(tempbankName);
                    }
                        break;
                    case 2:{
                        tempbankName = "MayBank";
                        payment[countPayment].setBankName(tempbankName);
                    }
                        break;
                    case 3:{
                        tempbankName = "Hong Leong Bank";
                        payment[countPayment].setBankName(tempbankName);
                    }
                        break;
                    default:
                        System.out.println("Wrong Select!!! Please only select 1,2 and 3\n");
                   } 
                }while(chooseBank < 0 || chooseBank > 3);

                do{
                    if(correctFormat > 0){
                    System.out.println("\nWrong Format of card number!!! It should be 16 number\n");
                    }
                    System.out.print("Enter the card number :");
                    cardNum = sc.next();
                    length = String.valueOf(cardNum).length();
                    payment[countPayment].setCardNo(cardNum);
                    correctFormat++;
                }while (length != 16);

                correctFormat = 0;
                do{
                    if(correctFormat > 0){
                    System.out.println("\nWrong Format of CV number!!! It should be 3 number only\n");
                    }
                    System.out.print("Enter the CV Num :");
                    cvNum = sc.nextInt();
                    length = String.valueOf(cvNum).length();
                    payment[countPayment].setCvNo(cvNum);
                    correctFormat++;
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
                    payment[countPayment].setPaymentSatus(true);
                    payment[countPayment].addPaymentId();
                    System.out.println(payment[countPayment]);
                    countPayment++;
                }
                else
                {
                    payment[countPayment].setPaymentSatus(false);
                    System.out.println( "Payment Cancelled,see you next time. Thank you");
                    payment[countPayment].setAmount(0.00);
                }
                
                
        }
        else
        {
            System.out.println("Booking was cancelled...");
            payment[countPayment].setPaymentSatus(false);
        }
    }
    
}
