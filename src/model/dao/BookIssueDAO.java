/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.to.BookIssueTO;
import model.to.LoginInfoTO;


public class BookIssueDAO {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

 public boolean insertRecord(BookIssueTO data){
    try{
    String query = "insert into BookIssue( MemberID,BookID,NoOfDays,BookDate,ReturnDate) values(?,?,?,?,?)";
        PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
    stmt.setInt(1,data.getMemberID());
    stmt.setInt(2,data.getBookID());
    stmt.setInt(3,data.getNoOfDays());
    stmt.setDate(4,data.getBookDate());
    stmt.setDate(5, data.getReturnDate());
    boolean result = stmt.executeUpdate()>0;
    stmt.close();
    return result;
    } catch (SQLException ex){
        errorMessage= ex.toString();
    return false;
   
    }
    }

public boolean updateRecord(BookIssueTO data){
try{
String query="update BookIssue set MemberID=?,BookID=?,NoOfDays=?,BookDate=?,Fine=?,FineAmount=? where IssueID=?";
PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
stmt.setInt(1,data.getMemberID());
stmt.setInt(2,data.getBookID());
stmt.setInt(3,data.getNoOfDays());
stmt.setDate(4, data.getBookDate());
stmt.setFloat(5,data.getFine());
stmt.setFloat(6,data.getFineAmount());
stmt.setDate(7, data.getReturnDate());
stmt.setInt(8,data.getIssueID());
boolean result=stmt.executeUpdate()>0;
stmt.close();
return result;
}catch(SQLException ex){
    errorMessage=ex.toString();
    return false;
}
}

public boolean deleteRecord(int IssueID){
try{
    String query="delete from BookIssue where IssueID=?";
    PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
    stmt.setInt(1,IssueID);
    boolean result=stmt.executeUpdate() >0;
    stmt.close();
    return result;
}catch(SQLException ex){
    errorMessage=ex.toString();
    return false;
}
}


public BookIssueTO getRecord(int IssueID){
try{
    String query="select IssueID,MemberID,BookID,NoOfDays,BookDate,ReturnDate from BookIssue where IssueID=?";
    PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
    stmt.setInt(1,IssueID);
    BookIssueTO result=null;
    ResultSet rs=stmt.executeQuery();
    if(rs.next()){
        result=new BookIssueTO();
        result.setIssueID(rs.getInt("IssueID"));
        result.setMemberID(rs.getInt("MemberID"));
        result.setBookID(rs.getInt("BookID"));
        result.setNoOfDays(rs.getInt("NoOfDays"));
        result.setBookDate(rs.getDate("BookDate"));
        result.setFine(rs.getFloat("Fine"));
        result.setFineAmount(rs.getFloat("FineAmount"));
        result.setReturnDate(rs.getDate("ReturnDate"));
       
    }
    rs.close();
    stmt.close();
    return result;
}catch(SQLException ex){
    errorMessage=ex.toString();
    return null;
}

}
public List<BookIssueTO> getAllRecord(){
try{
    String query="select IssueID,MemberID,BookID,NoOfDays,BookDate from BookIssue" ;
    PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
    List<BookIssueTO>  result=null;
    ResultSet rs=stmt.executeQuery();
    if(rs.next()){
      result=new ArrayList<BookIssueTO>();
       do {
            BookIssueTO bi=new BookIssueTO();
                bi.setIssueID(rs.getInt("IssueID"));
                bi.setMemberID(rs.getInt("MemberID"));
                bi.setBookID(rs.getInt("BookID"));
                bi.setNoOfDays(rs.getInt("NoOfDays"));
                bi.setBookDate(rs.getDate("BookDate"));
            
            
          
               result.add(bi);
        }while(rs.next());
        
    }
    rs.close();
    stmt.close();
    return result;
}catch(SQLException ex){
    errorMessage=ex.toString();
    return null;
}
}
public boolean ReturnBookRecord(BookIssueTO data){
try{
String query="update BookIssue set MemberID=?,BookID=?,NoOfDays=?,BookDate=?,Fine=?,FineAmount=? where IssueID=?";
PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
stmt.setInt(1,data.getMemberID());
stmt.setInt(2,data.getBookID());
stmt.setInt(3,data.getNoOfDays());
stmt.setDate(4, data.getBookDate());
stmt.setFloat(5,data.getFine());
stmt.setFloat(6,data.getFineAmount());
stmt.setDate(7, data.getReturnDate());
stmt.setInt(8,data.getIssueID());
boolean result=stmt.executeUpdate()>0;
stmt.close();
return result;
}catch(SQLException ex){
    errorMessage=ex.toString();
    return false;
}
}
}


