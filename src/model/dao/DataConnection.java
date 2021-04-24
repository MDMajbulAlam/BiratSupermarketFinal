/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class DataConnection {

    public static Connection con = null;

    private DataConnection() {
    }

    public static Connection getConnection() {
        try {
            if (con==null) {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "sql");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return con;

    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
        } catch (SQLException ex) {
        }
    }
}
