/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class MemberInfoTO {
    private int MemberID;
    private String MemberName,Address,ContactNo;
    private float Fee;
    private java.sql.Date DOB,StartDate,EndDate;

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int MemberID) {
        this.MemberID = MemberID;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public float getFee() {
        return Fee;
    }

    public void setFee(float Fee) {
        this.Fee = Fee;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public void setMemberID(String MemberID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String toString(){
       return MemberName+"["+ MemberID+" ]";
    }
    
}
