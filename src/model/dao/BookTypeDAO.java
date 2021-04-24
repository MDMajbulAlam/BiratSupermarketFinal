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
import model.to.BookTypeTO;
import model.to.LoginInfoTO;

/**
 *
 * @author DELL
 */
public class BookTypeDAO {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(BookTypeTO data) {
        try {
            String query = "insert into BookType(TypeID,TypeName) values(?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getTypeID());
            stmt.setString(2, data.getTypeName());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;

        }
    }

    public boolean updateRecord(BookTypeTO data) {
        try {
            String query = "update BookType set TypeName=? where TypeID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getTypeName());
            stmt.setString(2, data.getTypeID());

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String TypeID) {
        try {
            String query = "delete from BookType where TypeID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, TypeID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;
        }
    }

    public BookTypeTO setRecord(String TypeID) {
        try {
            String query = "select TypeID,TypeName from BookType where TypeID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, TypeID);
            BookTypeTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new BookTypeTO();
                result.setTypeID(rs.getString("TypeID"));
                result.setTypeName(rs.getString("TypeName"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return null;
        }
    }

    public List<BookTypeTO> getAllRecord() {
        try {
            String query = "select TypeID ,TypeName from BookType";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<BookTypeTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<BookTypeTO>();
                do {
                    BookTypeTO bit = new BookTypeTO();
                    bit.setTypeID(rs.getString("TypeID"));
                    bit.setTypeName(rs.getString("TypeName"));
                    result.add(bit);
                } while (rs.next());

            }
            rs.close();
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            ex.printStackTrace();
            return null;
        }
    }
}
