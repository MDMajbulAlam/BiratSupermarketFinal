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
import model.to.LoginInfoTO;

/**
 *
 * @author DELL
 */
public class LoginInfoDAO {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
    public LoginInfoTO checklogin(String UserName){
        try{
            String query="Select UserName,Password,RoleName,LastLogin from LoginInfo where UserName=? ";
             PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
             stmt.setString(1, UserName);
             LoginInfoTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()){
              result=new LoginInfoTO();
              result.setUserName(rs.getString("UserName"));
              result.setPassword(rs.getString("Password"));
              result.setRoleName(rs.getString("Rolename"));
              result.setLastLogin(rs.getTimestamp("LastLogin"));
             }
             rs.close();
             stmt.close();
             return result;
        } catch(SQLException ex){
            errorMessage=ex.toString();
            return null;
        }
    }    
  public boolean updateLastlogin(String UserName){
        try{
            String query=" update LoginInfo set LastLogin=sysdate() where UserName=?" ;
             PreparedStatement stmt=DataConnection.getConnection().prepareStatement(query);
             stmt.setString(1, UserName);
             LoginInfoTO result=null;
             boolean reslt =stmt.executeUpdate()>0;
             stmt.close();
             return reslt;
        } catch(SQLException ex){
            errorMessage=ex.toString();
            return false;
        }
    }   
    public boolean insertRecord(LoginInfoTO data) {
        try {
            String query = "insert into LoginInfo( UserName,Password,RoleName,LastLogin) values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getUserName());
            stmt.setString(2, data.getPassword());
            stmt.setString(3, data.getRoleName());
            stmt.setTimestamp(4, data.getLastLogin());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;

        }
    }
 
    public boolean updateRecord(LoginInfoTO data) {
        try {
            String query = "update LoginInfo set Password=?,RoleName=?,LastLogin=? where UserName=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getPassword());
            stmt.setString(2, data.getRoleName());
            stmt.setTimestamp(3, data.getLastLogin());
            stmt.setString(4, data.getUserName());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String UserName) {
        try {
            String query = "delete from LoginInfo where UserName=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, UserName);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;
        }
    }

    public LoginInfoTO getRecord(String UserName) {
        try {
            String query = "select UserName,Password,RoleName,LastLogin from LoginInfo where UserName=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, UserName);
            LoginInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new LoginInfoTO();
                result.setUserName(rs.getString("UserName"));
                result.setPassword(rs.getNString("Password"));
                result.setRoleName(rs.getString("RoleName"));
                result.setLastLogin(rs.getTimestamp("LastLogin"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return null;
        }
    }

    public List<LoginInfoTO> getAllRecord() {
        try {
            String query = "select UserName,Password,RoleName,LastLogin from LoginInfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<LoginInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<LoginInfoTO>();
                do {
                    LoginInfoTO li = new LoginInfoTO();
                    li.setUserName(rs.getString("UserName"));
                    li.setPassword(rs.getString("Password"));
                    li.setRoleName(rs.getString("RoleName"));
                    li.setLastLogin(rs.getTimestamp("LastLogin"));
                    result.add(li);
                } while (rs.next());

            }
            rs.close();
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return null;
        }
    }
}
