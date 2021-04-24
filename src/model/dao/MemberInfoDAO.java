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
import model.to.MemberInfoTO;

/**
 *
 * @author DELL
 */
public class MemberInfoDAO {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean insertRecord(MemberInfoTO data) {
        try {
            String query = "insert into MemberInfo(MemberID,MemberName,Address,DOB,ContactNo,Fee,StartDate,EndDate) values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, data.getMemberID());
            stmt.setString(2, data.getMemberName());
            stmt.setString(3, data.getAddress());
            stmt.setDate(4, data.getDOB());
            stmt.setString(5, data.getContactNo());
            stmt.setFloat(6, data.getFee());
            stmt.setDate(7, data.getStartDate());
            stmt.setDate(8, data.getEndDate());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;

        }
    }

    public boolean updateRecord(MemberInfoTO data) {
        try {
            String query = "update MemberInfo set MemberName=?,Address=?,DOB=?,ContactNo=?,Fee=?,StartDate=? where MemberID =?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getMemberName());
            stmt.setString(2, data.getAddress());
            stmt.setDate(3, data.getDOB());
            stmt.setString(4, data.getContactNo());
            stmt.setFloat(5, data.getFee());
            stmt.setDate(6, data.getStartDate());
            stmt.setInt(7, data.getMemberID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(int MemberID) {
        try {
            String query = "delete from MemberInfo where MemberID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, MemberID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return false;
        }
    }

    public MemberInfoTO setRecord(int MemberID) {
        try {
            String query = "select MemberName,Address,DOB,ContactNo,Fee,StartDate,EndDate from MemberInfo where MemberID=?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, MemberID);
            MemberInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new MemberInfoTO();
                result.setMemberID(rs.getInt("MemberID"));
                result.setMemberName(rs.getString("MemberName"));
                result.setAddress(rs.getString("Address"));
                result.setDOB(rs.getDate("DOB"));
                result.setContactNo(rs.getString("ContactNo"));
                result.setFee(rs.getFloat("Fee"));
                result.setStartDate(rs.getDate("StartDate"));
                result.setEndDate(rs.getDate("EndDate"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (SQLException ex) {
            errorMessage = ex.toString();
            return null;
        }
    }

    public List<MemberInfoTO> getAllRecord(String MName) {
        MName = MName + "%";
        try {
            String query = "select MemberID,MemberName,Address,DOB,ContactNo,Fee,StartDate,EndDate from MemberInfo where MemberName like ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, MName);
            List<MemberInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<MemberInfoTO>();
                do {
                    MemberInfoTO mit = new MemberInfoTO();
                    mit.setMemberID(rs.getInt("MemberID"));
                    mit.setMemberName(rs.getString("MemberName"));
                    mit.setAddress(rs.getString("Address"));
                    mit.setDOB(rs.getDate("DOB"));
                    mit.setContactNo(rs.getString("ContactNo"));
                    mit.setFee(rs.getFloat("Fee"));
                    mit.setStartDate(rs.getDate("StartDate"));
                    mit.setEndDate(rs.getDate("EndDate"));
                    result.add(mit);
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

    public List<MemberInfoTO> getAllRecord() {

        try {
            String query = "select MemberID,MemberName,Address,DOB,ContactNo,Fee,StartDate,EndDate from MemberInfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);

            List<MemberInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<MemberInfoTO>();
                do {
                    MemberInfoTO mit = new MemberInfoTO();
                    mit.setMemberID(rs.getInt("MemberID"));
                    mit.setMemberName(rs.getString("MemberName"));
                    mit.setAddress(rs.getString("Address"));
                    mit.setDOB(rs.getDate("DOB"));
                    mit.setContactNo(rs.getString("ContactNo"));
                    mit.setFee(rs.getFloat("Fee"));
                    mit.setStartDate(rs.getDate("StartDate"));
                    mit.setEndDate(rs.getDate("EndDate"));
                    result.add(mit);
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
