/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

import java.sql.Timestamp;


    
/**
 *
 * @author DELL
 */
public class LoginInfoTO {
  private String UserName,Password,RoleName;
  private java.sql.Timestamp  LastLogin;

    public String getUserName() {   
        return UserName;
    }

    public void setUserName(String UserName) {    
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public Timestamp getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Timestamp LastLogin) {
        this.LastLogin = LastLogin;
    }

   
    }
    
    

