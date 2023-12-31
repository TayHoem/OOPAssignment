/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass;

/**
 *
 * @author nicho
 */
public class Staff extends Person {

    private String staffId;
    private String position;
    private int stfPass;

    public Staff(String name, String phoneNo, char gender, String email, String icNo) {
        super(name, phoneNo, gender, email, icNo);
    }

    
    
    public Staff(String staffId, String position, int stfpass, String name, String phoneNo, char gender, String email, String icNo) {
        super(name, phoneNo, gender, email, icNo);
        this.staffId = staffId;
        this.position = position;
        this.stfPass = stfpass;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getPosition() {
        return position;
    }

    public int getStfpass() {
        return stfPass;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStfpass(int stfpass) {
        this.stfPass = stfpass;
    }

    public boolean login(String staffID, int staffPassword) {
        if (staffID.equals(this.staffId) && staffPassword == this.stfPass) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "               Staff ID: " + staffId
                + "\n               Staff Position: " + position
                + "\n               Staff name: " + super.getName()
                + "\n               Phone No: " + super.getPhoneNo()
                + "\n               Gender: " + super.getGender()
                + "\n               Email: " + super.getEmail()
                + "\n               Ic No: " + super.getIcNo();
    }
}
