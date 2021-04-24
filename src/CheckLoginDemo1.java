
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class CheckLoginDemo1 {
  public static void main(String[] args){
        Connection con=null;
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("ENTER UserName:");
            String uname=sc.nextLine();
            System.out.println("ENTER Password:");
            String upass=sc.nextLine();
            Class.forName("com.mysql.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","sql");
            String query="Select * From LoginInfo where UserName='"+ uname +"'and Password='"+upass+"'";
            System.out.println(query);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                System.out.println("Valid User");
            }else{
                System.out.println("Invalid User");
            }
            rs.close();
            
           stmt.close();
           
            con.close();
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        }catch(SQLException ex){
             System.out.println(ex);
             //ex.printStackTrace();
        }finally{
            try{
                if(con!=null){
                  con.close();
                }
        }catch(SQLException ex){
            }
        
} 
}  
}

