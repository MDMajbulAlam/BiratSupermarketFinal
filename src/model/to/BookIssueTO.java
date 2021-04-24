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
public class BookIssueTO {
    private int IssueID,MemberID,BookID,NoOfDays;
    private java.sql.Date BookDate, ReturnDate;

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date ReturnDate) {
        this.ReturnDate = ReturnDate;
    }
    private float Fine,FineAmount;

    public int getIssueID() {
        return IssueID;
    }

    public void setIssueID(int IssueID) {
        this.IssueID = IssueID;
    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int MemberID) {
        this.MemberID = MemberID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public int getNoOfDays() {
        return NoOfDays;
    }

    public void setNoOfDays(int NoOfDays) {
        this.NoOfDays = NoOfDays;
    }

    public Date getBookDate() {
        return BookDate;
    }

    public void setBookDate(Date BookDate) {
        this.BookDate = BookDate;
    }

    public float getFine() {
        return Fine;
    }

    public void setFine(float Fine) {
        this.Fine = Fine;
    }

    public float getFineAmount() {
        return FineAmount;
    }

    public void setFineAmount(float FineAmount) {
        this.FineAmount = FineAmount;
    }
    
 
  }          
    
    



