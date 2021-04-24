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
import model.to.BookInfoTO;
import model.to.LoginInfoTO;


public class BookInfoDAO {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public boolean insertRecord(BookInfoTO data){
    try{
    String query = "insert into BookInfo(BookName, AuthorName,BookPrice,NoOfPages,TypeID,Publication,Qty) values(?,?,?,?,?,?,?)";
        PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
    stmt.setString(1,data.getBookName());
    stmt.setString(2,data.getAuthorName());
    stmt.setFloat(3,data.getBookPrice());
     stmt.setInt(4,data.getNoOfPages());
      stmt.setString(5,data.getTypeID());
       stmt.setString(6,data.getPublication());
       stmt.setInt(7,data.getQty());
    boolean result = stmt.executeUpdate()>0;
    stmt.close();
    return result;
    } catch (SQLException ex){
        errorMessage= ex.toString();
    return false;
   
    }
    }

public boolean updateRecord(BookInfoTO data){
try{
String query="update BookInfo set BookName=?,AuthorName=?,BookPrice=?,NoOfPages=?,TypeID=?,Publication=?,Qty=? where BookID=?";
PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
stmt.setString(1,data.getBookName());
stmt.setString(2,data.getAuthorName());
stmt.setFloat(3,data.getBookPrice());
stmt.setInt(4,data.getNoOfPages());
stmt.setString(5,data.getTypeID());
stmt.setString(6,data.getPublication());
stmt.setInt(7,data.getQty());
stmt.setInt(8,data.getBookID());
boolean result=stmt.executeUpdate()>0;
stmt.close();
return result;
}catch(SQLException ex){
    errorMessage=ex.toString();
    return false;
}
}

public boolean deleteRecord(int BookID){
try{
    String query="delete from BookInfo where BookID=?";
    PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
    stmt.setInt(1,BookID);
    boolean result=stmt.executeUpdate() >0;
    stmt.close();
    return result;
}catch(SQLException ex){
    errorMessage=ex.toString();
    return false;
}
}


public BookInfoTO getRecord(int BookID){
try{
    String query="select BookID,BookName,AuthorName,BookPrice,NoOfPages,TypeID,Publication,Qty from BookInfo where BookID=?";
    PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
    stmt.setInt(1,BookID);
    BookInfoTO result=null;
    ResultSet rs=stmt.executeQuery();
    if(rs.next()){
        result=new BookInfoTO();
        result.setBookID(rs.getInt("BookID"));
        result.setBookName(rs.getString("BookName"));
        result.setAuthorName(rs.getString("AuthorName"));
        result.setBookPrice(rs.getFloat("BookPrice"));
        result.setNoOfPages(rs.getInt("NoOfPages"));
        result.setTypeID(rs.getString("TypeID"));
       result.setPublication(rs.getString("Publication"));
       result.setQty(rs.getInt("Qty"));
        
    }
    rs.close();
    stmt.close();
    return result;
}catch(SQLException ex){
    errorMessage=ex.toString();
    ex.printStackTrace();
    return null;
}
}
 public List<BookInfoTO> getAllRecord(){
try{
    String query="SELECT BookID,BookName,AuthorName,BookPrice,NoOfPages,bi.TypeID,\n" +
"TypeName,Publication,Qty from BookInfo bi join BookType bt on bi.TypeID=bt.TypeID;" ;
    PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
    List<BookInfoTO>  result=null;
    ResultSet rs=stmt.executeQuery();
    if(rs.next()){
      result=new ArrayList<BookInfoTO>();
       do {
            BookInfoTO bif=new  BookInfoTO();
            bif.setBookID(rs.getInt("BookID"));
            bif.setBookName(rs.getString("BookName"));
             bif.setAuthorName(rs.getString("AuthorName"));
              bif.setBookPrice(rs.getFloat("BookPrice"));
               bif.setNoOfPages(rs.getInt("NoOfPages"));
                bif.setTypeID(rs.getString("TypeID"));
                 bif.setPublication(rs.getString("Publication"));
                bif.setQty(rs.getInt("Qty")); 
                 bif.setTypeName(rs.getString("TypeName")); 
               result.add(bif);
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
}
