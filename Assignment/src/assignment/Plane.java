/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author nicho
 */
import java.util.ArrayList;
public class Plane {
     private String planeNo;
    private int numOfSeat;

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
       return "Plane No= "+planeNo+
               "\nNumber of Seat= "+ numOfSeat
               +"\n";
   }
}