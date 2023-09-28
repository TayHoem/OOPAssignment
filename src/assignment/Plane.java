/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author nicho
 */
public class Plane {
     private String planeNo;
    private int numOfSeat;

    public Plane() {
    }

    public Plane(String planeNo, int numOfSeat) {
        this.planeNo = planeNo;
        this.numOfSeat = numOfSeat;
    }

    public String getPlaneNo() {
        return planeNo;
    }

    public int getNumOfSeat() {
        return numOfSeat; 
    }

    public void setPlaneNo(String planeNo) {
        this.planeNo = planeNo;
    }

    public void setNumOfSeat(int numOfSeat) {
        this.numOfSeat = numOfSeat;
    }

   public String toString(){
       return "\n               Plane No: "+ planeNo
               +"\n               Number of Seat: "+ numOfSeat
               +"\n";
   }
}