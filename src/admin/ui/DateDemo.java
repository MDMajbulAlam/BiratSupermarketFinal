/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;
import java.util.*;
/**
 *
 * @author DELL
 */
public class DateDemo {
    public static void main(String[] args){
        Date date=new Date(95,7,21);
        Date date2=new Date(96,6,22);
        int comparison=date.compareTo(date2);
        int comparison2=date2.compareTo(date);
        System.out.println("Comparison Result:"+comparison);
        System.out.println("Comparison2 Result:"+comparison2);
        if(date.getTime() > date2.getTime()){
            
        }
    }
            
    
}


